package edu.matc.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_role", schema = "mydb", catalog = "")
public class UserRole {
    private int userRoleId;
    private User user;
    private String roleName;

    public UserRole() {
    }

    public UserRole(User user, String roleName) {
        this.user = user;
        this.roleName = roleName;
    }

    public UserRole(int userRoleId, User user, String roleName) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.roleName = roleName;
    }

    @Id
    @Column(name = "user_role_id", nullable = false)
    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", referencedColumnName = "username", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 25)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (userRoleId != userRole.userRoleId) return false;
        if (user != null ? !user.equals(userRole.user) : userRole.user != null) return false;
        if (roleName != null ? !roleName.equals(userRole.roleName) : userRole.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userRoleId;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
