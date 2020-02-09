package com.example.demoimagesearch.imagesearch;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ImageSearch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String url;
	private int height;
	private int width;
	private String thumbnail;
	private int thumbnailHeight;
	private int thumbnailWidth;
	private String base64Enconding;
	private String name;
	private String title;
	private String imageWebSearchUrl;
	
	@Override
	public String toString() {
		return "ImageSearch [url=" + url + ", height=" + height + ", width=" + width + ", thumbnail=" + thumbnail
				+ ", thumbnailHeight=" + thumbnailHeight + ", thumbnailWidth=" + thumbnailWidth + ", base64Enconding="
				+ base64Enconding + ", name=" + name + ", title=" + title + ", imageWebSearchUrl=" + imageWebSearchUrl
				+ "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getThumbnailHeight() {
		return thumbnailHeight;
	}

	public void setThumbnailHeight(int thumbnailHeight) {
		this.thumbnailHeight = thumbnailHeight;
	}

	public int getThumbnailWidth() {
		return thumbnailWidth;
	}

	public void setThumbnailWidth(int thumbnailWidth) {
		this.thumbnailWidth = thumbnailWidth;
	}

	public String getBase64Enconding() {
		return base64Enconding;
	}

	public void setBase64Enconding(String base64Enconding) {
		this.base64Enconding = base64Enconding;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageWebSearchUrl() {
		return imageWebSearchUrl;
	}

	public void setImageWebSearchUrl(String imageWebSearchUrl) {
		this.imageWebSearchUrl = imageWebSearchUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
