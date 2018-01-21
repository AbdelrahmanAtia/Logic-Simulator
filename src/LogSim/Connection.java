package LogSim;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

public class Connection extends JComponent {
	private int first;
	private int second;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private ArrayList<Gates> gates;
	private boolean upperConnection = false;
	private boolean lowerConnection = false;

	public Connection(int first, int second) {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		this.first = first;
		this.second = second;

	}

	public void paintComponent(Graphics g) {
		
		drawConnection(g);
		
	}

	private void drawConnection(Graphics g) {
		g.setColor(Color.white);
		g.drawLine(x1, y1, x2 - 10, y1);
		g.drawLine(x2 - 10, y1, x2 - 10, y2);
		g.drawLine(x2 - 10, y2, x2, y2);		
	}

	public void setGates(ArrayList<Gates> gates) {
		this.gates = gates;
	}

	public void drawFirst() {
		x1 = gates.get(first).getXOfoutputPoint();
		y1 = gates.get(first).getYOfOutputPoint();
		x2 = gates.get(second).getXOfFirstInput();
		y2 = gates.get(second).getYOfFirstInput();

		repaint();
	}

	public void drawSecond() {
		x1 = gates.get(first).getXOfoutputPoint();
		y1 = gates.get(first).getYOfOutputPoint();
		x2 = gates.get(second).getXOfSecInput();
		y2 = gates.get(second).getYOfSecInput();

		repaint();
	}

	//checks if upper connection connected
	public void setUpperConnection() {
		upperConnection = true;
	}

	//checks if lower connection connected
	public boolean isUpperConnection() {
		return upperConnection;
	}

	public void setLowerConnection() {
		lowerConnection = true;
	}

	public boolean isLowerConnection() {
		return lowerConnection;
	}
}