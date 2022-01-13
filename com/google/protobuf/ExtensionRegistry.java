package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ExtensionRegistry extends ExtensionRegistryLite {
   private final Map immutableExtensionsByName;
   private final Map mutableExtensionsByName;
   private final Map immutableExtensionsByNumber;
   private final Map mutableExtensionsByNumber;
   static final ExtensionRegistry EMPTY_REGISTRY = new ExtensionRegistry(true);

   public static ExtensionRegistry newInstance() {
      return new ExtensionRegistry();
   }

   public static ExtensionRegistry getEmptyRegistry() {
      return EMPTY_REGISTRY;
   }

   public ExtensionRegistry getUnmodifiable() {
      return new ExtensionRegistry(this);
   }

   /** @deprecated */
   @Deprecated
   public ExtensionRegistry.ExtensionInfo findExtensionByName(String fullName) {
      return this.findImmutableExtensionByName(fullName);
   }

   public ExtensionRegistry.ExtensionInfo findImmutableExtensionByName(String fullName) {
      return (ExtensionRegistry.ExtensionInfo)this.immutableExtensionsByName.get(fullName);
   }

   public ExtensionRegistry.ExtensionInfo findMutableExtensionByName(String fullName) {
      return (ExtensionRegistry.ExtensionInfo)this.mutableExtensionsByName.get(fullName);
   }

   /** @deprecated */
   @Deprecated
   public ExtensionRegistry.ExtensionInfo findExtensionByNumber(Descriptors.Descriptor containingType, int fieldNumber) {
      return this.findImmutableExtensionByNumber(containingType, fieldNumber);
   }

   public ExtensionRegistry.ExtensionInfo findImmutableExtensionByNumber(Descriptors.Descriptor containingType, int fieldNumber) {
      return (ExtensionRegistry.ExtensionInfo)this.immutableExtensionsByNumber.get(new ExtensionRegistry.DescriptorIntPair(containingType, fieldNumber));
   }

   public ExtensionRegistry.ExtensionInfo findMutableExtensionByNumber(Descriptors.Descriptor containingType, int fieldNumber) {
      return (ExtensionRegistry.ExtensionInfo)this.mutableExtensionsByNumber.get(new ExtensionRegistry.DescriptorIntPair(containingType, fieldNumber));
   }

   public Set getAllMutableExtensionsByExtendedType(String fullName) {
      HashSet extensions = new HashSet();
      Iterator var3 = this.mutableExtensionsByNumber.keySet().iterator();

      while(var3.hasNext()) {
         ExtensionRegistry.DescriptorIntPair pair = (ExtensionRegistry.DescriptorIntPair)var3.next();
         if (pair.descriptor.getFullName().equals(fullName)) {
            extensions.add(this.mutableExtensionsByNumber.get(pair));
         }
      }

      return extensions;
   }

   public Set getAllImmutableExtensionsByExtendedType(String fullName) {
      HashSet extensions = new HashSet();
      Iterator var3 = this.immutableExtensionsByNumber.keySet().iterator();

      while(var3.hasNext()) {
         ExtensionRegistry.DescriptorIntPair pair = (ExtensionRegistry.DescriptorIntPair)var3.next();
         if (pair.descriptor.getFullName().equals(fullName)) {
            extensions.add(this.immutableExtensionsByNumber.get(pair));
         }
      }

      return extensions;
   }

   public void add(Extension extension) {
      if (extension.getExtensionType() == Extension.ExtensionType.IMMUTABLE || extension.getExtensionType() == Extension.ExtensionType.MUTABLE) {
         this.add(newExtensionInfo(extension), extension.getExtensionType());
      }
   }

   public void add(GeneratedMessage.GeneratedExtension extension) {
      this.add((Extension)extension);
   }

   static ExtensionRegistry.ExtensionInfo newExtensionInfo(Extension extension) {
      if (extension.getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
         if (extension.getMessageDefaultInstance() == null) {
            throw new IllegalStateException("Registered message-type extension had null default instance: " + extension.getDescriptor().getFullName());
         } else {
            return new ExtensionRegistry.ExtensionInfo(extension.getDescriptor(), extension.getMessageDefaultInstance());
         }
      } else {
         return new ExtensionRegistry.ExtensionInfo(extension.getDescriptor(), (Message)null);
      }
   }

   public void add(Descriptors.FieldDescriptor type) {
      if (type.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
         throw new IllegalArgumentException("ExtensionRegistry.add() must be provided a default instance when adding an embedded message extension.");
      } else {
         ExtensionRegistry.ExtensionInfo info = new ExtensionRegistry.ExtensionInfo(type, (Message)null);
         this.add(info, Extension.ExtensionType.IMMUTABLE);
         this.add(info, Extension.ExtensionType.MUTABLE);
      }
   }

   public void add(Descriptors.FieldDescriptor type, Message defaultInstance) {
      if (type.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) {
         throw new IllegalArgumentException("ExtensionRegistry.add() provided a default instance for a non-message extension.");
      } else {
         this.add(new ExtensionRegistry.ExtensionInfo(type, defaultInstance), Extension.ExtensionType.IMMUTABLE);
      }
   }

   private ExtensionRegistry() {
      this.immutableExtensionsByName = new HashMap();
      this.mutableExtensionsByName = new HashMap();
      this.immutableExtensionsByNumber = new HashMap();
      this.mutableExtensionsByNumber = new HashMap();
   }

   private ExtensionRegistry(ExtensionRegistry other) {
      super(other);
      this.immutableExtensionsByName = Collections.unmodifiableMap(other.immutableExtensionsByName);
      this.mutableExtensionsByName = Collections.unmodifiableMap(other.mutableExtensionsByName);
      this.immutableExtensionsByNumber = Collections.unmodifiableMap(other.immutableExtensionsByNumber);
      this.mutableExtensionsByNumber = Collections.unmodifiableMap(other.mutableExtensionsByNumber);
   }

   ExtensionRegistry(boolean empty) {
      super(EMPTY_REGISTRY_LITE);
      this.immutableExtensionsByName = Collections.emptyMap();
      this.mutableExtensionsByName = Collections.emptyMap();
      this.immutableExtensionsByNumber = Collections.emptyMap();
      this.mutableExtensionsByNumber = Collections.emptyMap();
   }

   private void add(ExtensionRegistry.ExtensionInfo extension, Extension.ExtensionType extensionType) {
      if (!extension.descriptor.isExtension()) {
         throw new IllegalArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
      } else {
         Map extensionsByName;
         Map extensionsByNumber;
         switch(extensionType) {
         case IMMUTABLE:
            extensionsByName = this.immutableExtensionsByName;
            extensionsByNumber = this.immutableExtensionsByNumber;
            break;
         case MUTABLE:
            extensionsByName = this.mutableExtensionsByName;
            extensionsByNumber = this.mutableExtensionsByNumber;
            break;
         default:
            return;
         }

         extensionsByName.put(extension.descriptor.getFullName(), extension);
         extensionsByNumber.put(new ExtensionRegistry.DescriptorIntPair(extension.descriptor.getContainingType(), extension.descriptor.getNumber()), extension);
         Descriptors.FieldDescriptor field = extension.descriptor;
         if (field.getContainingType().getOptions().getMessageSetWireFormat() && field.getType() == Descriptors.FieldDescriptor.Type.MESSAGE && field.isOptional() && field.getExtensionScope() == field.getMessageType()) {
            extensionsByName.put(field.getMessageType().getFullName(), extension);
         }

      }
   }

   private static final class DescriptorIntPair {
      private final Descriptors.Descriptor descriptor;
      private final int number;

      DescriptorIntPair(Descriptors.Descriptor descriptor, int number) {
         this.descriptor = descriptor;
         this.number = number;
      }

      public int hashCode() {
         return this.descriptor.hashCode() * '\uffff' + this.number;
      }

      public boolean equals(Object obj) {
         if (!(obj instanceof ExtensionRegistry.DescriptorIntPair)) {
            return false;
         } else {
            ExtensionRegistry.DescriptorIntPair other = (ExtensionRegistry.DescriptorIntPair)obj;
            return this.descriptor == other.descriptor && this.number == other.number;
         }
      }
   }

   public static final class ExtensionInfo {
      public final Descriptors.FieldDescriptor descriptor;
      public final Message defaultInstance;

      private ExtensionInfo(Descriptors.FieldDescriptor descriptor) {
         this.descriptor = descriptor;
         this.defaultInstance = null;
      }

      private ExtensionInfo(Descriptors.FieldDescriptor descriptor, Message defaultInstance) {
         this.descriptor = descriptor;
         this.defaultInstance = defaultInstance;
      }

      // $FF: synthetic method
      ExtensionInfo(Descriptors.FieldDescriptor x0, Message x1, Object x2) {
         this(x0, x1);
      }
   }
}
