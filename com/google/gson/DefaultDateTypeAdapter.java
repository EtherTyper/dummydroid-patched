package com.google.gson;

import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

final class DefaultDateTypeAdapter extends TypeAdapter {
   private static final String SIMPLE_NAME = "DefaultDateTypeAdapter";
   private final Class dateType;
   private final List dateFormats;

   DefaultDateTypeAdapter(Class dateType) {
      this.dateFormats = new ArrayList();
      this.dateType = verifyDateType(dateType);
      this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
      if (!Locale.getDefault().equals(Locale.US)) {
         this.dateFormats.add(DateFormat.getDateTimeInstance(2, 2));
      }

      if (JavaVersion.isJava9OrLater()) {
         this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(2, 2));
      }

   }

   DefaultDateTypeAdapter(Class dateType, String datePattern) {
      this.dateFormats = new ArrayList();
      this.dateType = verifyDateType(dateType);
      this.dateFormats.add(new SimpleDateFormat(datePattern, Locale.US));
      if (!Locale.getDefault().equals(Locale.US)) {
         this.dateFormats.add(new SimpleDateFormat(datePattern));
      }

   }

   DefaultDateTypeAdapter(Class dateType, int style) {
      this.dateFormats = new ArrayList();
      this.dateType = verifyDateType(dateType);
      this.dateFormats.add(DateFormat.getDateInstance(style, Locale.US));
      if (!Locale.getDefault().equals(Locale.US)) {
         this.dateFormats.add(DateFormat.getDateInstance(style));
      }

      if (JavaVersion.isJava9OrLater()) {
         this.dateFormats.add(PreJava9DateFormatProvider.getUSDateFormat(style));
      }

   }

   public DefaultDateTypeAdapter(int dateStyle, int timeStyle) {
      this(Date.class, dateStyle, timeStyle);
   }

   public DefaultDateTypeAdapter(Class dateType, int dateStyle, int timeStyle) {
      this.dateFormats = new ArrayList();
      this.dateType = verifyDateType(dateType);
      this.dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle, Locale.US));
      if (!Locale.getDefault().equals(Locale.US)) {
         this.dateFormats.add(DateFormat.getDateTimeInstance(dateStyle, timeStyle));
      }

      if (JavaVersion.isJava9OrLater()) {
         this.dateFormats.add(PreJava9DateFormatProvider.getUSDateTimeFormat(dateStyle, timeStyle));
      }

   }

   private static Class verifyDateType(Class dateType) {
      if (dateType != Date.class && dateType != java.sql.Date.class && dateType != Timestamp.class) {
         throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + dateType);
      } else {
         return dateType;
      }
   }

   public void write(JsonWriter out, Date value) throws IOException {
      if (value == null) {
         out.nullValue();
      } else {
         synchronized(this.dateFormats) {
            String dateFormatAsString = ((DateFormat)this.dateFormats.get(0)).format(value);
            out.value(dateFormatAsString);
         }
      }
   }

   public Date read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
         in.nextNull();
         return null;
      } else {
         Date date = this.deserializeToDate(in.nextString());
         if (this.dateType == Date.class) {
            return date;
         } else if (this.dateType == Timestamp.class) {
            return new Timestamp(date.getTime());
         } else if (this.dateType == java.sql.Date.class) {
            return new java.sql.Date(date.getTime());
         } else {
            throw new AssertionError();
         }
      }
   }

   private Date deserializeToDate(String s) {
      synchronized(this.dateFormats) {
         Iterator var3 = this.dateFormats.iterator();

         while(true) {
            Date var10000;
            if (var3.hasNext()) {
               DateFormat dateFormat = (DateFormat)var3.next();

               try {
                  var10000 = dateFormat.parse(s);
               } catch (ParseException var8) {
                  continue;
               }

               return var10000;
            }

            try {
               var10000 = ISO8601Utils.parse(s, new ParsePosition(0));
            } catch (ParseException var7) {
               throw new JsonSyntaxException(s, var7);
            }

            return var10000;
         }
      }
   }

   public String toString() {
      DateFormat defaultFormat = (DateFormat)this.dateFormats.get(0);
      return defaultFormat instanceof SimpleDateFormat ? "DefaultDateTypeAdapter(" + ((SimpleDateFormat)defaultFormat).toPattern() + ')' : "DefaultDateTypeAdapter(" + defaultFormat.getClass().getSimpleName() + ')';
   }
}
