package X3;

import java.util.List;
import p147z3.C1938s;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class Y implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f852a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ Y(int i5, Object obj, boolean z6) {
        this.f852a = i5;
        this.c = obj;
        this.b = z6;
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f852a) {
            case 0:
                char[] cArr = (char[]) this.c;
                CharSequence DelimitedRangesSequence = (CharSequence) obj;
                int iIntValue = ((Integer) obj2).intValue();
                kotlin.jvm.internal.E.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
                int iIndexOfAny = b0.indexOfAny(DelimitedRangesSequence, cArr, iIntValue, this.b);
                if (iIndexOfAny < 0) {
                    return null;
                }
                return p147z3.A.to(Integer.valueOf(iIndexOfAny), 1);
            default:
                List list = (List) this.c;
                CharSequence DelimitedRangesSequence2 = (CharSequence) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                kotlin.jvm.internal.E.f(DelimitedRangesSequence2, "$this$DelimitedRangesSequence");
                C1938s c1938sB = b0.b(DelimitedRangesSequence2, list, iIntValue2, this.b, false);
                if (c1938sB != null) {
                    return p147z3.A.to(c1938sB.f9134a, Integer.valueOf(((String) c1938sB.b).length()));
                }
                return null;
        }
    }
}
