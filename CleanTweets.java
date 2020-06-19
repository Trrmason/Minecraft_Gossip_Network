package project;
import java.util.HashMap;
import java.util.Scanner;

public class CleanTweets {
	
	private HashMap<String, Integer> tweetStore;
	
	public CleanTweets() {}
	
	public void print() {
		int count = 0;
		for (String key : tweetStore.keySet()) {
			count++;
			System.out.println(key);
		}
		System.out.println("afinisheda");
	}
	
	public void LoadTweets() {
		tweetStore = new HashMap<String, Integer>();
		Scanner in = new Scanner(System.in);
		int count;
		while(in.hasNextLine()) {
			String tweet = in.nextLine().toLowerCase().substring(1);
			//Use ragex to replace all special characters
			tweet = tweet.replaceAll("[^a-zA-Z]", " ");
			//There was a lot of odd spam tweets that was just a bunch of numbers so the only way to get rid of them was to remove all tweets with numbers.
			//This probably got rid of a lot of real tweets too, but the amount of spam tweets was overwhelming.
			tweet = tweet.replaceAll("[0-9]", "%");
			tweet = tweet.trim();
			if (tweet.contentEquals("afinisheda")) {
				break;
			}
			//remove all tweets that contain these, http is to get rid of spam and image tweets.
			if (!tweet.contains("http") && !tweet.contains("%") && 
				!tweet.contains("pic") && !tweet.contains(" xe ") &&
				!tweet.contains(" xa ") && !tweet.contains(" xc ") &&
				!tweet.contains(" xd ") && !tweet.contains(" x ") &&
				!tweet.contains(" xx ") && !tweet.contains(" xxx ")){
				
				if (tweetStore.containsKey(tweet)) {
					count = tweetStore.get(tweet);
					tweetStore.put(tweet, count+1);
				}
				else {
					tweetStore.put(tweet, 1);
				}
			}
		}
		print();
	}
	
	
	public static void main(String[] args) {
		CleanTweets t = new CleanTweets();
		t.LoadTweets();
	}
}
