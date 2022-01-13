package com.google.gson.internal.reflect;

import com.google.gson.internal.JavaVersion;
import java.lang.reflect.AccessibleObject;

public abstract class ReflectionAccessor {
   private static final ReflectionAccessor instance = JavaVersion.getMajorJavaVersion() < 9 ? new PreJava9ReflectionAccessor() : new UnsafeReflectionAccessor();

   public abstract void makeAccessible(AccessibleObject var1);

   public static ReflectionAccessor getInstance() {
      return instance;
   }
}
