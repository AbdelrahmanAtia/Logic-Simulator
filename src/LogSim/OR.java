package LogSim;

import java.awt.Color;
import java.awt.Graphics;

public class OR extends Gates
{
	private Color color=Color.WHITE;
	private boolean firstInputConnected=false;
	private boolean secondInputConnected=false;     //there is only one input so i set the second input always connected
	private boolean outputConnected=false;
	
	private int in1=0;
	private int in2=0;
	private int out=0;
	
	private int indexOfFirstInputGate;
	private int indexOfSecondInputGate;
	public void paintComponent (Graphics g)
	{
		int x1=getValueOfX();
		int y1=getValueOfY();
		g.setColor(color);
		g.setFont(gateFont());

		g.drawLine(x1 , y1+5  , x1+24 , y1+5);  //1
		g.drawLine(x1 , y1+45 , x1+24 , y1+45);  //2
		g.drawArc(x1+10, y1, 20, 50, -90, 180);  //left arc
		g.drawArc(x1-30, y1, 100,50 , -90, 180); //right arc
		
		g.drawLine(x1+70, y1+25, x1+80, y1+25); // right most line
		
	    g.fillOval(x1+80, y1+23, 4, 4);   //right dot
		
		g.fillOval(x1, y1+3, 4, 4);   //top left dot
		
		g.fillOval(x1, y1+43, 4, 4);  //bottom left dot
	}
	public int getXOfoutputPoint()
	{
		return getValueOfX()+82;
	}
	
	public int getYOfOutputPoint()
	{
		return getValueOfY()+25;
	}
	public int getXOfFirstInput()
	{
		return getValueOfX()+2;
	}
	public int getYOfFirstInput()
	{
		return getValueOfY()+5;
	}
	
	public int getXOfSecInput()
	{
		return getValueOfX()+2;
	}
	
	public int getYOfSecInput()
	{
		return getValueOfY()+45;
	}
	
	public void HighLight()
	{
		color=Color.BLUE;
		repaint();
	}
	public void deHighLight()
	{
		color=Color.WHITE;
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
		 setOut();
	 }
	 public int getIn1()
	 {
		 return in1;
	 }
	 
	 public void setIn2(int in)
	 {
		 in2=in;
		 setOut();
	 }
	 public int getIn2()
	 {
		 return in2;
	 }
	 public void setOut()
	 {
		 if(in1==1 || in2==1)
		 {
			 out=1;
		 }
		 else
			 out=0;
	 }
	 
	 public int getOut()
	 {
		 return out;
	 }
	 
	 public void setIndexOfFirstInputGate(int index)
	 {
		 indexOfFirstInputGate=index;
	 }
	 public int getIndexOfFirstInputGate()
	 {
		 return indexOfFirstInputGate;
	 }
	 
	 public void setIndexOfSecondInputGate(int index)
	 {
		 indexOfSecondInputGate=index;
	 }
	 public int getIndexOfSecondInputGate()
	 {
		 return indexOfSecondInputGate;
	 }
}