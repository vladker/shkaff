package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class f0 implements p126w0.x {

    @VisibleForTesting
    static final int DEFAULT_FRAME_OPTION = 2;
    public static final p126w0.u d = p126w0.u.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new W());
    public static final p126w0.u e = p126w0.u.disk("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new X());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0 f3107f = new c0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List f3108g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f3109a;
    public final com.bumptech.glide.load.engine.bitmap_recycle.c b;
    public final c0 c;

    public f0(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, b0 b0Var) {
        this(cVar, b0Var, f3107f);
    }

    @RequiresApi(api = 23)
    public static p126w0.x byteBuffer(com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        return new f0(cVar, new a0());
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002a  */
    @Nullable
    private Bitmap decodeFrame(@NonNull Object obj, MediaMetadataRetriever mediaMetadataRetriever, long j6, int i5, int i6, int i7, r rVar) {
        Bitmap bitmap;
        if (isUnsupportedFormat(obj, mediaMetadataRetriever)) {
            throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
        }
        Bitmap bitmapDecodeScaledFrame = (Build.VERSION.SDK_INT < 27 || i6 == Integer.MIN_VALUE || i7 == Integer.MIN_VALUE || rVar == r.d) ? null : decodeScaledFrame(mediaMetadataRetriever, j6, i5, i6, i7, rVar);
        if (bitmapDecodeScaledFrame == null) {
            bitmapDecodeScaledFrame = mediaMetadataRetriever.getFrameAtTime(j6, i5);
        }
        if (isHdr180RotationFixRequired()) {
            try {
                if (!isHDR(mediaMetadataRetriever)) {
                    bitmap = bitmapDecodeScaledFrame;
                    bitmapDecodeScaledFrame = bitmap;
                } else if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) == 180) {
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmapDecodeScaledFrame.getWidth() / 2.0f, bitmapDecodeScaledFrame.getHeight() / 2.0f);
                    bitmapDecodeScaledFrame = Bitmap.createBitmap(bitmapDecodeScaledFrame, 0, 0, bitmapDecodeScaledFrame.getWidth(), bitmapDecodeScaledFrame.getHeight(), matrix, true);
                }
            } catch (NumberFormatException unused) {
                bitmap = bitmapDecodeScaledFrame;
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
                }
            }
        } else {
            bitmap = bitmapDecodeScaledFrame;
            bitmapDecodeScaledFrame = bitmap;
        }
        if (bitmapDecodeScaledFrame != null) {
            return bitmapDecodeScaledFrame;
        }
        throw new e0("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
    }

    @Nullable
    @TargetApi(27)
    private static Bitmap decodeScaledFrame(MediaMetadataRetriever mediaMetadataRetriever, long j6, int i5, int i6, int i7, r rVar) {
        try {
            int i8 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i9 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i10 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i10 == 90 || i10 == 270) {
                i9 = i8;
                i8 = i9;
            }
            float fB = rVar.b(i8, i9, i6, i7);
            return mediaMetadataRetriever.getScaledFrameAtTime(j6, i5, Math.round(i8 * fB), Math.round(fB * i9));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    @RequiresApi(30)
    private static boolean isHDR(MediaMetadataRetriever mediaMetadataRetriever) {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i5 = Integer.parseInt(strExtractMetadata);
        return (i5 == 7 || i5 == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    @VisibleForTesting
    public static boolean isHdr180RotationFixRequired() {
        if (!Build.MODEL.startsWith("Pixel") || Build.VERSION.SDK_INT != 33) {
            int i5 = Build.VERSION.SDK_INT;
            return i5 >= 30 && i5 < 33;
        }
        Iterator it = f3108g.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:23:0x0053, B:25:0x0059), top: B:40:0x0053 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0063 A[DONT_GENERATE] */
    private boolean isUnsupportedFormat(@NonNull Object obj, MediaMetadataRetriever mediaMetadataRetriever) {
        String str = Build.DEVICE;
        if (str == null || !str.matches(".+_cheets|cheets_.+")) {
            return false;
        }
        MediaExtractor mediaExtractor = null;
        try {
            try {
                if (!"video/webm".equals(mediaMetadataRetriever.extractMetadata(12))) {
                    return false;
                }
                MediaExtractor mediaExtractor2 = new MediaExtractor();
                try {
                    this.f3109a.initializeExtractor(mediaExtractor2, obj);
                    int trackCount = mediaExtractor2.getTrackCount();
                    for (int i5 = 0; i5 < trackCount; i5++) {
                        if ("video/x-vnd.on2.vp8".equals(mediaExtractor2.getTrackFormat(i5).getString("mime"))) {
                            mediaExtractor2.release();
                            return true;
                        }
                    }
                    mediaExtractor2.release();
                } catch (Throwable th) {
                    th = th;
                    mediaExtractor = mediaExtractor2;
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);
                    }
                }
                return false;
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to extract track info for a webm video on CrOS.", th);
                }
                return false;
            } finally {
                if (mediaExtractor != null) {
                    mediaExtractor.release();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p126w0.x
    public com.bumptech.glide.load.engine.O decode(@NonNull Object obj, int i5, int i6, @NonNull p126w0.v vVar) throws Exception {
        boolean zIsTerminated;
        boolean zIsTerminated2;
        long jLongValue = ((Long) vVar.get(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException(androidx.collection.a.j(jLongValue, "Requested frame must be non-negative, or DEFAULT_FRAME, given: "));
        }
        Integer num = (Integer) vVar.get(e);
        if (num == null) {
            num = 2;
        }
        r rVar = (r) vVar.get(r.f3117f);
        if (rVar == null) {
            rVar = r.e;
        }
        r rVar2 = rVar;
        this.c.getClass();
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        boolean z6 = false;
        try {
            this.f3109a.a(obj, mediaMetadataRetriever);
            Bitmap bitmapDecodeFrame = decodeFrame(obj, mediaMetadataRetriever, jLongValue, num.intValue(), i5, i6, rVar2);
            if (Build.VERSION.SDK_INT < 29) {
                mediaMetadataRetriever.release();
            } else if (mediaMetadataRetriever instanceof AutoCloseable) {
                mediaMetadataRetriever.close();
            } else if (mediaMetadataRetriever instanceof ExecutorService) {
                ExecutorService executorService = (ExecutorService) mediaMetadataRetriever;
                if (executorService != ForkJoinPool.commonPool() && !(zIsTerminated2 = executorService.isTerminated())) {
                    executorService.shutdown();
                    while (!zIsTerminated2) {
                        try {
                            zIsTerminated2 = executorService.awaitTermination(1L, TimeUnit.DAYS);
                        } catch (InterruptedException unused) {
                            if (!z6) {
                                executorService.shutdownNow();
                                z6 = true;
                            }
                        }
                    }
                    if (z6) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                mediaMetadataRetriever.release();
            }
            return C0510e.obtain(bitmapDecodeFrame, this.b);
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT < 29) {
                mediaMetadataRetriever.release();
            } else if (mediaMetadataRetriever instanceof AutoCloseable) {
                mediaMetadataRetriever.close();
            } else if (mediaMetadataRetriever instanceof ExecutorService) {
                ExecutorService executorService2 = (ExecutorService) mediaMetadataRetriever;
                if (executorService2 != ForkJoinPool.commonPool() && !(zIsTerminated = executorService2.isTerminated())) {
                    executorService2.shutdown();
                    while (!zIsTerminated) {
                        try {
                            zIsTerminated = executorService2.awaitTermination(1L, TimeUnit.DAYS);
                        } catch (InterruptedException unused2) {
                            if (!z6) {
                                executorService2.shutdownNow();
                                z6 = true;
                            }
                        }
                    }
                    if (z6) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    @Override // p126w0.x
    public boolean handles(@NonNull Object obj, @NonNull p126w0.v vVar) {
        return true;
    }

    @VisibleForTesting
    public f0(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, b0 b0Var, c0 c0Var) {
        this.b = cVar;
        this.f3109a = b0Var;
        this.c = c0Var;
    }
}
