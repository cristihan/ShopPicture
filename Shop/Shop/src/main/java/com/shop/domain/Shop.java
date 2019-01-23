package com.shop.domain;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.shop.utilities.InvalidParamException;

@Entity("shops")
public class Shop {
	
	private static int lastId;
	
	@Id
	private Integer shopId;
	private String nameShop;
	private int maxCapacity;
	
	@Embedded
	private List<Picture> allPictures = new ArrayList<Picture>();
	
	public Shop() {
		
	}
	
	public Shop(Integer shopId, String nameShop, int maxCapacity) throws InvalidParamException {
		if(nameShop == null || nameShop.trim().equals(""))
			throw new InvalidParamException();
		if(maxCapacity < 0)
			throw new InvalidParamException();
		
		this.shopId = lastId;
		lastId++;
		this.nameShop = nameShop;
		this.maxCapacity = maxCapacity;
	}


	public Integer getShopId() {
		return shopId;
	}

	public List<Picture> getAllPictures() {
		return new ArrayList<>(allPictures);
	}

	public String getNameShop() {
		return nameShop;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public void addPicture(Picture picture) throws Exception {
		if(picture == null) 
			throw new Exception(); 
		if(this.maxCapacity == this.allPictures.size())
			throw new Exception(); 
			this.allPictures.add(picture);		
		
	}
	
	public void burnPictures() {
		this.allPictures.removeAll(allPictures);
	}
	
	

}
