package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

public final class JsonTreeReader extends JsonReader {
   private static final Reader UNREADABLE_READER = new Reader() {
      public int read(char[] buffer, int offset, int count) throws IOException {
         throw new AssertionError();
      }

      public void close() throws IOException {
         throw new AssertionError();
      }
   };
   private static final Object SENTINEL_CLOSED = new Object();
   private Object[] stack = new Object[32];
   private int stackSize = 0;
   private String[] pathNames = new String[32];
   private int[] pathIndices = new int[32];

   public JsonTreeReader(JsonElement element) {
      super(UNREADABLE_READER);
      this.push(element);
   }

   public void beginArray() throws IOException {
      this.expect(JsonToken.BEGIN_ARRAY);
      JsonArray array = (JsonArray)this.peekStack();
      this.push(array.iterator());
      this.pathIndices[this.stackSize - 1] = 0;
   }

   public void endArray() throws IOException {
      this.expect(JsonToken.END_ARRAY);
      this.popStack();
      this.popStack();
      if (this.stackSize > 0) {
         int var10002 = this.pathIndices[this.stackSize - 1]++;
      }

   }

   public void beginObject() throws IOException {
      this.expect(JsonToken.BEGIN_OBJECT);
      JsonObject object = (JsonObject)this.peekStack();
      this.push(object.entrySet().iterator());
   }

   public void endObject() throws IOException {
      this.expect(JsonToken.END_OBJECT);
      this.popStack();
      this.popStack();
      if (this.stackSize > 0) {
         int var10002 = this.pathIndices[this.stackSize - 1]++;
      }

   }

   public boolean hasNext() throws IOException {
      JsonToken token = this.peek();
      return token != JsonToken.END_OBJECT && token != JsonToken.END_ARRAY;
   }

   public JsonToken peek() throws IOException {
      if (this.stackSize == 0) {
         return JsonToken.END_DOCUMENT;
      } else {
         Object o = this.peekStack();
         if (o instanceof Iterator) {
            boolean isObject = this.stack[this.stackSize - 2] instanceof JsonObject;
            Iterator iterator = (Iterator)o;
            if (iterator.hasNext()) {
               if (isObject) {
                  return JsonToken.NAME;
               } else {
                  this.push(iterator.next());
                  return this.peek();
               }
            } else {
               return isObject ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
         } else if (o instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
         } else if (o instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
         } else if (o instanceof JsonPrimitive) {
            JsonPrimitive primitive = (JsonPrimitive)o;
            if (primitive.isString()) {
               return JsonToken.STRING;
            } else if (primitive.isBoolean()) {
               return JsonToken.BOOLEAN;
            } else if (primitive.isNumber()) {
               return JsonToken.NUMBER;
            } else {
               throw new AssertionError();
            }
         } else if (o instanceof JsonNull) {
            return JsonToken.NULL;
         } else if (o == SENTINEL_CLOSED) {
            throw new IllegalStateException("JsonReader is closed");
         } else {
            throw new AssertionError();
         }
      }
   }

   private Object peekStack() {
      return this.stack[this.stackSize - 1];
   }

   private Object popStack() {
      Object result = this.stack[--this.stackSize];
      this.stack[this.stackSize] = null;
      return result;
   }

   private void expect(JsonToken expected) throws IOException {
      if (this.peek() != expected) {
         throw new IllegalStateException("Expected " + expected + " but was " + this.peek() + this.locationString());
      }
   }

   public String nextName() throws IOException {
      this.expect(JsonToken.NAME);
      Iterator i = (Iterator)this.peekStack();
      Entry entry = (Entry)i.next();
      String result = (String)entry.getKey();
      this.pathNames[this.stackSize - 1] = result;
      this.push(entry.getValue());
      return result;
   }

   public String nextString() throws IOException {
      JsonToken token = this.peek();
      if (token != JsonToken.STRING && token != JsonToken.NUMBER) {
         throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + token + this.locationString());
      } else {
         String result = ((JsonPrimitive)this.popStack()).getAsString();
         if (this.stackSize > 0) {
            int var10002 = this.pathIndices[this.stackSize - 1]++;
         }

         return result;
      }
   }

