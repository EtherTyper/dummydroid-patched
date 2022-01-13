package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TextFormatParseInfoTree {
   private Map locationsFromField;
   Map subtreesFromField;

   private TextFormatParseInfoTree(Map locationsFromField, Map subtreeBuildersFromField) {
      Map locs = new HashMap();
      Iterator var4 = locationsFromField.entrySet().iterator();

      while(var4.hasNext()) {
         Entry kv = (Entry)var4.next();
         locs.put(kv.getKey(), Collections.unmodifiableList((List)kv.getValue()));
      }

      this.locationsFromField = Collections.unmodifiableMap(locs);
      Map subs = new HashMap();
      Iterator var11 = subtreeBuildersFromField.entrySet().iterator();

      while(var11.hasNext()) {
         Entry kv = (Entry)var11.next();
         List submessagesOfField = new ArrayList();
         Iterator var8 = ((List)kv.getValue()).iterator();

         while(var8.hasNext()) {
            TextFormatParseInfoTree.Builder subBuilder = (TextFormatParseInfoTree.Builder)var8.next();
            submessagesOfField.add(subBuilder.build());
         }

         subs.put(kv.getKey(), Collections.unmodifiableList(submessagesOfField));
      }

      this.subtreesFromField = Collections.unmodifiableMap(subs);
   }

   public List getLocations(Descriptors.FieldDescriptor fieldDescriptor) {
      List result = (List)this.locationsFromField.get(fieldDescriptor);
      return result == null ? Collections.emptyList() : result;
   }

   public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor fieldDescriptor, int index) {
      return (TextFormatParseLocation)getFromList(this.getLocations(fieldDescriptor), index, fieldDescriptor);
   }

   public List getNestedTrees(Descriptors.FieldDescriptor fieldDescriptor) {
      List result = (List)this.subtreesFromField.get(fieldDescriptor);
      return result == null ? Collections.emptyList() : result;
   }

   public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor fieldDescriptor, int index) {
      return (TextFormatParseInfoTree)getFromList(this.getNestedTrees(fieldDescriptor), index, fieldDescriptor);
   }

   public static TextFormatParseInfoTree.Builder builder() {
      return new TextFormatParseInfoTree.Builder();
   }

   private static Object getFromList(List list, int index, Descriptors.FieldDescriptor fieldDescriptor) {
      if (index < list.size() && index >= 0) {
         return list.get(index);
      } else {
         throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", fieldDescriptor == null ? "<null>" : fieldDescriptor.getName(), index));
      }
   }

   // $FF: synthetic method
   TextFormatParseInfoTree(Map x0, Map x1, Object x2) {
      this(x0, x1);
   }

   public static class Builder {
      private Map locationsFromField;
      private Map subtreeBuildersFromField;

      private Builder() {
         this.locationsFromField = new HashMap();
         this.subtreeBuildersFromField = new HashMap();
      }

      public TextFormatParseInfoTree.Builder setLocation(Descriptors.FieldDescriptor fieldDescriptor, TextFormatParseLocation location) {
         List fieldLocations = (List)this.locationsFromField.get(fieldDescriptor);
         if (fieldLocations == null) {
            fieldLocations = new ArrayList();
            this.locationsFromField.put(fieldDescriptor, fieldLocations);
         }

         ((List)fieldLocations).add(location);
         return this;
      }

      public TextFormatParseInfoTree.Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor fieldDescriptor) {
         List submessageBuilders = (List)this.subtreeBuildersFromField.get(fieldDescriptor);
         if (submessageBuilders == null) {
            submessageBuilders = new ArrayList();
            this.subtreeBuildersFromField.put(fieldDescriptor, submessageBuilders);
         }

         TextFormatParseInfoTree.Builder subtreeBuilder = new TextFormatParseInfoTree.Builder();
         ((List)submessageBuilders).add(subtreeBuilder);
         return subtreeBuilder;
      }

      public TextFormatParseInfoTree build() {
         return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField);
      }

      // $FF: synthetic method
      Builder(Object x0) {
         this();
      }
   }
}
