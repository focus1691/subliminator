package gui.premium;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PremiumReminderTask implements Runnable {

	private PremiumReminderDialog premiumReminderDialog;

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
	}
}