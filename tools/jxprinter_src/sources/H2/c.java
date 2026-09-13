package H2;

import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Process;
import android.widget.Toast;
import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.core.InterceptorServiceImpl;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.MapUtils;
import com.android.billingclient.api.C0421m;
import com.android.billingclient.api.H;
import com.android.billingclient.api.P0;
import com.android.billingclient.api.k1;
import com.bumptech.glide.A;
import com.bumptech.glide.load.engine.C0487c;
import com.contrarywind.view.WheelView;
import com.google.android.gms.internal.play_billing.zzc;
import com.google.android.gms.internal.play_billing.zzjs;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.soundcloud.android.crop.CropImageActivity;
import com.soundcloud.android.crop.CropImageView;
import io.reactivex.internal.operators.flowable.F0;
import io.reactivex.internal.operators.flowable.P4;
import io.reactivex.internal.operators.observable.C0889k0;
import io.reactivex.internal.operators.observable.C0941u3;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import p007a4.C0289m;
import p134x2.K0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f294a;
    public final /* synthetic */ Object b;

    public /* synthetic */ c(Object obj, int i5) {
        this.f294a = i5;
        this.b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        switch (this.f294a) {
            case 0:
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.b;
                L2.f fVar = smartRefreshLayout.f3692B0;
                if (fVar != null) {
                    fVar.onLoadMore(smartRefreshLayout);
                    return;
                } else {
                    smartRefreshLayout.j(2000, false);
                    return;
                }
            case 1:
                CountDownLatch countDownLatch = new CountDownLatch(1);
                CropImageActivity cropImageActivity = (CropImageActivity) this.b;
                cropImageActivity.handler.post(new Q0.b(this, 1, countDownLatch, false));
                try {
                    countDownLatch.await();
                    cropImageActivity.handler.post(new c(new S4.h(cropImageActivity, 4), 2));
                    return;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            case 2:
                CropImageActivity cropImageActivity2 = (CropImageActivity) ((S4.h) this.b).b;
                if (cropImageActivity2.rotateBitmap != null) {
                    R2.e eVar = new R2.e(cropImageActivity2.imageView);
                    int iB = cropImageActivity2.rotateBitmap.b();
                    int iA = cropImageActivity2.rotateBitmap.a();
                    Rect rect = new Rect(0, 0, iB, iA);
                    int iMin = (Math.min(iB, iA) * 4) / 5;
                    if (cropImageActivity2.aspectX == 0 || cropImageActivity2.aspectY == 0) {
                        i5 = iMin;
                    } else if (cropImageActivity2.aspectX > cropImageActivity2.aspectY) {
                        i5 = (cropImageActivity2.aspectY * iMin) / cropImageActivity2.aspectX;
                    } else {
                        i5 = iMin;
                        iMin = (cropImageActivity2.aspectX * iMin) / cropImageActivity2.aspectY;
                    }
                    int i6 = (iB - iMin) / 2;
                    int i7 = (iA - i5) / 2;
                    RectF rectF = new RectF(i6, i7, i6 + iMin, i7 + i5);
                    Matrix unrotatedMatrix = cropImageActivity2.imageView.getUnrotatedMatrix();
                    boolean z6 = (cropImageActivity2.aspectX == 0 || cropImageActivity2.aspectY == 0) ? false : true;
                    eVar.c = new Matrix(unrotatedMatrix);
                    eVar.f590a = rectF;
                    eVar.d = new RectF(rect);
                    eVar.f599n = z6;
                    eVar.f600o = eVar.f590a.width() / eVar.f590a.height();
                    eVar.b = eVar.a();
                    eVar.e.setARGB(125, 50, 50, 50);
                    Paint paint = eVar.f591f;
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setAntiAlias(true);
                    eVar.f602q = 2.0f * eVar.f593h.getResources().getDisplayMetrics().density;
                    Paint paint2 = eVar.f592g;
                    paint2.setColor(eVar.f596k);
                    paint2.setStyle(Paint.Style.FILL);
                    paint2.setAntiAlias(true);
                    eVar.f601p = 12.0f * eVar.f593h.getResources().getDisplayMetrics().density;
                    eVar.f597l = 1;
                    CropImageView cropImageView = cropImageActivity2.imageView;
                    cropImageView.f3767l.add(eVar);
                    cropImageView.invalidate();
                }
                cropImageActivity2.imageView.invalidate();
                if (cropImageActivity2.imageView.f3767l.size() == 1) {
                    cropImageActivity2.cropView = (R2.e) cropImageActivity2.imageView.f3767l.get(0);
                    cropImageActivity2.cropView.f603r = true;
                    return;
                }
                return;
            case 3:
                R2.c cVar = (R2.c) this.b;
                cVar.f589a.removeLifeCycleListener(cVar);
                ProgressDialog progressDialog = cVar.b;
                if (progressDialog.getWindow() != null) {
                    progressDialog.dismiss();
                    return;
                }
                return;
            case 4:
                ((U0.c) this.b).getClass();
                return;
            case 5:
                WheelView wheelView = (WheelView) this.b;
                wheelView.e.f(wheelView.getCurrentItem());
                return;
            case 6:
                p012b4.f.a((C0289m) this.b);
                return;
            case 7:
                UniqueKeyTreeMap uniqueKeyTreeMap = com.alibaba.android.arouter.core.b.e;
                if (MapUtils.isNotEmpty(uniqueKeyTreeMap)) {
                    Iterator it = uniqueKeyTreeMap.entrySet().iterator();
                    while (it.hasNext()) {
                        Class cls = (Class) ((Map.Entry) it.next()).getValue();
                        try {
                            IInterceptor iInterceptor = (IInterceptor) cls.getConstructor(null).newInstance(null);
                            iInterceptor.init((Context) this.b);
                            com.alibaba.android.arouter.core.b.f2418f.add(iInterceptor);
                        } catch (Exception e6) {
                            throw new HandlerException("ARouter::ARouter init interceptor error! name = [" + cls.getName() + "], reason = [" + e6.getMessage() + "]");
                        }
                    }
                    boolean unused = InterceptorServiceImpl.interceptorHasInit = true;
                    ARouter.logger.info("ARouter::", "ARouter interceptors init over.");
                    synchronized (InterceptorServiceImpl.interceptorInitLock) {
                        InterceptorServiceImpl.interceptorInitLock.notifyAll();
                        break;
                    }
                    return;
                }
                return;
            case 8:
                try {
                    ((C0421m) ((xyz.doikki.videoplayer.player.k) this.b).c).zzK.d();
                    return;
                } catch (Throwable th) {
                    zzc.zzo("BillingClient", "Exception calling onBillingServiceDisconnected.", th);
                    return;
                }
            case 9:
                P0 p1 = (P0) this.b;
                C0421m c0421m = p1.e;
                c0421m.T(0);
                zzjs zzjsVar = zzjs.EXECUTE_ASYNC_TIMEOUT;
                H h6 = k1.f2517k;
                c0421m.S(p1.d, h6, zzjsVar);
                p1.d(h6);
                return;
            case 10:
                A a6 = (A) this.b;
                a6.c.addListener(a6);
                return;
            case 11:
                Process.setThreadPriority(10);
                ((Runnable) this.b).run();
                return;
            case 12:
                C0487c c0487c = (C0487c) this.b;
                while (!c0487c.e) {
                    try {
                        c0487c.cleanupActiveReference((C0487c.a) c0487c.c.remove());
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                }
                return;
            case 13:
                Application application = p030f.c.f3959i;
                StringBuilder sb = new StringBuilder("There's no route matched!\n Path = [");
                Postcard postcard = (Postcard) this.b;
                sb.append(postcard.getPath());
                sb.append("]\n Group = [");
                sb.append(postcard.getGroup());
                sb.append("]");
                Toast.makeText(application, sb.toString(), 1).show();
                return;
            case 14:
                F0 f1 = (F0) this.b;
                try {
                    f1.f4229a.onComplete();
                    return;
                } finally {
                    f1.d.dispose();
                }
            case 15:
                ((P4) this.b).c.cancel();
                return;
            case 16:
                C0889k0 c0889k0 = (C0889k0) this.b;
                try {
                    c0889k0.f5220a.onComplete();
                    return;
                } finally {
                    c0889k0.d.dispose();
                }
            case 17:
                ((C0941u3) this.b).c.dispose();
                return;
            case 18:
                Activity activity = ((p051j0.h) this.b).f5399a;
                K0 printer = p051j0.f.getPrinter();
                if (printer == null) {
                    activity.runOnUiThread(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(5));
                    return;
                } else if (printer.sendLatestCmdSync(new p051j0.g(activity, 0)).b()) {
                    activity.runOnUiThread(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(6));
                    return;
                } else {
                    activity.runOnUiThread(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(7));
                    return;
                }
            case 19:
                StringBuilder sb2 = new StringBuilder("执行第 ");
                p062l0.e eVar2 = (p062l0.e) this.b;
                sb2.append(eVar2.d);
                sb2.append(" 次重连");
                p051j0.a.d("GoogleBillingManager", sb2.toString());
                eVar2.e();
                return;
            case 20:
                p114u0.d dVar = (p114u0.d) this.b;
                dVar.d.f8186g.removeView(dVar.c);
                dVar.f8714h = false;
                dVar.e = false;
                dVar.getClass();
                return;
            default:
                ((O3.a) this.b).invoke();
                return;
        }
    }
}
