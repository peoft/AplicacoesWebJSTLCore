/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customTags;

import java.util.List;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author peof
 */
public class Split extends SimpleTagSupport {

    private String word;
    private String delimiter;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
    
    private boolean isDelimiter(char param) {
        boolean found = false;
        int index = 0;
        while (index != delimiter.length()) {
            if (delimiter.charAt(index) == param) {
                found = true;
                break;
            }                
            index++;            
        }        
        return found;
    }
    
    public String [] split() {
        String [] strings = null;
        if (word == null) {
            // Jogar exception...
            return strings;
        }
        
        if (delimiter == null) {
            // Jogar exception...
            return strings;
        }
        List<String> substrings = new ArrayList<>();
        String string = new String();
        
        int index = 0;
        while (index != word.length()) {
            char caracter = word.charAt(index);
            if (isDelimiter(caracter)) {
                substrings.add(string);
                string = "";
            } else {
                string += caracter;
            }            
            index++;
        }
        if (string.length() > 0) {
            substrings.add(string);
        }        
        strings = substrings.toArray(new String[0]);
        return strings;
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

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
            String [] subStrings = split();
            for (String string : subStrings) {
                out.println(string + "<P>");
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Split tag", ex);
        }
    }
    
}
