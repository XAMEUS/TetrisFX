package org.tetrisfx;

import javafx.scene.paint.Color;

public enum Tetromino {
	
	TypeI(4, 4, 1, Colors.TL2.getColor(), new boolean[][] {
		{
			false,	false,	false,	false,
			true,	true,	true,	true,
			false,	false,	false,	false,
			false,	false,	false,	false,
		},
		{
			false,	false,	true,	false,
			false,	false,	true,	false,
			false,	false,	true,	false,
			false,	false,	true,	false,
		},
		{
			false,	false,	false,	false,
			false,	false,	false,	false,
			true,	true,	true,	true,
			false,	false,	false,	false,
		},
		{
			false,	true,	false,	false,
			false,	true,	false,	false,
			false,	true,	false,	false,
			false,	true,	false,	false,
		}
	}),
	
	TypeJ(3, 3, 2, Colors.TB.getColor(), new boolean[][] {
		{
			true,	false,	false,
			true,	true,	true,
			false,	false,	false,
		},
		{
			false,	true,	true,
			false,	true,	false,
			false,	true,	false,
		},
		{
			false,	false,	false,
			true,	true,	true,
			false,	false,	true,
		},
		{
			false,	true,	false,
			false,	true,	false,
			true,	true,	false,
		}
	}),
	
	TypeL(3, 3, 2, Colors.TB.getColor(), new boolean[][] {
		{
			false,	false,	true,
			true,	true,	true,
			false,	false,	false,
		},
		{
			false,	true,	false,
			false,	true,	false,
			false,	true,	true,
		},
		{
			false,	false,	false,
			true,	true,	true,
			true,	false,	false,
		},
		{
			true,	true,	false,
			false,	true,	false,
			false,	true,	false,
		}
	}),
	
	TypeO(2, 2, 2, Colors.TBS.getColor(), new boolean[][] {
		{
			true,	true,
			true,	true,
		},
		{
			true,	true,
			true,	true,
		},
		{	
			true,	true,
			true,	true,
		},
		{
			true,	true,
			true,	true,
		}
	}),
	
	TypeS(3, 3, 2, Colors.TYW.getColor(), new boolean[][] {
		{
			false,	true,	true,
			true,	true,	false,
			false,	false,	false,
		},
		{
			false,	true,	false,
			false,	true,	true,
			false,	false,	true,
		},
		{
			false,	false,	false,
			false,	true,	true,
			true,	true,	false,
		},
		{
			true,	false,	false,
			true,	true,	false,
			false,	true,	false,
		}
	}),
	
	TypeT(3, 3, 2, Colors.TL.getColor(), new boolean[][] {
		{
			false,	true,	false,
			true,	true,	true,
			false,	false,	false,
		},
		{
			false,	true,	false,
			false,	true,	true,
			false,	true,	false,
		},
		{
			false,	false,	false,
			true,	true,	true,
			false,	true,	false,
		},
		{
			false,	true,	false,
			true,	true,	false,
			false,	true,	false,
		}
	}),

	TypeZ(3, 3, 2, Colors.TYW.getColor(), new boolean[][] {
		{
			true,	true,	false,
			false,	true,	true,
			false,	false,	false,
		},
		{
			false,	false,	true,
			false,	true,	true,
			false,	true,	false,
		},
		{
			false,	false,	false,
			true,	true,	false,
			false,	true,	true,
		},
		{
			false,	true,	false,
			true,	true,	false,
			true,	false,	false,
		}
	});
	
	private int dimension;
	private int cols;
	private int rows;
	private boolean[][] tiles;
	private int spawnCol;
	private int spawnRow;
	
	private Color baseColor;
	private Color lightColor;
	private Color darkColor;
	
	private Tetromino(int dimension, int cols, int rows, Color color, boolean[][] tiles) {
		
		this.dimension = dimension;
		this.cols = cols;
		this.rows = rows;
		this.tiles = tiles;

		this.baseColor = color;
		this.lightColor = color.brighter();
		this.darkColor = color.darker();
		
		this.spawnCol = 5 - dimension/2;
		this.spawnRow = getTopInset(0);
	}
	
	public boolean isTetromino(int i, int j, int rotation) {
		return this.tiles[rotation][j * this.dimension + i];
	}
	
	public int getTopInset(int rotation) {
		for(int j = 0; j < dimension; j++)
			for(int i = 0; i < dimension; i++)
				if(this.isTetromino(i, j, rotation))
					return j;
		return -1;
	}
	
	public int getLeftInset(int rotation) {
		for(int i = 0; i < dimension; i++)
			for(int j = 0; j < dimension;j++)
				if(this.isTetromino(i, j, rotation))
					return i;
		return -1;
	}
	
	public int getBottomInset(int rotation) {
		for(int j = dimension - 1; j >= 0; j--)
			for(int i = 0; i < dimension; i++)
				if(this.isTetromino(i, j, rotation))
					return dimension - j;
		return -1;
	}
	
	public int getRightInset(int rotation) {
		for(int i = dimension - 1; i >= 0; i--)
			for(int j = 0; j < dimension; j++)
				if(this.isTetromino(i, j, rotation))
					return dimension - i;
		return -1;
	}

	public int getDimension() {
		return this.dimension;
	}
	
	public int getCol() {
		return this.cols;
	}
	
	public int getRows() {
		return this.rows;
	}
	
	public int getSpawnColumn() {
		return spawnCol;
	}
	
	public int getSpawnRow() {
		return spawnRow;
	}
	
	public Color getBaseColor() {
		return this.baseColor;
	}
	
	public Color getLightColor() {
		return this.lightColor;
	}
	
	public Color getDarkColor() {
		return this.darkColor;
	}
}
