import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void argsLengthOne() {
    assertFalse(c.compute(2));
  }

  @Test
  public void argsLengthEven() {
    assertFalse(c.compute(2,3));
  }

  @Test
  public void argsContainsZero() {
    boolean flag = true;
    try {
      c.compute(1,2,0); //lenght odd
    }
    catch (Exception e){
      flag = false;
    }
    assertFalse(flag);
  }

  @Test
  public void sumOfArgsIsDivisible() {
    assertTrue(c.compute(1,1,1));
  }

  @Test
  public void sumOfArgsIsNotDivisible() {
    assertFalse(c.compute(2,4,5)); // prime number
  }



}