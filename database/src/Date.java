public class Date {
    private Integer day;
    private Integer month;
    private Integer year;

    Date() {
        this(0, 0, 0);
    }

    Date(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return day.toString() + '/'
                + month.toString() + '/'
                + year.toString();
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
