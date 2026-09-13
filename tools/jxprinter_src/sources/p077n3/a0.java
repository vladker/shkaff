package p077n3;

import io.reactivex.S;
import io.reactivex.plugins.a;
import java.util.concurrent.atomic.AtomicInteger;
import p011b3.c;
import p027e3.o;
import p033f3.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends AtomicInteger implements c {
    private static final long serialVersionUID = -5556924161382950569L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S f6285a;
    public final o b;
    public final b0[] c;
    public final Object[] d;

    public a0(S s6, int i5, o oVar) {
        super(i5);
        this.f6285a = s6;
        this.b = oVar;
        b0[] b0VarArr = new b0[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            b0VarArr[i6] = new b0(this, i6);
        }
        this.c = b0VarArr;
        this.d = new Object[i5];
    }

    public final void a(Throwable th, int i5) {
        if (getAndSet(0) <= 0) {
            a.onError(th);
            return;
        }
        b0[] b0VarArr = this.c;
        int length = b0VarArr.length;
        for (int i6 = 0; i6 < i5; i6++) {
            b0 b0Var = b0VarArr[i6];
            b0Var.getClass();
            d.a(b0Var);
        }
        while (true) {
            i5++;
            if (i5 >= length) {
                this.f6285a.onError(th);
                return;
            } else {
                b0 b0Var2 = b0VarArr[i5];
                b0Var2.getClass();
                d.a(b0Var2);
            }
        }
    }

    @Override // p011b3.c
    public final void dispose() {
        if (getAndSet(0) > 0) {
            for (b0 b0Var : this.c) {
                b0Var.getClass();
                d.a(b0Var);
            }
        }
    }

    @Override // p011b3.c
    public final boolean e() {
        return get() <= 0;
    }
}
