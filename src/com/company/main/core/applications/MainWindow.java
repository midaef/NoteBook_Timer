package com.company.main.core.applications;

import com.company.main.core.elements.Button;
import com.company.main.core.elements.Field;
import com.company.main.core.elements.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements Window {
	private JFrame frame;
	private JPanel panel;
	private String[] titles = {"List"};
	private JList list;

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

	public void setList() {
		list = new JList(titles);
		list.setBounds(10, 50, 125, 500);
		panel.add(list);
	}

	public void setTextArea() {
		JTextArea area = new JTextArea();
		area.setText("Your Note");
		area.setFont(new Font("Dialog", Font.PLAIN, 14));
		area.setTabSize(10);
		area.setBounds(150, 90,325,460);
		panel.add(area);
	}

	public void setTitleField() {
		Field text = new Field(150, 50, 325, 25);
		text.setText("Untitled");
		panel.add(text);

		Field h = new Field(175, 560, 30, 20);
		panel.add(h);

		Field m = new Field(243, 560, 30, 20);
		panel.add(m);

		Field s = new Field(308, 560, 30, 20);
		panel.add(s);
	}

	public void setLabel() {
		Label h = new Label(150, 560, "H:");
		panel.add(h);

		Label m = new Label(215, 560, "M:");
		panel.add(m);

		Label s = new Label(283, 560, "S:");
		panel.add(s);
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
		setList();
		setTextArea();
		setTitleField();
		setLabel();
		frame.add(panel);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
