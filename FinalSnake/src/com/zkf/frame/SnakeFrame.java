/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.frame;

import javax.swing.JFrame;

import com.zkf.panel.ButtonPanel;
import com.zkf.panel.SnakePanel;
//game frame
public class SnakeFrame extends BaseFrame{

	//Create an instance of the game panel and button panel
	SnakePanel snakePanel = new SnakePanel();
	ButtonPanel buttonPanel = new ButtonPanel(snakePanel);
	
	
	
	public SnakeFrame(){
		//frame info
		initFrame();
		addComponents();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	private void addComponents() {
		//add game panel 
		this.add(snakePanel);
		
		
		//SnaekPanel
		snakePanel.setFocusable(true);
		snakePanel.requestFocus();
		
		
		//add control pannel 
		this.add(buttonPanel);
	}
	public static void main(String[] args) {
	    new SnakeFrame();
	}
}
