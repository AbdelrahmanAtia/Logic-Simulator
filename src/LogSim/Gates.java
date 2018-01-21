package LogSim;

import java.awt.Font;

import javax.swing.JComponent;

public class Gates extends JComponent
{
	private int x;
	private int y;
	private static final int width=50;
	private static final int height=50;
	private int in1=0;
	private int in2=0;
	private int out=0;
	private int indexOfFirstInputGate;
	private int indexOfSecondInputGate;
	public Gates()
	{
		
	}
	public int getValueOfX(){
		return x;
	}
	
	public int getValueOfY(){
		return y;
	}
	
	public int getValueOfWidth(){
		return width;
	}
	
	public int getValueOfHeight(){
		return height;
	}
	public void setposition(int x,int y)
	{
		this.x=x;
		this.y=y;
		repaint();
	}
	public void HighLight()
	{
		
	}
	public void deHighLight()
	{
		
	}
	public Font gateFont()
	{
		Font font=new Font("SansSerif Bold" , Font.BOLD,100);
		return font;
		
	}
	public int getXOfoutputPoint()
	{
		return 0;
	}
	
	public int getYOfOutputPoint()
	{
		return 0;
	}
	public int getXOfFirstInput()
	{
		return 0;
	}
	public int getYOfFirstInput()
	{
		return 0;
	}
	
	public int getXOfSecInput()
	{
		return 0;
	}
	
	public int getYOfSecInput()
	{
		return 0;
	}
	
	
	 public void setConnectionIndex(int i)
	 {
		 
	 }
	 public int getConnectionIndex()
	 {
		 return 0;
	 }
	 public void setFirstInputConnected()
	 {
	 }
	 
	 public boolean isFirstInputConnected()
	 {
		 return true;
	 }
	 
	 public void setSecondInputConnected()
	 {
	 }
	 public boolean isSecondInputConnected()
	 {
		 return true;
	 }
	 public void setOutputConnected()
	 {
		 
	 }
	 public boolean isOutputConnected()
	 {
		 return false;
	 }
	 
	 public void setIn1(int in)
	 {
		 in1=in;
	 }
	 public int getIn1()
	 {
		 return in1;
	 }
	 
	 public void setIn2(int in)
	 {
		 in2=in;
	 }
	 public int getIn2()
	 {
		 return in2;
	 }
	 public void setOut()
	 {
		
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
	 
	 public String getGateName()
	 {
		 return " ";
	 }
}