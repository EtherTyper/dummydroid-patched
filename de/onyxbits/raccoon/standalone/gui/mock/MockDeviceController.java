package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.net.ClientFactory;
import de.onyxbits.raccoon.standalone.base.ModuleProvider;
import de.onyxbits.raccoon.standalone.gui.AppAction;
import de.onyxbits.raccoon.standalone.gui.DeskPane;
import de.onyxbits.raccoon.standalone.gui.EditMenu;
import de.onyxbits.raccoon.standalone.gui.FileMenu;
import de.onyxbits.raccoon.standalone.gui.Focus;
import de.onyxbits.raccoon.standalone.gui.IdleState;
import de.onyxbits.raccoon.standalone.gui.MnemonicContext;
import de.onyxbits.raccoon.standalone.gui.PrimaryWindowController;
import de.onyxbits.raccoon.standalone.gui.Scheduler;
import de.onyxbits.raccoon.standalone.gui.ShutdownAction;
import de.onyxbits.raccoon.standalone.gui.Spinner;
import de.onyxbits.raccoon.standalone.gui.ViewMenu;
import de.onyxbits.raccoon.standalone.gui.WindowBorder;
import de.onyxbits.raccoon.standalone.gui.bridge.DirectoryManager;
import de.onyxbits.raccoon.standalone.gui.unlock.Shop;
import de.onyxbits.raccoon.standalone.gui.unlock.UnlockAction;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.TitledBorder;
import org.apache.http.client.HttpClient;

class MockDeviceController extends PrimaryWindowController implements ActionListener, FocusListener {
   private static final String ID = MockDeviceController.class.getSimpleName();
   private static final Insets MARGIN = new Insets(2, 2, 2, 2);
   private static final int IDLE = 0;
   private static final int REGISTER = 1;
   private static final int LOGIN = 2;
   private static final int DOWNLOAD = 3;
   private JTextField manufacturer;
   private JTextField brand;
   private JTextField device;
   private JTextField hardware;
   private JTextField product;
   private JTextField model;
   private JTextField id;
   private JTextField fingerprint;
   private JTextField releaseVersion;
   private JTextField bootloader;
   private JSpinner sdk;
   private JSpinner glEs;
   private JTextField time;
   private JTextArea abi;
   private JTextArea logText;
   private JTextArea glExstensions;
   private JTable software;
   private JSpinner width;
   private JSpinner height;
   private JSpinner density;
   private JSpinner layout;
   private JTextArea features;
   private JTextArea libraries;
   private JTextArea locales;
   private JComboBox touchscreen;
   private JComboBox keyboard;
   private JComboBox navigation;
   private ShutdownAction shutdownAction;
   private SaveAsAction saveAsAction;
   private SaveAction saveAction;
   private OpenAction openAction;
   private NewAction newAction;
   private ProbeDeviceAction probeDeviceAction;
   private SubmitAction submitAction;
   private UserAgentAction userAgentAction;
   private UnlockAction unlockAction;
   private GsfIdAction gsfIdAction;
   private AuthAction authAction;
   private CarrierAction carrierAction;
   private CopyAction copyAction;
   private PasteAction pasteAction;
   private JTextField username;
   private JPasswordField password;
   private JCheckBox ota;
   private JTextField proxyUrl;
   private JCheckBox registerGsf;
   private JCheckBox login;
   private JCheckBox downloadApp;
   private JTextField testApp;
   PawnModel pawn;
   private IdleState idleState = new IdleState(true);
   private int state;
   private ClientFactory clientFactory;
   private String lastProxy;
   private Spinner spinner;

