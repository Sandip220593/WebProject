package com.demos.JSON;

import org.json.simple.JSONObject;

public class ImageDetails {
	public static final String IMG_ID = "col_img_id";
	public static final String IMG_NAME = "col_img_name";
	public static final String IMG_CLICKED_DATE = "col_img_clickedDate";
	public static final String IMG_ARTIST = "col_img_artist";
	public static final String IMG_CATEGORY = "col_img_category";

	private int img_id;
	private String img_name;
	private String img_clkdate;
	private String img_artist;
	private String img_category;

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	public String getImg_name() {
		return img_name;
	}

	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}

	public String getImg_clkdate() {
		return img_clkdate;
	}

	public void setImg_clkdate(String img_clkdate) {
		this.img_clkdate = img_clkdate;
	}

	public String getImg_artist() {
		return img_artist;
	}

	public void setImg_artist(String img_artist) {
		this.img_artist = img_artist;
	}

	public String getImg_category() {
		return img_category;
	}

	public void setImg_category(String img_category) {
		this.img_category = img_category;
	}

	public JSONObject getJSON(){
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put(IMG_CLICKED_DATE, this.img_id);
		jsonObject.put(IMG_NAME, this.img_name);
		jsonObject.put(IMG_CLICKED_DATE, this.img_clkdate);
		jsonObject.put(IMG_ARTIST, this.img_artist);
		jsonObject.put(IMG_CATEGORY, this.img_category);
		
		return jsonObject;
	}
}
