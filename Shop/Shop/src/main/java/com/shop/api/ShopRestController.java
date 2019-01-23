package com.shop.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shop.application.ShopController;
import com.shop.application.dto.ShopDTO;

@RestController
@CrossOrigin

public class ShopRestController {
	
	@Autowired
	private ShopController controller = new ShopController();
	
	private String toJson(Object object) {
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
	}
	
	/*
	 * POST /shops/ - Crear botiga: li direm el nom i la capacitat
	 */
	@PostMapping(value = "/shops", produces = "application/json;charset=UTF-8")
	public String addShop(@RequestBody String jShop) throws Exception {
		ShopDTO newShop = new Gson().fromJson(jShop, ShopDTO.class);
		ShopDTO shop = controller.createShop(newShop);
		return toJson(shop);
	}
	
	
	/*^
	 *         ◦ Llistar botigues: retorna la llista de botigues amb el seu nom i la capacitat
	 */
	@GetMapping(value = "/users", produces = "application/json;charset=UTF-8")
	public String listShops() {
		
	}
	
	


}
