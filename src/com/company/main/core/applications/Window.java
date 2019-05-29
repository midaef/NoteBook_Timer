package com.company.main.core.applications;

import com.company.main.core.elements.Button;
import javax.swing.*;

public interface Window {
	public void setButton();
	public void setPanel();
	public void init(String name, Integer width, Integer height);
	public default void setDecoration() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {}
	}
}
