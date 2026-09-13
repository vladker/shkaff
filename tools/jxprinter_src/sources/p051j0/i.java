package p051j0;

import S4.d;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.primitives.UnsignedBytes;
import com.library.base.frame.MvpActivity;
import com.orhanobut.hawk.Hawk;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.logging.log4j.util.Chars;
import p137y.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5400a = "";

    public static synchronized void a(String str, String str2, String str3) {
        String strSubstring = str.substring(2, 3);
        String strSubstring2 = str3.substring(4, 6);
        String strSubstring3 = str2.substring(1, 2);
        String strSubstring4 = str2.substring(4, 5);
        a.d("TAG", "开盖    " + strSubstring);
        a.d("TAG", "缺纸    " + strSubstring2);
        a.d("TAG", "过热    " + strSubstring3);
        a.d("TAG", "切刀    " + strSubstring4);
        boolean zEquals = "1".equals(strSubstring);
        boolean zEquals2 = "11".equals(strSubstring2);
        boolean zEquals3 = "1".equals(strSubstring4);
        boolean zEquals4 = "1".equals(strSubstring3);
        j jVar = new j();
        jVar.f9015a = zEquals;
        jVar.b = zEquals2;
        jVar.c = zEquals3;
        jVar.d = zEquals4;
        d.b().f(jVar);
        Hawk.put("LastDeviceState", jVar);
    }

    public static String b(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(str.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String c(Context context, Uri uri) {
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery == null) {
                return null;
            }
            try {
                int columnIndex = cursorQuery.getColumnIndex("_display_name");
                if (columnIndex == -1 || !cursorQuery.moveToFirst()) {
                    return null;
                }
                return cursorQuery.getString(columnIndex);
            } finally {
                cursorQuery.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f5400a);
        arrayList.add("HH:mm:ss");
        arrayList.add("HH:mm");
        arrayList.add("mm:ss");
        arrayList.add("H:m:s");
        arrayList.add("H:m");
        arrayList.add("HH-mm-ss");
        arrayList.add("H-m-s");
        arrayList.add("HH-mm");
        arrayList.add("H-m");
        arrayList.add("HH/mm/ss");
        arrayList.add("H/m/s");
        arrayList.add("HH/mm");
        arrayList.add("H/m");
        arrayList.add("hh:mm:ss am/pm");
        arrayList.add("hh:mm am/pm");
        arrayList.add("mm:ss am/pm");
        arrayList.add("h:m:s am/pm");
        arrayList.add("h:m am/pm");
        arrayList.add("hh-mm-ss am/pm");
        arrayList.add("h-m-s am/pm");
        arrayList.add("hh-mm am/pm");
        arrayList.add("h-m am/pm");
        arrayList.add("hh/mm/ss am/pm");
        arrayList.add("h/m/s am/pm");
        arrayList.add("hh/mm am/pm");
        arrayList.add("h/m am/pm");
        return arrayList;
    }

    public static ArrayList e() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f5400a);
        arrayList.add("HH:mm:ss");
        arrayList.add("HH:mm");
        arrayList.add("mm:ss");
        arrayList.add("H:m:s");
        arrayList.add("H:m");
        arrayList.add("HH-mm-ss");
        return arrayList;
    }

    public static ArrayList f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f5400a);
        arrayList.add("yyyy-MM-dd");
        arrayList.add("yyyy-MM");
        arrayList.add("MM-dd");
        arrayList.add("yyyy/MM/dd");
        arrayList.add("yyyy年MM月dd日");
        arrayList.add("yyyy/MM");
        arrayList.add("MM/dd");
        arrayList.add("yyyyMMdd");
        arrayList.add("yyMMdd");
        arrayList.add("dd");
        return arrayList;
    }

    public static ArrayList g() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(f5400a);
        arrayList.add("yyyy-MM-dd");
        arrayList.add("yyyy-MM");
        arrayList.add("MM-dd");
        arrayList.add("yyyy/MM/dd");
        arrayList.add("yyyy/MM");
        arrayList.add("MM/dd");
        arrayList.add("yyyyMMdd");
        arrayList.add("yyMMdd");
        arrayList.add("dd");
        arrayList.add("MMddyyyy");
        arrayList.add("MM/dd/yyyy");
        arrayList.add("MM-dd-yyyy");
        arrayList.add("MM.dd.yyyy");
        arrayList.add("MMddyy");
        arrayList.add("MM/dd/yy");
        arrayList.add("MM-dd-yy");
        arrayList.add("MM.dd.yy");
        arrayList.add("ddMMyyyy");
        arrayList.add("dd/MM/yyyy");
        arrayList.add("dd-MM-yyyy");
        arrayList.add("dd.MM.yyyy");
        arrayList.add("ddMMyy");
        arrayList.add("dd/MM/yy");
        arrayList.add("dd-MM-yy");
        arrayList.add("dd.MM.yy");
        return arrayList;
    }

    public static String h(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            sb.append(String.format("%4s", Integer.toBinaryString(Character.digit(str.charAt(i5), 16))).replace(Chars.SPACE, '0'));
        }
        return sb.toString();
    }

    public static String i(String str) {
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static String j(String str) {
        return i(str).trim();
    }

    public static byte[] k(Context context, Uri uri) {
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            byte[] bArr = new byte[inputStreamOpenInputStream.available()];
            inputStreamOpenInputStream.read(bArr);
            inputStreamOpenInputStream.close();
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void l(MvpActivity mvpActivity, Uri uri, File file) {
        try {
            file.getParentFile().mkdirs();
            InputStream inputStreamOpenInputStream = mvpActivity.getContentResolver().openInputStream(uri);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[8192];
            while (true) {
                int i5 = inputStreamOpenInputStream.read(bArr);
                if (i5 == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStreamOpenInputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, i5);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
