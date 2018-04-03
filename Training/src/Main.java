

public class Main {

    public static void main(String[] args)
    {
	    //SimpleServer server = new SimpleServer();
        MultiClientServer server = new MultiClientServer();
	    SimpleClient client1 = new SimpleClient("localhost", 40404);
        SimpleClient client2 = new SimpleClient("localhost", 40404);
	    server.Start();

        client1.Connect();
        server.Run();

        client2.Connect();
        server.Run();

        client1.SendTo("Oala!");
        server.Received(client1.id);

        client2.SendTo("Dudu!");
        server.Received(client2.id);
    }
}
