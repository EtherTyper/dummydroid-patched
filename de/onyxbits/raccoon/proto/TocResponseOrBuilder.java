package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface TocResponseOrBuilder extends MessageOrBuilder {
   boolean hasTosVersionDeprecated();

   int getTosVersionDeprecated();

   boolean hasTosContent();

   String getTosContent();

   ByteString getTosContentBytes();

   boolean hasTosCheckboxTextMarketingEmails();

   String getTosCheckboxTextMarketingEmails();

   ByteString getTosCheckboxTextMarketingEmailsBytes();

   boolean hasTosToken();

   String getTosToken();

   ByteString getTosTokenBytes();

   boolean hasSelfUpdateConfig();

   SelfUpdateConfig getSelfUpdateConfig();

   SelfUpdateConfigOrBuilder getSelfUpdateConfigOrBuilder();

   boolean hasRequiresUploadDeviceConfig();

   boolean getRequiresUploadDeviceConfig();

   boolean hasCookie();

   String getCookie();

   ByteString getCookieBytes();
}
