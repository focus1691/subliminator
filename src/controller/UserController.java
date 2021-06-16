package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

import gui.premium.PremiumCheckerTask;
import model.User;

public class UserController {

	private User user;
	private final String tempLoginKey = "MjMGqzdkMSs4K4PNkN454Ufc";
	private PremiumCheckerTask premiumCheckerTask;

	public UserController() {
		user = new User();
		premiumCheckerTask = new PremiumCheckerTask(this);
	}

	public boolean isTempUserSelected(String tempLoginKey) {
		return tempLoginKey.equals(this.tempLoginKey) ? true : false;
	}

	public String authenticateUser(String email, String pass) {
		String error = "";
		try {
			HttpClient httpclient = HttpClientBuilder.create().build();

			// Creating the RequestBuilder object
			RequestBuilder reqbuilder = RequestBuilder.get();

			// Setting URI and parameters
			RequestBuilder reqbuilder1 = reqbuilder
					.setUri("https://www.psychotechnology.com/api/get-subliminator-premium");
			RequestBuilder reqbuilder2 = reqbuilder1.addParameter("email", email).addParameter("password", pass);

			// Building the HttpUriRequest object
			HttpUriRequest httpget = reqbuilder2.build();

			HttpResponse response = httpclient.execute(httpget);
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			while ((output = br.readLine()) != null) {

				JSONObject json = new JSONObject(output);

				int id = json.getInt("id");
				String firstName = json.getString("firstName");
				String lastName = json.getString("lastName");
				boolean active = json.getBoolean("active");
				boolean premium = json.getBoolean("premium");

				user.setId(id);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setAccountActive(active);
				user.setUserPremium(premium);

			}

			if (user.isAccountActive()) {
				user.setEmail(email);
				user.setPassword(pass);
			}

		} catch (ClientProtocolException e) {
			error = "Cannot connect to the server";
		} catch (IOException e) {
			error = "Error processing data";
		} catch (JSONException e) {
			error = "Incorrect / user password";
		}
		return error;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void handleLogout() {
		this.user.setAccountActive(false);
		this.user.setUserPremium(false);
	}

	public boolean isAuthenticated() {
		return this.user.isAccountActive();
	}

	public boolean isPremium() {
		return this.user.isUserPremium();
	}

	public void setUserPremium(boolean isPremium) {
		this.user.setUserPremium(isPremium);
	}

	public void runPremiumPrompter() {
		if (!premiumCheckerTask.isAlive()) {
			premiumCheckerTask = new PremiumCheckerTask(this);
			premiumCheckerTask.start();
			premiumCheckerTask.runPremiumReminder();
		}
	}

	public void stopPremiumPrompter() {
		if (!premiumCheckerTask.isInterrupted()) {
			premiumCheckerTask.interrupt();
			premiumCheckerTask.stopPremiumReminder();
		}
	}

	public void showPremiumPopup() {
		premiumCheckerTask.showPopup();
	}
}
