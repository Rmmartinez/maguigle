package com.practica.maguigle.repositories;

import java.util.List;

import com.practica.maguigle.entities.WebPage;

public interface SearchRepository {
	
	List<WebPage> search(String textSearch);
	
	void save(WebPage webPage);

	boolean exist(String link);
	
	WebPage getByUrl(String url);

	List<WebPage>  getLinksToIndex();
}

