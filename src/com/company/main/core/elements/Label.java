package com.company.main.core.elements;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
	private Integer x, y;
	private String name;

	public Label(Integer x, Integer y, String name) {
		this.setText(name);
		this.setBounds(x, y, name.length() * 20, 20);
		this.setFont(new Font("Dialog", Font.PLAIN, 20));
	}
}
