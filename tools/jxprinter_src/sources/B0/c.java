package B0;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.C0524t;
import com.bumptech.glide.load.resource.bitmap.C0530z;
import com.bumptech.glide.load.resource.bitmap.r;
import p126w0.u;
import p126w0.v;
import p126w0.w;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements ImageDecoder$OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0530z f84a = C0530z.a();
    public final int b;
    public final int c;
    public final p126w0.b d;
    public final r e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f85f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final w f86g;

    public c(int i5, int i6, @NonNull v vVar) {
        this.b = i5;
        this.c = i6;
        this.d = (p126w0.b) vVar.get(C0524t.f3119f);
        this.e = (r) vVar.get(r.f3117f);
        u uVar = C0524t.f3122i;
        this.f85f = vVar.get(uVar) != null && ((Boolean) vVar.get(uVar)).booleanValue();
        this.f86g = (w) vVar.get(C0524t.f3120g);
    }

    public void onHeaderDecoded(@NonNull ImageDecoder imageDecoder, @NonNull ImageDecoder.ImageInfo imageInfo, @NonNull ImageDecoder.Source source) {
        if (this.f84a.b(this.b, this.c, this.f85f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.d == p126w0.b.b) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new b());
        Size size = imageInfo.getSize();
        int width = this.b;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.c;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fB = this.e.b(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fB);
        int iRound2 = Math.round(size.getHeight() * fB);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + iRound + "x" + iRound2 + "] scaleFactor: " + fB);
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        w wVar = this.f86g;
        if (wVar != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                imageDecoder.setTargetColorSpace(ColorSpace.get((wVar == w.f8814a && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
