package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;


public class TweetListModel
{
	
	private ArrayList<LonelyTweetModel> tweets;
	
	public TweetListModel() {
		super();
		tweets=new ArrayList<LonelyTweetModel>();
	}
	
	public void add(LonelyTweetModel lonelyTweetModel) {
		ArrayList<String> tweetStrings=this.getTweets();
		if (tweetStrings.contains(lonelyTweetModel.getText())) {
			throw new IllegalArgumentException("Tweet already exists");
		}
		else {
			tweets.add(lonelyTweetModel);
		}
	}
	
	public boolean hasTweet(String tweet) {
		return this.getTweets().contains(tweet);
	}
	
	public Integer getCount() {
		return tweets.size();
	}
	
	public LonelyTweetModel getItem(int position) {
		return tweets.get(position-1);
	}
	
	public ArrayList<String> getTweets() {
		ArrayList<String> tweetStrings=new ArrayList<String>();
		for (LonelyTweetModel ltm: tweets) {
			tweetStrings.add(ltm.getText());
		}
		return tweetStrings;
	}

}
