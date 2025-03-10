package main.model;

public enum ProfessionType {
    HIGH_INCOME,
    MID_INCOME,
    LOW_INCOME;

    public static ProfessionType fromProfession(String professionName) {
        return switch (professionName.toLowerCase()) {
            case "developer", "architect", "scrum master" -> MID_INCOME;
            case "tester", "system administrator", "technical writer" -> LOW_INCOME;
            case "department head", "professor" -> HIGH_INCOME;
            default -> throw new IllegalArgumentException("Unknown profession: " + professionName);
        };
    }

    public double getMortgageLimit(double totalIncome) {
        if (totalIncome >= 2000 && totalIncome < 3000) {
            return switch (this) {
                case HIGH_INCOME -> 220000;
                case MID_INCOME -> 160000;
                case LOW_INCOME -> 120000;
            };
        } else if (totalIncome >= 3000 && totalIncome < 5000) {
            return switch (this) {
                case HIGH_INCOME -> 250000;
                case MID_INCOME -> 180000;
                case LOW_INCOME -> 140000;
            };
        } else if (totalIncome >= 5000) {
            return switch (this) {
                case HIGH_INCOME -> 280000;
                case MID_INCOME -> 220000;
                case LOW_INCOME -> 160000;
            };
        }

        return 0;
    }
}
