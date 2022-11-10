import java.util.concurrent.atomic.AtomicInteger;

public class Contact {
    private static AtomicInteger nextID = new AtomicInteger(1);

    private int id;
    private String firstName;
    private String surname;
    private String address;
    private String areaCode;
    private String city;
    private String age;
    private String mobile;
    private String home;
    private String work;

    Contact(int id, String firstName, String surname, String age, String address, String areaCode, String city, String mobile, String home, String work) {
        this.id = id;
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.address = address;
        this.areaCode = areaCode;
        this.city = city;
        this.mobile = mobile;
        this.home = home;
        this.work = work;

    }

    Contact(String firstName, String surname, String age, String address, String areaCode, String city, String mobile, String home, String work) {
        this(nextID.getAndIncrement(), firstName, surname, age,address, areaCode, city, mobile, home, work);
    }

    int getID() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    String getFirstName() {
        return firstName;
    }

    String getSurname() {
        return surname;
    }

    String getAge(){ return age;}

    String getAddress() {
        return address;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    @Override
    public String toString() {
        return "\nID: " + getID() + "\nName: " + getFirstName() + "\nSurname: " + getSurname() + "\nAge: " + getAge() +
            "\nAddress: " + getAddress()  +"\nAreacode: " + getAreaCode() + "\nCity: " + getCity() + "\nMobile: " + getMobile()  + "\nHome: " + getHome() + "\nWork: " + getWork()+"\n";
    }

    String getName() {
        return firstName + surname;
    }
}
