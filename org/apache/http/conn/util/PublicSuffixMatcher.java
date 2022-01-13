package org.apache.http.conn.util;

import java.net.IDN;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(
   threading = ThreadingBehavior.SAFE
)
public final class PublicSuffixMatcher {
   private final Map rules;
   private final Map exceptions;

   public PublicSuffixMatcher(Collection rules, Collection exceptions) {
      this(DomainType.UNKNOWN, rules, exceptions);
   }

   public PublicSuffixMatcher(DomainType domainType, Collection rules, Collection exceptions) {
      Args.notNull(domainType, "Domain type");
      Args.notNull(rules, "Domain suffix rules");
      this.rules = new ConcurrentHashMap(rules.size());
      Iterator i$ = rules.iterator();

      String exception;
      while(i$.hasNext()) {
         exception = (String)i$.next();
         this.rules.put(exception, domainType);
      }

      this.exceptions = new ConcurrentHashMap();
      if (exceptions != null) {
         i$ = exceptions.iterator();

         while(i$.hasNext()) {
            exception = (String)i$.next();
            this.exceptions.put(exception, domainType);
         }
      }

   }

   public PublicSuffixMatcher(Collection lists) {
      Args.notNull(lists, "Domain suffix lists");
      this.rules = new ConcurrentHashMap();
      this.exceptions = new ConcurrentHashMap();
      Iterator i$ = lists.iterator();

      while(true) {
         DomainType domainType;
         List exceptions;
         do {
            if (!i$.hasNext()) {
               return;
            }

            PublicSuffixList list = (PublicSuffixList)i$.next();
            domainType = list.getType();
            List rules = list.getRules();
            Iterator i$ = rules.iterator();

            while(i$.hasNext()) {
               String rule = (String)i$.next();
               this.rules.put(rule, domainType);
            }

            exceptions = list.getExceptions();
         } while(exceptions == null);

         Iterator i$ = exceptions.iterator();

         while(i$.hasNext()) {
            String exception = (String)i$.next();
            this.exceptions.put(exception, domainType);
         }
      }
   }

   private static boolean hasEntry(Map map, String rule, DomainType expectedType) {
      if (map == null) {
         return false;
      } else {
         DomainType domainType = (DomainType)map.get(rule);
         return domainType == null ? false : expectedType == null || domainType.equals(expectedType);
      }
   }

   private boolean hasRule(String rule, DomainType expectedType) {
      return hasEntry(this.rules, rule, expectedType);
   }

   private boolean hasException(String exception, DomainType expectedType) {
      return hasEntry(this.exceptions, exception, expectedType);
   }

   public String getDomainRoot(String domain) {
      return this.getDomainRoot(domain, (DomainType)null);
   }

   public String getDomainRoot(String domain, DomainType expectedType) {
      if (domain == null) {
         return null;
      } else if (domain.startsWith(".")) {
         return null;
      } else {
         String domainName = null;

         String nextSegment;
         for(String segment = domain.toLowerCase(Locale.ROOT); segment != null; segment = nextSegment) {
            if (this.hasException(IDN.toUnicode(segment), expectedType)) {
               return segment;
            }

            if (this.hasRule(IDN.toUnicode(segment), expectedType)) {
               break;
            }

            int nextdot = segment.indexOf(46);
            nextSegment = nextdot != -1 ? segment.substring(nextdot + 1) : null;
            if (nextSegment != null && this.hasRule("*." + IDN.toUnicode(nextSegment), expectedType)) {
               break;
            }

            if (nextdot != -1) {
               domainName = segment;
            }
         }

         return domainName;
      }
   }

   public boolean matches(String domain) {
      return this.matches(domain, (DomainType)null);
   }

   public boolean matches(String domain, DomainType expectedType) {
      if (domain == null) {
         return false;
      } else {
         String domainRoot = this.getDomainRoot(domain.startsWith(".") ? domain.substring(1) : domain, expectedType);
         return domainRoot == null;
      }
   }
}
