package project;

import java.util.Scanner;
import java.util.TreeMap;

public class TweetCount {
	
	private TreeMap<String, Integer> tweetStore;
	
	public TweetCount() {}
	
	public void print() {
		int count = 0;
		for (String key : tweetStore.keySet()) {
			if (tweetStore.get(key) > 100) {
				count++;
				System.out.println(key);
			}
		}
		System.out.println("afinisheda");
	}
	
	
	
	public void LoadTweets() {
		tweetStore = new TreeMap<String, Integer>();
		Scanner in = new Scanner(System.in);
		int count;
		while(in.hasNext()) {
			String tweet = in.next().toLowerCase();
			tweet = tweet.replaceAll("[0-9]", "!");
			if (tweet.contentEquals("afinisheda")) {
				break;
			}
			if (tweet.length() != 1){
				if (!tweet.contains("!")) {
					if (tweetStore.containsKey(tweet)) {
						count = tweetStore.get(tweet);
						tweetStore.put(tweet, count+1);
					}
					else {
						tweetStore.put(tweet, 1);
					}
				}
			}
		}
		print();
	}
	
	
	
	
	public static void main(String[] args) {
		TweetCount t = new TweetCount();
		t.LoadTweets();
	}
}
