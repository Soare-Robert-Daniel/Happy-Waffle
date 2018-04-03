import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class SimpleClient {

    static int count = 0;

    protected String hostName = "localhost";
    protected int port = 40404;
    protected Socket client;
    protected DataOutputStream ToServer;
    protected DataInputStream FromServer;
    protected int id;
    protected int index;

    SimpleClient(String hostName, int port)
    {
        this.hostName = hostName;
        this.port = port;
        this.id = count;
        this.index = -1;
        count ++;
    }

    public void Connect() {
        try {
            this.client = new Socket(this.hostName, this.port);
            System.out.println("$ Registering to server...");

            this.ToServer = new DataOutputStream(this.client.getOutputStream());
            this.FromServer = new DataInputStream(this.client.getInputStream());
            Send(Integer.toString(this.id));
            //this.index = Integer.parseInt(Received());
        } catch (Exception e)
        {
            System.out.println("$ {!} Connect-> Exception" + e.toString());
            e.printStackTrace();
        }
    }

    private void Send(String msg)
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

    public void SendTo(String msg)
    {
        msg = Integer.toString(this.id) + "~" + msg;
        Send(msg);
    }

    public String Received()
    {
        try {
            int length = this.FromServer.readInt();
            if(length > 0)
            {
                byte[] data = new byte[length];
                this.FromServer.readFully(data, 0,data.length);
                System.out.println("[#] Message received from server: " + new String(data));
                return new String(data);
            }
        } catch(Exception e)
        {
            System.out.println("[!] Received-> Exception" + e.toString());
            e.printStackTrace();
        }
        return "-1";
    }
}
