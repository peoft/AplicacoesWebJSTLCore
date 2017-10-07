/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customTags;

import java.io.IOException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

/**
 *
 * @author peof
 */
public class Substring extends SimpleTagSupport {
    private String word;
    private int begin;
    private int end;

    public String getWord() {
        return word;
    }

    public void setWord(String word) throws NullPointerException {
        if (word == null) {
            throw new NullPointerException();
        }
        this.word = word;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) throws IndexOutOfBoundsException {
        if (begin < 0) {
            throw new IndexOutOfBoundsException();
        }            
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) throws IndexOutOfBoundsException {
        if (end < 0) {
            throw new IndexOutOfBoundsException();
        }        
        this.end = end;
    }
    
    private String substring() throws InvalidValue {
        if (begin >= end)
            throw new InvalidValue();
        int lastIndex = word.length() - 1;
        if (end > lastIndex)
            throw new InvalidValue();
        
        int count = begin;
        String substring = new String();
        while (count <= end) {
            substring +=word.charAt(count);
            count++;
        }
        return substring;        
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
            String substring = substring();
            out.println("Palavra=" + word + "<P>");
            out.println("Início=" + begin + "<P>");
            out.println("Fim=" + end + "<P>");
            out.println("Substring=" + substring + "<P>");
        } catch (java.io.IOException | InvalidValue ex) {
            try {
                out.println("Palavra pesquisada: " + word + "!" + "<P>");
                out.println("Verifique os valores dos índices de inicio (" + begin + ") e fim (" + end + ") !" + "<P>" + "Log da exceção:" + ex + "<P>");
            } catch (IOException ioEx) {
                throw new JspException("Error in Split tag", ioEx);
            }
        }
    }
    
}
