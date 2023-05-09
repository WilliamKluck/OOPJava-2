/* Creators: Jiaze Li, Yosan Tesfay, William Kluck
 * 03/12/2022
 */

package com.zkf.frame;

import javax.swing.JFrame;

import com.zkf.util.ImageUtil;

public abstract class BaseFrame extends JFrame{
	
		public  void initFrame() {
			//Set the position x, y coordinates and width and height of the form
			this.setBounds(600,200,706,500);
			//set title
			this.setTitle("Pacman snake");
			//Image   -->ImageIcon -->getImage()
			this.setIconImage(ImageUtil.getImage("img/logo.png"));

			this.setLayout(null);

			this.setResizable(false);
			
		}
}
