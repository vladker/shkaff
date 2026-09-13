package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import com.google.android.libraries.vision.visionkit.pipeline.zbbx;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbb implements zba {
    public zbb(zbbx zbbxVar) {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initialize(byte[] bArr, long j6, long j7, long j8, long j9, long j10) {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeFrameBufferReleaseCallback(long j6) {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeFrameManager() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeIsolationCallback() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final long initializeResultsCallback() {
        return 1L;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final byte[] process(long j6, long j7, long j8, byte[] bArr, int i5, int i6, int i7, int i8) {
        return zbcz.zbc().zbl();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final byte[] processBitmap(long j6, long j7, Bitmap bitmap, int i5, int i6, int i7, int i8) {
        return zbcz.zbc().zbl();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final byte[] processYuvFrame(long j6, long j7, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i5, int i6, int i7, int i8, int i9, int i10) {
        return zbcz.zbc().zbl();
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final boolean stop(long j6) {
        return true;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void zba() {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void start(long j6) {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void waitUntilIdle(long j6) {
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void close(long j6, long j7, long j8, long j9, long j10) {
    }
}
