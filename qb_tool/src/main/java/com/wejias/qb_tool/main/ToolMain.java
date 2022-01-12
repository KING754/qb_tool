package com.wejias.qb_tool.main;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.wejias.qb_tool.analyse.ParseLogic;
import com.wejias.qb_tool.constant.SiteInfo;
import com.wejias.qb_tool.helper.PropertyUtil;

public class ToolMain {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        ToolMain.initSiteInfo();
        
        ParseLogic qbTool = new ParseLogic();
        String mainData = qbTool.loginAndGetMainData();
		
        qbTool.dealData(mainData);
    }
    
    
    public static void initSiteInfo() {
        PropertyUtil.init();
        SiteInfo.initSiteMap();
    }

}
