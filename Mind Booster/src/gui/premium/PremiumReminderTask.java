package gui.premium;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PremiumReminderTask extends Thread {

	private PremiumReminderDialog premiumReminderDialog;
	private final int delay = 6;

	public PremiumReminderTask() {
		premiumReminderDialog = new PremiumReminderDialog();

		premiumReminderDialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				premiumReminderDialog.setVisible(false);
			}
		});
	}
	@Override
	public void run() {
		premiumReminderDialog.setVisible(true);
		try {
			sleep(delay);
		} catch (InterruptedException e) {
			System.err.println("Premium reminder sleep failed");
		}
	}
	
	public void showPopup() {
		premiumReminderDialog.setVisible(true);
	}
}