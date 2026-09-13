package V4;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f764a = Collections.unmodifiableMap(new HashMap());

    public static void applyCookiesToRequest(e eVar, HttpURLConnection httpURLConnection) {
        HashSet hashSet;
        HashSet hashSet2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry : eVar.d.entrySet()) {
            linkedHashSet.add(((String) entry.getKey()) + "=" + ((String) entry.getValue()));
        }
        HashSet hashSet3 = null;
        for (Map.Entry<String, List<String>> entry2 : eVar.f776n.get(asUri(eVar.f767a), f764a).entrySet()) {
            List<String> value = entry2.getValue();
            if (value != null && value.size() != 0) {
                String key = entry2.getKey();
                if (HttpHeaders.COOKIE.equals(key)) {
                    hashSet = hashSet3;
                    hashSet2 = linkedHashSet;
                } else if ("Cookie2".equals(key)) {
                    hashSet2 = new HashSet();
                    hashSet = hashSet2;
                }
                hashSet2.addAll(value);
                hashSet3 = hashSet;
            }
        }
        if (linkedHashSet.size() > 0) {
            httpURLConnection.addRequestProperty(HttpHeaders.COOKIE, W4.b.f(linkedHashSet, VectorFormat.DEFAULT_SEPARATOR));
        }
        if (hashSet3 == null || hashSet3.size() <= 0) {
            return;
        }
        httpURLConnection.addRequestProperty("Cookie2", W4.b.f(hashSet3, VectorFormat.DEFAULT_SEPARATOR));
    }

    public static URI asUri(URL url) throws MalformedURLException {
        try {
            return url.toURI();
        } catch (URISyntaxException e) {
            MalformedURLException malformedURLException = new MalformedURLException(e.getMessage());
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    public static void storeCookies(e eVar, URL url, Map<String, List<String>> map) throws IOException {
        eVar.f776n.put(asUri(url), map);
    }
}
