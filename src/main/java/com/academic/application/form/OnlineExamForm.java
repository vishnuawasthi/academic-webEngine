package com.academic.application.form;

import java.io.Serializable;
import java.util.List;

public class OnlineExamForm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 355486898901717425L;

	private String question;
	private List<String> options;

	private boolean a;
	private boolean b;
	private boolean c;
	private boolean d;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public boolean isA() {
		return a;
	}
	public void setA(boolean a) {
		this.a = a;
	}
	public boolean isB() {
		return b;
	}
	public void setB(boolean b) {
		this.b = b;
	}
	public boolean isC() {
		return c;
	}
	public void setC(boolean c) {
		this.c = c;
	}
	public boolean isD() {
		return d;
	}
	public void setD(boolean d) {
		this.d = d;
	}
	
	

}
