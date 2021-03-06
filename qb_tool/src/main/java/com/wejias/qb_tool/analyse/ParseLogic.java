package com.wejias.qb_tool.analyse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wejias.qb_tool.constant.Constant;
import com.wejias.qb_tool.constant.TrackerInfo;
import com.wejias.qb_tool.helper.ExeclHelpler;
import com.wejias.qb_tool.helper.HtmlUnitHelper;
import com.wejias.qb_tool.helper.JsonHelper;
import com.wejias.qb_tool.helper.PropertyUtil;
import com.wejias.qb_tool.vo.MainData;
import com.wejias.qb_tool.vo.TorrentDto;
import com.wejias.qb_tool.vo.TorrentVO;

public class ParseLogic {
    private static Logger logger = LoggerFactory.getLogger(ParseLogic.class);
    public static Map<String,List<TorrentVO>> TORRENT_MAP = new HashMap<String,List<TorrentVO>>();
    
    public String loginAndGetMainData() throws ClientProtocolException, IOException {
        String url = PropertyUtil.getPropertyStrValue(Constant.SETTING_PROPERTIES,Constant.QB_URL_KEY);
        String username = PropertyUtil.getPropertyStrValue(Constant.SETTING_PROPERTIES,Constant.QB_USERNAME);
        String password = PropertyUtil.getPropertyStrValue(Constant.SETTING_PROPERTIES,Constant.QB_PASSWOPRD);
        
        return new HtmlUnitHelper().loginQBWeb(url, username, password);
    }
    
    public void dealData(String respStr) {
        MainData mainData = JsonHelper.toJSONObject(respStr, MainData.class);
        if(mainData != null) {
            if(mainData.getTrackers() != null) {
                TrackerInfo.initTrackerMap(mainData.getTrackers());
            }
            
            if(mainData.getTorrents() != null) {
                List<Map<String, TorrentDto>> torrentList = mainData.getTorrents();
                for (Map<String, TorrentDto> tottentMap : torrentList) {
                    for (Entry<String, TorrentDto> entry : tottentMap.entrySet()) {
                        this.dealTorrent(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
        
        System.out.println("????????????"+TORRENT_MAP.size());
        int count = 0;
        for (Entry<String, List<TorrentVO>> entry : TORRENT_MAP.entrySet()) {
            count += entry.getValue().size();
        }
        System.out.println("?????????:"+count);
        List<TorrentVO> torrentVoList = this.dealSiteUpload();
        this.writeToExecl(torrentVoList);
        System.out.println("????????????!!!");
    }
    
    private void dealTorrent(String torrentId,TorrentDto torrent) {
        if(torrent == null) {
            logger.warn("torrent == null");
            return;
        }
        String name = torrent.getName();
        if(TORRENT_MAP.containsKey(name)) {
            List<TorrentVO> torrentList = TORRENT_MAP.get(name);
            torrentList.add(new TorrentVO(torrentId,torrent));
        }else{
            List<TorrentVO> torrentList = new ArrayList<TorrentVO>();
            torrentList.add(new TorrentVO(torrentId,torrent));
            TORRENT_MAP.put(name, torrentList);
        }
    }
    
    private List<TorrentVO> dealSiteUpload() {
        List<TorrentVO> needRecordVoList = new ArrayList<TorrentVO>();
        for (Entry<String, List<TorrentVO>> entry : TORRENT_MAP.entrySet()) {
            List<TorrentVO> val = entry.getValue();
            TorrentVO srcTorrentVO = null;
            TorrentVO maxDownload = null;
            for (TorrentVO torrentVO : val) {
                if(torrentVO.downloadByteSize > 0 && torrentVO.downAll) {
                    srcTorrentVO = torrentVO;
                    break;
                }
                if(maxDownload == null || torrentVO.downloadByteSize > maxDownload.downloadByteSize) {
                    maxDownload = torrentVO;
                }
            }
            if(srcTorrentVO == null && maxDownload != null) {
                srcTorrentVO = maxDownload;
            }
            if(srcTorrentVO == null) {
                throw new NullPointerException(entry.getKey()+" srcTorrentVO is null");
            }
            srcTorrentVO.siteUploadSize = new HashMap<String, Long>();
            srcTorrentVO.siteUploadSize.put(srcTorrentVO.site, srcTorrentVO.downloadByteSize);
            for (TorrentVO torrentVO : val) {
                if(!srcTorrentVO.downAll && torrentVO.downAll) {
                    srcTorrentVO.downAll = true;
                }
                if(torrentVO.site.equals(srcTorrentVO.site)) {
                    continue;
                }
                srcTorrentVO.downloadByteSize += torrentVO.downloadByteSize;
                srcTorrentVO.uploadByteSize += torrentVO.uploadByteSize;
                srcTorrentVO.siteUploadSize.put(torrentVO.site, torrentVO.uploadByteSize);
                srcTorrentVO.activeSecond += torrentVO.activeSecond;
            }
            srcTorrentVO.calStrField();
            needRecordVoList.add(srcTorrentVO);
        }
        return needRecordVoList;
    }
    
    public void writeToExecl(List<TorrentVO> torrentList) {
        String filePath = PropertyUtil.getPropertyStrValue(Constant.SETTING_PROPERTIES,Constant.EXECL_SAVE_PATH);
        filePath +="record.xlsx";
        ExeclHelpler.writeExcel(filePath, torrentList);
    }
}
