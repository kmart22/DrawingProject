package drawing.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Shape;
import drawing.controller.DrawingController;

public class ShapePanel extends JPanel
{
	private DrawingController baseController;
	private ArrayList<Shape> rectangleList;
	private ArrayList<Shape> triangleList;
	private ArrayList<Shape> circleList;
	private ArrayList<Shape> polygonList;
	private ArrayList<Shape>  ellipseList;
	private ArrayList<ArrayList <Shape>> shapes;
	
	public ShapePanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		rectangleList = new ArrayList<Shape>();
		circleList = new ArrayList<Shape>();
		ellipseList = new ArrayList<Shape>();
		triangleList = new ArrayList<Shape>();
		polygonList = new ArrayList<Shape>();
		shapes = new ArrayList<ArrayList <Shape>>();
		shapes.add(circleList);
		shapes.add(rectangleList);
		shapes.add(ellipseList);
		shapes.add(triangleList);
		shapes.add(polygonList);
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.CYAN);
		this.setMinimumSize(new Dimension(250, 500));
	}
	
	private getRandomColor()
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
		Graphics2D drawingGraphics = (Graphics2D) graphics;
		
		for(ArrayList<Shape> currentList : shapes)
		{
			drawShapes(currentList, drawingGraphics);
		}
		
//		for(Shape currentRectangle : rectangleList)
//		{
//			drawingGraphics.setColor(getRandomColor());
//			int strokeWidth = (int) (Math.random() *  10) + 1;
//			drawingGraphics.setStroke(new BasicStroke(strokeWidth));
//			drawingGraphics.draw(currentRectangle);
//			
//			int randomness = (int) (Math.random() * 35);
//			
//			if(randomness % 5 == 0 || randomness %  == 0)
//			{
//				drawingGraphics.fill(currentRectangle);
//				
//			}
//			else
//			{
//				drawingGraphics.draw(currentRectangle);
//			}
//		}
	}
	
	private void drawShape(ArrayList<Shape> shapeList, Graphics2D graphics)
	{
		for(Shape curentShape : shapeList)
		{
			graphics.setColor(getRandomColor());
			int strokeWidth = (int) (Math.random() * 10) +1;
			graphics.setStroke(new BasicStroke(strokeWidth));
			
			int randomness = (int) (Math.random() * 35);
			
			if(randomness % 5 == 0 || randomness % 7 ==0)
			{
				graphics.fill(currentShape);
				graphics.setColor(getRandomColor());
				graphics.draw(currentShape);
			}
			else
			{
				graphics.draw(curentShape);
			}
		}
	}
	
	public void addCircles()
	{
		if(circleList.size() > 500)
		{
			circleList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int radius = (int) (Math.random() * 25) + 2;
			int xCorner = (int) (Math.random() * this.getWidth() - 15);
			int yCorner = (int) (Math.random() * this.getHeight() -15);
			Ellipse2D.Double current = new Ellipse2D.Double(xCorner, yCorner, radius, radius);
			circleList.add(current);
			
		}
		this.repaint();
	}
	
	public void addTriangles()
	{
		if(triangleList.size() > 500)
		{
			triangleList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int vertexCount = 3;
			int [] xVertices = new int [vertexCount];
			int [] yVertices = new int [vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner= (int) (Math.random() * this.getWidth());
				int yCorner= (int) (Math.random() * this.getWidth());
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			triangleList.add(current);
		}
		this.repaint();
	}
	
	public void addPolygons()
	{
		if(polygonList.size() > 500)
		{
			polygonList.clear();
		}
		
		for(int index = 0; index < 30; index++)
		{
			int vertexCounnt = (int) (Math.random() * 7) + 4;
			int [] xVertices = new int [vertexCount];
			int [] yVertices = new int [vertexCount];
			for(int vertex = 0; vertex < vertexCount; vertex++)
			{
				int xCorner = (int) (Math.random() * this.getWidth());
				int yCorner = (int) (Math.random() * this.getHeight());
				xVertices[vertex] = xCorner;
				yVertices[vertex] = yCorner;
			}
			Polygon current = new Polygon(xVertices, yVertices, vertexCount);
			polygonList.add(current);
		}
		this.repaint();
		
	}
	
	
}
