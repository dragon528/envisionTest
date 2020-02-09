package com.example.demoimagesearch.imagesearch;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.HttpResponse;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageSearchService {

	@Autowired
	private ImageSearchRepository imageSearchRepository;
	
	public List<ImageSearch> imageSearch(String inputName) {
		
		List<ImageSearch> ims = searchImageInDatabase(inputName);

		if (ims.isEmpty()) {
			String name = inputName.trim().replace(" ", "%20");
			HttpResponse<JsonNode> response = Unirest.get(
					"https://contextualwebsearch-websearch-v1.p.rapidapi.com/api/Search/ImageSearchAPI?autoCorrect=false&pageNumber=1&pageSize=10&q=" + name + "&safeSearch=false")
					.header("x-rapidapi-host", "contextualwebsearch-websearch-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "a0370bff6bmsh8553aac86bd7cb4p125270jsnf831bb4a7954").asJson();

			JSONObject myObj = response.getBody().getObject();
			JSONArray results = myObj.getJSONArray("value");

			Gson gson = new Gson();
			Type dataListType = new TypeToken<ArrayList<ImageSearch>>() {
			}.getType();
			ims = gson.fromJson(results.toString(), dataListType);

			imageSearchRepository.saveAll(ims);
		}
		
		return ims;
	}
	
	private List<ImageSearch> searchImageInDatabase(String name) {
		List<ImageSearch> listImage = imageSearchRepository.findByNameLike("%"+name+"%");
		
		if (listImage.size() > 0) {
			return listImage;
		} else {
			return new ArrayList<ImageSearch>();
		}
	}
}
