package de.onyxbits.raccoon.proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface ResponseWrapperOrBuilder extends MessageOrBuilder {
   boolean hasPayload();

   Payload getPayload();

   PayloadOrBuilder getPayloadOrBuilder();

   boolean hasCommands();

   ServerCommands getCommands();

   ServerCommandsOrBuilder getCommandsOrBuilder();

   List getPreFetchList();

   PreFetch getPreFetch(int var1);

   int getPreFetchCount();

   List getPreFetchOrBuilderList();

   PreFetchOrBuilder getPreFetchOrBuilder(int var1);

   List getNotificationList();

   Notification getNotification(int var1);

   int getNotificationCount();

   List getNotificationOrBuilderList();

   NotificationOrBuilder getNotificationOrBuilder(int var1);
}
