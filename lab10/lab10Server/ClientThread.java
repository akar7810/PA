package lab10Server;

import java.net.Socket;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;

public class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                if(request.equals("stop")){
                    String response = "Server stopped";
                    out.println(response);
                    out.close(); // close() closes the stream permanently, stream needs to be reopened for further use
                    break;
                }
                String response = "Server received the request!";
                out.println(response);
                out.flush(); //flush() sends the buffer to the destination then empties the buffer, can still use the stream
            }
        } catch (IOException e) {
            System.err.println("Oops... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}