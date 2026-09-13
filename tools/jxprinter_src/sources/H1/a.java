package H1;

import android.graphics.Bitmap;
import android.graphics.RectF;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f291a;
    public final Bitmap b;
    public final RectF c;
    public final boolean d;
    public int e;

    public a(int i5, Bitmap bitmap, RectF rectF, boolean z6, int i6) {
        this.f291a = i5;
        this.b = bitmap;
        this.c = rectF;
        this.d = z6;
        this.e = i6;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f291a == this.f291a) {
            RectF rectF = aVar.c;
            float f6 = rectF.left;
            RectF rectF2 = this.c;
            if (f6 == rectF2.left && rectF.right == rectF2.right && rectF.top == rectF2.top && rectF.bottom == rectF2.bottom) {
                return true;
            }
        }
        return false;
    }
}
