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
public class Contains extends SimpleTagSupport {

    private String sentence;
    private String word;

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) throws NullPointerException {
        if (sentence == null) {
            throw new NullPointerException();
        }
        this.sentence = sentence;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) throws NullPointerException {
        if (word == null) {
            throw new NullPointerException();
        }
        this.word = word;
    }

    private boolean isWordLengthValid() {
        if (word.length() <= 0) {
            return false;
        }
        if (word.length() > sentence.length()) {
            return false;
        }
        return true;
    }

    private boolean isMatchedString(String string) {
        if (string.length() == word.length()) {
            if (string.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private String getSubstring(int begin) throws IndexOutOfBoundsException {
        if (begin < 0) {
            throw new IndexOutOfBoundsException();
        }

        if (begin >= sentence.length()) {
            return null;
        }

        int end = begin + word.length();
        if (end > sentence.length()) {
            return null;
        }

        String substring = new String();

        substring = sentence.substring(begin, end);
        return substring;
    }

    public boolean contains() {
        boolean ret = false;
        if (isWordLengthValid() == true) {
            int position = 0;
            String substring = null;
            substring = getSubstring(position);
            while (substring != null) {
                if (isMatchedString(substring) == true) {
                    ret = true;
                    break;
                }
                position++;
                substring = getSubstring(position);
            }
        }
        return ret;
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
            out.println("Sentença: " + sentence + "<P>");
            out.println("Palavra: " + word + "<P>");
            if (contains() == true) {
                out.println("Contém " + word + "!" + "<P>");
            } else {
                out.println("Não contém " + word + "!" + "<P>");
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in Contains tag", ex);
        }
    }

}
