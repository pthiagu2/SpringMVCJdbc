package com.spring.practice.dao;

import java.util.List;
import com.spring.practice.pojo.SearchEngine;

public interface SearchEngineDao {
	public void addSearchEngine(SearchEngine searchEngine);

	public void updateSearchEngine(SearchEngine searchEngine);

	public SearchEngine getSearchEngine(int id);

	public void deleteSearchEngine(int id);

	public List<SearchEngine> getSearchEngines();
}