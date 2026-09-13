package M2;

import H2.j;
import H2.k;
import I2.d;
import I2.e;
import I2.f;
import J2.c;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends RelativeLayout implements I2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f471a;
    public c b;
    public final I2.a c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NonNull View view) {
        this(view, view instanceof I2.a ? (I2.a) view : null);
    }

    public final boolean a() {
        I2.a aVar = this.c;
        return (aVar == null || aVar == this || !((b) aVar).a()) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof I2.a) && getView() == ((I2.a) obj).getView();
    }

    @Override // I2.a
    @NonNull
    public c getSpinnerStyle() {
        int i5;
        c cVar = this.b;
        if (cVar != null) {
            return cVar;
        }
        I2.a aVar = this.c;
        if (aVar != null && aVar != this) {
            return aVar.getSpinnerStyle();
        }
        View view = this.f471a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof j) {
                c cVar2 = ((j) layoutParams).b;
                this.b = cVar2;
                if (cVar2 != null) {
                    return cVar2;
                }
            }
            if (layoutParams != null && ((i5 = layoutParams.height) == 0 || i5 == -1)) {
                for (int i6 = 0; i6 < 5; i6++) {
                    c cVar3 = c.f379h[i6];
                    if (cVar3.c) {
                        this.b = cVar3;
                        return cVar3;
                    }
                }
            }
        }
        c cVar4 = c.d;
        this.b = cVar4;
        return cVar4;
    }

    @Override // I2.a
    @NonNull
    public View getView() {
        View view = this.f471a;
        return view == null ? this : view;
    }

    public int onFinish(@NonNull f fVar, boolean z6) {
        I2.a aVar = this.c;
        if (aVar == null || aVar == this) {
            return 0;
        }
        return aVar.onFinish(fVar, z6);
    }

    @Override // I2.a
    public final void onHorizontalDrag(float f6, int i5, int i6) {
        I2.a aVar = this.c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.onHorizontalDrag(f6, i5, i6);
    }

    public void onInitialized(@NonNull e eVar, int i5, int i6) {
        I2.a aVar = this.c;
        if (aVar != null && aVar != this) {
            aVar.onInitialized(eVar, i5, i6);
            return;
        }
        View view = this.f471a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof j) {
                ((k) eVar).requestDrawBackgroundFor(this, ((j) layoutParams).f302a);
            }
        }
    }

    @Override // I2.a
    public final void onMoving(boolean z6, float f6, int i5, int i6, int i7) {
        I2.a aVar = this.c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.onMoving(z6, f6, i5, i6, i7);
    }

    public void onReleased(@NonNull f fVar, int i5, int i6) {
        I2.a aVar = this.c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.onReleased(fVar, i5, i6);
    }

    public void onStartAnimator(@NonNull f fVar, int i5, int i6) {
        I2.a aVar = this.c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.onStartAnimator(fVar, i5, i6);
    }

    public void onStateChanged(@NonNull f fVar, @NonNull J2.b bVar, @NonNull J2.b bVar2) {
        I2.a aVar = this.c;
        if (aVar == null || aVar == this) {
            return;
        }
        if ((this instanceof I2.c) && (aVar instanceof d)) {
            boolean z6 = bVar.b;
            if (z6 && z6 && !bVar.c) {
                bVar = J2.b.values()[bVar.ordinal() - 1];
            }
            boolean z7 = bVar2.b;
            if (z7 && z7 && !bVar2.c) {
                bVar2 = J2.b.values()[bVar2.ordinal() - 1];
            }
        } else if ((this instanceof d) && (aVar instanceof I2.c)) {
            boolean z8 = bVar.f374a;
            if (z8 && z8 && !bVar.c) {
                bVar = J2.b.values()[bVar.ordinal() + 1];
            }
            boolean z9 = bVar2.f374a;
            if (z9 && z9 && !bVar2.c) {
                bVar2 = J2.b.values()[bVar2.ordinal() + 1];
            }
        }
        aVar.onStateChanged(fVar, bVar, bVar2);
    }

    @SuppressLint({"RestrictedApi"})
    public boolean setNoMoreData(boolean z6) {
        I2.a aVar = this.c;
        return (aVar instanceof I2.c) && ((I2.c) aVar).setNoMoreData(z6);
    }

    public void setPrimaryColors(@ColorInt int... iArr) {
        I2.a aVar = this.c;
        if (aVar == null || aVar == this) {
            return;
        }
        aVar.setPrimaryColors(iArr);
    }

    public b(@NonNull View view, @Nullable I2.a aVar) {
        super(view.getContext(), null, 0);
        this.f471a = view;
        this.c = aVar;
        boolean z6 = this instanceof I2.c;
        c cVar = c.f378g;
        if (z6 && (aVar instanceof d) && aVar.getSpinnerStyle() == cVar) {
            aVar.getView().setScaleY(-1.0f);
        } else if ((this instanceof d) && (aVar instanceof I2.c) && aVar.getSpinnerStyle() == cVar) {
            aVar.getView().setScaleY(-1.0f);
        }
    }
}
