package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface BulkDetailsResponseOrBuilder extends MessageOrBuilder {
   List getEntryList();

   BulkDetailsEntry getEntry(int var1);

   int getEntryCount();

   List getEntryOrBuilderList();

   BulkDetailsEntryOrBuilder getEntryOrBuilder(int var1);
}
