package credit_card_creation.abstractions;

import credit_card_creation.others.PaymentSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class CreditCard {
    private final UUID id = UUID.randomUUID();
    private String billNumber;
    private String pin;
    private String cardNumber;
    private String holderName;
    private PaymentSystem paymentSystem;
    private LocalDateTime validDate;
    private String bankName;
    private String cvv;

    protected BigDecimal currentCreditSum = BigDecimal.valueOf(0);
    protected BigDecimal currentPersonalSum = BigDecimal.valueOf(0);

    public CreditCard(
            String billNumber,
            String pin,
            String cardNumber,
            String holderName,
            PaymentSystem paymentSystem,
            LocalDateTime validDate,
            String bankName,
            String cvv) {

        this.billNumber = billNumber;
        this.pin = pin;
        this.cardNumber = cardNumber;
        this.holderName = holderName;
        this.paymentSystem = paymentSystem;
        this.validDate = validDate;
        this.bankName = bankName;
        this.cvv = cvv;
    }

    public UUID getId() {
        return id;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public String getPin() {
        return pin;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public PaymentSystem getPaymentSystem() {
        return paymentSystem;
    }

    public LocalDateTime getValidDate() {
        return validDate;
    }

    public String getBankName() {
        return bankName;
    }

    public String getCvv() {
        return cvv;
    }
}
