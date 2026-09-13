package com.alibaba.android.arouter.thread;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class CancelableCountDownLatch extends CountDownLatch {
    public CancelableCountDownLatch(int i5) {
        super(i5);
    }

    public void cancel() {
        while (getCount() > 0) {
            countDown();
        }
    }
}
