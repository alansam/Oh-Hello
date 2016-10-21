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

import static hello.resources.HelloResources.Table.HELLOCONTROLLER_FMT_000;
import static hello.resources.HelloResources.Table.HELLOCONTROLLER_FMT_001;
import static hello.resources.HelloResources.Table.HELLOCONTROLLER_HDR_000;
import static hello.resources.HelloResources.Table.HELLOCONTROLLER_HDR_001;
import static hello.resources.HelloResources.Table.HELLOCONTROLLER_HDR_002;
import static hello.resources.HelloResources.Table.HELLO_DEFAULT_LOCALES;
import static hello.resources.HelloResources.Table.HELLO_DEFAULT_LOCALE_DLM;
import static hello.resources.HelloResources.Table.HELLO_PROPERTY_FILE_NAME;
import static hello.resources.HelloResources.Table.HELLO_PROP_HELLO_VIEW;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import hello.HelloView.ViewType;
import hello.resources.HelloResources;

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

  private static final String K_NS;

  private static final String K_US;

  private static final Object K_SP;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloController $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloController.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    K_NS = ""; //$NON-NLS-1$
    K_SP = " "; //$NON-NLS-1$
    K_US = "_"; //$NON-NLS-1$
  }

  private HelloModel dataModel;

  private HelloView viewer;

  private Properties localProperties;

  /**
   * 
   */
  public HelloController() {
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    String propFile = HelloResources.getString(HELLO_PROPERTY_FILE_NAME);
    localProperties = fetchProperties(propFile);

    return;
  }

  /**
   * @param args
   */
  public void control(String[] args) {

    @SuppressWarnings("unused")
    String METHOD = ".control()"; //$NON-NLS-1$

    setViewer(allocateViewer());

    List<Locale> locales = new ArrayList<>();
    String fmt000 = HelloResources.getString(HELLOCONTROLLER_FMT_000);
    String fmt001 = HelloResources.getString(HELLOCONTROLLER_FMT_001);

    getViewer().display(getDataModel().getMessage());

    List<String> presentation;
    presentation = new ArrayList<>();
    presentation.add(String.format(fmt001, Hello.CLASSNAME, getDataModel().getVersion()));
    presentation.add(K_NS);

    getViewer().display(presentation);
    presentation = null;

    if (args.length <= 0) {
      // Set up default set of locale names
      locales.add(Locale.getDefault());
      String dlm = HelloResources.getString(HELLO_DEFAULT_LOCALE_DLM);
      args = HelloResources.getString(HELLO_DEFAULT_LOCALES).split(dlm); // $NON-NLS-1$
    }

    for (String al : args) {
      String[] localeParts = al.split(K_US);
      switch (localeParts.length) {
      case 1:
        locales.add(new Locale(localeParts[0]));
        break;

      case 2:
        locales.add(new Locale(localeParts[0], localeParts[1]));
        break;

      case 3:
      default:
        locales.add(new Locale(localeParts[0], localeParts[1], localeParts[2]));
        break;
      }
    }

    Locale savedDefault = Locale.getDefault();
    for (Locale lcl : locales) {
      Locale.setDefault(lcl);

      String lclName = lcl.toString();
      //@formatter:off
      String[] dl = { lcl.getDisplayLanguage(), lcl.getDisplayLanguage(savedDefault), };
      String[] dc = { lcl.getDisplayCountry(), lcl.getDisplayCountry(savedDefault), };
      String[] dv = { lcl.getDisplayVariant(), lcl.getDisplayVariant(savedDefault), };
      //@formatter:on
      HelloModel ello = new HelloModel();
      presentation = new ArrayList<>();
      presentation.add(String.format(fmt000, lclName, dl[0], dl[1]));
      if (lcl.getDisplayCountry().length() > 0) {
        presentation.add(String.format(fmt000, K_SP, dc[0], dc[1]));
      }
      if (lcl.getDisplayVariant().length() > 0) {
        presentation.add(String.format(fmt000, K_SP, dv[0], dv[1]));
      }

      String klass = HelloResources.getString(HELLOCONTROLLER_HDR_000);
      String versn = HelloResources.getString(HELLOCONTROLLER_HDR_001);
      String txmsg = HelloResources.getString(HELLOCONTROLLER_HDR_002);
      presentation.add(String.format(fmt001, klass, Hello.CLASSNAME)); // $NON-NLS-1$
      presentation.add(String.format(fmt001, versn, ello.getVersion())); // $NON-NLS-1$
      presentation.add(String.format(fmt001, txmsg, ello.getMessage())); // $NON-NLS-1$
      presentation.add(K_NS);

      getViewer().display(presentation);
      presentation = null;
    }
    Locale.setDefault(savedDefault);

    return;
  }

  /**
   * @return
   */
  private HelloView allocateViewer() {

    @SuppressWarnings("unused")
    String METHOD = ".allocateViewer()"; //$NON-NLS-1$

    HelloView newView;
    newView = null;

    String propViewKey = HelloResources.getString(HELLO_PROP_HELLO_VIEW);
    String propViewVal;
    String propViewValDflt = HelloView.ViewType.CONSOLE.toString();
    propViewVal = localProperties.getProperty(propViewKey);
    propViewVal = propViewVal != null ? propViewVal : System.getProperty(propViewKey, propViewValDflt);

    ViewType vType;
    try {
      vType = ViewType.valueOf(propViewVal.toUpperCase());
    }
    catch (IllegalArgumentException | NullPointerException ex) {
      vType = ViewType.CONSOLE;
    }

    switch (vType) {
    case WINDOW:
      newView = new HelloViewWindow();
      break;

    case CONSOLE:
    default:
      newView = new HelloViewConsole();
      break;
    }

    return newView;
  }

  /**
   * @param propFile
   * @return
   */
  private Properties fetchProperties(String propFile) {

    @SuppressWarnings("unused")
    String METHOD = ".fetchProperties()"; //$NON-NLS-1$

    Properties props;
    
    try (InputStream propStrm = new FileInputStream(new File(propFile))) {
      props = new Properties();
      props.load(propStrm);
    }
    catch (IOException ex) {
      props = new Properties(); // on error, flush any properties that did get loaded
    }

    return props;
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
