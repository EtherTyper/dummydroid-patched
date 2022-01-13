package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

final class PreJava9ReflectionAccessor extends ReflectionAccessor {
   public void makeAccessible(AccessibleObject ao) {
      ao.setAccessible(true);
   }
}
