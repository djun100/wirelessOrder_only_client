package com.cetetek.order.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * ʱ���̴߳�����
 */
public class TimeThread {

	public Handler h ;
	public TimeThread(Handler h) {
		this.h = h ;
	}
	
	/**
	 * ����1���߳̽�������,
	 */
	public void startTime() {
			//��ʼ�߳�����
			new TimeCustemer().start();
		}
	
	/**
	 * �����߳�
	 */
	class TimeCustemer extends Thread{
		public void run() {
			try {
				while(true){
					SimpleDateFormat sd = new SimpleDateFormat("yyyy��MM��dd��  hh:MM:ss");
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
