package com.radio.Etity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Question 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String question;
	String opa;
	String opb;
	String opc;
	String opd;
	int answer;
	
	@ManyToMany(mappedBy = "questions")
	Set<Test> tests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOpa() {
		return opa;
	}

	public void setOpa(String opa) {
		this.opa = opa;
	}

	public String getOpb() {
		return opb;
	}

	public void setOpb(String opb) {
		this.opb = opb;
	}

	public String getOpc() {
		return opc;
	}

	public void setOpc(String opc) {
		this.opc = opc;
	}

	public String getOpd() {
		return opd;
	}

	public void setOpd(String opd) {
		this.opd = opd;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", opa=" + opa + ", opb=" + opb + ", opc=" + opc
				+ ", opd=" + opd + ", answer=" + answer + ", tests=" + tests + "]";
	}

	
	
}
