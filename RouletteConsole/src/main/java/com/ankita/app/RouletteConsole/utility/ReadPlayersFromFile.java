package com.ankita.app.RouletteConsole.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.ankita.app.RouletteConsole.constant.RouletteConstant;
import com.ankita.app.RouletteConsole.exceptions.RouletteException;

public class ReadPlayersFromFile {

	public static StringBuilder readfile(String filePath) throws RouletteException {
		StringBuilder fileData = new StringBuilder();
		try {
			File myObj = new File(filePath);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				// System.out.println(data);
				if (fileData.length() != 0) {
					fileData.append(", ");
				}
				fileData.append(data);

			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			throw new RouletteException(RouletteConstant.FILE_NOT_FOUND_MESSAGE);
		}

		return fileData;
	}

	public static Set<String> getPlayerList(StringBuilder fileData) {
		String[] players = null;
		Set<String> playerSet=new  HashSet<String>();
		if (null != fileData) {
			players = fileData.toString().split(", ");
			for(int i=0;i<players.length;i++) {
				playerSet.add(players[i].toLowerCase());
			}
			
		}

		return playerSet;
	}
}
