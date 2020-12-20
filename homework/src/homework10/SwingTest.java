package homework10;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SwingTest {

	public static void main(String[] args) {
		TestFrame frame = new TestFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
class TestFrame extends JFrame{
	public static final int DEFAULT_WIDTH = 500, DEFAULT_HEIGHT = 200;
	private JPanel buttonPanel;
	
	public TestFrame() {
		setTitle("homework8");
		setSize( DEFAULT_WIDTH, DEFAULT_HEIGHT);
		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.CENTER);
		addButton("Add");
		addButton("RemoveFirst");
		addButton("RemoveLast");
		addButton("RemoveAll");
		
		JButton quitButton = new JButton("Quit");
		buttonPanel.add(quitButton);
		quitButton.setToolTipText("Help for Quit");
		quitButton.addActionListener((ActionEvent event)->
			System.exit(0));
	}
	public void addButton(String name) {
		JButton button = new JButton(name);
		buttonPanel.add(button);
		button.setToolTipText("Help for "+name);
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(null, event.getActionCommand());
			}
		};
		button.addActionListener(listener);
	}
}