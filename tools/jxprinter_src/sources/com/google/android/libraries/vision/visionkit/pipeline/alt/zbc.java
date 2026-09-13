package com.google.android.libraries.vision.visionkit.pipeline.alt;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbcq;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbki;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbtp;
import com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuq;
import com.google.android.libraries.vision.visionkit.pipeline.zbbe;
import com.google.android.libraries.vision.visionkit.pipeline.zbbf;
import com.google.android.libraries.vision.visionkit.pipeline.zbbx;
import com.google.android.libraries.vision.visionkit.pipeline.zbca;
import com.google.android.libraries.vision.visionkit.pipeline.zbcb;
import com.google.android.libraries.vision.visionkit.pipeline.zbcc;
import com.google.android.libraries.vision.visionkit.pipeline.zbcz;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class zbc implements zbbx, zbcc, zbcb {
    protected final zbtp zba;
    private final zbbf zbb;
    private final zba zbc;
    private long zbd;
    private final long zbe;
    private final long zbf;
    private final long zbg;
    private final long zbh;

    public zbc(zbca zbcaVar, String str) {
        zbtp zbtpVarZbb = zbtp.zbb();
        zbtp zbtpVarZba = zbtpVarZbb == null ? zbtp.zba() : zbtpVarZbb;
        if (zbcaVar.zbh()) {
            this.zbc = new zbb(this);
        } else if (zbcaVar.zbg()) {
            this.zbc = new NativePipelineImpl(this, this, this, zbtpVarZba);
        } else {
            this.zbc = new NativePipelineImpl("mlkit_google_ocr_pipeline", this, this, this, zbtpVarZba);
        }
        if (zbcaVar.zbi()) {
            this.zbb = new zbbf(zbcaVar.zba());
        } else {
            this.zbb = new zbbf(10);
        }
        this.zba = zbtpVarZba;
        long jInitializeFrameManager = this.zbc.initializeFrameManager();
        this.zbe = jInitializeFrameManager;
        long jInitializeFrameBufferReleaseCallback = this.zbc.initializeFrameBufferReleaseCallback(jInitializeFrameManager);
        this.zbf = jInitializeFrameBufferReleaseCallback;
        long jInitializeResultsCallback = this.zbc.initializeResultsCallback();
        this.zbg = jInitializeResultsCallback;
        long jInitializeIsolationCallback = this.zbc.initializeIsolationCallback();
        this.zbh = jInitializeIsolationCallback;
        this.zbd = this.zbc.initialize(zbcaVar.zbl(), jInitializeFrameBufferReleaseCallback, jInitializeResultsCallback, jInitializeIsolationCallback, 0L, 0L);
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbbx
    public final void zba(long j6) {
        this.zbb.zba(j6);
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbcb
    public final int zbb(String str) {
        Log.w("VKP", "openFileDescriptor called but is not available for this pipeline. Ignoring call.");
        return -1;
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbcb
    public final void zbc(int i5) {
        Log.w("VKP", "closeFileDescriptor called but is not available for this pipeline. Ignoring call.");
    }

    @Override // com.google.android.libraries.vision.visionkit.pipeline.zbcc
    public final void zbd(zbcz zbczVar) {
        zbcq.zba.zbb(this, "Pipeline received results: ".concat(String.valueOf(zbczVar)), new Object[0]);
    }

    public final zbki zbe(zbbe zbbeVar) {
        byte[] bArrProcess;
        if (this.zbd == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!this.zbb.zbb(zbbeVar, zbbeVar.zba()) || (bArrProcess = this.zbc.process(this.zbd, this.zbe, zbbeVar.zba(), zbbeVar.zbc(), zbbeVar.zbb().zbb(), zbbeVar.zbb().zba(), zbbeVar.zbd() - 1, zbbeVar.zbe() - 1)) == null) {
            return zbki.zbd();
        }
        try {
            return zbki.zbe(zbcz.zbd(bArrProcess, this.zba));
        } catch (zbuq e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    public final synchronized void zbf() {
        long j6 = this.zbd;
        if (j6 != 0) {
            this.zbc.stop(j6);
            this.zbc.close(this.zbd, this.zbe, this.zbf, this.zbg, this.zbh);
            this.zbd = 0L;
            this.zbc.zba();
        }
    }

    public final void zbg() throws PipelineException {
        long j6 = this.zbd;
        if (j6 == 0) {
            throw new PipelineException(zbd.FAILED_PRECONDITION.ordinal(), "Pipeline has been closed or was not initialized");
        }
        try {
            this.zbc.start(j6);
            this.zbc.waitUntilIdle(this.zbd);
        } catch (PipelineException e) {
            this.zbc.stop(this.zbd);
            throw e;
        }
    }

    public final void zbh() {
        long j6 = this.zbd;
        if (j6 == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!this.zbc.stop(j6)) {
            throw new IllegalStateException("Pipeline did not stop successfully.");
        }
    }

    public final zbki zbi(long j6, Bitmap bitmap, int i5) {
        if (this.zbd == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Unsupported bitmap config ".concat(String.valueOf(bitmap.getConfig())));
        }
        byte[] bArrProcessBitmap = this.zbc.processBitmap(this.zbd, j6, bitmap, bitmap.getWidth(), bitmap.getHeight(), 0, i5 - 1);
        if (bArrProcessBitmap == null) {
            return zbki.zbd();
        }
        try {
            return zbki.zbe(zbcz.zbd(bArrProcessBitmap, this.zba));
        } catch (zbuq e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    public final zbki zbj(long j6, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (this.zbd == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!byteBuffer.isDirect() || !byteBuffer2.isDirect() || !byteBuffer3.isDirect()) {
            throw new IllegalStateException("Byte buffers are not direct.");
        }
        byte[] bArrProcessYuvFrame = this.zbc.processYuvFrame(this.zbd, j6, byteBuffer, byteBuffer2, byteBuffer3, i5, i6, i7, i8, i9, i10 - 1);
        if (bArrProcessYuvFrame == null) {
            return zbki.zbd();
        }
        try {
            return zbki.zbe(zbcz.zbd(bArrProcessYuvFrame, this.zba));
        } catch (zbuq e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }
}
