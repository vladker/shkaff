package okhttp3.internal.http2;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class n extends o {
    @Override // okhttp3.internal.http2.o
    public void onStream(A a6) {
        a6.close(EnumC1358b.REFUSED_STREAM, null);
    }
}
