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
import com.wejias.qb_tool.helper.HtmlUnitHelper;
import com.wejias.qb_tool.helper.JsonHelper;
import com.wejias.qb_tool.helper.PropertyUtil;
import com.wejias.qb_tool.vo.MainData;
import com.wejias.qb_tool.vo.TorrentDto;
import com.wejias.qb_tool.vo.TorrentVO;

public class ParseHtml {
	private static Logger logger = LoggerFactory.getLogger(ParseHtml.class);
	
	public String loginAndGetMainData() throws ClientProtocolException, IOException {
		String url = PropertyUtil.getProperty(Constant.QB_URL_KEY);
		String username = PropertyUtil.getProperty(Constant.QB_USERNAME);
		String password = PropertyUtil.getProperty(Constant.QB_PASSWOPRD);
		
		return new HtmlUnitHelper().loginQBWeb(url, username, password);
	}
	
	public void dealData(String respStr) {
		MainData mainData = JsonHelper.toJSONObject(respStr, MainData.class);
		if(mainData != null) {
			if(mainData.getTorrents() != null) {
				List<Map<String, TorrentDto>> torrentList = mainData.getTorrents();
				for (Map<String, TorrentDto> tottentMap : torrentList) {
					for (Entry<String, TorrentDto> entry : tottentMap.entrySet()) {
						this.dealTorrent(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		
		System.out.println("文件数："+TORRENT_MAP.size());
		int count = 0;
		for (Entry<String, List<TorrentVO>> entry : TORRENT_MAP.entrySet()) {
			count += entry.getValue().size();
			for (TorrentVO torrent : entry.getValue()) {
				System.out.println(torrent);
				break;
			}
			break;
		}
		System.out.println("做种数:"+count);
	}
	
	public static Map<String,List<TorrentVO>> TORRENT_MAP = new HashMap<String,List<TorrentVO>>();
	private void dealTorrent(String torrentId,TorrentDto torrent) {
		if(torrent == null) {
			logger.warn("torrent == null");
			return;
		}
		String path = torrent.getContent_path();
		//			String pathGBK = new String(path.getBytes("ISO-8859-1"),"UTF-8");
		if(TORRENT_MAP.containsKey(path)) {
			List<TorrentVO> torrentList = TORRENT_MAP.get(path);
			torrentList.add(new TorrentVO(torrent));
		}else{
			List<TorrentVO> torrentList = new ArrayList<TorrentVO>();
			torrentList.add(new TorrentVO(torrent));
			TORRENT_MAP.put(path, torrentList);
		}
//			System.out.println(pathGBK);
	}
}
