package com.shop.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.domain.Picture;
import com.shop.utilities.InvalidParamException;


@Repository
public class PictureRepository {

	private static List<Picture> repository = new ArrayList<>();
	
	public void addShop(Picture picture) throws InvalidParamException {
		if (picture == null)
			throw new InvalidParamException();
		try {
			repository.add(picture);
		} catch (Exception e) {
			throw new InvalidParamException();
		}
	}
	
	public void burnPictures(int PictureId) {
		for (Picture picture : repository) {
			if(picture.getPictureId().equals(PictureId)) {
				repository.remove(PictureId);
			}
			
		}
	}

}
