package com.github.bingoohuang.building_maintainable_software.buildandsendmail;

import lombok.AllArgsConstructor;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/17.
 */
public class BuildAndSendMailV1 {
    public void buildAndSendMail(MailMan m, MailAddress mAddress, MailBody mBody) {
        // Build the mail
        Mail mail = new Mail(mAddress, mBody);
        // Send the mail
        m.sendMail(mail);
    }

    @AllArgsConstructor
    private static class Mail {
        private MailAddress address;
        private MailBody body;
    }

    private static class MailBody {
    }

    private class MailAddress {
        private String mId;

        private MailAddress(String firstName, String lastName, String division) {
            this.mId = firstName.charAt(0) + "." + lastName.substring(0, 7)
                    + "@" + division.substring(0, 5) + ".compa.ny";
        }
    }

    private class MailMan {
        public void sendMail(Mail mail) {
        }
    }
}
