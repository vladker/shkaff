package R2;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static void closeSilently(@Nullable Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public static File getFromMediaUri(Context context, ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery;
        Throwable th;
        Cursor cursor = null;
        if (uri == null) {
            return null;
        }
        if (Constants.FILE.equals(uri.getScheme())) {
            return new File(uri.getPath());
        }
        if (FirebaseAnalytics.Param.CONTENT.equals(uri.getScheme())) {
            try {
                try {
                    cursorQuery = contentResolver.query(uri, new String[]{"_data", "_display_name"}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                int columnIndex = uri.toString().startsWith("content://com.google.android.gallery3d") ? cursorQuery.getColumnIndex("_display_name") : cursorQuery.getColumnIndex("_data");
                                if (columnIndex != -1) {
                                    String string = cursorQuery.getString(columnIndex);
                                    if (!TextUtils.isEmpty(string)) {
                                        File file = new File(string);
                                        cursorQuery.close();
                                        return file;
                                    }
                                }
                            }
                        } catch (IllegalArgumentException unused) {
                            cursor = cursorQuery;
                            File fromMediaUriPfd = getFromMediaUriPfd(context, contentResolver, uri);
                            if (cursor != null) {
                                cursor.close();
                            }
                            return fromMediaUriPfd;
                        } catch (SecurityException unused2) {
                            if (cursorQuery != null) {
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor = cursorQuery;
                            if (cursor == null) {
                                throw th;
                            }
                            cursor.close();
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IllegalArgumentException unused3) {
            } catch (SecurityException unused4) {
                cursorQuery = null;
            }
        }
        return null;
    }

    @Nullable
    private static File getFromMediaUriPfd(Context context, ContentResolver contentResolver, Uri uri) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (uri == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(contentResolver.openFileDescriptor(uri, "r").getFileDescriptor());
            try {
                String tempFilename = getTempFilename(context);
                fileOutputStream = new FileOutputStream(tempFilename);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i5 = fileInputStream.read(bArr);
                        if (i5 == -1) {
                            File file = new File(tempFilename);
                            closeSilently(fileInputStream);
                            closeSilently(fileOutputStream);
                            return file;
                        }
                        fileOutputStream.write(bArr, 0, i5);
                    }
                } catch (IOException unused) {
                    closeSilently(fileInputStream);
                    closeSilently(fileOutputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    closeSilently(fileInputStream2);
                    closeSilently(fileOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (IOException unused3) {
            fileOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    private static String getTempFilename(Context context) {
        return File.createTempFile("image", "tmp", context.getCacheDir()).getAbsolutePath();
    }
}
