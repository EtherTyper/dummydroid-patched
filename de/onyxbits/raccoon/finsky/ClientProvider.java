package de.onyxbits.raccoon.finsky;

import org.apache.http.client.HttpClient;

public interface ClientProvider {
   HttpClient getClient();
}
