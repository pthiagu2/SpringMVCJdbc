package com.spring.practice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.practice.pojo.SearchEngine;
import com.spring.practice.pojo.SearchEngineExtractor;
import com.spring.practice.pojo.SearchEngineRowMapper;

@Repository
public class SearchEngineDaoImpl implements SearchEngineDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

		public void addSearchEngine(SearchEngine searchEngine) {
			String query = "SELECT Max(ID) FROM SEARCH_ENGINE";
			int id = jdbcTemplate.queryForObject(query, Integer.class);
			query = "insert into SEARCH_ENGINE (ID,NAME,URL) "
			+ " values(?, ?, ?)";
			jdbcTemplate.update(query, new Object[] { ++id, searchEngine.getName(),
			searchEngine.getUrl() });
			}

	public void updateSearchEngine(SearchEngine searchEngine) {
		String query = "update SEARCH_ENGINE set NAME=?, URL=? where ID=?";
		jdbcTemplate.update(query,
				new Object[] { searchEngine.getName(), searchEngine.getUrl(), searchEngine.getId() });
	}

	public SearchEngine getSearchEngine(int id) {
		String query = "Select * from SEARCH_ENGINE where ID=?";
		SearchEngine searchEngine = jdbcTemplate.query(query, new Object[] { id }, new SearchEngineExtractor());
		return searchEngine;
	}

	public void deleteSearchEngine(int id) {
		String query = "delete from SEARCH_ENGINE where ID=?";
		jdbcTemplate.update(query,
				new Object[] { id });
	}

	public List<SearchEngine> getSearchEngines() {
		String query = "SELECT * FROM SEARCH_ENGINE";
		List<SearchEngine> searchEngines = jdbcTemplate.query(query, new SearchEngineRowMapper());
		return searchEngines;
	}
}
