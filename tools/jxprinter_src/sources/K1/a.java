package K1;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static void copy(InputStream inputStream, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i5 = inputStream.read(bArr);
                    if (i5 == -1) {
                        try {
                            inputStream.close();
                            return;
                        } finally {
                            fileOutputStream2.close();
                        }
                    }
                    fileOutputStream2.write(bArr, 0, i5);
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } finally {
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static File fileFromAsset(Context context, String str) throws Throwable {
        File file = new File(context.getCacheDir(), androidx.collection.a.n(str, "-pdfview.pdf"));
        if (str.contains(PackagingURIHelper.FORWARD_SLASH_STRING)) {
            file.getParentFile().mkdirs();
        }
        copy(context.getAssets().open(str), file);
        return file;
    }
}
