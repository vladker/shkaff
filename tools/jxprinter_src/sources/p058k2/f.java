package p058k2;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import p070m2.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f5478a;
    public int b;
    public int c;
    public final /* synthetic */ k d;

    public f(k kVar, Context context) {
        this.d = kVar;
        this.f5478a = new a(context);
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVar;
        ImageView imageViewH;
        a aVar = this.f5478a;
        if (aVar.f6118a.isFinished() || (imageViewH = (kVar = this.d).h()) == null || !aVar.f6118a.computeScrollOffset()) {
            return;
        }
        int currX = aVar.f6118a.getCurrX();
        int currY = aVar.f6118a.getCurrY();
        if (k.f5479y) {
            StringBuilder sb = new StringBuilder("fling run(). CurrentX:");
            sb.append(this.b);
            sb.append(" CurrentY:");
            androidx.exifinterface.media.a.y(sb, this.c, " NewX:", currX, " NewY:");
            sb.append(currY);
            Log.d("PhotoViewAttacher", sb.toString());
        }
        kVar.f5488l.postTranslate(this.b - currX, this.c - currY);
        kVar.m(kVar.g());
        this.b = currX;
        this.c = currY;
        a.b(imageViewH, this);
    }
}
