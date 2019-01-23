package com.shop.persistence;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.domain.Shop;
import com.shop.utilities.InvalidParamException;

@Repository
public class ShopRepository {
	
	private static List<Shop> repository = new ArrayList<>();

//	private static Datastore datastore = DatastoreManager.getInstance().getDatastore();
//	/**
//	 * crea una nueva botiga y si existe la guarda
//	 * 
//	 * @param shop
//	 * @throws InvalidParamException
//	 */
	public void addShop(Shop shop) throws InvalidParamException {
		if (shop == null)
			throw new InvalidParamException();
		try {
			repository.add(shop);
			//datastore.save(shop);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}

	public List<Shop> getAllShops() {
		List<Shop> result = new ArrayList<>();
		for (Shop s : repository) {
			result.add(s);
		}
		return result;
		//return new ArrayList<>(repository);
		//return repository;	
	}
	
	public Shop getShopById(int shopId) throws Exception {
		for (Shop shop : repository) {
			if(shop.getShopId().equals(shopId)) {
				return shop;
			}
		}
		throw new Exception();
	}
	
	
//
//		
//	public static Shop findShop(String id) {
//		return datastore.find(Shop.class).field("id").equal(id).get();
//	}

}
