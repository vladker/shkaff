package J0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.bumptech.glide.load.resource.bitmap.Q;
import io.reactivex.internal.operators.observable.C0949w2;
import io.reactivex.internal.operators.observable.InterfaceC0901m2;
import io.reactivex.internal.operators.observable.InterfaceC0925r2;
import p050j.p;
import p050j.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements Q, InterfaceC0901m2, p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f347a;

    public /* synthetic */ f(int i5) {
        this.f347a = i5;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.Q
    public void a(Canvas canvas, Paint paint, RectF rectF) {
        float f6 = this.f347a;
        canvas.drawRoundRect(rectF, f6, f6, paint);
    }

    @Override // p050j.p
    public Object c(r rVar, Object obj, Object obj2) {
        return r.b(this.f347a, obj2);
    }

    @Override // io.reactivex.internal.operators.observable.InterfaceC0901m2
    public InterfaceC0925r2 call() {
        return new C0949w2(this.f347a);
    }
}
