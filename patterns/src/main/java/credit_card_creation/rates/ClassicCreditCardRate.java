package credit_card_creation.rates;

import credit_card_creation.abstractions.RateBase;

import java.math.BigDecimal;

public class ClassicCreditCardRate extends RateBase {
    //Бонусы за покупки у партнеров
    private BigDecimal accrualBonusesRate;
}
