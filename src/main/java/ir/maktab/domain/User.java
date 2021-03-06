package ir.maktab.domain;

import ir.maktab.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
public class User extends BaseEntity<Integer> {

    public static final String TABLE_NAME = "users";


    private String username;
    private String password;
    private String nationalCode;
    private LocalDate birthday;
    @Column(columnDefinition = "TINYINT(1)")
    private Boolean status;
    @OneToMany(mappedBy = "user")
    private Set<Activity> activities;

    public User() {
    }

    public User(String username, String password, String nationalCode, LocalDate birthday, Boolean status) {
        this.username = username;
        this.password = password;
        this.nationalCode = nationalCode;
        this.birthday = birthday;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User[" +
                "id= " + getId() +
                ", userName='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                ", birthday=" + birthday +
                ", status=" + status +
                ']';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
