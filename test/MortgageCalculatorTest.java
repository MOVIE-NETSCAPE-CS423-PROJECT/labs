package test;

import static org.junit.Assert.*;

import main.MortgageCalculator;
import main.model.Person;
import main.model.Profession;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MortgageCalculatorTest {

    private MortgageCalculator mortageCalculator;

    Person partnerWithoutProfession;

    Person partnerWithProfession;

    Person personWithPartnerWithProfession;

    Person  personWithPartnerWithoutProfession;

    Person personWithoutPartner;


    @Before
    public void setUp() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        partnerWithProfession = new Person("Jones Partner",
                new Profession("scrum master", 3000),
                null,
                LocalDate.parse("30/06/1992", dateTimeFormatter));

        partnerWithoutProfession = new Person("Partner NoProfession",
                null,
                null,
                LocalDate.parse("30/06/1999", dateTimeFormatter));


        personWithPartnerWithProfession = new Person("Jones",
                new Profession("developer", 6000),
                partnerWithProfession,
                LocalDate.parse("29/03/1991", dateTimeFormatter));


        personWithPartnerWithoutProfession = new Person("Alice",
                new Profession("system administrator", 6000),
                partnerWithoutProfession,
                LocalDate.parse("29/03/1996", dateTimeFormatter));


        personWithoutPartner = new Person("David",
                new Profession("system administrator", 4000), null,
                LocalDate.parse("13/05/1989", dateTimeFormatter));

        mortageCalculator = new MortgageCalculator();

    }


    @Test
    public void testMortgageEligibilityWithPersonWithoutPartner() {
        double result = mortageCalculator.computePersonMaxMortgage(personWithoutPartner);
        assertEquals(140000, result, 0.001);
    }

    @Test
    public void testMortgageEligibilityWithPersonWithPartnerWithoutProfession() {
        double result = mortageCalculator.computePersonMaxMortgage(personWithPartnerWithoutProfession);
        assertEquals(220000, result, 0.001);
    }

    @Test
    public void testMortgageEligibilityWithPersonWithPartnerWithProfession() {
        double result = mortageCalculator.computePersonMaxMortgage(personWithPartnerWithProfession);
        assertEquals(280000, result, 0.001);
    }

    @Test
    public void testMortgageEligibilityWithPersonWithPartnerHavingProfession() {
        double result = mortageCalculator.computePersonMaxMortgage(personWithPartnerWithProfession);
        assertEquals(280000, result, 0.001);
    }
}


