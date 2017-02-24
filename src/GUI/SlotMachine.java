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
	  

   int avgCredit1;
   int avgCredit2;
   int avgCredit;
   SlotMachine objNum;
	// maximum number of credits.
	private static final int maxBet = 3;
	// creating 3 reels.
	Reel objReel = new Reel();
	Isymbol[] reel1 = objReel.spin();
	Reel objReel2 = new Reel();
	Isymbol[] reel2 = objReel2.spin();
	Reel objReel3 = new Reel();
	Isymbol[] reel3 = objReel3.spin();
	// creating 3 treads.
	Thread thread1 = new Thread() {
		public void run() {
			reel1();
		}
	};
	Thread thread2 = new Thread() {
		public void run() {
			reel2();
		}
	};
	Thread thread3 = new Thread() {
		public void run() {
			reel3();
		}
	};

	symbol obj = new symbol();
	private JLabel lblCredit, lblBet, creditArea, betArea, lblImgEmpty, lblImg1, lblImg2, lblImg3, lblImgEmpty2, LBLEMP,headName;
	private JButton btnSpin, btnBetOne, btnBetMax, btnReset, btnAddCoin, btnStat;

	Container contentPane;

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

	@SuppressWarnings("static-access")
	@Override
	public void mouseClicked(MouseEvent e) {
		try {

			// Enabling all bttons.
			btnSpin.setEnabled(true);
			btnBetOne.setEnabled(true);
			btnBetMax.setEnabled(true);
			btnReset.setEnabled(true);
			btnAddCoin.setEnabled(true);
			btnStat.setEnabled(true);

			thread1.stop();
			thread2.stop();
			thread3.stop();

			compair();

			// re Start the threads
			thread1 = new Thread() {
				public void run() {
					reel1();
				}
			};
			thread2 = new Thread() {
				public void run() {
					reel2();
				}
			};
			thread3 = new Thread() {
				public void run() {
					reel3();
				}
			};
		} catch (Exception ex) {
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("AddCoin".equals(e.getActionCommand())) {
			addCoin();
		} else if ("BetMax".equals(e.getActionCommand())) {
			betMax();
		} else if ("BetOne".equals(e.getActionCommand())) {
			betOne();
		} else if ("Reset".equals(e.getActionCommand())) {
			reset();
		} else if ("Spin".equals(e.getActionCommand())) {
			spin();
		} else if ("Stat".equals(e.getActionCommand())) {
			stat();
		}
	}

	public void addCoin() {
		int InitialValue = Integer.parseInt(creditArea.getText());
		creditArea.setText(String.valueOf(++InitialValue));
	}

	public void betMax() {
		int betValue = Integer.parseInt(betArea.getText());
		if (betValue < maxBet) {
			// calculating the bet difference.
			int difference = maxBet - betValue;
			// removing credits after betting.
			int InitialValue = Integer.parseInt(creditArea.getText());
			int newValue = InitialValue - difference;
			if (newValue > 0) {
				creditArea.setText(String.valueOf(newValue));
				// setting max bet.
				betArea.setText("3");
			}

		}
        if(creditArea.getText().equals("0")){
			
			JOptionPane.showMessageDialog(null, "Plaese Add coin first", "Alert", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void betOne() {
		int betValue = Integer.parseInt(betArea.getText());
		// removing credits after betting.
		int InitialValue = Integer.parseInt(creditArea.getText());
		int newValue = InitialValue - 1;
		if (newValue >= 0) {
			creditArea.setText(String.valueOf(newValue));
			// setting max bet.
			betArea.setText(String.valueOf(++betValue));
		}
		if(creditArea.getText().equals("0")){
			
			JOptionPane.showMessageDialog(null, "Plaese Add coin first", "Alert", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void reset() {
		int betValue = Integer.parseInt(betArea.getText());
		int InitialValue = Integer.parseInt(creditArea.getText());
		creditArea.setText(String.valueOf(InitialValue + betValue));
		// setting max bet.
		betArea.setText(String.valueOf(0));
		creditArea.setText(String.valueOf(10));
		
	}

	public void spin() {
		if (betArea.getText().equals("0")) {
			JOptionPane.showMessageDialog(null, "Plaese bet first", "Alert", JOptionPane.INFORMATION_MESSAGE);
		} else {
			thread1.start();
			thread2.start();
			thread3.start();
        	countTimes++;
			betAmmount += Integer.parseInt(betArea.getText());
			// Disabaling all buttons.
			btnSpin.setEnabled(false);
			btnBetOne.setEnabled(false);
			btnBetMax.setEnabled(false);
			btnReset.setEnabled(false);
			btnAddCoin.setEnabled(false);
			btnStat.setEnabled(false);
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void reel1() {
		int num = 0;
		
		for (int i = 0; i < 1000; i--) {
			lblImg1.setIcon(reel1[++num].getImage());
			reel1Num = reel1[num].getValue();
			try {
				thread1.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (num == 5) {
				num = 0;
			}
		}
	}

	public void reel2() {
		int num = 0;
		for (int i = 0; i < 1000; i--) {
			lblImg2.setIcon(reel2[++num].getImage());
			reel2Num = reel2[num].getValue();

			try {
				thread2.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (num == 5) {
				num = 0;
			}
		}
	}

	public void reel3() {
		int num = 0;
		for (int i = 0; i < 1000; i--) {
			lblImg3.setIcon(reel3[++num].getImage());
			reel3Num = reel3[num].getValue();
			try {
				thread3.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (num == 5) {
				num = 0;
			}
		}
	}


	public void compair() {

		int value = 0;
		boolean flag = false;
		if (reel1Num == reel2Num) {
			
			flag = true;
			value = reel1Num;

		} else if (reel2Num == reel3Num) {
			flag = true;
			value = reel2Num;

		} else if (reel1Num == reel3Num) {
			flag = true;
			value = reel3Num;

		}

		if (flag) {
			int betValue = Integer.parseInt(betArea.getText());
			int wonAmmount = betValue * value;
			avgCredit1=avgCredit1+betValue;
			
			JOptionPane.showMessageDialog(null, "You have won : " + wonAmmount+" credits", "Congratulations",
					JOptionPane.INFORMATION_MESSAGE);
			int InitialValue = Integer.parseInt(creditArea.getText());
			creditArea.setText(String.valueOf(InitialValue + wonAmmount));
			betArea.setText(String.valueOf(0));
			countNumWinn++;
			objNum.setCountWinn(countNumWinn);

			
		} else {
			JOptionPane.showMessageDialog(null, "You have lost  ", "BAD LUCK", JOptionPane.INFORMATION_MESSAGE);
			int betValue = Integer.parseInt(betArea.getText());

			betArea.setText(String.valueOf(0));
			System.out.println(betValue);
		
			avgCredit2=avgCredit2-betValue;
			 System.out.println(avgCredit2);

        	countNumloss++;
        	objNum.setCountLoss(countNumloss);
        	

		}
		 avgCredit=avgCredit2+avgCredit1;
		 objNum.setAvgcredit(avgCredit);
		 objNum.setTimeCount(countTimes);
		 System.out.println(avgCredit);

	}

	public void stat() {
		Statistic stat=new Statistic(objNum);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {

	}

	@Override
	public void mouseExited(MouseEvent arg0) {

	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}
	public static void main(String[]args){
		SlotMachine object=new SlotMachine();
		object.setTitle("Slot Machine");
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		object.setSize(600,500);
		object.setLocationRelativeTo(null);
		object.setVisible(true);
	}
}
