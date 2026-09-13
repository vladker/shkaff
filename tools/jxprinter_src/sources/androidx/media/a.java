package androidx.media;

import android.graphics.ImageDecoder;
import android.view.DisplayCutout;
import android.webkit.TracingConfig;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class a {
    public static /* bridge */ /* synthetic */ boolean A(Object obj) {
        return obj instanceof DisplayCutout;
    }

    public static /* bridge */ /* synthetic */ ImageDecoder.Source d(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    public static /* synthetic */ android.media.session.MediaSessionManager.RemoteUserInfo g(int i5, int i6, String str) {
        return new android.media.session.MediaSessionManager.RemoteUserInfo(str, i5, i6);
    }

    public static /* bridge */ /* synthetic */ DisplayCutout i(Object obj) {
        return (DisplayCutout) obj;
    }

    public static /* synthetic */ TracingConfig.Builder j() {
        return new TracingConfig.Builder();
    }
}
