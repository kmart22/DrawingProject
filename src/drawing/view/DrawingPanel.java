package drawing.view;

import javax.swing.*;
import drawing.controller.DrawingController;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class DrawingPanel extends JPanel
{
	private ShapePanel shapePanel;
	private JButton rectangleButton;
	private SpringLayout baseLayout;
	private DrawingController baseController;
	
	public DrawingPanel(DrawingController baseController)
	{
		super();
		this.baseController = baseController;
		
		shapePanel = new ShapePanel(baseController);
		rectangleButton = new JButton("draw rectangles");
		baseLayout = new SpringLayout();
		
		setupPanel();
		setupLayout();
		setupListeners();
		
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GRAY);
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupListeners()
	{
		rectangleButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				shapePanel.addRectangles();
			}
		});
	}
}
