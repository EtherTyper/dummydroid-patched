package de.onyxbits.raccoon.standalone.cli;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public abstract class Procedure extends Command {
   protected void exportAsJson(Object data) throws IOException {
      Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
      this.exportAsText(gson.toJson(data));
   }

   protected void exportAsText(String data) throws IOException {
      File out = ((OutputSetting)this.fetch(OutputSetting.class)).getOutput();
      if (out == null) {
         this.stdOut().println(data);
      } else {
         FileOutputStream fout = new FileOutputStream(out);
         fout.write(data.getBytes());
         fout.close();
      }

   }

   protected String now() {
      return DateFormat.getDateTimeInstance().format(new Date());
   }
}
