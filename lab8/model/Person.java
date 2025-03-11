package model;

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

    public String getName() {
        return name;
    }

    public Profession getProfession() {
        return profession;
    }



    public Person getPartner() {
        return partner;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    private int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    private double getTotalIncome() {
        if (partner != null && partner.getProfession() != null) {

            return profession.getMonthlyIncome() + partner.getProfession().getMonthlyIncome() * 0.94;
        } else {
            return profession.getMonthlyIncome();
        }
    }


    public double computeMaxMortgage() {
        if (getAge() < 18) {
            return 0;
        }
        return profession.getMortgageEligibility(getTotalIncome());
    }


}
