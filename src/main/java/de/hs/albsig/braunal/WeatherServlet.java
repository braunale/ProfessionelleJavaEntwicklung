package de.hs.albsig.braunal;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



/**
* Servlet that manages the user input.
*
* @author Alexander Braun.
*
*/
public class WeatherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

/**
* Logger to display and save important informations.
*/
private static Logger logger = Logger.getLogger(WeatherServlet.class);

/**
* Default Constructor for the servlet.
*/
public WeatherServlet() {
    super();
    PropertyConfigurator.configure(WeatherServlet.class.getClassLoader()
        .getResource("log4j.properties"));
}


/**
 * @param request = given request from the web site
 * @param response = response object that will be filled
 * @throws ServletException at servlet errors
 * @throws IOException at errors with the inputstream
 */
public final void doGet(
        final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {

    logger.info("Called Weather Servlet");
    String town = request.getParameter("town");
    String output = "";

    if (town != null) {
        WeatherRetriever retriever = new WeatherRetriever();
        InputStream stream = null;
        try {
            stream = retriever.retrieve(town);
        } catch (Exception e) {
        e.printStackTrace();
        }
            StringWriter writer = new StringWriter();
            IOUtils.copy(stream, writer, StandardCharsets.UTF_8);
            output = writer.toString();
        } else {
            logger.error("Servlet was called without a town parameter");
            ErrorMessage error = new ErrorMessage(
                "No Town", "Please call the Servlet with ?town='your town'");
            StringWriter writer = new StringWriter();
            JAXBContext jaxbContext;
            try {
                jaxbContext = JAXBContext.newInstance(ErrorMessage.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.marshal(error, writer);
                output = writer.toString();
            } catch (JAXBException e) {
                logger.error("Error while create xml-Error Message: "
                      + e.getMessage());
            }
       }

         response.getWriter().append(output);
}

/**
* @param request = request from the web site
* @param response = response object that will be filled
* @throws ServletException at problems with the servlet
* @throws IOException at io problems
*/
public final void doPost(final HttpServletRequest request,
        final HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
}
}
