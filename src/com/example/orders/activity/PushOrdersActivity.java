package com.example.orders.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.orders.R;
import com.example.orders.adapter.SwipeAdapter;
import com.example.orders.entity.PushOrders;
import com.example.orders.widgets.PushOrdersListView;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class PushOrdersActivity extends Activity {

	private List<PushOrders> data = new ArrayList<PushOrders>();
	private PushOrdersListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_push_orders);
		
		initData();
		initView();
	}

	private void initData() {
		
    	for(int i=0;i<30;i++){
    		PushOrders orders = null;
    		if(i%3==0){
    			orders = new PushOrders("腾讯新闻", "人民日报刊文：习近平对评价毛泽东�?6个重要观�?", "早上8:44");
    			orders.setIcon_id(R.drawable.img_1);
    		}else if(i%3==1){
    			orders = new PushOrders("订阅", "CSDN�?2013年国内最具技术影响力公司","早上8:49");
    			orders.setIcon_id(R.drawable.img_2);
    		}else{
    			orders = new PushOrders("微博阅读", "美女演各款妹子跟男朋友打电话","昨天晚上");
    			orders.setIcon_id(R.drawable.img_3);
    		}
    		
    		data.add(orders);
    	}
	}
	
	/**
     * 初始化界面
     */
    private void initView() {
    	mListView = (PushOrdersListView)findViewById(R.id.push_orders_list);
        SwipeAdapter mAdapter = new SwipeAdapter(this,data,mListView.getRightViewWidth());
        
        mAdapter.setOnRightItemClickListener(new SwipeAdapter.onRightItemClickListener() {
        	
                    @Override
                    public void onRightItemClick(View v, int position) {
                    	
                        Toast.makeText(PushOrdersActivity.this, "删除第  " + (position+1)+" 对话记录",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        
        mListView.setAdapter(mAdapter);
        
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PushOrdersActivity.this, "点击 " + position, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

}
