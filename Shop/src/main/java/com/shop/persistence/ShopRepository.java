package com.shop.persistence;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;

import com.shop.domain.Shop;
import com.shop.utilities.InvalidParamException;

public class ShopRepository {

	private static Datastore datastore = DatastoreManager.getInstance().getDatastore();

	private static List<Shop> shops = new ArrayList<>();

	/**
	 * crea una nueva botiga y si existe la guarda
	 * 
	 * @param shop
	 * @throws InvalidParamException
	 */
	public void saveShop(Shop shop) throws InvalidParamException {
		if (shop == null)
			throw new InvalidParamException();
		try {
			datastore.save(shop);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}

	public List<Shop> getAllShops() {
		return datastore.find(Shop.class).asList();
	}

	public static Shop findShop(String uniId) {
		return datastore.find(Shop.class).field("id").equal(uniId).get();
	}

}
