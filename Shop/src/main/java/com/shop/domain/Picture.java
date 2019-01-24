package com.shop.domain;


import java.util.Calendar;

import com.shop.utilities.InvalidParamException;


public class Picture {
	
	private static int lastId = 1;
	
	private Integer pictureId;
	
	private String authorName;	
	private String pictureName;	
	private double price;		
	
	private Calendar dateIn;
	
	public Picture() {
		
	}
	
	public Picture(Integer pictureId, String authorName, String pictureName, double price, Calendar dateIn) throws InvalidParamException {
		if(authorName==null || authorName.trim().equals(""))
			throw new InvalidParamException();
		
		if(pictureName==null || pictureName.trim().equals(""))
			throw new InvalidParamException();
		
		if(price < 0   )
			throw new InvalidParamException();
		
		this.pictureId = lastId;
		lastId++;
		this.authorName = authorName;
		this.pictureName = pictureName;
		this.price = price;
		this.dateIn = Calendar.getInstance();	
	}
	

	public Integer getPictureId() {
		return pictureId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getPictureName() {
		return pictureName;
	}

	public double getPrice() {
		return price;
	}

	public Calendar getDataIn() {
		return dateIn;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	

}
