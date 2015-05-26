package com.FOEVERGOD73.Core;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {
	private JFrame frame;

		public Window(int w, int h, String title, boolean autostart, CoreEngine coreEngine){
			coreEngine.setPreferredSize(new Dimension(w, h));
			coreEngine.setMaximumSize(new Dimension(w, h));
			coreEngine.setMinimumSize(new Dimension(w, h));
			
			frame = new JFrame(title);
			frame.add(coreEngine);
			frame.pack();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			if(autostart)
				coreEngine.start();
		}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
}
