package _05_payroll;

/*
Write unit tests to make sure that these methods are working properly
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
        return "Hello " + employeeName + ", We are please to offer you an hourly wage of " + hourlyWage;
    }

}
