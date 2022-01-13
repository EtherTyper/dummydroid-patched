package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface BulkDetailsRequestOrBuilder extends MessageOrBuilder {
   List getDocidList();

   int getDocidCount();

   String getDocid(int var1);

   ByteString getDocidBytes(int var1);

   boolean hasIncludeChildDocs();

   boolean getIncludeChildDocs();

   boolean hasIncludeDetails();

   boolean getIncludeDetails();
}
