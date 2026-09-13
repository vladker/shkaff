package com.idlefish.flutterboost;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterBoostUtils {
    private static boolean sEnableDebugLogging = false;

    public static Map<String, Object> bundleToMap(Bundle bundle) {
        HashMap map = new HashMap();
        if (bundle != null && !bundle.keySet().isEmpty()) {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof Bundle) {
                    map.put(str, bundleToMap(bundle.getBundle(str)));
                } else if (obj != null) {
                    map.put(str, obj);
                }
            }
        }
        return map;
    }

    public static PlatformChannel.SystemChromeStyle copySystemChromeStyle(PlatformChannel.SystemChromeStyle systemChromeStyle) {
        if (systemChromeStyle == null) {
            return null;
        }
        return new PlatformChannel.SystemChromeStyle(systemChromeStyle.statusBarColor, systemChromeStyle.statusBarIconBrightness, systemChromeStyle.systemStatusBarContrastEnforced, systemChromeStyle.systemNavigationBarColor, systemChromeStyle.systemNavigationBarIconBrightness, systemChromeStyle.systemNavigationBarDividerColor, systemChromeStyle.systemNavigationBarContrastEnforced);
    }

    public static String createUniqueId(String str) {
        return UUID.randomUUID().toString() + "_" + str;
    }

    public static FlutterView findFlutterView(View view) {
        if (view instanceof FlutterView) {
            return (FlutterView) view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
            FlutterView flutterViewFindFlutterView = findFlutterView(viewGroup.getChildAt(i5));
            if (flutterViewFindFlutterView != null) {
                return flutterViewFindFlutterView;
            }
        }
        return null;
    }

    @Nullable
    public static PlatformChannel.SystemChromeStyle getCurrentSystemUiOverlayTheme(PlatformPlugin platformPlugin, boolean z6) {
        if (platformPlugin == null) {
            return null;
        }
        try {
            Field declaredField = platformPlugin.getClass().getDeclaredField("currentTheme");
            declaredField.setAccessible(true);
            PlatformChannel.SystemChromeStyle systemChromeStyle = (PlatformChannel.SystemChromeStyle) declaredField.get(platformPlugin);
            if (z6 && systemChromeStyle != null) {
                return copySystemChromeStyle(systemChromeStyle);
            }
            return systemChromeStyle;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static FlutterBoostPlugin getPlugin(FlutterEngine flutterEngine) {
        if (flutterEngine == null) {
            return null;
        }
        try {
            return (FlutterBoostPlugin) flutterEngine.getPlugins().get(FlutterBoostPlugin.class);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean isDebugLoggingEnabled() {
        return sEnableDebugLogging;
    }

    public static PlatformChannel.SystemChromeStyle mergeSystemChromeStyle(PlatformChannel.SystemChromeStyle systemChromeStyle, PlatformChannel.SystemChromeStyle systemChromeStyle2) {
        if (systemChromeStyle2 == null) {
            return copySystemChromeStyle(systemChromeStyle);
        }
        if (systemChromeStyle == null) {
            return copySystemChromeStyle(systemChromeStyle2);
        }
        Integer num = systemChromeStyle2.statusBarColor;
        if (num == null) {
            num = systemChromeStyle.statusBarColor;
        }
        PlatformChannel.Brightness brightness = systemChromeStyle2.statusBarIconBrightness;
        if (brightness == null) {
            brightness = systemChromeStyle.statusBarIconBrightness;
        }
        Boolean bool = systemChromeStyle2.systemStatusBarContrastEnforced;
        if (bool == null) {
            bool = systemChromeStyle.systemStatusBarContrastEnforced;
        }
        Integer num2 = systemChromeStyle2.systemNavigationBarColor;
        if (num2 == null) {
            num2 = systemChromeStyle.systemNavigationBarColor;
        }
        PlatformChannel.Brightness brightness2 = systemChromeStyle2.systemNavigationBarIconBrightness;
        if (brightness2 == null) {
            brightness2 = systemChromeStyle.systemNavigationBarIconBrightness;
        }
        Integer num3 = systemChromeStyle2.systemNavigationBarDividerColor;
        if (num3 == null) {
            num3 = systemChromeStyle.systemNavigationBarDividerColor;
        }
        Boolean bool2 = systemChromeStyle2.systemNavigationBarContrastEnforced;
        if (bool2 == null) {
            bool2 = systemChromeStyle.systemNavigationBarContrastEnforced;
        }
        return new PlatformChannel.SystemChromeStyle(num, brightness, bool, num2, brightness2, num3, bool2);
    }

    public static void setDebugLoggingEnabled(boolean z6) {
        sEnableDebugLogging = z6;
    }

    public static void setSystemChromeSystemUIOverlayStyle(@NonNull PlatformPlugin platformPlugin, @NonNull PlatformChannel.SystemChromeStyle systemChromeStyle) {
        try {
            Method declaredMethod = platformPlugin.getClass().getDeclaredMethod("setSystemChromeSystemUIOverlayStyle", PlatformChannel.SystemChromeStyle.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(platformPlugin, systemChromeStyle);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e6) {
            e6.printStackTrace();
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }
}
