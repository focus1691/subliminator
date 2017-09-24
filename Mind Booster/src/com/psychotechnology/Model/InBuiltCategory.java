package com.psychotechnology.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class InBuiltCategory {

	private ArrayList<Category> categories = new ArrayList<Category>();

	/**
	 * 
	 * @return list of all built-in categories, with their messages
	 */
	public ArrayList<Category> getCateories() {

		ArrayList<ArrayList<Message>> messages = new ArrayList<ArrayList<Message>>();

		// Add Self-enhancement messages (1st person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I never give up", "/com/psychotechnology/images/7.jpg"), new Message("I am strong", "/com/psychotechnology/images/2.jpg"),
				new Message("I don't care what others think about me", "/com/psychotechnology/images/18.jpg"),
				new Message("I stand out from the crowd", "/com/psychotechnology/images/4.jpg"),
				new Message("I will be successful", "/com/psychotechnology/images/5.jpg"),

				new Message("I have the power to achieve all of my dreams", "/com/psychotechnology/images/6.jpg"),
				new Message("I can do anything if I set my mind to it", "/com/psychotechnology/images/7.jpg"),
				new Message("I am the best at everything I do", "/com/psychotechnology/images/8.jpg"),
				new Message("I am strong-minded person", "/com/psychotechnology/images/9.jpg"),
				new Message("My dreams will become a reality", "/com/psychotechnology/images/10.jpg"),

				new Message("I have a bright future ahead of me", "/com/psychotechnology/images/10.jpg"),
				new Message("I focus on the positives in life", "/com/psychotechnology/images/12.jpg"),
				new Message("I am in control of my own destiny", "/com/psychotechnology/images/13.jpg"),
				new Message("I will climb to the top of the mountain", "/com/psychotechnology/images/14.jpg"),
				new Message("I am talented at influencing people", "/com/psychotechnology/images/15.jpg"),

				new Message("If I ruled the world it would be a better place", "/com/psychotechnology/images/16.jpg"),
				new Message("I can talk my way out of anything", "/com/psychotechnology/images/17.jpg"),
				new Message("I like to be the center of attention", "/com/psychotechnology/images/18.jpg"),
				new Message("I am a special person", "/com/psychotechnology/images/19.jpg"), new Message("I am assertive", "/com/psychotechnology/images/20.jpg"),

				new Message("I like to have authority over people", "/com/psychotechnology/images/21.jpg"),
				new Message("I find it easy to manipulate people", "/com/psychotechnology/images/22.jpg"),
				new Message("I demand respect from people", "/com/psychotechnology/images/20.jpg"),
				new Message("I can read people like a book", "/com/psychotechnology/images/24.jpg"),
				new Message("I am a role model to others", "/com/psychotechnology/images/25.jpg"),

				new Message("I love to show off", "/com/psychotechnology/images/26.jpg"),
				new Message("I remember everything that I read", "/com/psychotechnology/images/27.jpg"),
				new Message("I can recall facts with ease", "/com/psychotechnology/images/28.jpg"),
				new Message("I have a photographic memory", "/com/psychotechnology/images/29.jpg"),
				new Message("I find it easy to learn new information", "/com/psychotechnology/images/28.jpg"),

				new Message("I am a fast learner", "/com/psychotechnology/images/28.jpg"),
				new Message("I have a perfect memory", "/com/psychotechnology/images/29.jpg"),
				new Message("I am a genius", "/com/psychotechnology/images/33.jpg"),
				new Message("I have a high attention span", "/com/psychotechnology/images/34.jpg"),
				new Message("I have fast reactions", "/com/psychotechnology/images/35.jpg"),

				new Message("I am excellent at solving problems", "/com/psychotechnology/images/36.jpg"),
				new Message("I have a beautiful mind", "/com/psychotechnology/images/33.jpg"),
				new Message("I have an vivid imagination", "/com/psychotechnology/images/33.jpg"),
				new Message("I am a creative visionary", "/com/psychotechnology/images/33.jpg"),
				new Message("I am always thinking of new ideas", "/com/psychotechnology/images/40.jpg"),

				new Message("I am a beautiful person", "/com/psychotechnology/images/41.jpg"),
				new Message("I am proud of all my achievements", "/com/psychotechnology/images/42.jpg"),
				new Message("I have many talents", "/com/psychotechnology/images/43.jpg"),
				new Message("I like to be complimented", "/com/psychotechnology/images/41.jpg"),
				new Message("I am a natural born leader", "/com/psychotechnology/images/25.jpg") })));

		// Add Self-enhancement messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You never give up", "/com/psychotechnology/images/7.jpg"), new Message("You are strong", "/com/psychotechnology/images/2.jpg"),
				new Message("You don't care what others think about you", "/com/psychotechnology/images/18.jpg"),
				new Message("You stand out from the crowd", "/com/psychotechnology/images/4.jpg"),
				new Message("You will be successful", "/com/psychotechnology/images/5.jpg"),

				new Message("You have the power to achieve all of your dreams", "/com/psychotechnology/images/6.jpg"),
				new Message("You can do anything if you set your mind to it", "/com/psychotechnology/images/7.jpg"),
				new Message("You are the best at everything you do", "/com/psychotechnology/images/8.jpg"),
				new Message("You are a strong-minded person", "/com/psychotechnology/images/9.jpg"),
				new Message("Your dreams will become a reality", "/com/psychotechnology/images/10.jpg"),

				new Message("You have a bright future ahead of you", "/com/psychotechnology/images/10.jpg"),
				new Message("You focus on the positives in life", "/com/psychotechnology/images/12.jpg"),
				new Message("You are in control of your own destiny", "/com/psychotechnology/images/13.jpg"),
				new Message("You will climb to the top of the mountain", "/com/psychotechnology/images/14.jpg"),
				new Message("You are talented at influencing people", "/com/psychotechnology/images/15.jpg"),

				new Message("If you ruled the world it would be a better place", "/com/psychotechnology/images/16.jpg"),
				new Message("You can talk your way out of anything", "/com/psychotechnology/images/17.jpg"),
				new Message("You like to be the center of attention", "/com/psychotechnology/images/18.jpg"),
				new Message("You are a special person", "/com/psychotechnology/images/19.jpg"),
				new Message("You are assertive", "/com/psychotechnology/images/20.jpg"),

				new Message("You like to have authority over people", "/com/psychotechnology/images/21.jpg"),
				new Message("You find it easy to manipulate people", "/com/psychotechnology/images/22.jpg"),
				new Message("You demand respect from people", "/com/psychotechnology/images/20.jpg"),
				new Message("You can read people like a book", "/com/psychotechnology/images/24.jpg"),
				new Message("You are a role model to others", "/com/psychotechnology/images/25.jpg"),

				new Message("You love to show off", "/com/psychotechnology/images/26.jpg"),
				new Message("You remember everything that you read", "/com/psychotechnology/images/27.jpg"),
				new Message("You can recall facts with ease", "/com/psychotechnology/images/28.jpg"),
				new Message("You have a photographic memory", "/com/psychotechnology/images/29.jpg"),
				new Message("You find it easy to learn new information", "/com/psychotechnology/images/28.jpg"),

				new Message("You are a fast learner", "/com/psychotechnology/images/28.jpg"),
				new Message("You have a perfect memory", "/com/psychotechnology/images/29.jpg"),
				new Message("You are a genius", "/com/psychotechnology/images/33.jpg"),
				new Message("You have a high attention span", "/com/psychotechnology/images/34.jpg"),
				new Message("You have fast reactions", "/com/psychotechnology/images/35.jpg"),

				new Message("You are excellent at solving problems", "/com/psychotechnology/images/36.jpg"),
				new Message("You have a beautiful mind", "/com/psychotechnology/images/33.jpg"),
				new Message("You have a vivid imagination", "/com/psychotechnology/images/33.jpg"),
				new Message("You are a creative visionary", "/com/psychotechnology/images/33.jpg"),
				new Message("You are always thinking of new ideas", "/com/psychotechnology/images/40.jpg"),

				new Message("You are a beautiful person", "/com/psychotechnology/images/41.jpg"),
				new Message("You are proud of all your achievements", "/com/psychotechnology/images/42.jpg"),
				new Message("You have many talents", "/com/psychotechnology/images/43.jpg"),
				new Message("You like to be complimented", "/com/psychotechnology/images/41.jpg"),
				new Message("You are a natural born leader", "/com/psychotechnology/images/25.jpg") })));
		categories.add(new Category("Self-enhancement", messages));

		// Add Creativity messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am talented and creative", "-"), new Message("I find inspiration everywhere", "-"),
				new Message("I have a vivid imagination", "-"), new Message("I am an artistic person", "-"),
				new Message("I can create anything", "-"),

				new Message("I have a lot of creative ideas", "-"), new Message("I am inventive", "-"),
				new Message("I am a visionary", "-"), new Message("I have a powerful creative energy", "-"),
				new Message("My ideas are artistic", "-") })));

		// Add Creativity messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are talented and creative", "-"), new Message("You find inspiration everywhere", "-"),
				new Message("You have a vivid imagination", "-"), new Message("You are an artistic person", "-"),
				new Message("You can create anything", "-"),

				new Message("You have a lot of creative ideas", "-"), new Message("You are inventive", "-"),
				new Message("You are a visionary", "-"), new Message("You have a powerful creative energy", "-"),
				new Message("Your ideas are artistic", "-") })));

		categories.add(new Category("Creativity", messages));

		// Add Leadership messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am an alpha male", "-"),
				new Message("People look up to me", "-"), new Message("I am a leader", "-"),
				new Message("I inspire people", "-"), new Message("I have strong leadership skills", "-"),

				new Message("No goal is unreachable for me", "-"), new Message("I am focused and determined", "-"),
				new Message("I am a great visionary", "-"), new Message("I have a magnetic personality", "-"),
				new Message("I bring out the best in people", "-") })));

		// Add Leadership messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are an alpha male", "-"),
				new Message("People look up to you", "-"), new Message("You are a leader", "-"),
				new Message("You inspire people", "-"), new Message("You have strong leadership skills", "-"),

				new Message("No goal is unreachable for you", "-"), new Message("You are focused and determined", "-"),
				new Message("You are a great visionary", "-"), new Message("You have a magnetic personality", "-"),
				new Message("You bring out the best in people", "-") })));

		categories.add(new Category("Leadership", messages));

		// Add Memory messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I have a strong visual memory", "-"), new Message("I recall information quickly", "-"),
				new Message("I have a clear mind", "-"), new Message("I have a clear memory", "-"),
				new Message("I have a reliable memory", "-"), new Message("I store new facts efficiently", "-"),
				new Message("I remember names and faces easily", "-"),
				new Message("I always remember important details", "-"), new Message("My memory is sharp", "-"),
				new Message("Recalling information is easy for me", "-"),
				new Message("I have a photographic memory", "-") })));

		// Add Memory messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You have a strong visual memory", "-"), new Message("You recall information quickly", "-"),
				new Message("You have a clear mind", "-"), new Message("You have a clear memory", "-"),
				new Message("You have a reliable memory", "-"), new Message("You store new facts efficiently", "-"),
				new Message("You remember names and faces easily", "-"),
				new Message("You always remember important details", "-"), new Message("Your memory is sharp", "-"),
				new Message("Recalling information is easy for you", "-"),
				new Message("You have a photographic memory", "-") })));

		categories.add(new Category("Memory", messages));

		// Add Intelligence messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am smart", "-"),
				new Message("I am an intelligent person", "-"), new Message("I have intellectual potential", "-"),
				new Message("I focus easily", "-"), new Message("I can succeed at anything", "-"),
				new Message("Intelligence fills my mind", "-"), new Message("I learn rapidly and easily", "-"),
				new Message("I am bright and capable", "-"), new Message("I communicate intelligently", "-"),
				new Message("I have a brilliant mind", "-") })));

		// Add Intelligence messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are smart", "-"),
				new Message("You are an intelligent person", "-"), new Message("You have intellectual potential", "-"),
				new Message("You focus easily", "-"), new Message("You can succeed at anything", "-"),
				new Message("Intelligence fills your mind", "-"), new Message("You learn rapidly and easily", "-"),
				new Message("You are bright and capable", "-"), new Message("You communicate intelligently", "-"),
				new Message("You have a brilliant mind", "-") })));

		categories.add(new Category("Intelligence", messages));

		// Add Positive Thinking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("Today is beautiful", "-"), new Message("I am in peace", "-"),
						new Message("I refuse negativity", "-"), new Message("I am full of potential", "-"),
						new Message("I choose to be happy", "-"), new Message("I am courageous", "-"),
						new Message("I am grateful for what I have", "-"), new Message("I feel better each day", "-"),
						new Message("I live in the present", "-"), new Message("I have a healthy mind", "-") })));

		// Add Positive Thinking messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("Today is beautiful", "-"),
				new Message("You are in peace", "-"), new Message("You refuse negativity", "-"),
				new Message("You are full of potential", "-"), new Message("You choose to be happy", "-"),
				new Message("You are courageous", "-"), new Message("You are grateful for what you have", "-"),
				new Message("You feel better each day", "-"), new Message("You live in the present", "-"),
				new Message("You have a healthy mind", "-") })));

		categories.add(new Category("Positive Thinking", messages));

		// Add Self-esteem messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am worthy", "-"),
				new Message("I have beautiful qualities", "-"), new Message("I am smart", "-"),
				new Message("I deserve the best", "-"), new Message("I believe in myself", "-"),
				new Message("I love myself", "-"), new Message("I am talented", "-"), new Message("I am lovable", "-"),
				new Message("I am appreciated", "-"), new Message("I am at peace with myself", "-") })));

		// Add Self-esteem messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are worthy", "-"),
				new Message("You have beautiful qualities", "-"), new Message("You are smart", "-"),
				new Message("You deserve the best", "-"), new Message("You believe in yourself", "-"),
				new Message("You love yourself", "-"), new Message("You are talented", "-"),
				new Message("You are lovable", "-"), new Message("You are appreciated", "-"),
				new Message("You are at peace with yourself", "-") })));

		categories.add(new Category("Self-esteem", messages));

		// Add Motivation messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I will do what needs to be done", "-"), new Message("I am goal-oriented", "-"),
				new Message("I am focused", "-"), new Message("I can and will do it", "-"),
				new Message("I have mental strength", "-"), new Message("I am highly motivated to succeed", "-"),
				new Message("I am determined to succeed", "-"), new Message("I am capable of doing it", "-"),
				new Message("I have perseverance", "-"), new Message("I am driven", "-") })));

		// Add Motivation messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You will do what needs to be done", "-"), new Message("You are goal-oriented", "-"),
				new Message("You are focused", "-"), new Message("You can and will do it", "-"),
				new Message("You have mental strength", "-"), new Message("You are highly motivated to succeed", "-"),
				new Message("You are determined to succeed", "-"), new Message("You are capable of doing it", "-"),
				new Message("You have perseverance", "-"), new Message("You are driven", "-") })));

		categories.add(new Category("Motivation ", messages));

		// Add Law of Attraction messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am a positive individual", "-"), new Message("I attract positivity", "-"),
				new Message("My beliefs manifests in reality", "-"),
				new Message("I have the power to change things", "-"),
				new Message("I can achieve anything I want", "-"), new Message("I think positively", "-"),
				new Message("I am in control of my life", "-"), new Message("I attract success", "-"),
				new Message("I have a positive mindset", "-"), new Message("I attract good experiences", "-") })));

		// Add Law of Attraction messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are a positive individual", "-"), new Message("You attract positivity", "-"),
				new Message("Your beliefs manifests in reality", "-"),
				new Message("You have the power to change things", "-"),
				new Message("You can achieve anything you want", "-"), new Message("You think positively", "-"),
				new Message("You are in control of your life", "-"), new Message("You attract success", "-"),
				new Message("You have a positive mindset", "-"), new Message("You attract good experiences", "-") })));

		categories.add(new Category("Law of Attraction", messages));

		// Add Relationship messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I have strong social skills", "-"), new Message("I am a likeable person", "-"),
				new Message("I have a lot of friends", "-"), new Message("I am loved", "-"),
				new Message("I have healthy relationships", "-"), new Message("I have quality relationships", "-"),
				new Message("I can communicate with anyone", "-"), new Message("I can befriend anyone", "-"),
				new Message("My presence is enjoyable", "-"), new Message("People respect me", "-") })));

		// Add Relationship messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You have strong social skills", "-"), new Message("You are a likeable person", "-"),
				new Message("You have a lot of friends", "-"), new Message("You are loved", "-"),
				new Message("You have healthy relationships", "-"), new Message("You have quality relationships", "-"),
				new Message("You can communicate with anyone", "-"), new Message("You can befriend anyone", "-"),
				new Message("Your presence is enjoyable", "-"), new Message("People respect you", "-") })));

		categories.add(new Category("Relationships", messages));

		// Add Quit Smoking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I can quit smoking and I will", "-"), new Message("I have the strength to quit", "-"),
				new Message("I do not need to smoke", "-"), new Message("I choose a healthy life", "-"),
				new Message("I do not crave nicotine", "-"), new Message("I choose health", "-"),
				new Message("I am free", "-"), new Message("I refuse dependency", "-"),
				new Message("I have mental strength", "-"), new Message("I will never smoke again", "-") })));

		// Add Quit Smoking messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You can quit smoking and you will", "-"),
						new Message("You have the strength to quit", "-"), new Message("You do not need to smoke", "-"),
						new Message("You choose a healthy life", "-"), new Message("You do not crave nicotine", "-"),
						new Message("You choose health ", "-"), new Message("You are free", "-"),
						new Message("You refuse dependency", "-"), new Message("You have mental strength", "-"),
						new Message("You will never smoke again", "-") })));

		categories.add(new Category("Quit Smoking", messages));

		// Add Quit Drinking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I can quit drinking and I will", "-"), new Message("My health is important", "-"),
				new Message("I choose a healthy life", "-"), new Message("I am free", "-"),
				new Message("I have mental strength", "-"), new Message("I refuse dependency", "-"),
				new Message("I will never drink again", "-"), new Message("I do not need to drink", "-"),
				new Message("I do not crave drinking", "-"), new Message("I refuse dependency", "-") })));

		// Add Quit Drinking messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You can quit drinking and you will", "-"), new Message("Your health is important", "-"),
				new Message("You choose a healthy life", "-"), new Message("You are free", "-"),
				new Message("You have mental strength", "-"), new Message("You refuse dependency", "-"),
				new Message("You will never drink again", "-"), new Message("You do not need to drink", "-"),
				new Message("You do not crave drinking", "-"), new Message("You refuse dependency", "-") })));

		categories.add(new Category("Quit Drinking", messages));

		// Add Quit Porn messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I choose a healthy lifestyle", "-"),
				new Message("I have the mental strength to quit", "-"), new Message("I refuse dependency", "-"),
				new Message("I choose to be free", "-"), new Message("I do not crave porn", "-"),
				new Message("I can have a healthy sexual life", "-"),
				new Message("I know too much porn is unhealthy", "-"), new Message("I control sexual urges", "-"),
				new Message("My attitude toward sex is healthy", "-"),
				new Message("My willpower is stronger", "-") })));

		// Add Quit Porn messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You choose a healthy lifestyle", "-"),
				new Message("You have the mental strength to quit", "-"), new Message("You refuse dependency", "-"),
				new Message("You choose to be free", "-"), new Message("You do not crave porn", "-"),
				new Message("You can have a healthy sexual life", "-"),
				new Message("You know too much porn is unhealthy", "-"), new Message("You control sexual urges", "-"),
				new Message("Your attitude toward sex is healthy", "-"),
				new Message("Your willpower is stronger", "-") })));

		categories.add(new Category("Quit porn", messages));

		// Add Exercise messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I can and will exercise", "-"),
				new Message("I have strength and motivation", "-"), new Message("I have will power", "-"),
				new Message("I choose a healthy lifestyle", "-"),
				new Message("I choose to live in a healthy body", "-"), new Message("I can do it", "-"),
				new Message("I feel accomplished when I exercise", "-"), new Message("My body is strong", "-"),
				new Message("I am determined", "-"), new Message("I am focused", "-") })));

		// Add Exercise messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You can and will exercise", "-"),
				new Message("You have strength and motivation", "-"), new Message("You have will power", "-"),
				new Message("You choose a healthy lifestyle", "-"),
				new Message("You choose to live in a healthy body", "-"), new Message("You can do it", "-"),
				new Message("You feel accomplished when you exercise", "-"), new Message("Your body is strong", "-"),
				new Message("You are determined", "-"), new Message("You are focused", "-") })));

		categories.add(new Category("Exercise", messages));

		// Add Confidence messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am confident in my abilities", "-"), new Message("I know who I am and what I want", "-"),
				new Message("I am worthy", "-"), new Message("I am a strong individual", "-"),
				new Message("I have potential", "-"), new Message("I can overcome any challenge", "-"),
				new Message("I exude confidence", "-"), new Message("I am bold and assertive", "-"),
				new Message("I am fierce", "-"), new Message("I have courage", "-") })));

		// Add Confidence messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You are confident in your abilities", "-"),
						new Message("You know who you are and what you want", "-"), new Message("You are worthy", "-"),
						new Message("You are a strong individual", "-"), new Message("You have potential", "-"),
						new Message("You can overcome any challenge", "-"), new Message("You exude confidence", "-"),
						new Message("You are bold and assertive", "-"), new Message("You are fierce", "-"),
						new Message("You have courage", "-") })));

		categories.add(new Category("Confidence", messages));

		// Add Millionaire Mindset messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am goal oriented", "-"),
				new Message("I am driven", "-"), new Message("I am successful", "-"),
				new Message("I can achieve anything", "-"), new Message("I attract abundance", "-"),
				new Message("I am wealthy", "-"), new Message("I have power", "-"),
				new Message("I have business potential", "-"), new Message("I overcome financial obstacles", "-"),
				new Message("I have financial success", "-") })));

		// Add Millionaire Mindset messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are goal oriented", "-"),
				new Message("You are driven", "-"), new Message("You are successful", "-"),
				new Message("You can achieve anything", "-"), new Message("You attract abundance", "-"),
				new Message("You are wealthy", "-"), new Message("You have power", "-"),
				new Message("You have business potential", "-"), new Message("You overcome financial obstacles", "-"),
				new Message("You have financial success", "-") })));

		categories.add(new Category("Millionaire Mindset", messages));

		return categories;
	}

}
