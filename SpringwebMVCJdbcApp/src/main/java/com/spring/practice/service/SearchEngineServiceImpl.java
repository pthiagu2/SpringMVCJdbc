package com.spring.practice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.practice.dao.SearchEngineDao;
import com.spring.practice.pojo.SearchEngine;

@Service
public class SearchEngineServiceImpl implements SearchEngineService {
	@Autowired
	private SearchEngineDao searchEngineDao;

	public void addSearchEngine(SearchEngine searchEngine) {
		searchEngineDao.addSearchEngine(searchEngine);
	}

	public void updateSearchEngine(SearchEngine searchEngine) {
		searchEngineDao.updateSearchEngine(searchEngine);
	}

	public SearchEngine getSearchEngine(int id) {
	 return searchEngineDao.getSearchEngine(id);
	}

	public void deleteSearchEngine(int id) {
	searchEngineDao.deleteSearchEngine(id);	
	}

	public List<SearchEngine> getSearchEngines() {
		List<SearchEngine> searchEngines = searchEngineDao.getSearchEngines();
		return searchEngines;
	}
}
