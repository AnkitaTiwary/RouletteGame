package com.ankita.app.RouletteConsole.TO;

import com.ankita.app.RouletteConsole.enums.BetType;

public class Bet {

	private String playerName;
	private int playerId;
	private double bidAmount;
	private BetType bidType;
	private int bidNumber;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public BetType getBidType() {
		return bidType;
	}

	public void setBidType(BetType bidType) {
		this.bidType = bidType;
	}

	public int getBidNumber() {
		return bidNumber;
	}

	public void setBidNumber(int bidNumber) {
		this.bidNumber = bidNumber;
	}

	public Bet(String playerName, double bidAmount, BetType bidType, int bidNumber) {
		super();
		this.playerName = playerName;
		this.bidAmount = bidAmount;
		this.bidType = bidType;
		this.bidNumber = bidNumber;
	}

	public Bet(String playerName, double bidAmount, BetType bidType) {
		super();
		this.playerName = playerName;
		this.bidAmount = bidAmount;
		this.bidType = bidType;
	}

	public Bet() {
	}

	@Override
	public String toString() {
		return "Bid [playerName=" + playerName + ", playerId=" + playerId + ", bidAmount=" + bidAmount + ", bidType="
				+ bidType + ", bidNumber=" + bidNumber + "]";
	}
	
	

}
