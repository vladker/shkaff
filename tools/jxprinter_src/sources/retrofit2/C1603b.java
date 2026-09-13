package retrofit2;

/* JADX INFO: renamed from: retrofit2.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public final class C1603b implements InterfaceC1621t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1603b f8117a = new C1603b();

    @Override // retrofit2.InterfaceC1621t
    public okhttp3.W convert(okhttp3.W w6) {
        try {
            return B0.buffer(w6);
        } finally {
            w6.close();
        }
    }
}
