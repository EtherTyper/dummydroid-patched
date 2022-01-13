package de.onyxbits.raccoon.finsky;

import de.onyxbits.raccoon.proto.ResponseWrapper;

class CacheEntry {
   long ttl;
   long softTtl;
   public ResponseWrapper content;
}
