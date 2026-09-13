package cn.sharesdk.framework;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface PlatformActionListener {
    void onCancel(Platform platform, int i5);

    void onComplete(Platform platform, int i5, HashMap<String, Object> map);

    void onError(Platform platform, int i5, Throwable th);
}
