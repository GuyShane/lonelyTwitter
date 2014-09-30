import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.TweetListModel;



public class TweetListModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{
	public TweetListModelTest()
	{
		super(LonelyTwitterActivity.class);
	}
	
	public void testAddTweets() {
		TweetListModel tlm=new TweetListModel();
		tlm.add(new LonelyTweetModel("Test"));
		assertEquals(tlm.getCount(),Integer.valueOf(1));
	}
	
	public void testAddSameTweet() {
		LonelyTweetModel same=new LonelyTweetModel("Test");
		TweetListModel tlm=new TweetListModel();
		tlm.add(same);
		try {
			tlm.add(same);
			fail("Same tweet added");
		} catch (IllegalArgumentException iarge) {
			assertEquals(IllegalArgumentException.class,iarge.getClass());
		}
	}
	
	public void testAddDifferentCaseTweet() {
		LonelyTweetModel same=new LonelyTweetModel("Test");
		LonelyTweetModel differentCase=new LonelyTweetModel("test");
		TweetListModel tlm=new TweetListModel();
		tlm.add(same);
		try {
			tlm.add(differentCase);
			assertTrue(true);
		} catch (IllegalArgumentException iarge) {
			fail("Tweets were not the same");
		}
	}
	
	public void testGetItem() {
		TweetListModel tlm=new TweetListModel();
		LonelyTweetModel first=new LonelyTweetModel("Test");
		tlm.add(first);
		assertSame(first, tlm.getItem(1));
	}
	
	public void testGetTweets() {
		TweetListModel tlm=new TweetListModel();
		tlm.add(new LonelyTweetModel("one"));
		tlm.add(new LonelyTweetModel("two"));
		tlm.add(new LonelyTweetModel("three"));
		ArrayList<String> shouldGet=new ArrayList<String>();
		shouldGet.add("one");
		shouldGet.add("two");
		shouldGet.add("three");
		assertTrue(tlm.getTweets().equals(shouldGet));
	}
	
	public void testGetTweetOrder() {
		TweetListModel tlm=new TweetListModel();
		tlm.add(new LonelyTweetModel("one"));
		tlm.add(new LonelyTweetModel("two"));
		tlm.add(new LonelyTweetModel("three"));
		ArrayList<String> shouldGet=new ArrayList<String>();
		shouldGet.add("one");
		shouldGet.add("three");
		shouldGet.add("two");
		assertFalse(tlm.getTweets().equals(shouldGet));
	}
	
	public void testHasTweet() {
		TweetListModel tlm=new TweetListModel();
		LonelyTweetModel shouldHave=new LonelyTweetModel("one");
		tlm.add(shouldHave);
		assertTrue(tlm.hasTweet("one"));
	}
	
	public void testHasTweetDifferencCase() {
		TweetListModel tlm=new TweetListModel();
		LonelyTweetModel shouldHave=new LonelyTweetModel("one");
		tlm.add(shouldHave);
		assertFalse(tlm.hasTweet("One"));
	}
	
	public void testGetCount() {
		TweetListModel tlm=new TweetListModel();
		tlm.add(new LonelyTweetModel("one"));
		tlm.add(new LonelyTweetModel("two"));
		tlm.add(new LonelyTweetModel("three"));
		assertEquals(Integer.valueOf(3), tlm.getCount());
	}

}