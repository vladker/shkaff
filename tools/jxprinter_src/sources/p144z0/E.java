package p144z0;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.net.URL;
import java.security.MessageDigest;
import p126w0.q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class E implements q {
    public final G b;
    public int c;

    @Nullable
    private volatile byte[] cacheKeyBytes;

    @Nullable
    private String safeStringUrl;

    @Nullable
    private URL safeUrl;

    @Nullable
    private final String stringUrl;

    @Nullable
    private final URL url;

    public E(URL url) {
        K k6 = G.f9056a;
        this.url = (URL) L0.q.checkNotNull(url);
        this.stringUrl = null;
        this.b = (G) L0.q.checkNotNull(k6);
    }

    private URL getSafeUrl() {
        if (this.safeUrl == null) {
            if (TextUtils.isEmpty(this.safeStringUrl)) {
                String string = this.stringUrl;
                if (TextUtils.isEmpty(string)) {
                    string = ((URL) L0.q.checkNotNull(this.url)).toString();
                }
                this.safeStringUrl = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.safeUrl = new URL(this.safeStringUrl);
        }
        return this.safeUrl;
    }

    public final String a() {
        String str = this.stringUrl;
        return str != null ? str : ((URL) L0.q.checkNotNull(this.url)).toString();
    }

    @Override // p126w0.q
    public final boolean equals(Object obj) {
        if (obj instanceof E) {
            E e = (E) obj;
            if (a().equals(e.a()) && this.b.equals(e.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // p126w0.q
    public final int hashCode() {
        if (this.c == 0) {
            int iHashCode = a().hashCode();
            this.c = iHashCode;
            this.c = this.b.hashCode() + (iHashCode * 31);
        }
        return this.c;
    }

    public final String toString() {
        return a();
    }

    public URL toURL() {
        return getSafeUrl();
    }

    @Override // p126w0.q
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        if (this.cacheKeyBytes == null) {
            this.cacheKeyBytes = a().getBytes(q.f8812a);
        }
        messageDigest.update(this.cacheKeyBytes);
    }

    public E(String str) {
        K k6 = G.f9056a;
        this.url = null;
        this.stringUrl = L0.q.checkNotEmpty(str);
        this.b = (G) L0.q.checkNotNull(k6);
    }
}
