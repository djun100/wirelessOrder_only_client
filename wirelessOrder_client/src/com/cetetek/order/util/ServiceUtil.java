/**
 * Copyright (c) 2011, ����˼�Ͽ�̩�Ƽ����޹�˾ All rights reserved.
 * Website : http://www.cetetek.com
 * name : ServiceUtil.java 
 * Date : 2011-09-14
 * @author : xice
 * @version : 1.0	
 */
package com.cetetek.order.util;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Service������
 * @author : xice Email:jian.xun@cetetek.com
 * @version : 1.0
 * @date : 2011-9-14 ����09:53:06
 */
public class ServiceUtil<T> {

	/**
	 * ͨ����ַ�������ݼ���(���̸߳���)
	 * @param path
	 * @param analysisJSON
	 * @return
	 * @throws Exception
	 */
	public ArrayList<T> find(String path,ServiceUtil.Analysis<T> analysisJSON) throws Exception{
		byte[] data = HTTPUtil.downloadGET(path);
		String json = new String(data,HTTPUtil.HTTP_UTF8);
		JSONArray jsonArray = new JSONArray(json);
		ArrayList<T> list = new ArrayList<T>();
		for(int i=0;i<jsonArray.length();i++){
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			list.add(analysisJSON.analysisJSON(jsonObject));
		}
		return list;
	}
	
	/**
	 * ͨ����ַ���ص�������
	 * @param path
	 * @param analysisJSON
	 * @return
	 * @throws Exception
	 */
	public T findDetail(String path,ServiceUtil.Analysis<T> analysisJSON) throws Exception{
		byte[] data = HTTPUtil.downloadGET(path);
		String json = new String(data,HTTPUtil.HTTP_UTF8);
		JSONObject jsonObject = new JSONObject(json);
		return analysisJSON.analysisJSON(jsonObject);
	}
	
	/**
	 * ����POST����
	 * @param path
	 * @param params �������map����
	 * @param analysisJSON 
	 * @throws Exception
	 */
	public static String postRequest(String path,Map<String, String> params) throws Exception{
		byte[] data = HTTPUtil.downloadPost(path, params, HTTPUtil.HTTP_UTF8);
		return new String(data,HTTPUtil.HTTP_UTF8);
	}
	
	/**
	 * ����JSON�ӿ�
	 * @author pro
	 *
	 * @param <T>
	 */
	public interface Analysis<T>{
		public T analysisJSON(JSONObject jsonObject) throws Exception;
	}
}
