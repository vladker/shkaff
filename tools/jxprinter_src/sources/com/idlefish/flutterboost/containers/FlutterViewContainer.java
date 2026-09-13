package com.idlefish.flutterboost.containers;

import android.app.Activity;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public interface FlutterViewContainer {
    void finishContainer(Map<String, Object> map);

    Activity getContextActivity();

    String getUniqueId();

    String getUrl();

    Map<String, Object> getUrlParams();

    default boolean isOpaque() {
        return true;
    }

    default boolean isPausing() {
        return false;
    }

    default void detachFromEngineIfNeeded() {
    }
}
