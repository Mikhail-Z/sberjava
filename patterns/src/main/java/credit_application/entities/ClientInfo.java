package credit_application.entities;

import java.math.BigDecimal;

public class ClientInfo {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String passportSeries;
    private String passportNumber;
    private BigDecimal monthlyIncome;

    public ClientInfo(
            String firstName,
            String lastName,
            String patronymic,
            String passportSeries,
            String passportNumber,
            BigDecimal monthlyIncome) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.monthlyIncome = monthlyIncome;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public BigDecimal getMonthlyIncome() {
        return monthlyIncome;
    }
}
