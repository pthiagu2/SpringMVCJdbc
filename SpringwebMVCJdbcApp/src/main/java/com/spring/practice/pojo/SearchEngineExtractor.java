package com.spring.practice.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class SearchEngineExtractor implements ResultSetExtractor<SearchEngine> {

	public SearchEngine extractData(ResultSet resultSet) throws SQLException, DataAccessException {
		// TODO Auto-generated method stub
		resultSet.next();
		SearchEngine searchEngine = new SearchEngine();
		searchEngine.setId(resultSet.getInt(1));
		searchEngine.setName(resultSet.getString(2));
		searchEngine.setUrl(resultSet.getString(3));
		return searchEngine;
	}

}
