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

            caracter = sentence.charAt(0);
            while (caracter == ' ') {
                if (sentence.length() > 1) {
                    sentence = sentence.substring(1);
                } else {
                    sentence = "";
                    break;
                }
                caracter = sentence.charAt(0);
            }
        }
    }

    private void removeEndWhiteSpaces() {
        if (sentence.length() > 0) {
            char caracter = ' ';
            
            caracter = sentence.charAt(sentence.length()-1);
            while (caracter == ' ') {                
                sentence = sentence.substring(0,sentence.length()-1);
                caracter = sentence.charAt(sentence.length()-1);
            }
        }
    }

    public String trim() {
        removeBeginWhiteSpaces();
        removeEndWhiteSpaces();
        return sentence;
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
            
            
            out.println("Palavra =" + sentence + "!<P>");
            out.println("Resultado do trim =" + trim() + "!<P>");

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Trim tag", ex);
        }
    }

}
