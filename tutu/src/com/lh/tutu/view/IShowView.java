package com.lh.tutu.view;

import java.util.List;

import com.lh.tutu.entity.Item;

public interface IShowView extends IView {
	public void showItem(List<Item> items);
	void showError(String string);
}
