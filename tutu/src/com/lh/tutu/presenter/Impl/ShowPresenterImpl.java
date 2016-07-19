package com.lh.tutu.presenter.Impl;

import java.util.List;

import com.lh.tutu.entity.Item;
import com.lh.tutu.model.IModel.AsyncCallback;
import com.lh.tutu.model.IShowModel;
import com.lh.tutu.model.Impl.showModelImpl;
import com.lh.tutu.presenter.IShowPresenter;
import com.lh.tutu.view.IShowView;

public class ShowPresenterImpl implements IShowPresenter{
	private IShowView view;
	private IShowModel model;
	
	
	public ShowPresenterImpl(IShowView view) {
		super();
		this.view = view;
		model=new showModelImpl();
	}

	@Override
	public void loadItem() {
		model.getItem(new AsyncCallback() {
			
			@Override
			public void onSuccess(Object obj) {
				List<Item> items=(List<Item>) obj;
				view.showItem(items);
			}
			
			@Override
			public void onError(Object error) {
				view.showError((String) error);
			}
		});
	}

}
