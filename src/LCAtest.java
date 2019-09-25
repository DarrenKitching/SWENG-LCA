import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LCAtest {
    @Test
    public void testNull() {
        LCA lca = new LCA();
        assertEquals(lca.findLCA(null, null), null); // Two null inputs
        LCA.Node test = new LCA.Node(5);
        assertEquals(lca.findLCA(null, test), null); // First input null
        assertEquals(lca.findLCA(test, null), null); // Second input null
    }
}
