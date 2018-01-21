package LogSim;

import java.awt.Color;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;

public class MyDropTargetListner extends DropTargetAdapter {
	
	private JFrame frame;
	private DropTarget dropTarget;
	private ArrayList<Gates> gates;
	private Gates gate;

	public MyDropTargetListner(JFrame frame) {
		this.frame = frame;
	    gates=new ArrayList<>();		
		dropTarget = new DropTarget(frame, DnDConstants.ACTION_COPY, this, true, null);
	}
	
	public void drop(DropTargetDropEvent event) {
		Transferable tr = event.getTransferable();
		Point point = event.getLocation();
		if(event.isDataFlavorSupported(TransferableString.stringFlavor)) {
			event.acceptDrop(DnDConstants.ACTION_COPY);
			try {
					String str=(String) tr.getTransferData(TransferableString.stringFlavor);
					System.out.println(str);

					if(str.equals("AND"))
					{
						gate=new AND();
					}
					else if(str.equals("OR"))
					{
						gate=new OR(); 
					}
					else if(str.equals("NOT"))
					{
						gate=new NOT();  
					}
					else if(str.equals("NAND"))
					{
						gate=new NAND();  
					}
					else if(str.equals("XOR"))
					{
						gate=new XOR();   
					}
					else if(str.equals("Input Source"))
					{
						gate=new Source();  
					}
					else if(str.equals("LED"))
					{
						gate=new LED();  
					}
					gate.setposition(point.x-150, point.y-60); 
					gates.add(gate);  
					frame.add(gate);   
					creatGates();
					frame.setVisible(true);
					
				System.out.println(point);
			} 
			catch (UnsupportedFlavorException | IOException e) {
				e.printStackTrace();
			}
			event.dropComplete(true);
		}
	}
	public void creatGates() {

		class EnterListener implements MouseListener {
			private int j;
			private boolean firstGate;
			private boolean secondGate;
			private Connection connection;
			private int indexOfFirstGate;
			private int indexOfSecondGate;
			private int initialXPosition=0;
			private int initialYPosition=0;
			public ArrayList<Connection> connections;

			public EnterListener()
			{
				j=0;
				firstGate=true;
				secondGate=false;
			    connections=new ArrayList<>();
			}
			public void mouseClicked(MouseEvent arg0)   {}
			public void mouseExited(MouseEvent arg0)    {}
			public void mouseEntered(MouseEvent arg0)   {}
			
			public void mousePressed(MouseEvent e) 
			{
				for(int i=0;i<gates.size();i++)
				{
					int x=gates.get(i).getValueOfX();
					int y=gates.get(i).getValueOfY();
					int pressedAtX=e.getX();
					int pressedAtY=e.getY();
					if(pressedAtX >= x && pressedAtX <= (x+70) && pressedAtY >= y && pressedAtY <= (y+50) )
					{
						initialXPosition=gates.get(i).getValueOfX();
						initialYPosition=gates.get(i).getValueOfY();
						j=i;
						moveGate();
						if(firstGate )
						{
							secondGate=true;
							firstGate=false;
						     if(gates.get(j).getGateName().equals(" "))	     gates.get(j).HighLight();
							indexOfFirstGate=j;
						}
						else if(secondGate)
						{
							if(j==indexOfFirstGate)
							{
								if(gates.get(j).getGateName().equals(" "))    gates.get(j).deHighLight();
								secondGate=false;
								firstGate=true;
							}
							else
							{
								    indexOfSecondGate=j;
						        	connection=new Connection(indexOfFirstGate , indexOfSecondGate);
									connection.setGates(gates);
									if(!gates.get(indexOfSecondGate).isFirstInputConnected() )
									{
										connection.drawFirst();
										connection.setUpperConnection();

										gates.get(indexOfFirstGate).setOutputConnected();
										gates.get(indexOfSecondGate).setFirstInputConnected();
										gates.get(indexOfSecondGate).setIndexOfFirstInputGate(indexOfFirstGate);
										
										connections.add(connection);
							        
										frame.add(connection);
										frame.setVisible(true);
										
										if(gates.get(indexOfFirstGate).getGateName().equals(" "))  gates.get(indexOfFirstGate).deHighLight();
										
										secondGate=false;
										firstGate=true;
										
									}
									else if(!gates.get(indexOfSecondGate).isSecondInputConnected())
									{
										connection.drawSecond();
								    	connection.setLowerConnection();
								    	
								    	gates.get(indexOfFirstGate).setOutputConnected();
										gates.get(indexOfSecondGate).setSecondInputConnected();
										gates.get(indexOfSecondGate).setIndexOfSecondInputGate(indexOfFirstGate);
										
										connections.add(connection);
							        	
										frame.add(connection);
										frame.setVisible(true);
										
										gates.get(indexOfFirstGate).deHighLight();
										
										secondGate=false;
										firstGate=true;

									}
							}
						}
						if(gates.get(j).getGateName().equals("source") )
						{
							if(((Source) gates.get(j)).getColor() == Color.BLACK)
							{
										gates.get(j).HighLight();
										secondGate=true;
										firstGate=false;
							}
							else
							{
								gates.get(j).deHighLight();
								secondGate=false;
								firstGate=true;
							}
						}
						for(Gates element1:gates){
							for(Gates element:gates)
							{
							  if(element.isFirstInputConnected())    element.setIn1(gates.get(element.getIndexOfFirstInputGate()).getOut());
							  if(element.isSecondInputConnected())   element.setIn2(gates.get(element.getIndexOfSecondInputGate()).getOut());
							}
						}
					}
				
				}
			}

			MouseMotionListener listener1=new DragListener();
			private void moveGate() {
				for(Gates element:gates)
				{
					element.addMouseMotionListener(listener1);
				}
			}
			
			public void mouseReleased(MouseEvent arg0) 
			{
				int xReleased=arg0.getX();
				int yReleased=arg0.getY();
				
				for(Gates element: gates)
				{
					if(element!= gates.get(j))
					{
						int x=element.getValueOfX();
						int y=element.getValueOfY();
						if(xReleased > (x-70) && xReleased < (x+70) && yReleased > (y-50)  && yReleased < (y+50) )
						{
							gates.get(j).setposition(initialXPosition, initialYPosition);
							 if(connections.size()>0)
							    {
								    for(Connection obj:connections)
								    {
										if(gates.get(j).isFirstInputConnected()  && obj.isUpperConnection() )      obj.drawFirst () ;
										if(gates.get(j).isSecondInputConnected() && obj.isLowerConnection() )      obj.drawSecond() ;
										if(gates.get(j).isOutputConnected()      && obj.isUpperConnection() )      obj.drawFirst () ;
										if(gates.get(j).isOutputConnected()      && obj.isLowerConnection() )      obj.drawSecond() ;
								    }
							    }
						}
					}
				}
				
				for(Gates element: gates)
				{
					element.removeMouseMotionListener(listener1);
				}
			}
			
			class DragListener implements MouseMotionListener {
				
				public void mouseMoved(MouseEvent e) {}
				public void mouseDragged(MouseEvent e) 
				{
					int x=e.getX();
					int y=e.getY();
					gates.get(j).setposition(x,y);
				    if(connections.size()>0)
				    {
					    for(Connection element:connections)
					    {
							if(gates.get(j).isFirstInputConnected()  && element.isUpperConnection() )      element.drawFirst () ;
							if(gates.get(j).isSecondInputConnected() && element.isLowerConnection() )      element.drawSecond() ;
							if(gates.get(j).isOutputConnected()      && element.isUpperConnection() )      element.drawFirst () ;
							if(gates.get(j).isOutputConnected()      && element.isLowerConnection() )      element.drawSecond() ;
					    }
				    }
				}
			}
		}
		final MouseListener listener=new EnterListener();
		gate.addMouseListener(listener);		
    }
}