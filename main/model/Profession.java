package main.model;

public class Profession {

    private final ProfessionType professionType;
    private final double monthlyIncome;

    public Profession(String name, double monthlyIncome) {
        this.professionType = ProfessionType.fromProfession(name);
        this.monthlyIncome = monthlyIncome;
    }



    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public ProfessionType getProfessionType() {
        return professionType;
    }
}
