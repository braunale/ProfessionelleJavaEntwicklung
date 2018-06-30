package de.hs.albsig.braunal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Mockito Tests to verify the WratherServlet
 * 
 * @author Alexander Braun
 *
 */
public class WeatherServletTest extends Mockito {

	private static final Logger Log = Logger.getLogger(WeatherServletTest.class);

	private HttpServletRequest request;
	private HttpServletResponse response;
	private StringWriter stringWriter;
	private PrintWriter writer;

	@BeforeEach
	public void init() {
		request = mock(HttpServletRequest.class);
		response = mock(HttpServletResponse.class);
		stringWriter = new StringWriter();
		writer = new PrintWriter(stringWriter);
	}

	/**
	 * Verify the get-Method of the WeatherServlet
	 * 
	 * @throws Exception
	 *             if any method call throw an exception
	 */
	@Test
	public void testServletGet() throws Exception {

		when(request.getParameter("town")).thenReturn("ebingen");
		when(response.getWriter()).thenReturn(writer);

		new WeatherServlet().doGet(request, response);

		assertNotNull(stringWriter);
		assertTrue(!stringWriter.toString().equals(""));
	}

	/**
	 * Verify the post-Method of the WeatherServlet which calls the get-Method
	 * 
	 * @throws Exception
	 *             if any method call throw an exception
	 */
	@Test
	public void testServletPost() throws Exception {

		when(request.getParameter("town")).thenReturn("ebingen");
		when(response.getWriter()).thenReturn(writer);

		new WeatherServlet().doPost(request, response);

		assertNotNull(stringWriter);
		assertTrue(!stringWriter.toString().equals(""));
	}

	/**
	 * Verify that the right errorMessage is returned if the Servlet is called
	 * without a town
	 * 
	 * @throws Exception
	 *             if any method call throw an exception
	 */
	@Test
	public void testServletWithoutTown() throws Exception {

		when(request.getParameter("town")).thenReturn(null);
		when(response.getWriter()).thenReturn(writer);

		new WeatherServlet().doPost(request, response);

		String actualErrorResponse = writer.toString();

		ErrorMessage message = new ErrorMessage("No Town", "Please call the Servlet with ?town= 'your town'");
		JAXBContext jaxbContext;
		String expectedErrorMessage = "";
		try {
			jaxbContext = JAXBContext.newInstance(ErrorMessage.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(message, writer);
			expectedErrorMessage = writer.toString();
		} catch (JAXBException e) {
			Log.error(e.getStackTrace());
		}

		assertTrue(actualErrorResponse.endsWith(expectedErrorMessage));
	}

	@AfterEach
	public void end() {
		writer.flush();
	}
}
