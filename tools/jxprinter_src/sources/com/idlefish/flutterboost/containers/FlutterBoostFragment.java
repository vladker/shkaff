package com.idlefish.flutterboost.containers;

import W2.b;
import W2.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.idlefish.flutterboost.Assert;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoostUtils;
import io.flutter.embedding.android.FlutterFragment;
import io.flutter.embedding.android.FlutterTextureView;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.RenderMode;
import io.flutter.embedding.android.TransparencyMode;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterBoostFragment extends FlutterFragment implements FlutterViewContainer {
    private static final String TAG = "FlutterBoost_java";
    private FlutterView flutterView;
    private PlatformPlugin platformPlugin;
    private LifecycleStage stage;
    private final String who = UUID.randomUUID().toString();
    private final FlutterTextureHooker textureHooker = new FlutterTextureHooker();
    private boolean isAttached = false;
    private boolean isFinishing = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CachedEngineFragmentBuilder {
        private boolean destroyEngineWithFragment;
        private final Class<? extends FlutterBoostFragment> fragmentClass;
        private HashMap<String, Object> params;
        private RenderMode renderMode;
        private boolean shouldAttachEngineToActivity;
        private TransparencyMode transparencyMode;
        private String uniqueId;
        private String url;

        public CachedEngineFragmentBuilder() {
            this(FlutterBoostFragment.class);
        }

        public <T extends FlutterBoostFragment> T build() {
            try {
                T t6 = (T) this.fragmentClass.getDeclaredConstructor(null).newInstance(null);
                if (t6 != null) {
                    t6.setArguments(createArgs());
                    return t6;
                }
                throw new RuntimeException("The FlutterFragment subclass sent in the constructor (" + this.fragmentClass.getCanonicalName() + ") does not match the expected return type.");
            } catch (Exception e) {
                throw new RuntimeException("Could not instantiate FlutterFragment subclass (" + this.fragmentClass.getName() + ")", e);
            }
        }

        public Bundle createArgs() {
            Bundle bundle = new Bundle();
            bundle.putString(FlutterActivityLaunchConfigs.EXTRA_CACHED_ENGINE_ID, FlutterBoost.ENGINE_ID);
            bundle.putBoolean("destroy_engine_with_fragment", this.destroyEngineWithFragment);
            RenderMode renderMode = this.renderMode;
            if (renderMode == null) {
                renderMode = RenderMode.surface;
            }
            bundle.putString("flutterview_render_mode", renderMode.name());
            TransparencyMode transparencyMode = this.transparencyMode;
            if (transparencyMode == null) {
                transparencyMode = TransparencyMode.transparent;
            }
            bundle.putString("flutterview_transparency_mode", transparencyMode.name());
            bundle.putBoolean("should_attach_engine_to_activity", this.shouldAttachEngineToActivity);
            bundle.putString("url", this.url);
            bundle.putSerializable(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM, this.params);
            String strCreateUniqueId = this.uniqueId;
            if (strCreateUniqueId == null) {
                strCreateUniqueId = FlutterBoostUtils.createUniqueId(this.url);
            }
            bundle.putString(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID, strCreateUniqueId);
            return bundle;
        }

        public CachedEngineFragmentBuilder destroyEngineWithFragment(boolean z6) {
            this.destroyEngineWithFragment = z6;
            return this;
        }

        public CachedEngineFragmentBuilder renderMode(RenderMode renderMode) {
            this.renderMode = renderMode;
            return this;
        }

        public CachedEngineFragmentBuilder shouldAttachEngineToActivity(boolean z6) {
            this.shouldAttachEngineToActivity = z6;
            return this;
        }

        public CachedEngineFragmentBuilder transparencyMode(TransparencyMode transparencyMode) {
            this.transparencyMode = transparencyMode;
            return this;
        }

        public CachedEngineFragmentBuilder uniqueId(String str) {
            this.uniqueId = str;
            return this;
        }

        public CachedEngineFragmentBuilder url(String str) {
            this.url = str;
            return this;
        }

        public CachedEngineFragmentBuilder urlParams(Map<String, Object> map) {
            this.params = map instanceof HashMap ? (HashMap) map : new HashMap<>(map);
            return this;
        }

        public CachedEngineFragmentBuilder(Class<? extends FlutterBoostFragment> cls) {
            this.destroyEngineWithFragment = false;
            this.renderMode = RenderMode.surface;
            this.transparencyMode = TransparencyMode.opaque;
            this.shouldAttachEngineToActivity = true;
            this.url = PackagingURIHelper.FORWARD_SLASH_STRING;
            this.fragmentClass = cls;
        }
    }

    private boolean isDebugLoggingEnabled() {
        return FlutterBoostUtils.isDebugLoggingEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$didFragmentShow$3(Runnable runnable) {
        attachToEngineIfNeeded();
        this.textureHooker.onFlutterTextureViewRestoreState();
        runnable.run();
    }

    private void performAttach() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#performAttach: " + this);
        }
        getFlutterEngine().getActivityControlSurface().attachToActivity(getExclusiveAppComponent(), getLifecycle());
        if (this.platformPlugin == null) {
            this.platformPlugin = new PlatformPlugin(getActivity(), getFlutterEngine().getPlatformChannel(), this);
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

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
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

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void detachFromFlutterEngine() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#detachFromFlutterEngine: " + this);
        }
    }

    public void didFragmentHide() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#didFragmentHide: " + this + ", isOpaque=" + isOpaque());
        }
        FlutterBoost.instance().getPlugin().onContainerDisappeared(this);
    }

    public void didFragmentShow(Runnable runnable) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#didFragmentShow: " + this + ", isOpaque=" + isOpaque());
        }
        FlutterViewContainer topContainer = FlutterContainerManager.instance().getTopContainer();
        if (topContainer != null && topContainer != this) {
            topContainer.detachFromEngineIfNeeded();
        }
        FlutterBoost.instance().getPlugin().onContainerAppeared(this, new b(this, runnable, 18));
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public void finishContainer(Map<String, Object> map) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#finishContainer: " + this);
        }
        this.isFinishing = true;
        if (map != null) {
            Intent intent = new Intent();
            intent.putExtra(FlutterActivityLaunchConfigs.ACTIVITY_RESULT_KEY, new HashMap(map));
            getActivity().setResult(-1, intent);
        }
        onFinishContainer();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public String getCachedEngineId() {
        return FlutterBoost.ENGINE_ID;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Activity getContextActivity() {
        return getActivity();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public RenderMode getRenderMode() {
        return RenderMode.texture;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public TransparencyMode getTransparencyMode() {
        return TransparencyMode.valueOf(getArguments().getString("flutterview_transparency_mode", TransparencyMode.opaque.name()));
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUniqueId() {
        return getArguments().getString(FlutterActivityLaunchConfigs.EXTRA_UNIQUE_ID, this.who);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public String getUrl() {
        if (getArguments().containsKey("url")) {
            return getArguments().getString("url");
        }
        throw new RuntimeException("Oops! The fragment url are *MISSED*! You should override the |getUrl|, or set url via CachedEngineFragmentBuilder.");
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public Map<String, Object> getUrlParams() {
        return (HashMap) getArguments().getSerializable(FlutterActivityLaunchConfigs.EXTRA_URL_PARAM);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isOpaque() {
        return getTransparencyMode() == TransparencyMode.opaque;
    }

    @Override // com.idlefish.flutterboost.containers.FlutterViewContainer
    public boolean isPausing() {
        LifecycleStage lifecycleStage = this.stage;
        return (lifecycleStage == LifecycleStage.ON_PAUSE || lifecycleStage == LifecycleStage.ON_STOP) && !this.isFinishing;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onAttach: " + this);
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment
    public void onBackPressed() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onBackPressed: " + this);
        }
        FlutterBoost.instance().getPlugin().onBackPressed();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
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

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onCreate: " + this);
        }
        this.stage = LifecycleStage.ON_CREATE;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onCreateView: " + this);
        }
        FlutterBoost.instance().getPlugin().onContainerCreated(this);
        View viewOnCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        FlutterView flutterViewFindFlutterView = FlutterBoostUtils.findFlutterView(viewOnCreateView);
        this.flutterView = flutterViewFindFlutterView;
        flutterViewFindFlutterView.detachFromFlutterEngine();
        if (viewOnCreateView != this.flutterView) {
            return viewOnCreateView;
        }
        FrameLayout frameLayout = new FrameLayout(viewOnCreateView.getContext());
        frameLayout.addView(viewOnCreateView);
        return frameLayout;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onDestroy: " + this);
        }
        this.stage = LifecycleStage.ON_DESTROY;
        this.textureHooker.onFlutterTextureViewRelease();
        detachFromEngineIfNeeded();
        super.onDestroy();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onDestroyView: " + this);
        }
        FlutterBoost.instance().getPlugin().onContainerDestroyed(this);
        super.onDestroyView();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onDetach: " + this);
        }
    }

    public void onFinishContainer() {
        getActivity().finish();
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public void onFlutterTextureViewCreated(FlutterTextureView flutterTextureView) {
        super.onFlutterTextureViewCreated(flutterTextureView);
        this.textureHooker.hookFlutterTextureView(flutterTextureView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z6) {
        super.onHiddenChanged(z6);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onHiddenChanged: hidden=" + z6 + ", " + this);
        }
        if (this.flutterView == null) {
            return;
        }
        if (z6) {
            didFragmentHide();
        } else {
            didFragmentShow(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(2));
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onPause() {
        FlutterViewContainer topActivityContainer;
        super.onPause();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onPause: " + this + ", isFinshing=" + this.isFinishing);
        }
        if (Build.VERSION.SDK_INT == 29 && (topActivityContainer = FlutterContainerManager.instance().getTopActivityContainer()) != null && topActivityContainer != getContextActivity() && !topActivityContainer.isOpaque() && topActivityContainer.isPausing()) {
            Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
        } else {
            this.stage = LifecycleStage.ON_PAUSE;
            didFragmentHide();
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onResume: isHidden=" + isHidden() + ", " + this);
        }
        if (Build.VERSION.SDK_INT == 29) {
            FlutterContainerManager flutterContainerManagerInstance = FlutterContainerManager.instance();
            FlutterViewContainer topActivityContainer = flutterContainerManagerInstance.getTopActivityContainer();
            if (flutterContainerManagerInstance.isActiveContainer(this) && topActivityContainer != null && topActivityContainer != getContextActivity() && !topActivityContainer.isOpaque() && topActivityContainer.isPausing()) {
                Log.w(TAG, "Skip the unexpected activity lifecycle event on Android Q. See https://issuetracker.google.com/issues/185693011 for more details.");
                return;
            }
        }
        this.stage = LifecycleStage.ON_RESUME;
        if (isHidden()) {
            return;
        }
        didFragmentShow(new c(this, 15));
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onSaveInstanceState: " + this);
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onStart: " + this);
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onStop: " + this);
        }
        this.stage = LifecycleStage.ON_STOP;
    }

    /* JADX INFO: renamed from: onUpdateSystemUiOverlays, reason: merged with bridge method [inline-methods] */
    public void lambda$onResume$2() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onUpdateSystemUiOverlays: " + this);
        }
        Assert.assertNotNull(this.platformPlugin);
        this.platformPlugin.updateSystemUiOverlays();
    }

    @Override // io.flutter.embedding.android.FlutterFragment
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onUserLeaveHint: " + this);
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public PlatformPlugin providePlatformPlugin(Activity activity, FlutterEngine flutterEngine) {
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z6) {
        super.setUserVisibleHint(z6);
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#setUserVisibleHint: isVisibleToUser=" + z6 + ", " + this);
        }
        if (this.flutterView == null) {
            return;
        }
        if (z6) {
            didFragmentShow(new com.google.android.datatransport.runtime.scheduling.jobscheduling.a(3));
        } else {
            didFragmentHide();
        }
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDestroyEngineWithHost() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldDispatchAppLifecycleState() {
        return false;
    }

    @Override // io.flutter.embedding.android.FlutterFragment, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host
    public boolean shouldRestoreAndSaveState() {
        if (getArguments().containsKey(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION)) {
            return getArguments().getBoolean(FlutterActivityLaunchConfigs.EXTRA_ENABLE_STATE_RESTORATION);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onHiddenChanged$0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUserVisibleHint$1() {
    }
}
