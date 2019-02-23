package com.spring.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practice.pojo.SearchEngine;
import com.spring.practice.service.SearchEngineService;

@Controller
public class SearchEngineController {
	@Autowired
	SearchEngineService searchEngineService;

	@RequestMapping("/searchEngines")
	public ModelAndView getSearchEngines() {
		ModelAndView mvObject = new ModelAndView("searchEngines");
		List<SearchEngine> searchEngines = searchEngineService.getSearchEngines();
		mvObject.addObject("searchEnginesList", searchEngines);
		return mvObject;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSearchEngine(@PathVariable Integer id) {
		ModelAndView mvObject = new ModelAndView("editSearchEngine");
		SearchEngine searchEngine = searchEngineService.getSearchEngine(id);
		mvObject.addObject("command", searchEngine);
		return mvObject;

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView updateSearchEngine(@ModelAttribute SearchEngine searchEngine, @PathVariable Integer id) {
		ModelAndView mvObject = new ModelAndView("index");
		searchEngineService.updateSearchEngine(searchEngine);
		String message = "Search Engine was successfully updated";
		mvObject.addObject("message", message);
		return mvObject;

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSearchEngine(@PathVariable Integer id) {
		ModelAndView mvObject = new ModelAndView("index");
		searchEngineService.deleteSearchEngine(id);
		String message = "Search Engine was successfully deleted";
		mvObject.addObject("message", message);
		return mvObject;
	}

	@RequestMapping(value = "/newSearchEngine", method = RequestMethod.GET)
	public ModelAndView newSearchEngine() {
		ModelAndView mvObject = new ModelAndView("newSearchEngine");
		mvObject.addObject("command", new SearchEngine());
		return mvObject;

	}

	@RequestMapping(value = "/addSearchEngine", method = RequestMethod.POST)
	public ModelAndView addSearchEngine(@ModelAttribute SearchEngine searchEngine) {
		ModelAndView mvObject = new ModelAndView("index");
		searchEngineService.addSearchEngine(searchEngine);
		String message = "Search Engine was successfully added";
		mvObject.addObject("message", message);
		return mvObject;
	}

}
