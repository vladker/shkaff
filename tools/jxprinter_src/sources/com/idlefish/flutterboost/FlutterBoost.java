package com.idlefish.flutterboost;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.idlefish.flutterboost.containers.FlutterContainerManager;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.dart.DartExecutor;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterBoost {
    public static final String ENGINE_ID = "flutter_boost_default_engine";
    private LinkedList<Activity> activityQueue;
    private boolean isAppInBackground;
    private boolean isBackForegroundEventOverridden;
    private FlutterBoostPlugin plugin;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Callback {
        void onStart(FlutterEngine flutterEngine);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class LazyHolder {
        static final FlutterBoost INSTANCE = new FlutterBoost();

        private LazyHolder() {
        }
    }

    public static FlutterBoost instance() {
        return LazyHolder.INSTANCE;
    }

    private void setupActivityLifecycleCallback(Application application, boolean z6) {
        application.registerActivityLifecycleCallbacks(new BoostActivityLifecycle(z6));
    }

    public ListenerRemover addEventListener(String str, EventListener eventListener) {
        return getPlugin().addEventListener(str, eventListener);
    }

    public void changeFlutterAppLifecycle(int i5) {
        getPlugin().changeFlutterAppLifecycle(i5);
    }

    public void close(String str) {
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setUniqueId(str);
        getPlugin().popRoute(commonParams, new Messages.Result<Void>() { // from class: com.idlefish.flutterboost.FlutterBoost.1
            @Override // com.idlefish.flutterboost.Messages.Result
            public void success(Void r6) {
            }

            @Override // com.idlefish.flutterboost.Messages.Result
            public void error(Throwable th) {
            }
        });
    }

    public Activity currentActivity() {
        LinkedList<Activity> linkedList = this.activityQueue;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        return this.activityQueue.peek();
    }

    public void dispatchBackForegroundEvent(boolean z6) {
        if (!this.isBackForegroundEventOverridden) {
            throw new RuntimeException("Oops! You should set override enable first by FlutterBoostSetupOptions.");
        }
        if (z6) {
            getPlugin().onBackground();
        } else {
            getPlugin().onForeground();
        }
        setAppIsInBackground(z6);
    }

    public FlutterViewContainer findFlutterViewContainerById(String str) {
        return FlutterContainerManager.instance().findContainerById(str);
    }

    public FlutterEngine getEngine() {
        return FlutterEngineCache.getInstance().get(ENGINE_ID);
    }

    public FlutterBoostPlugin getPlugin() {
        if (this.plugin == null) {
            FlutterEngine engine = getEngine();
            if (engine == null) {
                throw new RuntimeException("FlutterBoost might *not* have been initialized yet!!!");
            }
            this.plugin = FlutterBoostUtils.getPlugin(engine);
        }
        return this.plugin;
    }

    public FlutterViewContainer getTopContainer() {
        return FlutterContainerManager.instance().getTopContainer();
    }

    public boolean isAppInBackground() {
        return this.isAppInBackground;
    }

    public void open(String str, Map<String, Object> map) {
        getPlugin().getDelegate().pushFlutterRoute(new FlutterBoostRouteOptions.Builder().pageName(str).arguments(map).build());
    }

    public void sendEventToFlutter(String str, Map<String, Object> map) {
        getPlugin().sendEventToFlutter(str, map);
    }

    public void setAppIsInBackground(boolean z6) {
        this.isAppInBackground = z6;
    }

    public void setup(Application application, FlutterBoostDelegate flutterBoostDelegate, Callback callback) {
        setup(application, flutterBoostDelegate, callback, FlutterBoostSetupOptions.createDefault());
    }

    public void tearDown() {
        FlutterEngine engine = getEngine();
        if (engine != null) {
            engine.destroy();
            FlutterEngineCache.getInstance().remove(ENGINE_ID);
        }
        this.activityQueue = null;
        this.plugin = null;
        this.isBackForegroundEventOverridden = false;
        this.isAppInBackground = false;
    }

    private FlutterBoost() {
        this.activityQueue = null;
        this.isBackForegroundEventOverridden = false;
        this.isAppInBackground = false;
    }

    public void setup(Application application, FlutterBoostDelegate flutterBoostDelegate, Callback callback, FlutterBoostSetupOptions flutterBoostSetupOptions) {
        Application application2;
        FlutterInjector.instance().flutterLoader().startInitialization(application);
        if (flutterBoostSetupOptions == null) {
            flutterBoostSetupOptions = FlutterBoostSetupOptions.createDefault();
        }
        this.isBackForegroundEventOverridden = flutterBoostSetupOptions.shouldOverrideBackForegroundEvent();
        FlutterBoostUtils.setDebugLoggingEnabled(flutterBoostSetupOptions.isDebugLoggingEnabled());
        FlutterEngine engine = getEngine();
        if (engine == null) {
            if (flutterBoostSetupOptions.flutterEngineProvider() != null) {
                engine = flutterBoostSetupOptions.flutterEngineProvider().provideFlutterEngine(application);
            }
            if (engine == null) {
                application2 = application;
                engine = new FlutterEngine(application2, null, null, new FBPlatformViewsController(), flutterBoostSetupOptions.shellArgs(), true);
            } else {
                application2 = application;
            }
            FlutterEngineCache.getInstance().put(ENGINE_ID, engine);
        } else {
            application2 = application;
        }
        if (!engine.getDartExecutor().isExecutingDart()) {
            engine.getNavigationChannel().setInitialRoute(flutterBoostSetupOptions.initialRoute());
            engine.getDartExecutor().executeDartEntrypoint(new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(), flutterBoostSetupOptions.dartEntrypoint()), flutterBoostSetupOptions.dartEntrypointArgs());
        }
        if (callback != null) {
            callback.onStart(engine);
        }
        getPlugin().setDelegate(flutterBoostDelegate);
        setupActivityLifecycleCallback(application2, this.isBackForegroundEventOverridden);
    }

    public void open(FlutterBoostRouteOptions flutterBoostRouteOptions) {
        getPlugin().getDelegate().pushFlutterRoute(flutterBoostRouteOptions);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public class BoostActivityLifecycle implements Application.ActivityLifecycleCallbacks {
        private int activityReferences = 0;
        private boolean isActivityChangingConfigurations = false;
        private boolean isBackForegroundEventOverridden;

        public BoostActivityLifecycle(boolean z6) {
            this.isBackForegroundEventOverridden = z6;
        }

        private void dispatchBackgroundEvent() {
            if (this.isBackForegroundEventOverridden) {
                return;
            }
            FlutterBoost.instance().setAppIsInBackground(true);
            FlutterBoost.instance().getPlugin().onBackground();
        }

        private void dispatchForegroundEvent() {
            if (this.isBackForegroundEventOverridden) {
                return;
            }
            FlutterBoost.instance().setAppIsInBackground(false);
            FlutterBoost.instance().getPlugin().onForeground();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (FlutterBoost.this.activityQueue == null) {
                FlutterBoost.this.activityQueue = new LinkedList();
            }
            FlutterBoost.this.activityQueue.addFirst(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (FlutterBoost.this.activityQueue == null || FlutterBoost.this.activityQueue.isEmpty()) {
                return;
            }
            FlutterBoost.this.activityQueue.remove(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (FlutterBoost.this.activityQueue == null) {
                FlutterBoost.this.activityQueue = new LinkedList();
                FlutterBoost.this.activityQueue.addFirst(activity);
            } else if (FlutterBoost.this.activityQueue.isEmpty()) {
                FlutterBoost.this.activityQueue.addFirst(activity);
            } else if (FlutterBoost.this.activityQueue.peek() != activity) {
                FlutterBoost.this.activityQueue.removeFirstOccurrence(activity);
                FlutterBoost.this.activityQueue.addFirst(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i5 = this.activityReferences + 1;
            this.activityReferences = i5;
            if (i5 != 1 || this.isActivityChangingConfigurations) {
                return;
            }
            dispatchForegroundEvent();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            boolean zIsChangingConfigurations = activity.isChangingConfigurations();
            this.isActivityChangingConfigurations = zIsChangingConfigurations;
            int i5 = this.activityReferences - 1;
            this.activityReferences = i5;
            if (i5 != 0 || zIsChangingConfigurations) {
                return;
            }
            dispatchBackgroundEvent();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
