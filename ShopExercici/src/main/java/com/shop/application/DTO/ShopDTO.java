package com.shop.application.DTO;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Id;

import com.google.gson.annotations.Expose;
import com.shop.domain.Picture;
import com.shop.domain.Shop;


public class ShopDTO {
	
	@Id
	@Expose
	private int shopId;
	@Expose
	private String shopName;
	@Expose
	private int maxCapacity;
	@Expose
	private List<PictureDTO> allPictures = new ArrayList<PictureDTO>();
	
	
	public ShopDTO(Shop shop) {	
		this.shopId = shop.getShopId();
		this.shopName = shop.getShopName();
		this.maxCapacity = shop.getMaxCapacity();
		this.allPictures = convertToDTO(shop.getAllPictures());
	}
	
	private List<PictureDTO> convertToDTO(List<Picture> allPictures){
		List<PictureDTO> result=new ArrayList<>();
		for (Picture p : allPictures) {
			result.add(new PictureDTO(p));
		}
		return result;
	}

	public int getShopId() {
		return shopId;
	}

	public String getShopName() {
		if(this.shopName == null) return"";
		return shopName;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public List<PictureDTO> getAllPictures() {
		return new ArrayList<>(allPictures);
	}
	
	

}
