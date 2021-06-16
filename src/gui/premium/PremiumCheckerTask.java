package gui.premium;

import controller.UserController;

public class PremiumCheckerTask extends Thread {

	private UserController userController;
	private PremiumReminderDialog premiumReminderDialog;
	private PremiumReminderTask premiumReminderTask;
	private final int delay = 6;

	public PremiumCheckerTask(UserController userController) {
		this.userController = userController;
		premiumReminderTask = new PremiumReminderTask();
	}

	@Override
	public void run() {
		if (userController.isPremium()) {
			userController.setUserPremium(true);
			premiumReminderDialog.setVisible(false);
			premiumReminderTask.interrupt();
			interrupt();
		} else {
			try {
				sleep(delay);
			} catch (InterruptedException e) {
				System.err.println("Premium check sleep failed");
			}
		}
	}

	public void runPremiumReminder() {
		if (!premiumReminderTask.isAlive()) {
			premiumReminderTask.start();
		}
	}

	public void stopPremiumReminder() {
		if (!premiumReminderTask.isInterrupted()) {
			premiumReminderTask.interrupt();
		}
	}
	
	public void showPopup() {
		premiumReminderTask.showPopup();
	}
}
