package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface NotificationOrBuilder extends MessageOrBuilder {
   boolean hasNotificationType();

   int getNotificationType();

   boolean hasTimestamp();

   long getTimestamp();

   boolean hasDocid();

   Docid getDocid();

   DocidOrBuilder getDocidOrBuilder();

   boolean hasDocTitle();

   String getDocTitle();

   ByteString getDocTitleBytes();

   boolean hasUserEmail();

   String getUserEmail();

   ByteString getUserEmailBytes();

   boolean hasAppData();

   AndroidAppNotificationData getAppData();

   AndroidAppNotificationDataOrBuilder getAppDataOrBuilder();

   boolean hasAppDeliveryData();

   AndroidAppDeliveryData getAppDeliveryData();

   AndroidAppDeliveryDataOrBuilder getAppDeliveryDataOrBuilder();

   boolean hasNotificationId();

   String getNotificationId();

   ByteString getNotificationIdBytes();
}
