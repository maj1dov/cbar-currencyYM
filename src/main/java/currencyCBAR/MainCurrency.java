package currencyCBAR;

import info.md7.cbar_currency.exceptions.CurrencyNotFoundException;
import info.md7.cbar_currency.model.CurrencyCode;
import info.md7.cbar_currency.util.CurrencyConverter;

import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.Scanner;

public class mainCurrency {
    public static void main(String[] args) {

        for (CurrencyCode info : EnumSet.allOf(CurrencyCode.class)) {
            System.out.println(info + " — " + info.getName() + ";");
        }

        Scanner ScanFromCurrency = new Scanner(System.in);
        System.out.println("Zəhmət olmasa satmaq istədiyiniz valyutanın 3 rəqəmli kodunu daxil edin: ");
        String FromCurrency = ScanFromCurrency.nextLine();

        Scanner ScanToCurrency = new Scanner(System.in);
        System.out.println('\n' + "Zəhmət olmasa almaq istədiyiniz valyutanın 3 rəqəmli kodunu daxil edin: ");
        String ToCurrency = ScanToCurrency.nextLine();

        Scanner ScanAmount = new Scanner(System.in);
        System.out.print("Satmaq istədiyiniz məbləği qeyd edin: ");
        BigDecimal Amount = ScanAmount.nextBigDecimal();

        if (FromCurrency.toUpperCase().equals("AZN") && ToCurrency.toUpperCase().equals("USD")) {
            try {
                BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.USD);
                System.out.println(ResultCurrency);
            } catch (CurrencyNotFoundException e) {
                e.printStackTrace();
            }
        } else if (FromCurrency.toUpperCase().equals("AZN") && ToCurrency.toUpperCase().equals("EUR")) {
            try {
                BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.EUR);
                System.out.println(ResultCurrency);
            } catch (CurrencyNotFoundException e) {
                e.printStackTrace();
            }
        } else if (FromCurrency.toUpperCase().equals("AZN") && ToCurrency.toUpperCase().equals("RUB")) {
            try {
                BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.RUB);
                System.out.println(ResultCurrency);
            } catch (CurrencyNotFoundException e) {
                e.printStackTrace();
            }
        } else if (FromCurrency.toUpperCase().equals("AZN") && ToCurrency.toUpperCase().equals("TRY")) {
            try {
                BigDecimal ResultCurrency = CurrencyConverter.convertFromAzn(Amount, CurrencyCode.TRY);
                System.out.println(ResultCurrency);
            } catch (CurrencyNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Qaqa yoxu bizde elə valyuta");
        }
        }
    }
