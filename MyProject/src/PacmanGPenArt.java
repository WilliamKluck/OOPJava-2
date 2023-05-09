/* @author: WILLIAM KLUCK 
 * @date: 12/03/2021 
 */
 import java.awt.Color;
import acm.program.*;
import acm.graphics.*;

public class PacmanGPenArt extends GraphicsProgram{

	private GPen pen;
	
	public final int APPLET_WIDTH = 1000;
	public final int APPLET_HEIGHT = 350; 
	
	public final Color YELLLOW = new Color(254, 254, 0);
	public final Color REDD = new Color(244, 0, 0);
	public final Color LAVENDER = new Color(249, 173, 255);
	public final Color AQUA = new Color(93, 255, 255);
	public final Color PASTELORANGE = new Color(248, 178, 0);
	public final Color LIGHTBLUE = new Color(29, 15, 255);
	
	public void init() {
			
			setSize(APPLET_WIDTH, APPLET_HEIGHT); // set the initial window size 
		}
	
	public void run() {
		
		
		// declare a variable for our GPen
		// and initialized to a new GPen object
		pen = new GPen();
		add(pen);  // adds the pen object to our applet
		
		// background color
		pen.setFillColor(Color.BLACK);  // set the background color to orange
		pen.startFilledRegion(); // start the background fill
		pen.drawLine(APPLET_WIDTH*2, 0);
		pen.drawLine(0, APPLET_HEIGHT*2);
		pen.drawLine(-APPLET_WIDTH*2, 0);
		pen.drawLine(0, -APPLET_HEIGHT*2);
		pen.endFilledRegion(); // end the background fill
		
		//sets the location for the Pacman
		pen.setLocation(APPLET_WIDTH/20, APPLET_HEIGHT/4);
			
		///start Pacman
		int pacSize = 4;
		double pacWidth = 39 * pacSize;
		double pacHeight = 39 * pacSize;
		
		pen.setFillColor(YELLLOW);
		
		pen.startFilledRegion();
		pen.move(pacWidth*3/13,0);
		
		pen.drawLine(pacWidth*5/13, 0);
		pen.drawLine(0, pacHeight*1/13);
		pen.drawLine(pacWidth*2/13, 0);
		pen.drawLine(0, pacHeight*1/13);
		pen.drawLine(pacWidth*1/13, 0);
		pen.drawLine(0, pacHeight*2/13);
		pen.drawLine(pacWidth*1/13, 0);
		pen.drawLine(0, pacHeight*5/13);
		//reversal width
		pen.drawLine(pacWidth*-1/13, 0);
		pen.drawLine(0, pacHeight*2/13);
		pen.drawLine(pacWidth*-1/13, 0);
		pen.drawLine(0, pacHeight*1/13);
		pen.drawLine(pacWidth*-2/13, 0);
		pen.drawLine(0, pacHeight*1/13);
		pen.drawLine(pacWidth*-5/13, 0);
		//reversal height
		pen.drawLine(0, pacHeight*-1/13);
		pen.drawLine(pacWidth*-2/13, 0);
		pen.drawLine(0, pacHeight*-1/13);
		pen.drawLine(pacWidth*-1/13, 0);
		pen.drawLine(0, pacHeight*-2/13);
		//mouth bottom
		pen.drawLine(pacWidth*2/13, 0);
		pen.drawLine(0, pacHeight*-1/13);
		pen.drawLine(pacWidth*3/13, 0);
		pen.drawLine(0, pacHeight*-1/13);
		pen.drawLine(pacWidth*3/13, 0);
		pen.drawLine(0, pacHeight*-1/13);
		//mouth top
		pen.drawLine(pacWidth*-3/13, 0);
		pen.drawLine(0, pacHeight*-1/13);
		pen.drawLine(pacWidth*-3/13, 0);
		pen.drawLine(0, pacHeight*-1/13);
		pen.drawLine(pacWidth*-2/13, 0);
		pen.drawLine(0, pacHeight*-2/13);
		//reverse width
		pen.drawLine(pacWidth*1/13, 0);
		pen.drawLine(0, pacHeight*-1/13);
		pen.drawLine(pacWidth*2/13, 0);
		
		pen.endFilledRegion();
			

		Color[] C = {REDD, LAVENDER, AQUA, PASTELORANGE};
		double location = 4.5;
		for(int i = 0; i < C.length; i++) {
			
			pen.setLocation(APPLET_WIDTH*location/20, APPLET_HEIGHT/4 - 8);
			
			int ghostSize = 4;
			double ghostWidth = 42 * ghostSize;
			double ghostHeight = 42 * ghostSize;
			
			pen.setFillColor(C[i]);
			
			pen.startFilledRegion();
			//start on top head
			pen.move(ghostWidth*5/14, 0);
			
			pen.drawLine(ghostWidth*4/14, 0);
			pen.drawLine(0, ghostHeight*1/14);
			pen.drawLine(ghostWidth*2/14, 0);
			pen.drawLine(0, ghostHeight*1/14);
			pen.drawLine(ghostWidth*1/14, 0);
			pen.drawLine(0, ghostHeight*1/14);
			pen.drawLine(ghostWidth*1/14, 0);
			pen.drawLine(0, ghostHeight*3/14);
			pen.drawLine(ghostWidth*1/14, 0);
			pen.drawLine(0, ghostHeight*6/14);
			//reverse width and do tentacles
			for(int j = 0; j < 3; j++) {
				pen.drawLine(0, ghostHeight*1/14);
				pen.drawLine(ghostWidth*-1/14, 0);
				pen.drawLine(0, ghostHeight*1/14);
				pen.drawLine(ghostWidth*-2/14, 0);
				pen.drawLine(0, ghostHeight*-1/14);
				pen.drawLine(ghostWidth*-1/14, 0);
				pen.drawLine(0, ghostHeight*-1/14);
				if (j<2) {
					pen.drawLine(ghostWidth*-1/14, 0);
				}
				
			}
			pen.drawLine(0, ghostHeight*-6/14);
			pen.drawLine(ghostWidth*1/14, 0);
			pen.drawLine(0, ghostHeight*-3/14);
			pen.drawLine(ghostWidth*1/14, 0);
			pen.drawLine(0, ghostHeight*-1/14);
			pen.drawLine(ghostWidth*1/14, 0);
			pen.drawLine(0, ghostHeight*-1/14);
			pen.drawLine(ghostWidth*2/14, 0);
			pen.drawLine(0, ghostHeight*-1/14);
			
			pen.endFilledRegion();
			
			// eyes
			pen.setFillColor(Color.WHITE);
			
			for(int j = 0; j < 2; j++) {
				pen.setLocation(APPLET_WIDTH*location/20, APPLET_HEIGHT/4 - 8);
				pen.startFilledRegion();
				pen.move(ghostWidth*(2+j*6)/14, ghostHeight*3/14);
				
				pen.drawLine(ghostWidth*2/14, 0);
				pen.drawLine(0, ghostHeight*1/14);
				pen.drawLine(ghostWidth*1/14, 0);
				pen.drawLine(0, ghostHeight*3/14);
				//reverse width
				pen.drawLine(ghostWidth*-1/14, 0);
				pen.drawLine(0, ghostHeight*1/14);
				pen.drawLine(ghostWidth*-2/14, 0);
				pen.drawLine(0, ghostHeight*-1/14);
				pen.drawLine(ghostWidth*-1/14, 0);
				pen.drawLine(0, ghostHeight*-3/14);
				pen.drawLine(ghostWidth*1/14, 0);
				pen.drawLine(0, ghostHeight*-1/14);
				
				pen.endFilledRegion();
			}
			
			// pupil
			pen.setFillColor(LIGHTBLUE);
			
			for(int j = 0; j < 2; j++) {
				pen.setLocation(APPLET_WIDTH*location/20, APPLET_HEIGHT/4 - 8);
				pen.startFilledRegion();
				pen.move(ghostWidth*(1+j*6)/14, ghostHeight*5/14);
				
				pen.drawLine(ghostWidth*2/14, 0);
				pen.drawLine(0, ghostHeight*2/14);
				pen.drawLine(ghostWidth*-2/14, 0);
				pen.drawLine(0, ghostHeight*-2/14);
				
				pen.endFilledRegion();
				
			}
			location += 3.5;
		}
			
	}
}
