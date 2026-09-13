package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import androidx.core.view.PointerIconCompat;
import com.google.android.gms.location.GeofenceStatusCodes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbaab implements zbuj {
    static final zbuj zba = new zbaab();

    private zbaab() {
    }

    @Override // com.google.android.gms.internal.mlkit_vision_text_bundled_common.zbuj
    public final boolean zba(int i5) {
        if (i5 == 3000 || i5 == 4000 || i5 == 5000 || i5 == 6000 || i5 == 6001 || i5 == 7000 || i5 == 7001) {
            return true;
        }
        switch (i5) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                switch (i5) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        return true;
                    default:
                        switch (i5) {
                            case 40:
                            case 41:
                            case 42:
                                return true;
                            default:
                                switch (i5) {
                                    case 1000:
                                    case 1001:
                                    case 1002:
                                    case PointerIconCompat.TYPE_HELP /* 1003 */:
                                    case 1004:
                                    case GeofenceStatusCodes.GEOFENCE_REQUEST_TOO_FREQUENT /* 1005 */:
                                    case PointerIconCompat.TYPE_CELL /* 1006 */:
                                    case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                                    case PointerIconCompat.TYPE_TEXT /* 1008 */:
                                    case PointerIconCompat.TYPE_VERTICAL_TEXT /* 1009 */:
                                    case PointerIconCompat.TYPE_ALIAS /* 1010 */:
                                    case PointerIconCompat.TYPE_COPY /* 1011 */:
                                    case PointerIconCompat.TYPE_NO_DROP /* 1012 */:
                                    case PointerIconCompat.TYPE_ALL_SCROLL /* 1013 */:
                                    case PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW /* 1014 */:
                                    case PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW /* 1015 */:
                                    case PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW /* 1016 */:
                                        return true;
                                    default:
                                        switch (i5) {
                                            case 2000:
                                            case 2001:
                                            case 2002:
                                            case 2003:
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }
}
