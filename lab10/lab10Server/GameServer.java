package lab10Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    String ipAddress;
    int PORT;
    ServerSocket serverSocket;

    public GameServer(String ipAddress, int PORT) throws IOException {
        this.ipAddress = ipAddress;
        this.PORT = PORT;
        this.serverSocket = new ServerSocket(PORT);
        init();
    }

    public void init() throws IOException {
        try {
            while (true) {
                System.out.println("Waiting for a client to wake up...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println("Error:" + e);
        } finally {
            serverSocket.close();
        }
    }
}