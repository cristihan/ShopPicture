package com.shop.application.DTO;



import java.util.Calendar;

import com.google.gson.annotations.Expose;
import com.shop.domain.Picture;

public class PictureDTO {	
	
	@Expose
	private int pictureId;
	@Expose
	private String authorName;	
	@Expose
	private String pictureName;	
	@Expose
	private double price;
	@Expose
	private Calendar dataIn;
	
	public PictureDTO() {
		
	}

	
	public PictureDTO(Picture picture) {
		super();
		this.pictureId = picture.getPictureId();
		this.authorName = picture.getAuthorName();
		this.pictureName = picture.getPictureName();
		this.price = picture.getPrice();
		this.dataIn = picture.getDataIn();
	}


	public int getPictureId() {
		return pictureId;
	}


	public String getAuthorName() {
		if(this.authorName == null  || this.authorName.equals(""))
			return "Anonimo";
		return authorName;
	}


	public String getPictureName() {
		if(this.pictureName == null) return "";
		return pictureName;
	}


	public double getPrice() {
		return price;
	}
	
	public Calendar getDataIn() {
		return dataIn;
	}


	@Override
	public boolean equals(Object obj) {
		if(obj instanceof PictureDTO) {
			return this.pictureName.equals(((PictureDTO) obj).pictureName);
		}
		return super.equals(obj);
	}
	

}
