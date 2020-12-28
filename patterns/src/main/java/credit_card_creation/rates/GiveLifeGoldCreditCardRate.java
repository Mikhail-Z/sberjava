package credit_card_creation.rates;

import credit_card_creation.abstractions.RateBase;

import java.math.BigDecimal;

public class GiveLifeGoldCreditCardRate extends RateBase {
    //Бонусы за покупки у партнеров
    private BigDecimal accrualBonusesRate;

    //Отчисления в фонд Подари Жизнь от суммы ваших покупок из личных средств
    private BigDecimal donationsToGiveLifeFundFromPersonalFundsForPurchasesRate;
    //Отчисления в фонд Подари Жизнь от суммы ваших покупок из средств банка
    private BigDecimal donationsToGiveLifeFundFromBankFundsForPurchasesRate;
    //Отчисления в фонд Подари Жизнь от банка от суммы годового обслуживания карты
    private BigDecimal donationsToGiveLifeFundFromCardMaintenanceYearRate;
    //Отчисления в фонд Подари Жизнь от Visa от суммы ваших покупок
    private BigDecimal donationsToGiveLifeFundFromVisaForPurchasesRate;
}
