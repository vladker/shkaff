package okhttp3.internal.http2;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class G extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1358b f6595a;

    public G(EnumC1358b enumC1358b) {
        super("stream was reset: " + enumC1358b);
        this.f6595a = enumC1358b;
    }
}
