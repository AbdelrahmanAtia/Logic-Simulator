package LogSim;

import java.awt.Color;
import java.awt.Graphics;

public class Source extends Gates
{
	private Color color=Color.BLACK;
	private boolean firstInputConnected=true;
	private boolean secondInputConnected=true;     
	private boolean outputConnected=false;
	private int out=0;

	public void paintComponent(Graphics g)
	{
		int x1=getValueOfX();
		int y1=getValueOfY();
		g.setColor(Color.BLACK);
		g.fillRect(x1, y1, 70, 50);
		g.setColor(Color.WHITE);
		g.fillRect(x1+5, y1+5, 60, 40);
		g.setColor(color);
		g.fillRect(x1+10, y1+10, 50, 30);
		
	}
	
	public int getXOfoutputPoint()
	{
		return getValueOfX()+70;
	}
	
	public int getYOfOutputPoint()
	{
		return getValueOfY()+25;
	}
	public void HighLight()
	{
		color=Color.RED;
		setOut(1);
		repaint();
	}
	public void deHighLight()
	{
		color=Color.BLACK;
		setOut(0);
		repaint();
	}
	 public void setFirstInputConnected()
	 {
		 firstInputConnected=true;
	 }
	 public boolean isFirstInputConnected()
	 {
		 return firstInputConnected;
	 }
	 
	 public void setSecondInputConnected()
	 {
		 secondInputConnected=true;
	 }
	 public boolean isSecondInputConnected()
	 {
		 return secondInputConnected;
	 }
	 
	 public void setOutputConnected()
	 {
		 outputConnected=true;
	 }
	 public boolean isOutputConnected()
	 {
		 return outputConnected;
	 }	
	 
	 public void setOut(int out)
	 {
		 this.out=out;
	 }
	 
	 public int getOut()
	 {
		 return out;
	 }
	 public String getGateName()
	 {
		 return "source";
	 }
	 public Color getColor()
	 {
		 return color;
	 }
}
