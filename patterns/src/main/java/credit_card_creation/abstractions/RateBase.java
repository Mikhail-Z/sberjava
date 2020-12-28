package credit_card_creation.abstractions;

import java.math.BigDecimal;

public abstract class RateBase {
    private String rateName;
    private BigDecimal cardMaintenanceYearCost;
    private BigDecimal creditLimit;
    private int interestFreePeriodDays;
    private BigDecimal notificationCost;
    private BigDecimal replenishmentFromCardsOfOtherBanksCost;
    private BigDecimal operationAnnualInterestRate;

    public RateBase() {}

    public RateBase(
            String rateName,
            BigDecimal cardMaintenanceYearCost,
            BigDecimal creditLimit,
            int interestFreePeriodDays,
            BigDecimal notificationCost,
            BigDecimal replenishmentFromCardsOfOtherBanksCost,
            BigDecimal operationAnnualInterestRate) {

        this.rateName = rateName;
        this.cardMaintenanceYearCost = cardMaintenanceYearCost;
        this.creditLimit = creditLimit;
        this.interestFreePeriodDays = interestFreePeriodDays;
        this.notificationCost = notificationCost;
        this.replenishmentFromCardsOfOtherBanksCost = replenishmentFromCardsOfOtherBanksCost;
        this.operationAnnualInterestRate = operationAnnualInterestRate;
    }
}
