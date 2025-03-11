package model;


public class Profession {

    private final ProfessionType professionType;
    private final double monthlyIncome;

    public Profession(String name, double monthlyIncome) {
        this.name = name;
        this.monthlyIncome = monthlyIncome;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public double getMortgageEligibility(double totalIncome) {

        double mortgageLimit = 0;

        if (totalIncome >= 2000 && totalIncome < 3000) {
            mortgageLimit = 160000;
        } else if (totalIncome >= 3000 && totalIncome < 5000) {
            mortgageLimit = 180000;
        } else if (totalIncome >= 5000) {
            mortgageLimit = 220000;
        }

        return mortgageLimit;
    }
}

