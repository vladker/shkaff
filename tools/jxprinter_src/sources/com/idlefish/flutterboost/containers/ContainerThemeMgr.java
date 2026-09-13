package com.idlefish.flutterboost.containers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.idlefish.flutterboost.FlutterBoostUtils;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ContainerThemeMgr {
    private static PlatformChannel.SystemChromeStyle finalStyle;
    private static final HashMap<Integer, PlatformChannel.SystemChromeStyle> themes = new HashMap<>();

    @Nullable
    public static PlatformChannel.SystemChromeStyle findTheme(@NonNull FlutterBoostActivity flutterBoostActivity) {
        return themes.get(Integer.valueOf(flutterBoostActivity.hashCode()));
    }

    public static PlatformChannel.SystemChromeStyle getFinalStyle() {
        return FlutterBoostUtils.copySystemChromeStyle(finalStyle);
    }

    @UiThread
    public static void onActivityDestroy(@NonNull FlutterBoostActivity flutterBoostActivity) {
        HashMap<Integer, PlatformChannel.SystemChromeStyle> map = themes;
        PlatformChannel.SystemChromeStyle systemChromeStyleRemove = map.remove(Integer.valueOf(flutterBoostActivity.hashCode()));
        if (map.isEmpty()) {
            finalStyle = systemChromeStyleRemove;
        }
    }

    @UiThread
    public static void onActivityPause(@NonNull FlutterBoostActivity flutterBoostActivity, PlatformChannel.SystemChromeStyle systemChromeStyle) {
        finalStyle = null;
        if (flutterBoostActivity.platformPlugin == null) {
            return;
        }
        int iHashCode = flutterBoostActivity.hashCode();
        PlatformChannel.SystemChromeStyle systemChromeStyleMergeSystemChromeStyle = FlutterBoostUtils.mergeSystemChromeStyle(systemChromeStyle, FlutterBoostUtils.getCurrentSystemUiOverlayTheme(flutterBoostActivity.platformPlugin, true));
        if (systemChromeStyleMergeSystemChromeStyle != null) {
            themes.put(Integer.valueOf(iHashCode), systemChromeStyleMergeSystemChromeStyle);
        }
    }
}
