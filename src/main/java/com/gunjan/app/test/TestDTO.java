package com.gunjan.app.test;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.gunjan.app.questions.QuestionsDTO;

@Component
public class TestDTO {
	
	private int duration;
	private int totalMarks;
	private int score;
	private Map<Integer,QuestionsDTO> map;
	
	public Map<Integer, QuestionsDTO> getMap() {
		return map;
	}
	public void setMap(Map<Integer, QuestionsDTO> map) {
		this.map = map;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
