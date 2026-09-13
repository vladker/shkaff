package com.bumptech.glide.manager;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bumptech.glide.load.resource.bitmap.C0530z;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class v implements Handler.Callback {

    @VisibleForTesting
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final t f3176i = new t();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bumptech.glide.A f3177a;
    public final Handler b;
    public final u c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f3179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f3180h;

    @VisibleForTesting
    final Map<FragmentManager, s> pendingRequestManagerFragments = new HashMap();

    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, F> pendingSupportRequestManagerFragments = new HashMap();
    public final ArrayMap d = new ArrayMap();
    public final ArrayMap e = new ArrayMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bundle f3178f = new Bundle();

    public v(@Nullable u uVar, com.bumptech.glide.l lVar) {
        uVar = uVar == null ? f3176i : uVar;
        this.c = uVar;
        this.b = new Handler(Looper.getMainLooper(), this);
        this.f3180h = new p(uVar);
        this.f3179g = (C0530z.f3127f && C0530z.e) ? lVar.f2913a.containsKey(com.bumptech.glide.h.class) ? new i() : new V1.b(15) : new V1.b(14);
    }

    @TargetApi(17)
    private static void assertNotDestroyed(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    private static Activity findActivity(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void findAllFragmentsWithViews(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, Fragment> arrayMap) {
        for (Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
            }
        }
    }

    @Deprecated
    private void findAllFragmentsWithViewsPreO(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, Fragment> arrayMap) {
        Fragment fragment;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            Bundle bundle = this.f3178f;
            bundle.putInt(Constants.KEY, i5);
            try {
                fragment = fragmentManager.getFragment(bundle, Constants.KEY);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                findAllFragmentsWithViews(fragment.getChildFragmentManager(), arrayMap);
            }
            i5 = i6;
        }
    }

    private static void findAllSupportFragmentsWithViews(@Nullable Collection<androidx.fragment.app.Fragment> collection, @NonNull Map<View, androidx.fragment.app.Fragment> map) {
        if (collection == null) {
            return;
        }
        for (androidx.fragment.app.Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                findAllSupportFragmentsWithViews(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private Fragment findFragment(@NonNull View view, @NonNull Activity activity) {
        ArrayMap<View, Fragment> arrayMap = this.e;
        arrayMap.clear();
        findAllFragmentsWithViews(activity.getFragmentManager(), arrayMap);
        View viewFindViewById = activity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = arrayMap.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        arrayMap.clear();
        return fragment;
    }

    @Nullable
    private androidx.fragment.app.Fragment findSupportFragment(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        ArrayMap arrayMap = this.d;
        arrayMap.clear();
        findAllSupportFragmentsWithViews(fragmentActivity.getSupportFragmentManager().getFragments(), arrayMap);
        View viewFindViewById = fragmentActivity.findViewById(R.id.content);
        androidx.fragment.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = (androidx.fragment.app.Fragment) arrayMap.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        arrayMap.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private com.bumptech.glide.A fragmentGet(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z6) {
        s requestManagerFragment = getRequestManagerFragment(fragmentManager, fragment);
        com.bumptech.glide.A requestManager = requestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        com.bumptech.glide.A aBuild = ((t) this.c).build(com.bumptech.glide.c.get(context), requestManagerFragment.getGlideLifecycle(), requestManagerFragment.getRequestManagerTreeNode(), context);
        if (z6) {
            aBuild.onStart();
        }
        requestManagerFragment.setRequestManager(aBuild);
        return aBuild;
    }

    @NonNull
    private com.bumptech.glide.A getApplicationManager(@NonNull Context context) {
        if (this.f3177a == null) {
            synchronized (this) {
                try {
                    if (this.f3177a == null) {
                        com.bumptech.glide.c cVar = com.bumptech.glide.c.get(context.getApplicationContext());
                        this.f3177a = ((t) this.c).build(cVar, new C0532b(), new h(), context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f3177a;
    }

    @NonNull
    public com.bumptech.glide.A get(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        char[] cArr = L0.s.f411a;
        if (Looper.myLooper() == Looper.getMainLooper() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return get((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return get((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return get(contextWrapper.getBaseContext());
                }
            }
        }
        return getApplicationManager(context);
    }

    @NonNull
    @Deprecated
    public s getRequestManagerFragment(Activity activity) {
        return getRequestManagerFragment(activity.getFragmentManager(), null);
    }

    @NonNull
    public F getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager fragmentManager) {
        return getSupportRequestManagerFragment(fragmentManager, null);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        ComponentCallbacks componentCallbacksRemove;
        Object obj;
        Object obj2;
        boolean z6 = true;
        boolean z7 = false;
        boolean z8 = message.arg1 == 1;
        int i5 = message.what;
        Handler handler = this.b;
        if (i5 != 1) {
            if (i5 != 2) {
                z6 = false;
            } else {
                androidx.fragment.app.FragmentManager fragmentManager = (androidx.fragment.app.FragmentManager) message.obj;
                F f6 = this.pendingSupportRequestManagerFragments.get(fragmentManager);
                F f7 = (F) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
                if (f7 != f6) {
                    if (f7 != null && f7.getRequestManager() != null) {
                        throw new IllegalStateException("We've added two fragments with requests! Old: " + f7 + " New: " + f6);
                    }
                    if (z8 || fragmentManager.isDestroyed()) {
                        if (fragmentManager.isDestroyed()) {
                            if (Log.isLoggable("RMRetriever", 5)) {
                                Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added, all requests for the destroyed parent are cancelled");
                            }
                        } else if (Log.isLoggable("RMRetriever", 6)) {
                            Log.e("RMRetriever", "ERROR: Tried adding Fragment twice and failed twice, giving up and cancelling all associated requests! This probably means you're starting loads in a unit test with an Activity that you haven't created and never create. If you're using Robolectric, create the Activity as part of your test setup");
                        }
                        f6.getGlideLifecycle().a();
                    } else {
                        FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(f6, FRAGMENT_TAG);
                        if (f7 != null) {
                            fragmentTransactionAdd.remove(f7);
                        }
                        fragmentTransactionAdd.commitNowAllowingStateLoss();
                        handler.obtainMessage(2, 1, 0, fragmentManager).sendToTarget();
                        if (Log.isLoggable("RMRetriever", 3)) {
                            Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
                        }
                        z7 = true;
                        z6 = false;
                    }
                }
                componentCallbacksRemove = this.pendingSupportRequestManagerFragments.remove(fragmentManager);
                obj = fragmentManager;
                z7 = true;
                obj2 = obj;
            }
            obj2 = null;
            componentCallbacksRemove = null;
        } else {
            FragmentManager fragmentManager2 = (FragmentManager) message.obj;
            s sVar = this.pendingRequestManagerFragments.get(fragmentManager2);
            s sVar2 = (s) fragmentManager2.findFragmentByTag(FRAGMENT_TAG);
            if (sVar2 != sVar) {
                if (sVar2 != null && sVar2.getRequestManager() != null) {
                    throw new IllegalStateException("We've added two fragments with requests! Old: " + sVar2 + " New: " + sVar);
                }
                if (z8 || fragmentManager2.isDestroyed()) {
                    if (Log.isLoggable("RMRetriever", 5)) {
                        if (fragmentManager2.isDestroyed()) {
                            Log.w("RMRetriever", "Parent was destroyed before our Fragment could be added");
                        } else {
                            Log.w("RMRetriever", "Tried adding Fragment twice and failed twice, giving up!");
                        }
                    }
                    sVar.getGlideLifecycle().a();
                } else {
                    android.app.FragmentTransaction fragmentTransactionAdd2 = fragmentManager2.beginTransaction().add(sVar, FRAGMENT_TAG);
                    if (sVar2 != null) {
                        fragmentTransactionAdd2.remove(sVar2);
                    }
                    fragmentTransactionAdd2.commitAllowingStateLoss();
                    handler.obtainMessage(1, 1, 0, fragmentManager2).sendToTarget();
                    if (Log.isLoggable("RMRetriever", 3)) {
                        Log.d("RMRetriever", "We failed to add our Fragment the first time around, trying again...");
                    }
                    z7 = true;
                    z6 = false;
                    obj2 = null;
                    componentCallbacksRemove = null;
                }
            }
            componentCallbacksRemove = this.pendingRequestManagerFragments.remove(fragmentManager2);
            obj = fragmentManager2;
            z7 = true;
            obj2 = obj;
        }
        if (Log.isLoggable("RMRetriever", 5) && z6 && componentCallbacksRemove == null) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z7;
    }

    @NonNull
    private s getRequestManagerFragment(@NonNull FragmentManager fragmentManager, @Nullable Fragment fragment) {
        s sVar = this.pendingRequestManagerFragments.get(fragmentManager);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = (s) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (sVar2 != null) {
            return sVar2;
        }
        s sVar3 = new s();
        sVar3.setParentFragmentHint(fragment);
        this.pendingRequestManagerFragments.put(fragmentManager, sVar3);
        fragmentManager.beginTransaction().add(sVar3, FRAGMENT_TAG).commitAllowingStateLoss();
        this.b.obtainMessage(1, fragmentManager).sendToTarget();
        return sVar3;
    }

    @NonNull
    private F getSupportRequestManagerFragment(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable androidx.fragment.app.Fragment fragment) {
        F f6 = this.pendingSupportRequestManagerFragments.get(fragmentManager);
        if (f6 != null) {
            return f6;
        }
        F f7 = (F) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (f7 != null) {
            return f7;
        }
        F f8 = new F();
        f8.setParentFragmentHint(fragment);
        this.pendingSupportRequestManagerFragments.put(fragmentManager, f8);
        fragmentManager.beginTransaction().add(f8, FRAGMENT_TAG).commitAllowingStateLoss();
        this.b.obtainMessage(2, fragmentManager).sendToTarget();
        return f8;
    }

    @NonNull
    public com.bumptech.glide.A get(@NonNull FragmentActivity fragmentActivity) {
        if (L0.s.d()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        this.f3179g.getClass();
        Activity activityFindActivity = findActivity(fragmentActivity);
        return this.f3180h.a(fragmentActivity, com.bumptech.glide.c.get(fragmentActivity.getApplicationContext()), fragmentActivity.getLifecycle(), fragmentActivity.getSupportFragmentManager(), activityFindActivity == null || !activityFindActivity.isFinishing());
    }

    @NonNull
    public com.bumptech.glide.A get(@NonNull androidx.fragment.app.Fragment fragment) {
        L0.q.checkNotNull(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (L0.s.d()) {
            return get(fragment.getContext().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            fragment.getActivity();
            this.f3179g.getClass();
        }
        androidx.fragment.app.FragmentManager childFragmentManager = fragment.getChildFragmentManager();
        Context context = fragment.getContext();
        return this.f3180h.a(context, com.bumptech.glide.c.get(context.getApplicationContext()), fragment.getLifecycle(), childFragmentManager, fragment.isVisible());
    }

    @NonNull
    @Deprecated
    public com.bumptech.glide.A get(@NonNull Activity activity) {
        if (L0.s.d()) {
            return get(activity.getApplicationContext());
        }
        if (activity instanceof FragmentActivity) {
            return get((FragmentActivity) activity);
        }
        assertNotDestroyed(activity);
        this.f3179g.getClass();
        FragmentManager fragmentManager = activity.getFragmentManager();
        Activity activityFindActivity = findActivity(activity);
        return fragmentGet(activity, fragmentManager, null, activityFindActivity == null || !activityFindActivity.isFinishing());
    }

    @NonNull
    public com.bumptech.glide.A get(@NonNull View view) {
        if (L0.s.d()) {
            return get(view.getContext().getApplicationContext());
        }
        L0.q.checkNotNull(view);
        L0.q.checkNotNull(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityFindActivity = findActivity(view.getContext());
        if (activityFindActivity == null) {
            return get(view.getContext().getApplicationContext());
        }
        if (activityFindActivity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activityFindActivity;
            androidx.fragment.app.Fragment fragmentFindSupportFragment = findSupportFragment(view, fragmentActivity);
            return fragmentFindSupportFragment != null ? get(fragmentFindSupportFragment) : get(fragmentActivity);
        }
        Fragment fragmentFindFragment = findFragment(view, activityFindActivity);
        if (fragmentFindFragment == null) {
            return get(activityFindActivity);
        }
        return get(fragmentFindFragment);
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.A get(@NonNull Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!L0.s.d()) {
                if (fragment.getActivity() != null) {
                    fragment.getActivity();
                    this.f3179g.getClass();
                }
                return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
            }
            return get(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}
