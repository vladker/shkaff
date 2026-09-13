package androidx.profileinstaller;

import androidx.annotation.RestrictTo;
import java.util.Arrays;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ProfileVersion {
    public static final int MIN_SUPPORTED_SDK = 24;
    static final byte[] V015_S = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_DIR, 0};
    static final byte[] V010_P = {TarConstants.LF_NORMAL, TarConstants.LF_LINK, TarConstants.LF_NORMAL, 0};
    static final byte[] V009_O_MR1 = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, 57, 0};
    static final byte[] V005_O = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_DIR, 0};
    static final byte[] V001_N = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_LINK, 0};
    static final byte[] METADATA_V001_N = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_LINK, 0};
    static final byte[] METADATA_V002 = {TarConstants.LF_NORMAL, TarConstants.LF_NORMAL, TarConstants.LF_SYMLINK, 0};

    private ProfileVersion() {
    }

    public static String dexKeySeparator(byte[] bArr) {
        return (Arrays.equals(bArr, V001_N) || Arrays.equals(bArr, V005_O)) ? ParameterizedMessage.ERROR_MSG_SEPARATOR : "!";
    }
}
