package com.GameEngine.Core;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.GameEngine.Objects.GameObject;

public class Input extends KeyAdapter implements MouseListener {
	
	public static final Input instance = new Input();
	
	public static final int NUM_KEYCODES = 525;
	public static final int NUM_MOUSEBUTTONS = 5;
	public static final int MOUSE_PRESS = 0;
	public static final int MOUSE_RELEASE = 1;
	public static final int MOUSE_HOLD = 2;
	
	public static final String Mouse_Left_Press = "Mouse_Left_Press";
	public static final String Mouse_Left_Release = "Mouse_Left_Release";
	public static final String Mouse_Left_Hold = "Mouse_Left_Hold";
	public static final String Mouse_Mid_Press = "Mouse_Mid_Press";
	public static final String Mouse_Mid_Release = "Mouse_Mid_Release";
	public static final String Mouse_Mid_Hold = "Mouse_Mid_Hold";
	public static final String Mouse_Right_Press = "Mouse_Right_Press";
	public static final String Mouse_Right_Release = "Mouse_Right_Release";
	public static final String Mouse_Right_Hold = "Mouse_Right_Hold";
	
	private boolean[] lastKeys = new boolean[NUM_KEYCODES];
	private boolean[] keys = new boolean[NUM_KEYCODES];
	private boolean[] lastMouse = new boolean[NUM_MOUSEBUTTONS];
	private boolean[] mouse = new boolean[NUM_MOUSEBUTTONS];
	
	public static Window window;
	
