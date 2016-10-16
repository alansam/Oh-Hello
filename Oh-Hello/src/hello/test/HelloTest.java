/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloTest.java:Oct 15, 2016:4:39:10 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) HelloTest.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Oct 15, 2016
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello.test;

import static hello.resources.HelloResources.Table.HELLO_DEFAULT_MESSAGE;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hello.Hello;
import hello.resources.HelloResources;

/**
 * Hello Test Case
 * 
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloTest {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloTest $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloTest.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

  }

  private Hello hello;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {

    hello = new Hello();

    return;
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {

    hello = null;

    return;
  }

  /**
   * Test method for {@link hello.Hello#getMessage()}.
   */
  @Test
  public void testGetMessage() {

    String expected;
    String actual;

    hello = new Hello();
    expected = HelloResources.getString(HELLO_DEFAULT_MESSAGE);
    actual = hello.getMessage();
    assertEquals(expected, actual);

    hello = new Hello(HelloResources.getString(HELLO_DEFAULT_MESSAGE));
    expected = HelloResources.getString(HELLO_DEFAULT_MESSAGE);
    actual = hello.getMessage();
    assertEquals(expected, actual);

    return;
  }
}
