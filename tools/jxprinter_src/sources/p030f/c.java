package p030f;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.alibaba.android.arouter.core.InstrumentationHook;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.thread.DefaultPoolExecutor;
import com.alibaba.android.arouter.utils.DefaultLogger;
import com.alibaba.android.arouter.utils.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILogger f3955a = new DefaultLogger("ARouter::");
    public static volatile boolean b = false;
    public static volatile boolean c = false;
    public static volatile boolean d = false;
    public static volatile c e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f3956f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile ThreadPoolExecutor f3957g = DefaultPoolExecutor.getInstance();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Handler f3958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Application f3959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static InterceptorService f3960j;

    @Deprecated
    public static void attachBaseContext() {
        Log.i("ARouter::", "ARouter start attachBaseContext");
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            Field declaredField = cls.getDeclaredField("mInstrumentation");
            declaredField.setAccessible(true);
            declaredField.set(objInvoke, new InstrumentationHook());
            Log.i("ARouter::", "ARouter hook instrumentation success!");
        } catch (Exception e6) {
            Log.e("ARouter::", "ARouter hook instrumentation failed! [" + e6.getMessage() + "]");
        }
    }

    public static Postcard b(String str, String str2, Boolean bool) {
        PathReplaceService pathReplaceService;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        if (!bool.booleanValue() && (pathReplaceService = (PathReplaceService) ARouter.getInstance().navigation(PathReplaceService.class)) != null) {
            str = pathReplaceService.forString(str);
        }
        return new Postcard(str, str2);
    }

    public static synchronized void c() {
        try {
            if (c) {
                f3956f = false;
                LogisticsCenter.suspend();
                f3955a.info("ARouter::", "ARouter destroy success!");
            } else {
                f3955a.error("ARouter::", "Destroy can be used in debug mode only!");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Deprecated
    public static boolean canAutoInject() {
        return d;
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            throw new HandlerException("ARouter::Extract the default group failed, the path must be start with '/' and contain more than 2 '/'!");
        }
        try {
            String strSubstring = str.substring(1, str.indexOf(PackagingURIHelper.FORWARD_SLASH_STRING, 1));
            if (TextUtils.isEmpty(strSubstring)) {
                throw new HandlerException("ARouter::Extract the default group failed! There's nothing between 2 '/'!");
            }
            return strSubstring;
        } catch (Exception e6) {
            f3955a.warning("ARouter::", "Failed to extract default group! " + e6.getMessage());
            return null;
        }
    }

    public static c e() {
        if (!f3956f) {
            throw new InitException("ARouterCore::Init::Invoke init(context) first!");
        }
        if (e == null) {
            synchronized (c.class) {
                try {
                    if (e == null) {
                        e = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return e;
    }

    @Deprecated
    public static synchronized void enableAutoInject() {
        d = true;
    }

    public final Object a(Postcard postcard, int i5, NavigationCallback navigationCallback) {
        Context context = postcard.getContext();
        int i6 = b.f3954a[postcard.getType().ordinal()];
        if (i6 == 1) {
            Intent intent = new Intent(context, postcard.getDestination());
            intent.putExtras(postcard.getExtras());
            int flags = postcard.getFlags();
            if (flags != 0) {
                intent.setFlags(flags);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            String action = postcard.getAction();
            if (!TextUtils.isEmpty(action)) {
                intent.setAction(action);
            }
            a aVar = new a(this, i5, context, intent, postcard, navigationCallback);
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                f3958h.post(aVar);
                return null;
            }
            aVar.run();
            return null;
        }
        if (i6 == 2) {
            return postcard.getProvider();
        }
        if (i6 != 3 && i6 != 4 && i6 != 5) {
            return null;
        }
        try {
            Object objNewInstance = postcard.getDestination().getConstructor(null).newInstance(null);
            if (objNewInstance instanceof Fragment) {
                ((Fragment) objNewInstance).setArguments(postcard.getExtras());
                return objNewInstance;
            }
            if (objNewInstance instanceof androidx.fragment.app.Fragment) {
                ((androidx.fragment.app.Fragment) objNewInstance).setArguments(postcard.getExtras());
            }
            return objNewInstance;
        } catch (Exception e6) {
            f3955a.error("ARouter::", "Fetch fragment instance error, " + TextUtils.formatStackTrace(e6.getStackTrace()));
            return null;
        }
    }
}
