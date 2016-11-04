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
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_000;
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_001;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

  private static final String LFMT_000;

  private static final String LFMT_001;

  public static Logger logger;

  static {

    logger = LoggerFactory.getLogger(Hello.class);
    LFMT_000 = HelloResources.getString(HELLO_MSG_LFMT_000);
    LFMT_001 = HelloResources.getString(HELLO_MSG_LFMT_001);

    CLASSNAME = Hello.class.getSimpleName();
    String METHOD = ".<clinit>"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    ID = "@(#) Hello $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    DEFAULT_MESSAGE = HelloResources.getString(HELLO_DEFAULT_MESSAGE);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
  }

  private HelloModel dataModel;

  private HelloController controller;

  private HelloView viewer;

  /**
   * Default constructor
   */
  public Hello() {

    this(DEFAULT_MESSAGE);
    String METHOD = ".<init>()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    // TODO Auto-generated constructor stub

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /**
   * Constructor
   * 
   * @param message
   */
  public Hello(String message) {

    String METHOD = ".<init>()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    setController(new HelloController()); // Create the controller
    setDataModel(new HelloModel()); // Create the data model
    setViewer(new HelloViewConsole()); // Create a default viewer
    getDataModel().setMessage(message); // pass default message to data model

    // Pass viewer and data model to controller
    getController().setViewer(getViewer());
    getController().setDataModel(getDataModel());

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /**
   * @return the dataModel
   */
  public HelloModel getDataModel() {

    return dataModel;
  }

  /**
   * @param dataModel
   *          the dataModel to set
   */
  public void setDataModel(HelloModel dataModel) {

    this.dataModel = dataModel;

    return;
  }

  /**
   * @return the controller
   */
  public HelloController getController() {

    return controller;
  }

  /**
   * @param controller
   *          the controller to set
   */
  public void setController(HelloController controller) {

    this.controller = controller;

    return;
  }

  /**
   * @return the viewer
   */
  public HelloView getViewer() {

    return viewer;
  }

  /**
   * @param viewer
   *          the viewer to set
   */
  public void setViewer(HelloView viewer) {

    this.viewer = viewer;

    return;
  }

  /**
   * Program entry point
   * 
   * @param args
   */
  public static void main(String[] args) {

    String METHOD = ".main()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    Hello me = new Hello();
    if (logger.isDebugEnabled()) {
      for (String arg : args) {
        logger.debug(arg);
      }
    }
    me.getController().control(args);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }
}
