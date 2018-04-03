import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class ClientData{
    public Socket connection;
    public DataOutputStream ToClient;
    public DataInputStream FromClient;
    public int id;
}

public class MultiClientServer {
    protected String hostName = "localhost";
    protected int port = 40404;
    protected ServerSocket server;
    ClientData[] clients;
    int index;

    public void Start()
    {
        try {
            index = 0;
            clients = new ClientData[10];
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
            this.clients[this.index] = new ClientData();
            this.clients[this.index].connection = this.server.accept();
            System.out.println("[#] Connection established.");

            this.clients[this.index].ToClient = new DataOutputStream(this.clients[this.index].connection.getOutputStream());
            this.clients[this.index].FromClient = new DataInputStream(this.clients[this.index].connection.getInputStream());

            try {
                int length = this.clients[this.index].FromClient.readInt();
                if(length > 0)
                {
                    byte[] data = new byte[length];
                    this.clients[this.index].FromClient.readFully(data, 0,data.length);
                    this.clients[this.index].id = Integer.parseInt(new String(data));
                    System.out.println("[#] Created a client with id: " + Integer.toString(this.clients[this.index].id) + " and index: " + Integer.toString(this.index));
                }
                //Send(Integer.toString(this.index), this.index);
                this.index ++;
            } catch(Exception e)
            {
                System.out.println("[!] Received-> Exception" + e.toString());
                e.printStackTrace();
            }
        } catch (Exception e)
        {
            System.out.println("[!] Run-> Exception" + e.toString());
            e.printStackTrace();
        }

    }

    public void Received(int index)
    {
        try {
            int length = this.clients[index].FromClient.readInt();
            if(length > 0)
            {
                byte[] data = new byte[length];
                this.clients[index].FromClient.readFully(data, 0,data.length);
                System.out.println("[#] Message received from client: " + new String(data));
            }
        } catch(Exception e)
        {
            System.out.println("[!] Received-> Exception" + e.toString());
            e.printStackTrace();
        }
    }

    private void Send(String msg, int index)
    {
        byte[] data = msg.getBytes();
        try {
            this.clients[index].ToClient.writeInt(data.length);
            this.clients[index].ToClient.write(data);
            this.clients[index].ToClient.flush();
            System.out.println("$ Message sent to client: " + msg + " |-> " + new String(data));

        } catch(Exception e)
        {

        }
    }
}
