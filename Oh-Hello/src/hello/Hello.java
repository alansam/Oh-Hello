/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:Hello.java:Oct 15, 2016:3:49:56 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) Hello.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Oct 15, 2016
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello;

import static hello.resources.HelloResources.Table.HELLO_DEFAULT_MESSAGE;

import hello.resources.HelloResources;

/**
 * Greeting
 * 
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class Hello {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  public static final String DEFAULT_MESSAGE;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) Hello $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = Hello.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    DEFAULT_MESSAGE = HelloResources.getString(HELLO_DEFAULT_MESSAGE);
  }

  private String message;

  /**
   * Default constructor
   */
  public Hello() {

    this(DEFAULT_MESSAGE);
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    // TODO Auto-generated constructor stub

    return;
  }

  /**
   * Constructor
   * 
   * @param message
   */
  public Hello(String message) {

    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    setMessage(message);

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
   * Program entry point
   * 
   * @param args
   */
  public static void main(String[] args) {

    @SuppressWarnings("unused")
    String METHOD = ".main()"; //$NON-NLS-1$

    System.out.println(new Hello().getMessage());

    return;
  }
}
