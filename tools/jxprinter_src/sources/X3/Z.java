package X3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class Z extends A3.F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f853a;
    public final /* synthetic */ CharSequence b;

    public Z(CharSequence charSequence) {
        this.b = charSequence;
    }

    @Override // A3.F
    public final char b() {
        int i5 = this.f853a;
        this.f853a = i5 + 1;
        return this.b.charAt(i5);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f853a < this.b.length();
    }
}
