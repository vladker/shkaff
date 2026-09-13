package com.alibaba.android.arouter.launcher;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.AutowiredService;
import com.alibaba.android.arouter.facade.service.DegradeService;
import com.alibaba.android.arouter.facade.service.InterceptorService;
import com.alibaba.android.arouter.facade.service.PathReplaceService;
import com.alibaba.android.arouter.facade.service.PretreatmentService;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.utils.TextUtils;
import com.android.billingclient.api.e1;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import p030f.c;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class ARouter {
    public static final String AUTO_INJECT = "wmHzgD4lOj5o4241";
    public static final String RAW_URI = "NTeRQWvye18AkPd6G";
    private static volatile boolean hasInit = false;
    private static volatile ARouter instance;
    public static ILogger logger;

    private ARouter() {
    }

    @Deprecated
    public static void attachBaseContext() {
        c.attachBaseContext();
    }

    @Deprecated
    public static boolean canAutoInject() {
        return c.canAutoInject();
    }

    public static boolean debuggable() {
        return c.c;
    }

    @Deprecated
    public static synchronized void enableAutoInject() {
        c.enableAutoInject();
    }

    public static ARouter getInstance() {
        if (!hasInit) {
            throw new InitException("ARouter::Init::Invoke init(context) first!");
        }
        if (instance == null) {
            synchronized (ARouter.class) {
                try {
                    if (instance == null) {
                        instance = new ARouter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public static void init(Application application) {
        if (hasInit) {
            return;
        }
        ILogger iLogger = c.f3955a;
        logger = iLogger;
        iLogger.info("ARouter::", "ARouter init start.");
        synchronized (c.class) {
            c.f3959i = application;
            LogisticsCenter.init(application, c.f3957g);
            c.f3955a.info("ARouter::", "ARouter init success!");
            c.f3956f = true;
            c.f3958h = new Handler(Looper.getMainLooper());
        }
        hasInit = true;
        if (hasInit) {
            c.f3960j = (InterceptorService) getInstance().build("/arouter/service/interceptor").navigation();
        }
        c.f3955a.info("ARouter::", "ARouter init over.");
    }

    public static boolean isMonitorMode() {
        return c.b;
    }

    public static synchronized void monitorMode() {
        ILogger iLogger = c.f3955a;
        synchronized (c.class) {
            c.b = true;
            c.f3955a.info("ARouter::", "ARouter monitorMode on");
        }
    }

    public static synchronized void openDebug() {
        ILogger iLogger = c.f3955a;
        synchronized (c.class) {
            c.c = true;
            c.f3955a.info("ARouter::", "ARouter openDebug");
        }
    }

    public static synchronized void openLog() {
        ILogger iLogger = c.f3955a;
        synchronized (c.class) {
            c.f3955a.showLog(true);
            c.f3955a.info("ARouter::", "ARouter openLog");
        }
    }

    public static synchronized void printStackTrace() {
        ILogger iLogger = c.f3955a;
        synchronized (c.class) {
            c.f3955a.showStackTrace(true);
            c.f3955a.info("ARouter::", "ARouter printStackTrace");
        }
    }

    public static synchronized void setExecutor(ThreadPoolExecutor threadPoolExecutor) {
        ILogger iLogger = c.f3955a;
        synchronized (c.class) {
            c.f3957g = threadPoolExecutor;
        }
    }

    public static void setLogger(ILogger iLogger) {
        if (iLogger != null) {
            c.f3955a = iLogger;
        } else {
            ILogger iLogger2 = c.f3955a;
        }
    }

    public boolean addRouteGroup(IRouteGroup iRouteGroup) {
        c.e().getClass();
        if (iRouteGroup != null) {
            try {
                HashMap map = new HashMap();
                iRouteGroup.loadInto(map);
                String str = null;
                for (Map.Entry entry : map.entrySet()) {
                    String strD = c.d((String) entry.getKey());
                    RouteMeta routeMeta = (RouteMeta) entry.getValue();
                    if (str == null) {
                        str = strD;
                    }
                    if (str != null && str.equals(strD) && str.equals(routeMeta.getGroup())) {
                    }
                }
                LogisticsCenter.addRouteGroupDynamic(str, iRouteGroup);
                c.f3955a.info("ARouter::", "Add route group [" + str + "] finish, " + map.size() + " new route meta.");
                return true;
            } catch (Exception e) {
                c.f3955a.error("ARouter::", "Add route group dynamic exception!", e);
                return false;
            }
        }
        return false;
    }

    public Postcard build(String str) {
        c.e().getClass();
        if (TextUtils.isEmpty(str)) {
            throw new HandlerException("ARouter::Parameter is invalid!");
        }
        PathReplaceService pathReplaceService = (PathReplaceService) getInstance().navigation(PathReplaceService.class);
        if (pathReplaceService != null) {
            str = pathReplaceService.forString(str);
        }
        return c.b(str, c.d(str), Boolean.TRUE);
    }

    public synchronized void destroy() {
        c.c();
        hasInit = false;
    }

    public void inject(Object obj) {
        ILogger iLogger = c.f3955a;
        AutowiredService autowiredService = (AutowiredService) getInstance().build("/arouter/service/autowired").navigation();
        if (autowiredService != null) {
            autowiredService.autowire(obj);
        }
    }

    public <T> T navigation(Class<? extends T> cls) {
        c.e().getClass();
        try {
            Postcard postcardBuildProvider = LogisticsCenter.buildProvider(cls.getName());
            if (postcardBuildProvider == null) {
                postcardBuildProvider = LogisticsCenter.buildProvider(cls.getSimpleName());
            }
            if (postcardBuildProvider == null) {
                return null;
            }
            postcardBuildProvider.setContext(c.f3959i);
            LogisticsCenter.completion(postcardBuildProvider);
            return (T) postcardBuildProvider.getProvider();
        } catch (NoRouteFoundException e) {
            c.f3955a.warning("ARouter::", e.getMessage());
            return null;
        }
    }

    @Deprecated
    public Postcard build(String str, String str2) {
        c cVarE = c.e();
        Boolean bool = Boolean.FALSE;
        cVarE.getClass();
        return c.b(str, str2, bool);
    }

    public Postcard build(Uri uri) {
        c.e().getClass();
        if (uri != null && !TextUtils.isEmpty(uri.toString())) {
            PathReplaceService pathReplaceService = (PathReplaceService) getInstance().navigation(PathReplaceService.class);
            if (pathReplaceService != null) {
                uri = pathReplaceService.forUri(uri);
            }
            return new Postcard(uri.getPath(), c.d(uri.getPath()), uri, null);
        }
        throw new HandlerException("ARouter::Parameter invalid!");
    }

    public Object navigation(Context context, Postcard postcard, int i5, NavigationCallback navigationCallback) {
        c cVarE = c.e();
        cVarE.getClass();
        PretreatmentService pretreatmentService = (PretreatmentService) getInstance().navigation(PretreatmentService.class);
        if (pretreatmentService == null || pretreatmentService.onPretreatment(context, postcard)) {
            postcard.setContext(context == null ? c.f3959i : context);
            try {
                LogisticsCenter.completion(postcard);
                if (navigationCallback != null) {
                    navigationCallback.onFound(postcard);
                }
                if (!postcard.isGreenChannel()) {
                    c.f3960j.doInterceptions(postcard, new e1(cVarE, i5, navigationCallback, postcard));
                    return null;
                }
                return cVarE.a(postcard, i5, navigationCallback);
            } catch (NoRouteFoundException e) {
                c.f3955a.warning("ARouter::", e.getMessage());
                if (c.c) {
                    H2.c cVar = new H2.c(postcard, 13);
                    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                        c.f3958h.post(cVar);
                    } else {
                        cVar.run();
                    }
                }
                if (navigationCallback != null) {
                    navigationCallback.onLost(postcard);
                } else {
                    DegradeService degradeService = (DegradeService) getInstance().navigation(DegradeService.class);
                    if (degradeService != null) {
                        degradeService.onLost(context, postcard);
                    }
                }
            }
        }
        return null;
    }
}
