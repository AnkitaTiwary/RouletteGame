package com.ankita.app.RouletteConsole.TO;

public class BetResult {
	private String playerName;
	private String placedBid;
	private boolean isWinner;
	private double winAmount;
	private double bidAmount;

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public BetResult(String playerName, boolean isWinner, double winAmount) {
		super();
		this.playerName = playerName;
		this.isWinner = isWinner;
		this.winAmount = winAmount;
	}

	public BetResult(String playerName, String placedBid, boolean isWinner, double winAmount, double bidAmount) {
		super();
		this.playerName = playerName;
		this.placedBid = placedBid;
		this.isWinner = isWinner;
		this.winAmount = winAmount;
		this.bidAmount = bidAmount;
	}

	public BetResult(String playerName, String placedBid, boolean isWinner, double winAmount) {
		super();
		this.playerName = playerName;
		this.placedBid = placedBid;
		this.isWinner = isWinner;
		this.winAmount = winAmount;
	}

	public String getPlacedBid() {
		return placedBid;
	}

	public void setPlacedBid(String placedBid) {
		this.placedBid = placedBid;
	}

	public BetResult() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}

	public double getWinAmount() {
		return winAmount;
	}

	public void setWinAmount(double winAmount) {
		this.winAmount = winAmount;
	}

	@Override
	public String toString() {
		return "BetResult [playerName=" + playerName + ", placedBid=" + placedBid + ", isWinner=" + isWinner
				+ ", winAmount=" + winAmount + ", bidAmount=" + bidAmount + "]";
	}
	
	

}
