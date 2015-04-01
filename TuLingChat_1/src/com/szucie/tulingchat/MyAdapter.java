package com.szucie.tulingchat;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MyAdapter extends BaseAdapter{
   
	//һ��list��������䣬����Ҫһ��context
	private Context context;
	private List<ListData> list;
	private RelativeLayout rLayout;
	
	
	public MyAdapter(Context context, List<ListData> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int id) {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public View getView(int positon, View arg1, ViewGroup arg2) {
        LayoutInflater  inflater = LayoutInflater.from(context);//ע��д������
      
        if(list.get(positon).getFlag() == ListData.SEND){
            rLayout = (RelativeLayout)inflater.inflate(R.layout.right,null);
          //  rLayout = (RelativeLayout)getLayoutInflater().inflate(R.layout.right,null);�ⲻ��activity�����Բ���д
         }//��Ϊ������ص��ǲ�ͬ��xml������Ҫ�����ݼ�һ����־λ��
       
        if(list.get(positon).getFlag() == ListData.RECIVE){
        	 rLayout = (RelativeLayout)inflater.inflate(R.layout.left,null);
        }
        TextView tv =(TextView)rLayout.findViewById(R.id.tv);
        TextView time = (TextView)rLayout.findViewById(R.id.time);
        tv.setText(list.get(positon).getText().toString());
        time.setText(list.get(positon).getTime().toString());
		return rLayout;
	}

}
