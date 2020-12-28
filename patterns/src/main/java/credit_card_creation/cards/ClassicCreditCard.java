package credit_card_creation.cards;

import credit_card_creation.abstractions.CreditCard;
import credit_card_creation.others.PaymentSystem;
import credit_card_creation.rates.ClassicCreditCardRate;

import java.time.LocalDateTime;

final public class ClassicCreditCard extends CreditCard {
    ClassicCreditCardRate rate;

    public ClassicCreditCard(
            ClassicCreditCardRate rate,
            String billNumber,
            String pin,
            String cardNumber,
            String holderName,
            PaymentSystem paymentSystem,
            LocalDateTime validDate,
            String bankName,
            String cvv) {

        super(billNumber, pin, cardNumber, holderName, paymentSystem, validDate, bankName, cvv);
        this.rate = rate;
    }

    public ClassicCreditCardRate getRate() {
        return rate;
    }
}
