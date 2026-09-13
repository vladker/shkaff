package p050j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5385a;
    public final long b;
    public final int c;

    public k(String str, long j6, int i5) {
        this.f5385a = str;
        this.b = j6;
        this.c = i5;
    }

    @Override // p050j.h
    public final boolean a(r rVar, Object obj) {
        Object objD = rVar.d(obj, this.f5385a);
        if (objD == null || !(objD instanceof Number)) {
            return false;
        }
        long jLongValue = ((Number) objD).longValue();
        long j6 = this.b;
        int i5 = this.c;
        if (i5 == 1) {
            if (jLongValue != j6) {
                return false;
            }
        } else if (i5 == 2) {
            if (jLongValue == j6) {
                return false;
            }
        } else if (i5 == 4) {
            if (jLongValue < j6) {
                return false;
            }
        } else if (i5 == 3) {
            if (jLongValue <= j6) {
                return false;
            }
        } else if (i5 == 6) {
            if (jLongValue > j6) {
                return false;
            }
        } else if (i5 != 5 || jLongValue >= j6) {
            return false;
        }
        return true;
    }
}
