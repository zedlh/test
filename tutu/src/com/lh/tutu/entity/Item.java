package com.lh.tutu.entity;

public class Item {

	private String id;
	private String setId;
	private String date;
	private String image_url;
	private int image_width;
	private int image_height;
	 private String photo_id;
	public Item() {
	}
	public Item(String id, String setId, String date, String image_url,
			int image_width, int image_height, String photo_id) {
		this.id = id;
		this.setId = setId;
		this.date = date;
		this.image_url = image_url;
		this.image_width = image_width;
		this.image_height = image_height;
		this.photo_id = photo_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSetId() {
		return setId;
	}
	public void setSetId(String setId) {
		this.setId = setId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public int getImage_width() {
		return image_width;
	}
	public void setImage_width(int image_width) {
		this.image_width = image_width;
	}
	public int getImage_height() {
		return image_height;
	}
	public void setImage_height(int image_height) {
		this.image_height = image_height;
	}
	public String getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", image_url=" + image_url + "]";
	}
	 
}
