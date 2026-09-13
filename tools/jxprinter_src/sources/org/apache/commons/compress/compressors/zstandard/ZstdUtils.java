package org.apache.commons.compress.compressors.zstandard;

import com.google.common.base.Ascii;
import org.apache.commons.compress.utils.OsgiUtils;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class ZstdUtils {
    private static final byte[] ZSTANDARD_FRAME_MAGIC = {40, -75, 47, -3};
    private static final byte[] SKIPPABLE_FRAME_MAGIC = {RefErrorPtg.sid, 77, Ascii.CAN};
    private static volatile CachedAvailability cachedZstdAvailability = CachedAvailability.DONT_CACHE;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum CachedAvailability {
        DONT_CACHE,
        CACHED_AVAILABLE,
        CACHED_UNAVAILABLE
    }

    static {
        setCacheZstdAvailablity(!OsgiUtils.isRunningInOsgiEnvironment());
    }

    private ZstdUtils() {
    }

    public static CachedAvailability getCachedZstdAvailability() {
        return cachedZstdAvailability;
    }

    private static boolean internalIsZstdCompressionAvailable() {
        try {
            Class.forName("com.github.luben.zstd.ZstdInputStream");
            return true;
        } catch (Exception | NoClassDefFoundError unused) {
            return false;
        }
    }

    public static boolean isZstdCompressionAvailable() {
        CachedAvailability cachedAvailability = cachedZstdAvailability;
        if (cachedAvailability != CachedAvailability.DONT_CACHE) {
            return cachedAvailability == CachedAvailability.CACHED_AVAILABLE;
        }
        return internalIsZstdCompressionAvailable();
    }

    public static boolean matches(byte[] bArr, int i5) {
        if (i5 < ZSTANDARD_FRAME_MAGIC.length) {
            return false;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr2 = ZSTANDARD_FRAME_MAGIC;
            if (i6 >= bArr2.length) {
                return true;
            }
            if (bArr[i6] == bArr2[i6]) {
                i6++;
            } else {
                if (80 != (bArr[0] & 240)) {
                    return false;
                }
                int i7 = 0;
                while (true) {
                    byte[] bArr3 = SKIPPABLE_FRAME_MAGIC;
                    if (i7 >= bArr3.length) {
                        return true;
                    }
                    int i8 = i7 + 1;
                    if (bArr[i8] != bArr3[i7]) {
                        return false;
                    }
                    i7 = i8;
                }
            }
        }
    }

    public static void setCacheZstdAvailablity(boolean z6) {
        if (!z6) {
            cachedZstdAvailability = CachedAvailability.DONT_CACHE;
        } else if (cachedZstdAvailability == CachedAvailability.DONT_CACHE) {
            cachedZstdAvailability = internalIsZstdCompressionAvailable() ? CachedAvailability.CACHED_AVAILABLE : CachedAvailability.CACHED_UNAVAILABLE;
        }
    }
}
