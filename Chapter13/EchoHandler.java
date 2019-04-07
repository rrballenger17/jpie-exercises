




class EchoHandler extends AbstractHandler {
	@Override
	public void handle(String target,
						Request baseRequest, 
						HttpServletRequest request, HttpServletResponse response)
							throws IOException, ServletException { 
			
			response.setContentType("text/plain"); 
			response.setStatus(HttpServletResponse.SC_OK); 
			baseRequest.setHandled(true);
			
			final ServletInputStream requestInputStream = request.getInputStream();
			final ServletOutputStream responseOutputStream = response.getOutputStream();
			IOUtils.copy(requestInputStream, responseOutputStream); 
	}
}






