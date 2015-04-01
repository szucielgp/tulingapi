package com.szucie.tulingchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class HttpData extends AsyncTask<URL, Integer, String>{

	private HttpClient hClient;
	private HttpGet   hGet;
	private HttpResponse hRes;
	private String url;//��ʼ��ʱ��URL
	private HttpEntity hEntity;
	private InputStream input;
	private StringBuffer sb = new StringBuffer();
	private String result = null;
	private GetData getData ;
	public HttpData(String url,GetData getData) {
		this.url = url;
		this.getData = getData;
	}
	@Override
	protected String doInBackground(URL... params) {

		hClient = new DefaultHttpClient();
		hGet = new HttpGet(url);
		try {
			hRes = hClient.execute(hGet);
			hEntity = hRes.getEntity();
			input = hEntity.getContent();
			BufferedReader bReader = new BufferedReader(new InputStreamReader(input));
			String line = null;
			while((line = bReader.readLine()) != null){//>0�õ���read��buff�������
				sb.append(line+"\n");
			}		
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = sb.toString();
		return result;
	} //ע��URL��д��
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		getData.getDateFromHttp(result);
		//����������а����ݸ���������acitivity�У����п���ͨ���ӿ���ʵ��
	}

	
}
