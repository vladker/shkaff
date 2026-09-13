package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements k, LifecycleObserver {

    @NonNull
    private final Lifecycle lifecycle;

    @NonNull
    private final Set<m> lifecycleListeners = new HashSet();

    public l(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    @Override // com.bumptech.glide.manager.k
    public void addListener(@NonNull m mVar) {
        this.lifecycleListeners.add(mVar);
        if (this.lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            mVar.onDestroy();
        } else if (this.lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            mVar.onStart();
        } else {
            mVar.onStop();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = L0.s.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onDestroy();
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = L0.s.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStart();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
        Iterator it = L0.s.getSnapshot(this.lifecycleListeners).iterator();
        while (it.hasNext()) {
            ((m) it.next()).onStop();
        }
    }

    @Override // com.bumptech.glide.manager.k
    public void removeListener(@NonNull m mVar) {
        this.lifecycleListeners.remove(mVar);
    }
}
