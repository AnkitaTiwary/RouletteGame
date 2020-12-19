package com.ankita.app.RouletteConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.ankita.app.RouletteConsole.TO.BetResult;
import com.ankita.app.RouletteConsole.TO.Bet;
import com.ankita.app.RouletteConsole.constant.RouletteConstant;
import com.ankita.app.RouletteConsole.enums.BetType;
import com.ankita.app.RouletteConsole.exceptions.RouletteException;
import com.ankita.app.RouletteConsole.threads.RouletteGameThread;
import com.ankita.app.RouletteConsole.utility.CommandLineTable;
import com.ankita.app.RouletteConsole.utility.GameUtility;
import com.ankita.app.RouletteConsole.utility.ReadPlayersFromFile;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		Set<String> playerList = null;
		boolean takeBets = true;
		while(playerList==null || playerList.isEmpty()) {
			playerList=getPlayers();	
		}

		if (null != playerList && !playerList.isEmpty()) {
			System.out.println("|------------GAME STARTED---------------|");
			RouletteGameThread thread = new RouletteGameThread();
			thread.start();

			while (takeBets) {
				System.out.println(
						"|------PLEASE PLACE A NEW BET IN ORDER :: PLAYER NAME BET(NUMBER/ ODD/ EVEN) AMOUNT (SPACE SEPARATOR)--- TYPE 'EXIT' TERMINATE THE GAME--");

				Scanner sc = new Scanner(System.in);
				String betInput = sc.nextLine();
				try {
					Bet bet = GameUtility.readBetInput(betInput, playerList);
					thread.placeANewBet(bet);
				} catch (RouletteException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

			}
		}
	}

	
	private static Set<String> getPlayers(){
		Set<String> playerList=new HashSet<String>();
		System.out.println("PLEASE ENTER THE PLAYER LIST FILE PATH");
		Scanner scanner = new Scanner(System.in);
		String filePath = scanner.nextLine();
		try {
			StringBuilder players = ReadPlayersFromFile.readfile(filePath);
			playerList = ReadPlayersFromFile.getPlayerList(players);

			System.out.println("PLAYING PLAYERS:: " + players);
		} catch (RouletteException e) {
			System.out.println(e.getMessage());
		}
		return playerList;
	}
}
