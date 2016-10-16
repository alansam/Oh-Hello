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

import java.util.List;

/**
 * Viewer
 * 
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot; &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public abstract class HelloView {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloView $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloView.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

  }

  /**
   * 
   */
  public HelloView() {
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    // TODO Auto-generated constructor stub

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
}
