package de.onyxbits.raccoon.standalone.gui.mock;

import de.onyxbits.raccoon.mockup.ApplicationInfo;
import de.onyxbits.raccoon.mockup.Build;
import de.onyxbits.raccoon.mockup.Device;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.util.TextTool;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class MutableDevice implements Device {
   protected SpinnerNumberModel screenWidth = new SpinnerNumberModel(1440, 1, 9999, 1);
   protected SpinnerNumberModel screenHeight = new SpinnerNumberModel(2560, 1, 9999, 1);
   protected SpinnerNumberModel screenDensity = new SpinnerNumberModel(640, 1, 999, 1);
   protected SpinnerNumberModel sdk = new SpinnerNumberModel(20, 1, 999, 1);
   protected SpinnerNumberModel glVersion = new SpinnerNumberModel(3.0D, 1.0D, 100.0D, 0.1D);
   protected SpinnerNumberModel screenLayout = new SpinnerNumberModel(2, 0, 65535, 1);
   protected PlainDocument time = new PlainDocument();
   protected PlainDocument brand = new PlainDocument();
   protected PlainDocument manufacturer = new PlainDocument();
   protected PlainDocument device = new PlainDocument();
   protected PlainDocument hardware = new PlainDocument();
   protected PlainDocument product = new PlainDocument();
   protected PlainDocument model = new PlainDocument();
   protected PlainDocument id = new PlainDocument();
   protected PlainDocument fingerprint = new PlainDocument();
   protected PlainDocument releaseVersion = new PlainDocument();
   protected PlainDocument bootloader = new PlainDocument();
   protected PlainDocument systemAvailableFeatures = new PlainDocument();
   protected PlainDocument systemSharedLibraries = new PlainDocument();
   protected PlainDocument glEsExtensions = new PlainDocument();
   protected PlainDocument abi = new PlainDocument();
   protected PlainDocument locales = new PlainDocument();
   protected ComboBoxModel navigation = new DefaultComboBoxModel(Navigation.values());
   protected ComboBoxModel touchscreen = new DefaultComboBoxModel(Touchscreen.values());
   protected ComboBoxModel keyboard = new DefaultComboBoxModel(Keyboard.values());
   protected VersionModel software = new VersionModel();
   protected ButtonModel ota = (new JCheckBox()).getModel();

   public MutableDevice() {
   }

   public int getScreenWidth() {
      return (Integer)this.screenWidth.getNumber();
   }

   public int getScreenHeight() {
      return (Integer)this.screenHeight.getNumber();
   }

   public int getScreenDensity() {
      return (Integer)this.screenDensity.getNumber();
   }

   public Build getBuild() {
      long d = 0L;

      try {
         d = DateFormat.getDateInstance().parse(this.time.getText(0, this.time.getLength())).getTime();
      } catch (Exception var4) {
      }

      return new Build(asString(this.manufacturer), asString(this.brand), asString(this.device), asString(this.hardware), asString(this.product), asString(this.model), asString(this.id), asString(this.releaseVersion), asString(this.bootloader), asInt(this.sdk), d, asList(this.abi), asString(this.fingerprint));
   }

   public List getSystemAvailableFeatures() {
      return asList(this.systemAvailableFeatures);
   }

   public List getSystemSharedLibraries() {
      return asList(this.systemSharedLibraries);
   }

   public boolean isOtaInstalled() {
      return this.ota.isSelected();
   }

   public List getLocales() {
      return asList(this.locales);
   }

   public int getGlEsVersion() {
      Double tmp = (Double)this.glVersion.getNumber();
      int major = (int)tmp.floatValue();
      int minor = (int)((tmp.floatValue() - (float)major) * 10.0F);
      return MockUtil.encodeGlVersion(major, minor);
   }

   public List getGlExtensions() {
      return asList(this.glEsExtensions);
   }

   public ApplicationInfo getApplicationInfo(String packageName) {
      String versionName = "";
      int versionCode = 1;

      for(int i = 0; i < VersionModel.ROWS.length; ++i) {
         if (VersionModel.ROWS[i].equals(packageName)) {
            try {
               versionName = this.software.getValueAt(i, 1).toString();
               if (versionName.length() == 0) {
                  return null;
               }

               versionCode = Integer.parseInt(this.software.getValueAt(i, 2).toString());
            } catch (Exception var6) {
               return null;
            }
         }
      }

      return new ApplicationInfo(packageName, versionName, versionCode);
   }

   public boolean getHasFiveWayNavigation() {
      return this.navigation.getSelectedItem() == Navigation.DPAD;
   }

   public boolean getHasHardwareKeyboard() {
      return this.keyboard.getSelectedItem() == Keyboard.QWERTY || this.keyboard.getSelectedItem() == Keyboard.TWELVE_KEYS;
   }

   public int getKeyboard() {
      return ((Keyboard)this.keyboard.getSelectedItem()).ordinal();
   }

   public int getTouchscreen() {
      return ((Touchscreen)this.touchscreen.getSelectedItem()).ordinal();
   }

   public int getNavigation() {
      return ((Navigation)this.navigation.getSelectedItem()).ordinal();
   }

   public int getScreenLayout() {
      return (Integer)this.screenLayout.getValue();
   }

   public void clear() {
      setText(this.brand, "");
      setText(this.bootloader, "");
      setText(this.device, "");
      setText(this.fingerprint, "");
      setText(this.id, "");
      setText(this.manufacturer, "");
      setText(this.model, "");
      setText(this.hardware, "");
      setText(this.product, "");
      setText(this.time, "");
      setText(this.releaseVersion, "");
      this.sdk.setValue(1);
      toModel(this.abi, new ArrayList());
      toModel(this.glEsExtensions, new ArrayList());
      toModel(this.systemAvailableFeatures, new ArrayList());
      toModel(this.systemSharedLibraries, new ArrayList());
      toModel(this.locales, new ArrayList());
      this.glVersion.setValue(1.0D);
      this.screenDensity.setValue(1);
      this.screenHeight.setValue(1);
      this.screenWidth.setValue(1);
      this.touchscreen.setSelectedItem(Touchscreen.FINGER);
      this.navigation.setSelectedItem(Navigation.NO_NAV);
      this.keyboard.setSelectedItem(Keyboard.NO_KEYS);
      this.ota.setSelected(false);

      for(int i = 0; i < VersionModel.ROWS.length; ++i) {
         this.software.setValueAt("1", i, 1);
         this.software.setValueAt("1", i, 2);
      }

   }

   public void merge(Build build) {
      if (build != null) {
         setText(this.brand, build.brand);
         setText(this.bootloader, build.bootloader);
         setText(this.device, build.device);
         setText(this.fingerprint, build.fingerprint);
         setText(this.id, build.id);
         setText(this.manufacturer, build.manufacturer);
         setText(this.model, build.model);
         setText(this.hardware, build.hardware);
         setText(this.product, build.product);
         setText(this.time, DateFormat.getDateTimeInstance().format(new Date(build.time)));
         setText(this.releaseVersion, build.releaseVersion);
         this.sdk.setValue(build.sdkVersion);
         toModel(this.abi, build.abi);
      }

   }

   public void merge(Device device) {
      this.merge(device.getBuild());
      toModel(this.glEsExtensions, device.getGlExtensions());
      toModel(this.systemAvailableFeatures, device.getSystemAvailableFeatures());
      toModel(this.systemSharedLibraries, device.getSystemSharedLibraries());
      toModel(this.locales, device.getLocales());
      double version = (double)MockUtil.decodeMajorGlVersion(device.getGlEsVersion());
      version += (double)(MockUtil.decodeMinorGlVersion(device.getGlEsVersion()) / 10);
      this.glVersion.setValue(version);
      this.screenDensity.setValue(device.getScreenDensity());
      this.screenHeight.setValue(device.getScreenHeight());
      this.screenWidth.setValue(device.getScreenWidth());
      this.touchscreen.setSelectedItem(Touchscreen.values()[device.getTouchscreen()]);
      this.navigation.setSelectedItem(Navigation.values()[device.getNavigation()]);
      this.keyboard.setSelectedItem(Keyboard.values()[device.getKeyboard()]);
      this.ota.setSelected(device.isOtaInstalled());

      for(int i = 0; i < VersionModel.ROWS.length; ++i) {
         String app = VersionModel.ROWS[i];
         ApplicationInfo ai = device.getApplicationInfo(app);
         if (ai != null) {
            this.software.setValueAt(ai.versionName, i, 1);
            this.software.setValueAt(ai.versionCode, i, 2);
         }
      }

   }

   protected static void toModel(PlainDocument doc, List lst) {
      StringBuilder sb = new StringBuilder();

      String s;
      for(Iterator var3 = lst.iterator(); var3.hasNext(); sb.append(s)) {
         s = (String)var3.next();
         if (sb.length() > 0) {
            sb.append('\n');
         }
      }

      try {
         doc.remove(0, doc.getLength());
         doc.insertString(0, sb.toString(), (AttributeSet)null);
      } catch (BadLocationException var5) {
      }

   }

   private static void setText(PlainDocument doc, String txt) {
      try {
         doc.remove(0, doc.getLength());
         if (txt != null) {
            doc.insertString(0, txt, (AttributeSet)null);
         }
      } catch (BadLocationException var3) {
      }

   }

   private static List asList(PlainDocument model) {
      ArrayList ret = new ArrayList();

      try {
         String[] tmp = model.getText(0, model.getLength()).split("\n");
         String[] var3 = tmp;
         int var4 = tmp.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            String s = var3[var5];
            if (s != null && s.length() > 0) {
               ret.add(s);
            }
         }
      } catch (BadLocationException var7) {
      }

      return ret;
   }

   private static int asInt(SpinnerNumberModel model) {
      return (Integer)model.getNumber();
   }

   private static String asString(PlainDocument doc) {
      try {
         return doc.getLength() == 0 ? null : doc.getText(0, doc.getLength());
      } catch (BadLocationException var2) {
         return "";
      }
   }

   public List getInstalledApps() {
      List ret = new ArrayList();

      for(int i = 0; i < VersionModel.ROWS.length; ++i) {
         String pn = this.software.getValueAt(i, 0).toString();
         String vn = this.software.getValueAt(i, 1).toString();
         boolean var5 = true;

         int vc;
         try {
            vc = Integer.parseInt(this.software.getValueAt(i, 2).toString());
         } catch (Exception var7) {
            return null;
         }

         ret.add(new ApplicationInfo(pn, vn, vc));
      }

      return ret;
   }

   public String getRedactedAgent() {
      MutableDevice device = new MutableDevice();
      String s = TextTool.redact("12345");
      Build build = new Build(s, s, s, s, s, s, s, s, s, this.getBuild().sdkVersion, this.getBuild().time, this.getBuild().abi, s);
      device.merge((Device)this);
      device.merge(build);
      return MockUtil.toFinskyAgent(device);
   }
}
