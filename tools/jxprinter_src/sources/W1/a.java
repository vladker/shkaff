package W1;

import Y4.f;
import Y4.p;
import Y4.q;
import io.reactivex.M;
import io.reactivex.internal.schedulers.y;
import org.jsoup.nodes.m;
import org.jsoup.nodes.s;
import p071m3.A;
import t5.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements q, y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f784a;
    public Object b;
    public Object c;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3) {
        this.f784a = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // Y4.q
    public void e(s sVar, int i5) {
        if (sVar instanceof m) {
            m mVar = (m) sVar;
            if (((p) this.c).a((m) this.f784a, mVar)) {
                ((f) this.b).add(mVar);
            }
        }
    }

    @Override // io.reactivex.internal.schedulers.y
    public void onWorker(int i5, M m6) {
        ((A) this.c).b(i5, (c[]) this.f784a, (c[]) this.b, m6);
    }

    public /* synthetic */ a(Object obj, boolean z6, Object obj2, Object obj3) {
        this.c = obj;
        this.f784a = obj2;
        this.b = obj3;
    }

    @Override // Y4.q
    public void b(s sVar, int i5) {
    }
}
