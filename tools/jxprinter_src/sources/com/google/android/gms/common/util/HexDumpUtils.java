package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.common.primitives.UnsignedBytes;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class HexDumpUtils {
    @Nullable
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i5, int i6, boolean z6) {
        int length;
        if (bArr == null || (length = bArr.length) == 0 || i5 < 0 || i6 <= 0 || i5 + i6 > length) {
            return null;
        }
        StringBuilder sb = new StringBuilder(((i6 + 15) / 16) * (z6 ? 75 : 57));
        int i7 = i6;
        int i8 = 0;
        int i9 = 0;
        while (i7 > 0) {
            if (i8 == 0) {
                if (i6 < 65536) {
                    sb.append(String.format("%04X:", Integer.valueOf(i5)));
                } else {
                    sb.append(String.format("%08X:", Integer.valueOf(i5)));
                }
                i9 = i5;
            } else if (i8 == 8) {
                sb.append(" -");
            }
            sb.append(String.format(" %02X", Integer.valueOf(bArr[i5] & UnsignedBytes.MAX_VALUE)));
            i7--;
            i8++;
            if (z6 && (i8 == 16 || i7 == 0)) {
                int i10 = 16 - i8;
                if (i10 > 0) {
                    for (int i11 = 0; i11 < i10; i11++) {
                        sb.append("   ");
                    }
                }
                if (i10 >= 8) {
                    sb.append("  ");
                }
                sb.append("  ");
                for (int i12 = 0; i12 < i8; i12++) {
                    char c = (char) bArr[i9 + i12];
                    if (c < ' ' || c > '~') {
                        c = '.';
                    }
                    sb.append(c);
                }
            }
            if (i8 == 16 || i7 == 0) {
                sb.append('\n');
                i8 = 0;
            }
            i5++;
        }
        return sb.toString();
    }
}
