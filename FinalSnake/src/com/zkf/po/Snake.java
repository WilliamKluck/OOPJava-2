/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.po;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.zkf.util.Config;

public class Snake {
	
	Node head;
	Node body;
	Node tail;
	Food food;
	
	public Snake(Food food) {
		this.food = food;
		head = new Node(7, 13, Config.RIGHT);
		body = new Node(7, 12, Config.RIGHT);
		tail = new Node(7, 11, Config.RIGHT);
	
		head.next = body;
		body.next = tail;
		tail.pre = body;
		body.pre = head;
		
	}
	public void draw(Graphics g) {
		for(Node n = head;n!= null;n = n.next) {
			n.draw(g);
		}
		
	}
	public void move() {

		addHead();
		
		if(!isEat()) {
			removeTail();
		}
		checkDeath();
		}
	
	private void checkDeath() {
		if(head.col<0) {
			head.col=34;
			return;
		}
		if(head.col>34) {
			head.col=0;
			return;
		}
		if(head.row<0) {
			head.row=21;
			return;
		}
		if(head.row>21) {
			head.row=0;
			return;
		}
		
		for(Node node = head.next;node!=null;node = node.next) {
			if(node.col == head.col&&node.row == head.row) {
				//死亡
				Config.isLive = false;
				return;
			}
		}
		
				if(head.row>=3&&head.row<=5&&head.col<=7&&head.col>=5) {
					Config.isLive=false;
					return;
				}
				if(head.row>=16&&head.row<=18&&head.col<=7&&head.col>=5) {
					Config.isLive=false;
					return;
				}
				if(head.row>=3&&head.row<=5&&head.col<=29&&head.col>=27) {
					Config.isLive=false;
					return;
				}
				if(head.row>=16&&head.row<=18&&head.col<=29&&head.col>=27) {
					Config.isLive=false;
					return;
				}
		
	}
	
	private void removeTail() {
		tail.pre.next = null;
		tail = tail.pre; 
	}
	
	public boolean isEat() {
		if(getRect().intersects(food.getRect())) {
			Config.score++;
			if(Config.score%2 == 0&&Config.SleepTime>100) {
				Config.SleepTime-=100;
			}
			food.repair();
			return true;
		}
		return false;
	}
	
	public Rectangle getRect() {
		return new Rectangle(head.col*Config.SPAN, head.row*Config.SPAN,Config.SPAN, Config.SPAN);
	}
	
	private void addHead() {
		Node node = null;
		switch(head.dir) {
		case Config.UP:
			node = new Node(head.row-1, head.col, head.dir);
			break;
		case Config.DOWN:
			node = new Node(head.row+1, head.col, head.dir);
			break;	
		case Config.LEFT:
			node = new Node(head.row, head.col-1, head.dir);
			break;
		case Config.RIGHT:
			node = new Node(head.row, head.col+1, head.dir);
			break;
			
			default:
				break;
		}
		
		node.next = head;
		head.pre = node;
		head = node;
	}
	public void dirControl(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP://上
			if(!head.dir.equals(Config.DOWN)) {
				head.dir = Config.UP;
			}
			break;
		case KeyEvent.VK_DOWN:
			if(!head.dir.equals(Config.UP)) {
				head.dir = Config.DOWN;
			}
			break;
		case KeyEvent.VK_LEFT:
			if(!head.dir.equals(Config.RIGHT)) {
				head.dir = Config.LEFT;
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(!head.dir.equals(Config.LEFT)) {
				head.dir = Config.RIGHT;
			}
			break;
	
		default:
			break;
		}
	}
}
