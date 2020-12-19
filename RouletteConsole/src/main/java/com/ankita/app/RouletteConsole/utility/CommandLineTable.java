package com.ankita.app.RouletteConsole.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ankita.app.RouletteConsole.TO.BetResult;
import com.github.freva.asciitable.AsciiTable;

public class CommandLineTable {

	public static void printTable(List<BetResult> resultList, int rouletteNumber) {

		System.out.println("|------------------------GAME RESULT-------------------------------|");
		System.out.println("|----WINNING NUMBER: " + rouletteNumber + "--------|");
		if (null != resultList && !resultList.isEmpty()) {
			String[] headers = { "", "PLAYER", "BID NUMBER /(ODD/EVEN)", "BID AMOUNT", "RESULT", "WIN AMOUNT" };

			String[][] rows = new String[resultList.size()][6];
			int index = 0;
			for (BetResult result : resultList) {
				rows[index][0] = String.valueOf(index + 1);
				rows[index][1] = result.getPlayerName().toUpperCase();
				rows[index][2] = result.getPlacedBid();
				rows[index][3] = String.valueOf(result.getBidAmount());
				rows[index][4] = (result.isWinner() ? "WIN" : "LOSE");
				rows[index][5] = String.valueOf(result.getWinAmount());
				index++;
			}
			System.out.println(AsciiTable.getTable(headers, rows));
		}
	}

}
