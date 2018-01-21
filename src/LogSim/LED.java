package LogSim;

import java.awt.Color;
import java.awt.Graphics;

public class LED  extends Gates
{
	private Color color=Color.BLACK;
	private boolean firstInputConnected=false;
	private boolean secondInputConnected=true;     
	private boolean outputConnected=true;
	private int in1=0;
	private int in2=0;
	private int out=0;
	
	private int indexOfFirstInputGate;
	private int indexOfSecondInputGate;

	public void paintComponent(Graphics g)
	{
		int x1=getValueOfX();
		int y1=getValueOfY();
		
		g.setColor(Color.BLACK);
		g.fillOval(x1, y1, 50, 50);
		
		g.setColor(Color.WHITE);
		g.fillOval(x1+5, y1+5, 40, 40);
		
		g.setColor(color);
		g.fillOval(x1+10, y1+10, 30, 30);
		
	}
	
	public int getXOfFirstInput()
	{
		return getValueOfX();
	}
	public int getYOfFirstInput()
	{
		return getValueOfY()+25;
	}
	
	public void HighLight()
	{
		color=Color.RED;
		repaint();
	}
	public void deHighLight()
	{
		color=Color.BLACK;
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
	 
	 public void setIn1(int in)
	 {
		 in1=in;
		 if(in1==1)
			 HighLight();
		 if(in1==0)
			 deHighLight();
	 }
	 public void setIndexOfFirstInputGate(int index)
	 {
		 indexOfFirstInputGate=index;
	 }
	 public int getIndexOfFirstInputGate()
	 {
		 return indexOfFirstInputGate;
	 }
}