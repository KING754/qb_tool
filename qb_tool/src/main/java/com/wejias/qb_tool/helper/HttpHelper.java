package com.wejias.qb_tool.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/*
*
*暂时不用???
*/
public class HttpHelper {
//	private static Logger logger = Logger.getLogger(HttpHelper.class);


	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@SuppressWarnings("deprecation")
	public static String doPost(String url, String userName, String parssWord)
			throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.setHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
		post.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36");
		post.setHeader("sec-ch-ua", "\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Google Chrome\";v=\"96\"");
		 
		StringEntity entiy = new StringEntity("username=" + userName + "&password=" + parssWord, "UTF-8");
		post.setEntity(entiy);
		CloseableHttpResponse response = client.execute(post);
		StringBuffer lineBuffer = new StringBuffer();
		if (response != null) {
			HttpEntity entity = response.getEntity();
			BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), "UTF-8"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				lineBuffer.append(line);
				System.out.println(line);
			}
			if (entity != null) {
				entity.consumeContent();
			}
		}
		return lineBuffer.toString();
	}

//    public static void addProxyRequestLog(String uuid,String url,String queryStr,String reqType){
//    	MyLogger logger = new MyLogger(LogConfigHelper.getProxyHttpLog(), uuid+","+reqType+":"+url+"?"+queryStr);
//    	MyLoggerManager.addLogger(logger);
//    }

    
//    public static void addProxyResponseLog(String uuid,String url,String reIfno,String respType){
//    	MyLogger logger = new MyLogger(LogConfigHelper.getProxyHttpLog(), uuid+","+respType+","+url+":"+reIfno);
//    	MyLoggerManager.addLogger(logger);
//    }

    
//    @SuppressWarnings("deprecation")
//	public static String doHttpsPost(String url, Map<String, String> params,
//			String charset, boolean pretty) {
//		PostMethod method = null;
//		StringBuffer response = new StringBuffer();
//		try {
//			//增加下面两行代码  
//	        Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);  
//	        Protocol.registerProtocol("https", myhttps); 
//	        
//			HttpClient client = new HttpClient();
//			//指的是连接一个url的连接等待时间。
//			client.getHttpConnectionManager().getParams().setConnectionTimeout(SystemConfigHelper.getConnectionTimeOut());
//			//连接上一个url，获取response的返回等待时间
//			client.getHttpConnectionManager().getParams().setSoTimeout(SystemConfigHelper.getResponseTimeOut());
//			
//			method = new PostMethod(url);
//			// 设置Http Post数据
//			if (params != null) {
//				NameValuePair[] values = new NameValuePair[params.size()];
//				List<NameValuePair> postValues = new ArrayList<NameValuePair>();
//				for (Map.Entry<String, String> entry : params.entrySet()) {
//					try {
//						postValues.add(new NameValuePair(entry.getKey(), URIUtil.encodeQuery(entry.getValue(), charset)));
//					} catch (URIException e) {
//						e.printStackTrace();
//						postValues.add(new NameValuePair(entry.getKey(), entry.getValue()));
//					}
//				}
//				values = postValues.toArray(values);
//				method.setRequestBody(values);
//			}
//			String uuid = DateHelper.getUUID();
//			HttpHelper.addProxyRequestLog(uuid, method.getURI().toString(), "", "POST");
//			
//			client.executeMethod(method);
//			if (method.getStatusCode() == HttpStatus.SC_OK) {
//				BufferedReader reader = new BufferedReader(
//						new InputStreamReader(method.getResponseBodyAsStream(),charset));
//				String line;
//				while ((line = reader.readLine()) != null) {
//					if (pretty){
//						response.append(line).append(System.getProperty("line.separator"));
//					}else{
//						response.append(line);
//					}
//				}
//				reader.close();
//			}
//			HttpHelper.addProxyResponseLog(uuid, url, response.toString(), "POST");
//		} catch (IOException e) {
//			e.printStackTrace();
//			logger.error("执行HTTP Post请求" + url + "时，发生异常！", e);
//		} finally {
//			if(method != null){
//				method.releaseConnection();
//			}
//		}
//		return response.toString();
//	}
    
    
    public static void main(String[] args) {
//    	String url = "https://oauth.api.189.cn/emp/oauth2/access_token?grant_type=client_credentials&app_id=455383560000030427&app_secret=d4b7bbe5ed2186d146942c9e133a3612";
////		String str = HttpHelper.doGet("http://www.baidu.com", null,"gb2312",false);
//    	String str = HttpHelper.doHttpsPost(url, null, SystemConfigHelper.UTF_8, false);
//		MyLoggerManager.printInfo(str);
	}

}