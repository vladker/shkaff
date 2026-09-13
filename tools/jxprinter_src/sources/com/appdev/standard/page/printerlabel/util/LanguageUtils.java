package com.appdev.standard.page.printerlabel.util;

import android.content.Context;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class LanguageUtils {
    public static boolean isCJKLanguage(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String language = locale.getLanguage();
        return language.equals(Locale.CHINESE.getLanguage()) || language.equals("zh") || language.equals("ja") || language.equals("ko") || locale.equals(Locale.TRADITIONAL_CHINESE);
    }
}
