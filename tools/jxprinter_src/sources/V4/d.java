package V4;

import com.google.common.net.HttpHeaders;
import com.google.common.primitives.UnsignedBytes;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import p051j0.i;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d implements U4.a {
    public static final URL e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URL f767a = e;
    public U4.c b = U4.c.GET;
    public final LinkedHashMap c = new LinkedHashMap();
    public final LinkedHashMap d = new LinkedHashMap();

    static {
        try {
            e = new URL("http://undefined/");
        } catch (MalformedURLException e6) {
            throw new IllegalStateException(e6);
        }
    }

    private Map.Entry<String, List<String>> scanHeaders(String str) {
        String strI = i.i(str);
        for (Map.Entry<String, List<String>> entry : this.c.entrySet()) {
            if (i.i(entry.getKey()).equals(strI)) {
                return entry;
            }
        }
        return null;
    }

    public final void a(String str, String str2) {
        int i5;
        h.notEmpty(str);
        if (str2 == null) {
            str2 = "";
        }
        h.notEmpty(str);
        List listB = b(str);
        if (listB.isEmpty()) {
            listB = new ArrayList();
            this.c.put(str, listB);
        }
        byte[] bytes = str2.getBytes(g.c);
        int i6 = 0;
        if (bytes.length >= 3 && (bytes[0] & UnsignedBytes.MAX_VALUE) == 239 && (bytes[1] & UnsignedBytes.MAX_VALUE) == 187 && (bytes[2] & UnsignedBytes.MAX_VALUE) == 191) {
            i6 = 3;
        }
        int length = bytes.length;
        while (i6 < length) {
            byte b = bytes[i6];
            if ((b & UnsignedBytes.MAX_POWER_OF_TWO) != 0) {
                if ((b & 224) == 192) {
                    i5 = i6 + 1;
                } else {
                    if ((b & 240) != 224) {
                        if ((b & 248) == 240) {
                            i5 = i6 + 3;
                        }
                        listB.add(str2);
                    }
                    i5 = i6 + 2;
                }
                if (i5 < bytes.length) {
                    while (i6 < i5) {
                        i6++;
                        if ((bytes[i6] & 192) != 128) {
                        }
                    }
                }
                listB.add(str2);
            }
            i6++;
        }
        str2 = new String(bytes, g.b);
        listB.add(str2);
    }

    public final List b(String str) {
        h.notNull(str);
        for (Map.Entry entry : this.c.entrySet()) {
            if (str.equalsIgnoreCase((String) entry.getKey())) {
                return (List) entry.getValue();
            }
        }
        return Collections.EMPTY_LIST;
    }

    public final boolean c(String str) {
        h.notEmpty(HttpHeaders.CONTENT_ENCODING);
        h.notEmpty(str);
        h.notEmpty(HttpHeaders.CONTENT_ENCODING);
        Iterator it = b(HttpHeaders.CONTENT_ENCODING).iterator();
        while (it.hasNext()) {
            if (str.equalsIgnoreCase((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // U4.a
    public final String cookie(String str) {
        h.notEmpty(str, "Cookie name must not be empty");
        return (String) this.d.get(str);
    }

    public final void d(String str) {
        h.notEmpty(str, "Header name must not be empty");
        Map.Entry<String, List<String>> entryScanHeaders = scanHeaders(str);
        if (entryScanHeaders != null) {
            this.c.remove(entryScanHeaders.getKey());
        }
    }

    public final URL e() {
        URL url = this.f767a;
        if (url != e) {
            return url;
        }
        throw new IllegalArgumentException("URL not set. Make sure to call #url(...) before executing the request.");
    }

    @Override // U4.a
    public final String header(String str) {
        h.notNull(str, "Header name must not be null");
        List listB = b(str);
        if (listB.size() > 0) {
            return W4.b.f(listB, ", ");
        }
        return null;
    }
}
