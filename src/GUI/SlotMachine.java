package src.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class SlotMachine extends JFrame implements ActionListener, MouseListener, Runnable {

	/*private static int numberofGames = 0;
	private static int countNumWinn = 0;
	private static int numberOfLoses = 0;*/
	private static int betAmmount=0;
	
	private static int countWinn;
    private static int countLoss;
    private static double timeCount;
    private static int Avgcredit;
    private static int reel1Num = 0;
	private static int reel2Num = 0;
	private static int reel3Num = 0;
	 int countNumWinn=0;//number of winn times in the game
	 	int countNumloss=0;//number of loss time in the game
	 	int countTimes=0;//number of time game play
	  

	public static int getCountWinn() {
		return countWinn;
	}

	public static void setCountWinn(int countWinn) {
		SlotMachine.countWinn = countWinn;
	}

	public static int getCountLoss() {
		return countLoss;
	}

	public static void setCountLoss(int countLoss) {
		SlotMachine.countLoss = countLoss;
	}

	public static double getTimeCount() {
		return timeCount;
	}

	public static void setTimeCount(double timeCount) {
		SlotMachine.timeCount = timeCount;
	}

	public static int getAvgcredit() {
		return Avgcredit;
	}

	public static void setAvgcredit(int avgcredit) {
		Avgcredit = avgcredit;
	}

public SlotMachine() {
		
		
		setLayout(new GridLayout(5,5,5,5));
		
		contentPane = getContentPane();
		contentPane.setLayout(new GridBagLayout());
		contentPane.setBackground(Color.WHITE);
		GridBagConstraints objgrid = new GridBagConstraints();
		objgrid.fill = GridBagConstraints.BOTH;
		objgrid.insets = new Insets(3, 3, 3, 3);

		

		// setting up black image for spaces
		//obj.setImage("images/black.png", "black");
		
		headName=new JLabel("Slot Machine");
		objgrid.gridx=1;
		objgrid.gridy=0;
		headName.setForeground(Color.RED);
		headName.setFont(new Font("Papyrus", Font.BOLD, 25)); 
		
		contentPane.add(headName,objgrid);
	
	
	lblImg1 = new JLabel();
	lblImg1.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 2, Color.BLUE));
	lblImg2 = new JLabel();
	lblImg2.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 2, Color.BLUE));
	lblImg3 = new JLabel();
	lblImg3.setBorder(BorderFactory.createMatteBorder(5, 2, 5, 5, Color.BLUE));
	

		lblImg1.setIcon(reel1[0].getImage());
		lblImg2.setIcon(reel2[0].getImage());
		lblImg3.setIcon(reel3[0].getImage());

		//objgrid.gridx = 0;
		//objgrid.gridy = 0;

		objgrid.gridx = 0;
		objgrid.gridy = 1;
		contentPane.add(lblImg1, objgrid);

		objgrid.gridx = 1;
		objgrid.gridy = 1;
		contentPane.add(lblImg2, objgrid);

		objgrid.gridx = 2;
		objgrid.gridy = 1;
		contentPane.add(lblImg3, objgrid);

		//objgrid.gridx = 4;
		//objgrid.gridy = 0;
		
	

		btnSpin = new JButton("Spin");
		btnSpin.setActionCommand("Spin");

		btnBetOne = new JButton("Bet One");
		btnBetOne.setActionCommand("BetOne");

		btnBetMax = new JButton("Bet Max");
		btnBetMax.setActionCommand("BetMax");

		btnReset = new JButton("Reset");
		btnReset.setActionCommand("Reset");

		btnAddCoin = new JButton("Add Coin");
		btnAddCoin.setActionCommand("AddCoin");

		btnStat = new JButton("Statistic");
		btnStat.setActionCommand("Stat");



		// add an empty jlabel for SPACE
		

		// add spin button to grid
		objgrid.gridx = 1;
		objgrid.gridy = 2;
		contentPane.add(btnSpin, objgrid);

		// add Add coin Button
		objgrid.gridx = 1;
		objgrid.gridy = 3;
		contentPane.add(btnAddCoin, objgrid);

		// add Bet One button
		objgrid.gridx = 0;
		objgrid.gridy = 3;
		contentPane.add(btnBetOne, objgrid);

		// add Bet Max button
		objgrid.gridx = 2;
		objgrid.gridy = 3;
		contentPane.add(btnBetMax, objgrid);

		// add Reset button
		objgrid.gridx = 1;
		objgrid.gridy = 4;
		contentPane.add(btnReset, objgrid);

		// add statistic button
		objgrid.gridx = 0;
		objgrid.gridy = 4;
		contentPane.add(btnStat, objgrid);
		
		// add credit area jlabel
		lblCredit = new JLabel("Credit Area : ");
		lblCredit.setForeground(Color.BLACK);
		objgrid.gridx = 0;
		objgrid.gridy = 5;
		contentPane.add(lblCredit, objgrid);

		// add a jlabel for credits.
		creditArea = new JLabel("10");
		creditArea.setForeground(Color.RED);
		objgrid.gridx = 1;
		objgrid.gridy = 5;
		contentPane.add(creditArea, objgrid);

		// add jlabel for bet area
		lblBet = new JLabel("Bet Area : ");
		lblBet.setForeground(Color.BLACK);
		objgrid.gridx = 0;
		objgrid.gridy = 6;
		contentPane.add(lblBet, objgrid);

		// add an empty jlabel for betAmmount
		betArea = new JLabel("0");
		betArea.setForeground(Color.RED);
		objgrid.gridx = 1;
		objgrid.gridy = 6;
		contentPane.add(betArea, objgrid);

		// adding Action Listeners
		btnSpin.addActionListener(this);
		btnBetOne.addActionListener(this);
		btnBetMax.addActionListener(this);
		btnReset.addActionListener(this);
		btnAddCoin.addActionListener(this);
		btnStat.addActionListener(this);
		addMouseListener(this);
	}
}