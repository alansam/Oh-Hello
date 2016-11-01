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

import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_000;
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_001;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.resources.HelloResources;

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

  private static final String LFMT_000;

  private static final String LFMT_001;

  public static Logger logger;

  static {

    logger = LoggerFactory.getLogger(HelloViewConsole.class);
    LFMT_000 = HelloResources.getString(HELLO_MSG_LFMT_000);
    LFMT_001 = HelloResources.getString(HELLO_MSG_LFMT_001);

    CLASSNAME = HelloViewConsole.class.getSimpleName();
    String METHOD = ".<clinit>"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    ID = "@(#) HelloViewConsole $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    logger.trace(LFMT_001, CLASSNAME, METHOD);
  }

  /**
   * 
   */
  public HelloViewConsole() {

    String METHOD = ".<init>()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    // TODO Auto-generated constructor stub

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String)
   */
  @Override
  public void display(String presentation) {

    String METHOD = ".display()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    out.println(presentation);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.util.List)
   */
  @Override
  public void display(List<String> presentation) {

    String METHOD = ".display()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    for (String pres : presentation) {
      out.println(pres);
    }

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String[])
   */
  @Override
  public void display(String[] presentation) {

    String METHOD = ".display()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    display(Arrays.asList(presentation));

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }
}
