package com.wejias.qb_tool.main;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.wejias.qb_tool.analyse.ParseHtml;
import com.wejias.qb_tool.constant.SiteInfo;
import com.wejias.qb_tool.helper.PropertyUtil;

public class ToolMain {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        ToolMain.initSiteInfo();
        
        ParseHtml qbTool = new ParseHtml();
        String mainData = qbTool.loginAndGetMainData();
		
        qbTool.dealData(mainData);
    }
    
    
    public static void initSiteInfo() {
        PropertyUtil.init();
        SiteInfo.initSiteMap();
        //TODO LL format site info to map.for easy!!!
    }

}
