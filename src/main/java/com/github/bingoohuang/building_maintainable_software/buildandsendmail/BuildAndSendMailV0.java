package com.github.bingoohuang.building_maintainable_software.buildandsendmail;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/17.
 */
public class BuildAndSendMailV0 {
    public void buildAndSendMail(
            MailMan m, String firstName, String lastName,
            String division, String subject, MailFont font, String message1,
            String message2, String message3) {
        // Format the email address
        String mId = firstName.charAt(0) + "." + lastName.substring(0, 7) + "@"
                + division.substring(0, 5) + ".compa.ny";
        // Format the message given the content type and raw message
        MailMessage mMessage = formatMessage(font,
                message1 + message2 + message3);
        // Send message
        m.send(mId, subject, mMessage);
    }

    private MailMessage formatMessage(MailFont font, String string) {
        return null;
    }

    private class MailMan {
        public void send(String mId, String subject, MailMessage mMessage) {
        }

    }

    private class MailFont {

    }

    private class MailMessage {

    }
}
