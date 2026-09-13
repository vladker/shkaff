package D1;

import android.graphics.RectF;
import android.util.TypedValue;
import com.github.barteksc.pdfviewer.PDFView;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PDFView f175a;
    public int b;
    public float c;
    public float d;
    public float e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f177g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f178h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f179i = new RectF(0.0f, 0.0f, 1.0f, 1.0f);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f180j;

    public l(PDFView pDFView) {
        this.f175a = pDFView;
        this.f180j = (int) TypedValue.applyDimension(1, 20, pDFView.getContext().getResources().getDisplayMetrics());
    }
}
