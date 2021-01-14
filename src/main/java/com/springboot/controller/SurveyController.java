package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.model.Question;
import com.springboot.service.SurveyService;

@Controller
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	// "/surveys/{surveyId}/questions"
	// GET
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retriveQuestionsForSurvey(@PathVariable String surveyId) {
		return surveyService.retrieveQuestions(surveyId);
	}

}
