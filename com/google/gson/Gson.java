package com.google.gson;

import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.Primitives;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.internal.bind.JsonTreeWriter;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.google.gson.internal.bind.TimeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class Gson {
   static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
   static final boolean DEFAULT_LENIENT = false;
   static final boolean DEFAULT_PRETTY_PRINT = false;
   static final boolean DEFAULT_ESCAPE_HTML = true;
   static final boolean DEFAULT_SERIALIZE_NULLS = false;
   static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
   static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
   private static final TypeToken NULL_KEY_SURROGATE = TypeToken.get(Object.class);
   private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
   private final ThreadLocal calls;
   private final Map typeTokenCache;
   private final ConstructorConstructor constructorConstructor;
   private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
   final List factories;
   final Excluder excluder;
   final FieldNamingStrategy fieldNamingStrategy;
   final Map instanceCreators;
   final boolean serializeNulls;
   final boolean complexMapKeySerialization;
   final boolean generateNonExecutableJson;
   final boolean htmlSafe;
   final boolean prettyPrinting;
   final boolean lenient;
   final boolean serializeSpecialFloatingPointValues;
   final String datePattern;
   final int dateStyle;
   final int timeStyle;
   final LongSerializationPolicy longSerializationPolicy;
   final List builderFactories;
   final List builderHierarchyFactories;

   public Gson() {
      this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, (String)null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
   }

   Gson(Excluder excluder, FieldNamingStrategy fieldNamingStrategy, Map instanceCreators, boolean serializeNulls, boolean complexMapKeySerialization, boolean generateNonExecutableGson, boolean htmlSafe, boolean prettyPrinting, boolean lenient, boolean serializeSpecialFloatingPointValues, LongSerializationPolicy longSerializationPolicy, String datePattern, int dateStyle, int timeStyle, List builderFactories, List builderHierarchyFactories, List factoriesToBeAdded) {
      this.calls = new ThreadLocal();
      this.typeTokenCache = new ConcurrentHashMap();
      this.excluder = excluder;
      this.fieldNamingStrategy = fieldNamingStrategy;
      this.instanceCreators = instanceCreators;
      this.constructorConstructor = new ConstructorConstructor(instanceCreators);
      this.serializeNulls = serializeNulls;
      this.complexMapKeySerialization = complexMapKeySerialization;
      this.generateNonExecutableJson = generateNonExecutableGson;
      this.htmlSafe = htmlSafe;
      this.prettyPrinting = prettyPrinting;
      this.lenient = lenient;
      this.serializeSpecialFloatingPointValues = serializeSpecialFloatingPointValues;
      this.longSerializationPolicy = longSerializationPolicy;
      this.datePattern = datePattern;
      this.dateStyle = dateStyle;
      this.timeStyle = timeStyle;
      this.builderFactories = builderFactories;
      this.builderHierarchyFactories = builderHierarchyFactories;
      List factories = new ArrayList();
      factories.add(TypeAdapters.JSON_ELEMENT_FACTORY);
      factories.add(ObjectTypeAdapter.FACTORY);
      factories.add(excluder);
      factories.addAll(factoriesToBeAdded);
      factories.add(TypeAdapters.STRING_FACTORY);
      factories.add(TypeAdapters.INTEGER_FACTORY);
      factories.add(TypeAdapters.BOOLEAN_FACTORY);
      factories.add(TypeAdapters.BYTE_FACTORY);
      factories.add(TypeAdapters.SHORT_FACTORY);
      TypeAdapter longAdapter = longAdapter(longSerializationPolicy);
      factories.add(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter));
      factories.add(TypeAdapters.newFactory(Double.TYPE, Double.class, this.doubleAdapter(serializeSpecialFloatingPointValues)));
      factories.add(TypeAdapters.newFactory(Float.TYPE, Float.class, this.floatAdapter(serializeSpecialFloatingPointValues)));
      factories.add(TypeAdapters.NUMBER_FACTORY);
      factories.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
      factories.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
      factories.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(longAdapter)));
      factories.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(longAdapter)));
      factories.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
      factories.add(TypeAdapters.CHARACTER_FACTORY);
      factories.add(TypeAdapters.STRING_BUILDER_FACTORY);
      factories.add(TypeAdapters.STRING_BUFFER_FACTORY);
      factories.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
      factories.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
      factories.add(TypeAdapters.URL_FACTORY);
      factories.add(TypeAdapters.URI_FACTORY);
      factories.add(TypeAdapters.UUID_FACTORY);
      factories.add(TypeAdapters.CURRENCY_FACTORY);
      factories.add(TypeAdapters.LOCALE_FACTORY);
      factories.add(TypeAdapters.INET_ADDRESS_FACTORY);
      factories.add(TypeAdapters.BIT_SET_FACTORY);
      factories.add(DateTypeAdapter.FACTORY);
      factories.add(TypeAdapters.CALENDAR_FACTORY);
      factories.add(TimeTypeAdapter.FACTORY);
      factories.add(SqlDateTypeAdapter.FACTORY);
      factories.add(TypeAdapters.TIMESTAMP_FACTORY);
      factories.add(ArrayTypeAdapter.FACTORY);
      factories.add(TypeAdapters.CLASS_FACTORY);
      factories.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
      factories.add(new MapTypeAdapterFactory(this.constructorConstructor, complexMapKeySerialization));
      this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
      factories.add(this.jsonAdapterFactory);
      factories.add(TypeAdapters.ENUM_FACTORY);
      factories.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, fieldNamingStrategy, excluder, this.jsonAdapterFactory));
      this.factories = Collections.unmodifiableList(factories);
   }

   public GsonBuilder newBuilder() {
      return new GsonBuilder(this);
   }

   public Excluder excluder() {
      return this.excluder;
   }

   public FieldNamingStrategy fieldNamingStrategy() {
      return this.fieldNamingStrategy;
   }

   public boolean serializeNulls() {
      return this.serializeNulls;
   }

   public boolean htmlSafe() {
      return this.htmlSafe;
   }

   private TypeAdapter doubleAdapter(boolean serializeSpecialFloatingPointValues) {
      return serializeSpecialFloatingPointValues ? TypeAdapters.DOUBLE : new TypeAdapter() {
         public Double read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
               in.nextNull();
               return null;
            } else {
               return in.nextDouble();
            }
         }

         public void write(JsonWriter out, Number value) throws IOException {
            if (value == null) {
               out.nullValue();
            } else {
               double doubleValue = value.doubleValue();
               Gson.checkValidFloatingPoint(doubleValue);
               out.value(value);
            }
         }
      };
   }

   private TypeAdapter floatAdapter(boolean serializeSpecialFloatingPointValues) {
      return serializeSpecialFloatingPointValues ? TypeAdapters.FLOAT : new TypeAdapter() {
         public Float read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
               in.nextNull();
               return null;
            } else {
               return (float)in.nextDouble();
            }
         }

         public void write(JsonWriter out, Number value) throws IOException {
            if (value == null) {
               out.nullValue();
            } else {
               float floatValue = value.floatValue();
               Gson.checkValidFloatingPoint((double)floatValue);
               out.value(value);
            }
         }
      };
   }

   static void checkValidFloatingPoint(double value) {
      if (Double.isNaN(value) || Double.isInfinite(value)) {
         throw new IllegalArgumentException(value + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
      }
   }

   private static TypeAdapter longAdapter(LongSerializationPolicy longSerializationPolicy) {
      return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? TypeAdapters.LONG : new TypeAdapter() {
         public Number read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
               in.nextNull();
               return null;
            } else {
               return in.nextLong();
            }
         }

         public void write(JsonWriter out, Number value) throws IOException {
            if (value == null) {
               out.nullValue();
            } else {
               out.value(value.toString());
            }
         }
      };
   }

   private static TypeAdapter atomicLongAdapter(final TypeAdapter longAdapter) {
      return (new TypeAdapter() {
         public void write(JsonWriter out, AtomicLong value) throws IOException {
            longAdapter.write(out, value.get());
         }

         public AtomicLong read(JsonReader in) throws IOException {
            Number value = (Number)longAdapter.read(in);
            return new AtomicLong(value.longValue());
         }
      }).nullSafe();
   }

   private static TypeAdapter atomicLongArrayAdapter(final TypeAdapter longAdapter) {
      return (new TypeAdapter() {
         public void write(JsonWriter out, AtomicLongArray value) throws IOException {
            out.beginArray();
            int i = 0;

            for(int length = value.length(); i < length; ++i) {
               longAdapter.write(out, value.get(i));
            }

            out.endArray();
         }

         public AtomicLongArray read(JsonReader in) throws IOException {
            List list = new ArrayList();
            in.beginArray();

            while(in.hasNext()) {
               long value = ((Number)longAdapter.read(in)).longValue();
               list.add(value);
            }

            in.endArray();
            int length = list.size();
            AtomicLongArray array = new AtomicLongArray(length);

            for(int i = 0; i < length; ++i) {
               array.set(i, (Long)list.get(i));
            }

            return array;
         }
      }).nullSafe();
   }

   public TypeAdapter getAdapter(TypeToken type) {
      TypeAdapter cached = (TypeAdapter)this.typeTokenCache.get(type == null ? NULL_KEY_SURROGATE : type);
      if (cached != null) {
         return cached;
      } else {
         Map threadCalls = (Map)this.calls.get();
         boolean requiresThreadLocalCleanup = false;
         if (threadCalls == null) {
            threadCalls = new HashMap();
            this.calls.set(threadCalls);
            requiresThreadLocalCleanup = true;
         }

         Gson.FutureTypeAdapter ongoingCall = (Gson.FutureTypeAdapter)((Map)threadCalls).get(type);
         if (ongoingCall != null) {
            return ongoingCall;
         } else {
            try {
               Gson.FutureTypeAdapter call = new Gson.FutureTypeAdapter();
               ((Map)threadCalls).put(type, call);
               Iterator var7 = this.factories.iterator();

               TypeAdapter candidate;
               do {
                  if (!var7.hasNext()) {
                     throw new IllegalArgumentException("GSON (2.8.6) cannot handle " + type);
                  }

                  TypeAdapterFactory factory = (TypeAdapterFactory)var7.next();
                  candidate = factory.create(this, type);
               } while(candidate == null);

               call.setDelegate(candidate);
               this.typeTokenCache.put(type, candidate);
               TypeAdapter var10 = candidate;
               return var10;
            } finally {
               ((Map)threadCalls).remove(type);
               if (requiresThreadLocalCleanup) {
                  this.calls.remove();
               }

            }
         }
      }
   }

   public TypeAdapter getDelegateAdapter(TypeAdapterFactory skipPast, TypeToken type) {
      if (!this.factories.contains(skipPast)) {
         skipPast = this.jsonAdapterFactory;
      }

      boolean skipPastFound = false;
      Iterator var4 = this.factories.iterator();

      while(var4.hasNext()) {
         TypeAdapterFactory factory = (TypeAdapterFactory)var4.next();
         if (!skipPastFound) {
            if (factory == skipPast) {
               skipPastFound = true;
            }
         } else {
            TypeAdapter candidate = factory.create(this, type);
            if (candidate != null) {
               return candidate;
            }
         }
      }

      throw new IllegalArgumentException("GSON cannot serialize " + type);
   }

   public TypeAdapter getAdapter(Class type) {
      return this.getAdapter(TypeToken.get(type));
   }

   public JsonElement toJsonTree(Object src) {
      return (JsonElement)(src == null ? JsonNull.INSTANCE : this.toJsonTree(src, src.getClass()));
   }

   public JsonElement toJsonTree(Object src, Type typeOfSrc) {
      JsonTreeWriter writer = new JsonTreeWriter();
      this.toJson(src, typeOfSrc, (JsonWriter)writer);
      return writer.get();
   }

   public String toJson(Object src) {
      return src == null ? this.toJson((JsonElement)JsonNull.INSTANCE) : this.toJson((Object)src, (Type)src.getClass());
   }

   public String toJson(Object src, Type typeOfSrc) {
      StringWriter writer = new StringWriter();
      this.toJson(src, typeOfSrc, (Appendable)writer);
      return writer.toString();
   }

   public void toJson(Object src, Appendable writer) throws JsonIOException {
      if (src != null) {
         this.toJson(src, src.getClass(), (Appendable)writer);
      } else {
         this.toJson((JsonElement)JsonNull.INSTANCE, (Appendable)writer);
      }

   }

   public void toJson(Object src, Type typeOfSrc, Appendable writer) throws JsonIOException {
      try {
         JsonWriter jsonWriter = this.newJsonWriter(Streams.writerForAppendable(writer));
         this.toJson(src, typeOfSrc, jsonWriter);
      } catch (IOException var5) {
         throw new JsonIOException(var5);
      }
   }

   public void toJson(Object src, Type typeOfSrc, JsonWriter writer) throws JsonIOException {
      TypeAdapter adapter = this.getAdapter(TypeToken.get(typeOfSrc));
      boolean oldLenient = writer.isLenient();
      writer.setLenient(true);
      boolean oldHtmlSafe = writer.isHtmlSafe();
      writer.setHtmlSafe(this.htmlSafe);
      boolean oldSerializeNulls = writer.getSerializeNulls();
      writer.setSerializeNulls(this.serializeNulls);

      try {
         adapter.write(writer, src);
      } catch (IOException var14) {
         throw new JsonIOException(var14);
      } catch (AssertionError var15) {
         AssertionError error = new AssertionError("AssertionError (GSON 2.8.6): " + var15.getMessage());
         error.initCause(var15);
         throw error;
      } finally {
         writer.setLenient(oldLenient);
         writer.setHtmlSafe(oldHtmlSafe);
         writer.setSerializeNulls(oldSerializeNulls);
      }

   }

   public String toJson(JsonElement jsonElement) {
      StringWriter writer = new StringWriter();
      this.toJson((JsonElement)jsonElement, (Appendable)writer);
      return writer.toString();
   }

   public void toJson(JsonElement jsonElement, Appendable writer) throws JsonIOException {
      try {
         JsonWriter jsonWriter = this.newJsonWriter(Streams.writerForAppendable(writer));
         this.toJson(jsonElement, jsonWriter);
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      }
   }

   public JsonWriter newJsonWriter(Writer writer) throws IOException {
      if (this.generateNonExecutableJson) {
         writer.write(")]}'\n");
      }

      JsonWriter jsonWriter = new JsonWriter(writer);
      if (this.prettyPrinting) {
         jsonWriter.setIndent("  ");
      }

      jsonWriter.setSerializeNulls(this.serializeNulls);
      return jsonWriter;
   }

   public JsonReader newJsonReader(Reader reader) {
      JsonReader jsonReader = new JsonReader(reader);
      jsonReader.setLenient(this.lenient);
      return jsonReader;
   }

   public void toJson(JsonElement jsonElement, JsonWriter writer) throws JsonIOException {
      boolean oldLenient = writer.isLenient();
      writer.setLenient(true);
      boolean oldHtmlSafe = writer.isHtmlSafe();
      writer.setHtmlSafe(this.htmlSafe);
      boolean oldSerializeNulls = writer.getSerializeNulls();
      writer.setSerializeNulls(this.serializeNulls);

      try {
         Streams.write(jsonElement, writer);
      } catch (IOException var12) {
         throw new JsonIOException(var12);
      } catch (AssertionError var13) {
         AssertionError error = new AssertionError("AssertionError (GSON 2.8.6): " + var13.getMessage());
         error.initCause(var13);
         throw error;
      } finally {
         writer.setLenient(oldLenient);
         writer.setHtmlSafe(oldHtmlSafe);
         writer.setSerializeNulls(oldSerializeNulls);
      }

   }

   public Object fromJson(String json, Class classOfT) throws JsonSyntaxException {
      Object object = this.fromJson((String)json, (Type)classOfT);
      return Primitives.wrap(classOfT).cast(object);
   }

   public Object fromJson(String json, Type typeOfT) throws JsonSyntaxException {
      if (json == null) {
         return null;
      } else {
         StringReader reader = new StringReader(json);
         Object target = this.fromJson((Reader)reader, (Type)typeOfT);
         return target;
      }
   }

   public Object fromJson(Reader json, Class classOfT) throws JsonSyntaxException, JsonIOException {
      JsonReader jsonReader = this.newJsonReader(json);
      Object object = this.fromJson((JsonReader)jsonReader, (Type)classOfT);
      assertFullConsumption(object, jsonReader);
      return Primitives.wrap(classOfT).cast(object);
   }

   public Object fromJson(Reader json, Type typeOfT) throws JsonIOException, JsonSyntaxException {
      JsonReader jsonReader = this.newJsonReader(json);
      Object object = this.fromJson(jsonReader, typeOfT);
      assertFullConsumption(object, jsonReader);
      return object;
   }

   private static void assertFullConsumption(Object obj, JsonReader reader) {
      try {
         if (obj != null && reader.peek() != JsonToken.END_DOCUMENT) {
            throw new JsonIOException("JSON document was not fully consumed.");
         }
      } catch (MalformedJsonException var3) {
         throw new JsonSyntaxException(var3);
      } catch (IOException var4) {
         throw new JsonIOException(var4);
      }
   }

   public Object fromJson(JsonReader reader, Type typeOfT) throws JsonIOException, JsonSyntaxException {
      boolean isEmpty = true;
      boolean oldLenient = reader.isLenient();
      reader.setLenient(true);

      AssertionError error;
      try {
         try {
            reader.peek();
            isEmpty = false;
            TypeToken typeToken = TypeToken.get(typeOfT);
            TypeAdapter typeAdapter = this.getAdapter(typeToken);
            Object object = typeAdapter.read(reader);
            Object var8 = object;
            return var8;
         } catch (EOFException var15) {
            if (!isEmpty) {
               throw new JsonSyntaxException(var15);
            }
         } catch (IllegalStateException var16) {
            throw new JsonSyntaxException(var16);
         } catch (IOException var17) {
            throw new JsonSyntaxException(var17);
         } catch (AssertionError var18) {
            error = new AssertionError("AssertionError (GSON 2.8.6): " + var18.getMessage());
            error.initCause(var18);
            throw error;
         }

         error = null;
      } finally {
         reader.setLenient(oldLenient);
      }

      return error;
   }

   public Object fromJson(JsonElement json, Class classOfT) throws JsonSyntaxException {
      Object object = this.fromJson((JsonElement)json, (Type)classOfT);
      return Primitives.wrap(classOfT).cast(object);
   }

   public Object fromJson(JsonElement json, Type typeOfT) throws JsonSyntaxException {
      return json == null ? null : this.fromJson((JsonReader)(new JsonTreeReader(json)), (Type)typeOfT);
   }

   public String toString() {
      return "{serializeNulls:" + this.serializeNulls + ",factories:" + this.factories + ",instanceCreators:" + this.constructorConstructor + "}";
   }

   static class FutureTypeAdapter extends TypeAdapter {
      private TypeAdapter delegate;

      public void setDelegate(TypeAdapter typeAdapter) {
         if (this.delegate != null) {
            throw new AssertionError();
         } else {
            this.delegate = typeAdapter;
         }
      }

      public Object read(JsonReader in) throws IOException {
         if (this.delegate == null) {
            throw new IllegalStateException();
         } else {
            return this.delegate.read(in);
         }
      }

      public void write(JsonWriter out, Object value) throws IOException {
         if (this.delegate == null) {
            throw new IllegalStateException();
         } else {
            this.delegate.write(out, value);
         }
      }
   }
}
