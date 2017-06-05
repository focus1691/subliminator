package com.psychotechnology.GUI.Settings;

import java.util.EventListener;

public interface SettingsListener extends EventListener {

	public void settingsEventOccurred(SettingsEvent e);
}