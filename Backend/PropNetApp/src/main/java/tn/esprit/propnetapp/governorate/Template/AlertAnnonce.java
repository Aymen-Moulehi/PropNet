package tn.esprit.propnetapp.governorate.Template;

import java.util.List;
import java.util.Map;


public class AlertAnnonce {
    public static String ContentMailToRecipient(String RecipientName, List<Map<String, Object>> results) {
        String template = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body style=\"margin: 0; padding: 0; background-color: #f2f2f2;\">\n" +
                "    <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border-collapse: collapse;\">\n" +
                "        <tr>\n" +
                "            <td align=\"center\" bgcolor=\"#ffffff\" style=\"padding: 40px 0 30px 0;\">\n" +
                "                <img src=\"https://img.freepik.com/premium-vector/special-offer-sale-discount-banner_180786-46.jpg?w=2000\" alt=\"Activate Your Account\" width=\"300\" height=\"auto\" style=\"display: block;\">\n" +
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
                "                            Exclusive Discounts: Take advantage of exclusive discounts on a wide selection of houses. We have negotiated special prices to make homeownership more affordable for you..\n" +
                "                        </td>\n" +
                "                    </tr>\n";

        // Add governorate information to the template
        for (Map<String, Object> data : results) {
            String governorateName = (String) data.get("GovernorateName");
            String minPriceTitle = (String) data.get("MinPriceTitle");
            Double minPriceLongitude = (Double) data.get("MinPriceLongitude");
            Double minPriceLatitude = (Double) data.get("MinPriceLatitude");
            String maxPriceTitle = (String) data.get("MaxPriceTitle");
            Double maxPriceLongitude = (Double) data.get("MaxPriceLongitude");
            Double maxPriceLatitude = (Double) data.get("MaxPriceLatitude");
            Integer idRealEstateMaxPrice = (Integer) data.get("idRealEstateMaxPrice");
            Integer idRealEstateMinPrice = (Integer) data.get("idRealEstateMinPrice");
            Float MinPrice = (Float) data.get("MinPrice");
            Float MaxPrice = (Float) data.get("MaxPrice");



            template += "                    <tr>\n" +
                    "                        <td style=\"padding: 0; color: #333333; font-family: Arial, sans-serif; font-size: 16px; line-height: 22px;\">\n" +
                    "                            <div style=\"text-align: center;\">\n" +
                    "                                <b>Governorate: " + governorateName + "</b><br>\n" +
                    "                            </div>\n" +
                    "                            <div style=\"padding: 10px 0; color: #333333; font-family: Arial, sans-serif; font-size: 16px; line-height: 22px;\">\n" +
                    "                                <div style=\"margin-bottom: 10px;\">\n" +
                    "                                    <span style=\"font-weight: bold;\">The most expensive house:</span><br>\n" +
                    "                                    <span style=\"font-weight: bold;\">House: </span>" + maxPriceTitle + "<br>\n" +
                    "                                    <span style=\"font-weight: bold;\">Longitude: </span>" + maxPriceLongitude + "<br>\n" +
                    "                                    <span style=\"font-weight: bold;\">Latitude: </span>" + maxPriceLatitude + "<br>\n" +
                    "                                    <span style=\"font-weight: bold;\">Price: </span>" + MaxPrice + "<br>\n" +
                    "                                <div>\n" +
                    "                                    <a href=\"http://localhost:4200/admin/annonce/listAnnonces/detail/" + idRealEstateMaxPrice + "\" style=\"display: inline-block; padding: 10px 20px; background-color: #ff9800; color: #ffffff; text-decoration: none; font-family: Arial, sans-serif; font-size: 16px; font-weight: bold; border-radius: 5px;\">See more</a><br>\n" +
                    "                                </div>\n" +
                    "                                </div>\n" +
                    "                                <div style=\"margin-bottom: 10px;\">\n" +
                    "                                    <span style=\"font-weight: bold;\">The least expensive house:</span><br>\n" +
                    "                                    <span style=\"font-weight: bold;\">House: </span>" + minPriceTitle + "<br>\n" +
                    "                                    <span style=\"font-weight: bold;\">Longitude: </span>" + minPriceLongitude + "<br>\n" +
                    "                                    <span style=\"font-weight: bold;\">Latitude: </span>" + minPriceLatitude + "<br>\n" +
                    "                                    <span style=\"font-weight: bold;\">Price: </span>" + MinPrice + "<br>\n" +
                    "                                </div>\n" +                    "                                <div>\n" +
                    "                                    <a href=\"http://localhost:4200/admin/annonce/listAnnonces/detail/" + idRealEstateMinPrice + "\" style=\"display: inline-block; padding: 10px 20px; background-color: #ff9800; color: #ffffff; text-decoration: none; font-family: Arial, sans-serif; font-size: 16px; font-weight: bold; border-radius: 5px;\">See more</a><br>\n" +
                    "                                </div>\n" +
                    "                            </div>\n" +
                    "                        </td>\n" +
                    "                    </tr>\n";
        }

        template += "                    <tr>\n" +
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
