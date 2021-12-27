package com.wejias.qb_tool.main;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.wejias.qb_tool.analyse.ParseHtml;

public class ToolMain {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		ParseHtml qbTool = new ParseHtml();
		String mainData = qbTool.loginAndGetMainData();
		
		qbTool.dealData(mainData);
	}
	
}
