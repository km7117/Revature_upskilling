package p1;

public enum Day {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    // Method to return the type of day (Weekday or Weekend)
    public String getDayType() {
        return (this == SATURDAY || this == SUNDAY) ? "Weekend" : "Weekday";
    }

    // Method to check if the day is a weekend
    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }

    // Overriding toString to provide user-friendly format
    @Override
    public String toString() {
        String dayName = this.name().toLowerCase();
        return dayName.substring(0, 1).toUpperCase() + dayName.substring(1);
    }

    // Method to compare the order of days in the week
    public int compareDays(Day day) {
        return this.ordinal() - day.ordinal();
    }

}

class Main {
    public static void main(String[] args) {
        // Print each day and its type (Weekday or Weekend)
        for (Day day : Day.values()) {
            System.out.println(day + " is a " + day.getDayType());
        }

        // Check if a specific day is a weekend
        Day dayToCheck = Day.SATURDAY;
        System.out.println("\nIs " + dayToCheck + " a weekend? " + dayToCheck.isWeekend());

        // Compare two days to check which one is earlier or later in the week
        Day day1 = Day.WEDNESDAY;
        Day day2 = Day.FRIDAY;

        int comparisonResult = day1.compareDays(day2);
        if (comparisonResult < 0) {
            System.out.println(day1 + " is earlier in the week than " + day2);
        } else if (comparisonResult > 0) {
            System.out.println(day1 + " is later in the week than " + day2);
        } else {
            System.out.println(day1 + " and " + day2 + " are the same day.");
        }
    }
}

