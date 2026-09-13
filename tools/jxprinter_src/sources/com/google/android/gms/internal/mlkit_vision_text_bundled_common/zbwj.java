package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbwj {
    public static String zba(zbtc zbtcVar) {
        StringBuilder sb = new StringBuilder(zbtcVar.zbd());
        for (int i5 = 0; i5 < zbtcVar.zbd(); i5++) {
            byte bZba = zbtcVar.zba(i5);
            if (bZba == 34) {
                sb.append("\\\"");
            } else if (bZba == 39) {
                sb.append("\\'");
            } else if (bZba != 92) {
                switch (bZba) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (bZba < 32 || bZba > 126) {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((bZba >>> 6) & 3) + 48));
                            sb.append((char) (((bZba >>> 3) & 7) + 48));
                            sb.append((char) ((bZba & 7) + 48));
                        } else {
                            sb.append((char) bZba);
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
