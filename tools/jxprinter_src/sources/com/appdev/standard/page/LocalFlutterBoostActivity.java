package com.appdev.standard.page;

import A3.AbstractC0157z;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.contract.ActivityResultContract;
import com.appdev.standard.dialog.PermissionTipDialog;
import com.hjq.permissions.InterfaceC0558k;
import com.hjq.permissions.V;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.AbstractC1095i;
import kotlin.jvm.internal.E;
import p056k0.i;
import p102s.G;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class LocalFlutterBoostActivity extends FlutterBoostActivity {
    private HashMap<Integer, p026e2.a> requestPermissionMap;
    private final AtomicInteger nextLocalRequestCode = new AtomicInteger();
    private final i mediaPicker = new i();
    private final ActivityResultRegistry activityResultRegistry = new LocalFlutterBoostActivity$activityResultRegistry$1(this);

    public final void checkAndRequestPermissions(String[] permissions, com.library.base.frame.c permissionTip, p026e2.a aVar) {
        final int iNextInt;
        HashMap<Integer, p026e2.a> map;
        E.f(permissions, "permissions");
        E.f(permissionTip, "permissionTip");
        if (aVar != null) {
            do {
                iNextInt = new Random().nextInt(Integer.MAX_VALUE);
                map = this.requestPermissionMap;
                E.c(map);
            } while (map.containsKey(Integer.valueOf(iNextInt)));
            Integer numValueOf = Integer.valueOf(iNextInt);
            HashMap<Integer, p026e2.a> map2 = this.requestPermissionMap;
            E.c(map2);
            map2.put(numValueOf, aVar);
        } else {
            iNextInt = 0;
        }
        final V vWith = V.with(this);
        for (String str : permissions) {
            vWith.permission(str);
        }
        if (hasPermission((String[]) Arrays.copyOf(permissions, permissions.length))) {
            doRequestPermissionSuccess(iNextInt);
            return;
        }
        PermissionTipDialog permissionTipDialog = (PermissionTipDialog) permissionTip;
        permissionTipDialog.f2624a = new com.library.base.frame.d() { // from class: com.appdev.standard.page.LocalFlutterBoostActivity.checkAndRequestPermissions.1
            @Override // com.library.base.frame.d
            public void onCancel() {
                this.doRequestPermissionFail(iNextInt);
            }

            @Override // com.library.base.frame.d
            public void onConfirm() {
                V v6 = vWith;
                final LocalFlutterBoostActivity localFlutterBoostActivity = this;
                final int i5 = iNextInt;
                v6.request(new InterfaceC0558k() { // from class: com.appdev.standard.page.LocalFlutterBoostActivity$checkAndRequestPermissions$1$onConfirm$1
                    @Override // com.hjq.permissions.InterfaceC0558k
                    public void onDenied(List<String> permissions2, boolean z6) {
                        E.f(permissions2, "permissions");
                        if (!z6) {
                            localFlutterBoostActivity.doRequestPermissionFail(i5);
                            return;
                        }
                        V.startPermissionActivity((Activity) localFlutterBoostActivity, permissions2);
                        HashMap<Integer, p026e2.a> requestPermissionMap = localFlutterBoostActivity.getRequestPermissionMap();
                        E.c(requestPermissionMap);
                        if (requestPermissionMap.get(Integer.valueOf(i5)) != null) {
                            HashMap<Integer, p026e2.a> requestPermissionMap2 = localFlutterBoostActivity.getRequestPermissionMap();
                            E.c(requestPermissionMap2);
                            requestPermissionMap2.remove(Integer.valueOf(i5));
                        }
                    }

                    @Override // com.hjq.permissions.InterfaceC0558k
                    public void onGranted(List<String> permissions2, boolean z6) {
                        E.f(permissions2, "permissions");
                        if (z6) {
                            localFlutterBoostActivity.doRequestPermissionSuccess(i5);
                        } else {
                            localFlutterBoostActivity.doRequestPermissionFail(i5);
                        }
                    }
                });
            }
        };
        permissionTipDialog.show();
    }

    public final void doRequestPermissionFail(int i5) {
        HashMap<Integer, p026e2.a> map = this.requestPermissionMap;
        E.c(map);
        p026e2.a aVar = map.get(Integer.valueOf(i5));
        if (aVar != null) {
            aVar.onRequestPermissionFail();
            HashMap<Integer, p026e2.a> map2 = this.requestPermissionMap;
            E.c(map2);
            map2.remove(Integer.valueOf(i5));
        }
        Iterator it = AbstractC1095i.iterator(LocalFlutterBoostActivity.class.getMethods());
        while (it.hasNext()) {
            Method method = (Method) it.next();
            p005a2.a aVar2 = (p005a2.a) method.getAnnotation(p005a2.a.class);
            if (aVar2 != null && aVar2.requestCode() == i5) {
                try {
                    method.invoke(this, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void doRequestPermissionSuccess(int i5) {
        HashMap<Integer, p026e2.a> map = this.requestPermissionMap;
        E.c(map);
        p026e2.a aVar = map.get(Integer.valueOf(i5));
        if (aVar != null) {
            aVar.onRequestPermissionSuccess();
            HashMap<Integer, p026e2.a> map2 = this.requestPermissionMap;
            E.c(map2);
            map2.remove(Integer.valueOf(i5));
        }
        Iterator it = AbstractC1095i.iterator(LocalFlutterBoostActivity.class.getMethods());
        while (it.hasNext()) {
            Method method = (Method) it.next();
            p005a2.b bVar = (p005a2.b) method.getAnnotation(p005a2.b.class);
            if (bVar != null && bVar.requestCode() == i5) {
                try {
                    method.invoke(this, null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    public final i getMediaPicker() {
        return this.mediaPicker;
    }

    public final HashMap<Integer, p026e2.a> getRequestPermissionMap() {
        return this.requestPermissionMap;
    }

    public final boolean hasPermission(String... permissions) {
        E.f(permissions, "permissions");
        return V.isGranted(this, (String[]) Arrays.copyOf(permissions, permissions.length));
    }

    public final void needBlueToothPermission(com.library.base.frame.c permissionTip, p026e2.a aVar) {
        E.f(permissionTip, "permissionTip");
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.BLUETOOTH_SCAN");
        arrayList.add("android.permission.BLUETOOTH_ADVERTISE");
        arrayList.add("android.permission.BLUETOOTH_CONNECT");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        checkAndRequestPermissions((String[]) arrayList.toArray(new String[0]), permissionTip, aVar);
    }

    public final void needCameraPermission(com.library.base.frame.c permissionTip, p026e2.a aVar) {
        E.f(permissionTip, "permissionTip");
        checkAndRequestPermissions(new String[]{"android.permission.CAMERA"}, permissionTip, aVar);
    }

    public final void needStoragePermission(com.library.base.frame.c permissionTip, p026e2.a aVar) {
        E.f(permissionTip, "permissionTip");
        checkAndRequestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO"}, permissionTip, aVar);
    }

    @Override // io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (this.activityResultRegistry.dispatchResult(i5, i6, intent)) {
            return;
        }
        super.onActivityResult(i5, i6, intent);
        G.Companion.onActivityResult(i5, i6, intent);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        V1.b.h().getClass();
        if (V1.b.b.empty() || V1.b.b.lastElement() != this) {
            V1.b.b.add(this);
        }
        this.mediaPicker.attachToActivity(this);
        this.requestPermissionMap = new HashMap<>();
    }

    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onDestroy() {
        V1.b.h().getClass();
        V1.b.b.remove(this);
        super.onDestroy();
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> contract, ActivityResultRegistry registry, ActivityResultCallback<O> callback) {
        E.f(contract, "contract");
        E.f(registry, "registry");
        E.f(callback, "callback");
        return registry.register(AbstractC0157z.k(this.nextLocalRequestCode.getAndIncrement(), "activity_rq#"), this, contract, callback);
    }

    public final void setRequestPermissionMap(HashMap<Integer, p026e2.a> map) {
        this.requestPermissionMap = map;
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> contract, ActivityResultCallback<O> callback) {
        E.f(contract, "contract");
        E.f(callback, "callback");
        return registerForActivityResult(contract, this.activityResultRegistry, callback);
    }
}