   public MockDeviceController(ModuleProvider provider) {
      super(provider);
      MutableDevice mutableDevice = new MutableDevice();
      this.pawn = new PawnModel();
      this.pawn.setTimezone(TimeZone.getDefault());
      this.pawn.setLocale(Locale.getDefault());
      this.pawn.setDevice(mutableDevice);
      this.shutdownAction = new ShutdownAction(provider);
      this.saveAsAction = new SaveAsAction(provider, this.pawn);
      this.saveAction = new SaveAction(provider, this.pawn);
      this.unlockAction = new UnlockAction(provider, Messages.t(ID + ".trial.title"), Messages.t(ID + ".trial.message"));
      this.newAction = new NewAction(provider, this.pawn);
      this.openAction = new OpenAction(provider, this.pawn);
      this.copyAction = new CopyAction(this.pawn);
      this.pasteAction = new PasteAction(this.pawn);
      this.probeDeviceAction = new ProbeDeviceAction(provider, mutableDevice, this.idleState);
      this.submitAction = new SubmitAction(provider);
      this.userAgentAction = new UserAgentAction(provider, mutableDevice);
      this.gsfIdAction = new GsfIdAction(provider, this.pawn);
      this.authAction = new AuthAction(provider, this.pawn);
      this.carrierAction = new CarrierAction(provider, this.pawn);
      this.username = new JTextField(this.pawn.uid, "", 25);
      this.password = new JPasswordField(this.pawn.pwd, "", 25);
      this.logText = new JTextArea(Messages.t(ID + ".usage"));
      this.manufacturer = new JTextField(mutableDevice.manufacturer, "", 20);
      this.brand = new JTextField(mutableDevice.brand, "", 20);
      this.device = new JTextField(mutableDevice.device, "", 20);
      this.hardware = new JTextField(mutableDevice.hardware, "", 20);
      this.product = new JTextField(mutableDevice.product, "", 20);
      this.model = new JTextField(mutableDevice.model, "", 20);
      this.id = new JTextField(mutableDevice.id, "", 20);
      this.fingerprint = new JTextField(mutableDevice.fingerprint, "", 20);
      this.releaseVersion = new JTextField(mutableDevice.releaseVersion, "", 20);
      this.bootloader = new JTextField(mutableDevice.bootloader, "", 20);
      this.time = new JTextField(mutableDevice.time, "", 20);
      this.sdk = new JSpinner(mutableDevice.sdk);
      this.ota = new JCheckBox(Messages.t(ID + ".ota"));
      this.ota.setModel(mutableDevice.ota);
      this.abi = new JTextArea(mutableDevice.abi);
      this.width = new JSpinner(mutableDevice.screenWidth);
      this.height = new JSpinner(mutableDevice.screenHeight);
      this.layout = new JSpinner(mutableDevice.screenLayout);
      this.density = new JSpinner(mutableDevice.screenDensity);
      this.glEs = new JSpinner(mutableDevice.glVersion);
      this.glExstensions = new JTextArea(mutableDevice.glEsExtensions);
      this.navigation = new JComboBox(mutableDevice.navigation);
      this.touchscreen = new JComboBox(mutableDevice.touchscreen);
      this.keyboard = new JComboBox(mutableDevice.keyboard);
      this.software = new JTable(mutableDevice.software);
      this.features = new JTextArea(mutableDevice.systemAvailableFeatures);
      this.libraries = new JTextArea(mutableDevice.systemSharedLibraries);
      this.locales = new JTextArea(mutableDevice.locales);
      this.spinner = new Spinner();
      this.spinner.setMargin(new Insets(2, 4, 2, 8));
      this.idleState.addIdleListener(this.spinner);
      this.proxyUrl = new JTextField(20);
      this.testApp = new JTextField("onyxbits.de.testapp", 20);
      this.registerGsf = new JCheckBox(Messages.t(ID + ".registergsf"));
      this.pawn.setRegisterGsfModel(this.registerGsf.getModel());
      this.login = new JCheckBox(Messages.t(ID + ".login"));
      this.pawn.setLoginModel(this.login.getModel());
      this.downloadApp = new JCheckBox(Messages.t(ID + ".downloadapp"));
      this.logText.setFont(new Font("Monospaced", 0, 12));
      this.manufacturer.setMargin(MARGIN);
      this.logText.setMargin(MARGIN);
      this.brand.setMargin(MARGIN);
      this.device.setMargin(MARGIN);
      this.hardware.setMargin(MARGIN);
      this.product.setMargin(MARGIN);
      this.model.setMargin(MARGIN);
      this.id.setMargin(MARGIN);
      this.fingerprint.setMargin(MARGIN);
      this.releaseVersion.setMargin(MARGIN);
      this.bootloader.setMargin(MARGIN);
      this.time.setMargin(MARGIN);
      this.features.setMargin(MARGIN);
      this.libraries.setMargin(MARGIN);
      this.abi.setMargin(MARGIN);
      this.locales.setMargin(MARGIN);
      this.glExstensions.setMargin(MARGIN);
      this.username.setMargin(MARGIN);
      this.password.setMargin(MARGIN);
      this.proxyUrl.setMargin(MARGIN);
      this.testApp.setMargin(MARGIN);
      this.logText.setEditable(false);
      this.registerGsf.setSelected(true);
      this.login.setSelected(true);
      this.downloadApp.setSelected(true);
      this.lastProxy = this.proxyUrl.getText();
   }

   protected JFrame createFrame() {
      return new JFrame(Messages.t(ID + ".windowtitle"));
   }

