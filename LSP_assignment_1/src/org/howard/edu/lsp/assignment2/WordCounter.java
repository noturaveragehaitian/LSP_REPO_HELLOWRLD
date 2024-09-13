package org.howard.edu.lsp.assignment2;
import java.util.HashMap;
import java.util.Map.Entry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class WordCounter {
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> wordHash = new HashMap<String, Integer>();

		try (Scanner myReader = new Scanner(new File("./words.txt").getCanonicalPath())) {
			while(myReader.hasNextLine()) {
				String line = myReader.nextLine();
				line = line.replaceAll("[^a-zA-Z\\s]", "");	// exclude all special characters and numbers
				String[] words = line.split("\\s+");
				for(String word : words) {
					word = word.toLowerCase();
					if(word.length() > 3) {
						if(wordHash.containsKey(word)) {
							wordHash.put(word, wordHash.getOrDefault(word, 0) + 1); // add to value if word in wordHash
						}															// create new key if word is not in wordHash
					}
				}
			}
			for(Entry<String, Integer> entry : wordHash.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}	 
		}
		catch (FileNotFoundException e) {
			System.out.println("could not complete word filter." + e.getMessage());
		}
	}
}