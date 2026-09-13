package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class J extends Fragment implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3531a;
    public boolean b;

    @Nullable
    private InterfaceC0560m mCallBack;

    public static void launch(@NonNull Activity activity, @NonNull List<String> list, @Nullable InterfaceC0560m interfaceC0560m) {
        J j6 = new J();
        Bundle bundle = new Bundle();
        if (list instanceof ArrayList) {
            bundle.putStringArrayList("request_permissions", (ArrayList) list);
        } else {
            bundle.putStringArrayList("request_permissions", new ArrayList<>(list));
        }
        j6.setArguments(bundle);
        j6.setRetainInstance(true);
        j6.f3531a = true;
        j6.setOnPermissionPageCallback(interfaceC0560m);
        j6.attachByActivity(activity);
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
        if (i5 != 1025) {
            return;
        }
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || (stringArrayList = arguments.getStringArrayList("request_permissions")) == null || stringArrayList.isEmpty()) {
            return;
        }
        K.postActivityResult(stringArrayList, this);
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        if (!this.f3531a) {
            detachByActivity(getActivity());
            return;
        }
        if (this.b) {
            return;
        }
        this.b = true;
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        S.startActivityForResult(this, K.getSmartPermissionIntent(getActivity(), arguments.getStringArrayList("request_permissions")), InputDeviceCompat.SOURCE_GAMEPAD);
    }

    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        if (isAdded() && (activity = getActivity()) != null) {
            detachByActivity(activity);
        }
    }

    public void setOnPermissionPageCallback(@Nullable InterfaceC0560m interfaceC0560m) {
    }
}
