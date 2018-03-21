import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class SimpleServer {
    protected String hostName = "localhost";
    protected int port = 40404;
    protected ServerSocket server;
    protected Socket connection;
    protected DataOutputStream ToClient;
    protected DataInputStream FromClient;

    public void Start()
    {
        try {
            server = new ServerSocket(this.port, 50, InetAddress.getByName(this.hostName));
            System.out.println("[#] Server started.");
        } catch (Exception e)
        {
            System.out.println("[!] Start-> Exception" + e.toString());
            e.printStackTrace();
        }
    }

    public void Run()
    {
        try {
            this.connection = server.accept();
            System.out.println("[#] Connection established.");

            this.ToClient = new DataOutputStream(this.connection.getOutputStream());
            this.FromClient = new DataInputStream(this.connection.getInputStream());
        } catch (Exception e)
        {
            System.out.println("[!] Run-> Exception" + e.toString());
            e.printStackTrace();
        }

    }

    public void Received()
    {
        try {
            int length = this.FromClient.readInt();
            if(length > 0)
            {
                byte[] data = new byte[length];
                this.FromClient.readFully(data, 0,data.length);
                System.out.println("[#] Message received from client: " + new String(data));
            }
        } catch(Exception e)
        {

        }

    }

}
