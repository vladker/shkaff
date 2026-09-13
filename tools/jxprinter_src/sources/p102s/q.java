package p102s;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import com.appdev.standard.page.printerlabel.widget.PrinterLabelTableView;
import java.util.ArrayList;
import p007a4.M;
import p147z3.Q;
import p147z3.v;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f8179a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(boolean z6, g gVar) {
        super(2, gVar);
        this.f8179a = z6;
    }

    @Override // G3.a
    public final g create(Object obj, g gVar) {
        return new q(this.f8179a, gVar);
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        return ((q) create((M) obj, (g) obj2)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        i.getCOROUTINE_SUSPENDED();
        v.throwOnFailure(obj);
        ArrayList arrayList = r.curTable;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj2 = arrayList.get(i5);
                i5++;
                ((PrinterLabelTableView) obj2).setOpenFrame(this.f8179a);
            }
        }
        return Q.INSTANCE;
    }
}
