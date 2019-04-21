package com.demos.JSON;

import javax.json.JsonObject;

import org.json.simple.JSONObject;

public class UserDetails {
	public static final String USER_INFO_ID = "col_user_info_id";
	public static final String USER_NAME = "col_user_name";
	public static final String USER_AGE = "col_user_age";
	public static final String USER_OCCUPATION = "col_user_occupation";
	public static final String USER_ADDRESS_STREET = "col_user_address_street";
	public static final String USER_ADDRESS_CITY = "col_user_address_city";
	public static final String USER_ADDRESS_PINCODE = "col_user_address_pincode";
	public static final String IMAGE_ARRAY = "image_array";
	
	private int u_id;
	private String u_name;
	private int u_age;
	private String u_occupation;
	private String u_street;
	private String u_city;
	private String u_pincode;
	private ImageDetails[] imageDetails;
	
	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public int getU_age() {
		return u_age;
	}

	public void setU_age(int u_age) {
		this.u_age = u_age;
	}

	public String getU_occupation() {
		return u_occupation;
	}

	public void setU_occupation(String u_occupation) {
		this.u_occupation = u_occupation;
	}

	public String getU_street() {
		return u_street;
	}

	public void setU_street(String u_street) {
		this.u_street = u_street;
	}

	public String getU_city() {
		return u_city;
	}

	public void setU_city(String u_city) {
		this.u_city = u_city;
	}

	public String getU_pincode() {
		return u_pincode;
	}

	public void setU_pincode(String u_pincode) {
		this.u_pincode = u_pincode;
	}

	public ImageDetails[] getImageDetails() {
		return imageDetails;
	}

	public void setImageDetails(ImageDetails[] imageDetails) {
		this.imageDetails = imageDetails;
	}

	public JSONObject getJSON() {
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put(USER_INFO_ID, this.u_id);
		jsonObject.put(USER_NAME, this.u_name);
		jsonObject.put(USER_AGE, this.u_age);
		jsonObject.put(USER_OCCUPATION, this.u_occupation);
		jsonObject.put(USER_ADDRESS_STREET, this.u_street);
		jsonObject.put(USER_ADDRESS_CITY, this.u_city);
		jsonObject.put(USER_ADDRESS_PINCODE, this.u_pincode);
		
		return jsonObject;
	}
}
