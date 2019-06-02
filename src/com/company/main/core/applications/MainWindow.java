package com.company.main.core.applications;

import com.company.main.core.elements.Button;
import com.company.main.core.elements.Field;
import com.company.main.core.elements.Label;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class MainWindow extends Thread implements Window {
	private JFrame frame;
	private JPanel panel;
	private String[] files;
	private JList list;
	private JTextArea area;
	private Field text;
	private Label main;
	private String name = "Untitled";

	public MainWindow(int width, int height) {
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
		deleteFormatTxt();
	}

	public void deleteFormatTxt() {
		String format = ".txt";
		for (int i = 0; i < files.length; i++) {
			StringBuffer buffer = new StringBuffer(files[i]);
			files[i] = buffer.delete(buffer.length() - format.length(), buffer.length()).toString();
		}
	}

	@Override
	public void setButton() {
		Button add = new Button(10, 10, 75,25,"Add");
		panel.add(add);
		add(add);

		Button save = new Button(100,10,75,25,"Save");
		panel.add(save);
		save(save);

		Button delete = new Button(190
				, 10, 75, 25, "Delete");
		panel.add(delete);
		delete(delete);
	}

	public void add(Button add) {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText("Untitled");
				area.setText("");
				main.setText("Created");
			}
		};
		add.addActionListener(actionListener);
	}

	public void  delete(Button delete) {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.gc();
				String title = text.getText();
				File file = new File(title + ".txt");
				if (file.delete())
					updateList();
					main.setText("Deleted");
			}
		};
		delete.addActionListener(actionListener);
	}

	public void save(Button save) {
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.gc();
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
				updateList();
				main.setText("Saved");
			}
		};
		save.addActionListener(actionListener);
	}

	public void updateList() {
		getFileTxt();
		DefaultListModel model = new DefaultListModel();
		for (int i = 0; i < files.length; i++) {
			model.add(i, files[i]);
		}
		list.setModel(model);
	}

	public void setList() {
		list = new JList(files);
		list.setBounds(10, 50, 125, 500);
		list.setBorder(new LineBorder(Color.BLACK));
		getIndexList();
		panel.add(list);
	}

	public void getIndexList() {
		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (files.length > 0) {
					System.gc();
					String title = files[list.getSelectedIndex()];
					name = title;
					changeTitle(name);
					setTitle(title);
					try {
						setText(title);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		list.addListSelectionListener(listSelectionListener);
	}

	public void setTitle(String title) {
		text.setText(title);
	}

	public void setText(String title) throws IOException {
		File file = new File(title + ".txt");
		String txt = "";
		Scanner sc = new Scanner(file);
		while (sc.hasNextLine()) {
			txt += sc.nextLine() + "\n";
		}
		area.setText(txt);
	}

	public void replaceTxt(String title) {
		String[] array = title.split(".");
		text.setText(title);
	}

	public void setTextArea() {
		area = new JTextArea();
		area.setFont(new Font("Dialog", Font.PLAIN, 14));
		area.setBorder(new LineBorder(Color.BLACK));
		area.setTabSize(10);
		area.setLineWrap(true);
		area.setWrapStyleWord(true);
		area.setBounds(150, 90,325,460);
		panel.add(area);
	}

	public void setTitleField() {
		text = new Field(150, 50, 325, 25);
		text.setText("Untitled");
		panel.add(text);

	}

	public void setLabel() {
		Label status = new Label(280, 15, "Status: ");
		panel.add(status);

		main = new Label(330, 15, "None");
		panel.add(main);

	}

	@Override
	public void setPanel() {
		panel = new JPanel();
		panel.setLayout(null);
	}

	public void changeTitle(String name) {
		frame.setTitle("NameLess NoteBook - " + name);
	}

	@Override
	public void init(String name, Integer width, Integer height) {
		setDecoration();
		frame = new JFrame("NameLess NoteBook - " + name);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPanel();
		setButton();
		getFileTxt();
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