package com.practica.maguigle.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practica.maguigle.entities.WebPage;
import com.practica.maguigle.services.SearchService;
import com.practica.maguigle.services.SpiderService;

@RestController
public class SearchController {
	
	@Autowired
	private SearchService service;
	
	@Autowired
	private SpiderService spiderService;
	
	
	@RequestMapping(value = "api/search", method = RequestMethod.GET)
	public List<WebPage> search(@RequestParam Map<String,String> params) {
		// /api/search?query=...
		String query = params.get("query");
		return service.search(query);
	}
	
	
	@RequestMapping(value = "api/test", method = RequestMethod.GET)
	public void search() throws Exception{
		spiderService.indexWebPages();
	}
	
}
