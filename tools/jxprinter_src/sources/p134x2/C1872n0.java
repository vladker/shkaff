package p134x2;

import E3.g;
import F3.i;
import G3.m;
import O3.p;
import android.graphics.Bitmap;
import p007a4.M;
import p147z3.Q;
import p147z3.u;
import p147z3.v;

/* JADX INFO: renamed from: x2.n0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class C1872n0 extends m implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public I f8919a;
    public int b;
    public final /* synthetic */ K0 c;
    public final /* synthetic */ Bitmap d;
    public final /* synthetic */ boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ String f8921g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f8922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ p f8923i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1872n0(K0 k6, Bitmap bitmap, boolean z6, int i5, String str, int i6, p pVar, g gVar) {
        super(2, gVar);
        this.c = k6;
        this.d = bitmap;
        this.e = z6;
        this.f8920f = i5;
        this.f8921g = str;
        this.f8922h = i6;
        this.f8923i = pVar;
    }

    @Override // G3.a
    public final g<Q> create(Object obj, g<?> gVar) {
        return new C1872n0(this.c, this.d, this.e, this.f8920f, this.f8921g, this.f8922h, this.f8923i, gVar);
    }

    @Override // O3.p
    public final Object invoke(M m6, g<? super K> gVar) {
        return ((C1872n0) create(m6, gVar)).invokeSuspend(Q.INSTANCE);
    }

    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        I i5;
        Object objB;
        Object coroutine_suspended = i.getCOROUTINE_SUSPENDED();
        int i6 = this.b;
        if (i6 == 0) {
            v.throwOnFailure(obj);
            I i7 = K.Companion;
            this.f8919a = i7;
            this.b = 1;
            Object objM1103printTSCBitmapbMdYcbs = this.c.m1103printTSCBitmapbMdYcbs(this.d, this.e, this.f8920f, this.f8921g, this.f8922h, this.f8923i, this);
            if (objM1103printTSCBitmapbMdYcbs == coroutine_suspended) {
                return coroutine_suspended;
            }
            i5 = i7;
            objB = objM1103printTSCBitmapbMdYcbs;
        } else {
            if (i6 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5 = this.f8919a;
            v.throwOnFailure(obj);
            objB = ((u) obj).b();
        }
        return i5.from(objB);
    }
}
