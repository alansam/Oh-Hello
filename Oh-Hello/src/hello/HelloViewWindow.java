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

import static hello.resources.HelloResources.Table.HELLOVIEW_W_ABOUT;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_CLOSE;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_CLOSE_MSG;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_EXIT;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_FILE;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_FONT_SIZE;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_HELP;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_OUTPUT_MESSAGE;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_SAVE_AS;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_START_HEIGHT;
import static hello.resources.HelloResources.Table.HELLOVIEW_W_START_WIDTH;
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_000;
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_001;
import static hello.resources.HelloResources.Table.HELLO_MSG_LFMT_002;
import static hello.resources.HelloResources.Table.HELLO_PROP_LINE_SEPARATOR;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hello.resources.HelloResources;

/**
 * @author alansampson : <a href="mailto:%22Alan%20Sampson%22%20%3Calansamps@gmail.com%3E">&quot;Alan Sampson&quot;
 *         &lt;alansamps@gmail.com&gt;</a>
 * @version 0.1
 *
 */
public class HelloViewWindow extends HelloView implements Runnable {

  public static final String ID;

  public static final String MAINT;

  public static final String CLASSNAME;

  public static final String COPYRIGHT;

  private static final String W_BORDER_TITLE;

  private static final int W_FONT_SIZE;

  private static final int W_START_HEIGHT;

  private static final int W_START_WIDTH;

  protected static final String W_ABOUT;

  protected static final String W_CLOSE;

  protected static final String W_CLOSE_MSG;

  protected static final String W_EXIT;

  protected static final String W_FILE;

  protected static final String W_HELP;

  protected static final String W_SAVE_AS;

  private static final String NL;

  private static final String LFMT_000;

  private static final String LFMT_001;

  private static final String LFMT_002;

  public static Logger logger;

  static {

    logger = LoggerFactory.getLogger(HelloViewWindow.class);
    LFMT_000 = HelloResources.getString(HELLO_MSG_LFMT_000);
    LFMT_001 = HelloResources.getString(HELLO_MSG_LFMT_001);
    LFMT_002 = HelloResources.getString(HELLO_MSG_LFMT_002);

    CLASSNAME = HelloViewWindow.class.getSimpleName();
    String METHOD = ".<clinit>"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    ID = "@(#) HelloViewWindow $Header: $"; //$NON-NLS-1$
    MAINT = "@(#) INIT"; //$NON-NLS-1$
    COPYRIGHT = "(C) Copyright Alan Sampson <alansamps@gmail.com> 2016, All rights reserved."; //$NON-NLS-1$

    NL = System.getProperty(HelloResources.getString(HELLO_PROP_LINE_SEPARATOR));
    W_BORDER_TITLE = HelloResources.getString(HELLOVIEW_W_OUTPUT_MESSAGE);

    String iVal;
    iVal = HelloResources.getString(HELLOVIEW_W_START_WIDTH);
    W_START_WIDTH = HelloView.isInteger(iVal) ? Integer.valueOf(iVal) : 1200;

    iVal = HelloResources.getString(HELLOVIEW_W_START_HEIGHT);
    W_START_HEIGHT = HelloView.isInteger(iVal) ? Integer.valueOf(iVal) : 800;

    iVal = HelloResources.getString(HELLOVIEW_W_FONT_SIZE);
    W_FONT_SIZE = HelloView.isInteger(iVal) ? Integer.valueOf(iVal) : 12;

    W_ABOUT = HelloResources.getString(HELLOVIEW_W_ABOUT);
    W_CLOSE = HelloResources.getString(HELLOVIEW_W_CLOSE);
    W_CLOSE_MSG = HelloResources.getString(HELLOVIEW_W_CLOSE_MSG);
    W_EXIT = HelloResources.getString(HELLOVIEW_W_EXIT);
    W_FILE = HelloResources.getString(HELLOVIEW_W_FILE);
    W_HELP = HelloResources.getString(HELLOVIEW_W_HELP);
    W_SAVE_AS = HelloResources.getString(HELLOVIEW_W_SAVE_AS);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
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
    String METHOD = ".<init>()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    // TODO Auto-generated constructor stub

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /**
   * Parameterized constructor
   * 
   * @param wBorderTitle
   * @throws HeadlessException
   */
  public HelloViewWindow(String wBorderTitle) throws HeadlessException {

    String METHOD = ".<init>()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    windowTitle = wBorderTitle;
    // Schedule a job for the event-dispatching thread: creating and showing this application's GUI.
    SwingUtilities.invokeLater(this);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /**
   * @throws HeadlessException
   */
  private void createWindow() throws HeadlessException {

    String METHOD = ".createWindow()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

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

        String METHOD = ".windowClosing()"; //$NON-NLS-1$
        logger.trace(LFMT_000, CLASSNAME, METHOD);

        window.dispose();

        logger.trace(LFMT_001, CLASSNAME, METHOD);
        return;
      }
    });

