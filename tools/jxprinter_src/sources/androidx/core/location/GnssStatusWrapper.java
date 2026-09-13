package androidx.core.location;

import android.location.GnssStatus;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY})
class GnssStatusWrapper extends GnssStatusCompat {
    private final GnssStatus mWrapped;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float getCarrierFrequencyHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.getCarrierFrequencyHz(i5);
        }

        public static boolean hasCarrierFrequencyHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.hasCarrierFrequencyHz(i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static float getBasebandCn0DbHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.getBasebandCn0DbHz(i5);
        }

        public static boolean hasBasebandCn0DbHz(GnssStatus gnssStatus, int i5) {
            return gnssStatus.hasBasebandCn0DbHz(i5);
        }
    }

    public GnssStatusWrapper(Object obj) {
        this.mWrapped = (GnssStatus) Preconditions.checkNotNull((GnssStatus) obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GnssStatusWrapper) {
            return this.mWrapped.equals(((GnssStatusWrapper) obj).mWrapped);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getAzimuthDegrees(int i5) {
        return this.mWrapped.getAzimuthDegrees(i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getBasebandCn0DbHz(int i5) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getBasebandCn0DbHz(this.mWrapped, i5);
        }
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCarrierFrequencyHz(int i5) {
        return Api26Impl.getCarrierFrequencyHz(this.mWrapped, i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getCn0DbHz(int i5) {
        return this.mWrapped.getCn0DbHz(i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getConstellationType(int i5) {
        return this.mWrapped.getConstellationType(i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public float getElevationDegrees(int i5) {
        return this.mWrapped.getElevationDegrees(i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSatelliteCount() {
        return this.mWrapped.getSatelliteCount();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public int getSvid(int i5) {
        return this.mWrapped.getSvid(i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasAlmanacData(int i5) {
        return this.mWrapped.hasAlmanacData(i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasBasebandCn0DbHz(int i5) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.hasBasebandCn0DbHz(this.mWrapped, i5);
        }
        return false;
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasCarrierFrequencyHz(int i5) {
        return Api26Impl.hasCarrierFrequencyHz(this.mWrapped, i5);
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean hasEphemerisData(int i5) {
        return this.mWrapped.hasEphemerisData(i5);
    }

    public int hashCode() {
        return this.mWrapped.hashCode();
    }

    @Override // androidx.core.location.GnssStatusCompat
    public boolean usedInFix(int i5) {
        return this.mWrapped.usedInFix(i5);
    }
}
