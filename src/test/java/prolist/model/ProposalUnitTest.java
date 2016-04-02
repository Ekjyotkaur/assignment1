package prolist.model;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ekjyo_000 on 21/03/2016.
 */
public class ProposalUnitTest {

    private Proposal prop;

    @Before
    public void setUp() {
        prop = new Proposal();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTitleCannotBeSetNull() {
        prop.setTitle(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSupervisorsCannotBeSetNull() {
        prop.setSupervisors(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChanges() {
        prop.setCohort(Proposal.Cohort.valueOf("Bachelor's"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThesisType()
    {
        prop.setThesisType(Proposal.ThesisType.valueOf("MARKS_6"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExaminerListNotNull()
    {
        prop.setExaminers(null);
    }
}
