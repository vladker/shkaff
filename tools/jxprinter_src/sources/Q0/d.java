package Q0;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f569a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Runnable e;

    public d(e eVar, List list, List list2, int i5, Runnable runnable) {
        this.f569a = eVar;
        this.b = list;
        this.c = list2;
        this.d = i5;
        this.e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new c(this));
        E.b(diffResultCalculateDiff, "DiffUtil.calculateDiff(o…         }\n            })");
        this.f569a.b.execute(new b(this, diffResultCalculateDiff, 0));
    }
}
