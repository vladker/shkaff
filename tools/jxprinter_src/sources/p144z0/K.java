package p144z0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class K implements G {
    public final Map b;
    public volatile Map c;

    public K(Map map) {
        this.b = Collections.unmodifiableMap(map);
    }

    @NonNull
    private String buildHeaderValue(@NonNull List<H> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            String strBuildHeader = list.get(i5).buildHeader();
            if (!TextUtils.isEmpty(strBuildHeader)) {
                sb.append(strBuildHeader);
                if (i5 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof K) {
            return this.b.equals(((K) obj).b);
        }
        return false;
    }

    @Override // p144z0.G
    public final Map getHeaders() {
        if (this.c == null) {
            synchronized (this) {
                try {
                    if (this.c == null) {
                        HashMap map = new HashMap();
                        for (Map.Entry entry : this.b.entrySet()) {
                            String strBuildHeaderValue = buildHeaderValue((List) entry.getValue());
                            if (!TextUtils.isEmpty(strBuildHeaderValue)) {
                                map.put(entry.getKey(), strBuildHeaderValue);
                            }
                        }
                        this.c = Collections.unmodifiableMap(map);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.c;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "LazyHeaders{headers=" + this.b + '}';
    }
}
