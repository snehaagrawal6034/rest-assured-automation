package stepDefinition;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArbitJunit {
    private int var = 1;
    @Before
    public void setup() {
        System.out.println(hashCode());
    }

    @Test
    public void testAdd1() {
        var = var + 1;
        Assert.assertEquals(2, var);
    }

    @Test
    public void testAdd2() {
        var = var + 1;
        Assert.assertEquals(2, var);
    }

    @After
    public void tearDown() {
        System.out.println(hashCode());
    }
}
