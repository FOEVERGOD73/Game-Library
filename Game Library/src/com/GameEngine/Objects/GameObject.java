package com.GameEngine.Objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

import com.GameEngine.Components.GameComponent;
import com.GameEngine.Core.Nameable;

public class GameObject extends Nameable {
	protected double x, y, width, height;
	protected GameObject parent;
	public String name;
	protected LinkedList<GameObject> children = new LinkedList<GameObject>();
	protected LinkedList<GameComponent> components = new LinkedList<GameComponent>();
	
	public GameObject() {
	}
	
	public GameObject(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void init(){}
	
	public void tickh() {
		while (true)
			try {
				for (GameObject child : getChildren()) {
					child.tickh();
				}
				break;
			} catch (ConcurrentModificationException e) {
				continue;
			}
		while (true)
			try {
				for (GameComponent component : components) {
					component.tick();
				}
				break;
			} catch (ConcurrentModificationException e) {
				continue;
			}
		tick();
	}
	
	public void renderh(Graphics g) {
		for (GameObject child : getChildren()) {
			child.renderh(g);
		}
		for (GameComponent component : components) {
			component.render(g);
		}
		render(g);
	}
	
	public void callBack(String name, String... args) {
		
	}
	
	public GameObject searchChildByName(String name) {
		for (GameObject child : children)
			if (child.name.equals(name))
				return child;
		return null;
	}
	
	public GameObject getChild(int index) {
		return getChildren().get(index);
	}
	
	public void addChild(GameObject child, String name) {
		child.setParent(this);
		child.name = name;
		getChildren().add(child);
		child.init();
	}
	
	public void removeChild(GameObject child) {
		getChildren().remove(child);
	}
	
	public void removeChild(int index) {
		children.remove(index);
	}
	
	public GameComponent searchComponentByName(String name) {
		for (GameComponent component : components)
			if (component.name.equals(name))
				return component;
		return null;
	}
	
	public void addComponent(GameComponent component) {
		component.setParent(this);
		components.add(component);
	}
	
	public void removeComponent(GameComponent component) {
		components.remove(component);
	}
	
	public void clear() {
		children.clear();
		components.clear();
	}
	
	public void tick() {
	}
	
	public void render(Graphics g) {
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getWidth() {
		return width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public GameObject getParent() {
		return parent;
	}
	
	public void setParent(GameObject parent) {
		this.parent = parent;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
	public Rectangle getBounds2() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
	public Rectangle getBounds3() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
	public Rectangle getBounds4() {
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}
	
	public LinkedList<GameObject> getChildren() {
		return children;
	}
	
	public void setChildren(LinkedList<GameObject> children) {
		this.children = children;
	}
}
