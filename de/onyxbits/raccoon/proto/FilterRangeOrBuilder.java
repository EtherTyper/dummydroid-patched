package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface FilterRangeOrBuilder extends MessageOrBuilder {
   boolean hasDocumentType();

   int getDocumentType();

   boolean hasAuthorityId();

   int getAuthorityId();

   List getFilterChoiceList();

   FilterChoice getFilterChoice(int var1);

   int getFilterChoiceCount();

   List getFilterChoiceOrBuilderList();

   FilterChoiceOrBuilder getFilterChoiceOrBuilder(int var1);

   boolean hasLabel();

   String getLabel();

   ByteString getLabelBytes();

   boolean hasIconFife();

   Image getIconFife();

   ImageOrBuilder getIconFifeOrBuilder();

   boolean hasSelectionDialogLabel();

   String getSelectionDialogLabel();

   ByteString getSelectionDialogLabelBytes();

   boolean hasConfirmationDialogTitle();

   String getConfirmationDialogTitle();

   ByteString getConfirmationDialogTitleBytes();

   boolean hasConfirmationDialogContent();

   String getConfirmationDialogContent();

   ByteString getConfirmationDialogContentBytes();

   boolean hasRepresentChoiceAsToggle();

   boolean getRepresentChoiceAsToggle();

   boolean hasAppPackageName();

   String getAppPackageName();

   ByteString getAppPackageNameBytes();

   boolean hasMinVersionCode();

   int getMinVersionCode();
}
