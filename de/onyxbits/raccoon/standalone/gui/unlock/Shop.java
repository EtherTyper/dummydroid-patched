package de.onyxbits.raccoon.standalone.gui.unlock;

import de.onyxbits.raccoon.standalone.base.AbstractModule;
import de.onyxbits.raccoon.standalone.base.AppAdapter;
import de.onyxbits.raccoon.util.SemanticVersion;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class Shop extends AbstractModule {
   private static final String ID = Shop.class.getSimpleName();

   public String getOffersUrl(String feature) {
      Locale locale = Locale.getDefault();
      Currency currency = Currency.getInstance(locale);
      String cc = currency.getCurrencyCode().toLowerCase();
      String pc = ((AppAdapter)this.fetch(AppAdapter.class)).getProductCode();
      String lang = locale.getLanguage().toLowerCase();
      String country = locale.getCountry().toLowerCase();
      SemanticVersion ver = ((AppAdapter)this.fetch(AppAdapter.class)).getVersion();
      List params = new ArrayList();
      params.add(new BasicNameValuePair("offers", cc));
      params.add(new BasicNameValuePair("currency", cc));
      params.add(new BasicNameValuePair("country", country));
      params.add(new BasicNameValuePair("language", lang));
      params.add(new BasicNameValuePair("product", pc));
      if (ver != null) {
         params.add(new BasicNameValuePair("version", ver.toString()));
      }

      if (feature != null) {
         params.add(new BasicNameValuePair("feature", feature));
      }

      String tmp = "?".concat(URLEncodedUtils.format((List)params, (String)"UTF-8"));
      return Messages.t(ID + ".url.offers", tmp);
   }

   public void shutdown() {
   }
}
