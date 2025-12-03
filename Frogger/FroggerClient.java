import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FroggerClient extends JFrame implements KeyListener, ActionListener {

	final static int CLIENT_PORT = 6001;
	final static int SERVER_PORT = 6000;
	
	private Background Background;
	private gameCharacter gameCharacter;

	private Container content;
	private JLabel backgroundLabel, frogLabel;
	private ImageIcon backgroundImage, frogImage;
	
	private JButton startButton;
	
	
	public FroggerClient() {
		
		String User = JOptionPane.showInputDialog("Please Enter Your Name For Score Tracking");
		JOptionPane.showMessageDialog(null, User);
		//Player = User;
		
		content = getContentPane();
		
		Background = new Background(0,0, 600, 966, "Background.png");
		gameCharacter = new gameCharacter(100,250,100,100,"Frog.png");
		
		setSize(froggerProperties.SCREEN_WIDTH, froggerProperties.SCREEN_HEIGHT +30);
		content.setBackground(Color.gray);
		setLayout(null);
		
		gameCharacter.setX(240);
		gameCharacter.setY(870);
		gameCharacter.setWidth(66);
		gameCharacter.setHeight(66);
		gameCharacter.setImage("Frog.png");
		
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		startButton.setSize(50,50);
		startButton.setLocation(froggerProperties.SCREEN_WIDTH -60 , froggerProperties.SCREEN_HEIGHT -90 );
		startButton.setFocusable(false);

		
		backgroundLabel = new JLabel();
		backgroundImage = new ImageIcon(getClass().getResource("gameSprites/" + Background.getImage()));
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setSize(Background.getWidth(), Background.getHeight());
		backgroundLabel.setLocation(Background.getX(), Background.getY());
		
		frogLabel = new JLabel();
		frogImage = new ImageIcon(getClass().getResource("gameSprites/" + gameCharacter.getImage()));
		frogLabel.setIcon(frogImage);
		frogLabel.setSize(gameCharacter.getWidth(), gameCharacter.getHeight());
		frogLabel.setLocation(gameCharacter.getX(), gameCharacter.getY());
		
	
		
		content.add(startButton);
		content.add(frogLabel);
		content.add(backgroundLabel);
		
		content.addKeyListener(this);
		content.setFocusable(true);

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			
	}
	
	public static void main(String[] args) throws IOException {
		FroggerClient myGame = new FroggerClient();
		myGame.setVisible(true);
		
		Thread t1 = new Thread ( new Runnable () {
			public void run ( ) {
				synchronized(this) {
					
					ServerSocket client;
					
					try {
						
						client = new ServerSocket(CLIENT_PORT);
						while(true) {
							Socket s2;
							try {
								s2 = client.accept();
								FroggerClientService myService = new FroggerClientService (s2);
								Thread t2 = new Thread(myService);
								t2.start();
									
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("client connected");
							
						}
					
					
					
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Waiting for server responses...");

					
				}
			}
		});
		t1.start( );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
		//int x = gameCharacter.getX();
		//int y = gameCharacter.getY();
		
		String command="";
		
		if ( e.getKeyCode() == KeyEvent.VK_UP ) {	
			//y -= froggerProperties.VERTICAL_STEP;	
			command = "MOVEFROG UP\n";
			
						
			} else if ( e.getKeyCode() == KeyEvent.VK_DOWN ) { 
					//y += froggerProperties.VERTICAL_STEP;
				command = "MOVEFROG DOWN\n";
				
				
			} else if ( e.getKeyCode() == KeyEvent.VK_LEFT ) { 
				
				//x -= froggerProperties.HORIZONTAL_STEP;
				command = "MOVEFROG LEFT\n";
			
				
			} else if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) { 
				//x += froggerProperties.HORIZONTAL_STEP;
				command = "MOVEFROG RIGHT\n";
					
			}
			
			//gameCharacter.setX(x);
			//gameCharacter.setY(y);
			
			
			//update location on screen
			//frogLabel.setLocation( gameCharacter.getX(), gameCharacter.getY() );
			
			
			
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}


