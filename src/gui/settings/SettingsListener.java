package gui.settings;

import java.util.EventListener;

public interface SettingsListener extends EventListener {

	public void settingsEventOccurred(SettingsEvent e);
}