package io.flutter.plugins.camera.media;

import W2.b;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugins.camera.types.CameraCaptureProperties;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ImageStreamReader {
    private static final String TAG = "ImageStreamReader";
    private final int dartImageFormat;

    @Nullable
    @VisibleForTesting(otherwise = 5)
    public Handler handler;
    private final ImageReader imageReader;
    private final ImageStreamReaderUtils imageStreamReaderUtils;
    private Map<String, Object> latestImageBufferHardReference;

    @VisibleForTesting
    public ImageStreamReader(@NonNull ImageReader imageReader, int i5, @NonNull ImageStreamReaderUtils imageStreamReaderUtils) {
        this.latestImageBufferHardReference = null;
        this.imageReader = imageReader;
        this.dartImageFormat = i5;
        this.imageStreamReaderUtils = imageStreamReaderUtils;
    }

    @VisibleForTesting
    public static int computeStreamImageFormat(int i5) {
        if (i5 == 17) {
            return 35;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onImageAvailable$0(EventChannel.EventSink eventSink, IllegalStateException illegalStateException) {
        eventSink.error("IllegalStateException", "Caught IllegalStateException: " + illegalStateException.getMessage(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$subscribeListener$1(CameraCaptureProperties cameraCaptureProperties, EventChannel.EventSink eventSink, ImageReader imageReader) {
        Image imageAcquireNextImage = imageReader.acquireNextImage();
        if (imageAcquireNextImage == null) {
            return;
        }
        onImageAvailable(imageAcquireNextImage, cameraCaptureProperties, eventSink);
    }

    public void close() {
        this.imageReader.close();
    }

    @NonNull
    public Surface getSurface() {
        return this.imageReader.getSurface();
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [io.flutter.plugins.camera.media.ImageStreamReader$1] */
    @VisibleForTesting
    public void onImageAvailable(@NonNull Image image, @NonNull CameraCaptureProperties cameraCaptureProperties, @NonNull final EventChannel.EventSink eventSink) {
        HashMap map = new HashMap();
        map.put("width", Integer.valueOf(image.getWidth()));
        map.put("height", Integer.valueOf(image.getHeight()));
        try {
            try {
                if (this.dartImageFormat == 17) {
                    map.put("planes", parsePlanesForNv21(image));
                } else {
                    map.put("planes", parsePlanesForYuvOrJpeg(image));
                }
            } catch (IllegalStateException e) {
                Handler handler = this.handler;
                if (handler == null) {
                    handler = new Handler(Looper.getMainLooper());
                }
                handler.post(new b(eventSink, e, 19));
            }
            image.close();
            map.put("format", Integer.valueOf(this.dartImageFormat));
            map.put("lensAperture", cameraCaptureProperties.getLastLensAperture());
            map.put("sensorExposureTime", cameraCaptureProperties.getLastSensorExposureTime());
            Integer lastSensorSensitivity = cameraCaptureProperties.getLastSensorSensitivity();
            map.put("sensorSensitivity", lastSensorSensitivity == null ? null : Double.valueOf(lastSensorSensitivity.intValue()));
            Handler handler2 = this.handler;
            if (handler2 == null) {
                handler2 = new Handler(Looper.getMainLooper());
            }
            this.latestImageBufferHardReference = map;
            handler2.post(new Runnable() { // from class: io.flutter.plugins.camera.media.ImageStreamReader.1

                @VisibleForTesting
                public WeakReference<Map<String, Object>> weakImageBuffer;

                @Override // java.lang.Runnable
                public void run() {
                    Map<String, Object> map2 = this.weakImageBuffer.get();
                    if (map2 == null) {
                        Log.d(ImageStreamReader.TAG, "Image buffer was dropped by garbage collector.");
                    } else {
                        eventSink.success(map2);
                    }
                }

                public Runnable withImageBuffer(Map<String, Object> map2) {
                    this.weakImageBuffer = new WeakReference<>(map2);
                    return this;
                }
            }.withImageBuffer(map));
        } catch (Throwable th) {
            image.close();
            throw th;
        }
    }

    @NonNull
    public List<Map<String, Object>> parsePlanesForNv21(@NonNull Image image) {
        ArrayList arrayList = new ArrayList();
        ByteBuffer byteBufferYuv420ThreePlanesToNV21 = this.imageStreamReaderUtils.yuv420ThreePlanesToNV21(image.getPlanes(), image.getWidth(), image.getHeight());
        HashMap map = new HashMap();
        map.put("bytesPerRow", Integer.valueOf(image.getWidth()));
        map.put("bytesPerPixel", 1);
        map.put("bytes", byteBufferYuv420ThreePlanesToNV21.array());
        arrayList.add(map);
        return arrayList;
    }

    @NonNull
    public List<Map<String, Object>> parsePlanesForYuvOrJpeg(@NonNull Image image) {
        ArrayList arrayList = new ArrayList();
        for (Image.Plane plane : image.getPlanes()) {
            ByteBuffer buffer = plane.getBuffer();
            int iRemaining = buffer.remaining();
            byte[] bArr = new byte[iRemaining];
            buffer.get(bArr, 0, iRemaining);
            HashMap map = new HashMap();
            map.put("bytesPerRow", Integer.valueOf(plane.getRowStride()));
            map.put("bytesPerPixel", Integer.valueOf(plane.getPixelStride()));
            map.put("bytes", bArr);
            arrayList.add(map);
        }
        return arrayList;
    }

    public void removeListener(@NonNull Handler handler) {
        this.imageReader.setOnImageAvailableListener(null, handler);
    }

    public void subscribeListener(@NonNull final CameraCaptureProperties cameraCaptureProperties, @NonNull final EventChannel.EventSink eventSink, @NonNull Handler handler) {
        this.imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.plugins.camera.media.a
            @Override // android.media.ImageReader.OnImageAvailableListener
            public final void onImageAvailable(ImageReader imageReader) {
                this.f4113a.lambda$subscribeListener$1(cameraCaptureProperties, eventSink, imageReader);
            }
        }, handler);
    }

    public ImageStreamReader(int i5, int i6, int i7, int i8) {
        this.latestImageBufferHardReference = null;
        this.dartImageFormat = i7;
        this.imageReader = ImageReader.newInstance(i5, i6, computeStreamImageFormat(i7), i8);
        this.imageStreamReaderUtils = new ImageStreamReaderUtils();
    }
}
