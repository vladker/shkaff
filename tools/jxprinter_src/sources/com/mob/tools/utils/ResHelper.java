package com.mob.tools.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mob.tools.network.KVPair;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ResHelper implements PublicMemberKeeper {
    public static void clearCache(Context context) {
        deleteFileAndFolder(new File(getCachePath(context, null)));
    }

    public static void closeIOs(Closeable... closeableArr) {
        com.mob.commons.a.a(closeableArr);
    }

    public static boolean copyFile(String str, String str2) {
        return cn.fly.tools.utils.ResHelper.copyFile(str, str2);
    }

    @Deprecated
    public static long dateStrToLong(String str) {
        return cn.fly.tools.utils.ResHelper.dateStrToLong(str);
    }

    @Deprecated
    public static long dateToLong(String str) {
        return cn.fly.tools.utils.ResHelper.dateToLong(str);
    }

    @Deprecated
    public static Bundle decodeUrl(String str) {
        return cn.fly.tools.utils.ResHelper.decodeUrl(str);
    }

    public static void deleteFileAndFolder(File file) {
        cn.fly.tools.utils.ResHelper.deleteFileAndFolder(file);
    }

    public static int designToDevice(Context context, int i5, int i6) {
        return cn.fly.tools.utils.ResHelper.designToDevice(context, i5, i6);
    }

    public static int dipToPx(Context context, int i5) {
        return cn.fly.tools.utils.ResHelper.dipToPx(context, i5);
    }

    @Deprecated
    public static String encodeUrl(Bundle bundle) {
        return cn.fly.tools.utils.ResHelper.encodeUrl(bundle);
    }

    public static <T> T forceCast(Object obj) {
        return (T) forceCast(obj, null);
    }

    public static int getAnimRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, "anim", str);
    }

    public static int getBitmapRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getBitmapRes(context, str);
    }

    public static String getCachePath(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getCachePath(context, str);
    }

    public static String getCacheRoot(Context context) {
        return getCacheRoot(context, false);
    }

    public static File getCacheRootFile(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getCacheRootFile(context, str);
    }

    public static long getCaliSysTime() {
        return cn.fly.tools.utils.ResHelper.getCaliSysTime();
    }

    public static int getColorRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, TypedValues.Custom.S_COLOR, str);
    }

    public static String getDataCache(Context context) {
        return cn.fly.tools.utils.ResHelper.getDataCache(context);
    }

    public static File getDataCacheFile(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getDataCacheFile(context, str);
    }

    public static float getDensity(Context context) {
        return cn.fly.tools.utils.ResHelper.getDensity(context);
    }

    public static int getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static float[] getDensityXYDpi(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return new float[]{displayMetrics.xdpi, displayMetrics.ydpi};
    }

    public static long getFLT() {
        return cn.fly.tools.utils.ResHelper.getFLT();
    }

    @Deprecated
    public static long getFileSize(String str) {
        return cn.fly.tools.utils.ResHelper.getFileSize(str);
    }

    public static int getIdRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, "id", str);
    }

    public static String getImageCachePath(Context context) {
        return getCachePath(context, "images");
    }

    public static int getLayoutRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, "layout", str);
    }

    @Deprecated
    public static synchronized Uri getMediaUri(Context context, String str, String str2) {
        return cn.fly.tools.utils.ResHelper.getMediaUri(context, str, str2);
    }

    public static int getRawRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, "raw", str);
    }

    public static int getResId(Context context, String str, String str2) {
        return cn.fly.tools.utils.ResHelper.getResId(context, str, str2);
    }

    public static int getScreenHeight(Context context) {
        return cn.fly.tools.utils.ResHelper.getScreenHeight(context);
    }

    public static double getScreenInch(Context context) {
        return cn.fly.tools.utils.ResHelper.getScreenInch(context);
    }

    public static int getScreenPpi(Context context) {
        return cn.fly.tools.utils.ResHelper.getScreenPpi(context);
    }

    public static int[] getScreenSize(Context context) {
        return cn.fly.tools.utils.ResHelper.getScreenSize(context);
    }

    public static int getScreenWidth(Context context) {
        return cn.fly.tools.utils.ResHelper.getScreenWidth(context);
    }

    public static int getStringArrayRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, "array", str);
    }

    public static int getStringRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, TypedValues.Custom.S_STRING, str);
    }

    public static int getStyleRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getResId(context, "style", str);
    }

    public static int[] getStyleableRes(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.getStyleableRes(context, str);
    }

    public static <T> boolean isEqual(T t6, T t7) {
        return !((t6 == null && t7 != null) || !(t6 == null || t6.equals(t7)));
    }

    @Deprecated
    public static int parseInt(String str) {
        return cn.fly.tools.utils.ResHelper.parseInt(str);
    }

    @Deprecated
    public static long parseLong(String str) {
        return parseLong(str, 10);
    }

    @Deprecated
    public static Uri pathToContentUri(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.pathToContentUri(context, str);
    }

    public static int pxToDip(Context context, int i5) {
        return cn.fly.tools.utils.ResHelper.pxToDip(context, i5);
    }

    public static ArrayList<HashMap<String, String>> readArrayListFromFile(String str) {
        return readArrayListFromFile(str, false);
    }

    public static byte[] readFromFileNoCompress(File file) {
        return cn.fly.tools.utils.ResHelper.readFromFileNoCompress(file);
    }

    public static Object readObjectFromFile(String str) {
        return cn.fly.tools.utils.ResHelper.readObjectFromFile(str);
    }

    public static void saveArrayListToFile(ArrayList<HashMap<String, String>> arrayList, String str) {
        saveArrayListToFile(arrayList, str, false);
    }

    public static boolean saveObjectToFile(String str, Object obj) {
        return cn.fly.tools.utils.ResHelper.saveObjectToFile(str, obj);
    }

    @Deprecated
    public static long strToDate(String str) {
        return cn.fly.tools.utils.ResHelper.strToDate(str);
    }

    @Deprecated
    public static Bundle urlToBundle(String str) {
        return cn.fly.tools.utils.ResHelper.urlToBundle(str);
    }

    @Deprecated
    public static Uri videoPathToContentUri(Context context, String str) {
        return cn.fly.tools.utils.ResHelper.videoPathToContentUri(context, str);
    }

    public static void writeToFileNoCompress(File file, byte[] bArr) {
        cn.fly.tools.utils.ResHelper.writeToFileNoCompress(file, bArr);
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        cn.fly.tools.utils.ResHelper.copyFile(fileInputStream, fileOutputStream);
    }

    public static int designToDevice(Context context, float f6, int i5) {
        return cn.fly.tools.utils.ResHelper.designToDevice(context, f6, i5);
    }

    @Deprecated
    public static String encodeUrl(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            KVPair<String> kVPair = arrayList.get(i6);
            i6++;
            KVPair<String> kVPair2 = kVPair;
            if (i5 > 0) {
                sb.append('&');
            }
            String str = kVPair2.name;
            String str2 = kVPair2.value;
            if (str != null) {
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(cn.fly.tools.utils.Data.urlEncode(str) + "=" + Data.urlEncode(str2));
                i5++;
            }
        }
        return sb.toString();
    }

    public static <T> T forceCast(Object obj, T t6) {
        return (T) cn.fly.tools.utils.ResHelper.forceCast(obj, t6);
    }

    public static String getCacheRoot(Context context, boolean z6) {
        return cn.fly.tools.utils.ResHelper.getCacheRoot(context, z6);
    }

    public static File getDataCacheFile(Context context, String str, boolean z6) {
        return cn.fly.tools.utils.ResHelper.getDataCacheFile(context, str, z6);
    }

    @Deprecated
    public static long getFileSize(File file) {
        return cn.fly.tools.utils.ResHelper.getFileSize(file);
    }

    @Deprecated
    public static int parseInt(String str, int i5) {
        return Integer.parseInt(str, i5);
    }

    @Deprecated
    public static long parseLong(String str, int i5) {
        return Long.parseLong(str, i5);
    }

    public static ArrayList<HashMap<String, String>> readArrayListFromFile(String str, boolean z6) {
        return cn.fly.tools.utils.ResHelper.readArrayListFromFile(str, z6);
    }

    public static void saveArrayListToFile(ArrayList<HashMap<String, String>> arrayList, String str, boolean z6) {
        cn.fly.tools.utils.ResHelper.saveArrayListToFile(arrayList, str, z6);
    }
}
