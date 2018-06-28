package de.hs.albsig.braunal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WeatherRetrieverTest {

	@Test
	public void testRetriever() {
		
		WeatherRetriever retriever = new WeatherRetriever();
		try {
			assertEquals(true,retriever.retrieve("ebingen")!=null,"Weather Retriver does not work");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
