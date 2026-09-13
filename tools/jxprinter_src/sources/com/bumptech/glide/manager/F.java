package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class F extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0531a f3167a;
    public final E b;
    public final HashSet c;

    @Nullable
    private Fragment parentFragmentHint;

    @Nullable
    private com.bumptech.glide.A requestManager;

    @Nullable
    private F rootRequestManagerFragment;

    public F() {
        this(new C0531a());
    }

    @Nullable
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    @Nullable
    private static FragmentManager getRootFragmentManager(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean isDescendant(@NonNull Fragment fragment) {
        Fragment parentFragmentUsingHint = getParentFragmentUsingHint();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(parentFragmentUsingHint)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        F f6 = this.rootRequestManagerFragment;
        if (f6 != null) {
            f6.c.remove(this);
            this.rootRequestManagerFragment = null;
        }
        F supportRequestManagerFragment = com.bumptech.glide.c.get(context).getRequestManagerRetriever().getSupportRequestManagerFragment(fragmentManager);
        this.rootRequestManagerFragment = supportRequestManagerFragment;
        if (equals(supportRequestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.c.add(this);
    }

    @NonNull
    public Set<F> getDescendantRequestManagerFragments() {
        F f6 = this.rootRequestManagerFragment;
        if (f6 == null) {
            return Collections.EMPTY_SET;
        }
        if (equals(f6)) {
            return Collections.unmodifiableSet(this.c);
        }
        HashSet hashSet = new HashSet();
        for (F f7 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(f7.getParentFragmentUsingHint())) {
                hashSet.add(f7);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    public C0531a getGlideLifecycle() {
        return this.f3167a;
    }

    @Nullable
    public com.bumptech.glide.A getRequestManager() {
        return this.requestManager;
    }

    @NonNull
    public w getRequestManagerTreeNode() {
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager rootFragmentManager = getRootFragmentManager(this);
        if (rootFragmentManager == null) {
            if (Log.isLoggable("SupportRMFragment", 5)) {
                Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
            }
        } else {
            try {
                registerFragmentWithRoot(getContext(), rootFragmentManager);
            } catch (IllegalStateException e) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f3167a.a();
        F f6 = this.rootRequestManagerFragment;
        if (f6 != null) {
            f6.c.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.parentFragmentHint = null;
        F f6 = this.rootRequestManagerFragment;
        if (f6 != null) {
            f6.c.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        C0531a c0531a = this.f3167a;
        c0531a.b = true;
        Iterator it = L0.s.getSnapshot(c0531a.f3169a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        C0531a c0531a = this.f3167a;
        c0531a.b = false;
        Iterator it = L0.s.getSnapshot(c0531a.f3169a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStop();
        }
    }

    public void setParentFragmentHint(@Nullable Fragment fragment) {
        FragmentManager rootFragmentManager;
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getContext() == null || (rootFragmentManager = getRootFragmentManager(fragment)) == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getContext(), rootFragmentManager);
    }

    public void setRequestManager(@Nullable com.bumptech.glide.A a6) {
        this.requestManager = a6;
    }

    @Override // androidx.fragment.app.Fragment
    public final String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + VectorFormat.DEFAULT_SUFFIX;
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public F(@NonNull C0531a c0531a) {
        this.b = new E(this);
        this.c = new HashSet();
        this.f3167a = c0531a;
    }
}
