package p058k2;

import android.annotation.TargetApi;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public static int a(int i5) {
        return getPointerIndexHoneyComb(i5);
    }

    public static void b(ImageView imageView, Runnable runnable) {
        postOnAnimationJellyBean(imageView, runnable);
    }

    @TargetApi(5)
    private static int getPointerIndexEclair(int i5) {
        return (i5 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    @TargetApi(11)
    private static int getPointerIndexHoneyComb(int i5) {
        return (i5 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    @TargetApi(16)
    private static void postOnAnimationJellyBean(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
