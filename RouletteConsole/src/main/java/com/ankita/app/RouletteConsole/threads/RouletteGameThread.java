package com.ankita.app.RouletteConsole.threads;

import java.util.ArrayList;
import java.util.List;

import com.ankita.app.RouletteConsole.TO.BetResult;
import com.ankita.app.RouletteConsole.TO.Bet;
import com.ankita.app.RouletteConsole.constant.RouletteConstant;
import com.ankita.app.RouletteConsole.enums.BetType;
import com.ankita.app.RouletteConsole.utility.CommandLineTable;
import com.ankita.app.RouletteConsole.utility.GameUtility;

public class RouletteGameThread implements Runnable {

	private Thread t;
	private String threadName;
	// List<Bid> bidList;
	private volatile List<Bet> bidList = new ArrayList<Bet>();
	boolean runThread = true;

	long ROULETTE_TIMING_IN_MS = RouletteConstant.ROULETTE_ROTATE_TIMING_IN_MS;

	public RouletteGameThread(String threadName) {
		this.threadName = threadName;

	}

	public RouletteGameThread() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void run() {
		System.out.println("Thread started");
		while (runThread) {
			
			try {
				Thread.sleep(ROULETTE_TIMING_IN_MS);
				int rouletteResultNumber = GameUtility.generateRouletteNumber();
				List<BetResult> betResult = GameUtility.betResultCalculate(this.bidList, rouletteResultNumber);
				CommandLineTable.printTable(betResult, rouletteResultNumber);
				this.bidList=new ArrayList<Bet>();
				System.out.println(
						"|------PLEASE PLACE A NEW BET IN ORDER :: PLAYER NAME BID(NUMBER/ ODD/ EVEN) AMOUNT (SPACE SEPARATOR)--- TYPE 'EXIT' TERMINATE THE GAME--");

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void placeANewBet(Bet bid) {
		this.bidList.add(bid);
		
	}

	public void start() {
		// System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

}
