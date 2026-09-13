package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import com.google.android.apps.common.proguard.UsedByNative;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq;
import com.google.android.libraries.vision.visionkit.pipeline.zbbx;
import com.google.android.libraries.vision.visionkit.pipeline.zbcb;
import com.google.android.libraries.vision.visionkit.pipeline.zbcc;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class NativePipelineImpl implements zba {
    private zbtp zba;
    private zbbx zbb;
    private zbcc zbc;
    private zbcb zbd;

    public NativePipelineImpl(zbbx zbbxVar, zbcc zbccVar, zbcb zbcbVar, zbtp zbtpVar) {
        this.zbb = zbbxVar;
        this.zbc = zbccVar;
        this.zbd = zbcbVar;
        this.zba = zbtpVar;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native void close(long j6, long j7, long j8, long j9, long j10);

    @Keep
    @UsedByNative("pipeline_jni.cc")
    public void closeFileDescriptor(int i5) {
        this.zbd.zbc(i5);
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initialize(byte[] bArr, long j6, long j7, long j8, long j9, long j10);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeFrameBufferReleaseCallback(long j6);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeFrameManager();

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeIsolationCallback();

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native long initializeResultsCallback();

    @Keep
    @UsedByNative("pipeline_jni.cc")
    public void onReleaseAtTimestampUs(long j6) {
        this.zbb.zba(j6);
    }

    @Keep
    @UsedByNative("pipeline_jni.cc")
    public void onResult(byte[] bArr) {
        try {
            this.zbc.zbd(zbcz.zbd(bArr, this.zba));
        } catch (zbuq e) {
            zbcq.zba.zba(e, "Error in result from JNI layer", new Object[0]);
        }
    }

    @Keep
    @UsedByNative("pipeline_jni.cc")
    public int openFileDescriptor(String str) {
        this.zbd.zbb(str);
        return -1;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native byte[] process(long j6, long j7, long j8, byte[] bArr, int i5, int i6, int i7, int i8);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native byte[] processBitmap(long j6, long j7, Bitmap bitmap, int i5, int i6, int i7, int i8);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native byte[] processYuvFrame(long j6, long j7, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i5, int i6, int i7, int i8, int i9, int i10);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native void start(long j6);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native boolean stop(long j6);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public native void waitUntilIdle(long j6);

    @Override // com.google.android.libraries.vision.visionkit.pipeline.alt.zba
    public final void zba() {
        this.zba = null;
        this.zbb = null;
        this.zbc = null;
        this.zbd = null;
    }

    public NativePipelineImpl(String str, zbbx zbbxVar, zbcc zbccVar, zbcb zbcbVar, zbtp zbtpVar) {
        this(zbbxVar, zbccVar, zbcbVar, zbtpVar);
        System.loadLibrary("mlkit_google_ocr_pipeline");
    }
}
