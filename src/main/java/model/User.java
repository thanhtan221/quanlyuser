package model;

public class User {
 protected int id;
 protected String name;
 protected String password;
 protected String phone;
 protected String address;
 protected String city;
 protected Role role;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

//    public User(String name, String password, String phone) {
//        this.name = name;
//        this.password = password;
//        this.phone = phone;
//    }

    public User(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        this.role=role;
    }

    public User(int id, String name, String password, String phone, String address, String city, Role role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone=phone;
        this.address = address;
        this.city = city;
        this.role=role;
    }
    public User(String name, String password, String phone, String address, String city) {
        this.name = name;
        this.password = password;
        this.phone=phone;
        this.address = address;
        this.city = city;
    }

    public User(String name, String password, String phone, String address, String city, Role role) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.role = role;
    }

    public User(int id, String name, String password, String phone, String address, String city) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.phone=phone;
        this.address = address;
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", role=" + role +
                '}';
    }
}
