package drawing.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
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
			
			Rectangle currentRectangle = new Rectangle(xConer, yConer, width, height);
			rectangleList.add(currentRectangle);
		}
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		//this.setBackground(getRandomColor()); bad deign choice.. would not recommend
		Graphics2D drawingGraphics = (Graphics2D) graphics;
		for(Rectangle currentRectangle : rectangleList)
		{
			drawingGraphics.setColor(getRandomColor());
			int strokeWidth = (int) (Math.random() *  10) + 1;
			drawingGraphics.setStroke(new BasicStroke(strokeWidth));
			drawingGraphics.draw(currentRectangle);
			
			int randomness = (int) (Math.random() * 35);
			if(randomness % 5 == 0 || randomness %  == 0)
			{
				drawingGraphics.fill(currentRectangle);
				
			}
			else
			{
				drawingGraphics.draw(currentRectangle);
			}
		}
	}
}
