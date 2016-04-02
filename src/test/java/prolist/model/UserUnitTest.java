package prolist.model;



import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Yuan-Fang Li
 * @version $Id: $
 */
public class UserUnitTest {
    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRoleCannotBeSetNull() {
        user.setRole(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPasswordCannotBeSetNull() {
        user.setPassword(null);
    }

    @Test
    public void testSameEmailMeansSameUser() {
        user.setEmail("john@example.com");
        User u1 = new User();
        u1.setEmail("john@example.com");

        assertEquals(user, u1);
    }

    //test for checking that role has predefined values.
    @Test(expected = IllegalArgumentException.class)
    public void testRoleWithinRange()
    {user.setRole(User.Role.valueOf("Student"));}

    @Test(expected = IllegalArgumentException.class)
    public void testEmailValid()
    {
        user.setEmail("abc^domain.com");
    }

    @Test
    public void testUpdateProposal()
    {
        user.updateProposalTitle("Hemodialysis");
    }
}