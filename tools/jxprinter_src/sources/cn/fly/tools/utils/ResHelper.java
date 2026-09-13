package cn.fly.tools.utils;

import A3.AbstractC0157z;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.CSCenter;
import cn.fly.commons.m;
import cn.fly.commons.z;
import cn.fly.tools.FlyLog;
import cn.fly.tools.proguard.PublicMemberKeeper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ResHelper implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f1936a;
    private static int b;
    private static Uri c;

    public static boolean checkAndCreateDir(String str) {
        File file = new File(str);
        try {
            if (file.exists()) {
                return file.isDirectory();
            }
            file.mkdirs();
            return file.exists() && file.isDirectory();
        } catch (Exception unused) {
            return false;
        }
    }

    public static void clearCache(Context context) {
        deleteFileAndFolder(new File(getCachePath(context, null)));
    }

    public static void closeIOs(Closeable... closeableArr) {
        C0396r.a(closeableArr);
    }

    public static boolean copyFile(String str, String str2) {
        FileOutputStream fileOutputStream;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    copyFile(fileInputStream2, fileOutputStream);
                    C0396r.a(fileInputStream2, fileOutputStream);
                    return true;
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    C0396r.a(fileInputStream, fileOutputStream);
                    return false;
                }
            } catch (Throwable unused2) {
                fileOutputStream = null;
            }
        } catch (Throwable unused3) {
            fileOutputStream = null;
        }
    }

    @Deprecated
    public static long dateStrToLong(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str, new ParsePosition(0)).getTime();
    }

    @Deprecated
    public static long dateToLong(String str) {
        try {
            Date date = new Date(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getTimeInMillis();
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return 0L;
        }
    }

    @Deprecated
    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length < 2 || strArrSplit[1] == null) {
                    bundle.putString(URLDecoder.decode(strArrSplit[0]), "");
                } else {
                    bundle.putString(URLDecoder.decode(strArrSplit[0]), URLDecoder.decode(strArrSplit[1]));
                }
            }
        }
        return bundle;
    }

    public static void deleteFileAndFolder(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            file.delete();
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                deleteFileAndFolder(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static int designToDevice(Context context, int i5, int i6) {
        if (b == 0) {
            int[] screenSize = getScreenSize(context);
            int i7 = screenSize[0];
            int i8 = screenSize[1];
            if (i7 >= i8) {
                i7 = i8;
            }
            b = i7;
        }
        return (int) (((i6 * b) / i5) + 0.5f);
    }

    public static int dipToPx(Context context, int i5) {
        if (f1936a <= 0.0f) {
            f1936a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i5 * f1936a) + 0.5f);
    }

    @Deprecated
    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z6 = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                obj = "";
            }
            if (z6) {
                z6 = false;
            } else {
                sb.append("&");
            }
            sb.append(Data.urlEncode(str) + "=" + Data.urlEncode(String.valueOf(obj)));
        }
        return sb.toString();
    }

    public static <T> T forceCast(Object obj) {
        return (T) forceCast(obj, null);
    }

    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        int resId = getResId(context, "drawable", str);
        return resId <= 0 ? getResId(context, "mipmap", str) : resId;
    }

    public static String getCachePath(Context context, String str) {
        String string = context.getFilesDir().getAbsolutePath() + m.a("001n") + "fvv" + m.a("007nefejhn");
        try {
            String sandboxPath = DH.SyncMtd.getSandboxPath();
            if (sandboxPath != null) {
                string = sandboxPath + m.a("001n") + "fvv" + m.a("001n") + DH.SyncMtd.getPackageName() + m.a("007nefejhn");
            }
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
        }
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sbX = AbstractC0157z.x(string, str);
            sbX.append(m.a("001n"));
            string = sbX.toString();
        }
        File file = new File(string);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return string;
    }

    public static String getCacheRoot(Context context) {
        return getCacheRoot(context, false);
    }

    public static File getCacheRootFile(Context context, String str) {
        try {
            String cacheRoot = getCacheRoot(context);
            if (cacheRoot == null) {
                return null;
            }
            File file = new File(cacheRoot, str);
            if (file.getParentFile().exists() && file.getParentFile().isDirectory()) {
                return file;
            }
            file.getParentFile().delete();
            file.getParentFile().mkdirs();
            return file;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static long getCaliSysTime() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (cn.fly.commons.c.b == 0 || cn.fly.commons.c.c == 0) {
            return jCurrentTimeMillis;
        }
        return (SystemClock.elapsedRealtime() - cn.fly.commons.c.c) + cn.fly.commons.c.b;
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, TypedValues.Custom.S_COLOR, str);
    }

    public static String getDataCache(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + m.a("001n") + "fvv";
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            return str;
        }
        file.delete();
        file.mkdirs();
        return str;
    }

    public static File getDataCacheFile(Context context, String str) {
        return getDataCacheFile(context, str, false);
    }

    public static float getDensity(Context context) {
        if (f1936a <= 0.0f) {
            f1936a = context.getResources().getDisplayMetrics().density;
        }
        return f1936a;
    }

    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static float[] getDensityXYDpi(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new float[]{displayMetrics.xdpi, displayMetrics.ydpi};
    }

    public static long getFLT() {
        return z.a().d();
    }

    @Deprecated
    public static long getFileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, m.a("002Efkfe"), str);
    }

    public static String getImageCachePath(Context context) {
        return getCachePath(context, "images");
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, m.a("006if2gefmfiJk"), str);
    }

    @Deprecated
    public static synchronized Uri getMediaUri(Context context, String str, String str2) {
        Uri uri;
        final Object obj = new Object();
        c = null;
        MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{str2}, new MediaScannerConnection.OnScanCompletedListener() { // from class: cn.fly.tools.utils.ResHelper.1
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str3, Uri uri2) {
                Uri unused = ResHelper.c = uri2;
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (c == null) {
                synchronized (obj) {
                    obj.wait(10000L);
                }
            }
        } catch (Throwable unused) {
        }
        uri = c;
        c = null;
        return uri;
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getResId(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return 0;
        }
        int identifier = context.getResources().getIdentifier(str2, str, packageName);
        if (identifier <= 0) {
            identifier = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
        }
        if (identifier <= 0) {
            FlyLog.getInstance().w(androidx.collection.a.p("failed to parse ", str, " resource \"", str2, "\""));
        }
        return identifier;
    }

    public static int getScreenHeight(Context context) {
        return getScreenSize(context)[1];
    }

    public static double getScreenInch(Context context) {
        try {
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            float[] densityXYDpi = getDensityXYDpi(context);
            if (densityXYDpi == null || densityXYDpi.length != 2) {
                return 0.0d;
            }
            double d = screenWidth / densityXYDpi[0];
            double d6 = screenHeight / densityXYDpi[1];
            return new BigDecimal(Math.sqrt((d6 * d6) + (d * d))).setScale(1, 4).doubleValue();
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return 0.0d;
        }
    }

    public static int getScreenPpi(Context context) {
        try {
            int screenWidth = getScreenWidth(context);
            int screenHeight = getScreenHeight(context);
            return (int) Math.round(Math.sqrt((screenHeight * screenHeight) + (screenWidth * screenWidth)) / getScreenInch(context));
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return 0;
        }
    }

    public static int[] getScreenSize(Context context) {
        int[] screenSize;
        WindowManager windowManager;
        int[] iArr;
        if (CSCenter.getInstance().isScreenInfoAvailable()) {
            Display defaultDisplay = null;
            try {
                windowManager = (WindowManager) DH.SyncMtd.getSystemServiceSafe("window");
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
                windowManager = null;
            }
            if (windowManager == null) {
                screenSize = new int[]{0, 0};
            } else {
                try {
                    defaultDisplay = windowManager.getDefaultDisplay();
                } catch (Throwable th2) {
                    FlyLog.getInstance().w(th2);
                }
                if (defaultDisplay == null) {
                    try {
                        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                        iArr = new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
                    } catch (Throwable th3) {
                        FlyLog.getInstance().w(th3);
                        screenSize = new int[]{0, 0};
                    }
                } else {
                    try {
                        Point point = new Point();
                        Method method = defaultDisplay.getClass().getMethod(m.a("011$glFhk]il0hfi.gnfkif(h"), Point.class);
                        method.setAccessible(true);
                        method.invoke(defaultDisplay, point);
                        iArr = new int[]{point.x, point.y};
                    } catch (Throwable th4) {
                        FlyLog.getInstance().w(th4);
                        screenSize = new int[]{0, 0};
                    }
                }
                screenSize = iArr;
            }
        } else {
            screenSize = CSCenter.getInstance().getScreenSize();
        }
        return a(screenSize);
    }

    public static int getScreenWidth(Context context) {
        return getScreenSize(context)[0];
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, TypedValues.Custom.S_STRING, str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, "style", str);
    }

    public static int[] getStyleableRes(Context context, String str) {
        try {
            Object staticField = ReflectHelper.getStaticField(ReflectHelper.importClass(context.getPackageName() + ".R$styleable"), str);
            if (staticField == null) {
                return new int[0];
            }
            return staticField.getClass().isArray() ? (int[]) staticField : new int[]{((Integer) staticField).intValue()};
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return new int[0];
        }
    }

    public static <T> boolean isEqual(T t6, T t7) {
        return !((t6 == null && t7 != null) || !(t6 == null || t6.equals(t7)));
    }

    @Deprecated
    public static int parseInt(String str) {
        return parseInt(str, 10);
    }

    @Deprecated
    public static long parseLong(String str) {
        return parseLong(str, 10);
    }

    @Deprecated
    public static Uri pathToContentUri(Context context, String str) {
        try {
            if (!DH.SyncMtd.checkPermission(m.a("040fgBfeflfmfkfefnPlh]flfhfkhkhkfkfmMg'fnilikhfhnfjikiiheikilgihfhgfjgnheijilhfkfik"))) {
                return null;
            }
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                if (!new File(str).exists()) {
                    return null;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", str);
                return context.getContentResolver().insert(uri, contentValues);
            }
            int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i5);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static int pxToDip(Context context, int i5) {
        if (f1936a <= 0.0f) {
            f1936a = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i5 / f1936a) + 0.5f);
    }

    public static ArrayList<HashMap<String, String>> readArrayListFromFile(String str) {
        return readArrayListFromFile(str, false);
    }

    public static byte[] readFromFileNoCompress(File file) {
        FileChannel channel;
        FileInputStream fileInputStream;
        if (file != null && file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    channel = fileInputStream.getChannel();
                    try {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
                        while (channel.read(byteBufferAllocate) > 0) {
                        }
                        byte[] bArrArray = byteBufferAllocate.array();
                        C0396r.a(channel, fileInputStream);
                        return bArrArray;
                    } catch (Throwable th) {
                        th = th;
                        try {
                            FlyLog.getInstance().d(th);
                            C0396r.a(channel, fileInputStream);
                            return null;
                        } catch (Throwable th2) {
                            C0396r.a(channel, fileInputStream);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    channel = null;
                }
            } catch (Throwable th4) {
                th = th4;
                channel = null;
                fileInputStream = null;
            }
        }
        return null;
    }

    public static Object readObjectFromFile(String str) {
        File file;
        GZIPInputStream gZIPInputStream;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        if (!TextUtils.isEmpty(str)) {
            try {
                file = new File(str);
                if (!file.exists()) {
                    file = null;
                }
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
            if (file != null) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        gZIPInputStream = new GZIPInputStream(fileInputStream);
                        try {
                            objectInputStream = new ObjectInputStream(gZIPInputStream);
                            try {
                                Object object = objectInputStream.readObject();
                                objectInputStream.close();
                                C0396r.a(objectInputStream, gZIPInputStream, fileInputStream);
                                return object;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    FlyLog.getInstance().d(th);
                                    C0396r.a(objectInputStream, gZIPInputStream, fileInputStream);
                                    return null;
                                } catch (Throwable th3) {
                                    C0396r.a(objectInputStream, gZIPInputStream, fileInputStream);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            objectInputStream = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        gZIPInputStream = null;
                        objectInputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    gZIPInputStream = null;
                    fileInputStream = null;
                    objectInputStream = null;
                }
            }
        }
        return null;
    }

    public static void saveArrayListToFile(ArrayList<HashMap<String, String>> arrayList, String str) {
        saveArrayListToFile(arrayList, str, false);
    }

    public static boolean saveObjectToFile(String str, Object obj) {
        File file;
        GZIPOutputStream gZIPOutputStream;
        ObjectOutputStream objectOutputStream;
        if (!TextUtils.isEmpty(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
                if (obj == null) {
                    return true;
                }
                if (!file.getParentFile().exists() || !file.getParentFile().isDirectory()) {
                    file.getParentFile().delete();
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
                file = null;
            }
            if (file != null) {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        gZIPOutputStream = new GZIPOutputStream(fileOutputStream2);
                        try {
                            objectOutputStream = new ObjectOutputStream(gZIPOutputStream);
                            try {
                                objectOutputStream.writeObject(obj);
                                objectOutputStream.flush();
                                objectOutputStream.close();
                                C0396r.a(objectOutputStream, gZIPOutputStream, fileOutputStream2);
                                return true;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    FlyLog.getInstance().d(th);
                                    C0396r.a(objectOutputStream, gZIPOutputStream, fileOutputStream);
                                    return false;
                                } catch (Throwable th3) {
                                    C0396r.a(objectOutputStream, gZIPOutputStream, fileOutputStream);
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            objectOutputStream = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        gZIPOutputStream = null;
                        objectOutputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    gZIPOutputStream = null;
                    objectOutputStream = null;
                }
            }
        }
        return false;
    }

    @Deprecated
    public static long strToDate(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0)).getTime();
    }

    @Deprecated
    public static Bundle urlToBundle(String str) {
        String str2;
        int iIndexOf = str.indexOf("://");
        if (iIndexOf >= 0) {
            str2 = m.a("007jkklmnn") + str.substring(iIndexOf + 1);
        } else {
            str2 = m.a("007jkklmnn") + str;
        }
        try {
            URL url = new URL(str2);
            Bundle bundleDecodeUrl = decodeUrl(url.getQuery());
            bundleDecodeUrl.putAll(decodeUrl(url.getRef()));
            return bundleDecodeUrl;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return new Bundle();
        }
    }

    @Deprecated
    public static Uri videoPathToContentUri(Context context, String str) {
        try {
            if (!DH.SyncMtd.checkPermission(m.a("040fgZfeflfmfkfefnNlh=flfhfkhkhkfkfmRg0fnilikhfhnfjikiiheikilgihfhgfjgnheijilhfkfik"))) {
                return null;
            }
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            Cursor cursorQuery = contentResolver.query(uri, new String[]{"_id"}, "_data=? ", new String[]{str}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                if (!new File(str).exists()) {
                    return null;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("_data", str);
                return context.getContentResolver().insert(uri, contentValues);
            }
            int i5 = cursorQuery.getInt(cursorQuery.getColumnIndex("_id"));
            return Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + i5);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return null;
        }
    }

    public static void writeToFileNoCompress(File file, byte[] bArr) {
        FileChannel fileChannel;
        if (file == null || bArr == null) {
            return;
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                FlyLog.getInstance().d(e);
            }
        }
        if (!file.exists()) {
            return;
        }
        FileChannel channel = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                channel = fileOutputStream.getChannel();
                channel.write(ByteBuffer.wrap(bArr));
                channel.force(true);
                C0396r.a(channel, fileOutputStream);
            } catch (Throwable th) {
                th = th;
                fileChannel = channel;
                channel = fileOutputStream;
                try {
                    FlyLog.getInstance().d(th);
                    C0396r.a(fileChannel, channel);
                } catch (Throwable th2) {
                    C0396r.a(fileChannel, channel);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    private static int[] a(int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return new int[]{0, 0};
        }
        int i5 = iArr[0];
        int i6 = iArr[1];
        return (i5 <= 0 || i6 <= 0) ? new int[]{0, 0} : new int[]{i5, i6};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T forceCast(Object obj, T t6) {
        if (obj != 0) {
            try {
                if (obj instanceof Integer) {
                    return t6 instanceof Long ? (T) Long.valueOf(((Integer) obj).intValue()) : obj;
                }
                return obj;
            } catch (Throwable unused) {
            }
        }
        return t6;
    }

    public static String getCacheRoot(Context context, boolean z6) {
        String dataCache;
        if (z6) {
            dataCache = null;
        } else {
            try {
                dataCache = getDataCache(context);
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
                return null;
            }
        }
        String sandboxPath = DH.SyncMtd.getSandboxPath();
        if (sandboxPath != null) {
            dataCache = sandboxPath + m.a("001n") + "fvv";
        }
        if (TextUtils.isEmpty(dataCache)) {
            return null;
        }
        File file = new File(dataCache);
        if (file.exists() && file.isDirectory()) {
            return dataCache;
        }
        file.delete();
        file.mkdirs();
        return dataCache;
    }

    public static File getDataCacheFile(Context context, String str, boolean z6) {
        File file = new File(getDataCache(context), str);
        if (z6 && !file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
                return file;
            } catch (Throwable th) {
                FlyLog.getInstance().d(th);
            }
        }
        return file;
    }

    @Deprecated
    public static int parseInt(String str, int i5) {
        return Integer.parseInt(str, i5);
    }

    @Deprecated
    public static long parseLong(String str, int i5) {
        return Long.parseLong(str, i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r13v11, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.io.Closeable[]] */
    public static ArrayList<HashMap<String, String>> readArrayListFromFile(String str, boolean z6) {
        GZIPInputStream gZIPInputStream;
        InputStreamReader inputStreamReader;
        ?? r10;
        ?? bufferedReader;
        File dataCacheFile = getDataCacheFile(FlySDK.getContext(), str, false);
        if (dataCacheFile.exists() && dataCacheFile.length() > 0) {
            FileInputStream fileInputStream = null;
            try {
                ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                FileInputStream fileInputStream2 = new FileInputStream(dataCacheFile);
                try {
                    gZIPInputStream = new GZIPInputStream(fileInputStream2);
                    try {
                        inputStreamReader = new InputStreamReader(gZIPInputStream, "utf-8");
                        try {
                            bufferedReader = new BufferedReader(inputStreamReader);
                            try {
                                String line = bufferedReader.readLine();
                                while (line != null) {
                                    if (z6) {
                                        line = new String(Base64.decode(line, 2), "utf-8");
                                    }
                                    arrayList.add(HashonHelper.fromJson(line));
                                    line = bufferedReader.readLine();
                                }
                                C0396r.a((Closeable[]) new Closeable[]{bufferedReader, inputStreamReader, gZIPInputStream, fileInputStream2});
                                return arrayList;
                            } catch (Throwable th) {
                                th = th;
                                fileInputStream = fileInputStream2;
                                r10 = bufferedReader;
                                try {
                                    FlyLog.getInstance().d(th);
                                    C0396r.a((Closeable[]) new Closeable[]{r10, inputStreamReader, gZIPInputStream, fileInputStream});
                                    return new ArrayList<>();
                                } catch (Throwable th2) {
                                    C0396r.a((Closeable[]) new Closeable[]{r10, inputStreamReader, gZIPInputStream, fileInputStream});
                                    throw th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = 0;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        inputStreamReader = null;
                        bufferedReader = inputStreamReader;
                        fileInputStream = fileInputStream2;
                        r10 = bufferedReader;
                        FlyLog.getInstance().d(th);
                        C0396r.a((Closeable[]) new Closeable[]{r10, inputStreamReader, gZIPInputStream, fileInputStream});
                        return new ArrayList<>();
                    }
                } catch (Throwable th5) {
                    th = th5;
                    gZIPInputStream = null;
                    inputStreamReader = null;
                }
            } catch (Throwable th6) {
                th = th6;
                gZIPInputStream = null;
                inputStreamReader = null;
                r10 = 0;
            }
        }
        return new ArrayList<>();
    }

    public static void saveArrayListToFile(ArrayList<HashMap<String, String>> arrayList, String str, boolean z6) {
        GZIPOutputStream gZIPOutputStream;
        OutputStreamWriter outputStreamWriter;
        Closeable closeable = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(getDataCacheFile(FlySDK.getContext(), str, true));
            try {
                gZIPOutputStream = new GZIPOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(gZIPOutputStream, "utf-8");
                    try {
                        int size = arrayList.size();
                        int i5 = 0;
                        while (i5 < size) {
                            HashMap<String, String> map = arrayList.get(i5);
                            i5++;
                            String strFromHashMap = HashonHelper.fromHashMap(map);
                            if (z6) {
                                strFromHashMap = new String(Base64.encode(strFromHashMap.getBytes("utf-8"), 2), "utf-8");
                            }
                            outputStreamWriter.append((CharSequence) strFromHashMap).append('\n');
                        }
                        C0396r.a(outputStreamWriter, gZIPOutputStream, fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        closeable = fileOutputStream;
                        try {
                            FlyLog.getInstance().d(th);
                            C0396r.a(outputStreamWriter, gZIPOutputStream, closeable);
                        } catch (Throwable th2) {
                            C0396r.a(outputStreamWriter, gZIPOutputStream, closeable);
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamWriter = null;
                }
            } catch (Throwable th4) {
                th = th4;
                gZIPOutputStream = null;
                outputStreamWriter = null;
            }
        } catch (Throwable th5) {
            th = th5;
            gZIPOutputStream = null;
            outputStreamWriter = null;
        }
    }

    @Deprecated
    public static long getFileSize(File file) {
        if (!file.exists()) {
            return 0L;
        }
        if (file.isDirectory()) {
            int fileSize = 0;
            for (String str : file.list()) {
                fileSize = (int) (getFileSize(new File(file, str)) + fileSize);
            }
            return fileSize;
        }
        return file.length();
    }

    public static int designToDevice(Context context, float f6, int i5) {
        if (f1936a <= 0.0f) {
            f1936a = context.getResources().getDisplayMetrics().density;
        }
        return (int) (((i5 * f1936a) / f6) + 0.5f);
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        byte[] bArr = new byte[65536];
        int i5 = fileInputStream.read(bArr);
        while (i5 > 0) {
            fileOutputStream.write(bArr, 0, i5);
            i5 = fileInputStream.read(bArr);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
