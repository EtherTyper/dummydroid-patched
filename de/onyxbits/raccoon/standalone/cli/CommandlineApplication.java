package de.onyxbits.raccoon.standalone.cli;

import de.onyxbits.raccoon.standalone.base.AbstractApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public abstract class CommandlineApplication extends AbstractApplication implements CommandlineSystemProperties, ExitStatus {
   private static final String ID = CommandlineApplication.class.getSimpleName();

   protected abstract Command[] listCommands();

   public final int route(String[] cmdLineArgs) {
      CommandLine commandLine = null;
      Command[] commands = this.listCommands();
      Options options = new Options();

      int var7;
      try {
         Command[] var5 = commands;
         int var6 = commands.length;
         var7 = 0;

         while(true) {
            if (var7 >= var6) {
               commandLine = (new DefaultParser()).parse(options, cmdLineArgs);
               break;
            }

            Command cmd = var5[var7];
            options.addOption(cmd.getOption());
            ++var7;
         }
      } catch (ParseException var14) {
         ((PrintModule)this.fetch(PrintModule.class)).err.println(var14.getMessage());
         return 1;
      }

      List procedures = new ArrayList();
      Option[] var16 = commandLine.getOptions();
      var7 = var16.length;

      int var20;
      for(var20 = 0; var20 < var7; ++var20) {
         Option option = var16[var20];
         Command[] var10 = commands;
         int var11 = commands.length;

         for(int var12 = 0; var12 < var11; ++var12) {
            Command cmd = var10[var12];
            if (option.equals(cmd.getOption())) {
               if (cmd instanceof Procedure) {
                  procedures.add((Procedure)cmd);
               }

               if (cmd instanceof Setting && this.exec((Setting)cmd, this.extractArgs(cmd, commandLine)) != 0) {
                  return 1;
               }
            }
         }
      }

      switch(procedures.size()) {
      case 0:
         List tmp = new ArrayList();
         Command[] var19 = commands;
         var20 = commands.length;

         for(int var21 = 0; var21 < var20; ++var21) {
            Command command = var19[var21];
            if (command instanceof Procedure) {
               tmp.add((Procedure)command);
            }
         }

         ((PrintModule)this.fetch(PrintModule.class)).err.println(Messages.t(ID + ".procedures.none", this.toCsv(tmp)));
         return 1;
      case 1:
         Procedure p = (Procedure)procedures.get(0);
         if (p instanceof HelpProcedure) {
            ((HelpProcedure)p).setOptions(options);
         }

         return this.exec(p, this.extractArgs(p, commandLine));
      default:
         ((PrintModule)this.fetch(PrintModule.class)).err.println(Messages.t(ID + ".procedures.multiple", this.toCsv(procedures)));
         return 1;
      }
   }

   protected int exec(Procedure procedure, String[] args) {
      return procedure.exec(args);
   }

   protected int exec(Setting setting, String[] args) {
      return setting.exec(args);
   }

   private String toCsv(List list) {
      StringBuilder sb = new StringBuilder();
      Iterator var3 = list.iterator();

      while(var3.hasNext()) {
         Procedure p = (Procedure)var3.next();
         if (sb.length() > 0) {
            sb.append(", ");
         }

         Option o = p.getOption();
         if (o.getLongOpt() != null) {
            sb.append("--");
            sb.append(o.getLongOpt());
         } else {
            sb.append('-');
            sb.append(o.getOpt());
         }
      }

      return sb.toString();
   }

   private String[] extractArgs(Command cmd, CommandLine commandLine) {
      String str = cmd.getOption().getOpt();
      String[] ret = null;
      if (str != null && commandLine.hasOption(str)) {
         ret = commandLine.getOptionValues(str);
      } else {
         str = cmd.getOption().getLongOpt();
         if (str != null && commandLine.hasOption(str)) {
            ret = commandLine.getOptionValues(str);
         }
      }

      return ret == null ? new String[0] : ret;
   }
}
