package tn.esprit.propnetapp.claim.TemplateMail;

public class ClaimEmail {
    public static String ContentMailToRecipient (String RecipientName){
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
                "                <img src=\"https://media.istockphoto.com/id/1136139496/fr/photo/pile-dapplications-revendications-sur-un-bureau.jpg?s=612x612&w=0&k=20&c=uA_DXTzOZ3amQxYGRswb7b5l18hPmNconEWTnU0WK18=\" alt=\"Activate Your Account\" width=\"300\" height=\"auto\" style=\"display: block;\">\n" +
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
                "                            Thank you for submitting your request. We have received it and will process it accordingly. If any additional information is needed, we will reach out to you. Have a great day!.\n" +
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