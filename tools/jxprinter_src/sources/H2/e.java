package H2;

import android.animation.ValueAnimator;
import com.android.billingclient.api.C0421m;
import com.android.billingclient.api.k1;
import com.google.android.gms.internal.play_billing.zzjs;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f296a;
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ e(Object obj, int i5, int i6) {
        this.f296a = i6;
        this.c = obj;
        this.b = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        O2.a aVarE;
        ValueAnimator valueAnimatorA;
        xyz.doikki.videoplayer.player.c cVar;
        xyz.doikki.videoplayer.player.c cVar2;
        switch (this.f296a) {
            case 0:
                f fVar = (f) this.c;
                SmartRefreshLayout smartRefreshLayout = fVar.d;
                if (!smartRefreshLayout.f3744p0 || this.b >= 0) {
                    aVarE = null;
                } else {
                    aVarE = smartRefreshLayout.f3720U0.e(smartRefreshLayout.b);
                    if (aVarE != null) {
                        aVarE.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                    }
                }
                C5.e eVar = new C5.e(this, 2);
                k kVar = smartRefreshLayout.f3723X0;
                int i5 = smartRefreshLayout.b;
                if (i5 > 0) {
                    valueAnimatorA = kVar.a(0);
                } else {
                    if (aVarE != null || i5 == 0) {
                        ValueAnimator valueAnimator = smartRefreshLayout.f3736k1;
                        if (valueAnimator != null) {
                            valueAnimator.setDuration(0L);
                            smartRefreshLayout.f3736k1.cancel();
                            smartRefreshLayout.f3736k1 = null;
                        }
                        smartRefreshLayout.f3723X0.b(0, false);
                        smartRefreshLayout.f3723X0.setState(J2.b.None);
                    } else if (fVar.c && smartRefreshLayout.f3707K) {
                        int i6 = -smartRefreshLayout.f3706J0;
                        if (i5 >= i6) {
                            smartRefreshLayout.p(J2.b.None);
                        } else {
                            valueAnimatorA = kVar.a(i6);
                        }
                    } else {
                        valueAnimatorA = kVar.a(0);
                    }
                    valueAnimatorA = null;
                }
                if (valueAnimatorA == null) {
                    eVar.onAnimationEnd(null);
                } else {
                    valueAnimatorA.addListener(eVar);
                }
                break;
            case 1:
                ((C0421m) this.c).zzbc(null, this.b, k1.f2517k, zzjs.EXECUTE_ASYNC_TIMEOUT, null);
                break;
            default:
                xyz.doikki.videoplayer.player.e eVar2 = (xyz.doikki.videoplayer.player.e) this.c;
                xyz.doikki.videoplayer.player.g gVar = (xyz.doikki.videoplayer.player.g) eVar2.b.get();
                if (gVar != null) {
                    int i7 = this.b;
                    if (i7 != -3) {
                        if (i7 == -2 || i7 == -1) {
                            if (gVar.h()) {
                                eVar2.e = true;
                                gVar.pause();
                            }
                            break;
                        } else if (i7 == 1 || i7 == 2) {
                            if (eVar2.d || eVar2.e) {
                                gVar.start();
                                eVar2.d = false;
                                eVar2.e = false;
                            }
                            if (!gVar.f8998h && (cVar2 = gVar.f8995a) != null) {
                                cVar2.b.setVolume(1.0f, 1.0f);
                                break;
                            }
                        }
                    } else if (gVar.h() && !gVar.f8998h && (cVar = gVar.f8995a) != null) {
                        cVar.b.setVolume(0.1f, 0.1f);
                        break;
                    }
                }
                break;
        }
    }
}
