package U4;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f739a;
    public final String b;

    public k(String str, String str2) {
        super("Unhandled content type. Must be text/*, application/xml, or application/*+xml");
        this.f739a = str;
        this.b = str2;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + ". Mimetype=" + this.f739a + ", URL=" + this.b;
    }
}
