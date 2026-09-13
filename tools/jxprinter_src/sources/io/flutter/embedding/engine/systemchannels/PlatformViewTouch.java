package io.flutter.embedding.engine.systemchannels;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class PlatformViewTouch {
    public final int action;
    public final int buttonState;
    public final int deviceId;

    @NonNull
    public final Number downTime;
    public final int edgeFlags;

    @NonNull
    public final Number eventTime;
    public final int flags;
    public final int metaState;
    public final long motionEventId;
    public final int pointerCount;

    @NonNull
    public final Object rawPointerCoords;

    @NonNull
    public final Object rawPointerPropertiesList;
    public final int source;
    public final int viewId;
    public final float xPrecision;
    public final float yPrecision;

    public PlatformViewTouch(int i5, @NonNull Number number, @NonNull Number number2, int i6, int i7, @NonNull Object obj, @NonNull Object obj2, int i8, int i9, float f6, float f7, int i10, int i11, int i12, int i13, long j6) {
        this.viewId = i5;
        this.downTime = number;
        this.eventTime = number2;
        this.action = i6;
        this.pointerCount = i7;
        this.rawPointerPropertiesList = obj;
        this.rawPointerCoords = obj2;
        this.metaState = i8;
        this.buttonState = i9;
        this.xPrecision = f6;
        this.yPrecision = f7;
        this.deviceId = i10;
        this.edgeFlags = i11;
        this.source = i12;
        this.flags = i13;
        this.motionEventId = j6;
    }
}
