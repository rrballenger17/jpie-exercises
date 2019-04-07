public class JettyExample {
	public static void main(String args[]) throws Exception { 
		final Server jettyServer = new Server(8080); 
		jettyServer.setHandler(new EchoHandler()); jettyServer.start();
		jettyServer.join();
	} 
}