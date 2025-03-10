package main.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private final String name;
    private final Profession profession;
    private final Person partner;
    private final LocalDate birthDate;

    public Person(String name, Profession profession, Person partner, LocalDate birthDate) {
        this.name = name;
        this.profession = profession;
        this.partner = partner;
        this.birthDate = birthDate;
    }


    public Profession getProfession() {
        return profession;
    }


    private int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    private double computeTotalIncome() {
        double totalIncome = profession.getMonthlyIncome();
        if (partner != null && partner.getProfession() != null) {
            totalIncome += partner.getProfession().getMonthlyIncome() * 0.94;
        }
        return totalIncome;
    }

    public double computeMaxMortgage() {
        if (getAge() < 18) {
            return 0;
        }

        return profession.getProfessionType().getMortgageLimit(computeTotalIncome());
    }
}
