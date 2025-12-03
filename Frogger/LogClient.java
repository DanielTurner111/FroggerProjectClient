import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Log extends spriteCharacteristics implements Runnable {

	//private Boolean moving;
	//private Thread t;
	private JLabel logLabel;
	private JButton startButton;
	private gameCharacter gameCharacter;
	private JLabel frogLabel;
	//private int speed;
	//private Boolean moveLeft;
	
	
	public Log() {
		//super();
		//this.moving = false;
	}



	public Log (int x, int y, int width, int height, String image, Boolean moving, int speed, Boolean moveLeft) {
		
		super(x,y, width, height, image);
		this.moving = moving;
		this.speed = speed;
		this.moveLeft = moveLeft;
		
	}
	
	public Boolean getMoving() {return moving; }
	public void setMoving(Boolean moving) {this.moving = moving; }
	public void setGameCharacter( gameCharacter gameCharacter) {this.gameCharacter = gameCharacter;}
	public void setGameCharacterLabel(JLabel frogLabel) {this.frogLabel = frogLabel;}
	public void setLogLabels(JLabel logLabel) {this.logLabel = logLabel;}
	public void setStartButton(JButton startButton) {this.startButton = startButton;}
	public JLabel getLogLabel() {return this.logLabel;}
	public Boolean getMoveLeft() {return moveLeft;}
	public int getSpeed() {return speed;}


	