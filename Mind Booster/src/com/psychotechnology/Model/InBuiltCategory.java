package com.psychotechnology.Model;

import java.awt.Color;
import java.awt.Font;
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
			
		Font default_font=new Font("Serif", Font.ITALIC | Font.BOLD, 12);
		Color default_color=null;
		// Add Self-enhancement messages (1st person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I never give up", "/com/psychotechnology/images/7.jpg", default_font, default_color, false), new Message("I am strong", "/com/psychotechnology/images/2.jpg", default_font, default_color, false),
				new Message("I don't care what others think about me", "/com/psychotechnology/images/18.jpg", default_font, default_color, false),
				new Message("I stand out from the crowd", "/com/psychotechnology/images/4.jpg", default_font, default_color, false),
				new Message("I will be successful", "/com/psychotechnology/images/5.jpg", default_font, default_color, false),

				new Message("I have the power to achieve all of my dreams", "/com/psychotechnology/images/6.jpg", default_font, default_color, false),
				new Message("I can do anything if I set my mind to it", "/com/psychotechnology/images/7.jpg", default_font, default_color, false),
				new Message("I am the best at everything I do", "/com/psychotechnology/images/8.jpg", default_font, default_color, false),
				new Message("I am strong-minded person", "/com/psychotechnology/images/9.jpg", default_font, default_color, false),
				new Message("My dreams will become a reality", "/com/psychotechnology/images/10.jpg", default_font, default_color, false),

				new Message("I have a bright future ahead of me", "/com/psychotechnology/images/10.jpg", default_font, default_color, false),
				new Message("I focus on the positives in life", "/com/psychotechnology/images/12.jpg", default_font, default_color, false),
				new Message("I am in control of my own destiny", "/com/psychotechnology/images/13.jpg", default_font, default_color, false),
				new Message("I will climb to the top of the mountain", "/com/psychotechnology/images/14.jpg", default_font, default_color, false),
				new Message("I am talented at influencing people", "/com/psychotechnology/images/15.jpg", default_font, default_color, false),

				new Message("If I ruled the world it would be a better place", "/com/psychotechnology/images/16.jpg", default_font, default_color, false),
				new Message("I can talk my way out of anything", "/com/psychotechnology/images/17.jpg", default_font, default_color, false),
				new Message("I like to be the center of attention", "/com/psychotechnology/images/18.jpg", default_font, default_color, false),
				new Message("I am a special person", "/com/psychotechnology/images/19.jpg", default_font, default_color, false), new Message("I am assertive", "/com/psychotechnology/images/20.jpg", default_font, default_color, false),

				new Message("I like to have authority over people", "/com/psychotechnology/images/21.jpg", default_font, default_color, false),
				new Message("I find it easy to manipulate people", "/com/psychotechnology/images/22.jpg", default_font, default_color, false),
				new Message("I demand respect from people", "/com/psychotechnology/images/20.jpg", default_font, default_color, false),
				new Message("I can read people like a book", "/com/psychotechnology/images/24.jpg", default_font, default_color, false),
				new Message("I am a role model to others", "/com/psychotechnology/images/25.jpg", default_font, default_color, false),

				new Message("I love to show off", "/com/psychotechnology/images/26.jpg", default_font, default_color, false),
				new Message("I remember everything that I read", "/com/psychotechnology/images/27.jpg", default_font, default_color, false),
				new Message("I can recall facts with ease", "/com/psychotechnology/images/28.jpg", default_font, default_color, false),
				new Message("I have a photographic memory", "/com/psychotechnology/images/29.jpg", default_font, default_color, false),
				new Message("I find it easy to learn new information", "/com/psychotechnology/images/28.jpg", default_font, default_color, false),

				new Message("I am a fast learner", "/com/psychotechnology/images/28.jpg", default_font, default_color, false),
				new Message("I have a perfect memory", "/com/psychotechnology/images/29.jpg", default_font, default_color, false),
				new Message("I am a genius", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("I have a high attention span", "/com/psychotechnology/images/34.jpg", default_font, default_color, false),
				new Message("I have fast reactions", "/com/psychotechnology/images/35.jpg", default_font, default_color, false),

				new Message("I am excellent at solving problems", "/com/psychotechnology/images/36.jpg", default_font, default_color, false),
				new Message("I have a beautiful mind", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("I have an vivid imagination", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("I am a creative visionary", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("I am always thinking of new ideas", "/com/psychotechnology/images/40.jpg", default_font, default_color, false),

				new Message("I am a beautiful person", "/com/psychotechnology/images/41.jpg", default_font, default_color, false),
				new Message("I am proud of all my achievements", "/com/psychotechnology/images/42.jpg", default_font, default_color, false),
				new Message("I have many talents", "/com/psychotechnology/images/43.jpg", default_font, default_color, false),
				new Message("I like to be complimented", "/com/psychotechnology/images/41.jpg", default_font, default_color, false),
				new Message("I am a natural born leader", "/com/psychotechnology/images/25.jpg", default_font, default_color, false) })));

		// Add Self-enhancement messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You never give up", "/com/psychotechnology/images/7.jpg", default_font, default_color, false), new Message("You are strong", "/com/psychotechnology/images/2.jpg", default_font, default_color, false),
				new Message("You don't care what others think about you", "/com/psychotechnology/images/18.jpg", default_font, default_color, false),
				new Message("You stand out from the crowd", "/com/psychotechnology/images/4.jpg", default_font, default_color, false),
				new Message("You will be successful", "/com/psychotechnology/images/5.jpg", default_font, default_color, false),

				new Message("You have the power to achieve all of your dreams", "/com/psychotechnology/images/6.jpg", default_font, default_color, false),
				new Message("You can do anything if you set your mind to it", "/com/psychotechnology/images/7.jpg", default_font, default_color, false),
				new Message("You are the best at everything you do", "/com/psychotechnology/images/8.jpg", default_font, default_color, false),
				new Message("You are a strong-minded person", "/com/psychotechnology/images/9.jpg", default_font, default_color, false),
				new Message("Your dreams will become a reality", "/com/psychotechnology/images/10.jpg", default_font, default_color, false),

				new Message("You have a bright future ahead of you", "/com/psychotechnology/images/10.jpg", default_font, default_color, false),
				new Message("You focus on the positives in life", "/com/psychotechnology/images/12.jpg", default_font, default_color, false),
				new Message("You are in control of your own destiny", "/com/psychotechnology/images/13.jpg", default_font, default_color, false),
				new Message("You will climb to the top of the mountain", "/com/psychotechnology/images/14.jpg", default_font, default_color, false),
				new Message("You are talented at influencing people", "/com/psychotechnology/images/15.jpg", default_font, default_color, false),

				new Message("If you ruled the world it would be a better place", "/com/psychotechnology/images/16.jpg", default_font, default_color, false),
				new Message("You can talk your way out of anything", "/com/psychotechnology/images/17.jpg", default_font, default_color, false),
				new Message("You like to be the center of attention", "/com/psychotechnology/images/18.jpg", default_font, default_color, false),
				new Message("You are a special person", "/com/psychotechnology/images/19.jpg", default_font, default_color, false),
				new Message("You are assertive", "/com/psychotechnology/images/20.jpg", default_font, default_color, false),

				new Message("You like to have authority over people", "/com/psychotechnology/images/21.jpg", default_font, default_color, false),
				new Message("You find it easy to manipulate people", "/com/psychotechnology/images/22.jpg", default_font, default_color, false),
				new Message("You demand respect from people", "/com/psychotechnology/images/20.jpg", default_font, default_color, false),
				new Message("You can read people like a book", "/com/psychotechnology/images/24.jpg", default_font, default_color, false),
				new Message("You are a role model to others", "/com/psychotechnology/images/25.jpg", default_font, default_color, false),

				new Message("You love to show off", "/com/psychotechnology/images/26.jpg", default_font, default_color, false),
				new Message("You remember everything that you read", "/com/psychotechnology/images/27.jpg", default_font, default_color, false),
				new Message("You can recall facts with ease", "/com/psychotechnology/images/28.jpg", default_font, default_color, false),
				new Message("You have a photographic memory", "/com/psychotechnology/images/29.jpg", default_font, default_color, false),
				new Message("You find it easy to learn new information", "/com/psychotechnology/images/28.jpg", default_font, default_color, false),

				new Message("You are a fast learner", "/com/psychotechnology/images/28.jpg", default_font, default_color, false),
				new Message("You have a perfect memory", "/com/psychotechnology/images/29.jpg", default_font, default_color, false),
				new Message("You are a genius", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("You have a high attention span", "/com/psychotechnology/images/34.jpg", default_font, default_color, false),
				new Message("You have fast reactions", "/com/psychotechnology/images/35.jpg", default_font, default_color, false),

				new Message("You are excellent at solving problems", "/com/psychotechnology/images/36.jpg", default_font, default_color, false),
				new Message("You have a beautiful mind", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("You have a vivid imagination", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("You are a creative visionary", "/com/psychotechnology/images/33.jpg", default_font, default_color, false),
				new Message("You are always thinking of new ideas", "/com/psychotechnology/images/40.jpg", default_font, default_color, false),

				new Message("You are a beautiful person", "/com/psychotechnology/images/41.jpg", default_font, default_color, false),
				new Message("You are proud of all your achievements", "/com/psychotechnology/images/42.jpg", default_font, default_color, false),
				new Message("You have many talents", "/com/psychotechnology/images/43.jpg", default_font, default_color, false),
				new Message("You like to be complimented", "/com/psychotechnology/images/41.jpg", default_font, default_color, false),
				new Message("You are a natural born leader", "/com/psychotechnology/images/25.jpg", default_font, default_color, false) })));
		categories.add(new Category("Self-enhancement", messages));

		// Add Creativity messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am talented and creative", "-", default_font, default_color, false), new Message("I find inspiration everywhere", "-", default_font, default_color, false),
				new Message("I have a vivid imagination", "-", default_font, default_color, false), new Message("I am an artistic person", "-", default_font, default_color, false),
				new Message("I can create anything", "-", default_font, default_color, false),

				new Message("I have a lot of creative ideas", "-", default_font, default_color, false), new Message("I am inventive", "-", default_font, default_color, false),
				new Message("I am a visionary", "-", default_font, default_color, false), new Message("I have a powerful creative energy", "-", default_font, default_color, false),
				new Message("My ideas are artistic", "-", default_font, default_color, false) })));

		// Add Creativity messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are talented and creative", "-", default_font, default_color, false), new Message("You find inspiration everywhere", "-", default_font, default_color, false),
				new Message("You have a vivid imagination", "-", default_font, default_color, false), new Message("You are an artistic person", "-", default_font, default_color, false),
				new Message("You can create anything", "-", default_font, default_color, false),

				new Message("You have a lot of creative ideas", "-", default_font, default_color, false), new Message("You are inventive", "-", default_font, default_color, false),
				new Message("You are a visionary", "-", default_font, default_color, false), new Message("You have a powerful creative energy", "-", default_font, default_color, false),
				new Message("Your ideas are artistic", "-", default_font, default_color, false) })));

		categories.add(new Category("Creativity", messages));

		// Add Leadership messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am an alpha male", "-", default_font, default_color, false),
				new Message("People look up to me", "-", default_font, default_color, false), new Message("I am a leader", "-", default_font, default_color, false),
				new Message("I inspire people", "-", default_font, default_color, false), new Message("I have strong leadership skills", "-", default_font, default_color, false),

				new Message("No goal is unreachable for me", "-", default_font, default_color, false), new Message("I am focused and determined", "-", default_font, default_color, false),
				new Message("I am a great visionary", "-", default_font, default_color, false), new Message("I have a magnetic personality", "-", default_font, default_color, false),
				new Message("I bring out the best in people", "-", default_font, default_color, false) })));

		// Add Leadership messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are an alpha male", "-", default_font, default_color, false),
				new Message("People look up to you", "-", default_font, default_color, false), new Message("You are a leader", "-", default_font, default_color, false),
				new Message("You inspire people", "-", default_font, default_color, false), new Message("You have strong leadership skills", "-", default_font, default_color, false),

				new Message("No goal is unreachable for you", "-", default_font, default_color, false), new Message("You are focused and determined", "-", default_font, default_color, false),
				new Message("You are a great visionary", "-", default_font, default_color, false), new Message("You have a magnetic personality", "-", default_font, default_color, false),
				new Message("You bring out the best in people", "-", default_font, default_color, false) })));

		categories.add(new Category("Leadership", messages));

		// Add Memory messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I have a strong visual memory", "-", default_font, default_color, false), new Message("I recall information quickly", "-", default_font, default_color, false),
				new Message("I have a clear mind", "-", default_font, default_color, false), new Message("I have a clear memory", "-", default_font, default_color, false),
				new Message("I have a reliable memory", "-", default_font, default_color, false), new Message("I store new facts efficiently", "-", default_font, default_color, false),
				new Message("I remember names and faces easily", "-", default_font, default_color, false),
				new Message("I always remember important details", "-", default_font, default_color, false), new Message("My memory is sharp", "-", default_font, default_color, false),
				new Message("Recalling information is easy for me", "-", default_font, default_color, false),
				new Message("I have a photographic memory", "-", default_font, default_color, false) })));

		// Add Memory messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You have a strong visual memory", "-", default_font, default_color, false), new Message("You recall information quickly", "-", default_font, default_color, false),
				new Message("You have a clear mind", "-", default_font, default_color, false), new Message("You have a clear memory", "-", default_font, default_color, false),
				new Message("You have a reliable memory", "-", default_font, default_color, false), new Message("You store new facts efficiently", "-", default_font, default_color, false),
				new Message("You remember names and faces easily", "-", default_font, default_color, false),
				new Message("You always remember important details", "-", default_font, default_color, false), new Message("Your memory is sharp", "-", default_font, default_color, false),
				new Message("Recalling information is easy for you", "-", default_font, default_color, false),
				new Message("You have a photographic memory", "-", default_font, default_color, false) })));

		categories.add(new Category("Memory", messages));

		// Add Intelligence messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am smart", "-", default_font, default_color, false),
				new Message("I am an intelligent person", "-", default_font, default_color, false), new Message("I have intellectual potential", "-", default_font, default_color, false),
				new Message("I focus easily", "-", default_font, default_color, false), new Message("I can succeed at anything", "-", default_font, default_color, false),
				new Message("Intelligence fills my mind", "-", default_font, default_color, false), new Message("I learn rapidly and easily", "-", default_font, default_color, false),
				new Message("I am bright and capable", "-", default_font, default_color, false), new Message("I communicate intelligently", "-", default_font, default_color, false),
				new Message("I have a brilliant mind", "-", default_font, default_color, false) })));

		// Add Intelligence messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are smart", "-", default_font, default_color, false),
				new Message("You are an intelligent person", "-", default_font, default_color, false), new Message("You have intellectual potential", "-", default_font, default_color, false),
				new Message("You focus easily", "-", default_font, default_color, false), new Message("You can succeed at anything", "-", default_font, default_color, false),
				new Message("Intelligence fills your mind", "-", default_font, default_color, false), new Message("You learn rapidly and easily", "-", default_font, default_color, false),
				new Message("You are bright and capable", "-", default_font, default_color, false), new Message("You communicate intelligently", "-", default_font, default_color, false),
				new Message("You have a brilliant mind", "-", default_font, default_color, false) })));

		categories.add(new Category("Intelligence", messages));

		// Add Positive Thinking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("Today is beautiful", "-", default_font, default_color, false), new Message("I am in peace", "-", default_font, default_color, false),
						new Message("I refuse negativity", "-", default_font, default_color, false), new Message("I am full of potential", "-", default_font, default_color, false),
						new Message("I choose to be happy", "-", default_font, default_color, false), new Message("I am courageous", "-", default_font, default_color, false),
						new Message("I am grateful for what I have", "-", default_font, default_color, false), new Message("I feel better each day", "-", default_font, default_color, false),
						new Message("I live in the present", "-", default_font, default_color, false), new Message("I have a healthy mind", "-", default_font, default_color, false) })));

		// Add Positive Thinking messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("Today is beautiful", "-", default_font, default_color, false),
				new Message("You are in peace", "-", default_font, default_color, false), new Message("You refuse negativity", "-", default_font, default_color, false),
				new Message("You are full of potential", "-", default_font, default_color, false), new Message("You choose to be happy", "-", default_font, default_color, false),
				new Message("You are courageous", "-", default_font, default_color, false), new Message("You are grateful for what you have", "-", default_font, default_color, false),
				new Message("You feel better each day", "-", default_font, default_color, false), new Message("You live in the present", "-", default_font, default_color, false),
				new Message("You have a healthy mind", "-", default_font, default_color, false) })));

		categories.add(new Category("Positive Thinking", messages));

		// Add Self-esteem messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am worthy", "-", default_font, default_color, false),
				new Message("I have beautiful qualities", "-", default_font, default_color, false), new Message("I am smart", "-", default_font, default_color, false),
				new Message("I deserve the best", "-", default_font, default_color, false), new Message("I believe in myself", "-", default_font, default_color, false),
				new Message("I love myself", "-", default_font, default_color, false), new Message("I am talented", "-", default_font, default_color, false), new Message("I am lovable", "-", default_font, default_color, false),
				new Message("I am appreciated", "-", default_font, default_color, false), new Message("I am at peace with myself", "-", default_font, default_color, false) })));

		// Add Self-esteem messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are worthy", "-", default_font, default_color, false),
				new Message("You have beautiful qualities", "-", default_font, default_color, false), new Message("You are smart", "-", default_font, default_color, false),
				new Message("You deserve the best", "-", default_font, default_color, false), new Message("You believe in yourself", "-", default_font, default_color, false),
				new Message("You love yourself", "-", default_font, default_color, false), new Message("You are talented", "-", default_font, default_color, false),
				new Message("You are lovable", "-", default_font, default_color, false), new Message("You are appreciated", "-", default_font, default_color, false),
				new Message("You are at peace with yourself", "-", default_font, default_color, false) })));

		categories.add(new Category("Self-esteem", messages));

		// Add Motivation messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I will do what needs to be done", "-", default_font, default_color, false), new Message("I am goal-oriented", "-", default_font, default_color, false),
				new Message("I am focused", "-", default_font, default_color, false), new Message("I can and will do it", "-", default_font, default_color, false),
				new Message("I have mental strength", "-", default_font, default_color, false), new Message("I am highly motivated to succeed", "-", default_font, default_color, false),
				new Message("I am determined to succeed", "-", default_font, default_color, false), new Message("I am capable of doing it", "-", default_font, default_color, false),
				new Message("I have perseverance", "-", default_font, default_color, false), new Message("I am driven", "-", default_font, default_color, false) })));

		// Add Motivation messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You will do what needs to be done", "-", default_font, default_color, false), new Message("You are goal-oriented", "-", default_font, default_color, false),
				new Message("You are focused", "-", default_font, default_color, false), new Message("You can and will do it", "-", default_font, default_color, false),
				new Message("You have mental strength", "-", default_font, default_color, false), new Message("You are highly motivated to succeed", "-", default_font, default_color, false),
				new Message("You are determined to succeed", "-", default_font, default_color, false), new Message("You are capable of doing it", "-", default_font, default_color, false),
				new Message("You have perseverance", "-", default_font, default_color, false), new Message("You are driven", "-", default_font, default_color, false) })));

		categories.add(new Category("Motivation ", messages));

		// Add Law of Attraction messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am a positive individual", "-", default_font, default_color, false), new Message("I attract positivity", "-", default_font, default_color, false),
				new Message("My beliefs manifests in reality", "-", default_font, default_color, false),
				new Message("I have the power to change things", "-", default_font, default_color, false),
				new Message("I can achieve anything I want", "-", default_font, default_color, false), new Message("I think positively", "-", default_font, default_color, false),
				new Message("I am in control of my life", "-", default_font, default_color, false), new Message("I attract success", "-", default_font, default_color, false),
				new Message("I have a positive mindset", "-", default_font, default_color, false), new Message("I attract good experiences", "-", default_font, default_color, false) })));

		// Add Law of Attraction messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are a positive individual", "-", default_font, default_color, false), new Message("You attract positivity", "-", default_font, default_color, false),
				new Message("Your beliefs manifests in reality", "-", default_font, default_color, false),
				new Message("You have the power to change things", "-", default_font, default_color, false),
				new Message("You can achieve anything you want", "-", default_font, default_color, false), new Message("You think positively", "-", default_font, default_color, false),
				new Message("You are in control of your life", "-", default_font, default_color, false), new Message("You attract success", "-", default_font, default_color, false),
				new Message("You have a positive mindset", "-", default_font, default_color, false), new Message("You attract good experiences", "-", default_font, default_color, false) })));

		categories.add(new Category("Law of Attraction", messages));

		// Add Relationship messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I have strong social skills", "-", default_font, default_color, false), new Message("I am a likeable person", "-", default_font, default_color, false),
				new Message("I have a lot of friends", "-", default_font, default_color, false), new Message("I am loved", "-", default_font, default_color, false),
				new Message("I have healthy relationships", "-", default_font, default_color, false), new Message("I have quality relationships", "-", default_font, default_color, false),
				new Message("I can communicate with anyone", "-", default_font, default_color, false), new Message("I can befriend anyone", "-", default_font, default_color, false),
				new Message("My presence is enjoyable", "-", default_font, default_color, false), new Message("People respect me", "-", default_font, default_color, false) })));

		// Add Relationship messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You have strong social skills", "-", default_font, default_color, false), new Message("You are a likeable person", "-", default_font, default_color, false),
				new Message("You have a lot of friends", "-", default_font, default_color, false), new Message("You are loved", "-", default_font, default_color, false),
				new Message("You have healthy relationships", "-", default_font, default_color, false), new Message("You have quality relationships", "-", default_font, default_color, false),
				new Message("You can communicate with anyone", "-", default_font, default_color, false), new Message("You can befriend anyone", "-", default_font, default_color, false),
				new Message("Your presence is enjoyable", "-", default_font, default_color, false), new Message("People respect you", "-", default_font, default_color, false) })));

		categories.add(new Category("Relationships", messages));

		// Add Quit Smoking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I can quit smoking and I will", "-", default_font, default_color, false), new Message("I have the strength to quit", "-", default_font, default_color, false),
				new Message("I do not need to smoke", "-", default_font, default_color, false), new Message("I choose a healthy life", "-", default_font, default_color, false),
				new Message("I do not crave nicotine", "-", default_font, default_color, false), new Message("I choose health", "-", default_font, default_color, false),
				new Message("I am free", "-", default_font, default_color, false), new Message("I refuse dependency", "-", default_font, default_color, false),
				new Message("I have mental strength", "-", default_font, default_color, false), new Message("I will never smoke again", "-", default_font, default_color, false) })));

		// Add Quit Smoking messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You can quit smoking and you will", "-", default_font, default_color, false),
						new Message("You have the strength to quit", "-", default_font, default_color, false), new Message("You do not need to smoke", "-", default_font, default_color, false),
						new Message("You choose a healthy life", "-", default_font, default_color, false), new Message("You do not crave nicotine", "-", default_font, default_color, false),
						new Message("You choose health ", "-", default_font, default_color, false), new Message("You are free", "-", default_font, default_color, false),
						new Message("You refuse dependency", "-", default_font, default_color, false), new Message("You have mental strength", "-", default_font, default_color, false),
						new Message("You will never smoke again", "-", default_font, default_color, false) })));

		categories.add(new Category("Quit Smoking", messages));

		// Add Quit Drinking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I can quit drinking and I will", "-", default_font, default_color, false), new Message("My health is important", "-", default_font, default_color, false),
				new Message("I choose a healthy life", "-", default_font, default_color, false), new Message("I am free", "-", default_font, default_color, false),
				new Message("I have mental strength", "-", default_font, default_color, false), new Message("I refuse dependency", "-", default_font, default_color, false),
				new Message("I will never drink again", "-", default_font, default_color, false), new Message("I do not need to drink", "-", default_font, default_color, false),
				new Message("I do not crave drinking", "-", default_font, default_color, false), new Message("I refuse dependency", "-", default_font, default_color, false) })));

		// Add Quit Drinking messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You can quit drinking and you will", "-", default_font, default_color, false), new Message("Your health is important", "-", default_font, default_color, false),
				new Message("You choose a healthy life", "-", default_font, default_color, false), new Message("You are free", "-", default_font, default_color, false),
				new Message("You have mental strength", "-", default_font, default_color, false), new Message("You refuse dependency", "-", default_font, default_color, false),
				new Message("You will never drink again", "-", default_font, default_color, false), new Message("You do not need to drink", "-", default_font, default_color, false),
				new Message("You do not crave drinking", "-", default_font, default_color, false), new Message("You refuse dependency", "-", default_font, default_color, false) })));

		categories.add(new Category("Quit Drinking", messages));

		// Add Quit Porn messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I choose a healthy lifestyle", "-", default_font, default_color, false),
				new Message("I have the mental strength to quit", "-", default_font, default_color, false), new Message("I refuse dependency", "-", default_font, default_color, false),
				new Message("I choose to be free", "-", default_font, default_color, false), new Message("I do not crave porn", "-", default_font, default_color, false),
				new Message("I can have a healthy sexual life", "-", default_font, default_color, false),
				new Message("I know too much porn is unhealthy", "-", default_font, default_color, false), new Message("I control sexual urges", "-", default_font, default_color, false),
				new Message("My attitude toward sex is healthy", "-", default_font, default_color, false),
				new Message("My willpower is stronger", "-", default_font, default_color, false) })));

		// Add Quit Porn messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You choose a healthy lifestyle", "-", default_font, default_color, false),
				new Message("You have the mental strength to quit", "-", default_font, default_color, false), new Message("You refuse dependency", "-", default_font, default_color, false),
				new Message("You choose to be free", "-", default_font, default_color, false), new Message("You do not crave porn", "-", default_font, default_color, false),
				new Message("You can have a healthy sexual life", "-", default_font, default_color, false),
				new Message("You know too much porn is unhealthy", "-", default_font, default_color, false), new Message("You control sexual urges", "-", default_font, default_color, false),
				new Message("Your attitude toward sex is healthy", "-", default_font, default_color, false),
				new Message("Your willpower is stronger", "-", default_font, default_color, false) })));

		categories.add(new Category("Quit porn", messages));

		// Add Exercise messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I can and will exercise", "-", default_font, default_color, false),
				new Message("I have strength and motivation", "-", default_font, default_color, false), new Message("I have will power", "-", default_font, default_color, false),
				new Message("I choose a healthy lifestyle", "-", default_font, default_color, false),
				new Message("I choose to live in a healthy body", "-", default_font, default_color, false), new Message("I can do it", "-", default_font, default_color, false),
				new Message("I feel accomplished when I exercise", "-", default_font, default_color, false), new Message("My body is strong", "-", default_font, default_color, false),
				new Message("I am determined", "-", default_font, default_color, false), new Message("I am focused", "-", default_font, default_color, false) })));

		// Add Exercise messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You can and will exercise", "-", default_font, default_color, false),
				new Message("You have strength and motivation", "-", default_font, default_color, false), new Message("You have will power", "-", default_font, default_color, false),
				new Message("You choose a healthy lifestyle", "-", default_font, default_color, false),
				new Message("You choose to live in a healthy body", "-", default_font, default_color, false), new Message("You can do it", "-", default_font, default_color, false),
				new Message("You feel accomplished when you exercise", "-", default_font, default_color, false), new Message("Your body is strong", "-", default_font, default_color, false),
				new Message("You are determined", "-", default_font, default_color, false), new Message("You are focused", "-", default_font, default_color, false) })));

		categories.add(new Category("Exercise", messages));

		// Add Confidence messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am confident in my abilities", "-", default_font, default_color, false), new Message("I know who I am and what I want", "-", default_font, default_color, false),
				new Message("I am worthy", "-", default_font, default_color, false), new Message("I am a strong individual", "-", default_font, default_color, false),
				new Message("I have potential", "-", default_font, default_color, false), new Message("I can overcome any challenge", "-", default_font, default_color, false),
				new Message("I exude confidence", "-", default_font, default_color, false), new Message("I am bold and assertive", "-", default_font, default_color, false),
				new Message("I am fierce", "-", default_font, default_color, false), new Message("I have courage", "-", default_font, default_color, false) })));

		// Add Confidence messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You are confident in your abilities", "-", default_font, default_color, false),
						new Message("You know who you are and what you want", "-", default_font, default_color, false), new Message("You are worthy", "-", default_font, default_color, false),
						new Message("You are a strong individual", "-", default_font, default_color, false), new Message("You have potential", "-", default_font, default_color, false),
						new Message("You can overcome any challenge", "-", default_font, default_color, false), new Message("You exude confidence", "-", default_font, default_color, false),
						new Message("You are bold and assertive", "-", default_font, default_color, false), new Message("You are fierce", "-", default_font, default_color, false),
						new Message("You have courage", "-", default_font, default_color, false) })));

		categories.add(new Category("Confidence", messages));

		// Add Millionaire Mindset messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am goal oriented", "-", default_font, default_color, false),
				new Message("I am driven", "-", default_font, default_color, false), new Message("I am successful", "-", default_font, default_color, false),
				new Message("I can achieve anything", "-", default_font, default_color, false), new Message("I attract abundance", "-", default_font, default_color, false),
				new Message("I am wealthy", "-", default_font, default_color, false), new Message("I have power", "-", default_font, default_color, false),
				new Message("I have business potential", "-", default_font, default_color, false), new Message("I overcome financial obstacles", "-", default_font, default_color, false),
				new Message("I have financial success", "-", default_font, default_color, false) })));

		// Add Millionaire Mindset messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are goal oriented", "-", default_font, default_color, false),
				new Message("You are driven", "-", default_font, default_color, false), new Message("You are successful", "-", default_font, default_color, false),
				new Message("You can achieve anything", "-", default_font, default_color, false), new Message("You attract abundance", "-", default_font, default_color, false),
				new Message("You are wealthy", "-", default_font, default_color, false), new Message("You have power", "-", default_font, default_color, false),
				new Message("You have business potential", "-", default_font, default_color, false), new Message("You overcome financial obstacles", "-", default_font, default_color, false),
				new Message("You have financial success", "-", default_font, default_color, false) })));

		categories.add(new Category("Millionaire Mindset", messages));

		return categories;
	}

}
