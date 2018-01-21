package LogSim;


import java.awt.Color;
import java.awt.Graphics;

public class NOT extends Gates
{
	private Color color=Color.WHITE;
	private boolean firstInputConnected=false;
	private boolean secondInputConnected=true;     //there is only one input so i set the second input always connected
	private boolean outputConnected=false;
	
	private int in1=0;
	private int out=0;
	
	private int indexOfFirstInputGate;
	private int indexOfSecondInputGate;

	public void paintComponent(Graphics g)
	{
		
		int x1=getValueOfX();
		int y1=getValueOfY();
		g.setColor(color);
		g.setFont(gateFont());

		g.drawLine(x1+4   , y1+25, x1+30, y1+25); //horizontal line 
		g.drawLine(x1+30, y1, x1+70, y1+25);  // top inclined line
		g.drawLine(x1+30, y1+50, x1+70, y1+25);  //bottom inclined line
		g.drawLine(x1+30, y1, x1+30, y1+50);   // vertical line
		
		g.drawLine(x1+78, y1+25, x1+88, y1+25);  // right most line
		g.fillOval(x1+88, y1+23, 4, 4);   //right dot
		g.drawOval(x1+70, y1+21, 8, 8);  //right circle

		g.fillOval(x1, y1+23, 4, 4);   // left dot
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
		return getValueOfY()+25;
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
	 
	
	 public void setOut()
	 {
		 if(in1==1)
		 {
			 out=0;
		 }
		 else
			 out=1;
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
