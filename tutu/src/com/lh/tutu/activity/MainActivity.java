package com.lh.tutu.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.lh.tutu.R;
import com.lh.tutu.adapter.MyAdapter;
import com.lh.tutu.entity.Item;
import com.lh.tutu.presenter.IShowPresenter;
import com.lh.tutu.presenter.Impl.ShowPresenterImpl;
import com.lh.tutu.view.IShowView;

public class MainActivity extends Activity implements IShowView {
	private MyAdapter adapter1;
	private MyAdapter adapter2;
	private IShowPresenter showPresenter;
	private ListView lvshow1;
	private ListView lvshow2;
	private List<Item> list1;
	private List<Item> list2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lvshow1 = (ListView) findViewById(R.id.lv_lv1);
		lvshow2 = (ListView) findViewById(R.id.lv_lv2);

		showPresenter = new ShowPresenterImpl(this);
		list1 = new ArrayList<Item>();
		list2 = new ArrayList<Item>();

		showPresenter.loadItem();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void showItem(List<Item> items) {
		for(int i=0; i< items.size(); i++){
			if(i%2==0){
				list1.add(items.get(i));
			}else{
				list2.add(items.get(i));
			}
		}
		adapter1 = new MyAdapter(this, list1);
		adapter2 = new MyAdapter(this, list2);
		
		lvshow1.setAdapter(adapter1);
		lvshow2.setAdapter(adapter2);
	}

	@Override
	public void showError(String string) {

	}

}
