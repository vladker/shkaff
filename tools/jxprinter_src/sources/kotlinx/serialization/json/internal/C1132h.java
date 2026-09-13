package kotlinx.serialization.json.internal;

/* JADX INFO: renamed from: kotlinx.serialization.json.internal.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class C1132h implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5739a;
    private final char[] buffer;

    public C1132h(char[] buffer) {
        kotlin.jvm.internal.E.f(buffer, "buffer");
        this.buffer = buffer;
        this.f5739a = buffer.length;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i5) {
        return this.buffer[i5];
    }

    public final char[] getBuffer$kotlinx_serialization_json() {
        return this.buffer;
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f5739a;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        return X3.W.concatToString(this.buffer, i5, Math.min(i6, this.f5739a));
    }

    public final String substring(int i5, int i6) {
        return X3.W.concatToString(this.buffer, i5, Math.min(i6, this.f5739a));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return substring(0, this.f5739a);
    }
}
