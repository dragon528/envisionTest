package com.example.demoimagesearch.imagesearch;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ImageSearchController {

	@Autowired
	private ImageSearchService imageSearchService;
	
	@PostMapping("/") 
	public ResponseEntity<List<ImageSearch>> searchImage(@RequestParam(value = "name") String name) {
		
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/").buildAndExpand().toUri();
		
		List<ImageSearch> ims = imageSearchService.imageSearch(name);
		
		System.out.println(ims.toString());
		
		return ResponseEntity.created(uri).body(ims);
	}
}
