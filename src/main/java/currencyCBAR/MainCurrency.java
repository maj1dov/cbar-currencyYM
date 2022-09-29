package currencyCBAR;

import info.md7.cbar_currency.exceptions.CurrencyNotFoundException;
import info.md7.cbar_currency.model.CurrencyCode;
import info.md7.cbar_currency.util.CurrencyConverter;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Scanner;

public class MainCurrency {
    public static void main(String[] args) throws CurrencyNotFoundException {

        for (CurrencyCode info : EnumSet.allOf(CurrencyCode.class)) {
            System.out.println(info + " — " + info.getName() + ";");
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Zəhmət olmasa satmaq istədiyiniz valyutanın 3 rəqəmli kodunu daxil edin: ");
        String FromCurrency = scanner.nextLine();

        System.out.println('\n' + "Zəhmət olmasa almaq istədiyiniz valyutanın 3 rəqəmli kodunu daxil edin: ");
        String ToCurrency = scanner.nextLine();

        System.out.print("Satmaq istədiyiniz məbləği qeyd edin: ");
        BigDecimal Amount = scanner.nextBigDecimal();

        try {
            BigDecimal result = doConvertation(FromCurrency, ToCurrency, Amount);
            System.out.println(result);
        } catch (CurrencyNotFoundException e) {
            throw new RuntimeException(e);
        }

//        try {
//            if (FromCurrency.equalsIgnoreCase("AZN") && ToCurrency.equalsIgnoreCase("USD")) {
//                    BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.USD);
//                    System.out.println(ResultCurrency);
//            } else if (FromCurrency.toUpperCase().equals("AZN") && ToCurrency.toUpperCase().equals("EUR")) {
//                    BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.EUR);
//                    System.out.println(ResultCurrency);
//            } else if (FromCurrency.toUpperCase().equals("AZN") && ToCurrency.toUpperCase().equals("RUB")) {
//                    BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.RUB);
//                    System.out.println(ResultCurrency);
//            } else if (FromCurrency.toUpperCase().equals("AZN") && ToCurrency.toUpperCase().equals("TRY")) {
//                    BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.TRY);
//                    System.out.println(ResultCurrency);
//            } else {
//                System.out.println("Qaqa yoxu bizde elə valyuta");
//            }
//        } catch (CurrencyNotFoundException e) {
//            e.printStackTrace();
//        }
    }

    private static BigDecimal doConvertation(String from, String to, BigDecimal amount)
        throws CurrencyNotFoundException {
        CurrencyCode fromCurrency = CurrencyCode.valueOf(from.toUpperCase());
        CurrencyCode toCurrency = CurrencyCode.valueOf(to.toUpperCase());
        if (fromCurrency == CurrencyCode.AZN) {
            return CurrencyConverter.convertFromAzn(amount, toCurrency);
        } else {
            return CurrencyConverter.convertToAzn(amount, fromCurrency);
        }
    }
}
