package prolist.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yli on 23/02/2016.
 */

public class User extends SeriablizableEntity {
    public enum Role {
        ADMINISTRATOR, ACADEMIC;
    }

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phone;

    private Role role;

    private Proposal proposal;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, Role role, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.phone = phone;
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

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches())
            this.email = email;
        else
            throw new IllegalArgumentException("Invalid Email Address");
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (null == role) {
            throw new IllegalArgumentException("Role cannot be null.");
        }

        if(!role.equals("ADMINISTRATOR")||!role.equals("ACADEMIC"))
            throw new IllegalArgumentException("Invalid Role");
        this.role = role;
    }

    public void setPassword(String password) {
        if (null == password) {
            throw new IllegalArgumentException("Password cannot be null.");
        } else if (password.trim().equals("")) {
            throw new IllegalArgumentException("Password cannot be empty.");
        }
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return 31 * email.hashCode();
    }

    public void updateProposalTitle(String title)
    {
        proposal = new Proposal();
        proposal.setTitle(title);
    }
}
