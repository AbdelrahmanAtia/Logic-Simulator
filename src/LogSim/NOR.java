package LogSim;


import java.awt.Color;
import java.awt.Graphics;

public class NOR extends Gates
{
	private Color color=Color.WHITE;
	private boolean firstInputConnected=false;
	private boolean secondInputConnected=false;     //there is only one input so i set the second input always connected
	private boolean outputConnected=false;
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
		
		g.drawLine(x1+78, y1+25, x1+88, y1+25);  // right most line
		g.fillOval(x1+88, y1+23, 4, 4);   //right dot
		g.drawOval(x1+70, y1+21, 8, 8);  //right circle
		
		
		g.fillOval(x1, y1+3, 4, 4);   //top left dot
		
		g.fillOval(x1, y1+43, 4, 4);  //bottom left dot
	
	}
	public int getXOfoutputPoint()
	{
		return getValueOfX()+90;
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
}

