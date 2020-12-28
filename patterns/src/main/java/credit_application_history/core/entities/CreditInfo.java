package credit_application_history.core.entities;

import credit_application.entities.CreditHistory;

import java.math.BigDecimal;
import java.time.Period;

public class CreditInfo {
    private BigDecimal rate;
    private Period period;
    private BigDecimal monthlyPayment;
    private CreditHistory creditHistory;

    public CreditInfo(BigDecimal rate, Period period, BigDecimal monthlyPayment, CreditHistory creditHistory) {
        this.rate = rate;
        this.period = period;
        this.monthlyPayment = monthlyPayment;
        this.creditHistory = creditHistory;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public Period getPeriod() {
        return period;
    }

    public BigDecimal getMonthlyPayment() {
        return monthlyPayment;
    }

    public CreditHistory getCreditHistory() {
        return creditHistory;
    }
}
