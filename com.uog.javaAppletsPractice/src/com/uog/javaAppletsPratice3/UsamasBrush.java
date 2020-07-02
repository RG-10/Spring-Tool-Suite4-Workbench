package com.uog.javaAppletsPratice3;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

@SuppressWarnings("serial")
public abstract class UsamasBrush extends Applet implements MouseMotionListener {
	
	      int width, height;
	
	      Image backbuffer;
	
	      Graphics backg;
	
	 public void init() {
		
		  width = getSize().width;
		  
		  height = getSize().height;
		
		
		  backbuffer = createImage( width, height);
		  backg = backbuffer.getGraphics();
		  backg.setColor(Color.black);
		  backg.fillRect(0, 0, width, height);
		  backg.setColor(Color.white);
		  
		  addMouseMotionListener(this);
		
	}
	 
	 
	 public void mouseMoved(MouseEvent e) {
		 
	 }
	 
	 public void mouseDragged(MouseEvent e) {
		 
		  int x = e.getX();
		  int y = e.getY();
		  
		  backg.fillOval(x-5, y-5, 10, 10);
		  repaint();
		  e.consume(); //this is input event
		 
	 }
	 
	 public void update(Graphics g) {
		 
		  g.drawImage(backbuffer, 0, 0, this);
		  
	 }
	 
	 public void paint(Graphics g) {
		 
		  update(g);
	 }
}
             //HTML code For Above Program//
             //===========================//
             //---------------------------//

             //<applet width = 300 height = 300 code="Usamasbrush.class"></applet>















