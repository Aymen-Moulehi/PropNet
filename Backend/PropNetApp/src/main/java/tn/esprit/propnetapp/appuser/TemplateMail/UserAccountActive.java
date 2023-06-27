package tn.esprit.propnetapp.appuser.TemplateMail;

public class UserAccountActive {
    public String ContentMailToRecipient (String RecipientName){
        String template = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Activate Your Account</title>\n" +
                "</head>\n" +
                "<body style=\"margin: 0; padding: 0; background-color: #f2f2f2;\">\n" +
                "    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n" +
                "        <tr>\n" +
                "            <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 40px 0 30px 0;\">\n" +
                "                <img src=\"https://cdn.dribbble.com/users/3299931/screenshots/11595099/activate_your_account_2x.png\" alt=\"Activate Your Account\" width=\"300\" height=\"auto\" style=\"display: block;\">\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\n" +
                "                <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;\">\n" +
                "                    <tr>\n" +
                "                        <td style=\"padding: 20px 0 30px 0; color: #333333; font-family: Arial, sans-serif; font-size: 24px; line-height: 28px;\">\n" +
                "                            <b>Dear " + RecipientName + ",</b>\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"padding: 0 0 20px 0; color: #333333; font-family: Arial, sans-serif; font-size: 16px; line-height: 22px;\">\n" +
                "                            Thank you for creating an account with us. Your account has been successfully activated.\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"padding: 0; color: #333333; font-family: Arial, sans-serif; font-size: 16px; line-height: 22px;\">\n" +
                "                            If you have any questions or need assistance, please feel free to contact us.\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                    <tr>\n" +
                "                        <td style=\"padding: 0; color: #333333; font-family: Arial, sans-serif; font-size: 16px; line-height: 22px;\">\n" +
                "                            Best regards,<br>\n" +
                "                            Your Company\n" +
                "                        </td>\n" +
                "                    </tr>\n" +
                "                </table>\n" +
                "            </td>\n" +
                "        </tr>\n" +
                "    </table>\n" +
                "</body>\n" +
                "</html>";

        return template;
    }
}
