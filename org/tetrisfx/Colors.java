package org.tetrisfx;

import javafx.scene.paint.Color;

public enum Colors {
	
	Test(new Color(0.5, 0.5, 0.6, 1)),
	Pink(new Color(0.8, 0.5, 0.6, 1)),
	Black(new Color(0, 0, 0, 1)),
	
	/*TBS(new Color(0.925, 0.815, 0.470, 1)),
	TB(new Color(0.850, 0.357, 0.263, 1)),
	TL(new Color(0.752, 0.161, 0.259, 1)),
	TYW(new Color(0.330, 0.141, 0.217, 1)),
	TL2(new Color(0.326, 0.467, 0.478, 1))*/
	TBS(new Color(0.333, 0.384, 0.439, 1)),
	TB(new Color(0.306, 0.804, 0.769, 1)),
	TL(new Color(0.780, 0.957, 0.392, 1)),
	TYW(new Color(0.941, 0.392, 0.392, 1)),
	TL2(new Color(0.769, 0.302, 0.345, 1))
	;
	
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
