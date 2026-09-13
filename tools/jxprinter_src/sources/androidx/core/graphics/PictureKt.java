package androidx.core.graphics;

import O3.l;
import android.graphics.Picture;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class PictureKt {
    public static final Picture record(Picture picture, int i5, int i6, l lVar) {
        try {
            lVar.invoke(picture.beginRecording(i5, i6));
            return picture;
        } finally {
            picture.endRecording();
        }
    }
}
