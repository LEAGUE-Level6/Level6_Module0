package _06_payroll;

/*
Complete the units tests in src/test/java/_06_payroll/PayrollTest.java to make sure that the methods are working properly.
 */
public class Payroll {

    public double calculatePaycheck(double hourlyWage, int numHours){
        return hourlyWage * numHours;
    }

    public double calculateMileageReimbursement(int milesTraveled){
        double centsPerMile = .575;
        return milesTraveled * centsPerMile;
    }

    public String createOfferLetter(String employeeName, double hourlyWage){
        return "Hello " + employeeName + ", We are pleased to offer you an hourly wage of " + hourlyWage;
    }

}
