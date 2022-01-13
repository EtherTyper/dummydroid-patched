package de.onyxbits.raccoon.standalone.transfer;

import java.util.List;

public interface Transfer {
   int PENDING = 0;
   int PREPROCESSING = 1;
   int TRANSFERRING = 2;
   int POSTPROCESSING = 3;
   int FINISHED = 8;
   int PAUSED = 16;
   int ABORTED = 32;
   int FAILED = 64;

   long getTransferred();

   List getLog();

   int getState();

   void execute();

   void cancel();
}
