package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface TestingProgramOrBuilder extends MessageOrBuilder {
   boolean hasTesterCapReached();

   boolean getTesterCapReached();

   boolean hasIsTestingProgramDoc();

   boolean getIsTestingProgramDoc();

   boolean hasIsTestApk();

   boolean getIsTestApk();

   boolean hasDeveloperFeedbackUrl();

   String getDeveloperFeedbackUrl();

   ByteString getDeveloperFeedbackUrlBytes();

   boolean hasDeveloperFeedbackEmailAddress();

   String getDeveloperFeedbackEmailAddress();

   ByteString getDeveloperFeedbackEmailAddressBytes();

   boolean hasTestingProgramIcon();

   Image getTestingProgramIcon();

   ImageOrBuilder getTestingProgramIconOrBuilder();
}
