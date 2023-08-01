package com.practica.maguigle.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.practica.maguigle.entities.WebPage;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Repository
public class SearchRepositoryImp implements SearchRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public List<WebPage> search(String textSearch) {
		String query = "FROM WebPage WHERE description like :textSearch";
		return entityManager.createQuery(query)
				.setParameter("textSearch", "%"+textSearch+"%")
				.getResultList();
	}

	@Transactional
	@Override
	public void save(WebPage webPage) {
		entityManager.merge(webPage);
	}

	
	@Override
	public boolean exist(String url) {
		return(getByUrl(url) != null);
	}

	@Override
	public WebPage getByUrl(String url) {
		String query = "From WebPage WHERE url = :url";
		List<WebPage> list = entityManager.createQuery(query)
				.setParameter("url", url)
				.getResultList();
		
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public List<WebPage> getLinksToIndex() {
		String query = "FROM WebPage WHERE title is null AND description is null";
		return entityManager.createQuery(query)
				.setMaxResults(100)
				.getResultList();
	}

}