    JMenuBar mb = createMenuBar();
    contents.add(mb, BorderLayout.NORTH);

    contents.add(scrollArea, BorderLayout.CENTER);

    window.setResizable(true);
    window.pack();
    window.setSize(W_START_WIDTH, W_START_HEIGHT);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /**
   * @return
   */
  private JMenuBar createMenuBar() {

    String METHOD = ".createMenuBar()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    JMenuBar menuBar;
    JMenu menuFile;
    JMenu menuHelp;
    JMenuItem menuItem;

    menuBar = new JMenuBar();

    menuFile = new JMenu(W_FILE);
    menuFile.setMnemonic(KeyEvent.VK_F);
    menuItem = new JMenuItem(W_SAVE_AS, KeyEvent.VK_S);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.META_MASK));
    menuItem.setEnabled(false); // TODO: build a save dialogue
    menuFile.add(menuItem);
    menuItem = new JMenuItem(W_EXIT, KeyEvent.VK_X);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.META_MASK));
    menuItem.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent evt) {

        String METHOD = ".actionPerformed()"; //$NON-NLS-1$
        logger.trace(LFMT_000, CLASSNAME, METHOD);

        if (evt.getActionCommand().equalsIgnoreCase(W_EXIT)) {
          int ynDialog;
          ynDialog = JOptionPane.showConfirmDialog(window, W_CLOSE_MSG, W_CLOSE, JOptionPane.YES_NO_OPTION);

          switch (ynDialog) {
          case JOptionPane.YES_OPTION:
            window.dispose();
            Integer exitCode = new Integer(0);
            logger.trace(LFMT_002, CLASSNAME, METHOD, exitCode);
            System.exit(exitCode);
            break;

          case JOptionPane.NO_OPTION:
          default:
            break;
          }
        }

        logger.trace(LFMT_001, CLASSNAME, METHOD);
        return;
      }
    });
    menuFile.add(menuItem);

    menuHelp = new JMenu(W_HELP);
    menuHelp.setMnemonic(KeyEvent.VK_H);
    menuItem = new JMenuItem(W_ABOUT);
    menuItem.setEnabled(false); // TODO: build an "about" dialogue
    menuHelp.add(menuItem);

    menuBar.add(menuFile);
    menuBar.add(menuHelp);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return menuBar;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String)
   */
  @Override
  public void display(String line) {

    String METHOD = ".display()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    List<String> presentation;
    presentation = new ArrayList<>();
    presentation.add(line);
    display(presentation);

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.util.List)
   */
  @Override
  public void display(List<String> presentation) {

    String METHOD = ".display()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    try {
      // Schedule a job for the event-dispatching thread to update GUI elements.
      SwingUtilities.invokeAndWait(new Runnable() {

        @Override
        public void run() {

          String METHOD = ".run()"; //$NON-NLS-1$
          logger.trace(LFMT_000, CLASSNAME, METHOD);

          presentation.forEach(line -> {
            textArea.append(line);
            textArea.append(NL);
          });

          logger.trace(LFMT_001, CLASSNAME, METHOD);
          return;
        }
      });
    }
    catch (InvocationTargetException | InterruptedException ex) {
      logger.error(ex.getLocalizedMessage(), ex);
    }

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see hello.HelloView#display(java.lang.String[])
   */
  @Override
  public void display(String[] presentation) {

    String METHOD = ".display()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    display(Arrays.asList(presentation));

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Runnable#run()
   */
  @Override
  public void run() {

    String METHOD = ".run()"; //$NON-NLS-1$
    logger.trace(LFMT_000, CLASSNAME, METHOD);

    createWindow();

    logger.trace(LFMT_001, CLASSNAME, METHOD);
    return;
  }
}
