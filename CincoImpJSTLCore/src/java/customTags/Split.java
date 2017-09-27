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
    
    private int getDelimiterIndex(int begin) throws IndexOutOfBoundsException {
        int index = -1, count = 0;
        
        if (begin < 0) {
            throw new IndexOutOfBoundsException();
        }
        
        while (count < delimiter.length()) {
            int found;
            found = word.indexOf(delimiter.charAt(count), begin);
            if (found != -1) {
                if (index != -1) {
                    // Valida índice encontrado para mais de um delimitador!
                    if (found < index) {
                        index = found;
                    }
                } else {
                    index = found;
                }
            }
            count++;
        }        
        return index;
    }
    
    public String [] split() throws NullPointerException {
        
        if (word == null) {
            throw new NullPointerException();
        }
        
        if (delimiter == null) {
            throw new NullPointerException();
        }
        List<String> substrings = new ArrayList<>();
        
        int index = 0, begin = 0;
        while (index != -1) {
            index = getDelimiterIndex(index);
            
            if (index != -1) {
                substrings.add(word.substring(begin, index));
                index++;
                begin = index;                
            }
        }
        if (begin < (word.length() - 1)) {
            substrings.add(word.substring(begin));
        }        
        
        String [] strings;
        strings = substrings.toArray(new String[0]);
        return strings;
    }
    
    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     * @throws javax.servlet.jsp.JspException
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
            
            out.println("Palavra=" + word + "<P>");
            out.println("Delimitador=" + delimiter + "<P>");
            
            String [] subStrings = split();
            for (String string : subStrings) {
                out.println(string + "<P>");
            }
        } catch (java.io.IOException | IndexOutOfBoundsException | NullPointerException ex) {
            throw new JspException("Error in Split tag", ex);
        }
        
    }
    
}
