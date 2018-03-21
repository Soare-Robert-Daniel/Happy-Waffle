import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class SimpleClient {
    protected String hostName = "localhost";
    protected int port = 40404;
    protected Socket client;
    protected DataOutputStream ToServer;
    protected DataInputStream FromServer;

    SimpleClient(String hostName, int port)
    {
        this.hostName = hostName;
        this.port = port;
    }

    public void Connect() {
        try {
            this.client = new Socket(this.hostName, this.port);
            System.out.println("$ Connecting to server...");

            this.ToServer = new DataOutputStream(this.client.getOutputStream());
            this.FromServer = new DataInputStream(this.client.getInputStream());
        } catch (Exception e)
        {
            System.out.println("$ {!} Connect-> Exception" + e.toString());
            e.printStackTrace();
        }
    }

    public void Send(String msg)
    {
        byte[] data = msg.getBytes();
        try {
            this.ToServer.writeInt(data.length);
            this.ToServer.write(data);
            this.ToServer.flush();
            System.out.println("$ Message sent to server: " + msg + " |-> " + new String(data));

        } catch(Exception e)
        {

        }
    }
}
