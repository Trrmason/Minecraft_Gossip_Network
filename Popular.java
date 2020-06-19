package project;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public class Popular {
	
	//Used treemap to have organized source words, makes it easier to read.
	private TreeMap<String, HashMap<String, Integer>> sequence;
	
	public Popular() {}
	
	
	public String[][] TopFive(HashMap<String, Integer> values) {
		//For this I used a matrix to store the top five words and their count
		String[][] top = new String[2][5];
		for (int i = 0; i < 5; i++) {
			top[0][i] = "0";
			top[1][i] = "0";
		}
		//This populates the matrix with the top five target words.
		for (String key: values.keySet()) {
			int cur = values.get(key);
			for (int i = 0; i < 5; i++) {
				if (cur > Integer.parseInt(top[1][i])) {
					if (key.length() > 1 && key != "i") {
						top[1][i] = Integer.toString(cur);
						top[0][i] = key;
						break;
					}
				}
			}
		}
		return top;
	}
	
	public void Print() {
		//Print for a csv file
		System.out.println("key,word,occurance");
		for (String key : sequence.keySet()) {
			if (sequence.get(key).size() > 200) {
				String[][] out = TopFive(sequence.get(key));
				for (int i = 0; i < 5; i++) {
					System.out.println(key + "," + out[0][i] + "," + out[1][i]);
				}
			}
		}
	}
	
	
	public HashMap<String, Integer> PopulateValue(HashMap<String, Integer> values, String val) {
		//Helper function to manage sequence's value hashmap.
		//Takes the target word as key and keeps a count as value. 
		int count;
		if (values.containsKey(val)) {
			count = values.get(val);
			values.put(val, count+1);
		}else {
			values.put(val, 1);
		}
		return values;
		}
	
	
	public void PopularSequence() {
		sequence = new TreeMap<String, HashMap<String, Integer>>();
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) {
			String tweet = in.nextLine();
			//For some reason scanner wasn't noticing the end of the file so i added a helper.
			if (tweet.contentEquals("afinisheda")) {break;}
			String[] splitTweet = tweet.split("\\s+");
			//This loop takes the key and creates a hashmap for the value if the key doesn't exist
			//If the key does exist it calls the helper function and populates the temp hashmap to be stored in sequence.
			for (int i = 0; i < splitTweet.length-1; i++) {
				//Grabs the source i and target i+1.
				if (splitTweet[i].length() > 1 || splitTweet[i] == "i" || splitTweet[i] == "a") {
					if (sequence.containsKey(splitTweet[i])) {
						HashMap<String, Integer> values = sequence.get(splitTweet[i]);
						sequence.put(splitTweet[i], PopulateValue(values, splitTweet[i+1]));
					}
					else {
						HashMap<String, Integer> temp = new HashMap<String, Integer>();
						temp.put(splitTweet[i], 1);
						sequence.put(splitTweet[i], temp);
					}
				}
			}
		}
		Print();
	}
	
	public static void main(String[] args) {
		Popular p = new Popular();
		p.PopularSequence();
	}
}
