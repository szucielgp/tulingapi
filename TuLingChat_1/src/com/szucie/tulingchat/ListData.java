package com.szucie.tulingchat;

public class ListData {

	private String text;
//	public static String SEND = "1";
//	public static String RECIVE="2";//ʹ��String��ʱ���ڱ���ʱ����ÿһ���2��
	public static int SEND = 1;
	public static int RECIVE = 2;
//	private static int flag;����д����static�ģ����Ը�ȫ�ֱ���һ�������ڶ�����new listdata��ʱ�򣬱�Ϊ2���������еĶ������2��staticλ�ھ�̬�洢��������һ������
	private  int flag;
	private String time;
	public ListData(String text,int flag,String time) {
		this.text = text;
		this.flag = flag;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
