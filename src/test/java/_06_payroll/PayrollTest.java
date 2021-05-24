package _06_payroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PayrollTest {

    Payroll payroll = new Payroll();

    @Test
    void itShouldCalculatePaycheck() {
        //given
        double hourlyWage = 15.00;
        int numHours =  40;
        double expectedPaycheck = hourlyWage * numHours;

        //when
        double actualPaycheck = payroll.calculatePaycheck(hourlyWage, numHours);

        //then
        assertEquals(expectedPaycheck, actualPaycheck);
    }

    @Test
    void itShouldCalculateMileageReimbursement() {
        //given
        int milesTraveled = 10;
        double expectedReimbursement = 10*.575;

        //when
        double actualReimbursement = payroll.calculateMileageReimbursement(10);

        //then
        assertEquals(expectedReimbursement, actualReimbursement);
    }

    @Test
    void itShouldCreateOfferLetter() {
        //given
        String employeeName = "Mortimer";
        double hourlyWage = 15.00;
        String expectedOfferLetter = "Hello " + employeeName + ", We are pleased to offer you an hourly wage of " + hourlyWage;

        //when
        String actualOfferLetter = payroll.createOfferLetter(employeeName, hourlyWage);

        //then
        assertEquals(expectedOfferLetter, actualOfferLetter);
    }

}
