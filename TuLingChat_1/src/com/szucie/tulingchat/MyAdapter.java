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
   
	//一个list对象来填充，还需要一个context
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
        LayoutInflater  inflater = LayoutInflater.from(context);//注意写法！！
      
        if(list.get(positon).getFlag() == ListData.SEND){
            rLayout = (RelativeLayout)inflater.inflate(R.layout.right,null);
          //  rLayout = (RelativeLayout)getLayoutInflater().inflate(R.layout.right,null);这不是activity，所以不能写
         }//因为这里加载的是不同的xml，所以要给数据加一个标志位！
       
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
