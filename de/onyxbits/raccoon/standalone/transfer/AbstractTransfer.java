package de.onyxbits.raccoon.standalone.transfer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractTransfer implements Transfer {
   private static final int ERRMASK = 96;
   private long transferred;
   private int state = 0;
   private List reports = new ArrayList();

   public long getTransferred() {
      return this.transferred;
   }

   public int getState() {
      return this.state;
   }

   public final void execute() {
      if ((this.state & 96) == 0) {
         this.state = 1;
         this.onPreProcess();
      }

      if ((this.state & 96) == 0) {
         this.state = 2;
         this.onTransfer();
      }

      if ((this.state & 96) == 0) {
         this.state = 3;
         this.onPostProcess();
      }

      this.state = 8 | this.state & 96;
   }

   protected void onPostProcess() {
   }

   protected void onChunk() {
   }

   protected void onPreProcess() {
   }

   protected abstract void onTransfer();

   protected void logInfo(String message) {
      LogMessage lm = new LogMessage(0, message);
      synchronized(this.reports) {
         this.reports.add(lm);
      }
   }

   protected void logWarn(String message) {
      LogMessage lm = new LogMessage(1, message);
      synchronized(this.reports) {
         this.reports.add(lm);
      }
   }

   protected void logFatal(String message) {
      this.state |= 64;
      LogMessage lm = new LogMessage(2, message);
      synchronized(this.reports) {
         this.reports.add(lm);
      }
   }

   public List getLog() {
      List ret = new ArrayList();
      synchronized(this.reports) {
         Iterator var3 = this.reports.iterator();

         while(var3.hasNext()) {
            LogMessage lm = (LogMessage)var3.next();
            ret.add(lm);
         }

         return ret;
      }
   }

   public boolean isCancelled() {
      return (this.state & 32) == 32;
   }

   public void cancel() {
      this.state |= 32;
   }

   protected void copy(InputStream in, OutputStream... out) throws IOException {
      int len = false;
      byte[] buffer = new byte['耀'];

      int len;
      while((this.state & 96) == 0 && (len = in.read(buffer)) > 0) {
         OutputStream[] var5 = out;
         int var6 = out.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            OutputStream o = var5[var7];
            o.write(buffer, 0, len);
         }

         this.transferred += (long)len;
         this.onChunk();
      }

   }
}
