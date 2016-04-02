package prolist.model;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ekjyo_000 on 21/03/2016.
 */
public class AuditLogUnitTest {
    private AuditLog audit;

    @Before
    public void setUp() {
        audit = new AuditLog();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChanges() {
        audit.setTypeOfChange(AuditLog.Changes.valueOf("update"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testProposalIdCannotBeNull()
    {
        audit.setProposalId(null);
    }
}
