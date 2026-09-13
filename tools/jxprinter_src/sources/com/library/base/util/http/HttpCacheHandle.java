package com.library.base.util.http;

import android.content.Context;
import android.content.SharedPreferences;
import p051j0.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class HttpCacheHandle {
    private static final String TAG = "HttpCacheHandle";
    private static SharedPreferences preferences;

    public static String get(String str) {
        SharedPreferences sharedPreferences = preferences;
        if (sharedPreferences != null) {
            return sharedPreferences.getString(str, null);
        }
        a.d(TAG, "没有进行初始操作");
        return null;
    }

    public static void init(Context context) {
        preferences = context.getSharedPreferences("sanduHttp", 0);
    }

    public static void put(String str, String str2) {
        SharedPreferences sharedPreferences = preferences;
        if (sharedPreferences == null) {
            a.d(TAG, "没有进行初始操作");
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }
}
