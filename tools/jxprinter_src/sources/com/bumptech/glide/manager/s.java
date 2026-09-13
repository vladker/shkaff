package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class s extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0531a f3175a;
    public final r b;
    public final HashSet c;

    @Nullable
    private Fragment parentFragmentHint;

    @Nullable
    private com.bumptech.glide.A requestManager;

    @Nullable
    private s rootRequestManagerFragment;

    public s() {
        this(new C0531a());
    }

    @Nullable
    @TargetApi(17)
    private Fragment getParentFragmentUsingHint() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.parentFragmentHint;
    }

    @TargetApi(17)
    private boolean isDescendant(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void registerFragmentWithRoot(@NonNull Activity activity) {
        s sVar = this.rootRequestManagerFragment;
        if (sVar != null) {
            sVar.c.remove(this);
            this.rootRequestManagerFragment = null;
        }
        s requestManagerFragment = com.bumptech.glide.c.get(activity).getRequestManagerRetriever().getRequestManagerFragment(activity);
        this.rootRequestManagerFragment = requestManagerFragment;
        if (equals(requestManagerFragment)) {
            return;
        }
        this.rootRequestManagerFragment.c.add(this);
    }

    @NonNull
    @TargetApi(17)
    public Set<s> getDescendantRequestManagerFragments() {
        if (equals(this.rootRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.c);
        }
        if (this.rootRequestManagerFragment == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet();
        for (s sVar : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(sVar.getParentFragment())) {
                hashSet.add(sVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @NonNull
    public C0531a getGlideLifecycle() {
        return this.f3175a;
    }

    @Nullable
    public com.bumptech.glide.A getRequestManager() {
        return this.requestManager;
    }

    @NonNull
    public w getRequestManagerTreeNode() {
        return this.b;
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            registerFragmentWithRoot(activity);
        } catch (IllegalStateException e) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e);
            }
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f3175a.a();
        s sVar = this.rootRequestManagerFragment;
        if (sVar != null) {
            sVar.c.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // android.app.Fragment
    public final void onDetach() {
        super.onDetach();
        s sVar = this.rootRequestManagerFragment;
        if (sVar != null) {
            sVar.c.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        C0531a c0531a = this.f3175a;
        c0531a.b = true;
        Iterator it = L0.s.getSnapshot(c0531a.f3169a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        C0531a c0531a = this.f3175a;
        c0531a.b = false;
        Iterator it = L0.s.getSnapshot(c0531a.f3169a).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStop();
        }
    }

    public void setParentFragmentHint(@Nullable Fragment fragment) {
        this.parentFragmentHint = fragment;
        if (fragment == null || fragment.getActivity() == null) {
            return;
        }
        registerFragmentWithRoot(fragment.getActivity());
    }

    public void setRequestManager(@Nullable com.bumptech.glide.A a6) {
        this.requestManager = a6;
    }

    @Override // android.app.Fragment
    public final String toString() {
        return super.toString() + "{parent=" + getParentFragmentUsingHint() + VectorFormat.DEFAULT_SUFFIX;
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public s(@NonNull C0531a c0531a) {
        this.b = new r(this);
        this.c = new HashSet();
        this.f3175a = c0531a;
    }
}