	public void tick() {
		for (int i = 0; i < NUM_KEYCODES; i++)
			lastKeys[i] = isKeyDown(i);
		for (int i = 0; i < NUM_MOUSEBUTTONS; i++)
			lastMouse[i] = isMouseDown(i);
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mousePressed(MouseEvent e) {
		mouse[e.getButton()] = true;
	}
	
	public void mouseReleased(MouseEvent e) {
		mouse[e.getButton()] = false;
	}
	
	public boolean mousePressed(int MouseCode) {
		return isMouseDown(MouseCode) && !lastMouse[MouseCode];
	}
	
	public boolean mouseReleased(int MouseCode) {
		return !isMouseDown(MouseCode) && lastMouse[MouseCode];
	}
	
	public static Point MousePos() {
		if (window != null) {
			Point point = window.getFrame().getMousePosition();
			if (point != null) {
				point.x -= 1;
				point.y -= 23;
			}else
				point = new Point(-100, -100);
			return point;
		}else
			return new Point(-100, -100);
	}
	
	public static void setMousePos(int x, int y) {
		try {
			Robot r = new Robot();
			r.mouseMove(x + window.getFrame().getX() + 1, y + window.getFrame().getY() + 23);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public boolean keyPressed(int keyCode) {
		return isKeyDown(keyCode) && !lastKeys[keyCode];
	}
	
	public boolean keyReleased(int keyCode) {
		return !isKeyDown(keyCode) && lastKeys[keyCode];
	}
	
	public boolean isMouseDown(int mouseCode) {
		return mouse[mouseCode];
	}
	
	public boolean isKeyDown(int keyCode) {
		return keys[keyCode];
	}
	
	public boolean isObjectHeld(int mouseCode, GameObject object){
		if(isMouseDown(mouseCode)){
			Point mousePos = MousePos();
			if(mousePos.x > object.getX() && mousePos.x < object.getX() + object.getWidth()){
				if(mousePos.y > object.getY() && mousePos.y < object.getY() + object.getHeight()){
					return true;
				}else
					return false;
			}else
				return false;
		}else
			return false;
	}
	
	public boolean isObjectPressed(int mouseCode, GameObject object){
		if(mousePressed(mouseCode)){
			Point mousePos = MousePos();
			if(mousePos.x > object.getX() && mousePos.x < object.getX() + object.getWidth()){
				if(mousePos.y > object.getY() && mousePos.y < object.getY() + object.getHeight()){
					return true;
				}else
					return false;
			}else
				return false;
		}else
			return false;
	}
	
	public boolean isObjectReleased(int mouseCode, GameObject object){
		if(mouseReleased(mouseCode)){
			Point mousePos = MousePos();
			if(mousePos.x > object.getX() && mousePos.x < object.getX() + object.getWidth()){
				if(mousePos.y > object.getY() && mousePos.y < object.getY() + object.getHeight()){
					return true;
				}else
					return false;
			}else
				return false;
		}else
			return false;
	}
	
	public static final int MOUSE_LEFT = 1;
	public static final int MOUSE_MID = 2;
	public static final int MOUSE_RIGHT = 3;
	
	public static final int VK_ENTER = '\n';
	public static final int VK_BACK_SPACE = '\b';
	public static final int VK_TAB = '\t';
	public static final int VK_CANCEL = 0x03;
	public static final int VK_CLEAR = 0x0C;
	public static final int VK_SHIFT = 0x10;
	public static final int VK_CONTROL = 0x11;
	public static final int VK_ALT = 0x12;
	public static final int VK_PAUSE = 0x13;
	public static final int VK_CAPS_LOCK = 0x14;
	public static final int VK_ESCAPE = 0x1B;
	public static final int VK_SPACE = 0x20;
	public static final int VK_PAGE_UP = 0x21;
	public static final int VK_PAGE_DOWN = 0x22;
	public static final int VK_END = 0x23;
	public static final int VK_HOME = 0x24;
	public static final int VK_LEFT = 0x25;
	public static final int VK_UP = 0x26;
	public static final int VK_RIGHT = 0x27;
	public static final int VK_DOWN = 0x28;
	public static final int VK_COMMA = 0x2C;
	public static final int VK_MINUS = 0x2D;
	public static final int VK_PERIOD = 0x2E;
	public static final int VK_SLASH = 0x2F;
	public static final int VK_0 = 0x30;
	public static final int VK_1 = 0x31;
	public static final int VK_2 = 0x32;
	public static final int VK_3 = 0x33;
	public static final int VK_4 = 0x34;
	public static final int VK_5 = 0x35;
	public static final int VK_6 = 0x36;
	public static final int VK_7 = 0x37;
	public static final int VK_8 = 0x38;
	public static final int VK_9 = 0x39;
	public static final int VK_SEMICOLON = 0x3B;
	public static final int VK_EQUALS = 0x3D;
	public static final int VK_A = 0x41;
	public static final int VK_B = 0x42;
	public static final int VK_C = 0x43;
	public static final int VK_D = 0x44;
	public static final int VK_E = 0x45;
	public static final int VK_F = 0x46;
	public static final int VK_G = 0x47;
	public static final int VK_H = 0x48;
	public static final int VK_I = 0x49;
	public static final int VK_J = 0x4A;
	public static final int VK_K = 0x4B;
	public static final int VK_L = 0x4C;
	public static final int VK_M = 0x4D;
	public static final int VK_N = 0x4E;
	public static final int VK_O = 0x4F;
	public static final int VK_P = 0x50;
	public static final int VK_Q = 0x51;
	public static final int VK_R = 0x52;
	public static final int VK_S = 0x53;
	public static final int VK_T = 0x54;
	public static final int VK_U = 0x55;
	public static final int VK_V = 0x56;
	public static final int VK_W = 0x57;
	public static final int VK_X = 0x58;
	public static final int VK_Y = 0x59;
	public static final int VK_Z = 0x5A;
	public static final int VK_OPEN_BRACKET = 0x5B;
	public static final int VK_BACK_SLASH = 0x5C;
	public static final int VK_CLOSE_BRACKET = 0x5D;
	public static final int VK_NUMPAD0 = 0x60;
	public static final int VK_NUMPAD1 = 0x61;
	public static final int VK_NUMPAD2 = 0x62;
	public static final int VK_NUMPAD3 = 0x63;
	public static final int VK_NUMPAD4 = 0x64;
	public static final int VK_NUMPAD5 = 0x65;
	public static final int VK_NUMPAD6 = 0x66;
	public static final int VK_NUMPAD7 = 0x67;
	public static final int VK_NUMPAD8 = 0x68;
	public static final int VK_NUMPAD9 = 0x69;
	public static final int VK_MULTIPLY = 0x6A;
	public static final int VK_ADD = 0x6B;
	public static final int VK_SEPARATER = 0x6C;
	public static final int VK_SEPARATOR = VK_SEPARATER;
	public static final int VK_SUBTRACT = 0x6D;
	public static final int VK_DECIMAL = 0x6E;
	public static final int VK_DIVIDE = 0x6F;
	public static final int VK_DELETE = 0x7F; /* ASCII DEL */
	public static final int VK_NUM_LOCK = 0x90;
	public static final int VK_SCROLL_LOCK = 0x91;
	public static final int VK_F1 = 0x70;
	public static final int VK_F2 = 0x71;
	public static final int VK_F3 = 0x72;
	public static final int VK_F4 = 0x73;
	public static final int VK_F5 = 0x74;
	public static final int VK_F6 = 0x75;
	public static final int VK_F7 = 0x76;
	public static final int VK_F8 = 0x77;
	public static final int VK_F9 = 0x78;
	public static final int VK_F10 = 0x79;
	public static final int VK_F11 = 0x7A;
	public static final int VK_F12 = 0x7B;
	public static final int VK_PRINTSCREEN = 0x9A;
	public static final int VK_INSERT = 0x9B;
	public static final int VK_HELP = 0x9C;
	public static final int VK_META = 0x9D;
	public static final int VK_BACK_QUOTE = 0xC0;
	public static final int VK_QUOTE = 0xDE;
	public static final int VK_KP_UP = 0xE0;
	public static final int VK_KP_DOWN = 0xE1;
	public static final int VK_KP_LEFT = 0xE2;
	public static final int VK_KP_RIGHT = 0xE3;
	public static final int VK_AMPERSAND = 0x96;
	public static final int VK_ASTERISK = 0x97;
	public static final int VK_QUOTEDBL = 0x98;
	public static final int VK_LESS = 0x99;
	public static final int VK_GREATER = 0xa0;
	public static final int VK_BRACELEFT = 0xa1;
	public static final int VK_BRACERIGHT = 0xa2;
	public static final int VK_AT = 0x0200;
	public static final int VK_COLON = 0x0201;
	public static final int VK_CIRCUMFLEX = 0x0202;
	public static final int VK_DOLLAR = 0x0203;
	public static final int VK_EURO_SIGN = 0x0204;
	public static final int VK_EXCLAMATION_MARK = 0x0205;
	public static final int VK_INVERTED_EXCLAMATION_MARK = 0x0206;
	public static final int VK_LEFT_PARENTHESIS = 0x0207;
	public static final int VK_NUMBER_SIGN = 0x0208;
	public static final int VK_PLUS = 0x0209;
	public static final int VK_RIGHT_PARENTHESIS = 0x020A;
	public static final int VK_UNDERSCORE = 0x020B;
	public static final int VK_WINDOWS = 0x020C;
	public static final int VK_CONTEXT_MENU = 0x020D;
	
	public static Input getInstance() {
		return instance;
	}
}
