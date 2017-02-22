/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloModelTest.java:Feb 21, 2017:5:01:40 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2017, All rights reserved.
 *
 * #(@) HelloModelTest.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Feb 21, 2017
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello.test;

import static hello.resources.HelloResources.Table.HELLO_MSG000;
import static hello.resources.HelloResources.Table.HELLO_VERSION;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hello.HelloModel;
import hello.resources.HelloResources;

/**
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloModelTest {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloModelTest $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloModelTest.class.getSimpleName();
    COPYRIGHT = "\u00A9 Copyright Alan Sampson <alansamps@gmail.com> 2017, All rights reserved."; //$NON-NLS-1$

  }

  private HelloModel helloModel;

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {

    helloModel = new HelloModel();

    return;
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {

    helloModel = null;

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#HelloModel()}.
   */
  @Test
  public void testHelloModel() {

    String expected, actual;

    helloModel = new HelloModel();

    assertNotNull(helloModel);

    expected = HelloResources.getString(HELLO_MSG000);
    actual = helloModel.getMessage();
    assertEquals(expected, actual);

    expected = HelloResources.getString(HELLO_VERSION);
    actual = helloModel.getVersion();
    assertEquals(expected, actual);

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#getMessage()}.
   */
  @Test
  public void testGetMessage() {

    String expected, actual;

    helloModel = new HelloModel();
    assertNotNull(helloModel);

    expected = HelloResources.getString(HELLO_MSG000);
    actual = helloModel.getMessage();
    assertEquals(expected, actual);

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#setMessage(java.lang.String)}.
   */
  @Test
  public void testSetMessage() {

    String expected, actual;

    helloModel = new HelloModel();
    assertNotNull(helloModel);

    expected = "";
    helloModel.setMessage(expected);
    actual = helloModel.getMessage();
    assertEquals(expected, actual);

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#getVersion()}.
   */
  @Test
  public void testGetVersion() {

    String expected, actual;

    helloModel = new HelloModel();
    assertNotNull(helloModel);

    expected = HelloResources.getString(HELLO_VERSION);
    actual = helloModel.getVersion();
    assertEquals(expected, actual);

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#setVersion(java.lang.String)}.
   */
  @Test
  public void testSetVersion() {

    String expected, actual;

    helloModel = new HelloModel();
    assertNotNull(helloModel);

    expected = "";
    helloModel.setMessage(expected);
    actual = helloModel.getMessage();
    assertEquals(expected, actual);

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#toString()}.
   */
  @Test
  public void testToString() {

    //TODO create test case
    assertTrue(true);

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#hashCode()}.
   */
  @Test
  public void testHashCode() {

    //TODO create test case
    assertTrue(true);

    return;
  }

  /**
   * Test method for {@link hello.HelloModel#equals(java.lang.Object)}.
   */
  @Test
  public void testEqualsObject() {

    HelloModel left, right;

    helloModel = new HelloModel();
    assertNotNull(helloModel);

    // identical objects
    left = helloModel;
    right = new HelloModel();
    assertEquals(left, right);
    assertTrue(left.equals(right));

    // change one of the objects
    right.setVersion("");
    assertFalse(left.equals(right));

    // exact same object
    left = helloModel;
    right = left;
    assertTrue(left.equals(right));

    // test against null
    left = helloModel;
    right = null;
    assertFalse(left.equals(right));

    // test against a different type of object
    assertFalse(left.equals(new Object()));

    // test against a null message
    left = new HelloModel();
    right = new HelloModel();
    right.setMessage(null);
    assertFalse(left.equals(right));

    // test against a null version
    left = new HelloModel();
    right = new HelloModel();
    right.setVersion(null);
    assertFalse(left.equals(right));

    // test both messages null
    left = new HelloModel();
    right = new HelloModel();
    left.setMessage(null);
    right.setMessage(null);
    assertTrue(left.equals(right));

    // test both versions null
    left = new HelloModel();
    right = new HelloModel();
    left.setVersion(null);
    right.setVersion(null);
    assertTrue(left.equals(right));

    // test messages differ
    left = new HelloModel();
    right = new HelloModel();
    right.setMessage("");
    assertFalse(left.equals(right));

    // test versions differ
    left = new HelloModel();
    right = new HelloModel();
    right.setVersion("");
    assertFalse(left.equals(right));

    // test the objects
    left = new HelloModel();
    right = new HelloModel();
    assertEquals(left, right);
    assertTrue(left.equals(right));
    assertEquals(left.getMessage(), right.getMessage());
    assertEquals(left.getVersion(), right.getVersion());

    return;
  }
}
