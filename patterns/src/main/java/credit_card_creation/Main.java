package credit_card_creation;

import credit_card_creation.abstractions.CreditCard;
import credit_card_creation.abstractions.RateBase;
import credit_card_creation.factories.CreditCardFactory;
import credit_card_creation.others.PaymentSystem;
import credit_card_creation.rates.GiveLifeGoldCreditCardRate;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        RateBase rate = new GiveLifeGoldCreditCardRate();
        CreditCard card = new CreditCardFactory()
                .Create(rate, "10000053453", "1234", "1234567887654321", "Name Surname", PaymentSystem.MasterCard, LocalDateTime.now().plusYears(3), "sberbank", "123");
        System.out.printf("была выпущена карта с ид: %s%n", card.getId());
    }
}
