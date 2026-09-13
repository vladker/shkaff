package p050j;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5384a;
    public final String b;
    public final boolean c;
    public final Object d;

    public /* synthetic */ j(String str, Serializable serializable, boolean z6, int i5) {
        this.f5384a = i5;
        this.b = str;
        this.d = serializable;
        this.c = z6;
    }

    @Override // p050j.h
    public boolean a(r rVar, Object obj) {
        boolean z6;
        switch (this.f5384a) {
            case 0:
                Object objD = rVar.d(obj, this.b);
                if (objD == null) {
                    return false;
                }
                boolean z7 = objD instanceof Number;
                boolean z8 = this.c;
                if (z7) {
                    long jLongValue = ((Number) objD).longValue();
                    for (long j6 : (long[]) this.d) {
                        if (j6 == jLongValue) {
                            return !z8;
                        }
                    }
                }
                return z8;
            case 1:
                Long[] lArr = (Long[]) this.d;
                Object objD2 = rVar.d(obj, this.b);
                boolean z9 = this.c;
                int i5 = 0;
                if (objD2 == null) {
                    int length = lArr.length;
                    while (i5 < length) {
                        if (lArr[i5] != null) {
                            i5++;
                        }
                    }
                    return z9;
                }
                if (!(objD2 instanceof Number)) {
                    return z9;
                }
                long jLongValue2 = ((Number) objD2).longValue();
                int length2 = lArr.length;
                while (i5 < length2) {
                    Long l6 = lArr[i5];
                    if (l6 == null || l6.longValue() != jLongValue2) {
                        i5++;
                    }
                }
                return z9;
                return !z9;
            case 2:
                Object objD3 = rVar.d(obj, this.b);
                if (objD3 == null) {
                    return false;
                }
                boolean zMatches = ((Pattern) this.d).matcher(objD3.toString()).matches();
                return this.c ? !zMatches : zMatches;
            case 3:
                Object objD4 = rVar.d(obj, this.b);
                String[] strArr = (String[]) this.d;
                int length3 = strArr.length;
                int i6 = 0;
                while (true) {
                    z6 = this.c;
                    if (i6 >= length3) {
                        return z6;
                    }
                    String str = strArr[i6];
                    if (str != objD4 && (str == null || !str.equals(objD4))) {
                        i6++;
                    }
                }
                return !z6;
            default:
                boolean zEquals = ((Boolean) this.d).equals(rVar.d(obj, this.b));
                return !this.c ? !zEquals : zEquals;
        }
    }

    public /* synthetic */ j(boolean z6, Bitmap bitmap, String str, int i5) {
        this.f5384a = i5;
        this.c = z6;
        this.d = bitmap;
        this.b = str;
    }

    public j(String str, String str2, boolean z6) {
        this.f5384a = 2;
        this.b = str;
        this.d = Pattern.compile(str2);
        this.c = z6;
    }
}
