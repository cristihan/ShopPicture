package com.shop.application.dto;

import java.util.Calendar;

import com.google.gson.annotations.Expose;
import com.shop.domain.Picture;

public class PictureDTO {
	
	@Expose
	private int pictureId;
	@Expose
	private String nameAuthor;
	@Expose
	private String namePicture;
	@Expose
	private double price;
	@Expose
	private Calendar dataIn;
	
	public PictureDTO() {
		
	}
	
	public PictureDTO(Picture picture)  {		
		this.pictureId = picture.getPictureId();
		this.nameAuthor = picture.getNameAuthor();
		this.namePicture = picture.getNamePicture();
		this.price = picture.getPrice();
		this.dataIn = picture.getDateIn();
	}
		

	public int getPictureId() {
		return pictureId;
	}

	public String getNameAuthor() {
		if(nameAuthor == null || nameAuthor.equals(""))
			return "Anonimo";
		return nameAuthor;
	}

	public String getNamePicture() {
		if(namePicture == null) return "";
		return namePicture;
	}

	public double getPrice() {
		return price;
	}
	
	

}
