/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloController.java:Oct 16, 2016:11:31:40 AM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) HelloController.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Oct 16, 2016
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello;

import java.util.Arrays;
import java.util.List;

/**
 * Application controller
 * 
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloController {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloController $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloController.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

  }

  private HelloModel dataModel;

  private HelloView viewer;

  /**
   * 
   */
  public HelloController() {
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    // TODO Auto-generated constructor stub

    return;
  }

  /**
   * @param args
   */
  public void control(String[] args) {

    @SuppressWarnings("unused")
    String METHOD = ".control()"; //$NON-NLS-1$

    //@formatter:off
    getViewer().display(getDataModel().getMessage());
    String[] messageArray = { "Hello, Hello", };
    List<String> messageList = Arrays.asList(new String[] { "Hello, Hello, Hello", });
    //@formatter:on
    getViewer().display(messageArray);
    getViewer().display(messageList);

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
}
