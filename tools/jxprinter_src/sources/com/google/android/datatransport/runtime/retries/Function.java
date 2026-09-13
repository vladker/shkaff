package com.google.android.datatransport.runtime.retries;

import java.lang.Throwable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public interface Function<TInput, TResult, TException extends Throwable> {
    TResult apply(TInput tinput);
}
