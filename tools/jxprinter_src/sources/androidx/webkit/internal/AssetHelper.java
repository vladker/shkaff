package androidx.webkit.internal;

import android.content.Context;
import android.util.TypedValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class AssetHelper {
    public static final String DEFAULT_MIME_TYPE = "text/plain";
    private final Context mContext;

    public AssetHelper(Context context) {
        this.mContext = context;
    }

    public static String getCanonicalDirPath(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith(PackagingURIHelper.FORWARD_SLASH_STRING) ? canonicalPath.concat(PackagingURIHelper.FORWARD_SLASH_STRING) : canonicalPath;
    }

    public static File getCanonicalFileIfChild(File file, String str) throws IOException {
        String canonicalDirPath = getCanonicalDirPath(file);
        String canonicalPath = new File(file, str).getCanonicalPath();
        if (canonicalPath.startsWith(canonicalDirPath)) {
            return new File(canonicalPath);
        }
        return null;
    }

    public static File getDataDir(Context context) {
        return ApiHelperForN.getDataDir(context);
    }

    private int getFieldId(String str, String str2) {
        return this.mContext.getResources().getIdentifier(str2, str, this.mContext.getPackageName());
    }

    private int getValueType(int i5) {
        TypedValue typedValue = new TypedValue();
        this.mContext.getResources().getValue(i5, typedValue, true);
        return typedValue.type;
    }

    public static String guessMimeType(String str) {
        String mimeFromFileName = MimeUtil.getMimeFromFileName(str);
        return mimeFromFileName == null ? DEFAULT_MIME_TYPE : mimeFromFileName;
    }

    private static InputStream handleSvgzStream(String str, InputStream inputStream) {
        return str.endsWith(".svgz") ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static InputStream openFile(File file) {
        return handleSvgzStream(file.getPath(), new FileInputStream(file));
    }

    private static String removeLeadingSlash(String str) {
        return (str.length() <= 1 || str.charAt(0) != '/') ? str : str.substring(1);
    }

    public InputStream openAsset(String str) {
        String strRemoveLeadingSlash = removeLeadingSlash(str);
        return handleSvgzStream(strRemoveLeadingSlash, this.mContext.getAssets().open(strRemoveLeadingSlash, 2));
    }

    public InputStream openResource(String str) throws IOException {
        String strRemoveLeadingSlash = removeLeadingSlash(str);
        String[] strArrSplit = strRemoveLeadingSlash.split(PackagingURIHelper.FORWARD_SLASH_STRING, -1);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Incorrect resource path: ".concat(strRemoveLeadingSlash));
        }
        String str2 = strArrSplit[0];
        String strSubstring = strArrSplit[1];
        int iLastIndexOf = strSubstring.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = strSubstring.substring(0, iLastIndexOf);
        }
        int fieldId = getFieldId(str2, strSubstring);
        int valueType = getValueType(fieldId);
        if (valueType == 3) {
            return handleSvgzStream(strRemoveLeadingSlash, this.mContext.getResources().openRawResource(fieldId));
        }
        throw new IOException(String.format("Expected %s resource to be of TYPE_STRING but was %d", strRemoveLeadingSlash, Integer.valueOf(valueType)));
    }
}
