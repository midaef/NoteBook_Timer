package com.company.main.core.applications;

import com.company.main.core.elements.Button;
import com.company.main.core.elements.Field;
import com.company.main.core.elements.Label;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainWindow implements Window {
	private JFrame frame;
	private JPanel panel;
	private String[] files;
	private JList list;
	private JTextArea area;
	private Field text;

	public MainWindow(String name, int width, int height) {
		init(name, width, height);
	}
	
	public void getFileTxt() {
		String path = System.getProperty("user.dir");
		File folder = new File(path);
		files = folder.list(new FilenameFilter() {
			@Override public boolean accept(File folder, String name) {
				return name.endsWith(".txt");
			}
		});
	}

	@Override
	public void setButton() {
		Button add = new Button(10,10,75,25,"Save");
		panel.add(add);
		save(add);
	}

	public void save(Button add) {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = text.getText();
				String text = area.getText();
				try {
					FileWriter writer = new FileWriter(title + ".txt");
					writer.write(text);
					writer.flush();
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		};
		add.addActionListener(actionListener);
	}

	public void setList() {
		list = new JList(files);
		list.setBounds(10, 50, 125, 500);
		panel.add(list);
	}

	public void setTextArea() {
		area = new JTextArea();
		area.setText("Your Note");
		area.setFont(new Font("Dialog", Font.PLAIN, 14));
		area.setTabSize(10);
		area.setBounds(150, 90,325,460);
		panel.add(area);
	}

	public void setTitleField() {
		text = new Field(150, 50, 325, 25);
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
		getFileTxt();
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
