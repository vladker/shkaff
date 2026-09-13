package p050j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5382a;
    public final double b;
    public final int c;

    public g(double d, int i5, String str) {
        this.f5382a = str;
        this.b = d;
        this.c = i5;
    }

    @Override // p050j.h
    public final boolean a(r rVar, Object obj) {
        Object objD = rVar.d(obj, this.f5382a);
        if (objD == null || !(objD instanceof Number)) {
            return false;
        }
        double dDoubleValue = ((Number) objD).doubleValue();
        double d = this.b;
        int i5 = this.c;
        if (i5 == 1) {
            if (dDoubleValue != d) {
                return false;
            }
        } else if (i5 == 2) {
            if (dDoubleValue == d) {
                return false;
            }
        } else if (i5 == 4) {
            if (dDoubleValue < d) {
                return false;
            }
        } else if (i5 == 3) {
            if (dDoubleValue <= d) {
                return false;
            }
        } else if (i5 == 6) {
            if (dDoubleValue > d) {
                return false;
            }
        } else if (i5 != 5 || dDoubleValue >= d) {
            return false;
        }
        return true;
    }
}
