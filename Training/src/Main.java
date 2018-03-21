

public class Main {

    public static void main(String[] args)
    {
	    SimpleServer server = new SimpleServer();
	    SimpleClient client = new SimpleClient("localhost", 40404);

	    server.Start();
        client.Connect();
        server.Run();

        client.Send("Oala!");
        server.Received();
    }
}
