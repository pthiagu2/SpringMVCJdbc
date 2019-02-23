package com.spring.practice.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class SearchEngineRowMapper implements RowMapper<SearchEngine> {
	public SearchEngine mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.setId(resultSet.getInt(1));
		searchEngine.setName(resultSet.getString(2));
		searchEngine.setUrl(resultSet.getString(3));
		return searchEngine;
	}
}