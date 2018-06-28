package de.hs.albsig.braunal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ErrorMessageTest {
	
	@Test
	public void testErrorMessageConstructor() {
		
		ErrorMessage testMessage = new ErrorMessage("Test","Test in detail"); 
		assertEquals("Test",testMessage.getTitle(),"Titel ist not equal to the title that was set in the constructor");
		assertEquals("Test in detail",testMessage.getDetails(),"Titel ist not equal to the title that was set in the constructor");
	}
	
}
