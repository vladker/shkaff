package com.idlefish.flutterboost;

import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import com.idlefish.flutterboost.containers.FlutterContainerManager;
import com.idlefish.flutterboost.containers.FlutterViewContainer;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class FlutterBoostPlugin implements FlutterPlugin, Messages.NativeRouterApi, ActivityAware {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String APP_LIFECYCLE_CHANGED_KEY = "app_lifecycle_changed_key";
    private static final int FLUTTER_APP_STATE_PAUSED = 4;
    private static final int FLUTTER_APP_STATE_RESUMED = 1;
    private static final String LIFECYCLE_STATE = "lifecycleState";
    private static final String TAG = "FlutterBoost_java";
    private Messages.FlutterRouterApi channel;
    private Messages.StackInfo dartStack;
    private FlutterBoostDelegate delegate;
    private FlutterEngine engine;
    private SparseArray<String> pageNames;
    private int requestCode = 1000;
    private HashMap<String, LinkedList<EventListener>> listenersTable = new HashMap<>();

    private void checkEngineState() {
        FlutterEngine flutterEngine = this.engine;
        if (flutterEngine == null || !flutterEngine.getDartExecutor().isExecutingDart()) {
            throw new RuntimeException("The engine is not ready for use. The message may be drop silently by the engine. You should check 'DartExecutor.isExecutingDart()' first!");
        }
    }

    private boolean isDebugLoggingEnabled() {
        return FlutterBoostUtils.isDebugLoggingEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAttachedToActivity$12(String str, Void r6) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onNativeResult return, pageName=" + str + ", " + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onAttachedToActivity$13(int i5, int i6, Intent intent) {
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        Messages.CommonParams commonParams = new Messages.CommonParams();
        String str = this.pageNames.get(i5);
        this.pageNames.remove(i5);
        if (str == null) {
            return true;
        }
        commonParams.setPageName(str);
        if (intent != null) {
            commonParams.setArguments(FlutterBoostUtils.bundleToMap(intent.getExtras()));
        }
        this.channel.onNativeResult(commonParams, new b(this, str, 1));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackPressed$4(Void r6) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onBackPressed end: " + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBackground$7(Void r6) {
        Log.d(TAG, "## onBackground end: " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onContainerAppeared$10(String str, Runnable runnable, Void r6) {
        if (!FlutterContainerManager.instance().isTopContainer(str) || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onContainerHide$9(String str, Void r6) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerHide end: " + str + ", " + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onContainerShow$8(String str, Void r6) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerShow end: " + str + ", " + this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onForeground$6(Void r6) {
        Log.d(TAG, "## onForeground end: " + this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$popRoute$3(String str, Messages.FlutterRouterApi.Reply reply, Void r6) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#popRoute end: " + str + ", " + this);
        }
        if (reply != null) {
            reply.reply(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$pushRoute$2(String str, String str2, Messages.FlutterRouterApi.Reply reply, Void r6) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#pushRoute end: " + str + ", " + str2);
        }
        if (reply != null) {
            reply.reply(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeRoute$5(String str, Messages.FlutterRouterApi.Reply reply, Void r6) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#removeRoute end: " + str + ", " + this);
        }
        if (reply != null) {
            reply.reply(null);
        }
    }

    public ListenerRemover addEventListener(String str, EventListener eventListener) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#addEventListener: " + str + ", " + this);
        }
        LinkedList<EventListener> linkedList = this.listenersTable.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.listenersTable.put(str, linkedList);
        }
        linkedList.add(eventListener);
        return new F4.f(linkedList, eventListener, 10);
    }

    public void changeFlutterAppLifecycle(int i5) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#changeFlutterAppLifecycle: " + i5 + ", " + this);
        }
        HashMap map = new HashMap();
        map.put(LIFECYCLE_STATE, Integer.valueOf(i5));
        sendEventToFlutter(APP_LIFECYCLE_CHANGED_KEY, map);
    }

    public Messages.FlutterRouterApi getChannel() {
        return this.channel;
    }

    public FlutterBoostDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public Messages.StackInfo getStackFromHost() {
        if (this.dartStack == null) {
            return Messages.StackInfo.fromMap(new HashMap());
        }
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#getStackFromHost: " + this.dartStack + ", " + this);
        }
        return this.dartStack;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onAttachedToActivity: " + this);
        }
        activityPluginBinding.addActivityResultListener(new PluginRegistry.ActivityResultListener() { // from class: com.idlefish.flutterboost.e
            @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
            public final boolean onActivityResult(int i5, int i6, Intent intent) {
                return this.f3557a.lambda$onAttachedToActivity$13(i5, i6, intent);
            }
        });
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onAttachedToEngine: " + this);
        }
        Messages.NativeRouterApi.setup(flutterPluginBinding.getBinaryMessenger(), this);
        this.engine = flutterPluginBinding.getFlutterEngine();
        this.channel = new Messages.FlutterRouterApi(flutterPluginBinding.getBinaryMessenger());
        this.pageNames = new SparseArray<>();
    }

    public void onBackPressed() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onBackPressed start: " + this);
        }
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        this.channel.onBackPressed(new c(this, 2));
    }

    public void onBackground() {
        Log.d(TAG, "## onBackground start: " + this);
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        this.channel.onBackground(new Messages.CommonParams(), new c(this, 1));
        changeFlutterAppLifecycle(4);
    }

    public void onContainerAppeared(FlutterViewContainer flutterViewContainer, Runnable runnable) {
        String uniqueId = flutterViewContainer.getUniqueId();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerAppeared: " + uniqueId + ", " + this);
        }
        FlutterContainerManager.instance().activateContainer(uniqueId, flutterViewContainer);
        pushRoute(uniqueId, flutterViewContainer.getUrl(), flutterViewContainer.getUrlParams(), new F4.f(uniqueId, runnable, 9));
        onContainerShow(uniqueId);
    }

    public void onContainerCreated(FlutterViewContainer flutterViewContainer) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerCreated: " + flutterViewContainer.getUniqueId() + ", " + this);
        }
        FlutterContainerManager.instance().addContainer(flutterViewContainer.getUniqueId(), flutterViewContainer);
        if (FlutterContainerManager.instance().getContainerSize() == 1) {
            changeFlutterAppLifecycle(1);
        }
    }

    public void onContainerDestroyed(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerDestroyed: " + uniqueId + ", " + this);
        }
        removeRoute(uniqueId, new F4.e(19));
        FlutterContainerManager.instance().removeContainer(uniqueId);
        if (FlutterContainerManager.instance().getContainerSize() == 0) {
            changeFlutterAppLifecycle(4);
        }
    }

    public void onContainerDisappeared(FlutterViewContainer flutterViewContainer) {
        String uniqueId = flutterViewContainer.getUniqueId();
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerDisappeared: " + uniqueId + ", " + this);
        }
        onContainerHide(uniqueId);
    }

    public void onContainerHide(String str) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerHide start: " + str + ", " + this);
        }
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setUniqueId(str);
        this.channel.onContainerHide(commonParams, new b(this, str, 2));
    }

    public void onContainerShow(String str) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onContainerShow start: " + str + ", " + this);
        }
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setUniqueId(str);
        this.channel.onContainerShow(commonParams, new b(this, str, 0));
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onDetachedFromActivity: " + this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onDetachedFromActivityForConfigChanges: " + this);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onDetachedFromEngine: " + this);
        }
        this.engine = null;
        this.channel = null;
    }

    public void onForeground() {
        Log.d(TAG, "## onForeground start: " + this);
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        this.channel.onForeground(new Messages.CommonParams(), new c(this, 0));
        changeFlutterAppLifecycle(1);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#onReattachedToActivityForConfigChanges: " + this);
        }
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void popRoute(Messages.CommonParams commonParams, Messages.Result<Void> result) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#popRoute: " + commonParams.getUniqueId() + ", " + this);
        }
        if (this.delegate == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
        }
        if (this.delegate.popRoute(new FlutterBoostRouteOptions.Builder().pageName(commonParams.getPageName()).uniqueId(commonParams.getUniqueId()).arguments(commonParams.getArguments()).build())) {
            result.success(null);
            return;
        }
        String uniqueId = commonParams.getUniqueId();
        if (uniqueId == null) {
            throw new RuntimeException("Oops!! The unique id is null!");
        }
        FlutterViewContainer flutterViewContainerFindContainerById = FlutterContainerManager.instance().findContainerById(uniqueId);
        if (flutterViewContainerFindContainerById != null) {
            flutterViewContainerFindContainerById.finishContainer(commonParams.getArguments());
        }
        result.success(null);
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushFlutterRoute(Messages.CommonParams commonParams) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#pushFlutterRoute: " + commonParams.getUniqueId() + ", " + this);
        }
        if (this.delegate == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
        }
        this.delegate.pushFlutterRoute(new FlutterBoostRouteOptions.Builder().pageName(commonParams.getPageName()).uniqueId(commonParams.getUniqueId()).opaque(commonParams.getOpaque().booleanValue()).arguments(commonParams.getArguments()).build());
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void pushNativeRoute(Messages.CommonParams commonParams) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#pushNativeRoute: " + commonParams.getUniqueId() + ", " + this);
        }
        if (this.delegate == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* set delegate!");
        }
        int i5 = this.requestCode + 1;
        this.requestCode = i5;
        SparseArray<String> sparseArray = this.pageNames;
        if (sparseArray != null) {
            sparseArray.put(i5, commonParams.getPageName());
        }
        this.delegate.pushNativeRoute(new FlutterBoostRouteOptions.Builder().pageName(commonParams.getPageName()).arguments(commonParams.getArguments()).requestCode(this.requestCode).build());
    }

    public void pushRoute(final String str, final String str2, Map<String, Object> map, final Messages.FlutterRouterApi.Reply<Void> reply) {
        if (isDebugLoggingEnabled()) {
            StringBuilder sbU = androidx.collection.a.u("#pushRoute start: ", str2, ", ", str, ", ");
            sbU.append(this);
            Log.d(TAG, sbU.toString());
        }
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setUniqueId(str);
        commonParams.setPageName(str2);
        commonParams.setArguments(map);
        this.channel.pushRoute(commonParams, new Messages.FlutterRouterApi.Reply() { // from class: com.idlefish.flutterboost.d
            @Override // com.idlefish.flutterboost.Messages.FlutterRouterApi.Reply
            public final void reply(Object obj) {
                this.f3556a.lambda$pushRoute$2(str2, str, reply, (Void) obj);
            }
        });
    }

    public void removeRoute(String str, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#removeRoute start: " + str + ", " + this);
        }
        if (this.channel == null) {
            throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
        }
        checkEngineState();
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setUniqueId(str);
        this.channel.removeRoute(commonParams, new a(this, str, reply, 1));
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void saveStackToHost(Messages.StackInfo stackInfo) {
        this.dartStack = stackInfo;
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#saveStackToHost: " + this.dartStack + ", " + this);
        }
    }

    public void sendEventToFlutter(String str, Map<String, Object> map) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#sendEventToFlutter: " + str + ", " + this);
        }
        Messages.CommonParams commonParams = new Messages.CommonParams();
        commonParams.setKey(str);
        commonParams.setArguments(map);
        getChannel().sendEventToFlutter(commonParams, new F4.e(18));
    }

    @Override // com.idlefish.flutterboost.Messages.NativeRouterApi
    public void sendEventToNative(Messages.CommonParams commonParams) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#sendEventToNative: " + this);
        }
        String key = commonParams.getKey();
        Map<String, Object> arguments = commonParams.getArguments();
        if (arguments == null) {
            arguments = new HashMap<>();
        }
        LinkedList<EventListener> linkedList = this.listenersTable.get(key);
        if (linkedList == null) {
            return;
        }
        Iterator<EventListener> it = linkedList.iterator();
        while (it.hasNext()) {
            it.next().onEvent(key, arguments);
        }
    }

    public void setDelegate(FlutterBoostDelegate flutterBoostDelegate) {
        this.delegate = flutterBoostDelegate;
    }

    public void popRoute(String str, Messages.FlutterRouterApi.Reply<Void> reply) {
        if (isDebugLoggingEnabled()) {
            Log.d(TAG, "#popRoute start: " + str + ", " + this);
        }
        if (this.channel != null) {
            checkEngineState();
            Messages.CommonParams commonParams = new Messages.CommonParams();
            commonParams.setUniqueId(str);
            this.channel.popRoute(commonParams, new a(this, str, reply, 0));
            return;
        }
        throw new RuntimeException("FlutterBoostPlugin might *NOT* have attached to engine yet!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onContainerDestroyed$11(Void r6) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendEventToFlutter$1(Void r6) {
    }
}
