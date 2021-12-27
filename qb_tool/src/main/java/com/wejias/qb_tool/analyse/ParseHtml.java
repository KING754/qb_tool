package com.wejias.qb_tool.analyse;

import java.io.IOException;
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
import com.wejias.qb_tool.vo.Torrent;

public class ParseHtml {
	private static Logger logger = LoggerFactory.getLogger(ParseHtml.class);
	
	public String loginAndGetMainData() throws ClientProtocolException, IOException {
		String url = PropertyUtil.getProperty(Constant.QB_URL_KEY);
		String username = PropertyUtil.getProperty(Constant.QB_USERNAME);
		String password = PropertyUtil.getProperty(Constant.QB_PASSWOPRD);
		
//		String loginResp = HttpHelper.doPost(url, username, password);
		return new HtmlUnitHelper().loginQBWeb(url, username, password);
	}
	
	public void dealData(String respStr) {
		int count = 0;
		MainData mainData = JsonHelper.toJSONObject(respStr, MainData.class);
		if(mainData != null) {
			if(mainData.getTorrents() != null) {
				List<Map<String, Torrent>> torrentList = mainData.getTorrents();
				for (Map<String, Torrent> tottentMap : torrentList) {
					count = tottentMap.size();
					for (Entry<String, Torrent> entry : tottentMap.entrySet()) {
						this.dealTorrent(entry.getKey(), entry.getValue());
					}
				}
			}
		}
		System.out.println("总数:"+count);
	}
	
	private void dealTorrent(String torrentId,Torrent torrent) {
		if(torrent == null) {
			logger.warn("torrent == null");
			return;
		}
//		System.out.println("rid:"+torrentId);
//		System.out.println("Torrent:"+torrent);
//		System.out.println("--------------------------");
		
		if(torrent.getContent_path().indexOf("Benedetta.2021.BluRay.1080p.x264") >= 0) {
			System.out.println(torrent.getContent_path());
		}
	}
}
