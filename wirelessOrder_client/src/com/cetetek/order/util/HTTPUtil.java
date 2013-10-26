/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : HTTPUtil.java 
 * Date : 2011-09-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/**
 * ������ʰ�����
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:51:13
 */
public class HTTPUtil {
	//���ȴ�ʱ��
	private static final int TIMEOUT = 6*1000; 
	//�ַ�����
	public static final String HTTP_UTF8 = "UTF-8";
	/**
	 * ��get�������HTTP����
	 * @param path 
	 * @return
	 * @throws Exception
	 */
	public static byte[] downloadGET (String path) throws Exception{
		URL url = new URL(path);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setReadTimeout(TIMEOUT);
		connection.setUseCaches(false);
		if(connection.getResponseCode() != 200){
			throw new RuntimeException("ResponseCode!= 200");
		}
		BufferedInputStream inputStream = new BufferedInputStream(connection.getInputStream());
		byte[] data = readInputStream(inputStream);
		connection.disconnect();
		return data;
	}
	/**
	 * ���������ж�ȡ�ֽ�����
	 * @param inputStream
	 * @return
	 * @throws Exception
	 */
	private static byte[] readInputStream(InputStream inputStream) throws Exception{
		byte[] buffer = new byte[1024];
		int len = -1;
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		while((len = inputStream.read(buffer))!=-1){
			arrayOutputStream.write(buffer, 0, len);
		}
		arrayOutputStream.close();
		inputStream.close();
		return arrayOutputStream.toByteArray();
	}
	
	/**
	 * post ����
	 * @param path ����·��
	 * @param params �����б�
	 * @param encoding �����ʽ
	 * @throws Exception
	 */
	public static byte[] downloadPost(String path,Map<String, String> params,String encoding) throws Exception{
		encoding = (encoding!=null && "".equals(encoding)) ? encoding : HTTP_UTF8;
		StringBuilder sb = new StringBuilder();
		if(params!=null){
			for(Map.Entry<String, String> item : params.entrySet()){
				sb.append(item.getKey()+"="+URLEncoder.encode(item.getValue(), encoding)).append("&");
			}
			sb = sb.deleteCharAt(sb.length()-1);
		}
		byte[] d = sb.toString().getBytes();
		URL url = new URL(path);
		HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setUseCaches(false);
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setRequestProperty("Connection", "Keep-Alive");
		connection.setRequestProperty("Charset", encoding);
		connection.setRequestProperty("Content-Length", String.valueOf(d.length));
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(connection.getOutputStream());
		bufferedOutputStream.write(d);
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		if(connection.getResponseCode() != 200){
			throw new RuntimeException("ResponseCode != 200");
		}
		BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
		byte[] data = readInputStream(bufferedInputStream);
		connection.disconnect();
		return data;
	}
}