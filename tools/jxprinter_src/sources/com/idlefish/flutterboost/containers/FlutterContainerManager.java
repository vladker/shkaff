package com.idlefish.flutterboost.containers;

import android.app.Activity;
import android.util.Log;
import com.idlefish.flutterboost.FlutterBoostUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterContainerManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "FlutterBoost_java";
    private final LinkedList<FlutterViewContainer> activeContainers;
    private final Map<String, FlutterViewContainer> allContainers;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LazyHolder {
        static final FlutterContainerManager INSTANCE = new FlutterContainerManager();

        private LazyHolder() {
        }
    }

    public static FlutterContainerManager instance() {
        return LazyHolder.INSTANCE;
    }

    private boolean isDebugLoggingEnabled() {
        return FlutterBoostUtils.isDebugLoggingEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$toString$0(StringBuilder sb, FlutterViewContainer flutterViewContainer) {
        sb.append(flutterViewContainer.getUrl() + ',');
    }

    public void activateContainer(String str, FlutterViewContainer flutterViewContainer) {
        if (str == null || flutterViewContainer == null) {
            return;
        }
        if (this.activeContainers.contains(flutterViewContainer)) {
            this.activeContainers.remove(flutterViewContainer);
        }
        this.activeContainers.add(flutterViewContainer);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#activateContainer: " + str + "," + this);
        }
    }

    public void addContainer(String str, FlutterViewContainer flutterViewContainer) {
        this.allContainers.put(str, flutterViewContainer);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#addContainer: " + str + ", " + this);
        }
    }

    public FlutterViewContainer findContainerById(String str) {
        if (this.allContainers.containsKey(str)) {
            return this.allContainers.get(str);
        }
        return null;
    }

    public int getContainerSize() {
        return this.allContainers.size();
    }

    public FlutterViewContainer getTopActivityContainer() {
        int size = this.activeContainers.size();
        if (size == 0) {
            return null;
        }
        for (int i5 = size - 1; i5 >= 0; i5--) {
            FlutterViewContainer flutterViewContainer = this.activeContainers.get(i5);
            if (flutterViewContainer instanceof Activity) {
                return flutterViewContainer;
            }
        }
        return null;
    }

    public FlutterViewContainer getTopContainer() {
        if (this.activeContainers.size() > 0) {
            return this.activeContainers.getLast();
        }
        return null;
    }

    public boolean isActiveContainer(FlutterViewContainer flutterViewContainer) {
        return this.activeContainers.contains(flutterViewContainer);
    }

    public boolean isTopContainer(String str) {
        FlutterViewContainer topContainer = getTopContainer();
        return topContainer != null && topContainer.getUniqueId() == str;
    }

    public void removeContainer(String str) {
        if (str == null) {
            return;
        }
        this.activeContainers.remove(this.allContainers.remove(str));
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#removeContainer: " + str + ", " + this);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("activeContainers=" + this.activeContainers.size() + ", [");
        this.activeContainers.forEach(new a(sb, 0));
        sb.append("]");
        return sb.toString();
    }

    private FlutterContainerManager() {
        this.allContainers = new HashMap();
        this.activeContainers = new LinkedList<>();
    }
}
