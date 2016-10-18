/*
 * -----------------------------------------------------------------------------
 * Oh-Hello:HelloViewWindow.java:Oct 17, 2016:4:55:42 PM
 *
 * (C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved.
 *
 * #(@) HelloViewWindow.java $Header: $
 *
 * -----------------------------------------------------------------------------
 *
 * Created: Oct 17, 2016
 *
 * -+----1----+----2----+----3----+----4----+----5----+----6----+----7----+----8
 */

package hello;

import static hello.resources.HelloResources.Table.HELLOVIEW_W_FONT_SIZE;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_OUTPUT_MESSAGE;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_START_HEIGHT;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_START_WIDTH;
import static hello.resources.HelloResources.Table.HELLO_PROP_LINE_SEPARATOR;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import hello.resources.HelloResources;

/**
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloViewWindow extends HelloView {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  private static final String W_BORDER_TITLE;

  private static final int W_FONT_SIZE;

  private static final int W_START_HEIGHT;

  private static final int W_START_WIDTH;

  private static final String NL;

  static {

    @SuppressWarnings("unused")
    String METHOD = ".<clinit>"; //$NON-NLS-1$

    ID = "@(#) HelloViewWindow $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    CLASSNAME = HelloViewWindow.class.getSimpleName();
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    NL = System.getProperty(HelloResources.getString(HELLO_PROP_LINE_SEPARATOR)); // $NON-NLS-1$
    W_BORDER_TITLE = HelloResources.getString(HELLOVIEW_W_OUTPUT_MESSAGE); // $NON-NLS-1$

    String iVal;
    iVal = HelloResources.getString(HELLOVIEW_W_START_WIDTH); // $NON-NLS-1$
    W_START_WIDTH = HelloView.isInteger(iVal) ? Integer.valueOf(iVal) : 1200;

    iVal = HelloResources.getString(HELLOVIEW_W_START_HEIGHT); // $NON-NLS-1$
    W_START_HEIGHT = HelloView.isInteger(iVal) ? Integer.valueOf(iVal) : 800;

    iVal = HelloResources.getString(HELLOVIEW_W_FONT_SIZE); // $NON-NLS-1$
    W_FONT_SIZE = HelloView.isInteger(iVal) ? Integer.valueOf(iVal) : 12;
  }

  private String windowTitle;

  private JFrame window;

  private Container contents;

  private JTextArea textArea;

  private JScrollPane scrollArea;

  /**
   * Default constructor
   * 
   * @throws HeadlessException
   */
  public HelloViewWindow() throws HeadlessException {

    this(W_BORDER_TITLE);
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    return;
  }

  /**
   * Parameterized constructor
   * 
   * @param wBorderTitle
   * @throws HeadlessException
   */
  public HelloViewWindow(String wBorderTitle) throws HeadlessException {
    @SuppressWarnings("unused")
    String METHOD = ".<init>()"; //$NON-NLS-1$

    windowTitle = wBorderTitle;
    createWindow();

    return;
  }

  /**
   * @throws HeadlessException
   */
  private void createWindow() throws HeadlessException {

    @SuppressWarnings("unused")
    String METHOD = ".createWindow()"; //$NON-NLS-1$

    window = new JFrame(windowTitle);
    contents = window.getContentPane();
    textArea = new JTextArea();
    scrollArea = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollArea.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(W_BORDER_TITLE),
        BorderFactory.createEtchedBorder(EtchedBorder.RAISED)));
    textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, W_FONT_SIZE));
    window.addWindowListener(new WindowAdapter() {

      /*
       * (non-Javadoc)
       * 
       * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
       */
      @Override
      public void windowClosing(WindowEvent evt) {

        @SuppressWarnings("unused")
        String METHOD = ".windowClosing()"; //$NON-NLS-1$

        window.dispose();

        return;
      }
    });
    contents.add(scrollArea, BorderLayout.CENTER);
    window.setResizable(true);
    window.pack();
    window.setSize(W_START_WIDTH, W_START_HEIGHT);
    window.setVisible(true);

    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String)
   */
  @Override
  public void display(String line) {

    @SuppressWarnings("unused")
    String METHOD = ".display()"; //$NON-NLS-1$

    textArea.append(line);
    textArea.append(NL);

    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.util.List)
   */
  @Override
  public void display(List<String> presentation) {

    @SuppressWarnings("unused")
    String METHOD = ".display()"; //$NON-NLS-1$

    for (String line : presentation) {
      textArea.append(line);
      textArea.append(NL);
    }

    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String[])
   */
  @Override
  public void display(String[] presentation) {

    @SuppressWarnings("unused")
    String METHOD = ".display()"; //$NON-NLS-1$

    display(Arrays.asList(presentation));

    return;
  }
}
