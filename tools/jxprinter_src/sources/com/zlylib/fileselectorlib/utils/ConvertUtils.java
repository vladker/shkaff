package com.zlylib.fileselectorlib.utils;

import android.R;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.collection.a;
import com.google.android.material.color.utilities.Contrast;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class ConvertUtils {
    public static final long GB = 1073741824;
    public static final long KB = 1024;
    public static final long MB = 1048576;

    private static String _queryPathFromMediaStore(Context context, Uri uri, String str, String[] strArr) {
        String string = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery == null) {
                return null;
            }
            int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("_data");
            cursorQuery.moveToFirst();
            string = cursorQuery.getString(columnIndexOrThrow);
            cursorQuery.close();
            return string;
        } catch (IllegalArgumentException e) {
            LogUtils.error(e);
            return string;
        }
    }

    public static <T> T[] toArray(List<T> list) {
        return (T[]) list.toArray();
    }

    public static String toBinaryString(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 8];
        int i5 = 0;
        for (int i6 : bArr) {
            if (i6 < 0) {
                i6 += 256;
            }
            cArr2[i5] = cArr[(i6 >>> 7) & 1];
            cArr2[i5 + 1] = cArr[(i6 >>> 6) & 1];
            cArr2[i5 + 2] = cArr[(i6 >>> 5) & 1];
            cArr2[i5 + 3] = cArr[(i6 >>> 4) & 1];
            cArr2[i5 + 4] = cArr[(i6 >>> 3) & 1];
            cArr2[i5 + 5] = cArr[(i6 >>> 2) & 1];
            int i7 = i5 + 7;
            cArr2[i5 + 6] = cArr[(i6 >>> 1) & 1];
            i5 += 8;
            cArr2[i7] = cArr[i6 & 1];
        }
        return new String(cArr2);
    }

    public static Bitmap toBitmap(byte[] bArr, int i5, int i6) {
        Bitmap bitmapDecodeByteArray = null;
        if (bArr.length != 0) {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inDither = false;
                options.inPreferredConfig = null;
                if (i5 > 0 && i6 > 0) {
                    options.outWidth = i5;
                    options.outHeight = i6;
                }
                bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                bitmapDecodeByteArray.setDensity(96);
                return bitmapDecodeByteArray;
            } catch (Exception e) {
                LogUtils.error(e);
            }
        }
        return bitmapDecodeByteArray;
    }

    public static byte[] toByteArray(int i5) {
        return ByteBuffer.allocate(4).putInt(i5).array();
    }

    public static ColorStateList toColorStateList(@ColorInt int i5, @ColorInt int i6, @ColorInt int i7, @ColorInt int i8) {
        return new ColorStateList(new int[][]{new int[]{R.attr.state_pressed, R.attr.state_enabled}, new int[]{R.attr.state_enabled, R.attr.state_focused}, new int[]{R.attr.state_enabled}, new int[]{R.attr.state_focused}, new int[]{R.attr.state_window_focused}, new int[0]}, new int[]{i6, i7, i5, i7, i8, i5});
    }

    public static String toColorString(@ColorInt int i5) {
        return toColorString(i5, false);
    }

    public static int toDarkenColor(@ColorInt int i5) {
        return toDarkenColor(i5, 0.8f);
    }

    public static int toDp(Context context, float f6) {
        int i5 = (int) ((f6 / context.getResources().getDisplayMetrics().density) + 0.5f);
        LogUtils.verbose(f6 + " px == " + i5 + " dp");
        return i5;
    }

    public static Drawable toDrawable(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(Resources.getSystem(), bitmap);
    }

    public static String toFileSizeString(long j6) {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (j6 < 1024) {
            return j6 + "B";
        }
        if (j6 < 1048576) {
            return decimalFormat.format(j6 / 1024.0d) + "K";
        }
        if (j6 < 1073741824) {
            return decimalFormat.format(j6 / 1048576.0d) + "M";
        }
        return decimalFormat.format(j6 / 1.073741824E9d) + "G";
    }

    public static float toFloat(Object obj) {
        try {
            return Float.parseFloat(obj.toString());
        } catch (NumberFormatException unused) {
            return -1.0f;
        }
    }

    public static String toGbk(String str) {
        try {
            return new String(str.getBytes("utf-8"), "gbk");
        } catch (UnsupportedEncodingException e) {
            LogUtils.warn(e);
            return str;
        }
    }

    public static String toHexString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : str.getBytes()) {
            sb.append(Integer.toHexString(b & UnsignedBytes.MAX_VALUE));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int toInt(Object obj) {
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static <T> List<T> toList(T[] tArr) {
        return Arrays.asList(tArr);
    }

    public static long toLong(Object obj) {
        try {
            return Long.parseLong(obj.toString());
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @TargetApi(19)
    public static String toPath(Context context, Uri uri) {
        if (uri == null) {
            LogUtils.verbose("uri is null");
            return "";
        }
        LogUtils.verbose("uri: " + uri.toString());
        String path = uri.getPath();
        String scheme = uri.getScheme();
        String authority = uri.getAuthority();
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] strArrSplit = documentId.split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            byte b = 0;
            String str = strArrSplit[0];
            authority.getClass();
            switch (authority.hashCode()) {
                case 320699453:
                    if (!authority.equals("com.android.providers.downloads.documents")) {
                        b = -1;
                    }
                    break;
                case 596745902:
                    b = !authority.equals("com.android.externalstorage.documents") ? (byte) -1 : (byte) 1;
                    break;
                case 1734583286:
                    b = !authority.equals("com.android.providers.media.documents") ? (byte) -1 : (byte) 2;
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    return _queryPathFromMediaStore(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), null, null);
                case 1:
                    if ("primary".equalsIgnoreCase(str)) {
                        return Environment.getExternalStorageDirectory() + PackagingURIHelper.FORWARD_SLASH_STRING + strArrSplit[1];
                    }
                    break;
                case 2:
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return _queryPathFromMediaStore(context, uri2, "_id=?", new String[]{strArrSplit[1]});
            }
        } else {
            if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(scheme)) {
                return authority.equals("com.google.android.apps.photos.content") ? uri.getLastPathSegment() : _queryPathFromMediaStore(context, uri, null, null);
            }
            if (Constants.FILE.equalsIgnoreCase(scheme)) {
                return uri.getPath();
            }
        }
        LogUtils.verbose("uri to path: " + path);
        return path;
    }

    public static int toPx(Context context, float f6) {
        int i5 = (int) ((context.getResources().getDisplayMetrics().density * f6) + 0.5f);
        LogUtils.verbose(f6 + " dp == " + i5 + " px");
        return i5;
    }

    public static int toShort(byte b, byte b6) {
        return (b << 8) + (b6 & UnsignedBytes.MAX_VALUE);
    }

    public static String toSlashString(String str) {
        String strN = "";
        for (char c : str.toCharArray()) {
            if (c == '\"' || c == '\'' || c == '\\') {
                strN = a.n(strN, "\\");
            }
            strN = strN + c;
        }
        return strN;
    }

    public static int toSp(Context context, float f6) {
        int i5 = (int) ((f6 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
        LogUtils.verbose(f6 + " px == " + i5 + " sp");
        return i5;
    }

    public static String toString(Object[] objArr) {
        return Arrays.deepToString(objArr);
    }

    public static byte[] toByteArray(String str, boolean z6) {
        if (str == null || str.equals("")) {
            return null;
        }
        if (!z6) {
            return str.getBytes();
        }
        String strReplaceAll = str.replaceAll("\\s+", "");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(strReplaceAll.length() / 2);
        for (int i5 = 0; i5 < strReplaceAll.length(); i5 += 2) {
            byteArrayOutputStream.write(("0123456789ABCDEF".indexOf(strReplaceAll.charAt(i5)) << 4) | "0123456789ABCDEF".indexOf(strReplaceAll.charAt(i5 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            LogUtils.warn(e);
            return byteArray;
        }
    }

    public static String toColorString(@ColorInt int i5, boolean z6) {
        String hexString = Integer.toHexString(Color.alpha(i5));
        String hexString2 = Integer.toHexString(Color.red(i5));
        String hexString3 = Integer.toHexString(Color.green(i5));
        String hexString4 = Integer.toHexString(Color.blue(i5));
        if (hexString.length() == 1) {
            hexString = "0".concat(hexString);
        }
        String str = hexString;
        if (hexString2.length() == 1) {
            hexString2 = "0".concat(hexString2);
        }
        String str2 = hexString2;
        if (hexString3.length() == 1) {
            hexString3 = "0".concat(hexString3);
        }
        String str3 = hexString3;
        if (hexString4.length() == 1) {
            hexString4 = "0".concat(hexString4);
        }
        String str4 = hexString4;
        if (z6) {
            String strA = androidx.exifinterface.media.a.A(str, str2, str3, str4);
            LogUtils.verbose(String.format(Locale.CHINA, "%d to color string is %s", Integer.valueOf(i5), strA));
            return strA;
        }
        String strO = a.o(str2, str3, str4);
        LogUtils.verbose(String.format(Locale.CHINA, "%d to color string is %s%s%s%s, exclude alpha is %s", Integer.valueOf(i5), str, str2, str3, str4, strO));
        return strO;
    }

    public static int toDarkenColor(@ColorInt int i5, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f6) {
        float[] fArr = new float[3];
        Color.colorToHSV(i5, fArr);
        fArr[2] = fArr[2] * f6;
        return Color.HSVToColor(fArr);
    }

    public static Drawable toDrawable(byte[] bArr) {
        return toDrawable(toBitmap(bArr));
    }

    public static int toInt(byte[] bArr) {
        int i5 = 0;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            i5 += (bArr[i6] & UnsignedBytes.MAX_VALUE) << (i6 * 8);
        }
        return i5;
    }

    public static String toString(Object[] objArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(obj);
            sb.append(str);
        }
        return sb.toString();
    }

    public static String toString(InputStream inputStream, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            LogUtils.error(e);
        }
        return sb.toString();
    }

    public static ColorStateList toColorStateList(@ColorInt int i5, @ColorInt int i6) {
        return toColorStateList(i5, i6, i6, i5);
    }

    public static String toHexString(byte... bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i5 = 0;
        for (int i6 : bArr) {
            if (i6 < 0) {
                i6 += 256;
            }
            int i7 = i5 + 1;
            cArr2[i5] = cArr[i6 >>> 4];
            i5 += 2;
            cArr2[i7] = cArr[i6 & 15];
        }
        return new String(cArr2);
    }

    public static Bitmap toBitmap(byte[] bArr) {
        return toBitmap(bArr, -1, -1);
    }

    public static Bitmap toBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        if (drawable instanceof ColorDrawable) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawColor(((ColorDrawable) drawable).getColor());
            return bitmapCreateBitmap;
        }
        if (!(drawable instanceof NinePatchDrawable)) {
            return null;
        }
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap2;
    }

    public static String toBinaryString(int i5) {
        String binaryString = Integer.toBinaryString(i5);
        LogUtils.verbose(String.format(Locale.CHINA, "%d to binary string is %s", Integer.valueOf(i5), binaryString));
        return binaryString;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[100];
            while (true) {
                int i5 = inputStream.read(bArr, 0, 100);
                if (i5 == -1) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i5);
            }
        } catch (IOException e) {
            LogUtils.warn(e);
            return null;
        }
    }

    public static String toString(InputStream inputStream) {
        return toString(inputStream, "utf-8");
    }

    public static String toHexString(int i5) {
        String hexString = Integer.toHexString(i5);
        LogUtils.verbose(String.format(Locale.CHINA, "%d to hex string is %s", Integer.valueOf(i5), hexString));
        return hexString;
    }

    public static byte[] toByteArray(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            LogUtils.warn(e);
            return byteArray;
        }
    }

    public static byte[] toByteArray(Drawable drawable) {
        return toByteArray(toBitmap(drawable));
    }
}
