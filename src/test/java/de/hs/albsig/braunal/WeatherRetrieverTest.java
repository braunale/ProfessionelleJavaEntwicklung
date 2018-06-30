package de.hs.albsig.braunal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

public class WeatherRetrieverTest {

	private static final Logger Log = Logger.getLogger(WeatherRetrieverTest.class);

	@Test
	public void testRetriever() {

		WeatherRetriever retriever = new WeatherRetriever();
		try {
			assertEquals(true, retriever.retrieve("ebingen") != null, "Weather Retriver does not work");
		} catch (Exception e) {
			Log.error(e);
		}
	}
}
