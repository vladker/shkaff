package L0;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.common.primitives.UnsignedBytes;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f411a = "0123456789abcdef".toCharArray();
    public static final char[] b = new char[64];

    @Nullable
    private static volatile Handler mainThreadHandler;

    public static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static Handler b() {
        if (mainThreadHandler == null) {
            synchronized (s.class) {
                try {
                    if (mainThreadHandler == null) {
                        mainThreadHandler = new Handler(Looper.getMainLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return mainThreadHandler;
    }

    public static boolean bothModelsNullEquivalentOrEquals(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static boolean bothNullOrEqual(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @NonNull
    private static String bytesToHex(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i5 = 0; i5 < bArr.length; i5++) {
            byte b6 = bArr[i5];
            int i6 = i5 * 2;
            int i7 = (b6 & UnsignedBytes.MAX_VALUE) >>> 4;
            char[] cArr2 = f411a;
            cArr[i6] = cArr2[i7];
            cArr[i6 + 1] = cArr2[b6 & 15];
        }
        return new String(cArr);
    }

    public static int c(int i5, int i6) {
        return (i6 * 31) + i5;
    }

    @NonNull
    public static <T> Queue<T> createQueue(int i5) {
        return new ArrayDeque(i5);
    }

    public static boolean d() {
        return !(Looper.myLooper() == Looper.getMainLooper());
    }

    public static boolean e(int i5, int i6) {
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            return i6 > 0 || i6 == Integer.MIN_VALUE;
        }
        return false;
    }

    @TargetApi(19)
    public static int getBitmapByteSize(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int getBytesPerPixel(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i5 = r.f410a[config.ordinal()];
        int i6 = 1;
        if (i5 != 1) {
            i6 = 2;
            if (i5 != 2 && i5 != 3) {
                return i5 != 4 ? 4 : 8;
            }
        }
        return i6;
    }

    @Deprecated
    public static int getSize(@NonNull Bitmap bitmap) {
        return getBitmapByteSize(bitmap);
    }

    @NonNull
    public static <T> List<T> getSnapshot(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t6 : collection) {
            if (t6 != null) {
                arrayList.add(t6);
            }
        }
        return arrayList;
    }

    public static int hashCode(@Nullable Object obj, int i5) {
        return c(obj == null ? 0 : obj.hashCode(), i5);
    }

    @NonNull
    public static String sha256BytesToHex(@NonNull byte[] bArr) {
        String strBytesToHex;
        char[] cArr = b;
        synchronized (cArr) {
            strBytesToHex = bytesToHex(bArr, cArr);
        }
        return strBytesToHex;
    }

    public static int getBitmapByteSize(int i5, int i6, @Nullable Bitmap.Config config) {
        return getBytesPerPixel(config) * i5 * i6;
    }
}
