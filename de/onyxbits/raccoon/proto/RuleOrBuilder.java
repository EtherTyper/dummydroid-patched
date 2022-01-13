package de.onyxbits.raccoon.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface RuleOrBuilder extends MessageOrBuilder {
   boolean hasNegate();

   boolean getNegate();

   boolean hasOperator();

   int getOperator();

   boolean hasKey();

   int getKey();

   List getStringArgList();

   int getStringArgCount();

   String getStringArg(int var1);

   ByteString getStringArgBytes(int var1);

   List getLongArgList();

   int getLongArgCount();

   long getLongArg(int var1);

   List getDoubleArgList();

   int getDoubleArgCount();

   double getDoubleArg(int var1);

   List getSubruleList();

   Rule getSubrule(int var1);

   int getSubruleCount();

   List getSubruleOrBuilderList();

   RuleOrBuilder getSubruleOrBuilder(int var1);

   boolean hasResponseCode();

   int getResponseCode();

   boolean hasComment();

   String getComment();

   ByteString getCommentBytes();

   List getStringArgHashList();

   int getStringArgHashCount();

   long getStringArgHash(int var1);

   List getConstArgList();

   int getConstArgCount();

   int getConstArg(int var1);
}
