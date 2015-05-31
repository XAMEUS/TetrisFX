package org.tetrisfx;

import javafx.scene.paint.Color;

public enum Colors {
	
	Test(new Color(0.5, 0.5, 0.6, 1)),
	Pink(new Color(1, 0.5, 0.6, 1)),
	Black(new Color(0, 0, 0, 1));
	
	private Color color;
	
	private Colors(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public Color brighter() {
		return this.color.brighter();
	}
	
	public Color darker() {
		return this.color.darker();
	}
	
}
