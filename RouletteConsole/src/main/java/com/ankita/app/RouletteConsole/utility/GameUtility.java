package com.ankita.app.RouletteConsole.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.ankita.app.RouletteConsole.TO.BetResult;
import com.ankita.app.RouletteConsole.TO.Bet;
import com.ankita.app.RouletteConsole.constant.RouletteConstant;
import com.ankita.app.RouletteConsole.enums.BetType;
import com.ankita.app.RouletteConsole.exceptions.RouletteException;

public class GameUtility {

	public static List<BetResult> betResultCalculate(List<Bet> betList, int rouletteNumber) {
		List<BetResult> betResultList = new ArrayList<BetResult>();
		boolean rouletteNumberIsEven = (rouletteNumber % 2 == 0) ? true : false;
		if (null != betList && !betList.isEmpty()) {
			BetResult betResult = null;
			for (Bet bet : betList) {
				betResult = new BetResult();
				betResult.setPlayerName(bet.getPlayerName());
				betResult.setBidAmount(bet.getBidAmount());
				if ((bet.getBidType().getValue().equalsIgnoreCase(RouletteConstant.EVEN_NUMBER))
						|| (bet.getBidType().getValue().equalsIgnoreCase(RouletteConstant.ODD_NUMBER))) {
					betResult.setPlacedBid(bet.getBidType().getValue());
				} else {
					betResult.setPlacedBid(String.valueOf(bet.getBidNumber()));
				}

				if (bet.getBidType().getValue().equalsIgnoreCase(RouletteConstant.EVEN_NUMBER)
						&& rouletteNumberIsEven) {
					betResult.setWinner(true);
				} else if (bet.getBidType().getValue().equalsIgnoreCase(RouletteConstant.ODD_NUMBER)
						&& !rouletteNumberIsEven) {
					betResult.setWinner(true);
				} else if (bet.getBidType().getValue().equalsIgnoreCase(RouletteConstant.NUMBER)
						&& bet.getBidNumber() == rouletteNumber) {
					betResult.setWinner(true);
				} else {
					betResult.setWinner(false);
				}
				betResult.setWinAmount(
						winningAmountCalculation(bet.getBidAmount(), bet.getBidType(), betResult.isWinner()));
				betResultList.add(betResult);
			}
		}

		return betResultList;
	}

	private static double winningAmountCalculation(double bidAmount, BetType bidType, boolean isWinner) {

		double winAmount = 0.0;
		if (isWinner) {
			if (bidType.getValue().equalsIgnoreCase(RouletteConstant.EVEN_NUMBER)
					|| bidType.getValue().equalsIgnoreCase(RouletteConstant.ODD_NUMBER)) {
				winAmount = bidAmount * 2;
			} else if (bidType.getValue().equalsIgnoreCase(RouletteConstant.NUMBER)) {
				winAmount = bidAmount * 36;
			}
		}
		return winAmount;
	}

	public static int generateRouletteNumber() {
		Random random = new Random();
		int min = 1;
		int max = 36;
		int randomValue = random.nextInt((max - min) + 1) + min;
		return randomValue;
	}

	public static Bet readBetInput(String input, Set<String> playerList) throws RouletteException {
		if (input.equalsIgnoreCase("EXIT")) {
			System.exit(0);
		}
		Bet newBid = null;
		if (null != input && input.split(" ").length == 3) {
			String playerName = input.split(" ")[0].trim();
			String bid = input.split(" ")[1].trim();
			String amount = input.split(" ")[2].trim();
			newBid = new Bet();
			
			if (playerList.contains(playerName.toLowerCase())) {
				newBid.setPlayerName(playerName);
				if ((bid.equalsIgnoreCase(BetType.EVEN.getValue())) || (bid.equalsIgnoreCase(BetType.ODD.getValue()))) {
					newBid.setBidType((bid.equalsIgnoreCase(RouletteConstant.EVEN_NUMBER)) ? BetType.EVEN : BetType.ODD);
					try {
						double bidamount = Double.parseDouble(amount);
						newBid.setBidAmount(bidamount);

					} catch (NumberFormatException e) {
						throw new RouletteException(
								"INVALID BET PLACED. PLEASE PLACE A VALID BET IN ORDER :: PLAYER NAME BID(NUMBER/ ODD/ EVEN) AMOUNT (SPACE SEPARATOR)");

					}
				} else {
					try {
						int bidNumber = Integer.parseInt(bid);
						if (bidNumber >= 1 && bidNumber <= 36) {
							newBid.setBidType(BetType.NUMBER);
							newBid.setBidNumber(bidNumber);
							try {
								double bidamount = Double.parseDouble(amount);
								newBid.setBidAmount(bidamount);

							} catch (NumberFormatException e) {
								throw new RouletteException(
										"INVALID BET PLACED. PLEASE PLACE A VALID BET IN ORDER :: PLAYER NAME BID(NUMBER/ ODD/ EVEN) AMOUNT (SPACE SEPARATOR)");

							}
						} else {
							throw new RouletteException("Please enter number between 1 - 36");
						}
					} catch (NumberFormatException e) {
						throw new RouletteException(
								"INVALID BET PLACED. PLEASE PLACE A VALID BET IN ORDER :: PLAYER NAME BID(NUMBER/ ODD/ EVEN) AMOUNT (SPACE SEPARATOR)");
					}
				}
			} else {
				throw new RouletteException("The player does not exist in the provided player list file");
			}
		} else {
			throw new RouletteException(
					"INVALID BET PLACED. PLEASE PLACE A VALID BET IN ORDER :: PLAYER NAME BID(NUMBER/ ODD/ EVEN) AMOUNT (SPACE SEPARATOR)");
		}

		return newBid;
	}

}
