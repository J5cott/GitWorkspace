package model;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JEditorPane;


public class View extends JPanel{

	private JButton zero, one, two, three, four, five, six, 
	seven, eight, nine, add, sub, enter, clear, allclear;
	
	private JEditorPane result;
	
	private Stack<String> input;
	
	private Input math;
	
	/**
	 * Construct a new View
	 */
	public View(){
		
		math = new Input();
		
		input = new Stack<String>();
		
		result = new JEditorPane();
		result.setText("0");
		result.setEditable(false);
		result.setSize(300, 25);
		
		JPanel j = new JPanel();
		
		j.setLayout(new BorderLayout());
		j.add(result, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		zero = new JButton("0");
		one = new JButton("1");
		two = new JButton("2");
		three = new JButton("3");
		four = new JButton("4");
		five = new JButton("5");
		six = new JButton("6");
		seven = new JButton("7");
		eight = new JButton("8");
		nine = new JButton("9");
		
		zero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("0");
			}
			
		});
		
		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("1");
			}
			
		});
		
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("2");
			}
			
		});
		
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("3");
			}
			
		});
		
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("4");
			}
			
		});
		
		five.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("5");
			}
			
		});
		
		six.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("6");
			}
			
		});
		
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("7");
			}
			
		});
		
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("8");
			}
			
		});
		
		nine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("9");
			}
			
		});
		
		add = new JButton("+");
		
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("+");
			}
			
		});
		
		sub = new JButton("-");
		
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("-");
			}
			
		});
		
		enter = new JButton("Enter");
		
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				result.setText(String.valueOf(math.calucate(input)));
			}
			
		});
		
		clear = new JButton("Clear");
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.clear();
			}
			
		});
		
		allclear = new JButton("AllClear");
		
		allclear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.clear();
				math.clear();
			}
			
		});
		
		enter = new JButton("Enter");
		
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				result.setText(String.valueOf(math.calucate(input)));
			}
			
		});
		
		//Add buttons to the panel in a grid format.
		
		buttonPanel.setLayout(new GridLayout( 4, 4));
		buttonPanel.add(clear);
		buttonPanel.add(allclear);
		buttonPanel.add(zero);
		buttonPanel.add(one);
		buttonPanel.add(two);
		buttonPanel.add(three);
		buttonPanel.add(four);
		buttonPanel.add(five);
		buttonPanel.add(six);
		buttonPanel.add(seven);
		buttonPanel.add(eight);
		buttonPanel.add(nine);
		buttonPanel.add(add);
		buttonPanel.add(sub);
		
		j.add(buttonPanel, BorderLayout.CENTER);
	}
	
}
