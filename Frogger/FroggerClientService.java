import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class FroggerClientService implements Runnable {

	private Socket s;
	private Scanner in;
	
	public FroggerClientService (Socket aSocket) {
		this.s = aSocket;
	}
	public void run() {
		
		try {
			in = new Scanner(s.getInputStream());
			processRequest( );
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	//processing the requests
	public void processRequest () throws IOException {
		//if next request is empty then return
		while(true) {
			if(!in.hasNext( )){
				return;
			}
			String command = in.next();
			if (command.equals("Quit")) {
				return;
			} else {
				executeCommand(command);
			}
		}
	}
	
	private void executeCommand(String command) {
		if ( command.equals("GETFROG") ) {
			//no extra data to extract
			//get x, y from character1, send to client
			
			
			return;			
		} else if ( command.equals("GETCARS") ) {
			
			//get x, y, moving, visible, from character2, send to client
			
	
			
		}else if ( command.equals("GETLOGS") ) {
			
			//get x, y, moving, visible, from character2, send to client
			
	
			
		} else if ( command.equals("MOVEFROG") ) {
			//get value for direction
			//ifs to update x, y depending on direction
		
			return;
			
		}  else if (command.equals("MOVECARS")) {
			//get value for start or stop
			//trigger thread if START
			
		} else if (command.equals("MOVELOGS")) {
			//get value for start or stop
			//trigger thread if START
			
		} else {
			System.out.println(command + " received");

			String outCommand = "INVALID COMMAND"; 
			out.println(outCommand);
			out.flush();
			return;			
		}
		
	}
}

}
