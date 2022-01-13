package de.onyxbits.raccoon.standalone;

import de.onyxbits.raccoon.dfemodel.CheckinPawn;
import de.onyxbits.raccoon.dfemodel.DetailsPawn;
import de.onyxbits.raccoon.dfemodel.FinskyPawn;
import de.onyxbits.raccoon.dfemodel.HelloMarketPawn;
import de.onyxbits.raccoon.dfemodel.LoginPawn;
import de.onyxbits.raccoon.mockup.MockUtil;
import de.onyxbits.raccoon.mockup.Pawn;
import de.onyxbits.raccoon.net.ClientFactory;
import de.onyxbits.raccoon.standalone.base.AbstractModule;
import de.onyxbits.raccoon.standalone.base.AppAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpClient;

public class Uplink extends AbstractModule {
   public static final String PAWNSUFFIX = "prf";
   private ClientFactory clientFactory;
   private Pawn pawn;
   private URI proxy;

   public void setProxy(URI url) {
      if (url != null) {
         String s = url.getScheme();
         if (!"http".equals(s) && !"https".equals(s) && !"socks".equals(s)) {
            throw new IllegalArgumentException("Only the following schemes are supported: http, https, socks");
         }
      }

      if (this.clientFactory != null) {
         this.clientFactory.shutdown();
         this.clientFactory = null;
      }

      this.proxy = url;
   }

   public URI getProxy() {
      return this.proxy;
   }

   public void selectPawn(String alias) throws FileNotFoundException, IOException {
      this.pawn = this.loadPawn(alias);
   }

   public Pawn getSelectedPawn() {
      if (this.pawn == null) {
         try {
            this.selectPawn("default");
         } catch (IOException var2) {
         }
      }

      return this.pawn;
   }

   public HttpClient createClient() {
      if (this.clientFactory == null) {
         InetSocketAddress p = null;
         int type = 0;
         if (this.proxy != null) {
            p = new InetSocketAddress(this.proxy.getHost(), this.proxy.getPort());
            if ("socks".equals(this.proxy.getScheme())) {
               type = 2;
            }

            if ("https".equals(this.proxy.getScheme())) {
               type = 1;
            }

            if ("http".equals(this.proxy.getScheme())) {
               type = 1;
            }

            if (type == 0) {
               type = 1;
               p = new InetSocketAddress("localhost", 0);
            }
         }

         this.clientFactory = new ClientFactory(type, p, 40, 40, 9000);
      }

      return this.clientFactory.createClient();
   }

   public void shutdown() {
      if (this.clientFactory != null) {
         this.clientFactory.shutdown();
      }

   }

   public LoginPawn createLoginPawn() {
      if (this.getSelectedPawn() == null) {
         throw new NullPointerException("No Pawn selected");
      } else {
         return new LoginPawn(this.getSelectedPawn(), new UplinkClientProvider(this));
      }
   }

   public CheckinPawn createCheckinPawn() {
      if (this.getSelectedPawn() == null) {
         throw new NullPointerException("No Pawn selected");
      } else {
         return new CheckinPawn(this.getSelectedPawn(), new UplinkClientProvider(this));
      }
   }

   public FinskyPawn createDfePawn() {
      if (this.getSelectedPawn() == null) {
         throw new NullPointerException("No Pawn selected");
      } else {
         return new FinskyPawn(this.getSelectedPawn(), new UplinkClientProvider(this));
      }
   }

   public DetailsPawn createDetailsPawn() {
      if (this.getSelectedPawn() == null) {
         throw new NullPointerException("No Pawn selected");
      } else {
         return new DetailsPawn(this.getSelectedPawn(), new UplinkClientProvider(this));
      }
   }

   public HelloMarketPawn createHelloMarketPawn() {
      if (this.getSelectedPawn() == null) {
         throw new NullPointerException("No Pawn selected");
      } else {
         return new HelloMarketPawn(this.getSelectedPawn(), new UplinkClientProvider(this));
      }
   }

   public File pathOfPawns() {
      return new File(((AppAdapter)this.fetch(AppAdapter.class)).pathOfConfig(), "profiles");
   }

   public File pathOfPawn(Pawn p) {
      return this.pathOfPawn(p.getAlias());
   }

   public File pathOfPawn(String alias) {
      if (alias != null && alias.length() != 0) {
         char[] tmp = alias.toCharArray();

         for(int i = 0; i < tmp.length; ++i) {
            if ((tmp[i] < 'a' || tmp[i] > 'z') && (tmp[i] < 'A' || tmp[i] > 'Z') && (tmp[i] < '0' || tmp[i] > '9') && tmp[i] != '-' && tmp[i] != ' ') {
               tmp[i] = '_';
            }
         }

         return new File(this.pathOfPawns(), new String(tmp) + "." + "prf");
      } else {
         return new File(this.pathOfPawns(), "default.prf");
      }
   }

   public Pawn loadPawn(String alias) throws IOException, FileNotFoundException {
      FileReader reader = new FileReader(this.pathOfPawn(alias));
      Throwable var3 = null;

      Pawn var4;
      try {
         var4 = MockUtil.decodePawn((Reader)reader);
      } catch (Throwable var13) {
         var3 = var13;
         throw var13;
      } finally {
         if (reader != null) {
            if (var3 != null) {
               try {
                  reader.close();
               } catch (Throwable var12) {
                  var3.addSuppressed(var12);
               }
            } else {
               reader.close();
            }
         }

      }

      return var4;
   }

   public void savePawn(Pawn pawn) throws IOException {
      this.pathOfPawns().mkdirs();
      File file = this.pathOfPawn(pawn);
      FileOutputStream fos = new FileOutputStream(file);
      fos.write(MockUtil.encodePawn(pawn).getBytes());
      fos.close();
   }

   public List listPawns() {
      this.pathOfPawns().mkdirs();
      List ret = new ArrayList();
      File[] files = this.pathOfPawns().listFiles();
      File[] var3 = files;
      int var4 = files.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         File file = var3[var5];
         if (file.isFile() && file.getName().toLowerCase().endsWith("prf")) {
            try {
               FileReader reader = new FileReader(file);
               Throwable var8 = null;

               try {
                  String alias = MockUtil.decodePawn((Reader)reader).getAlias();
                  if (alias != null && !ret.contains(alias)) {
                     ret.add(alias);
                  }
               } catch (Throwable var17) {
                  var8 = var17;
                  throw var17;
               } finally {
                  if (reader != null) {
                     if (var8 != null) {
                        try {
                           reader.close();
                        } catch (Throwable var18) {
                           var8.addSuppressed(var18);
                        }
                     } else {
                        reader.close();
                     }
                  }

               }
            } catch (Exception var20) {
            }
         }
      }

      return ret;
   }
}
