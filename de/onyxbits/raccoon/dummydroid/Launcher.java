package de.onyxbits.raccoon.dummydroid;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.onyxbits.raccoon.finsky.Base64G;
import de.onyxbits.raccoon.standalone.Registration;
import de.onyxbits.raccoon.standalone.RegistrationAdapter;
import de.onyxbits.raccoon.standalone.base.Module;
import de.onyxbits.raccoon.standalone.cli.Command;
import de.onyxbits.raccoon.standalone.cli.CommandlineApplication;
import de.onyxbits.raccoon.standalone.cli.HelpProcedure;
import de.onyxbits.raccoon.standalone.cli.Procedure;
import de.onyxbits.raccoon.standalone.gui.mock.MockDeviceActivity;
import de.onyxbits.raccoon.util.RandomSymbols;
import de.onyxbits.raccoon.util.VersionFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

public class Launcher extends CommandlineApplication implements Runnable, Registration {
   private Plate plate;
   private long created;

   private Launcher() {
      FileReader reader = null;

      try {
         reader = new FileReader(this.pathOfRegistration());
         this.plate = (Plate)(new Gson()).fromJson((Reader)reader, (Class)Plate.class);
         if (!this.isValid(Base64G.decode((String)this.plate.key, 0))) {
            throw new IllegalArgumentException();
         }
      } catch (Exception var11) {
         this.getRegistrationId();
         this.plate = new Plate();
         this.plate.enabled = Collections.emptyList();
      } finally {
         if (reader != null) {
            try {
               reader.close();
            } catch (IOException var10) {
            }
         }

      }

   }

   public Module create(Class module) {
      return (Module)(module == RegistrationAdapter.class ? new RegistrationAdapter(this) : super.create(module));
   }

   public File pathOf() {
      String tmp = System.getProperty("workspace");
      return tmp != null ? new File(tmp) : new File(FileSystemView.getFileSystemView().getDefaultDirectory(), "DummyDroid");
   }

   private File pathOfConfig() {
      return new File(this.pathOf(), "config");
   }

   private File pathOfVersion() {
      return new File(this.pathOfConfig(), "version.dat");
   }

   private File pathOfRegistration() {
      return new File(this.pathOfConfig(), "registration.dat");
   }

   private boolean isValid(byte[] data) {
      byte[] ret = new byte[data.length];
      byte[] id = this.getRegistrationId().getBytes();
      int idx = 0;

      for(int i = 0; i < data.length; ++i) {
         ret[i] = (byte)(data[i] ^ id[idx]);
         idx = (idx + 1) % id.length;
      }

      String[] tmp = (new String(ret)).split(":");
      String[] var6 = tmp;
      int var7 = tmp.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         String s = var6[var8];
         if ("valid".equals(s)) {
            return true;
         }
      }

      return false;
   }

   public void run() {
      ((MockDeviceActivity)this.fetch(MockDeviceActivity.class)).setVisible(true);
      MockDeviceActivity activity = (MockDeviceActivity)this.fetch(MockDeviceActivity.class);
      activity.setVisible(true);
   }

   public String getFullName() {
      return this.plate.fullName;
   }

   public String getContactEmail() {
      return this.plate.contactEmail;
   }

   public String getRegistrationId() {
      if (this.created == 0L) {
         File file = this.pathOfVersion();

         try {
            if (!file.exists()) {
               file.getParentFile().mkdirs();
               this.created = VersionFile.create(file, this.getProductCode(), 5).getCreated();
            } else {
               this.created = (new VersionFile(file)).getCreated();
            }
         } catch (Exception var3) {
            return null;
         }
      }

      RandomSymbols r = new RandomSymbols(this.created);
      StringBuilder sb = new StringBuilder();
      sb.append(r.next());
      sb.append(r.next());
      sb.append(r.next());
      sb.append(r.next());
      return sb.toString();
   }

   public String getProductCode() {
      return "dummydroid";
   }

   public boolean isEnabled(String id) {
      Iterator var2 = this.plate.enabled.iterator();

      String s;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         s = (String)var2.next();
      } while(!id.matches(s));

      return true;
   }

   public boolean updateRegistration(byte[] data) throws IOException {
      if (this.isValid(data)) {
         this.plate = new Plate();
         this.plate.enabled = Collections.singletonList(".*");
         this.plate.registrationId = this.getRegistrationId();
         this.plate.timestamp = System.currentTimeMillis();
         this.plate.key = Base64G.encodeToString(data, 0);
         this.pathOfRegistration().getParentFile().mkdirs();
         FileOutputStream fout = new FileOutputStream(this.pathOfRegistration());
         fout.write((new GsonBuilder()).setPrettyPrinting().create().toJson((Object)this.plate).getBytes());
         fout.close();
         return true;
      } else {
         return false;
      }
   }

   protected Command[] listCommands() {
      Command[] ret = new Command[]{(Command)this.fetch(UnlockProcedure.class), (Command)this.fetch(HelpProcedure.class)};
      return ret;
   }

   protected int exec(Procedure procedure, String[] args) {
      return procedure.exec(args);
   }

   public static void main(String[] args) {
      Launcher launcher = new Launcher();
      if (args.length == 0) {
         System.setProperty("awt.useSystemAAFontSettings", "on");
         System.setProperty("swing.aatext", "true");
         SwingUtilities.invokeLater(launcher);
      } else {
         int res = launcher.route(args);
         if (res != -1) {
            System.exit(res);
         }
      }

   }
}
