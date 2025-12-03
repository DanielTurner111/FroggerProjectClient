import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Car extends spriteCharacteristics {

	//private Boolean moving;
	//private Thread t;
	private JLabel carLabel;
	private JButton startButton;
	private gameCharacter gameCharacter;
	private JLabel frogLabel;
	//private int speed;
	//private Boolean moveLeft;
	
	
	public Car() {
		//super();
		//this.moving = false;
	}



	public Car (int x, int y, int width, int height, String image, Boolean moving, int speed, Boolean moveLeft) {
		
		super(x,y, width, height, image);
		this.moving = moving;
		this.speed = speed;
		this.moveLeft = moveLeft;
		
	}
	
	public Boolean getMoving() {return moving; }
	public void setMoving(Boolean moving) {this.moving = moving; }
	
	public void setGameCharacter( gameCharacter gameCharacter) {this.gameCharacter = gameCharacter;}
	public void setGameCharacterLabel(JLabel frogLabel) {this.frogLabel = frogLabel;}
	public void setCarLabels(JLabel carLabel) {this.carLabel = carLabel;}
	public JLabel getCarLabel() {return this.carLabel;}
	public void setStartButton(JButton startButton) {this.startButton = startButton;}
	
	
