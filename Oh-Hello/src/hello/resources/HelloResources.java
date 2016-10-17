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

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloResources {

  private static final String BUNDLE_NAME;

  private static ResourceBundle RESOURCE_BUNDLE;

  private static Locale currentLocale;

  static {
    BUNDLE_NAME = "hello.resources.hello_resources"; //$NON-NLS-1$
    currentLocale = Locale.getDefault();
    RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  }

  /**
   * 
   */
  private HelloResources() {

    // TODO Auto-generated constructor stub

    return;
  }

  /**
   * @param key
   * @return
   */
  public static String getString(String key) {

    try {
      Locale newLocale = Locale.getDefault();
      if (!currentLocale.equals(currentLocale)) {
        currentLocale = newLocale;
        RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, currentLocale);
      }
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

    public static final String HELLO_MSG000;

    public static final String HELLO_VERSION;

    public static final String HELLO_DEFAULT_LOCALE_DLM;

    public static final String HELLO_DEFAULT_LOCALES;

    public static final String HELLOCONTROLLER_FMT_000;

    public static final String HELLOCONTROLLER_FMT_001;

    public static final String HELLOCONTROLLER_HDR_000;

    public static final String HELLOCONTROLLER_HDR_001;

    public static final String HELLOCONTROLLER_HDR_002;

    static {

      @SuppressWarnings("unused")
      String METHOD = ".<clinit>"; //$NON-NLS-1$

      ID = "@(#) Table $Header: $"; //$NON-NLS-1$
      MAINT = "@(#) INIT"; //$NON-NLS-1$
      CLASSNAME = Table.class.getSimpleName();

      HELLO_DEFAULT_MESSAGE = "Hello.DEFAULT_MESSAGE"; //$NON-NLS-1$
      HELLO_MSG000 = "Hello.MSG000"; //$NON-NLS-1$
      HELLO_VERSION = "Hello.VERSION"; //$NON-NLS-1$
      HELLO_DEFAULT_LOCALE_DLM = "Hello.DEFAULT_LOCALE_DLM"; //$NON-NLS-1$
      HELLO_DEFAULT_LOCALES = "Hello.DEFAULT_LOCALES"; //$NON-NLS-1$

      HELLOCONTROLLER_FMT_000 = "HelloController.FMT_000"; //$NON-NLS-1$
      HELLOCONTROLLER_FMT_001 = "HelloController.FMT_001"; //$NON-NLS-1$
      HELLOCONTROLLER_HDR_000 = "HelloController.HDR_000"; //$NON-NLS-1$
      HELLOCONTROLLER_HDR_001 = "HelloController.HDR_001"; //$NON-NLS-1$
      HELLOCONTROLLER_HDR_002 = "HelloController.HDR_002"; //$NON-NLS-1$
    }
  }
}
