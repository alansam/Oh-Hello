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
      if (!currentLocale.equals(newLocale)) {
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

    public static final String HELLO_MSG_LFMT_000;

    public static final String HELLO_MSG_LFMT_001;

    public static final String HELLO_MSG_LFMT_002;

    public static final String HELLO_MSG_LFMT_200;

    public static final String HELLO_DFMT_001;

    public static final String HELLO_DFMT_002;

    public static final String HELLO_DFMT_003;

    public static final String HELLO_DEFAULT_MESSAGE;

    public static final String HELLO_MSG000;

    public static final String HELLO_PROPERTY_FILE_NAME;

    public static final String HELLO_PROP_HELLO_VIEW;

    public static final String HELLO_PROP_LANGTAG;

    public static final String HELLO_VERSION;

    public static final String HELLO_DEFAULT_LOCALE_DLM;

    public static final String HELLO_DEFAULT_LOCALES;

    public static final String HELLOCONTROLLER_FMT_000;

    public static final String HELLOCONTROLLER_FMT_001;

    public static final String HELLOCONTROLLER_HDR_000;

    public static final String HELLOCONTROLLER_HDR_001;

    public static final String HELLOCONTROLLER_HDR_002;

    public static final String HELLO_PROP_LINE_SEPARATOR;

    public static final String HELLOVIEW_W_OUTPUT_MESSAGE;

    public static final String HELLOVIEW_W_START_WIDTH;

    public static final String HELLOVIEW_W_START_HEIGHT;

    public static final String HELLOVIEW_W_FONT_SIZE;

    public static final String HELLOVIEW_W_ABOUT;

    public static final String HELLOVIEW_W_CLOSE;

    public static final String HELLOVIEW_W_CLOSE_MSG;

    public static final String HELLOVIEW_W_EXIT;

    public static final String HELLOVIEW_W_FILE;

    public static final String HELLOVIEW_W_HELP;

    public static final String HELLOVIEW_W_SAVE_AS;

    static {

      @SuppressWarnings("unused")
      String METHOD = ".<clinit>"; //$NON-NLS-1$

      ID = "@(#) Table $Header: $"; //$NON-NLS-1$
      MAINT = "@(#) INIT"; //$NON-NLS-1$
      CLASSNAME = Table.class.getSimpleName();

      HELLO_MSG_LFMT_000 = "Hello.MSG_LFMT_000"; //$NON-NLS-1$
      HELLO_MSG_LFMT_001 = "Hello.MSG_LFMT_001"; //$NON-NLS-1$
      HELLO_MSG_LFMT_002 = "Hello.MSG_LFMT_002"; //$NON-NLS-1$

      HELLO_MSG_LFMT_200 = "Hello.MSG_LFMT_200"; //$NON-NLS-1$

      HELLO_DFMT_001 = "Hello.DFMT_001"; //$NON-NLS-1$
      HELLO_DFMT_002 = "Hello.DFMT_002"; //$NON-NLS-1$
      HELLO_DFMT_003 = "Hello.DFMT_003"; //$NON-NLS-1$

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

      HELLO_PROPERTY_FILE_NAME = "Hello.PROPERTY_FILE_NAME"; //$NON-NLS-1$
      HELLO_PROP_HELLO_VIEW = "Hello.PROP_HELLO_VIEW"; //$NON-NLS-1$
      HELLO_PROP_LINE_SEPARATOR = "Hello.PROP_LINE_SEPARATOR"; //$NON-NLS-1$
      HELLO_PROP_LANGTAG = "Hello.PROP_LANGTAG"; //$NON-NLS-1$

      HELLOVIEW_W_OUTPUT_MESSAGE = "HelloView.W_OUTPUT_MESSAGE"; //$NON-NLS-1$
      HELLOVIEW_W_START_WIDTH = "HelloView.W_START_WIDTH"; //$NON-NLS-1$
      HELLOVIEW_W_START_HEIGHT = "HelloView.W_START_HEIGHT"; //$NON-NLS-1$
      HELLOVIEW_W_FONT_SIZE = "HelloView.W_FONT_SIZE"; //$NON-NLS-1$

      HELLOVIEW_W_ABOUT = "HelloView.W_ABOUT"; //$NON-NLS-1$
      HELLOVIEW_W_CLOSE = "HelloView.W_CLOSE"; //$NON-NLS-1$
      HELLOVIEW_W_CLOSE_MSG = "HelloView.W_CLOSE_MSG"; //$NON-NLS-1$
      HELLOVIEW_W_EXIT = "HelloView.W_EXIT"; //$NON-NLS-1$
      HELLOVIEW_W_FILE = "HelloView.W_FILE"; //$NON-NLS-1$
      HELLOVIEW_W_HELP = "HelloView.W_HELP"; //$NON-NLS-1$
      HELLOVIEW_W_SAVE_AS = "HelloView.W_SAVE_AS"; //$NON-NLS-1$

    }
  }
}
