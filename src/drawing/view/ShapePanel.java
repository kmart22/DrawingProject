package drawing.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

import drawing.controller.DrawingController;

public class ShapePanel extends JPanel
{
	private DrawingController baseController;
	private ArrayList<Rectangle> rectangleList;
	
	public ShapePanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		rectangleList = new ArrayList<Rectangle>();
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setMinimumSize(new Dimension(250, 500));
	}
	
	private void getRandomColor()
	{
		int alpha = (int) (Math.random() * 120);
		int red = (int) (Math.random() * 120);
		int green = (int) (Math.random() * 120);
		int blue = (int) (Math.random() * 120);
		
		return new Color(red, green, blue, alpha);
	}
	
	public void addRectangles()
	{
		for(int index = 0; index < 500; index++)
		{
			int width = (int) (Math.random() * 120) + 1;
			int height = (int) (Math.random() * 120) + 15;
			int xCorner  = (int) (Math.random() * this.getWidth() - 30);
			int yCorner = (int) (Math.random() * this.getHeight() - 15);
		}
	}
}
