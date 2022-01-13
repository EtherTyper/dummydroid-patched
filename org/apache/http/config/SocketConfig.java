package org.apache.http.config;

import org.apache.http.annotation.Contract;
import org.apache.http.annotation.ThreadingBehavior;
import org.apache.http.util.Args;

@Contract(
   threading = ThreadingBehavior.IMMUTABLE
)
public class SocketConfig implements Cloneable {
   public static final SocketConfig DEFAULT = (new SocketConfig.Builder()).build();
   private final int soTimeout;
   private final boolean soReuseAddress;
   private final int soLinger;
   private final boolean soKeepAlive;
   private final boolean tcpNoDelay;
   private final int sndBufSize;
   private final int rcvBufSize;
   private final int backlogSize;

   SocketConfig(int soTimeout, boolean soReuseAddress, int soLinger, boolean soKeepAlive, boolean tcpNoDelay, int sndBufSize, int rcvBufSize, int backlogSize) {
      this.soTimeout = soTimeout;
      this.soReuseAddress = soReuseAddress;
      this.soLinger = soLinger;
      this.soKeepAlive = soKeepAlive;
      this.tcpNoDelay = tcpNoDelay;
      this.sndBufSize = sndBufSize;
      this.rcvBufSize = rcvBufSize;
      this.backlogSize = backlogSize;
   }

   public int getSoTimeout() {
      return this.soTimeout;
   }

   public boolean isSoReuseAddress() {
      return this.soReuseAddress;
   }

   public int getSoLinger() {
      return this.soLinger;
   }

   public boolean isSoKeepAlive() {
      return this.soKeepAlive;
   }

   public boolean isTcpNoDelay() {
      return this.tcpNoDelay;
   }

   public int getSndBufSize() {
      return this.sndBufSize;
   }

   public int getRcvBufSize() {
      return this.rcvBufSize;
   }

   public int getBacklogSize() {
      return this.backlogSize;
   }

   protected SocketConfig clone() throws CloneNotSupportedException {
      return (SocketConfig)super.clone();
   }

   public String toString() {
      StringBuilder builder = new StringBuilder();
      builder.append("[soTimeout=").append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append(", sndBufSize=").append(this.sndBufSize).append(", rcvBufSize=").append(this.rcvBufSize).append(", backlogSize=").append(this.backlogSize).append("]");
      return builder.toString();
   }

   public static SocketConfig.Builder custom() {
      return new SocketConfig.Builder();
   }

   public static SocketConfig.Builder copy(SocketConfig config) {
      Args.notNull(config, "Socket config");
      return (new SocketConfig.Builder()).setSoTimeout(config.getSoTimeout()).setSoReuseAddress(config.isSoReuseAddress()).setSoLinger(config.getSoLinger()).setSoKeepAlive(config.isSoKeepAlive()).setTcpNoDelay(config.isTcpNoDelay()).setSndBufSize(config.getSndBufSize()).setRcvBufSize(config.getRcvBufSize()).setBacklogSize(config.getBacklogSize());
   }

   public static class Builder {
      private int soTimeout;
      private boolean soReuseAddress;
      private int soLinger = -1;
      private boolean soKeepAlive;
      private boolean tcpNoDelay = true;
      private int sndBufSize;
      private int rcvBufSize;
      private int backlogSize;

      Builder() {
      }

      public SocketConfig.Builder setSoTimeout(int soTimeout) {
         this.soTimeout = soTimeout;
         return this;
      }

      public SocketConfig.Builder setSoReuseAddress(boolean soReuseAddress) {
         this.soReuseAddress = soReuseAddress;
         return this;
      }

      public SocketConfig.Builder setSoLinger(int soLinger) {
         this.soLinger = soLinger;
         return this;
      }

      public SocketConfig.Builder setSoKeepAlive(boolean soKeepAlive) {
         this.soKeepAlive = soKeepAlive;
         return this;
      }

      public SocketConfig.Builder setTcpNoDelay(boolean tcpNoDelay) {
         this.tcpNoDelay = tcpNoDelay;
         return this;
      }

      public SocketConfig.Builder setSndBufSize(int sndBufSize) {
         this.sndBufSize = sndBufSize;
         return this;
      }

      public SocketConfig.Builder setRcvBufSize(int rcvBufSize) {
         this.rcvBufSize = rcvBufSize;
         return this;
      }

      public SocketConfig.Builder setBacklogSize(int backlogSize) {
         this.backlogSize = backlogSize;
         return this;
      }

      public SocketConfig build() {
         return new SocketConfig(this.soTimeout, this.soReuseAddress, this.soLinger, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize);
      }
   }
}
