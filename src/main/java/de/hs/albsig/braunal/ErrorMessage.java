package de.hs.albsig.braunal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Message class to display an error on the web site.
 *
 * @author Alexander Braun.
 *
 */
@XmlRootElement
public class ErrorMessage {

/**
* Name of the error.
*/
private  String title = "";

/**
* Detailed description of the error.
*/
private String details = "";

/**
* Empty standard constructor.
*/
public ErrorMessage() {
}

/**
* Constructor to set title and details.
*
* @param t
*            = name of the error.
* @param d
*            = detailed description.
*/
public ErrorMessage(final String t, final String d) {
    super();
    this.title = t;
    this.details = d;
}

/**
* @return value of the title.
*/
public final String getTitle() {
    return title;
}

/**
* set value of the title.
*
* @param t = new value of title.
*/
@XmlElement
public final void setTitle(final String t) {
    this.title = t;
}

/**
*
* @return value of details.
*/
public final String getDetails() {
    return details;
}

/**
* set value of details.
*
* @param d = new value of details.
*/
@XmlElement
public final void setDetails(final String d) {
    this.details = d;
}
}
