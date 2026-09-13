package com.hjq.permissions;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.v1;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class S {
    public static Intent addSubIntentToMainIntent(@Nullable Intent intent, @Nullable Intent intent2) {
        if (intent == null && intent2 != null) {
            return intent2;
        }
        if (intent2 == null) {
            return intent;
        }
        getDeepSubIntent(intent).putExtra("sub_intent_key", intent2);
        return intent;
    }

    public static Intent getDeepSubIntent(@NonNull Intent intent) {
        Intent subIntentInMainIntent = getSubIntentInMainIntent(intent);
        return subIntentInMainIntent != null ? getDeepSubIntent(subIntentInMainIntent) : intent;
    }

    public static Intent getSubIntentInMainIntent(@NonNull Intent intent) {
        return v1.e() ? (Intent) intent.getParcelableExtra("sub_intent_key", Intent.class) : (Intent) intent.getParcelableExtra("sub_intent_key");
    }

    public static boolean startActivity(@NonNull Context context, Intent intent) {
        return startActivity(new O(context, 0), intent);
    }

    public static boolean startActivityForResult(@NonNull Activity activity, @NonNull Intent intent, int i5) {
        return startActivityForResult(new N(activity, 0), intent, i5);
    }

    public static boolean startActivity(@NonNull Activity activity, Intent intent) {
        return startActivity(new N(activity, 0), intent);
    }

    public static boolean startActivityForResult(@NonNull Fragment fragment, @NonNull Intent intent, int i5) {
        return startActivityForResult(new P(fragment, 0), intent, i5);
    }

    public static boolean startActivity(@NonNull Fragment fragment, Intent intent) {
        return startActivity(new P(fragment, 0), intent);
    }

    public static boolean startActivityForResult(@NonNull androidx.fragment.app.Fragment fragment, @NonNull Intent intent, int i5) {
        return startActivityForResult(new Q(fragment, 0), intent, i5);
    }

    public static boolean startActivity(@NonNull androidx.fragment.app.Fragment fragment, Intent intent) {
        return startActivity(new Q(fragment, 0), intent);
    }

    public static boolean startActivityForResult(@NonNull M m6, @NonNull Intent intent, int i5) {
        try {
            m6.startActivityForResult(intent, i5);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent subIntentInMainIntent = getSubIntentInMainIntent(intent);
            if (subIntentInMainIntent == null) {
                return false;
            }
            return startActivityForResult(m6, subIntentInMainIntent, i5);
        }
    }

    public static boolean startActivity(@NonNull M m6, @NonNull Intent intent) {
        try {
            m6.startActivity(intent);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Intent subIntentInMainIntent = getSubIntentInMainIntent(intent);
            if (subIntentInMainIntent == null) {
                return false;
            }
            return startActivity(m6, subIntentInMainIntent);
        }
    }
}
