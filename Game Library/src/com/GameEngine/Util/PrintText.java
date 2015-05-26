package com.GameEngine.Util;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class PrintText {
	public static void printText(String text, int x, int y, boolean rightAlign, Font font, Graphics g) {
		if (font != null)
			g.setFont(font);
		if (rightAlign) {
			FontMetrics fontMetrics = g.getFontMetrics();
			g.drawString(text, x - fontMetrics.stringWidth(text), y);
		} else
			g.drawString(text, x, y);
	}
}
