package androidx.media;

import android.media.VolumeProvider;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class VolumeProviderCompatApi21 {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Delegate {
        void onAdjustVolume(int i5);

        void onSetVolumeTo(int i5);
    }

    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int i5, int i6, int i7, final Delegate delegate) {
        return new VolumeProvider(i5, i6, i7) { // from class: androidx.media.VolumeProviderCompatApi21.1
            @Override // android.media.VolumeProvider
            public void onAdjustVolume(int i8) {
                delegate.onAdjustVolume(i8);
            }

            @Override // android.media.VolumeProvider
            public void onSetVolumeTo(int i8) {
                delegate.onSetVolumeTo(i8);
            }
        };
    }

    public static void setCurrentVolume(Object obj, int i5) {
        ((VolumeProvider) obj).setCurrentVolume(i5);
    }
}
