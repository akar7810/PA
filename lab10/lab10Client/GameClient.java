package lab10Client;

import java.net.Socket;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;

public class GameClient {
    String ipAddress;
    int PORT;

    public GameClient(String ipAddress, int PORT) {
        this.ipAddress = ipAddress;
        this.PORT = PORT;

    }

    public void start() {
        try {
            Socket socket = new Socket(ipAddress, PORT);//closing socket and keyboard because of warnings
            try(Scanner keyboard = new Scanner(System.in)){//using try-with-resources to close the keyboard scanner
            while (true) {
                System.out.println("Enter command:");
                String request = keyboard.next();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(request);
                if (request.equals("exit"))
                    {
                	System.out.println("Goodbye!");
                	
	                break;
                    }
                String response = in.readLine();
                System.out.println(response);
                }
            }
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("No server awake... " + e);
        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}