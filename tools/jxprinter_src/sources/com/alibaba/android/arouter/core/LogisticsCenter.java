package com.alibaba.android.arouter.core;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.android.arouter.utils.ClassUtils;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.android.arouter.utils.MapUtils;
import com.alibaba.android.arouter.utils.PackageUtils;
import com.alibaba.android.arouter.utils.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class LogisticsCenter {
    static ThreadPoolExecutor executor;
    private static Context mContext;
    private static boolean registerByPlugin;

    public static synchronized void addRouteGroupDynamic(String str, IRouteGroup iRouteGroup) {
        try {
            HashMap map = b.f2417a;
            if (map.containsKey(str)) {
                ((IRouteGroup) ((Class) map.get(str)).getConstructor(null).newInstance(null)).loadInto(b.b);
                map.remove(str);
            }
            if (iRouteGroup != null) {
                iRouteGroup.loadInto(b.b);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Postcard buildProvider(String str) {
        RouteMeta routeMeta = (RouteMeta) b.d.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void completion(Postcard postcard) {
        try {
            if (postcard == null) {
                throw new NoRouteFoundException("ARouter::No postcard!");
            }
            RouteMeta routeMeta = (RouteMeta) b.b.get(postcard.getPath());
            if (routeMeta != null) {
                postcard.setDestination(routeMeta.getDestination());
                postcard.setType(routeMeta.getType());
                postcard.setPriority(routeMeta.getPriority());
                postcard.setExtra(routeMeta.getExtra());
                Uri uri = postcard.getUri();
                if (uri != null) {
                    Map<String, String> mapSplitQueryParameters = TextUtils.splitQueryParameters(uri);
                    Map<String, Integer> paramsType = routeMeta.getParamsType();
                    if (MapUtils.isNotEmpty(paramsType)) {
                        for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                            setValue(postcard, entry.getValue(), entry.getKey(), mapSplitQueryParameters.get(entry.getKey()));
                        }
                        postcard.getExtras().putStringArray(ARouter.AUTO_INJECT, (String[]) paramsType.keySet().toArray(new String[0]));
                    }
                    postcard.withString(ARouter.RAW_URI, uri.toString());
                }
                int i5 = a.f2416a[routeMeta.getType().ordinal()];
                if (i5 == 1) {
                    Class<?> destination = routeMeta.getDestination();
                    HashMap map = b.c;
                    IProvider iProvider = (IProvider) map.get(destination);
                    if (iProvider == null) {
                        try {
                            iProvider = (IProvider) destination.getConstructor(null).newInstance(null);
                            iProvider.init(mContext);
                            map.put(destination, iProvider);
                        } catch (Exception e) {
                            ARouter.logger.error("ARouter::", "Init provider failed!", e);
                            throw new HandlerException("Init provider failed!");
                        }
                    }
                    postcard.setProvider(iProvider);
                    postcard.greenChannel();
                } else if (i5 == 2) {
                    postcard.greenChannel();
                }
            } else {
                if (!b.f2417a.containsKey(postcard.getGroup())) {
                    throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
                }
                try {
                    if (ARouter.debuggable()) {
                        ILogger iLogger = ARouter.logger;
                        Locale.getDefault();
                        iLogger.debug("ARouter::", "The group [" + postcard.getGroup() + "] starts loading, trigger by [" + postcard.getPath() + "]");
                    }
                    addRouteGroupDynamic(postcard.getGroup(), null);
                    if (ARouter.debuggable()) {
                        ILogger iLogger2 = ARouter.logger;
                        Locale.getDefault();
                        iLogger2.debug("ARouter::", "The group [" + postcard.getGroup() + "] has already been loaded, trigger by [" + postcard.getPath() + "]");
                    }
                    completion(postcard);
                } catch (Exception e6) {
                    throw new HandlerException("ARouter::Fatal exception when loading group meta. [" + e6.getMessage() + "]");
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void init(Context context, ThreadPoolExecutor threadPoolExecutor) {
        Set<String> fileNameByPackageName;
        try {
            mContext = context;
            executor = threadPoolExecutor;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                loadRouterMap();
                if (registerByPlugin) {
                    ARouter.logger.info("ARouter::", "Load router map by arouter-auto-register plugin.");
                } else {
                    if (ARouter.debuggable() || PackageUtils.isNewVersion(context)) {
                        ARouter.logger.info("ARouter::", "Run with debug mode or new install, rebuild router map.");
                        fileNameByPackageName = ClassUtils.getFileNameByPackageName(mContext, Consts.ROUTE_ROOT_PAKCAGE);
                        if (!fileNameByPackageName.isEmpty()) {
                            context.getSharedPreferences(Consts.AROUTER_SP_CACHE_KEY, 0).edit().putStringSet(Consts.AROUTER_SP_KEY_MAP, fileNameByPackageName).apply();
                        }
                        PackageUtils.updateVersion(context);
                    } else {
                        ARouter.logger.info("ARouter::", "Load router map from cache.");
                        fileNameByPackageName = new HashSet<>(context.getSharedPreferences(Consts.AROUTER_SP_CACHE_KEY, 0).getStringSet(Consts.AROUTER_SP_KEY_MAP, new HashSet()));
                    }
                    ARouter.logger.info("ARouter::", "Find router map finished, map size = " + fileNameByPackageName.size() + ", cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                    jCurrentTimeMillis = System.currentTimeMillis();
                    for (String str : fileNameByPackageName) {
                        if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Root")) {
                            ((IRouteRoot) Class.forName(str).getConstructor(null).newInstance(null)).loadInto(b.f2417a);
                        } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Interceptors")) {
                            ((IInterceptorGroup) Class.forName(str).getConstructor(null).newInstance(null)).loadInto(b.e);
                        } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Providers")) {
                            ((IProviderGroup) Class.forName(str).getConstructor(null).newInstance(null)).loadInto(b.d);
                        }
                    }
                }
                ARouter.logger.info("ARouter::", "Load root element finished, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                HashMap map = b.f2417a;
                if (map.size() == 0) {
                    ARouter.logger.error("ARouter::", "No mapping files were found, check your configuration please!");
                }
                if (ARouter.debuggable()) {
                    ARouter.logger.debug("ARouter::", String.format(Locale.getDefault(), "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]", Integer.valueOf(map.size()), Integer.valueOf(b.e.size()), Integer.valueOf(b.d.size())));
                }
            } catch (Exception e) {
                throw new HandlerException("ARouter::ARouter init logistics center exception! [" + e.getMessage() + "]");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private static void loadRouterMap() {
        registerByPlugin = false;
    }

    private static void markRegisteredByPlugin() {
        if (registerByPlugin) {
            return;
        }
        registerByPlugin = true;
    }

    private static void register(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Object objNewInstance = Class.forName(str).getConstructor(null).newInstance(null);
            if (objNewInstance instanceof IRouteRoot) {
                registerRouteRoot((IRouteRoot) objNewInstance);
                return;
            }
            if (objNewInstance instanceof IProviderGroup) {
                registerProvider((IProviderGroup) objNewInstance);
                return;
            }
            if (objNewInstance instanceof IInterceptorGroup) {
                registerInterceptor((IInterceptorGroup) objNewInstance);
                return;
            }
            ARouter.logger.info("ARouter::", "register failed, class name: " + str + " should implements one of IRouteRoot/IProviderGroup/IInterceptorGroup.");
        } catch (Exception e) {
            ARouter.logger.error("ARouter::", "register class error:" + str, e);
        }
    }

    private static void registerInterceptor(IInterceptorGroup iInterceptorGroup) {
        markRegisteredByPlugin();
        if (iInterceptorGroup != null) {
            iInterceptorGroup.loadInto(b.e);
        }
    }

    private static void registerProvider(IProviderGroup iProviderGroup) {
        markRegisteredByPlugin();
        if (iProviderGroup != null) {
            iProviderGroup.loadInto(b.d);
        }
    }

    private static void registerRouteRoot(IRouteRoot iRouteRoot) {
        markRegisteredByPlugin();
        if (iRouteRoot != null) {
            iRouteRoot.loadInto(b.f2417a);
        }
    }

    private static void setValue(Postcard postcard, Integer num, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            if (num == null) {
                postcard.withString(str, str2);
                return;
            }
            if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                postcard.withBoolean(str, Boolean.parseBoolean(str2));
                return;
            }
            if (num.intValue() == TypeKind.BYTE.ordinal()) {
                postcard.withByte(str, Byte.parseByte(str2));
                return;
            }
            if (num.intValue() == TypeKind.SHORT.ordinal()) {
                postcard.withShort(str, Short.parseShort(str2));
                return;
            }
            if (num.intValue() == TypeKind.INT.ordinal()) {
                postcard.withInt(str, Integer.parseInt(str2));
                return;
            }
            if (num.intValue() == TypeKind.LONG.ordinal()) {
                postcard.withLong(str, Long.parseLong(str2));
                return;
            }
            if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                postcard.withFloat(str, Float.parseFloat(str2));
                return;
            }
            if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                postcard.withDouble(str, Double.parseDouble(str2));
                return;
            }
            if (num.intValue() == TypeKind.STRING.ordinal()) {
                postcard.withString(str, str2);
            } else {
                if (num.intValue() == TypeKind.PARCELABLE.ordinal()) {
                    return;
                }
                if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(str, str2);
                } else {
                    postcard.withString(str, str2);
                }
            }
        } catch (Throwable th) {
            ARouter.logger.warning("ARouter::", "LogisticsCenter setValue failed! " + th.getMessage());
        }
    }

    public static void suspend() {
        b.b.clear();
        b.f2417a.clear();
        b.c.clear();
        b.d.clear();
        b.f2418f.clear();
        b.e.clear();
    }
}
