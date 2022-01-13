package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ModifyLibraryRequestOrBuilder extends MessageOrBuilder {
   boolean hasLibraryId();

   String getLibraryId();

   ByteString getLibraryIdBytes();

   List getAddDocIdList();

   int getAddDocIdCount();

   String getAddDocId(int var1);

   ByteString getAddDocIdBytes(int var1);

   List getRemovalDocIdList();

   int getRemovalDocIdCount();

   String getRemovalDocId(int var1);

   ByteString getRemovalDocIdBytes(int var1);

   List getArchiveDocIdList();

   int getArchiveDocIdCount();

   String getArchiveDocId(int var1);

   ByteString getArchiveDocIdBytes(int var1);
}
