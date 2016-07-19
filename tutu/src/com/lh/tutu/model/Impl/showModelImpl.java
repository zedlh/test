package com.lh.tutu.model.Impl;

import java.util.List;

import android.util.Log;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.lh.tutu.app.MyApplication;
import com.lh.tutu.entity.Item;
import com.lh.tutu.entity.Result;
import com.lh.tutu.model.IShowModel;

public class showModelImpl implements IShowModel {
	private RequestQueue queue;
	
	@Override
	public void getItem(final AsyncCallback callback) {
		queue=MyApplication.getHttpQueue();
		String url = "http://image.baidu.com/channel/listjson?pn=0&rn=30&tag1=%E7%BE%8E%E5%A5%B3&tag2=%E5%85%A8%E9%83%A8&ftags=%E5%B0%8F%E6%B8%85%E6%96%B0&ie=utf8";
		
		StringRequest request = new StringRequest(Method.GET, url,
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						Log.i("info", "res"+response);
						List<Item> items;
						Gson gson=new Gson();
						Result data=gson.fromJson(response,Result.class);
						items=data.getData();
						Log.i("info", "item"+items);
						callback.onSuccess(items);
					}
			
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						callback.onError(error);
					}
				});
		queue.add(request);
	}

}
