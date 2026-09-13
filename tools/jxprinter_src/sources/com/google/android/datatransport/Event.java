package com.google.android.datatransport;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class Event<T> {
    public static <T> Event<T> ofData(int i5, T t6, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.DEFAULT, productData, eventContext);
    }

    public static <T> Event<T> ofTelemetry(int i5, T t6, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.VERY_LOW, productData, eventContext);
    }

    public static <T> Event<T> ofUrgent(int i5, T t6, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.HIGHEST, productData, eventContext);
    }

    @Nullable
    public abstract Integer getCode();

    @Nullable
    public abstract EventContext getEventContext();

    public abstract T getPayload();

    public abstract Priority getPriority();

    @Nullable
    public abstract ProductData getProductData();

    public static <T> Event<T> ofData(int i5, T t6, @Nullable ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.DEFAULT, productData, null);
    }

    public static <T> Event<T> ofTelemetry(int i5, T t6, @Nullable ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.VERY_LOW, productData, null);
    }

    public static <T> Event<T> ofUrgent(int i5, T t6, @Nullable ProductData productData) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.HIGHEST, productData, null);
    }

    public static <T> Event<T> ofData(int i5, T t6, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.DEFAULT, null, eventContext);
    }

    public static <T> Event<T> ofTelemetry(int i5, T t6, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.VERY_LOW, null, eventContext);
    }

    public static <T> Event<T> ofUrgent(int i5, T t6, @Nullable EventContext eventContext) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.HIGHEST, null, eventContext);
    }

    public static <T> Event<T> ofData(int i5, T t6) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.DEFAULT, null, null);
    }

    public static <T> Event<T> ofTelemetry(int i5, T t6) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.VERY_LOW, null, null);
    }

    public static <T> Event<T> ofUrgent(int i5, T t6) {
        return new AutoValue_Event(Integer.valueOf(i5), t6, Priority.HIGHEST, null, null);
    }

    public static <T> Event<T> ofData(T t6, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(null, t6, Priority.DEFAULT, productData, eventContext);
    }

    public static <T> Event<T> ofTelemetry(T t6, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(null, t6, Priority.VERY_LOW, productData, eventContext);
    }

    public static <T> Event<T> ofUrgent(T t6, @Nullable ProductData productData, @Nullable EventContext eventContext) {
        return new AutoValue_Event(null, t6, Priority.HIGHEST, productData, eventContext);
    }

    public static <T> Event<T> ofData(T t6, @Nullable ProductData productData) {
        return new AutoValue_Event(null, t6, Priority.DEFAULT, productData, null);
    }

    public static <T> Event<T> ofTelemetry(T t6, @Nullable ProductData productData) {
        return new AutoValue_Event(null, t6, Priority.VERY_LOW, productData, null);
    }

    public static <T> Event<T> ofUrgent(T t6, @Nullable ProductData productData) {
        return new AutoValue_Event(null, t6, Priority.HIGHEST, productData, null);
    }

    public static <T> Event<T> ofData(T t6, @Nullable EventContext eventContext) {
        return new AutoValue_Event(null, t6, Priority.DEFAULT, null, eventContext);
    }

    public static <T> Event<T> ofTelemetry(T t6, @Nullable EventContext eventContext) {
        return new AutoValue_Event(null, t6, Priority.VERY_LOW, null, eventContext);
    }

    public static <T> Event<T> ofUrgent(T t6, @Nullable EventContext eventContext) {
        return new AutoValue_Event(null, t6, Priority.HIGHEST, null, eventContext);
    }

    public static <T> Event<T> ofData(T t6) {
        return new AutoValue_Event(null, t6, Priority.DEFAULT, null, null);
    }

    public static <T> Event<T> ofTelemetry(T t6) {
        return new AutoValue_Event(null, t6, Priority.VERY_LOW, null, null);
    }

    public static <T> Event<T> ofUrgent(T t6) {
        return new AutoValue_Event(null, t6, Priority.HIGHEST, null, null);
    }
}
