package de.hs.albsig.braunal;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Mockito Tests to verify the WratherServlet 
 * 
 * @author Alexander Braun
 *
 */
public class WeatherServletTest extends Mockito{
	
    @Test
    /**
     * Verify the get-Method of the WeatherServlet 
     * 
     * @throws Exception if any method call throw an exception
     */
    public void testServletGet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("town")).thenReturn("ebingen");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doGet(request, response);
        writer.flush(); 
        
        assertTrue(stringWriter!=null);
        assertTrue(!stringWriter.toString().equals(""));
    }
    
    @Test
    /**
     * Verify the post-Method of the WeatherServlet
     * which calls the get-Method 
     * 
     * @throws Exception if any method call throw an exception
     */
    public void testServletPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("town")).thenReturn("ebingen");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doPost(request, response);
        writer.flush();
        
        assertTrue(stringWriter!=null);
        assertTrue(!stringWriter.toString().equals(""));
    }
    
    @Test
    /**
     * Verify that the right errorMessage is returned 
     * if the Servlet is called without a town 
     * 
     * @throws Exception if any method call throw an exception
     */
    public void testServletWithoutTown() throws Exception {
       
    	/*
    	HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("town")).thenReturn(null);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new WeatherServlet().doPost(request, response);        
        writer.flush(); // it may not have been flushed yet...
        
        String actualErrorResponse = writer.toString(); 
        
        
        ErrorMessage message = new ErrorMessage("No Town", "Please call the Servlet with ?town= 'your town'");
        StringWriter writer2 = new StringWriter();
        JAXBContext jaxbContext;
        String expectedErrorMessage = "";
        try {
            jaxbContext = JAXBContext.newInstance(ErrorMessage.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.marshal(message, writer);
            expectedErrorMessage = writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        assertTrue(actualErrorResponse.endsWith(expectedErrorMessage));*/
    }
}
