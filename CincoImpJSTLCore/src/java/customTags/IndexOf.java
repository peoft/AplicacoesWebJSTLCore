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
public class IndexOf extends SimpleTagSupport {

    private String sentence;
    private String search;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    private boolean isSearchLengthValid() {
        if (search.length() <= 0 )
            return false;
        if (search.length() > sentence.length()) {
            return false;
        }
        return true;
    }

    private boolean isMatchedString(String string) {
        if (string.length() == search.length()) {
            if (string.equals(search)) {
                return true;
            }
        }
        return false;
    }

    private String getSubstring(int begin) throws IndexOutOfBoundsException {
        if (begin < 0)
            throw new IndexOutOfBoundsException();
        
        if (begin >= sentence.length())
            return null;
        
        int end = begin + search.length();
        if (end > sentence.length())
            return null;
        
        String substring = new String();
        
        substring = sentence.substring(begin, end);
        return substring;
    }

    public int indexOf() {
        int index = -1;
        if (isSearchLengthValid() == true) {
            int position = 0;
            String substring = null;
            substring = getSubstring(position);
            while (substring != null) {
                if (isMatchedString(substring) == true) {
                    index = position;
                    break;
                }
                position++;
                substring = getSubstring(position);
            }
        }
        return index;
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

            int index = indexOf();

            out.println("Sentença:" + this.sentence + "<P>");
            out.println("Busca:" + this.search + "<P>");
            out.println("Índice=" + index + "<P>");

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in IndexOf tag", ex);
        }
    }

}
