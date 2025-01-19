package Models;

import java.sql.Date;

public class Accounts {

    private int accountID;
    private String username;
    private String password;
    private int isAdmin;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Date birthDay;
    private boolean gender;
    private String region;
    private String address;
    private double money;

    public Accounts() {
    }

    public Accounts(int accountID, String username, String password, int isAdmin, String firstName, String lastName, String email, String phone, Date birthDay, boolean gender, String region, String address, double money) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.gender = gender;
        this.region = region;
        this.address = address;
        this.money = money;
    }
    
    public Accounts(String firstName, String lastName,double money) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.money = money;
    }
    
    public Accounts(String username) {
        this.username = username;
    }

    public Accounts(int accountID, String firstName, String lastName, String email, String phone, Date birthDay, boolean gender, String region, String address) {
        this.accountID = accountID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.birthDay = birthDay;
        this.gender = gender;
        this.region = region;
        this.address = address;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Accounts{" + "accountID=" + accountID + ", username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", birthDay=" + birthDay + ", gender=" + gender + ", region=" + region + ", address=" + address + ", money=" + money + '}';
    }

}
