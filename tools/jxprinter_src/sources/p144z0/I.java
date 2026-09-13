package p144z0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class I {
    public static final Map d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9057a;
    public Map b;
    public boolean c;

    static {
        String sanitizedUserAgent = getSanitizedUserAgent();
        HashMap map = new HashMap(2);
        if (!TextUtils.isEmpty(sanitizedUserAgent)) {
            map.put(HttpHeaders.USER_AGENT, Collections.singletonList(new J(sanitizedUserAgent)));
        }
        d = Collections.unmodifiableMap(map);
    }

    @VisibleForTesting
    public static String getSanitizedUserAgent() {
        String property = System.getProperty("http.agent");
        if (TextUtils.isEmpty(property)) {
            return property;
        }
        int length = property.length();
        StringBuilder sb = new StringBuilder(property.length());
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = property.charAt(i5);
            if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                sb.append(cCharAt);
            } else {
                sb.append('?');
            }
        }
        return sb.toString();
    }

    public final void a() {
        if (this.f9057a) {
            this.f9057a = false;
            HashMap map = new HashMap(this.b.size());
            for (Map.Entry entry : this.b.entrySet()) {
                map.put(entry.getKey(), new ArrayList((Collection) entry.getValue()));
            }
            this.b = map;
        }
    }

    public I addHeader(@NonNull String str, @NonNull String str2) {
        return addHeader(str, new J(str2));
    }

    public I setHeader(@NonNull String str, @Nullable String str2) {
        return setHeader(str, str2 == null ? null : new J(str2));
    }

    public I addHeader(@NonNull String str, @NonNull H h6) {
        if (this.c && HttpHeaders.USER_AGENT.equalsIgnoreCase(str)) {
            return setHeader(str, h6);
        }
        a();
        List arrayList = (List) this.b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.b.put(str, arrayList);
        }
        arrayList.add(h6);
        return this;
    }

    public I setHeader(@NonNull String str, @Nullable H h6) {
        a();
        if (h6 == null) {
            this.b.remove(str);
        } else {
            List arrayList = (List) this.b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.b.put(str, arrayList);
            }
            arrayList.clear();
            arrayList.add(h6);
        }
        if (this.c && HttpHeaders.USER_AGENT.equalsIgnoreCase(str)) {
            this.c = false;
        }
        return this;
    }
}
