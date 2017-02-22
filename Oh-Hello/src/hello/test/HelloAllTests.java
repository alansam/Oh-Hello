/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloAllTests.java:Feb 21, 2017:5:09:47 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2017, All rights reserved.
 *
 * #(@) HelloAllTests.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Feb 21, 2017
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
@RunWith(Suite.class)
@SuiteClasses({
    HelloTest.class, HelloModelTest.class
})
public class HelloAllTests {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloAllTests $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloAllTests.class.getSimpleName();
    COPYRIGHT = "\u00A9 Copyright Alan Sampson <alansamps@gmail.com> 2017, All rights reserved."; //$NON-NLS-1$

  }
}
