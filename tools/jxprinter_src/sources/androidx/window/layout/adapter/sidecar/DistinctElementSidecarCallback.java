package androidx.window.layout.adapter.sidecar;

import android.os.IBinder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DistinctElementSidecarCallback implements SidecarInterface.SidecarCallback {

    @GuardedBy("mLock")
    private final Map<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;
    private final SidecarAdapter mAdapter;
    private final SidecarInterface.SidecarCallback mCallback;

    @GuardedBy("mLock")
    private SidecarDeviceState mLastDeviceState;
    private final Object mLock;

    public DistinctElementSidecarCallback(@NonNull SidecarAdapter sidecarAdapter, @NonNull SidecarInterface.SidecarCallback sidecarCallback) {
        this.mLock = new Object();
        this.mActivityWindowLayoutInfo = new WeakHashMap();
        this.mAdapter = sidecarAdapter;
        this.mCallback = sidecarCallback;
    }

    public void onDeviceStateChanged(@NonNull SidecarDeviceState sidecarDeviceState) {
        if (sidecarDeviceState == null) {
            return;
        }
        synchronized (this.mLock) {
            try {
                if (this.mAdapter.isEqualSidecarDeviceState(this.mLastDeviceState, sidecarDeviceState)) {
                    return;
                }
                this.mLastDeviceState = sidecarDeviceState;
                this.mCallback.onDeviceStateChanged(sidecarDeviceState);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onWindowLayoutChanged(@NonNull IBinder iBinder, @NonNull SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
        synchronized (this.mLock) {
            try {
                if (this.mAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(iBinder), sidecarWindowLayoutInfo)) {
                    return;
                }
                this.mActivityWindowLayoutInfo.put(iBinder, sidecarWindowLayoutInfo);
                this.mCallback.onWindowLayoutChanged(iBinder, sidecarWindowLayoutInfo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @VisibleForTesting
    public DistinctElementSidecarCallback(@NonNull SidecarInterface.SidecarCallback sidecarCallback) {
        this.mLock = new Object();
        this.mActivityWindowLayoutInfo = new WeakHashMap();
        this.mAdapter = new SidecarAdapter();
        this.mCallback = sidecarCallback;
    }
}
