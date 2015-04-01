package com.szucie.tulingchat;
//此本完成数据的封装
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements GetData,OnClickListener{
 
	private HttpData httpData;
	public List<ListData> lists;
	private ListView listView;
	private Button bsend;
	private EditText ev;
	private MyAdapter adapter;
	private String send;
	private String time;
	private long cTime=0,oTime=0;
	private String[] welcome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intiView();
	}
 
	public void intiView(){
		lists = new ArrayList<ListData>();
		listView = (ListView)findViewById(R.id.list);
		ev = (EditText)findViewById(R.id.send);
		bsend = (Button)findViewById(R.id.bsend);
	    ListData listdata = new ListData(getWelcome(), ListData.RECIVE, getTime());
	    lists.add(listdata);
		adapter = new MyAdapter(MainActivity.this,lists);
		listView.setAdapter(adapter);
		bsend.setOnClickListener(this);
	}
	@Override
	public void getDateFromHttp(String str) {
		System.out.println(str);
	    paseText(str);
	}
	
	public void paseText(String str){
		 try {
			JSONObject jobj = new JSONObject(str);
			String code = jobj.getString("code");
			String text = jobj.getString("text");
			ListData data = new ListData(text,ListData.RECIVE,getTime());
			lists.add(data);
			adapter.notifyDataSetChanged();
//			System.out.println(code);
			for(int i=0;i<lists.size();i++){
				System.out.println(lists.get(i).getFlag());	
			}
			//get到的一个对象
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		ListData ld = new ListData(ev.getText().toString(),ListData.SEND,getTime());
		lists.add(ld);
		System.out.println(lists.get(lists.indexOf(ld)).getFlag()+"fdfdfdfd");
		adapter.notifyDataSetChanged();
		//adapter.notifyDataSetInvalidated();
		send = ev.getText().toString();
		ev.setText("");
		String nssend = send.replace(" ", "");
		String nesend = nssend.replace("\n", "");
		httpData = (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=4019018ced48ffcecb4a45b619c00a31&info="+send,
				this)
		.execute();	//nesend不能直接在“”中，会被当做字符串来处理	
	}
	
	public String getTime(){
		cTime = System.currentTimeMillis();
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日:HH时mm分ss秒");
		Date date= new Date();
		time= format.format(date);
		if((cTime-oTime)>5000 ){
			oTime = cTime;
			return time;
		}
		else{
		return "";
		}
	}
	
	public String getWelcome(){
		String str="你好";
		welcome = this.getResources().getStringArray(R.array.welcome_tips);//注意这里的写法
		int index =  (int)Math.random()*(welcome.length-1);
		str = welcome[index];
	//System.out.println(Math.random());
		return str;
	}
}
