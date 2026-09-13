package com.hjq.permissions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.NonNull;
import com.android.billingclient.api.v1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.hjq.permissions.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0562o {

    @NonNull
    private static final InterfaceC0564q DELEGATE;

    static {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 34) {
            DELEGATE = new C();
            return;
        }
        if (v1.e()) {
            DELEGATE = new B();
            return;
        }
        if (i5 >= 31) {
            DELEGATE = new A();
            return;
        }
        if (v1.d()) {
            DELEGATE = new z();
            return;
        }
        if (v1.c()) {
            DELEGATE = new y();
        } else if (i5 >= 28) {
            DELEGATE = new x();
        } else {
            DELEGATE = new w();
        }
    }

    public static boolean a(List list) {
        if (list != null && !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (isSpecialPermission((String) it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<String> getDeniedPermissions(@NonNull Context context, @NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (!isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static List<String> getGrantedPermissions(@NonNull Context context, @NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            if (isGrantedPermission(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static Intent getPermissionIntent(@NonNull Context context, @NonNull String str) {
        return DELEGATE.getPermissionIntent(context, str);
    }

    public static int getPermissionResult(@NonNull Context context, @NonNull String str) {
        return isGrantedPermission(context, str) ? 0 : -1;
    }

    public static boolean isDoNotAskAgainPermission(@NonNull Activity activity, @NonNull String str) {
        return DELEGATE.isDoNotAskAgainPermission(activity, str);
    }

    public static boolean isDoNotAskAgainPermissions(@NonNull Activity activity, @NonNull List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (isDoNotAskAgainPermission(activity, it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isGrantedPermission(@NonNull Context context, @NonNull String str) {
        return DELEGATE.isGrantedPermission(context, str);
    }

    public static boolean isGrantedPermissions(@NonNull Context context, @NonNull List<String> list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (!isGrantedPermission(context, it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSpecialPermission(@NonNull String str) {
        return AbstractC0561n.isSpecialPermission(str);
    }

    public static List<String> getDeniedPermissions(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] == -1) {
                arrayList.add(list.get(i5));
            }
        }
        return arrayList;
    }

    public static List<String> getGrantedPermissions(@NonNull List<String> list, @NonNull int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (iArr[i5] == 0) {
                arrayList.add(list.get(i5));
            }
        }
        return arrayList;
    }
}
