package com.aarongoldbin.week3ExerciseTags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.*;

/**
 * This class will determine the time and output an appropriate message to the jsp
 *
 * @author agoldbin
 */

/**
 * The type Time tag.
 */
public class TimeTag extends SimpleTagSupport {
    private LocalTime currentTime;
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        currentTime = LocalTime.now();
//      Look how nice I am. I left you the testing line!
//        currentTime = LocalTime.of(17, 01);

        out.println(determineTimeMessage(currentTime));
    }

    /**
     * Determine time message string.
     *
     * @param currentTime the current time
     * @return the string
     */
    public String determineTimeMessage(LocalTime currentTime) {
        String timeMessage = "";
        if (currentTime.isBefore(LocalTime.of(12, 00))) {
            timeMessage = "Good Morning! What a wonderfully frigid day!";
        } else if (currentTime.isBefore(LocalTime.of(17, 00))) {
            timeMessage = "Good Afternoon! How was lunch?";
        } else {
            timeMessage = "It's 5 o'clock somewhere! That means it's Miller "
                    + "Time!";
        }
        return timeMessage;
    }
}
