package credit_card_creation.factories;

import credit_card_creation.abstractions.CreditCard;
import credit_card_creation.abstractions.RateBase;
import credit_card_creation.cards.ClassicCreditCard;
import credit_card_creation.cards.DigitalCreditCard;
import credit_card_creation.cards.GiveLifeGoldCreditCard;
import credit_card_creation.others.PaymentSystem;
import credit_card_creation.rates.ClassicCreditCardRate;
import credit_card_creation.rates.DigitalCreditCardRate;
import credit_card_creation.rates.GiveLifeGoldCreditCardRate;

import java.time.LocalDateTime;

public class CreditCardFactory {

    public CreditCard Create(
            RateBase rate,
            String billNumber,
            String pin,
            String cardNumber,
            String holderName,
            PaymentSystem paymentSystem,
            LocalDateTime validDate,
            String bankName,
            String cvv) {

        if (rate instanceof ClassicCreditCardRate) {
            return new ClassicCreditCard((ClassicCreditCardRate) rate, billNumber, pin, cardNumber, holderName, paymentSystem, validDate, bankName, cvv);
        }
        else if (rate instanceof DigitalCreditCardRate) {
            return new DigitalCreditCard((DigitalCreditCardRate) rate, billNumber, pin, cardNumber, holderName, paymentSystem, validDate, bankName, cvv);
        }
        else if (rate instanceof GiveLifeGoldCreditCardRate) {
            return new GiveLifeGoldCreditCard((GiveLifeGoldCreditCardRate) rate, billNumber, pin, cardNumber, holderName, paymentSystem, validDate, bankName, cvv);
        }
        else throw new IllegalArgumentException("задан неправильный тариф -- под него не существует кредитной карты");
    }
}
