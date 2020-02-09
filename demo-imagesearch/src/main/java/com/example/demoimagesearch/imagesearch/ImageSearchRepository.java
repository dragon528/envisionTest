package com.example.demoimagesearch.imagesearch;

import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ImageSearchRepository extends JpaRepository<ImageSearch, Long> {
	
	List<ImageSearch> findByNameLike(String name);
}
