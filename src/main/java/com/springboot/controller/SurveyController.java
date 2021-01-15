package com.springboot.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.model.Question;
import com.springboot.service.SurveyService;

@RestController
public class SurveyController {

	@Autowired
	private SurveyService surveyService;

	// "/surveys/{surveyId}/questions"
	// GET
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retriveQuestionsForSurvey(@PathVariable String surveyId) {
		System.out.println("Service is called..");
		return surveyService.retrieveQuestions(surveyId);
	}

	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> addQuestionSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion) {
		// What should be the structure of request body ?
		/**
		 * {"description":"Second Most Populous Country in the
		 * World","correctAnswer":"India", "options":["India","Russia","United
		 * States","China"]}
		 */
		// How will be mapped to Question Object?
		/**
		 * Using : @RequestBody()
		 */
		// What should be returned.
		// What should be response Status

		System.out.println("Service is called..");
		Question question = surveyService.addQuestion(surveyId, newQuestion);
		//Success - URI of the new resource created in Response Header 
		//Status  - Created 
		//URI  	  - /surveys/{surveyId}/questions
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(question.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retriveDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		System.out.println("Service is called..");
		return surveyService.retrieveQuestion(surveyId, questionId);
	}

}
