package com.hjq.permissions;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.v1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class H extends Fragment implements Runnable {
    public static final ArrayList e = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3530a;
    public boolean b;
    public boolean c;
    public int d;

    @Nullable
    private InterfaceC0558k mCallBack;

    @Nullable
    private InterfaceC0559l mInterceptor;

    public static void launch(@NonNull Activity activity, @NonNull List<String> list, @NonNull InterfaceC0559l interfaceC0559l, @Nullable InterfaceC0558k interfaceC0558k) {
        int iNextInt;
        Integer numValueOf;
        ArrayList arrayList;
        H h6 = new H();
        Random random = new Random();
        do {
            iNextInt = random.nextInt((int) Math.pow(2.0d, 8.0d));
            numValueOf = Integer.valueOf(iNextInt);
            arrayList = e;
        } while (arrayList.contains(numValueOf));
        arrayList.add(Integer.valueOf(iNextInt));
        Bundle bundle = new Bundle();
        bundle.putInt("request_code", iNextInt);
        if (list instanceof ArrayList) {
            bundle.putStringArrayList("request_permissions", (ArrayList) list);
        } else {
            bundle.putStringArrayList("request_permissions", new ArrayList<>(list));
        }
        h6.setArguments(bundle);
        h6.setRetainInstance(true);
        h6.c = true;
        h6.setOnPermissionCallback(interfaceC0558k);
        h6.setOnPermissionInterceptor(interfaceC0559l);
        h6.attachByActivity(activity);
    }

    public final void a() {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i5 = arguments.getInt("request_code");
        ArrayList<String> stringArrayList = arguments.getStringArrayList("request_permissions");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return;
        }
        if (v1.e() && stringArrayList.size() >= 2 && K.containsPermission(stringArrayList, "android.permission.BODY_SENSORS_BACKGROUND")) {
            ArrayList arrayList = new ArrayList(stringArrayList);
            arrayList.remove("android.permission.BODY_SENSORS_BACKGROUND");
            splitTwiceRequestPermission(activity, stringArrayList, arrayList, i5);
            return;
        }
        if (v1.c() && stringArrayList.size() >= 2 && K.containsPermission(stringArrayList, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            ArrayList arrayList2 = new ArrayList(stringArrayList);
            arrayList2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            splitTwiceRequestPermission(activity, stringArrayList, arrayList2, i5);
        } else {
            if (!v1.c() || !K.containsPermission(stringArrayList, "android.permission.ACCESS_MEDIA_LOCATION") || !K.containsPermission(stringArrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), i5);
                return;
            }
            ArrayList arrayList3 = new ArrayList(stringArrayList);
            arrayList3.remove("android.permission.ACCESS_MEDIA_LOCATION");
            splitTwiceRequestPermission(activity, stringArrayList, arrayList3, i5);
        }
    }

    public void attachByActivity(@NonNull Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void detachByActivity(@NonNull Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        fragmentManager.beginTransaction().remove(this).commitAllowingStateLoss();
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i5, int i6, @Nullable Intent intent) {
        ArrayList<String> stringArrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.b || i5 != arguments.getInt("request_code") || (stringArrayList = arguments.getStringArrayList("request_permissions")) == null || stringArrayList.isEmpty()) {
            return;
        }
        this.b = true;
        K.postActivityResult(stringArrayList, this);
    }

    @Override // android.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.d = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        K.lockActivityOrientation(activity);
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.mCallBack = null;
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.d != -1 || activity.getRequestedOrientation() == -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (strArr == null || strArr.length == 0 || iArr == null || iArr.length == 0) {
            return;
        }
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (activity == null || arguments == null || this.mInterceptor == null || i5 != arguments.getInt("request_code")) {
            return;
        }
        InterfaceC0558k interfaceC0558k = this.mCallBack;
        this.mCallBack = null;
        InterfaceC0559l interfaceC0559l = this.mInterceptor;
        this.mInterceptor = null;
        K.optimizePermissionResults(activity, strArr, iArr);
        ArrayList arrayListAsArrayList = K.asArrayList(strArr);
        e.remove(Integer.valueOf(i5));
        detachByActivity(activity);
        List<String> grantedPermissions = AbstractC0562o.getGrantedPermissions(arrayListAsArrayList, iArr);
        if (grantedPermissions.size() == arrayListAsArrayList.size()) {
            interfaceC0559l.grantedPermissionRequest(activity, arrayListAsArrayList, grantedPermissions, true, interfaceC0558k);
            interfaceC0559l.finishPermissionRequest(activity, arrayListAsArrayList, false, interfaceC0558k);
            return;
        }
        List<String> deniedPermissions = AbstractC0562o.getDeniedPermissions(arrayListAsArrayList, iArr);
        interfaceC0559l.deniedPermissionRequest(activity, arrayListAsArrayList, deniedPermissions, AbstractC0562o.isDoNotAskAgainPermissions(activity, deniedPermissions), interfaceC0558k);
        if (!grantedPermissions.isEmpty()) {
            interfaceC0559l.grantedPermissionRequest(activity, arrayListAsArrayList, grantedPermissions, false, interfaceC0558k);
        }
        interfaceC0559l.finishPermissionRequest(activity, arrayListAsArrayList, false, interfaceC0558k);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        ArrayList<String> stringArrayList;
        super.onResume();
        if (!this.c) {
            detachByActivity(getActivity());
            return;
        }
        if (this.f3530a) {
            return;
        }
        this.f3530a = true;
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null || (stringArrayList = arguments.getStringArrayList("request_permissions")) == null || stringArrayList.isEmpty()) {
            return;
        }
        int size = stringArrayList.size();
        boolean z6 = false;
        int i5 = 0;
        while (i5 < size) {
            String str = stringArrayList.get(i5);
            i5++;
            String str2 = str;
            if (AbstractC0562o.isSpecialPermission(str2) && !AbstractC0562o.isGrantedPermission(activity, str2) && (v1.d() || !K.equalsPermission(str2, "android.permission.MANAGE_EXTERNAL_STORAGE"))) {
                S.startActivityForResult(this, K.getSmartPermissionIntent(activity, K.asArrayList(str2)), getArguments().getInt("request_code"));
                z6 = true;
            }
        }
        if (z6) {
            return;
        }
        a();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (isAdded()) {
            a();
        }
    }

    public void setOnPermissionCallback(@Nullable InterfaceC0558k interfaceC0558k) {
        this.mCallBack = interfaceC0558k;
    }

    public void setOnPermissionInterceptor(@Nullable InterfaceC0559l interfaceC0559l) {
        this.mInterceptor = interfaceC0559l;
    }

    public void splitTwiceRequestPermission(@NonNull Activity activity, @NonNull List<String> list, @NonNull List<String> list2, int i5) {
        ArrayList arrayList = new ArrayList(list);
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.remove(it.next());
        }
        launch(activity, list2, new D(), new G(this, activity, arrayList, list, i5));
    }
}
