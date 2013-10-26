package com.cetetek.order.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * 时间线程处理器
 */
public class TimeThread {

	public Handler h ;
	public TimeThread(Handler h) {
		this.h = h ;
	}
	
	/**
	 * 开启1条线程进行下载,
	 */
	public void startTime() {
			//开始线程下载
			new TimeCustemer().start();
		}
	
	/**
	 * 下载线程
	 */
	class TimeCustemer extends Thread{
		public void run() {
			try {
				while(true){
					SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日  hh:MM:ss");
					String time = sd.format(new Date());
					Message msg = new Message();
					Bundle b = new Bundle();
					b.putString("time", time);
					msg.setData(b);
					h.sendMessage(msg);
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