   public boolean nextBoolean() throws IOException {
      this.expect(JsonToken.BOOLEAN);
      boolean result = ((JsonPrimitive)this.popStack()).getAsBoolean();
      if (this.stackSize > 0) {
         int var10002 = this.pathIndices[this.stackSize - 1]++;
      }

      return result;
   }

   public void nextNull() throws IOException {
      this.expect(JsonToken.NULL);
      this.popStack();
      if (this.stackSize > 0) {
         int var10002 = this.pathIndices[this.stackSize - 1]++;
      }

   }

   public double nextDouble() throws IOException {
      JsonToken token = this.peek();
      if (token != JsonToken.NUMBER && token != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token + this.locationString());
      } else {
         double result = ((JsonPrimitive)this.peekStack()).getAsDouble();
         if (this.isLenient() || !Double.isNaN(result) && !Double.isInfinite(result)) {
            this.popStack();
            if (this.stackSize > 0) {
               int var10002 = this.pathIndices[this.stackSize - 1]++;
            }

            return result;
         } else {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + result);
         }
      }
   }

   public long nextLong() throws IOException {
      JsonToken token = this.peek();
      if (token != JsonToken.NUMBER && token != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token + this.locationString());
      } else {
         long result = ((JsonPrimitive)this.peekStack()).getAsLong();
         this.popStack();
         if (this.stackSize > 0) {
            int var10002 = this.pathIndices[this.stackSize - 1]++;
         }

         return result;
      }
   }

   public int nextInt() throws IOException {
      JsonToken token = this.peek();
      if (token != JsonToken.NUMBER && token != JsonToken.STRING) {
         throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + token + this.locationString());
      } else {
         int result = ((JsonPrimitive)this.peekStack()).getAsInt();
         this.popStack();
         if (this.stackSize > 0) {
            int var10002 = this.pathIndices[this.stackSize - 1]++;
         }

         return result;
      }
   }

   public void close() throws IOException {
      this.stack = new Object[]{SENTINEL_CLOSED};
      this.stackSize = 1;
   }

   public void skipValue() throws IOException {
      if (this.peek() == JsonToken.NAME) {
         this.nextName();
         this.pathNames[this.stackSize - 2] = "null";
      } else {
         this.popStack();
         if (this.stackSize > 0) {
            this.pathNames[this.stackSize - 1] = "null";
         }
      }

      if (this.stackSize > 0) {
         int var10002 = this.pathIndices[this.stackSize - 1]++;
      }

   }

   public String toString() {
      return this.getClass().getSimpleName();
   }

   public void promoteNameToValue() throws IOException {
      this.expect(JsonToken.NAME);
      Iterator i = (Iterator)this.peekStack();
      Entry entry = (Entry)i.next();
      this.push(entry.getValue());
      this.push(new JsonPrimitive((String)entry.getKey()));
   }

   private void push(Object newTop) {
      if (this.stackSize == this.stack.length) {
         int newLength = this.stackSize * 2;
         this.stack = Arrays.copyOf(this.stack, newLength);
         this.pathIndices = Arrays.copyOf(this.pathIndices, newLength);
         this.pathNames = (String[])Arrays.copyOf(this.pathNames, newLength);
      }

      this.stack[this.stackSize++] = newTop;
   }

   public String getPath() {
      StringBuilder result = (new StringBuilder()).append('$');

      for(int i = 0; i < this.stackSize; ++i) {
         if (this.stack[i] instanceof JsonArray) {
            ++i;
            if (this.stack[i] instanceof Iterator) {
               result.append('[').append(this.pathIndices[i]).append(']');
            }
         } else if (this.stack[i] instanceof JsonObject) {
            ++i;
            if (this.stack[i] instanceof Iterator) {
               result.append('.');
               if (this.pathNames[i] != null) {
                  result.append(this.pathNames[i]);
               }
            }
         }
      }

      return result.toString();
   }

   private String locationString() {
      return " at path " + this.getPath();
   }
}
