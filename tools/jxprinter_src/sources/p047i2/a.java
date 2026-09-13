package p047i2;

import I0.j;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.bumptech.glide.A;
import com.bumptech.glide.load.engine.AbstractC0501q;
import com.bumptech.glide.load.resource.bitmap.C0516k;
import com.bumptech.glide.load.resource.bitmap.M;
import p035f5.b;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static A f4045a;
    public static Context b;

    public static void a(ImageView imageView, String str) {
        loadPicture(str, imageView, true, 1, 1, null, -1);
    }

    public static void b(String str, ImageView imageView, int i5) {
        loadPicture(str, imageView, true, 3, 3, 10, i5);
    }

    public static void loadBitmapFitCenter(Bitmap bitmap, ImageView imageView, @DrawableRes int i5) {
        loadPicture(bitmap, imageView, false, 3, 1, null, i5);
    }

    public static void loadCirclePicture(String str, ImageView imageView, @DrawableRes int i5) {
        loadPicture(str, imageView, true, 1, 2, null, i5);
    }

    public static void loadDrawableFileFitCenter(String str, ImageView imageView, @DrawableRes int i5) {
        loadPicture(str, imageView, true, 3, 1, null, i5);
    }

    public static void loadDrawableRes(@DrawableRes int i5, ImageView imageView) {
        loadPicture(Integer.valueOf(i5), imageView, true, 2, 1, null, -1);
    }

    public static void loadPicture(Object obj, ImageView imageView, boolean z6, int i5, int i6, Integer num, @DrawableRes int i7) {
        if (b == null || f4045a == null) {
            p051j0.a.k("GlideUtil", "GlideUtilnot initComponent");
            return;
        }
        j jVar = new j();
        if (i5 == 2) {
            jVar.centerCrop();
        } else if (i5 == 3) {
            jVar.fitCenter();
        }
        if (i6 == 2) {
            jVar = j.bitmapTransform(new C0516k());
        }
        if (i6 == 3 && num != null && num.intValue() > 0) {
            jVar = j.bitmapTransform(new M(b.d(num.intValue())));
        }
        if (z6) {
            jVar.diskCacheStrategy(AbstractC0501q.c);
        } else {
            jVar.diskCacheStrategy(AbstractC0501q.f3068a);
        }
        if (i7 != -1) {
            jVar.placeholder(i7);
        }
        f4045a.load(obj).apply((I0.a) jVar).into(imageView);
    }

    public static void loadPictureCenterCrop(String str, ImageView imageView, @DrawableRes int i5) {
        loadPicture(str, imageView, true, 2, 1, null, i5);
    }

    public static void loadPictureFitCenter(String str, ImageView imageView, @DrawableRes int i5) {
        loadPicture(str, imageView, true, 3, 1, null, i5);
    }

    public static void loadPicture(String str, ImageView imageView, @DrawableRes int i5) {
        loadPicture(str, imageView, true, 1, 1, null, i5);
    }
}
