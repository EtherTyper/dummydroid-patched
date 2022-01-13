package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ContentFilterSettingsResponseOrBuilder extends MessageOrBuilder {
   List getFilterRangeList();

   FilterRange getFilterRange(int var1);

   int getFilterRangeCount();

   List getFilterRangeOrBuilderList();

   FilterRangeOrBuilder getFilterRangeOrBuilder(int var1);

   boolean hasIntoTitle();

   String getIntoTitle();

   ByteString getIntoTitleBytes();

   boolean hasInfoText();

   String getInfoText();

   ByteString getInfoTextBytes();
}
