package com.shop.domain;

import java.time.LocalDate;
//import java.util.Calendar;
//import java.util.Date;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;

import com.shop.utilities.InvalidParamException;


public class Picture {
	
	private static int lastId = 1;
	@Id
	private int pictureId;
	
	private String nameAuthor;
	private String namePicture;
	private double price;
	
	@Embedded
	private LocalDate dataIn;
	
	public Picture() {
		
	}
	
	public Picture(int pictureId, String nameAuthor, String namePicture, double price, LocalDate dataIn) throws InvalidParamException {
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
		this.dataIn = dataIn;
	}
	
	
	public int getPictureId() {
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

	public LocalDate getEnterDate() {
		return dataIn;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}
	
	
	

//	public Date getDateIn() {
//		return dateIn;
//	}
//	
//	public void newEntrada() {
//		dateIn = Calendar.getInstance().getTime();
//	}

}
	
