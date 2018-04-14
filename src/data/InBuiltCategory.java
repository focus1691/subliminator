package data;

import java.util.ArrayList;
import java.util.Arrays;

import model.Category;
import model.Message;

public class InBuiltCategory {

	private ArrayList<Category> categories = new ArrayList<Category>();

	/**
	 * 
	 * @return list of all built-in categories, with their messages
	 */
	public ArrayList<Category> getCateories() {

		ArrayList<ArrayList<Message>> messages = new ArrayList<ArrayList<Message>>();
		// Add Self-enhancement messages (1st person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("I never give up", "/images/7.jpg", false),
						new Message("I am strong", "/images/2.jpg", false),
						new Message("I don't care what others think about me", "/images/18.jpg", false),
						new Message("I stand out from the crowd", "/images/4.jpg", false),
						new Message("I will be successful", "/images/5.jpg", false),

						new Message("I have the power to achieve all of my dreams", "/images/6.jpg", false),
						new Message("I can do anything if I set my mind to it", "/images/7.jpg", false),
						new Message("I am the best at everything I do", "/images/8.jpg", false),
						new Message("I am strong-minded person", "/images/9.jpg", false),
						new Message("My dreams will become a reality", "/images/10.jpg", false),

						new Message("I have a bright future ahead of me", "/images/10.jpg", false),
						new Message("I focus on the positives in life", "/images/12.jpg", false),
						new Message("I am in control of my own destiny", "/images/13.jpg", false),
						new Message("I will climb to the top of the mountain", "/images/14.jpg", false),
						new Message("I am talented at influencing people", "/images/15.jpg", false),

						new Message("If I ruled the world it would be a better place", "/images/16.jpg", false),
						new Message("I can talk my way out of anything", "/images/17.jpg", false),
						new Message("I like to be the center of attention", "/images/18.jpg", false),
						new Message("I am a special person", "/images/19.jpg", false),
						new Message("I am assertive", "/images/20.jpg", false),

						new Message("I like to have authority over people", "/images/21.jpg", false),
						new Message("I find it easy to manipulate people", "/images/22.jpg", false),
						new Message("I demand respect from people", "/images/20.jpg", false),
						new Message("I can read people like a book", "/images/24.jpg", false),
						new Message("I am a role model to others", "/images/25.jpg", false),

						new Message("I love to show off", "/images/26.jpg", false),
						new Message("I remember everything that I read", "/images/27.jpg", false),
						new Message("I can recall facts with ease", "/images/28.jpg", false),
						new Message("I have a photographic memory", "/images/29.jpg", false),
						new Message("I find it easy to learn new information", "/images/28.jpg", false),

						new Message("I am a fast learner", "/images/28.jpg", false),
						new Message("I have a perfect memory", "/images/29.jpg", false),
						new Message("I am a genius", "/images/33.jpg", false),
						new Message("I have a high attention span", "/images/34.jpg", false),
						new Message("I have fast reactions", "/images/35.jpg", false),

						new Message("I am excellent at solving problems", "/images/36.jpg", false),
						new Message("I have a beautiful mind", "/images/33.jpg", false),
						new Message("I have an vivid imagination", "/images/33.jpg", false),
						new Message("I am a creative visionary", "/images/33.jpg", false),
						new Message("I am always thinking of new ideas", "/images/40.jpg", false),

						new Message("I am a beautiful person", "/images/41.jpg", false),
						new Message("I am proud of all my achievements", "/images/42.jpg", false),
						new Message("I have many talents", "/images/43.jpg", false),
						new Message("I like to be complimented", "/images/41.jpg", false),
						new Message("I am a natural born leader", "/images/25.jpg", false) })));

		// Add Self-enhancement messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You never give up", "/images/7.jpg", false),
						new Message("You are strong", "/images/2.jpg", false),
						new Message("You don't care what others think about you", "/images/18.jpg", false),
						new Message("You stand out from the crowd", "/images/4.jpg", false),
						new Message("You will be successful", "/images/5.jpg", false),

						new Message("You have the power to achieve all of your dreams", "/images/6.jpg", false),
						new Message("You can do anything if you set your mind to it", "/images/7.jpg", false),
						new Message("You are the best at everything you do", "/images/8.jpg", false),
						new Message("You are a strong-minded person", "/images/9.jpg", false),
						new Message("Your dreams will become a reality", "/images/10.jpg", false),

						new Message("You have a bright future ahead of you", "/images/10.jpg", false),
						new Message("You focus on the positives in life", "/images/12.jpg", false),
						new Message("You are in control of your own destiny", "/images/13.jpg", false),
						new Message("You will climb to the top of the mountain", "/images/14.jpg", false),
						new Message("You are talented at influencing people", "/images/15.jpg", false),

						new Message("If you ruled the world it would be a better place", "/images/16.jpg", false),
						new Message("You can talk your way out of anything", "/images/17.jpg", false),
						new Message("You like to be the center of attention", "/images/18.jpg", false),
						new Message("You are a special person", "/images/19.jpg", false),
						new Message("You are assertive", "/images/20.jpg", false),

						new Message("You like to have authority over people", "/images/21.jpg", false),
						new Message("You find it easy to manipulate people", "/images/22.jpg", false),
						new Message("You demand respect from people", "/images/20.jpg", false),
						new Message("You can read people like a book", "/images/24.jpg", false),
						new Message("You are a role model to others", "/images/25.jpg", false),

						new Message("You love to show off", "/images/26.jpg", false),
						new Message("You remember everything that you read", "/images/27.jpg", false),
						new Message("You can recall facts with ease", "/images/28.jpg", false),
						new Message("You have a photographic memory", "/images/29.jpg", false),
						new Message("You find it easy to learn new information", "/images/28.jpg", false),

						new Message("You are a fast learner", "/images/28.jpg", false),
						new Message("You have a perfect memory", "/images/29.jpg", false),
						new Message("You are a genius", "/images/33.jpg", false),
						new Message("You have a high attention span", "/images/34.jpg", false),
						new Message("You have fast reactions", "/images/35.jpg", false),

						new Message("You are excellent at solving problems", "/images/36.jpg", false),
						new Message("You have a beautiful mind", "/images/33.jpg", false),
						new Message("You have a vivid imagination", "/images/33.jpg", false),
						new Message("You are a creative visionary", "/images/33.jpg", false),
						new Message("You are always thinking of new ideas", "/images/40.jpg", false),

						new Message("You are a beautiful person", "/images/41.jpg", false),
						new Message("You are proud of all your achievements", "/images/42.jpg", false),
						new Message("You have many talents", "/images/43.jpg", false),
						new Message("You like to be complimented", "/images/41.jpg", false),
						new Message("You are a natural born leader", "/images/25.jpg", false) })));
		categories.add(new Category("Self-enhancement", messages));

		// Add Creativity messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am talented and creative", "-", false),
				new Message("I find inspiration everywhere", "-", false),
				new Message("I have a vivid imagination", "-", false),
				new Message("I am an artistic person", "-", false), new Message("I can create anything", "-", false),

				new Message("I have a lot of creative ideas", "-", false), new Message("I am inventive", "-", false),
				new Message("I am a visionary", "-", false),
				new Message("I have a powerful creative energy", "-", false),
				new Message("My ideas are artistic", "-", false) })));

		// Add Creativity messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You are talented and creative", "-", false),
						new Message("You find inspiration everywhere", "-", false),
						new Message("You have a vivid imagination", "-", false),
						new Message("You are an artistic person", "-", false),
						new Message("You can create anything", "-", false),

						new Message("You have a lot of creative ideas", "-", false),
						new Message("You are inventive", "-", false), new Message("You are a visionary", "-", false),
						new Message("You have a powerful creative energy", "-", false),
						new Message("Your ideas are artistic", "-", false) })));

		categories.add(new Category("Creativity", messages));

		// Add Leadership messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am an alpha male", "-", false),
				new Message("People look up to me", "-", false), new Message("I am a leader", "-", false),
				new Message("I inspire people", "-", false), new Message("I have strong leadership skills", "-", false),

				new Message("No goal is unreachable for me", "-", false),
				new Message("I am focused and determined", "-", false),
				new Message("I am a great visionary", "-", false),
				new Message("I have a magnetic personality", "-", false),
				new Message("I bring out the best in people", "-", false) })));

		// Add Leadership messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are an alpha male", "-", false), new Message("People look up to you", "-", false),
				new Message("You are a leader", "-", false), new Message("You inspire people", "-", false),
				new Message("You have strong leadership skills", "-", false),

				new Message("No goal is unreachable for you", "-", false),
				new Message("You are focused and determined", "-", false),
				new Message("You are a great visionary", "-", false),
				new Message("You have a magnetic personality", "-", false),
				new Message("You bring out the best in people", "-", false) })));

		categories.add(new Category("Leadership", messages));

		// Add Memory messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I have a strong visual memory", "-", false),
				new Message("I recall information quickly", "-", false), new Message("I have a clear mind", "-", false),
				new Message("I have a clear memory", "-", false), new Message("I have a reliable memory", "-", false),
				new Message("I store new facts efficiently", "-", false),
				new Message("I remember names and faces easily", "-", false),
				new Message("I always remember important details", "-", false),
				new Message("My memory is sharp", "-", false),
				new Message("Recalling information is easy for me", "-", false),
				new Message("I have a photographic memory", "-", false) })));

		// Add Memory messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You have a strong visual memory", "-", false),
				new Message("You recall information quickly", "-", false),
				new Message("You have a clear mind", "-", false), new Message("You have a clear memory", "-", false),
				new Message("You have a reliable memory", "-", false),
				new Message("You store new facts efficiently", "-", false),
				new Message("You remember names and faces easily", "-", false),
				new Message("You always remember important details", "-", false),
				new Message("Your memory is sharp", "-", false),
				new Message("Recalling information is easy for you", "-", false),
				new Message("You have a photographic memory", "-", false) })));

		categories.add(new Category("Memory", messages));

		// Add Intelligence messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am smart", "-", false),
				new Message("I am an intelligent person", "-", false),
				new Message("I have intellectual potential", "-", false), new Message("I focus easily", "-", false),
				new Message("I can succeed at anything", "-", false),
				new Message("Intelligence fills my mind", "-", false),
				new Message("I learn rapidly and easily", "-", false),
				new Message("I am bright and capable", "-", false),
				new Message("I communicate intelligently", "-", false),
				new Message("I have a brilliant mind", "-", false) })));

		// Add Intelligence messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are smart", "-", false),
				new Message("You are an intelligent person", "-", false),
				new Message("You have intellectual potential", "-", false), new Message("You focus easily", "-", false),
				new Message("You can succeed at anything", "-", false),
				new Message("Intelligence fills your mind", "-", false),
				new Message("You learn rapidly and easily", "-", false),
				new Message("You are bright and capable", "-", false),
				new Message("You communicate intelligently", "-", false),
				new Message("You have a brilliant mind", "-", false) })));

		categories.add(new Category("Intelligence", messages));

		// Add Positive Thinking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("Today is beautiful", "-", false),
				new Message("I am in peace", "-", false), new Message("I refuse negativity", "-", false),
				new Message("I am full of potential", "-", false), new Message("I choose to be happy", "-", false),
				new Message("I am courageous", "-", false), new Message("I am grateful for what I have", "-", false),
				new Message("I feel better each day", "-", false), new Message("I live in the present", "-", false),
				new Message("I have a healthy mind", "-", false) })));

		// Add Positive Thinking messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("Today is beautiful", "-", false),
				new Message("You are in peace", "-", false), new Message("You refuse negativity", "-", false),
				new Message("You are full of potential", "-", false), new Message("You choose to be happy", "-", false),
				new Message("You are courageous", "-", false),
				new Message("You are grateful for what you have", "-", false),
				new Message("You feel better each day", "-", false), new Message("You live in the present", "-", false),
				new Message("You have a healthy mind", "-", false) })));

		categories.add(new Category("Positive Thinking", messages));

		// Add Self-esteem messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("I am worthy", "-", false),
				new Message("I have beautiful qualities", "-", false), new Message("I am smart", "-", false),
				new Message("I deserve the best", "-", false), new Message("I believe in myself", "-", false),
				new Message("I love myself", "-", false), new Message("I am talented", "-", false),
				new Message("I am lovable", "-", false), new Message("I am appreciated", "-", false),
				new Message("I am at peace with myself", "-", false) })));

		// Add Self-esteem messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] { new Message("You are worthy", "-", false),
				new Message("You have beautiful qualities", "-", false), new Message("You are smart", "-", false),
				new Message("You deserve the best", "-", false), new Message("You believe in yourself", "-", false),
				new Message("You love yourself", "-", false), new Message("You are talented", "-", false),
				new Message("You are lovable", "-", false), new Message("You are appreciated", "-", false),
				new Message("You are at peace with yourself", "-", false) })));

		categories.add(new Category("Self-esteem", messages));

		// Add Motivation messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I will do what needs to be done", "-", false),
				new Message("I am goal-oriented", "-", false), new Message("I am focused", "-", false),
				new Message("I can and will do it", "-", false), new Message("I have mental strength", "-", false),
				new Message("I am highly motivated to succeed", "-", false),
				new Message("I am determined to succeed", "-", false),
				new Message("I am capable of doing it", "-", false), new Message("I have perseverance", "-", false),
				new Message("I am driven", "-", false) })));

		// Add Motivation messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You will do what needs to be done", "-", false),
				new Message("You are goal-oriented", "-", false), new Message("You are focused", "-", false),
				new Message("You can and will do it", "-", false), new Message("You have mental strength", "-", false),
				new Message("You are highly motivated to succeed", "-", false),
				new Message("You are determined to succeed", "-", false),
				new Message("You are capable of doing it", "-", false),
				new Message("You have perseverance", "-", false), new Message("You are driven", "-", false) })));

		categories.add(new Category("Motivation ", messages));

		// Add Law of Attraction messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am a positive individual", "-", false), new Message("I attract positivity", "-", false),
				new Message("My beliefs manifests in reality", "-", false),
				new Message("I have the power to change things", "-", false),
				new Message("I can achieve anything I want", "-", false), new Message("I think positively", "-", false),
				new Message("I am in control of my life", "-", false), new Message("I attract success", "-", false),
				new Message("I have a positive mindset", "-", false),
				new Message("I attract good experiences", "-", false) })));

		// Add Law of Attraction messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are a positive individual", "-", false),
				new Message("You attract positivity", "-", false),
				new Message("Your beliefs manifests in reality", "-", false),
				new Message("You have the power to change things", "-", false),
				new Message("You can achieve anything you want", "-", false),
				new Message("You think positively", "-", false),
				new Message("You are in control of your life", "-", false),
				new Message("You attract success", "-", false), new Message("You have a positive mindset", "-", false),
				new Message("You attract good experiences", "-", false) })));

		categories.add(new Category("Law of Attraction", messages));

		// Add Relationship messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I have strong social skills", "-", false),
				new Message("I am a likeable person", "-", false), new Message("I have a lot of friends", "-", false),
				new Message("I am loved", "-", false), new Message("I have healthy relationships", "-", false),
				new Message("I have quality relationships", "-", false),
				new Message("I can communicate with anyone", "-", false),
				new Message("I can befriend anyone", "-", false), new Message("My presence is enjoyable", "-", false),
				new Message("People respect me", "-", false) })));

		// Add Relationship messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You have strong social skills", "-", false),
						new Message("You are a likeable person", "-", false),
						new Message("You have a lot of friends", "-", false), new Message("You are loved", "-", false),
						new Message("You have healthy relationships", "-", false),
						new Message("You have quality relationships", "-", false),
						new Message("You can communicate with anyone", "-", false),
						new Message("You can befriend anyone", "-", false),
						new Message("Your presence is enjoyable", "-", false),
						new Message("People respect you", "-", false) })));

		categories.add(new Category("Relationships", messages));

		// Add Quit Smoking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I can quit smoking and I will", "-", false),
				new Message("I have the strength to quit", "-", false),
				new Message("I do not need to smoke", "-", false), new Message("I choose a healthy life", "-", false),
				new Message("I do not crave nicotine", "-", false), new Message("I choose health", "-", false),
				new Message("I am free", "-", false), new Message("I refuse dependency", "-", false),
				new Message("I have mental strength", "-", false),
				new Message("I will never smoke again", "-", false) })));

		// Add Quit Smoking messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You can quit smoking and you will", "-", false),
				new Message("You have the strength to quit", "-", false),
				new Message("You do not need to smoke", "-", false),
				new Message("You choose a healthy life", "-", false),
				new Message("You do not crave nicotine", "-", false), new Message("You choose health ", "-", false),
				new Message("You are free", "-", false), new Message("You refuse dependency", "-", false),
				new Message("You have mental strength", "-", false),
				new Message("You will never smoke again", "-", false) })));

		categories.add(new Category("Quit Smoking", messages));

		// Add Quit Drinking messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I can quit drinking and I will", "-", false),
				new Message("My health is important", "-", false), new Message("I choose a healthy life", "-", false),
				new Message("I am free", "-", false), new Message("I have mental strength", "-", false),
				new Message("I refuse dependency", "-", false), new Message("I will never drink again", "-", false),
				new Message("I do not need to drink", "-", false), new Message("I do not crave drinking", "-", false),
				new Message("I refuse dependency", "-", false) })));

		// Add Quit Drinking messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You can quit drinking and you will", "-", false),
				new Message("Your health is important", "-", false),
				new Message("You choose a healthy life", "-", false), new Message("You are free", "-", false),
				new Message("You have mental strength", "-", false), new Message("You refuse dependency", "-", false),
				new Message("You will never drink again", "-", false),
				new Message("You do not need to drink", "-", false),
				new Message("You do not crave drinking", "-", false),
				new Message("You refuse dependency", "-", false) })));

		categories.add(new Category("Quit Drinking", messages));

		// Add Quit Porn messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("I choose a healthy lifestyle", "-", false),
						new Message("I have the mental strength to quit", "-", false),
						new Message("I refuse dependency", "-", false), new Message("I choose to be free", "-", false),
						new Message("I do not crave porn", "-", false),
						new Message("I can have a healthy sexual life", "-", false),
						new Message("I know too much porn is unhealthy", "-", false),
						new Message("I control sexual urges", "-", false),
						new Message("My attitude toward sex is healthy", "-", false),
						new Message("My willpower is stronger", "-", false) })));

		// Add Quit Porn messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You choose a healthy lifestyle", "-", false),
				new Message("You have the mental strength to quit", "-", false),
				new Message("You refuse dependency", "-", false), new Message("You choose to be free", "-", false),
				new Message("You do not crave porn", "-", false),
				new Message("You can have a healthy sexual life", "-", false),
				new Message("You know too much porn is unhealthy", "-", false),
				new Message("You control sexual urges", "-", false),
				new Message("Your attitude toward sex is healthy", "-", false),
				new Message("Your willpower is stronger", "-", false) })));

		categories.add(new Category("Quit porn", messages));

		// Add Exercise messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I can and will exercise", "-", false),
				new Message("I have strength and motivation", "-", false), new Message("I have will power", "-", false),
				new Message("I choose a healthy lifestyle", "-", false),
				new Message("I choose to live in a healthy body", "-", false), new Message("I can do it", "-", false),
				new Message("I feel accomplished when I exercise", "-", false),
				new Message("My body is strong", "-", false), new Message("I am determined", "-", false),
				new Message("I am focused", "-", false) })));

		// Add Exercise messages (2nd person)
		messages.add(new ArrayList<Message>(
				Arrays.asList(new Message[] { new Message("You can and will exercise", "-", false),
						new Message("You have strength and motivation", "-", false),
						new Message("You have will power", "-", false),
						new Message("You choose a healthy lifestyle", "-", false),
						new Message("You choose to live in a healthy body", "-", false),
						new Message("You can do it", "-", false),
						new Message("You feel accomplished when you exercise", "-", false),
						new Message("Your body is strong", "-", false), new Message("You are determined", "-", false),
						new Message("You are focused", "-", false) })));

		categories.add(new Category("Exercise", messages));

		// Add Confidence messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("I am confident in my abilities", "-", false),
				new Message("I know who I am and what I want", "-", false), new Message("I am worthy", "-", false),
				new Message("I am a strong individual", "-", false), new Message("I have potential", "-", false),
				new Message("I can overcome any challenge", "-", false), new Message("I exude confidence", "-", false),
				new Message("I am bold and assertive", "-", false), new Message("I am fierce", "-", false),
				new Message("I have courage", "-", false) })));

		// Add Confidence messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are confident in your abilities", "-", false),
				new Message("You know who you are and what you want", "-", false),
				new Message("You are worthy", "-", false), new Message("You are a strong individual", "-", false),
				new Message("You have potential", "-", false),
				new Message("You can overcome any challenge", "-", false),
				new Message("You exude confidence", "-", false), new Message("You are bold and assertive", "-", false),
				new Message("You are fierce", "-", false), new Message("You have courage", "-", false) })));

		categories.add(new Category("Confidence", messages));

		// Add Millionaire Mindset messages (1st person)
		messages = new ArrayList<ArrayList<Message>>();
		messages.add(new ArrayList<Message>(Arrays.asList(
				new Message[] { new Message("I am goal oriented", "-", false), new Message("I am driven", "-", false),
						new Message("I am successful", "-", false), new Message("I can achieve anything", "-", false),
						new Message("I attract abundance", "-", false), new Message("I am wealthy", "-", false),
						new Message("I have power", "-", false), new Message("I have business potential", "-", false),
						new Message("I overcome financial obstacles", "-", false),
						new Message("I have financial success", "-", false) })));

		// Add Millionaire Mindset messages (2nd person)
		messages.add(new ArrayList<Message>(Arrays.asList(new Message[] {
				new Message("You are goal oriented", "-", false), new Message("You are driven", "-", false),
				new Message("You are successful", "-", false), new Message("You can achieve anything", "-", false),
				new Message("You attract abundance", "-", false), new Message("You are wealthy", "-", false),
				new Message("You have power", "-", false), new Message("You have business potential", "-", false),
				new Message("You overcome financial obstacles", "-", false),
				new Message("You have financial success", "-", false) })));

		categories.add(new Category("Millionaire Mindset", messages));

		return categories;
	}

}