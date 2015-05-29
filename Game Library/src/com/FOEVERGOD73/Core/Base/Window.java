package com.FOEVERGOD73.Core.Base;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.FOEVERGOD73.Core.Render.RenderEngine;

public class Window {
	private JFrame frame;

		public Window(int w, int h, String title, boolean autostart, RenderEngine renderEngine, CoreEngine coreEngine){
			renderEngine.setPreferredSize(new Dimension(w, h));
			renderEngine.setMaximumSize(new Dimension(w, h));
			renderEngine.setMinimumSize(new Dimension(w, h));
			
			frame = new JFrame(title);
			frame.add(renderEngine);
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
