/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloResources.java:Oct 15, 2016:5:11:55 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) HelloResources.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Oct 15, 2016
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello.resources;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloResources {

  private static final String BUNDLE_NAME = "hello.resources.hello_resources"; //$NON-NLS-1$

  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

  private HelloResources() {
  }

  public static String getString(String key) {

    try {
      return RESOURCE_BUNDLE.getString(key);
    }
    catch (MissingResourceException ex) {
      return '!' + key + '!';
    }
  }

  public static class Table {

    public static final String ID;

    public static final String MAINT;

    public static final String CLASSNAME;

    public static final String HELLO_DEFAULT_MESSAGE;

    static {

      @SuppressWarnings("unused")
      String METHOD = ".<clinit>"; //$NON-NLS-1$

      ID = "@(#) Table $Header: $"; //$NON-NLS-1$
      MAINT = "@(#) INIT"; //$NON-NLS-1$
      CLASSNAME = Table.class.getSimpleName();

      HELLO_DEFAULT_MESSAGE = "Hello.DEFAULT_MESSAGE"; //$NON-NLS-1$
    }
  }
}
