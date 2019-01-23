package com.shop.persistence;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;

import com.shop.domain.Shop;
import com.shop.persistence.DatastoreManager;
import com.shop.utilities.InvalidParamException;

public class ShopRepository {

	private static Datastore datastore = DatastoreManager.getInstance().getDatastore();

	private static List<Shop> shops = new ArrayList<>();

	public ShopRepository() {
	}

	/*
	 * public void createShop(Shop shop) throws InvalidParamException {
	 * if(shop==null) throw new InvalidParamException(); shops.add(shop); }
	 */
	public void addShop(Shop shop) throws InvalidParamException {
		if (shop == null)
			throw new InvalidParamException();
		try {
			shops.add(shop);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}

	public List<Shop> getAllShops() {
		return new ArrayList<>(shops);
	}

	public List<Shop> getAllShops1() {
		List<Shop> result = new ArrayList<>();

		for (Shop shop : shops) {
			result.add(shop);
		}
		return result;
	}

	public Shop getShopById(int shopID) throws Exception {
		for (Shop shop : shops) {
			if (shop.getShopId().equals(shopID)) {
				return shop;
			}
		}
		throw new Exception();
	}

	public boolean shopExistById(Shop shop) {
		for (Shop s : shops) {
			if (s.getShopId().equals(shop.getShopId()))
				return true;
		}
		return false;
	}

}
