/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloModel.java:Oct 16, 2016:11:15:21 AM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) HelloModel.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Oct 16, 2016
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello;

import static hello.resources.HelloResources.Table.HELLO_MSG000;
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_000;
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_001;
import static hello.resources.HelloResources.Table.HELLO_VERSION;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.resources.HelloResources;

/**
 * Data Model
 * 
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloModel {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  private static final String LFMT_000;

  private static final String LFMT_001;

  public static Logger logger;

  static {

    logger = LoggerFactory.getLogger(HelloModel.class);
    LFMT_000 = HelloResources.getString(HELLO_MSG_LFMT_000);
    LFMT_001 = HelloResources.getString(HELLO_MSG_LFMT_001);

    CLASSNAME = HelloModel.class.getSimpleName();
    String METHOD = ".<clinit>"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    ID = "@(#) HelloModel $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    logger.trace(LFMT_001, CLASSNAME, METHOD);
  }

  private String message;

  private String version;

  /**
   * 
   */
  public HelloModel() {

    String METHOD = ".<init>()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    setMessage(HelloResources.getString(HELLO_MSG000));
    setVersion(HelloResources.getString(HELLO_VERSION));

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /**
   * @return the message
   */
  public String getMessage() {

    return message;
  }

  /**
   * @param message
   *          the message to set
   */
  public void setMessage(String message) {

    this.message = message;

    return;
  }

  /**
   * @return the version
   */
  public String getVersion() {

    return version;
  }

  /**
   * @param version
   *          the version to set
   */
  public void setVersion(String version) {

    this.version = version;

    return;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {

    String to = String.format("HelloModel [message=%s, version=%s]", message, version);

    return to;
  }
}
