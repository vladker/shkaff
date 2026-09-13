package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback<H> extends FragmentContainer {
    private final Activity activity;
    private final Context context;
    private final FragmentManager fragmentManager;
    private final Handler handler;
    private final int windowAnimations;

    public FragmentHostCallback(Activity activity, Context context, Handler handler, int i5) {
        E.f(context, "context");
        E.f(handler, "handler");
        this.activity = activity;
        this.context = context;
        this.handler = handler;
        this.windowAnimations = i5;
        this.fragmentManager = new FragmentManagerImpl();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Activity getActivity() {
        return this.activity;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Context getContext() {
        return this.context;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final Handler getHandler() {
        return this.handler;
    }

    public void onDump(String prefix, FileDescriptor fileDescriptor, PrintWriter writer, String[] strArr) {
        E.f(prefix, "prefix");
        E.f(writer, "writer");
    }

    @Override // androidx.fragment.app.FragmentContainer
    public View onFindViewById(int i5) {
        return null;
    }

    public abstract H onGetHost();

    public LayoutInflater onGetLayoutInflater() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.context);
        E.e(layoutInflaterFrom, "from(context)");
        return layoutInflaterFrom;
    }

    public int onGetWindowAnimations() {
        return this.windowAnimations;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(Fragment fragment, String[] permissions, int i5) {
        E.f(fragment, "fragment");
        E.f(permissions, "permissions");
    }

    public boolean onShouldSaveFragmentState(Fragment fragment) {
        E.f(fragment, "fragment");
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(String permission) {
        E.f(permission, "permission");
        return false;
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i5) {
        E.f(fragment, "fragment");
        E.f(intent, "intent");
        onStartActivityFromFragment(fragment, intent, i5, null);
    }

    public void onStartIntentSenderFromFragment(Fragment fragment, IntentSender intent, int i5, Intent intent2, int i6, int i7, int i8, Bundle bundle) {
        E.f(fragment, "fragment");
        E.f(intent, "intent");
        if (i5 != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        Activity activity = this.activity;
        if (activity == null) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        ActivityCompat.startIntentSenderForResult(activity, intent, i5, intent2, i6, i7, i8, bundle);
    }

    public void onStartActivityFromFragment(Fragment fragment, Intent intent, int i5, Bundle bundle) {
        E.f(fragment, "fragment");
        E.f(intent, "intent");
        if (i5 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        ContextCompat.startActivity(this.context, intent, bundle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(Context context, Handler handler, int i5) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i5);
        E.f(context, "context");
        E.f(handler, "handler");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(FragmentActivity activity) {
        this(activity, activity, new Handler(), 0);
        E.f(activity, "activity");
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}
