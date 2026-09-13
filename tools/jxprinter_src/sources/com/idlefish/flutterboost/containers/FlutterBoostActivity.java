package com.idlefish.flutterboost.containers;

import W2.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.idlefish.flutterboost.Assert;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostUtils;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.plugin.platform.PlatformPlugin;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterBoostActivity extends FlutterActivity implements FlutterViewContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "FlutterBoost_java";
    private FlutterView flutterView;
    protected PlatformPlugin platformPlugin;
    private LifecycleStage stage;
    private final String who = UUID.randomUUID().toString();
    private final FlutterTextureHooker textureHooker = new FlutterTextureHooker();
    private boolean isAttached = false;
    PlatformChannel.SystemChromeStyle restoreTheme = null;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CachedEngineIntentBuilder {
        private final Class<? extends FlutterBoostActivity> activityClass;
        private HashMap<String, Object> params;
        private String uniqueId;
        private String url;
        private boolean destroyEngineWithActivity = false;
        private String backgroundMode = io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.opaque.name();

        public CachedEngineIntentBuilder(Class<? extends FlutterBoostActivity> cls) {
            this.activityClass = cls;
        }

        public CachedEngineIntentBuilder backgroundMode(io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode backgroundMode) {
            this.backgroundMode = backgroundMode.name();
            return this;
        }

        public Intent build(Context context) {
            Intent intentPutExtra = new Intent(context, this.activityClass).putExtra(FlutterActivityLaunchConfigs.EXTRA_CACHED_ENGINE_ID, FlutterBoost.ENGINE_ID).putExtra(FlutterActivityLaunchConfigs.EXTRA_DESTROY_ENGINE_WITH_ACTIVITY, this.destroyEngineWithActivity).putExtra(FlutterActivityLaunchConfigs.EXTRA_BACKGROUND_MODE, this.backgroundMode).putExtra("url", this.url).putExtra(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM, this.params);
            String strCreateUniqueId = this.uniqueId;
            if (strCreateUniqueId == null) {
                strCreateUniqueId = FlutterBoostUtils.createUniqueId(this.url);
            }
            return intentPutExtra.putExtra(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID, strCreateUniqueId);
        }

        public CachedEngineIntentBuilder destroyEngineWithActivity(boolean z6) {
            this.destroyEngineWithActivity = z6;
            return this;
        }

        public CachedEngineIntentBuilder uniqueId(String str) {
            this.uniqueId = str;
            return this;
        }

        public CachedEngineIntentBuilder url(String str) {
            this.url = str;
            return this;
        }

        public CachedEngineIntentBuilder urlParams(Map<String, Object> map) {
            this.params = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
            return this;
        }
    }

    private boolean isDebugLoggingEnabled() {
        return FlutterBoostUtils.isDebugLoggingEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$0() {
        attachToEngineIfNeeded();
        this.textureHooker.onFlutterTextureViewRestoreState();
        onUpdateSystemUiOverlays();
    }

    private void performAttach() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#performAttach: " + this);
        }
        getFlutterEngine().getActivityControlSurface().attachToActivity(getExclusiveAppComponent(), getLifecycle());
        if (this.platformPlugin == null) {
            PlatformPlugin platformPlugin = new PlatformPlugin(getActivity(), getFlutterEngine().getPlatformChannel(), this);
            this.platformPlugin = platformPlugin;
            PlatformChannel.SystemChromeStyle systemChromeStyle = this.restoreTheme;
            if (systemChromeStyle != null) {
                FlutterBoostUtils.setSystemChromeSystemUIOverlayStyle(platformPlugin, systemChromeStyle);
            }
        }
        this.flutterView.attachToFlutterEngine(getFlutterEngine());
    }

    private void performDetach() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#performDetach: " + this);
        }
        getFlutterEngine().getActivityControlSurface().detachFromActivity();
        releasePlatformChannel();
        this.flutterView.detachFromFlutterEngine();
    }

    private void releasePlatformChannel() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#releasePlatformChannel: " + this);
        }
        PlatformPlugin platformPlugin = this.platformPlugin;
        if (platformPlugin != null) {
            platformPlugin.destroy();
            this.platformPlugin = null;
        }
    }

    private void setIsFlutterUiDisplayed(boolean z6) {
        try {
            FlutterRenderer renderer = getFlutterEngine().getRenderer();
            Field declaredField = FlutterRenderer.class.getDeclaredField("isDisplayingFlutterUi");
            declaredField.setAccessible(true);
            declaredField.setBoolean(renderer, false);
        } catch (Exception e) {
            Log.e(TAG, "You *should* keep fields in io.flutter.embedding.engine.renderer.FlutterRenderer.");
            e.printStackTrace();
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean attachToEngineAutomatically() {
        return false;
    }

    public void attachToEngineIfNeeded() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#attachToEngineIfNeeded: " + this);
        }
        if (this.isAttached) {
            return;
        }
        performAttach();
        this.isAttached = true;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public void detachFromEngineIfNeeded() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#detachFromEngineIfNeeded: " + this);
        }
        if (this.isAttached) {
            performDetach();
            this.isAttached = false;
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void detachFromFlutterEngine() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#detachFromFlutterEngine: " + this);
        }
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public void finishContainer(Map<String, Object> map) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#finishContainer: " + this);
        }
        if (map != null) {
            Intent intent = new Intent();
            intent.putExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY, new HashMap(map));
            setResult(-1, intent);
        }
        finish();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public String getCachedEngineId() {
        return FlutterBoost.ENGINE_ID;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUniqueId() {
        return !getIntent().hasExtra(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID) ? this.who : getIntent().getStringExtra(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUrl() {
        if (getIntent().hasExtra("url")) {
            return getIntent().getStringExtra("url");
        }
        Log.e(TAG, "Oops! The activity url are *MISSED*! You should override the |getUrl|, or set url via |CachedEngineIntentBuilder.url|.");
        return null;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Map<String, Object> getUrlParams() {
        return (HashMap) getIntent().getSerializableExtra(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isOpaque() {
        return getBackgroundMode() == io.flutter.embedding.android.FlutterActivityLaunchConfigs.BackgroundMode.opaque;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isPausing() {
        LifecycleStage lifecycleStage = this.stage;
        return (lifecycleStage == LifecycleStage.ON_PAUSE || lifecycleStage == LifecycleStage.ON_STOP) && !isFinishing();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onBackPressed() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onBackPressed: " + this);
        }
        FlutterBoost.instance().getPlugin().onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (isDebugLoggingEnabled()) {
            StringBuilder sb = new StringBuilder("#onConfigurationChanged: ");
            sb.append(configuration.orientation == 2 ? "LANDSCAPE" : "PORTRAIT");
            sb.append(", ");
            sb.append(this);
            Log.d(TAG, sb.toString());
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onCreate: " + this);
        }
        FlutterViewContainer topContainer = FlutterContainerManager.instance().getTopContainer();
        if (topContainer != this && (topContainer instanceof FlutterBoostActivity)) {
            this.restoreTheme = ContainerThemeMgr.findTheme((FlutterBoostActivity) topContainer);
        } else if (topContainer == null) {
            this.restoreTheme = ContainerThemeMgr.getFinalStyle();
        }
        super.onCreate(bundle);
        this.stage = LifecycleStage.ON_CREATE;
        FlutterView flutterViewFindFlutterView = FlutterBoostUtils.findFlutterView(getWindow().getDecorView());
        this.flutterView = flutterViewFindFlutterView;
        flutterViewFindFlutterView.detachFromFlutterEngine();
        FlutterBoost.instance().getPlugin().onContainerCreated(this);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onDestroy() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onDestroy: " + this);
        }
        ContainerThemeMgr.onActivityDestroy(this);
        this.stage = LifecycleStage.ON_DESTROY;
        detachFromEngineIfNeeded();
        this.textureHooker.onFlutterTextureViewRelease();
        FlutterBoost.instance().getPlugin().onContainerDestroyed(this);
        super.onDestroy();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.hookFlutterTextureView(flutterTextureView);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onPause: " + this + ", isOpaque=" + isOpaque());
        }
        ContainerThemeMgr.onActivityPause(this, this.restoreTheme);
        this.restoreTheme = ContainerThemeMgr.findTheme(this);
        FlutterViewContainer topActivityContainer = FlutterContainerManager.instance().getTopActivityContainer();
        if (Build.VERSION.SDK_INT == 29 && topActivityContainer != null && topActivityContainer != this && !topActivityContainer.isOpaque() && topActivityContainer.isPausing()) {
            Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
            return;
        }
        this.stage = LifecycleStage.ON_PAUSE;
        FlutterBoost.instance().getPlugin().onContainerDisappeared(this);
        setIsFlutterUiDisplayed(false);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onResume: " + this + ", isOpaque=" + isOpaque());
        }
        FlutterContainerManager flutterContainerManagerInstance = FlutterContainerManager.instance();
        if (Build.VERSION.SDK_INT == 29) {
            FlutterViewContainer topActivityContainer = flutterContainerManagerInstance.getTopActivityContainer();
            if (flutterContainerManagerInstance.isActiveContainer(this) && topActivityContainer != null && topActivityContainer != this && !topActivityContainer.isOpaque() && topActivityContainer.isPausing()) {
                Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        FlutterViewContainer topContainer = flutterContainerManagerInstance.getTopContainer();
        if (topContainer != null && topContainer != this) {
            topContainer.detachFromEngineIfNeeded();
        }
        FlutterBoost.instance().getPlugin().onContainerAppeared(this, new c(this, 14));
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onSaveInstanceState: " + this);
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.stage = LifecycleStage.ON_START;
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onStart: " + this);
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.stage = LifecycleStage.ON_STOP;
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onStop: " + this);
        }
    }

    public void onUpdateSystemUiOverlays() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onUpdateSystemUiOverlays: " + this);
        }
        Assert.assertNotNull(this.platformPlugin);
        this.platformPlugin.updateSystemUiOverlays();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onUserLeaveHint: " + this);
        }
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldAttachEngineToActivity() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDispatchAppLifecycleState() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldRestoreAndSaveState() {
        if (getIntent().hasExtra(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION)) {
            return getIntent().getBooleanExtra(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION, false);
        }
        return true;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Activity getContextActivity() {
        return this;
    }
}
