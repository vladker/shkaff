package p030f;

import com.alibaba.android.arouter.facade.enums.RouteType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f3954a;

    static {
        int[] iArr = new int[RouteType.values().length];
        f3954a = iArr;
        try {
            iArr[RouteType.ACTIVITY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3954a[RouteType.PROVIDER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3954a[RouteType.BOARDCAST.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3954a[RouteType.CONTENT_PROVIDER.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f3954a[RouteType.FRAGMENT.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f3954a[RouteType.METHOD.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f3954a[RouteType.SERVICE.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
    }
}
