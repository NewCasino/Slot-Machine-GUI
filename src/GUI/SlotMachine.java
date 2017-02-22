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
}