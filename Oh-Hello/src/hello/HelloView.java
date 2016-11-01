/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloView.java:Oct 16, 2016:1:44:22 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) HelloView.java $Header: $
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

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.resources.HelloResources;

/**
 * Viewer
 * 
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public abstract class HelloView {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  private static final String LFMT_000;

  private static final String LFMT_001;

  public static Logger logger;

  static {

    logger = LoggerFactory.getLogger(Hello.class);
    LFMT_000 = HelloResources.getString(HELLO_MSG_LFMT_000);
    LFMT_001 = HelloResources.getString(HELLO_MSG_LFMT_001);

    CLASSNAME = HelloView.class.getSimpleName();
    String METHOD = ".<clinit>"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    ID = "@(#) HelloView $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    logger.trace(LFMT_001, CLASSNAME, METHOD);
  }

  protected enum ViewType {
    CONSOLE, WINDOW;
  }

  /**
   * 
   */
  public HelloView() {

    String METHOD = ".<init>()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    // TODO Auto-generated constructor stub

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /**
   * @param presentation
   */
  public abstract void display(String presentation);

  /**
   * @param presentation
   */
  public abstract void display(List<String> presentation);

  /**
   * @param presentation
   */
  public abstract void display(String[] presentation);

  /**
   * @param iVal
   * @return
   */
  public static boolean isInteger(String iVal) {

    String METHOD = ".isInteger()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    boolean result = false;
    try (Scanner sc = new Scanner(iVal)) {
      result = sc.hasNextInt();
    }
    catch (Exception ex) {
      logger.error(ex.getLocalizedMessage(), ex);
    }

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return result;
  }
}
