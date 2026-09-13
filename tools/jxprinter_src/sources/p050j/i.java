package p050j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5383a;
    public final long b;
    public final long c;
    public final boolean d;

    public i(String str, long j6, long j7, boolean z6) {
        this.f5383a = str;
        this.b = j6;
        this.c = j7;
        this.d = z6;
    }

    @Override // p050j.h
    public final boolean a(r rVar, Object obj) {
        Object objD = rVar.d(obj, this.f5383a);
        if (objD == null) {
            return false;
        }
        boolean z6 = objD instanceof Number;
        boolean z7 = this.d;
        if (z6) {
            long jLongValue = ((Number) objD).longValue();
            if (jLongValue >= this.b && jLongValue <= this.c) {
                return !z7;
            }
        }
        return z7;
    }
}
