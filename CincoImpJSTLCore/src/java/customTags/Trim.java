/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customTags;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author peof
 */
public class Trim extends SimpleTagSupport {

    private String sentence;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) throws NullPointerException {
        if (sentence == null) {
            throw new NullPointerException();
        }
        this.sentence = sentence;
    }

    private void removeBeginWhiteSpaces() {
        if (sentence.length() > 0) {
            char caracter = ' ';
            String trimmed = sentence;

            caracter = trimmed.charAt(0);
            while (caracter == ' ') {
                if (trimmed.length() > 1) {
                    trimmed = trimmed.substring(1);
                } else {
                    trimmed = "";
                    break;
                }
                caracter = trimmed.charAt(0);
            }
            sentence = trimmed;
        }
    }

    private void removeEndWhiteSpaces() {
        if (sentence.length() > 0) {
            char caracter = ' ';
            String trimmed = sentence;
            
            caracter = trimmed.charAt(trimmed.length()-1);
            while (caracter == ' ') {                
                trimmed = trimmed.substring(0,trimmed.length()-1);
                caracter = trimmed.charAt(trimmed.length()-1);
            }
            sentence = trimmed;
        }
    }

    public String trim() {
        String trimmed = null;

        removeBeginWhiteSpaces();
        removeEndWhiteSpaces();
        trimmed = sentence;
        return trimmed;
    }

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            
            out.println("Resultado do trim =" + trim() + "!");

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Trim tag", ex);
        }
    }

}
