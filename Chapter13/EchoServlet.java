


public class EchoServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException { 

		response.setContentType("text/plain"); 
		response.setStatus(HttpServletResponse.SC_OK);

		final ServletInputStream requestInputStream = request.getInputStream();
		final ServletOutputStream responseOutputStream = response.getOutputStream();

		IOUtils.copy(requestInputStream, responseOutputStream); 
	}
}