   public Container mount() {
      GridBagConstraints gbc = new GridBagConstraints();
      JPanel ret = new DeskPane(new GridBagLayout());
      Focus.on(this.username);
      this.submitAction.ctrl = this;
      DirectoryManager dm = (DirectoryManager)this.fetch(DirectoryManager.class);
      dm.addDirectoryListener(this.probeDeviceAction);
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(10, 10, 0, 10);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      ret.add(this.mountPawn(), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(10, 10, 10, 10);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 1.0D;
      ret.add(this.mountSpec(), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 2;
      gbc.fill = 1;
      gbc.insets = new Insets(10, 0, 10, 10);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 1.0D;
      ret.add(this.mountUplink(), gbc);
      return ret;
   }

   private Component mountUplink() {
      GridBagConstraints gbc = new GridBagConstraints();
      JPanel ret = new JPanel(new GridBagLayout());
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.mountSettings(), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 4, 4, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.logText), gbc);
      ret.setBorder(new WindowBorder(Messages.t(ID.concat(".title.uplink"))));
      return ret;
   }

   private Component mountSettings() {
      GridBagConstraints gbc = new GridBagConstraints();
      JPanel ret = new JPanel(new GridBagLayout());
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".settings.testapp")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 3;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.testApp), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".settings.proxyurl")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 3;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.proxyUrl), gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(12, 4, 4, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".settings.actions")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(12, 4, 4, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.login), gbc);
      gbc.gridx = 2;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(12, 4, 4, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.registerGsf), gbc);
      gbc.gridx = 3;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(12, 4, 4, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.downloadApp), gbc);
      ret.setBorder(new TitledBorder(Messages.t(ID + ".title.settings")));
      return ret;
   }

   private Component mountSpec() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      JTabbedPane tabs = new JTabbedPane();
      tabs.addTab(Messages.t(ID + ".tab.build"), this.mountBuild());
      tabs.addTab(Messages.t(ID + ".tab.userinterface"), this.mountUserInterface());
      tabs.addTab(Messages.t(ID + ".tab.opengl"), this.mountOpenGl());
      tabs.addTab(Messages.t(ID + ".tab.software"), this.mountVersions());
      tabs.addTab(Messages.t(ID + ".tab.features"), this.mountFeatures());
      tabs.addTab(Messages.t(ID + ".tab.libraries"), this.mountLibraries());
      tabs.addTab(Messages.t(ID + ".tab.locales"), this.mountLocales());
      tabs.addTab(Messages.t(ID + ".tab.abi"), this.mountAbi());
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 4, 4, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(tabs, gbc);
      ret.setBorder(new WindowBorder(Messages.t(ID + ".title.spec")));
      return ret;
   }

   private Component mountAbi() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.idleState.enableOnIdle(this.abi)), gbc);
      return ret;
   }

   private Component mountLocales() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.idleState.enableOnIdle(this.locales)), gbc);
      return ret;
   }

   private Component mountLibraries() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.idleState.enableOnIdle(this.libraries)), gbc);
      return ret;
   }

   private Component mountFeatures() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.idleState.enableOnIdle(this.features)), gbc);
      return ret;
   }

   private Component mountVersions() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".versions.sdk")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.sdk), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 2;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.idleState.enableOnIdle(this.software)), gbc);
      return ret;
   }

   private Component mountPawn() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".pawn.username")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.username), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 8, 4);
      gbc.anchor = 17;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".pawn.password")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 8, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.password), gbc);
      ret.setBorder(new WindowBorder(Messages.t(ID.concat(".title.pawn"))));
      return ret;
   }

   private Component mountOpenGl() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".opengl.version")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.glEs), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 2;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(8, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(new JScrollPane(this.idleState.enableOnIdle(this.glExstensions)), gbc);
      return ret;
   }

   private Component mountUserInterface() {
      JPanel ret = new JPanel(new GridBagLayout());
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".userinterface.width")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.width), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".userinterface.height")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.height), gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".userinterface.density")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.density), gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".userinterface.layout")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.layout), gbc);
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(16, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".userinterface.touchscreen")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(16, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.touchscreen), gbc);
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".userinterface.navigation")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 5;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.navigation), gbc);
      gbc.gridx = 0;
      gbc.gridy = 6;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".userinterface.keyboard")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 6;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.keyboard), gbc);
      gbc.gridx = 0;
      gbc.gridy = 7;
      gbc.gridwidth = 2;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(Box.createGlue(), gbc);
      return ret;
   }

   private Container mountBuild() {
      GridBagConstraints gbc = new GridBagConstraints();
      JPanel ret = new JPanel(new GridBagLayout());
      gbc.gridx = 0;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.model")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(8, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.model), gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.manufacturer")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.manufacturer), gbc);
      gbc.gridx = 0;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.brand")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.brand), gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.product")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 3;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.product), gbc);
      gbc.gridx = 0;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.device")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 4;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.device), gbc);
      gbc.gridx = 0;
      gbc.gridy = 5;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.hardware")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 5;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.hardware), gbc);
      gbc.gridx = 0;
      gbc.gridy = 6;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.id")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 6;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.id), gbc);
      gbc.gridx = 0;
      gbc.gridy = 7;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.bootloader")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 7;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.bootloader), gbc);
      gbc.gridx = 0;
      gbc.gridy = 8;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.releaseversion")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 8;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.releaseVersion), gbc);
      gbc.gridx = 0;
      gbc.gridy = 9;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.time")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 9;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 4, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.time), gbc);
      gbc.gridx = 0;
      gbc.gridy = 10;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 0, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(new JLabel(Messages.t(ID + ".build.fingerprint")), gbc);
      gbc.gridx = 1;
      gbc.gridy = 10;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 4, 4, 4);
      gbc.anchor = 18;
      gbc.weightx = 0.0D;
      gbc.weighty = 0.0D;
      ret.add(this.idleState.enableOnIdle(this.fingerprint), gbc);
      gbc.gridx = 1;
      gbc.gridy = 11;
      gbc.gridwidth = 1;
      gbc.gridheight = 1;
      gbc.fill = 2;
      gbc.insets = new Insets(4, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(this.idleState.enableOnIdle(this.ota), gbc);
      gbc.gridx = 0;
      gbc.gridy = 12;
      gbc.gridwidth = 2;
      gbc.gridheight = 1;
      gbc.fill = 1;
      gbc.insets = new Insets(0, 0, 0, 0);
      gbc.anchor = 18;
      gbc.weightx = 1.0D;
      gbc.weighty = 1.0D;
      ret.add(Box.createGlue(), gbc);
      return ret;
   }

   protected JMenu createViewMenu() {
      JMenu ret = new ViewMenu();
      MnemonicContext mc = new MnemonicContext();
      JMenuItem tmp = ret.add(this.userAgentAction);
      mc.assign(tmp);
      tmp = ret.add(this.gsfIdAction);
      mc.assign(tmp);
      tmp = ret.add(this.authAction);
      mc.assign(tmp);
      tmp = ret.add(this.carrierAction);
      mc.assign(tmp);
      return ret;
   }

   protected JMenu createFileMenu() {
      JMenu ret = new FileMenu();
      MnemonicContext mc = new MnemonicContext();
      JMenuItem tmp = ret.add(this.newAction);
      mc.assign(tmp);
      tmp.setAccelerator(KeyStroke.getKeyStroke(78, AppAction.MASK));
      tmp = ret.add(this.openAction);
      mc.assign(tmp);
      tmp.setAccelerator(KeyStroke.getKeyStroke(79, AppAction.MASK));
      ret.addSeparator();
      ret.add(this.saveAsAction);
      tmp = ret.add(this.saveAction);
      tmp.setAccelerator(KeyStroke.getKeyStroke(83, AppAction.MASK));
      mc.assign(tmp);
      ret.addSeparator();
      tmp = ret.add(this.submitAction);
      tmp.setAccelerator(KeyStroke.getKeyStroke(10, AppAction.MASK));
      mc.assign(tmp);
      ret.addSeparator();
      tmp = ret.add(this.shutdownAction);
      tmp.setAccelerator(ShutdownAction.ACCEL);
      mc.assign(tmp);
      return ret;
   }

   protected JMenu createEditMenu() {
      JMenu ret = new EditMenu();
      MnemonicContext mc = new MnemonicContext();
      JMenuItem tmp = ret.add(this.copyAction);
      tmp.setAccelerator(KeyStroke.getKeyStroke(67, AppAction.MASK | 64));
      mc.assign(tmp);
      tmp = ret.add(this.pasteAction);
      tmp.setAccelerator(KeyStroke.getKeyStroke(86, AppAction.MASK | 64));
      mc.assign(tmp);
      ret.addSeparator();
      tmp = ret.add(this.probeDeviceAction);
      tmp.setAccelerator(KeyStroke.getKeyStroke(119, 0));
      mc.assign(tmp);
      return ret;
   }

   protected JToolBar createToolBar() {
      JToolBar ret = new JToolBar();
      ret.add(this.submitAction);
      ret.add(this.probeDeviceAction);
      if (((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).isEyesOnly()) {
         ret.addSeparator();
         ret.add(this.unlockAction);
      }

      ret.add(Box.createGlue());
      ret.add(this.spinner);
      return ret;
   }

   public void next() {
      switch(this.state) {
      case 0:
         if (this.login.isSelected()) {
            this.enterLogin();
            break;
         } else if (this.registerGsf.isSelected()) {
            this.enterRegister();
            break;
         } else if (this.downloadApp.isSelected() && this.testApp.getText().length() > 0) {
            this.enterDownload();
            break;
         }
      case 2:
         if (this.registerGsf.isSelected()) {
            this.enterRegister();
            break;
         } else if (this.downloadApp.isSelected() && this.testApp.getText().length() > 0) {
            this.enterDownload();
            break;
         }
      case 1:
         if (this.downloadApp.isSelected() && this.testApp.getText().length() > 0) {
            this.enterDownload();
            break;
         }
      case 3:
         this.reset();
      }

   }

   public void log(String txt) {
      String tmp = this.logText.getText();
      if (tmp.length() > 0 && !tmp.endsWith("\n")) {
         this.logText.append("\n");
      }

      this.logText.append(txt);
   }

   public void reset() {
      this.idleState.setIdle(true);
      this.state = 0;
   }

   private void enterDownload() {
      this.idleState.setIdle(false);
      this.state = 3;
      ((Scheduler)this.fetch(Scheduler.class)).schedule(new DownloadTask(this, this.testApp.getText()));
   }

   private void enterRegister() {
      this.idleState.setIdle(false);
      this.state = 1;
      ((Scheduler)this.fetch(Scheduler.class)).schedule(new RegisterTask(this));
   }

   private void enterLogin() {
      this.idleState.setIdle(false);
      this.state = 2;
      ((Scheduler)this.fetch(Scheduler.class)).schedule(new LoginTask(this));
   }

   public void clearLog() {
      this.logText.setText("");
   }

   protected HttpClient createClient() {
      if (!this.lastProxy.equals(this.proxyUrl.getText())) {
         if (this.clientFactory != null) {
            this.clientFactory.shutdown();
         }

         this.clientFactory = null;
         this.lastProxy = this.proxyUrl.getText();
      }

      InetSocketAddress proxy = null;
      int type = 0;
      if (this.lastProxy.length() > 0) {
         URI u = URI.create(this.lastProxy);
         proxy = new InetSocketAddress(u.getHost(), u.getPort());
         if ("socks".equals(u.getScheme())) {
            type = 2;
         }

         if ("https".equals(u.getScheme())) {
            type = 1;
         }

         if (type == 0) {
            throw new IllegalArgumentException(Messages.t(ID + ".protocol"));
         }
      }

      if (this.clientFactory == null) {
         this.clientFactory = new ClientFactory(type, proxy, 40, 40, 9000);
      }

      return this.clientFactory.createClient();
   }

   public boolean isRedacting() {
      return true;
   }

   public void shutdown() {
      if (this.clientFactory != null) {
         this.clientFactory.shutdown();
         this.clientFactory = null;
      }

      this.spinner.getTicker().stop();
   }

   public void windowOpened(WindowEvent e) {
      MockDeviceActivity activity = (MockDeviceActivity)this.fetch(MockDeviceActivity.class);
      if (activity.isEyesOnly()) {
         String url = ((Shop)this.fetch(Shop.class)).getOffersUrl(ID + ".trial.message");
         String title = Messages.t(ID + ".trial.title");
         String message = Messages.t(ID + ".trial.message", url);
         UnlockAction.showDialog(this.getWindow(), activity, title, message);
      }

      this.username.addActionListener(this);
      this.username.addFocusListener(this);
      this.password.addFocusListener(this);
      this.password.addActionListener(this);
      this.proxyUrl.addFocusListener(this);
      this.testApp.addFocusListener(this);
   }

   public String getContextHelpUrl() {
      return Messages.t(ID + ".url.contexthelp");
   }

   public String getSupportUrl() {
      return Messages.t(ID + ".url.support");
   }

   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == this.username) {
         Focus.on(this.password);
      }

      if (e.getSource() == this.password) {
         Focus.on(this.username);
      }

   }

   public void focusGained(FocusEvent e) {
      if (e.getSource() instanceof JTextField) {
         JTextField src = (JTextField)e.getSource();
         src.setSelectionStart(0);
         src.setSelectionEnd(src.getText().length());
      }

   }

   public void focusLost(FocusEvent e) {
   }
}
