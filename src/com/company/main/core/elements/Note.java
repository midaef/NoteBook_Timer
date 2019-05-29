package com.company.main.core.elements;

public class Note {
	private String title;
	private String note;

	public Note(String note) {
		this("Untitled", note);
	}

	public Note(String title, String note) {
		this.title = title;
		this.note = note;
	}
}
