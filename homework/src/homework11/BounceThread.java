package homework11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BounceThread {

	public static void main(String[] args) {
		JFrame frame = new BounceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
class BounceFrame extends JFrame{
	private BallPanel ballPanel;
	private static final int DEFAULT_WIDTH = 450;
	private static final int DEFAULT_HEIGHT = 350;
	private static int delay = 6;

	public BounceFrame() {
		setTitle("BounceThread");
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		ballPanel = new BallPanel(); add(ballPanel,BorderLayout.CENTER);
		
		JMenu menu = new JMenu("Speed");
		JMenuItem faster = new JMenuItem("Faster");
		faster.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) {delay = delay/2;}});
		JMenuItem slower = new JMenuItem("Slower");
		slower.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) {delay = delay*2;}});
		menu.add(faster);
		menu.add(slower); 
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.add(menu);
		
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel,"Add1",new ActionListener() {
			public void actionPerformed(ActionEvent event) {addBall();}
		});
		addButton(buttonPanel,"Add2",new ActionListener() {
			public void actionPerformed(ActionEvent event) {addBall(); 
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} addBall();}
		});
		addButton(buttonPanel,"Close",new ActionListener() {
			public void actionPerformed(ActionEvent event) {System.exit(0);}
		});
		
		add(buttonPanel,BorderLayout.SOUTH);
		
	}
	private void addButton(Container container,String title, ActionListener listener) {
		JButton button = new JButton(title);
		container.add(button);
		button.addActionListener(listener);
	}
	public void addBall() {
		Ball b = new Ball();
		ballPanel.add(b);
		Runnable r = new BallRunnable(b,ballPanel, delay);
		Thread t = new Thread(r);
		t.start();
	}
}

class BallRunnable implements Runnable {
	private Ball ball;
	private BallPanel ballPanel;
	public static final int STEPS = 1000;
	public int delay;
	
	public BallRunnable(Ball aBall, BallPanel ballPanel, int delay) {
		ball = aBall; this.ballPanel = ballPanel; this.delay = delay;
	}
	
	@Override
	public void run() {
		try {
			for(int i = 1; i <= STEPS; i++) {
				ball.move(ballPanel.getBounds());
				try {
					ballPanel.paint(ballPanel.getGraphics());
				} catch (ConcurrentModificationException e) {
					System.err.println("ConcurrentModification warning");
				}
				Thread.sleep(delay);
			}
		}catch(InterruptedException e){}
	}
}

class Ball{
	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
	
	public void move(Rectangle2D bounds) {
		x+= dx; y+= dy;
		if(x < bounds.getMinX()) {x = bounds.getMinX(); dx = -dx;}
		if(x + XSIZE >= bounds.getMaxX()) {x = bounds.getMaxX()- XSIZE; dx = -dx;}
		if(y < bounds.getMinY()) {y = bounds.getMinY(); dy = -dy;}
		if(y + YSIZE >= bounds.getMaxY()) {y = bounds.getMaxY()- YSIZE; dy = -dy;}
	}
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x,y,XSIZE,YSIZE);	}
}

class BallPanel extends JPanel{
	private List<Ball> balls = new ArrayList<>();
	public void add(Ball b) { balls.add(b);}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(Ball b : balls) {g2.fill(b.getShape());}
	}
}


