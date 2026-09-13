package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import androidx.collection.a;
import io.flutter.Log;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorLogResult implements MethodChannel.Result {
    private int level;
    private String tag;

    public ErrorLogResult(String str) {
        this(str, Log.WARN);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void error(String str, @Nullable String str2, @Nullable Object obj) {
        String strL = obj != null ? a.l(obj, " details: ") : "";
        int i5 = this.level;
        if (i5 < Log.WARN) {
            return;
        }
        Log.println(i5, this.tag, str2 + strL);
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void notImplemented() {
        int i5 = this.level;
        if (i5 < Log.WARN) {
            return;
        }
        Log.println(i5, this.tag, "method not implemented");
    }

    public ErrorLogResult(String str, int i5) {
        this.tag = str;
        this.level = i5;
    }

    @Override // io.flutter.plugin.common.MethodChannel.Result
    public void success(@Nullable Object obj) {
    }
}
