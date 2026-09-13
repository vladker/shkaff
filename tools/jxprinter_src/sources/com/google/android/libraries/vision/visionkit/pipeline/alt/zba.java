package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
interface zba {
    void close(long j6, long j7, long j8, long j9, long j10);

    long initialize(byte[] bArr, long j6, long j7, long j8, long j9, long j10);

    long initializeFrameBufferReleaseCallback(long j6);

    long initializeFrameManager();

    long initializeIsolationCallback();

    long initializeResultsCallback();

    byte[] process(long j6, long j7, long j8, byte[] bArr, int i5, int i6, int i7, int i8);

    byte[] processBitmap(long j6, long j7, Bitmap bitmap, int i5, int i6, int i7, int i8);

    byte[] processYuvFrame(long j6, long j7, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i5, int i6, int i7, int i8, int i9, int i10);

    void start(long j6);

    boolean stop(long j6);

    void waitUntilIdle(long j6);

    void zba();
}
