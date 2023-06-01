package HackerRank;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleFormattedMoney {
    public static void main(String[] args) {
        double payment = 12324.134;

        // Format for US currency
        Locale usLocale = new Locale("en", "US");
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(usLocale);
        String usFormattedPayment = usFormat.format(payment);

        // Format for Indian currency
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        String indiaFormattedPayment = indiaFormat.format(payment);

        // Format for Chinese currency
        Locale chinaLocale = Locale.CHINA;
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(chinaLocale);
        String chinaFormattedPayment = chinaFormat.format(payment);

        // Format for French currency
        Locale franceLocale = Locale.FRANCE;
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(franceLocale);
        String franceFormattedPayment = franceFormat.format(payment);

        // Print the formatted values
        System.out.println("US: " + usFormattedPayment);
        System.out.println("India: " + indiaFormattedPayment);
        System.out.println("China: " + chinaFormattedPayment);
        System.out.println("France: " + franceFormattedPayment);
    }
}
