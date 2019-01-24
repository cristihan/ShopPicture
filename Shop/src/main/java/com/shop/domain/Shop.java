package com.shop.domain;

import java.util.ArrayList;
import java.util.List;


public class Shop {
	
	private static int lastId = 1;
	
	
	private Integer shopId;
	private String shopName;
	private int maxCapacity;
	
	
	private List<Picture> allPictures = new ArrayList<Picture>();
	
	public Shop() {
		
	}
	
	public Shop(Integer shopId, String shopName, int maxCapacity ) throws Exception {
		if(shopName==null || shopName.trim().equals(""))
			throw new Exception();
		
		if(maxCapacity < 0   )
			throw new Exception();
		
		this.shopId = lastId;
		lastId++;
		this.shopName = shopName;
		this.maxCapacity = maxCapacity;
	}		

	public Integer getShopId() {
		return shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public List<Picture> getAllPictures() {
		return new ArrayList<>(allPictures);
	}
	
	public void addPicture(Picture picture) throws Exception {
		if(picture == null)
			throw new Exception();
		if(this.maxCapacity == this.allPictures.size()) {
			throw new Exception();
		}
		this.allPictures.add(picture);
	}
	
	public void burnPictures() {
		this.allPictures.removeAll(allPictures);
	}
	
	
	

}
