package org.tetrisfx;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Grid extends Pane {
	
	private Canvas canvas;
	
	private int TILE_SIZE = 31;
	private int SHADE_WIDTH = 5;
	
	public Grid() {
		this.canvas = new Canvas(302, 602);
		this.getChildren().add(this.canvas);
	}
	
	public void draw() {
		
		this.clear();

		final double width = this.canvas.getWidth();
    	final double height = this.canvas.getHeight();
    	
    	this.drawTile(Colors.Test.getColor(), Colors.Test.brighter(), Colors.Test.darker(), 150, 300);
    	
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setStroke(new Color(0.2, 0.3, 0.4, 0.2));
		for (int x = 0; x <= 10; x++) {
			gc.strokeLine(x*30+1, 0, x*30+1, height);
		}
		for (int y = 0; y <= 20; y++) {
			gc.strokeLine(1, y*30+1, width, y*30+1);
		}
		
	}
	
	public void clear() {
		
		final double width = this.canvas.getWidth();
    	final double height = this.canvas.getHeight();

    	GraphicsContext gc = this.canvas.getGraphicsContext2D();
		gc.setFill(new Color(0.9, 0.9, 0.9, 1));
		gc.setStroke(new Color(0.9, 0.9, 0.9, 1));
		gc.clearRect(0, 0, width, height);
		gc.fillRect(0, 0, width, height);
		gc.setLineWidth(1);
    	
	}
	
	private void drawTile(Color base, Color light, Color dark, int x, int y) {
		
		GraphicsContext gc = this.canvas.getGraphicsContext2D();
		
		gc.setFill(base);
		gc.fillRect(x, y, TILE_SIZE, TILE_SIZE);
		
		gc.setFill(dark);
		gc.fillRect(x, y + TILE_SIZE - SHADE_WIDTH, TILE_SIZE, SHADE_WIDTH);
		gc.fillRect(x + TILE_SIZE - SHADE_WIDTH, y, SHADE_WIDTH, TILE_SIZE);
		
		gc.setStroke(light);
		for(int i = 0; i < SHADE_WIDTH; i++) {
			gc.strokeLine(x, y + i, x + TILE_SIZE - i - 1, y + i);
			gc.strokeLine(x + i, y, x + i, y + TILE_SIZE - i - 1);
		}
	}
	
}
