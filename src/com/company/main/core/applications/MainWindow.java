package com.company.main.core.applications;

import com.company.main.core.elements.Button;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements Window {
	private JFrame frame;
	private JPanel panel;

	public MainWindow(String name, int width, int height) {
		init(name, width, height);
	}

	@Override
	public void setButton() {
		Button add = new Button(10,10,75,25,"Add");
		panel.add(add);
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NoteWindow nw = new NoteWindow("Add Note - NameLess", 400, 600);
			}
		};
		add.addActionListener(actionListener);
	}

	@Override
	public void setPanel() {
		panel = new JPanel();
		panel.setLayout(null);
	}

	@Override
	public void init(String name, Integer width, Integer height) {
		setDecoration();
		frame = new JFrame(name);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();
		setButton();
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
