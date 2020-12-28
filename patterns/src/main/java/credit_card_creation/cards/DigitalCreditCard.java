package credit_card_creation.cards;

import credit_card_creation.abstractions.CreditCard;
import credit_card_creation.others.PaymentSystem;
import credit_card_creation.rates.DigitalCreditCardRate;

import java.time.LocalDateTime;

final public class DigitalCreditCard extends CreditCard {

    private final DigitalCreditCardRate rate;

    public DigitalCreditCard(DigitalCreditCardRate rate, String billNumber, String pin, String cardNumber, String holderName, PaymentSystem paymentSystem, LocalDateTime validDate, String bankName, String cvv) {
        super(billNumber, pin, cardNumber, holderName, paymentSystem, validDate, bankName, cvv);
        this.rate = rate;
    }

    public DigitalCreditCardRate getRate() {
        return rate;
    }
}
