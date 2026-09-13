package H2;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class k implements I2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f303a;

    public k(SmartRefreshLayout smartRefreshLayout) {
        this.f303a = smartRefreshLayout;
    }

    public final ValueAnimator a(int i5) {
        SmartRefreshLayout smartRefreshLayout = this.f303a;
        return smartRefreshLayout.g(i5, 0, smartRefreshLayout.f3763z, smartRefreshLayout.f3729f);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x012c  */
    /* JADX WARN: Code duplicated, block: B:50:0x009a  */
    public final k b(int i5, boolean z6) {
        int i6;
        boolean z7;
        I2.c cVar;
        I2.d dVar;
        I2.c cVar2;
        Object obj;
        Object obj2;
        SmartRefreshLayout smartRefreshLayout = this.f303a;
        k kVar = smartRefreshLayout.f3723X0;
        if (smartRefreshLayout.b != i5 || (((obj = smartRefreshLayout.f3718S0) != null && ((M2.b) obj).a()) || ((obj2 = smartRefreshLayout.f3719T0) != null && ((M2.b) obj2).a()))) {
            int i7 = smartRefreshLayout.b;
            smartRefreshLayout.b = i5;
            float f6 = 10.0f;
            if (z6) {
                J2.b bVar = smartRefreshLayout.f3725Z0;
                if (bVar.d || bVar.e) {
                    float f7 = i5;
                    float f8 = smartRefreshLayout.f3714P0;
                    if (f8 < 10.0f) {
                        f8 *= smartRefreshLayout.f3702H0;
                    }
                    if (f7 <= f8) {
                        float f9 = -i5;
                        float f10 = smartRefreshLayout.f3716Q0;
                        if (f10 < 10.0f) {
                            f10 *= smartRefreshLayout.f3706J0;
                        }
                        if (f9 > f10 && !smartRefreshLayout.f3756v0) {
                            kVar.setState(J2.b.ReleaseToLoad);
                        } else if (i5 < 0 && !smartRefreshLayout.f3756v0) {
                            kVar.setState(J2.b.PullUpToLoad);
                        } else if (i5 > 0) {
                            kVar.setState(J2.b.PullDownToRefresh);
                        }
                    } else if (smartRefreshLayout.f3724Y0 != J2.b.ReleaseToTwoLevel) {
                        kVar.setState(J2.b.ReleaseToRefresh);
                    }
                }
            }
            O2.a aVar = smartRefreshLayout.f3720U0;
            J2.c cVar3 = J2.c.d;
            if (aVar != null) {
                if (i5 < 0) {
                    i6 = 0;
                    z7 = false;
                } else {
                    if (smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.f3703I, smartRefreshLayout.f3718S0)) {
                        i6 = i5;
                    } else if (i7 < 0) {
                        i6 = 0;
                    } else {
                        i6 = 0;
                        z7 = false;
                    }
                    z7 = true;
                }
                if (i5 <= 0) {
                    if (smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.f3705J, smartRefreshLayout.f3719T0)) {
                        i6 = i5;
                    } else if (i7 > 0) {
                        i6 = 0;
                    }
                    z7 = true;
                }
                if (z7) {
                    smartRefreshLayout.f3720U0.d(i6, smartRefreshLayout.f3749s, smartRefreshLayout.f3751t);
                    if (smartRefreshLayout.f3756v0 && smartRefreshLayout.f3758w0 && smartRefreshLayout.f3707K && (cVar2 = smartRefreshLayout.f3719T0) != null && cVar2.getSpinnerStyle() == cVar3 && smartRefreshLayout.n(smartRefreshLayout.f3695D)) {
                        smartRefreshLayout.f3719T0.getView().setTranslationY(Math.max(0, i6));
                    }
                    boolean z8 = smartRefreshLayout.f3699G;
                    J2.c cVar4 = J2.c.e;
                    boolean z9 = (z8 && (dVar = smartRefreshLayout.f3718S0) != null && dVar.getSpinnerStyle() == cVar4) || smartRefreshLayout.b1 != 0;
                    boolean z10 = (smartRefreshLayout.f3701H && (cVar = smartRefreshLayout.f3719T0) != null && cVar.getSpinnerStyle() == cVar4) || smartRefreshLayout.f3728c1 != 0;
                    if ((z9 && (i6 >= 0 || i7 > 0)) || (z10 && (i6 <= 0 || i7 < 0))) {
                        smartRefreshLayout.invalidate();
                    }
                }
            }
            float f11 = 1.0f;
            if ((i5 >= 0 || i7 > 0) && smartRefreshLayout.f3718S0 != null) {
                int iMax = Math.max(i5, 0);
                int i8 = smartRefreshLayout.f3702H0;
                float f12 = smartRefreshLayout.f3712N0;
                if (f12 < 10.0f) {
                    f12 *= i8;
                }
                int i9 = (int) f12;
                float f13 = iMax * 1.0f;
                float f14 = smartRefreshLayout.f3714P0;
                if (f14 < 10.0f) {
                    f14 *= i8;
                }
                float f15 = f13 / f14;
                if (smartRefreshLayout.n(smartRefreshLayout.f3693C) || (smartRefreshLayout.f3724Y0 == J2.b.RefreshFinish && !z6)) {
                    if (i7 != smartRefreshLayout.b) {
                        if (smartRefreshLayout.f3718S0.getSpinnerStyle() == cVar3) {
                            smartRefreshLayout.f3718S0.getView().setTranslationY(smartRefreshLayout.b);
                            if (smartRefreshLayout.b1 != 0 && smartRefreshLayout.f3721V0 != null && !smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.f3703I, smartRefreshLayout.f3718S0)) {
                                smartRefreshLayout.invalidate();
                            }
                        } else {
                            if (smartRefreshLayout.f3718S0.getSpinnerStyle().c) {
                                View view = smartRefreshLayout.f3718S0.getView();
                                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                                ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : SmartRefreshLayout.f3689o1;
                                view.measure(View.MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max((smartRefreshLayout.b - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0), 1073741824));
                                int i10 = marginLayoutParams.leftMargin;
                                int i11 = marginLayoutParams.topMargin + smartRefreshLayout.f3709L0;
                                view.layout(i10, i11, view.getMeasuredWidth() + i10, view.getMeasuredHeight() + i11);
                            }
                            smartRefreshLayout.f3718S0.onMoving(z6, f15, iMax, i8, i9);
                        }
                        smartRefreshLayout.f3718S0.onMoving(z6, f15, iMax, i8, i9);
                    } else {
                        f11 = 1.0f;
                        f6 = 10.0f;
                    }
                    if (z6 && ((M2.b) smartRefreshLayout.f3718S0).a()) {
                        int i12 = (int) smartRefreshLayout.f3733j;
                        int width = smartRefreshLayout.getWidth();
                        smartRefreshLayout.f3718S0.onHorizontalDrag(smartRefreshLayout.f3733j / (width == 0 ? 1 : width), i12, width);
                    }
                } else {
                    f11 = 1.0f;
                    f6 = 10.0f;
                }
            } else {
                f11 = 1.0f;
                f6 = 10.0f;
            }
            if ((i5 <= 0 || i7 < 0) && smartRefreshLayout.f3719T0 != null) {
                int i13 = -Math.min(i5, 0);
                int i14 = smartRefreshLayout.f3706J0;
                float f16 = smartRefreshLayout.f3713O0;
                if (f16 < f6) {
                    f16 *= i14;
                }
                int i15 = (int) f16;
                float f17 = i13 * f11;
                float f18 = smartRefreshLayout.f3716Q0;
                if (f18 < f6) {
                    f18 *= i14;
                }
                float f19 = f17 / f18;
                if (smartRefreshLayout.n(smartRefreshLayout.f3695D) || (smartRefreshLayout.f3724Y0 == J2.b.LoadFinish && !z6)) {
                    if (i7 != smartRefreshLayout.b) {
                        if (smartRefreshLayout.f3719T0.getSpinnerStyle() == cVar3) {
                            smartRefreshLayout.f3719T0.getView().setTranslationY(smartRefreshLayout.b);
                            if (smartRefreshLayout.f3728c1 != 0 && smartRefreshLayout.f3721V0 != null && !smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.f3705J, smartRefreshLayout.f3719T0)) {
                                smartRefreshLayout.invalidate();
                            }
                        } else if (smartRefreshLayout.f3719T0.getSpinnerStyle().c) {
                            View view2 = smartRefreshLayout.f3719T0.getView();
                            ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                            ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : SmartRefreshLayout.f3689o1;
                            view2.measure(View.MeasureSpec.makeMeasureSpec(view2.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(((-smartRefreshLayout.b) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0), 1073741824));
                            int i16 = marginLayoutParams2.leftMargin;
                            int measuredHeight = (smartRefreshLayout.getMeasuredHeight() + marginLayoutParams2.topMargin) - smartRefreshLayout.f3711M0;
                            view2.layout(i16, measuredHeight - view2.getMeasuredHeight(), view2.getMeasuredWidth() + i16, measuredHeight);
                        }
                        smartRefreshLayout.f3719T0.onMoving(z6, f19, i13, i14, i15);
                    }
                    if (z6 && ((M2.b) smartRefreshLayout.f3719T0).a()) {
                        int i17 = (int) smartRefreshLayout.f3733j;
                        int width2 = smartRefreshLayout.getWidth();
                        smartRefreshLayout.f3719T0.onHorizontalDrag(smartRefreshLayout.f3733j / (width2 == 0 ? 1 : width2), i17, width2);
                    }
                }
            }
        }
        return this;
    }

    @Override // I2.e
    @NonNull
    public I2.b getRefreshContent() {
        return this.f303a.f3720U0;
    }

    @Override // I2.e
    @NonNull
    public I2.f getRefreshLayout() {
        return this.f303a;
    }

    @Override // I2.e
    public I2.e requestDefaultTranslationContentFor(@NonNull I2.a aVar, boolean z6) {
        SmartRefreshLayout smartRefreshLayout = this.f303a;
        if (aVar.equals(smartRefreshLayout.f3718S0)) {
            if (!smartRefreshLayout.f3762y0) {
                smartRefreshLayout.f3762y0 = true;
                smartRefreshLayout.f3703I = z6;
                return this;
            }
        } else if (aVar.equals(smartRefreshLayout.f3719T0) && !smartRefreshLayout.f3764z0) {
            smartRefreshLayout.f3764z0 = true;
            smartRefreshLayout.f3705J = z6;
        }
        return this;
    }

    @Override // I2.e
    public I2.e requestDrawBackgroundFor(@NonNull I2.a aVar, int i5) {
        SmartRefreshLayout smartRefreshLayout = this.f303a;
        if (smartRefreshLayout.f3721V0 == null && i5 != 0) {
            smartRefreshLayout.f3721V0 = new Paint();
        }
        if (aVar.equals(smartRefreshLayout.f3718S0)) {
            smartRefreshLayout.b1 = i5;
            return this;
        }
        if (aVar.equals(smartRefreshLayout.f3719T0)) {
            smartRefreshLayout.f3728c1 = i5;
        }
        return this;
    }

    @Override // I2.e
    public I2.e requestNeedTouchEventFor(@NonNull I2.a aVar, boolean z6) {
        SmartRefreshLayout smartRefreshLayout = this.f303a;
        if (aVar.equals(smartRefreshLayout.f3718S0)) {
            smartRefreshLayout.d1 = z6;
            return this;
        }
        if (aVar.equals(smartRefreshLayout.f3719T0)) {
            smartRefreshLayout.e1 = z6;
        }
        return this;
    }

    @Override // I2.e
    public I2.e requestRemeasureHeightFor(@NonNull I2.a aVar) {
        SmartRefreshLayout smartRefreshLayout = this.f303a;
        if (aVar.equals(smartRefreshLayout.f3718S0)) {
            J2.a aVar2 = smartRefreshLayout.f3704I0;
            if (aVar2.b) {
                smartRefreshLayout.f3704I0 = aVar2.b();
                return this;
            }
        } else if (aVar.equals(smartRefreshLayout.f3719T0)) {
            J2.a aVar3 = smartRefreshLayout.f3708K0;
            if (aVar3.b) {
                smartRefreshLayout.f3708K0 = aVar3.b();
            }
        }
        return this;
    }

    @Override // I2.e
    public I2.e setState(@NonNull J2.b bVar) {
        SmartRefreshLayout smartRefreshLayout = this.f303a;
        boolean z6 = smartRefreshLayout.f3707K;
        boolean z7 = smartRefreshLayout.f3693C;
        switch (bVar) {
            case None:
                J2.b bVar2 = smartRefreshLayout.f3724Y0;
                J2.b bVar3 = J2.b.None;
                if (bVar2 != bVar3 && smartRefreshLayout.b == 0) {
                    smartRefreshLayout.p(bVar3);
                } else if (smartRefreshLayout.b != 0) {
                    a(0);
                }
                break;
            case PullDownToRefresh:
                if (!smartRefreshLayout.f3724Y0.e && smartRefreshLayout.n(z7)) {
                    smartRefreshLayout.p(J2.b.PullDownToRefresh);
                } else {
                    smartRefreshLayout.setViceState(J2.b.PullDownToRefresh);
                }
                break;
            case PullUpToLoad:
                if (smartRefreshLayout.n(smartRefreshLayout.f3695D)) {
                    J2.b bVar4 = smartRefreshLayout.f3724Y0;
                    if (!bVar4.e && !bVar4.f375f && (!smartRefreshLayout.f3756v0 || !z6 || !smartRefreshLayout.f3758w0)) {
                        smartRefreshLayout.p(J2.b.PullUpToLoad);
                    }
                }
                smartRefreshLayout.setViceState(J2.b.PullUpToLoad);
                break;
            case PullDownCanceled:
                if (!smartRefreshLayout.f3724Y0.e && smartRefreshLayout.n(z7)) {
                    smartRefreshLayout.p(J2.b.PullDownCanceled);
                    setState(J2.b.None);
                } else {
                    smartRefreshLayout.setViceState(J2.b.PullDownCanceled);
                }
                break;
            case PullUpCanceled:
                if (!smartRefreshLayout.n(smartRefreshLayout.f3695D) || smartRefreshLayout.f3724Y0.e || (smartRefreshLayout.f3756v0 && z6 && smartRefreshLayout.f3758w0)) {
                    smartRefreshLayout.setViceState(J2.b.PullUpCanceled);
                } else {
                    smartRefreshLayout.p(J2.b.PullUpCanceled);
                    setState(J2.b.None);
                }
                break;
            case ReleaseToRefresh:
                if (!smartRefreshLayout.f3724Y0.e && smartRefreshLayout.n(z7)) {
                    smartRefreshLayout.p(J2.b.ReleaseToRefresh);
                } else {
                    smartRefreshLayout.setViceState(J2.b.ReleaseToRefresh);
                }
                break;
            case ReleaseToLoad:
                if (smartRefreshLayout.n(smartRefreshLayout.f3695D)) {
                    J2.b bVar5 = smartRefreshLayout.f3724Y0;
                    if (!bVar5.e && !bVar5.f375f && (!smartRefreshLayout.f3756v0 || !z6 || !smartRefreshLayout.f3758w0)) {
                        smartRefreshLayout.p(J2.b.ReleaseToLoad);
                    }
                }
                smartRefreshLayout.setViceState(J2.b.ReleaseToLoad);
                break;
            case ReleaseToTwoLevel:
                if (!smartRefreshLayout.f3724Y0.e && smartRefreshLayout.n(z7)) {
                    smartRefreshLayout.p(J2.b.ReleaseToTwoLevel);
                } else {
                    smartRefreshLayout.setViceState(J2.b.ReleaseToTwoLevel);
                }
                break;
            case TwoLevelReleased:
            default:
                smartRefreshLayout.p(bVar);
                break;
            case RefreshReleased:
                if (!smartRefreshLayout.f3724Y0.e && smartRefreshLayout.n(z7)) {
                    smartRefreshLayout.p(J2.b.RefreshReleased);
                } else {
                    smartRefreshLayout.setViceState(J2.b.RefreshReleased);
                }
                break;
            case LoadReleased:
                if (!smartRefreshLayout.f3724Y0.e && smartRefreshLayout.n(smartRefreshLayout.f3695D)) {
                    smartRefreshLayout.p(J2.b.LoadReleased);
                } else {
                    smartRefreshLayout.setViceState(J2.b.LoadReleased);
                }
                break;
            case Refreshing:
                smartRefreshLayout.setStateRefreshing(true);
                break;
            case Loading:
                smartRefreshLayout.setStateLoading(true);
                break;
        }
        return null;
    }
}
