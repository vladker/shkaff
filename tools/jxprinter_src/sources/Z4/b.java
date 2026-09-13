package Z4;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collection;
import org.litepal.crud.d;
import org.litepal.crud.f;
import p013b5.c;
import p013b5.e;
import p079o.AbstractC1282k;
import p079o.J;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f903a = 0;

    static {
        new Handler(Looper.getMainLooper());
    }

    public static Object a(Class cls, long j6) {
        Object obj;
        synchronized (f.class) {
            ArrayList arrayListY = new d(p035f5.b.f()).y(cls, null, "id = ?", new String[]{String.valueOf(j6)}, null, null, null);
            obj = arrayListY.size() > 0 ? arrayListY.get(0) : null;
        }
        return obj;
    }

    @Deprecated
    public static p013b5.a averageAsync(Class<?> cls, String str) {
        return averageAsync(AbstractC1282k.a(J.k(cls.getName())), str);
    }

    public static Cursor b(String... strArr) {
        synchronized (f.class) {
            try {
                AbstractC1282k.b(strArr);
                String[] strArr2 = null;
                if (strArr.length <= 0) {
                    return null;
                }
                if (strArr.length != 1) {
                    strArr2 = new String[strArr.length - 1];
                    System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
                }
                return p035f5.b.f().rawQuery(strArr[0], strArr2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Deprecated
    public static p013b5.b countAsync(Class<?> cls) {
        return countAsync(AbstractC1282k.a(J.k(cls.getName())));
    }

    @Deprecated
    public static p013b5.f deleteAllAsync(Class<?> cls, String... strArr) {
        return new p013b5.f();
    }

    @Deprecated
    public static p013b5.f deleteAsync(Class<?> cls, long j6) {
        return new p013b5.f();
    }

    @Deprecated
    public static <T> p013b5.d findAllAsync(Class<T> cls, long... jArr) {
        return findAllAsync(cls, false, jArr);
    }

    @Deprecated
    public static <T> c findAsync(Class<T> cls, long j6) {
        return findAsync(cls, j6, false);
    }

    @Deprecated
    public static <T> c findFirstAsync(Class<T> cls) {
        return findFirstAsync(cls, false);
    }

    @Deprecated
    public static <T> c findLastAsync(Class<T> cls) {
        return findLastAsync(cls, false);
    }

    @Deprecated
    public static <T> c maxAsync(Class<?> cls, String str, Class<T> cls2) {
        return maxAsync(AbstractC1282k.a(J.k(cls.getName())), str, cls2);
    }

    @Deprecated
    public static <T> c minAsync(Class<?> cls, String str, Class<T> cls2) {
        return minAsync(AbstractC1282k.a(J.k(cls.getName())), str, cls2);
    }

    @Deprecated
    public static <T extends f> e saveAllAsync(Collection<T> collection) {
        return new e();
    }

    @Deprecated
    public static <T> c sumAsync(Class<?> cls, String str, Class<T> cls2) {
        return sumAsync(AbstractC1282k.a(J.k(cls.getName())), str, cls2);
    }

    @Deprecated
    public static p013b5.f updateAllAsync(Class<?> cls, ContentValues contentValues, String... strArr) {
        return updateAllAsync(AbstractC1282k.a(J.k(cls.getName())), contentValues, strArr);
    }

    @Deprecated
    public static p013b5.f updateAsync(Class<?> cls, ContentValues contentValues, long j6) {
        return new p013b5.f();
    }

    @Deprecated
    public static p013b5.a averageAsync(String str, String str2) {
        return new p013b5.a();
    }

    @Deprecated
    public static p013b5.b countAsync(String str) {
        return new p013b5.b();
    }

    @Deprecated
    public static <T> p013b5.d findAllAsync(Class<T> cls, boolean z6, long... jArr) {
        return new p013b5.d();
    }

    @Deprecated
    public static <T> c findAsync(Class<T> cls, long j6, boolean z6) {
        return new c();
    }

    @Deprecated
    public static <T> c findFirstAsync(Class<T> cls, boolean z6) {
        return new c();
    }

    @Deprecated
    public static <T> c findLastAsync(Class<T> cls, boolean z6) {
        return new c();
    }

    @Deprecated
    public static <T> c maxAsync(String str, String str2, Class<T> cls) {
        return new c();
    }

    @Deprecated
    public static <T> c minAsync(String str, String str2, Class<T> cls) {
        return new c();
    }

    @Deprecated
    public static <T> c sumAsync(String str, String str2, Class<T> cls) {
        return new c();
    }

    @Deprecated
    public static p013b5.f deleteAllAsync(String str, String... strArr) {
        return new p013b5.f();
    }

    @Deprecated
    public static p013b5.f updateAllAsync(String str, ContentValues contentValues, String... strArr) {
        return new p013b5.f();
    }
}
