/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.po;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Random;

import javax.swing.JPanel;

import com.zkf.util.Config;
import com.zkf.util.ImageUtil;

public class Barrier implements ImageObserver {
	Image bg_food;
	
	private int row;
	
	private int col;
	
	public Barrier(int x,int y) {
		initComponents();
		this.row=x;
		this.col=y;
	
	}
	private void initComponents() {
		bg_food=ImageUtil.getImage("img/food.png");
	}
	public void repair() {
		row=new Random().nextInt(Config.ROWS);
		col=new Random().nextInt(Config.CLOS);
		
			
	}

	public void draw(Graphics g) {
		g.drawImage(bg_food, col*Config.SPAN,row*Config.SPAN,Config.SPAN*3, Config.SPAN*3, this);
	}
	
	public Rectangle getRect() {
		return new Rectangle(col*Config.SPAN, row*Config.SPAN, Config.SPAN*3, Config.SPAN*3);
	}
	@Override
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
