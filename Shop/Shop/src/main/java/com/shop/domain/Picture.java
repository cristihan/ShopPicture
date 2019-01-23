package com.shop.domain;

import java.util.Calendar;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.shop.utilities.InvalidParamException;

@Entity("picture")
public class Picture {
	
	private static int lastId = 1;
	@Id
	private Integer pictureId;
	
	private String nameAuthor;
	private String namePicture;
	private double price;
	
	@Embedded
	private Calendar dataIn;
	
	public Picture() {
		
	}
	
	public Picture(Integer pictureId, String nameAuthor, String namePicture, double price) throws InvalidParamException {
		if(nameAuthor == null || nameAuthor.trim().equals(""))
			throw new InvalidParamException();
		if(namePicture == null || namePicture.trim().equals(""))
			throw new InvalidParamException();
		if(price < 0)
			throw new InvalidParamException();
		
		this.pictureId = lastId;
		lastId++;
		this.nameAuthor = nameAuthor;
		this.namePicture = namePicture;
		this.price = price;
		this.dataIn = Calendar.getInstance();
	}
	
	
	public Integer getPictureId() {
		return pictureId;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public String getNamePicture() {
		return namePicture;
	}

	public double getPrice() {
		return price;
	}

	public Calendar getDateIn() {
		return dataIn;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}



}
	
