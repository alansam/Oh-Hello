/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloViewConsole.java:Oct 16, 2016:1:56:22 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) HelloViewConsole.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Oct 16, 2016
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;

/**
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloViewConsole extends HelloView {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloViewConsole $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloViewConsole.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

  }

  /**
   * 
   */
  public HelloViewConsole() {
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    // TODO Auto-generated constructor stub

    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String)
   */
  @Override
  public void display(String presentation) {

    @SuppressWarnings("unused")
    String METHOD = ".display()"; //$NON-NLS-1$

    out.println(presentation);

    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.util.List)
   */
  @Override
  public void display(List<String> presentation) {

    @SuppressWarnings("unused")
    String METHOD = ".display()"; //$NON-NLS-1$

    for (String pres : presentation) {
      out.println(pres);
    }

    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String[])
   */
  @Override
  public void display(String[] presentation) {

    @SuppressWarnings("unused")
    String METHOD = ".display()"; //$NON-NLS-1$

    display(Arrays.asList(presentation));

    return;
  }
}
