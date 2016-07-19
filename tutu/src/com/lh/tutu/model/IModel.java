package com.lh.tutu.model;

public interface IModel {
	public interface AsyncCallback{
		void onSuccess(Object success);
		void onError(Object error);
	}
}
