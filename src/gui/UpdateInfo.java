package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class UpdateInfo extends JFrame {

	private static final long serialVersionUID = -622059982314112173L;
	private JEditorPane infoPane;
	private JScrollPane scp;
	private JButton ok;
	private JButton cancelBtn;
	private JPanel pan1;
	private JPanel pan2;

	public UpdateInfo(String info) {
		initComponents();
		infoPane.setText(info);
	}

	private void initComponents() {

		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setTitle("New Update Found");
		pan1 = new JPanel();
		pan1.setLayout(new BorderLayout());

		pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());

		infoPane = new JEditorPane();
		infoPane.setContentType("text/html");

		scp = new JScrollPane();
		scp.setViewportView(infoPane);

		ok = new JButton("Update");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});

		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateInfo.this.dispose();
			}
		});
		pan2.add(ok);
		pan2.add(cancelBtn);
		pan1.add(pan2, BorderLayout.SOUTH);
		pan1.add(scp, BorderLayout.CENTER);
		this.add(pan1);
		pack();
		setVisible(true);
		this.setSize(300, 200);
	}

	private void update() {
		// TODO: Add my Code!
	}

}