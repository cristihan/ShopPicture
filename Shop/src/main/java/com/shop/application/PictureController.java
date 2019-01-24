package com.shop.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.shop.application.DTO.PictureDTO;
import com.shop.domain.Picture;
import com.shop.domain.Shop;
import com.shop.persistence.ShopRepository;

@Controller
public class PictureController {

	
	private ShopRepository shopRepository = new ShopRepository();

	/*
	 * Afegir quadre: li donarem el nom del quadre i el del autor
	 */
	public PictureDTO createPicture(int shopId, PictureDTO pictureDto) throws Exception {
		Picture picture = new Picture(pictureDto.getPictureId(), pictureDto.getPictureName(),
				pictureDto.getAuthorName(), pictureDto.getPrice(), pictureDto.getDataIn());
		Shop s = shopRepository.getShopById(shopId);
		s.addPicture(picture);
		return new PictureDTO(picture);
	}

	/*
	 * Llistar els quadres de la botiga
	 */
	public List<PictureDTO> getAllPictures(int PictureId) throws Exception {
		List<PictureDTO> pictures = new ArrayList<>();
		Shop shop = shopRepository.getShopById(PictureId);
		for (Picture picture : shop.getAllPictures()) {
			pictures.add(new PictureDTO(picture));
		}
		return pictures;

	}

}
