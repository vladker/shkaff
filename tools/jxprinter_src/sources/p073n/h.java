package p073n;

import java.lang.reflect.Type;
import java.util.Arrays;
import p050j.d;
import p067m.b;
import p067m.g;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f6186a;
    public final Enum[] b;
    public final Enum[] c;
    public final long[] d;

    public h(Class cls) {
        this.f6186a = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.c = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.d = new long[enumArr.length];
        int i5 = 0;
        while (true) {
            Enum[] enumArr2 = this.c;
            if (i5 >= enumArr2.length) {
                break;
            }
            String strName = enumArr2[i5].name();
            long jCharAt = -2128831035;
            for (int i6 = 0; i6 < strName.length(); i6++) {
                jCharAt = (jCharAt ^ ((long) strName.charAt(i6))) * 16777619;
            }
            jArr[i5] = jCharAt;
            this.d[i5] = jCharAt;
            i5++;
        }
        Arrays.sort(this.d);
        this.b = new Enum[this.c.length];
        for (int i7 = 0; i7 < this.d.length; i7++) {
            for (int i8 = 0; i8 < length; i8++) {
                if (this.d[i7] == jArr[i8]) {
                    this.b[i7] = this.c[i8];
                    break;
                }
            }
        }
    }

    @Override // p073n.p
    public final int a() {
        return 2;
    }

    @Override // p073n.p
    public final Object b(b bVar, Type type, Object obj) {
        try {
            g gVar = bVar.e;
            int i5 = gVar.f6092a;
            Class cls = this.f6186a;
            if (i5 == 2) {
                int iG = gVar.g();
                gVar.n(16);
                if (iG >= 0) {
                    Enum[] enumArr = this.c;
                    if (iG <= enumArr.length) {
                        return enumArr[iG];
                    }
                }
                throw new d("parse enum " + cls.getName() + " error, value : " + iG);
            }
            if (i5 == 4) {
                String strJ = gVar.J();
                gVar.n(16);
                if (strJ.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, strJ);
            }
            if (i5 == 8) {
                gVar.n(16);
                return null;
            }
            throw new d("parse enum " + cls.getName() + " error, value : " + bVar.h(null));
        } catch (d e) {
            throw e;
        } catch (Exception e6) {
            throw new d(e6.getMessage(), e6);
        }
    }
}
