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
import static hello.resources.HelloResources.Table.HELLO_VERSION;

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

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloModel $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloModel.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

  }

  private String message;

  private String version;

  /**
   * 
   */
  public HelloModel() {
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    setMessage(HelloResources.getString(HELLO_MSG000));
    setVersion(HelloResources.getString(HELLO_VERSION));

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
}
