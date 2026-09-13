package p050j;

import A3.AbstractC0157z;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5390a;
    public final int b;
    public final int c;

    public o(int i5, int i6, int i7) {
        this.f5390a = i5;
        this.b = i6;
        this.c = i7;
    }

    @Override // p050j.p
    public final Object c(r rVar, Object obj, Object obj2) {
        int iIntValue = q.a(rVar, obj2).intValue();
        int i5 = this.f5390a;
        if (i5 < 0) {
            i5 += iIntValue;
        }
        int i6 = this.b;
        if (i6 < 0) {
            i6 += iIntValue;
        }
        int i7 = this.c;
        int iB = AbstractC0157z.b(i6, i5, i7, 1);
        if (iB == -1) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iB);
        while (i5 <= i6 && i5 < iIntValue) {
            arrayList.add(r.b(i5, obj2));
            i5 += i7;
        }
        return arrayList;
    }
}
