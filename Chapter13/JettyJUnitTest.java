



public class JettyJUnitTest {
	
	private static Server jettyServer;

	@BeforeClass
	public static void startJetty() throws Exception {
		jettyServer = new Server(8080);
		final ServletHandler servletHandler = new ServletHandler(); 
		jettyServer.setHandler(servletHandler); 
		servletHandler.addServletWithMapping(EchoServlet.class, "/echo/*"); 
		jettyServer.start();
	}


	@Test
	public void postRequestWithData() throws IOException {
		
		final HttpClient httpClient = new DefaultHttpClient();
		final HttpPost post = new HttpPost("http://localhost:8080/echo/"); 
		final String requestBody = "Hello World";
		post.setEntity(new StringEntity(requestBody));

		final HttpResponse response = httpClient.execute(post);
		final int statusCode = response.getStatusLine().getStatusCode();
		final InputStream responseBodyStream = response.getEntity().getContent(); 
		
		final StringWriter stringWriter = new StringWriter();
		
		IOUtils.copy(responseBodyStream, stringWriter); 

		final String receivedBody = stringWriter.toString();

		assertEquals(200, statusCode);

		assertEquals(requestBody, receivedBody); 

	}

	@AfterClass
	public static void stopJetty() throws Exception {
		jettyServer.stop(); 
	}

}