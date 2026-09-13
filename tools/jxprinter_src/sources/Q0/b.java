package Q0;

import R2.o;
import S4.j;
import android.os.StrictMode;
import androidx.recyclerview.widget.DiffUtil;
import com.alibaba.android.arouter.core.InterceptorServiceImpl;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.thread.CancelableCountDownLatch;
import com.android.billingclient.api.C0421m;
import com.android.billingclient.api.C0445y0;
import com.android.billingclient.api.H;
import com.android.billingclient.api.InterfaceC0426o0;
import com.android.billingclient.api.InterfaceC0433s0;
import com.android.billingclient.api.k1;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzca;
import com.google.android.gms.internal.play_billing.zzjs;
import com.soundcloud.android.crop.CropImageActivity;
import io.reactivex.AbstractC0985s;
import io.reactivex.InterfaceC0679f;
import io.reactivex.internal.operators.flowable.F0;
import io.reactivex.internal.operators.flowable.g5;
import io.reactivex.internal.operators.flowable.h5;
import io.reactivex.internal.operators.observable.C0889k0;
import io.reactivex.internal.operators.observable.K3;
import io.reactivex.internal.operators.observable.L3;
import io.reactivex.internal.operators.observable.Y2;
import io.reactivex.internal.operators.observable.Z2;
import io.reactivex.internal.schedulers.C0972k;
import io.reactivex.internal.schedulers.M;
import io.reactivex.internal.schedulers.N;
import io.reactivex.internal.schedulers.RunnableC0968g;
import io.reactivex.y;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import p007a4.InterfaceC0285k;
import p059k3.p0;
import p077n3.C1252f;
import p147z3.Q;
import p147z3.u;
import p147z3.v;
import retrofit2.I;
import xyz.doikki.videoplayer.player.k;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f567a;
    public final Object b;
    public final Object c;

    public /* synthetic */ b(Object obj, int i5, Object obj2, boolean z6) {
        this.f567a = i5;
        this.c = obj;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f567a) {
            case 0:
                d dVar = (d) this.b;
                e eVar = dVar.f569a;
                if (eVar.d == dVar.d) {
                    List<Object> list = dVar.c;
                    DiffUtil.DiffResult diffResult = (DiffUtil.DiffResult) this.c;
                    Runnable runnable = dVar.e;
                    O0.e eVar2 = eVar.e;
                    eVar2.getData();
                    eVar2.setData$com_github_CymChad_brvah(list);
                    diffResult.dispatchUpdatesTo(eVar.f570a);
                    eVar.a(runnable);
                    return;
                }
                return;
            case 1:
                H2.c cVar = (H2.c) this.c;
                if (((CropImageActivity) cVar.b).imageView.getScale() == 1.0f) {
                    ((CropImageActivity) cVar.b).imageView.a();
                }
                ((CountDownLatch) this.b).countDown();
                return;
            case 2:
                ((R2.g) this.c).e((o) this.b);
                return;
            case 3:
                S4.i iVarB = ((j) this.b).b();
                if (iVarB == null) {
                    throw new IllegalStateException("No pending post available");
                }
                ((S4.d) this.c).c(iVarB);
                return;
            case 4:
                ((InterfaceC0285k) this.b).resumeUndispatched((p012b4.c) this.c, Q.INSTANCE);
                return;
            case 5:
                InterceptorCallback interceptorCallback = (InterceptorCallback) this.c;
                Postcard postcard = (Postcard) this.b;
                CancelableCountDownLatch cancelableCountDownLatch = new CancelableCountDownLatch(com.alibaba.android.arouter.core.b.f2418f.size());
                try {
                    InterceptorServiceImpl._execute(0, cancelableCountDownLatch, postcard);
                    cancelableCountDownLatch.await(postcard.getTimeout(), TimeUnit.SECONDS);
                    if (cancelableCountDownLatch.getCount() > 0) {
                        interceptorCallback.onInterrupt(new HandlerException("The interceptor processing timed out."));
                    } else if (postcard.getTag() != null) {
                        interceptorCallback.onInterrupt((Throwable) postcard.getTag());
                    } else {
                        interceptorCallback.onContinue(postcard);
                    }
                    return;
                } catch (Exception e) {
                    interceptorCallback.onInterrupt(e);
                    return;
                }
            case 6:
                C0421m c0421m = (C0421m) this.b;
                InterfaceC0433s0 interfaceC0433s0 = (InterfaceC0433s0) this.c;
                zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
                H h6 = k1.f2517k;
                c0421m.N(9, h6, zzjsVar);
                ((F4.f) interfaceC0433s0).onQueryPurchasesResponse(h6, zzca.zzk());
                return;
            case 7:
                C0421m.A((C0421m) this.b, (H) this.c);
                return;
            case 8:
                C0421m c0421m2 = (C0421m) this.b;
                InterfaceC0426o0 interfaceC0426o0 = (InterfaceC0426o0) this.c;
                zzjs zzjsVar2 = zzjs.EXECUTE_ASYNC_TIMEOUT;
                H h7 = k1.f2517k;
                c0421m2.N(7, h7, zzjsVar2);
                ((p062l0.a) interfaceC0426o0).onProductDetailsResponse(h7, new C0445y0(zzca.zzk(), zzca.zzk()));
                return;
            case 9:
                try {
                    ((C0421m) ((k) this.b).c).zzK.onBillingSetupFinished((H) this.c);
                    return;
                } catch (Throwable th) {
                    zzc.zzo("BillingClient", "Exception calling onBillingSetupFinished.", th);
                    return;
                }
            case 10:
                ((p044h4.o) this.b).trySelect((p044h4.b) this.c, Q.INSTANCE);
                return;
            case 11:
                synchronized (((io.reactivex.internal.operators.flowable.H) this.c)) {
                    ((io.reactivex.internal.operators.flowable.H) this.c).f4270m.remove((Collection) this.b);
                    break;
                }
                io.reactivex.internal.operators.flowable.H h8 = (io.reactivex.internal.operators.flowable.H) this.c;
                h8.s((Collection) this.b, h8.f4269l);
                return;
            case 12:
                F0 f1 = (F0) this.c;
                try {
                    f1.f4229a.onError((Throwable) this.b);
                    return;
                } finally {
                    f1.d.dispose();
                }
            case 13:
                ((F0) this.c).f4229a.onNext(this.b);
                return;
            case 14:
                h5 h5Var = (h5) this.c;
                h5Var.d.offer(new g5((p123v3.d) this.b, false));
                if (h5Var.p()) {
                    h5Var.u();
                    return;
                }
                return;
            case 15:
                C0889k0 c0889k0 = (C0889k0) this.c;
                try {
                    c0889k0.f5220a.onError((Throwable) this.b);
                    return;
                } finally {
                    c0889k0.d.dispose();
                }
            case 16:
                ((C0889k0) this.c).f5220a.onNext(this.b);
                return;
            case 17:
                ((Z2) this.c).f5141a.subscribe((Y2) this.b);
                return;
            case 18:
                L3 l6 = (L3) this.c;
                l6.c.offer(new K3((p129w3.f) this.b, false));
                if (l6.c()) {
                    l6.h();
                    return;
                }
                return;
            case 19:
                RunnableC0968g runnableC0968g = (RunnableC0968g) this.b;
                p033f3.h hVar = runnableC0968g.b;
                p011b3.c cVarScheduleDirect = ((C0972k) this.c).scheduleDirect(runnableC0968g);
                hVar.getClass();
                p033f3.d.c(hVar, cVarScheduleDirect);
                return;
            case 20:
                InterfaceC0679f interfaceC0679f = (InterfaceC0679f) this.b;
                try {
                    ((Runnable) this.c).run();
                    return;
                } finally {
                    interfaceC0679f.onComplete();
                }
            case 21:
                ((M) this.b).d = true;
                ((N) this.c).f5344a.remove((M) this.b);
                return;
            case 22:
                ((AbstractC0985s) ((y) this.c)).subscribe((p0) this.b);
                return;
            case 23:
                ((C1252f) this.c).b.onError((Throwable) this.b);
                return;
            case 24:
                ((C1252f) this.c).b.onSuccess(this.b);
                return;
            case 25:
                F3.h.intercepted((I) this.b).resumeWith(u.m1361constructorimpl(v.createFailure((Throwable) this.c)));
                return;
            default:
                p138y0.c cVar2 = (p138y0.c) this.c;
                if (cVar2.d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    ((Runnable) this.b).run();
                    return;
                } catch (Throwable th2) {
                    cVar2.c.a(th2);
                    return;
                }
        }
    }

    public /* synthetic */ b(Object obj, Object obj2, int i5) {
        this.f567a = i5;
        this.b = obj;
        this.c = obj2;
    }

    public b(S4.d dVar) {
        this.f567a = 3;
        this.c = dVar;
        this.b = new j();
    }
}
