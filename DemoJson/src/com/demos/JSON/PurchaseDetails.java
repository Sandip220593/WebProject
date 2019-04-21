package com.demos.JSON;

public class PurchaseDetails {
	public static final String PURCHASE_ID = "col_purchase_id";
	public static final String PURCHASE_BUYER_ID = "col_purchase_buyer_id";
	public static final String PURCHASE_IMAGE_ID = "col_purchase_image_id";
	public static final String PURCHASE_DATE = "col_purchase_date";

	private int purchase_id;
	private int purchase_buyer_id;
	private int purchase_img_id;
	private String purchase_date;

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getPurchase_buyer_id() {
		return purchase_buyer_id;
	}

	public void setPurchase_buyer_id(int purchase_buyer_id) {
		this.purchase_buyer_id = purchase_buyer_id;
	}

	public int getPurchase_img_id() {
		return purchase_img_id;
	}

	public void setPurchase_img_id(int purchase_img_id) {
		this.purchase_img_id = purchase_img_id;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	
	
}
