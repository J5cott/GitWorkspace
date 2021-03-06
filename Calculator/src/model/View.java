package model;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.Action;


public class View extends JPanel{

	private JButton zero, one, two, three, four, five, six, 
	seven, eight, nine, add, sub, enter, clear, allclear, period;
	
	private JEditorPane result;
	
	private Stack<String> input;
	private Stack<String> tempstack;
	
	private String resultstring;
	
	private Input1 math;
	
	
	/**
	 * Construct a new View
	 */
	public View(){
		
		math = new Input1();
		
		
		resultstring = "";
		input = new Stack<String>();
		tempstack = new Stack<String>();
		
		
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
		period = new JButton(".");
		
/**		AbstractAction buttonPressed = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        };
*/
		AbstractAction buttonPressed = new AbstractAction(){
			
			@Override
			public void actionPerformed(ActionEvent e){
				JButton b = (JButton) e.getSource();
				if(b.equals(zero)){
					input.push("0");
					tempstack.push("0");
					//result.setText("0");
				} else if(b.equals(one)){
					input.push("1");
					tempstack.push("1");
					//result.setText("1");
				} else if(b.equals(two)){
					input.push("2");
					tempstack.push("2");
					//result.setText("2");
				} else if(b.equals(three)){
					input.push("3");
					tempstack.push("3");
					//result.setText("3");
				} else if (b.equals(four)){
					input.push("4");
					tempstack.push("4");
					//result.setText("4");
				} else if (b.equals(five)){
					input.push("5");
					tempstack.push("5");
					//result.setText("5");
				} else if (b.equals(six)){
					input.push("6");
					tempstack.push("6");
					//result.setText("6");
				} else if (b.equals(seven)){
					input.push("7");
					tempstack.push("7");
					//result.setText("7");
				} else if (b.equals(eight)){
					input.push("8");
					tempstack.push("8");
					//result.setText("8");
				} else if (b.equals(nine)){
					input.push("9");
					tempstack.push("9");
					//result.setText("9");
				} else if (b.equals(enter)){
					resultstring = String.valueOf(math.calculate(input));
					//result.setText(String.valueOf(math.calculate(input)));
				} else if (b.equals(add)){
					input.push("+");
					resultstring = "";
				} else if (b.equals(sub)){
				input.push("-");
				resultstring = "";
				} else if (b.equals(clear)){
					input.clear();
					//result.setText("0");
					resultstring = "0";
				} else if (b.equals(allclear)){
					input.clear();
					math.clear();
					resultstring = "0";
					//result.setText("0");
		}
				else if (b.equals(".")){
					input.push(".");
					tempstack.push(".");
					//result.setText(".");
				}
				if(tempstack.isEmpty() == false){
				resultstring = resultstring.concat(String.valueOf(tempstack.pop()));
				}
				result.setText(resultstring);
			}};
		
		zero.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("0");
				result.setText("0");
			}
			
		});
		
		
		zero.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0,0), "0_pressed");
		zero.getActionMap().put("0_pressed", buttonPressed);
		

		one.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("1");
				result.setText("1");
			}
			
		});

		one.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1,0), "1_pressed");
		one.getActionMap().put("1_pressed", buttonPressed);

		
		two.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("2");
				result.setText("2");
			}
			
		});
		
		two.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2,0), "2_pressed");
		two.getActionMap().put("2_pressed", buttonPressed);
		
		three.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("3");
				result.setText("3");
			}
			
		});
		
		three.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3,0), "3_pressed");
		three.getActionMap().put("3_pressed", buttonPressed);
		
		four.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("4");
				result.setText("4");
			}
			
		});
		
		four.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4,0), "4_pressed");
		four.getActionMap().put("4_pressed", buttonPressed);
		
		five.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("5");
				result.setText("5");
			}
			
		});
		
		five.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5,0), "5_pressed");
		five.getActionMap().put("5_pressed", buttonPressed);
		
		six.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("6");
				result.setText("6");
			}
			
		});
		
		six.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6,0), "6_pressed");
		six.getActionMap().put("6_pressed", buttonPressed);
		
		seven.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("7");
				result.setText("7");
			}
			
		});
		
		seven.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7,0), "7_pressed");
		seven.getActionMap().put("7_pressed", buttonPressed);
		
		eight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("8");
				result.setText("8");
			}
			
		});
		
		eight.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8,0), "8_pressed");
		eight.getActionMap().put("8_pressed", buttonPressed);
		
		nine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("9");
				result.setText("9");
			}
			
		});
		
		nine.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9,0), "9_pressed");
		nine.getActionMap().put("9_pressed", buttonPressed);
		
		
		period.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push(".");
				result.setText(".");
			}
			
		});
		
		
		period.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_PERIOD,0), "._pressed");
		period.getActionMap().put("._pressed", buttonPressed);
		
		add = new JButton("+");
		
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("+");
			}
			
		});
		
		add.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_EQUALS,0), "+_pressed");
		add.getActionMap().put("+_pressed", buttonPressed);
		
		sub = new JButton("-");
		
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.push("-");
			}
			
		});
		
		sub.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_SUBTRACT,0), "-_pressed");
		sub.getActionMap().put("-_pressed", buttonPressed);
		
		enter = new JButton("Enter");
		
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				result.setText(String.valueOf(math.calculate(input)));
			}
			
		});
		
		enter.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER,0), "Enter_pressed");
		enter.getActionMap().put("Enter_pressed", buttonPressed);
		
		clear = new JButton("Clear");
		
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.clear();
				result.setText("0");
			}
			
		});
		
		clear.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,0), "Clear_pressed");
		clear.getActionMap().put("Clear_pressed", buttonPressed);
		
		allclear = new JButton("AllClear");
		
		allclear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				input.clear();
				math.clear();
				result.setText("0");
			}
			
		});
		
		allclear.getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW).
        put(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A,0), "AllClear_pressed");
		allclear.getActionMap().put("AllClear_pressed", buttonPressed);
		
		//Add buttons to the panel in a grid format.
		
		buttonPanel.setLayout(new GridLayout( 4, 4));
		buttonPanel.add(clear);
		buttonPanel.add(allclear);
		buttonPanel.add(add);
		buttonPanel.add(sub);
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
		buttonPanel.add(enter);
		buttonPanel.add(period);
		
		j.add(buttonPanel, BorderLayout.CENTER);
		this.add(j);
	}
	
	public static void main(String[] args){
		
		JFrame frame = new JFrame("Example");
		
		JLabel label = new JLabel("This is a label!");
		
		JButton button = new JButton();
		button.setText("Press me");
		
		frame.add(new View());
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
			
		}
		
//		View view = new View();
//		Scanner sc = new Scanner(System.in);
//		if(sc.hasNextLine()){
//			try{
//			String s = sc.nextLine();
//			if(s.equals("+")){
//				
//			} else if(s.equals("-")){
//				
//			}else{
//				double d = Double.valueOf(s);
//			}
//			} catch(NumberFormatException e){
//				
//			}
//		}
	}
	

