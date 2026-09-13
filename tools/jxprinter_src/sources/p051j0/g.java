package p051j0;

import E3.o;
import O3.p;
import W2.b;
import android.app.Activity;
import kotlinx.coroutines.flow.internal.F;
import kotlinx.coroutines.flow.internal.I;
import p007a4.H0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class g implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5398a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i5) {
        this.f5398a = i5;
        this.b = obj;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0024  */
    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5398a) {
            case 0:
                ((Activity) this.b).runOnUiThread(new b((Integer) obj2, (Integer) obj, 24));
                return null;
            default:
                F f6 = (F) this.b;
                int iIntValue = ((Integer) obj).intValue();
                o oVar = (o) obj2;
                E3.p key = oVar.getKey();
                o oVar2 = f6.collectContext.get(key);
                if (key == H0.Key) {
                    H0 h1 = (H0) oVar2;
                    H0 h0TransitiveCoroutineParent = I.transitiveCoroutineParent((H0) oVar, h1);
                    if (h0TransitiveCoroutineParent != h1) {
                        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + h0TransitiveCoroutineParent + ", expected child of " + h1 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
                    }
                    if (h1 != null) {
                        iIntValue++;
                    }
                } else if (oVar != oVar2) {
                    iIntValue = Integer.MIN_VALUE;
                } else {
                    iIntValue++;
                }
                return Integer.valueOf(iIntValue);
        }
    }
}
