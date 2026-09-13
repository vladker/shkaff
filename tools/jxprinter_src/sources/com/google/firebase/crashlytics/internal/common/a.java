package com.google.firebase.crashlytics.internal.common;

import android.app.ActivityManager;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.params.SessionConfiguration;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ ActivityManager.TaskDescription e(int i5, String str) {
        return new ActivityManager.TaskDescription(str, 0, i5);
    }

    public static /* synthetic */ SessionConfiguration j(List list, ExecutorService executorService, CameraCaptureSession.StateCallback stateCallback) {
        return new SessionConfiguration(0, list, executorService, stateCallback);
    }

    public static /* synthetic */ void l() {
    }
}
