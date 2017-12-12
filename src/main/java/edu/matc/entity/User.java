package edu.matc.entity;

import edu.matc.utility.LocalDateAttributeConverter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author hentwistle
 */
@Entity
@Table(name = "user")
public class User {
    //@Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="user_id")
    private int userid;

    @Id
    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="owner")
    private boolean owner;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_household",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "household_id")
    )
    private Set<Household> household;

    //@Column(name="date_of_birth")
    //@Convert(converter = LocalDateAttributeConverter.class)
    //private LocalDate birthdate;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userid    the userid
     * @param username  the username
     * @param email     the email address
     * @param password  the password
     * @param firstName the user first name
     * @param lastName the user last name
     * @param owner    indicates whether the user is the admin for their household
     */
    public User(int userid, String username, String email,
                String password, String firstName, String lastName, boolean owner) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.owner = owner;
    }


    /**
     * Gets userid.
     *
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }


    /**
     * Gets birthdate
     *
     * @return the birthdate
     */
    // LocalDate getBirthdate() {
    //    return birthdate;
    //}

    /**
     * Sets birthdate.
     *
     * @param birthdate the birthdate
     */
    //public void setBirthdate(LocalDate birthdate) {
    //    this.birthdate = birthdate;
    //}


    //public int calculateAge() {
    //   LocalDate now = LocalDate.now();
    //   long age = ChronoUnit.YEARS.between(birthdate, now);

    //    return (int)age;
    //}

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }



}