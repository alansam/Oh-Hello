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

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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

      HelloModel ello = new HelloModel();
      presentation = new ArrayList<>();
      presentation
          .add(String.format(fmt000, lcl.toString(), lcl.getDisplayLanguage(), lcl.getDisplayLanguage(savedDefault)));
      if (lcl.getDisplayCountry().length() > 0) {
        presentation.add(String.format(fmt000, K_SP, lcl.getDisplayCountry(), lcl.getDisplayCountry(savedDefault)));
      }
      if (lcl.getDisplayVariant().length() > 0) {
        presentation.add(String.format(fmt000, K_SP, lcl.getDisplayVariant(), lcl.getDisplayVariant(savedDefault)));
      }

      presentation.add(String.format(fmt001, HelloResources.getString(HELLOCONTROLLER_HDR_000), Hello.CLASSNAME)); // $NON-NLS-1$
      presentation.add(String.format(fmt001, HelloResources.getString(HELLOCONTROLLER_HDR_001), ello.getVersion())); // $NON-NLS-1$
      presentation.add(String.format(fmt001, HelloResources.getString(HELLOCONTROLLER_HDR_002), ello.getMessage())); // $NON-NLS-1$
      presentation.add(K_NS);

      getViewer().display(presentation);
      presentation = null;
    }
    Locale.setDefault(savedDefault);

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
