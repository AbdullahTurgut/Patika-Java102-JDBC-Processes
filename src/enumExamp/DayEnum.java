package enumExamp;

public enum DayEnum {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THURSDAY(5),
    FRIDAY(6),
    SATURDAY(7);
    private int day;

    DayEnum(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

}
