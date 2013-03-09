package org.zhaodj.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.protocol.Protocol;

public class HttpClientUtil {

	//链接超时  
	private static final int CON_TIMEOUT=2000;
	private static final int TIMEOUT = 10000;
    private static HttpClient httpClient;
    
    public static HttpClient getHttpClient(){
		if(httpClient==null){
			HttpConnectionManager connectionManager=new MultiThreadedHttpConnectionManager();
			HttpConnectionManagerParams params=connectionManager.getParams();
			params.setConnectionTimeout(CON_TIMEOUT);
			params.setSoTimeout(TIMEOUT);
			httpClient=new HttpClient(connectionManager);
			//Protocol myhttps = new Protocol("https", new MySSLSocketFactory(), 443);
			//Protocol.registerProtocol("https", myhttps);
		}
		return httpClient;
	}
}
