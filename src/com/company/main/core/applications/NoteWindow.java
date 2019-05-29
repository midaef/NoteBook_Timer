package com.company.main.core.applications;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NoteWindow extends JFrame implements Window{
	private JFrame frame;
	private JPanel panel;

	public NoteWindow(String name, int width, int height) {
		init(name, width, height);
	}

	@Override
	public void setButton() {

	}

	@Override
	public void setPanel() {
		panel = new JPanel();
		panel.setLayout(null);
	}

	@Override
	public void init(String name, Integer width, Integer height) {
		setDecoration();
		setDecoration();
		frame = new JFrame(name);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();
//		setButton();
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
