import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Listener for the buttons on the board	while playing game
	public class InternetListener implements ActionListener
	{	
		int i,j;
		
		public void actionPerformed(ActionEvent v)
		{						
			
			System.out.println(Bship.getPlayers(0).getMove());
			if
			(Bship.getPlayers(0).getMove())			
			{				
				System.out.println("WooHoo");
				Object source = v.getSource();
				outer:						
				for (i=0;i<10;i++)
				{				
					for (j=0;j<10;j++)
					{					
						if (source==Bship.getPlayers(1).getBboard(i,j))
						{								
							if ((Bship.getPlayers(1).getBboard(i,j).getBackground()==Color.black)||
								(Bship.getPlayers(1).getBboard(i,j).getBackground()==Color.orange)||
								(Bship.getPlayers(1).getBboard(i,j).getBackground()==Color.blue))
							{
								JOptionPane.showMessageDialog(null,"You tri"
								+"ed that spot already.","Wasted Shot",
								JOptionPane.ERROR_MESSAGE);
								Bship.getClient().fireShot();								
							}
							else
							{
								Bship.getClient().fireShot(i,j);							
							}
							break outer;						
						}
						else if (source==(Bship.getPlayers(0).getBboard(i
							,j)))
						{
							JOptionPane.showMessageDialog(null,"You are not suppose"
							+"d to fire on your own board!","Lost Turn",
							JOptionPane.WARNING_MESSAGE);
							Bship.getClient().fireShot();		
							break outer;							
						}			
					}
				}						
				Player.isStatsOpen();
				Bship.getPlayers(0).setMove(false);													
			}
			else
			{
				if (!Bship.getGameOver())
				{
					JOptionPane.showMessageDialog(null,"You cannot not play yet.",
					"Wait",JOptionPane.WARNING_MESSAGE);				
				}
				else
				{
					for (i=0;i<10;i++)
					{				
						for (j=0;j<10;j++)
						{
							Bship.getPlayers(0).getBboard(i
							,j).setEnabled(false);
							Bship.getPlayers(0).getBboard(i,j).setEnabled(false);
						}
					}
				}
			}								
		}
	}	

