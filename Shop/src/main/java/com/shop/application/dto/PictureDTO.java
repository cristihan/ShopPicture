package com.shop.application.dto;

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
	
	public PictureDTO() {
		
	}
	
	public PictureDTO(Picture picture) {
		this.pictureId = picture.getPictureId();
		this.nameAuthor = picture.getNameAuthor();
		this.namePicture = picture.getNamePicture();
		this.price = picture.getPrice();
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
	
	

}
