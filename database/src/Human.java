import java.util.Map;
import java.util.Scanner;

public class Human implements Entry, CSVFormatEntry {
    private String guid;
    private String email;
    private Date birthday;
    private String first;
    private String last;
    private String gender;
    private String city;
    private String state;

    @Override
    public void initialize(Map<String, Object> data) {

        guid = (String)data.get("guid");
        email = (String)data.get("email");

        var scDate = new Scanner((String)data.get("birthday"));
        scDate.useDelimiter("/");
        birthday = new Date(scDate.nextInt(),
                scDate.nextInt(), scDate.nextInt());

        first = (String)data.get("first");
        last = (String)data.get("last");
        gender = (String)data.get("gender");
        city = (String)data.get("city");
        state = (String)data.get("state");
    }

    @Override
    public String toString() {
        return guid + ' '
                + email + ' '
                + birthday.toString() + ' '
                + first + ' '
                + last + ' '
                + gender + ' '
                + city + ' '
                + state;
    }

    @Override
    public String toCSVString() {
        return guid + ';'
                + email + ';'
                + birthday.toString() + ';'
                + first + ';'
                + last + ';'
                + gender + ';'
                + city + ';'
                + state;
    }

    public String getGuid() {
        return guid;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
