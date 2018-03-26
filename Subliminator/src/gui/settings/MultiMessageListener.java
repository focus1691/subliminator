package gui.settings;

import java.util.EventListener;

public interface MultiMessageListener extends EventListener {

	public void multiMessageEventOccurred(MultiMessageEvent e);
}