package org.apache.commons.compress.harmony.archive.internal.nls;

import A3.AbstractC0157z;
import D4.a;
import java.security.AccessController;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Messages {
    private static ResourceBundle bundle;

    static {
        try {
            bundle = setLocale(Locale.getDefault(), "org.apache.commons.compress.harmony.archive.internal.nls.messages");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004c  */
    /* JADX WARN: Code duplicated, block: B:44:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0060 A[SYNTHETIC] */
    public static String format(String str, Object[] objArr) {
        byte bDigit;
        int i5;
        StringBuilder sb = new StringBuilder((objArr.length * 20) + str.length());
        int length = objArr.length;
        String[] strArr = new String[length];
        int length2 = 0;
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj == null) {
                strArr[i6] = "<null>";
            } else {
                strArr[i6] = obj.toString();
            }
        }
        while (true) {
            int iIndexOf = str.indexOf(123, length2);
            if (iIndexOf < 0) {
                break;
            }
            if (iIndexOf != 0) {
                int i7 = iIndexOf - 1;
                if (str.charAt(i7) == '\\') {
                    if (iIndexOf != 1) {
                        sb.append(str.substring(length2, i7));
                    }
                    sb.append('{');
                    i5 = iIndexOf + 1;
                } else if (iIndexOf > str.length() - 3) {
                    sb.append(str.substring(length2));
                    length2 = str.length();
                } else {
                    int i8 = iIndexOf + 1;
                    bDigit = (byte) Character.digit(str.charAt(i8), 10);
                    if (bDigit >= 0 || str.charAt(iIndexOf + 2) != '}') {
                        sb.append(str.substring(length2, i8));
                        length2 = i8;
                    } else {
                        sb.append(str.substring(length2, iIndexOf));
                        if (bDigit >= length) {
                            sb.append("<missing argument>");
                        } else {
                            sb.append(strArr[bDigit]);
                        }
                        i5 = iIndexOf + 3;
                    }
                }
                length2 = i5;
            } else if (iIndexOf > str.length() - 3) {
                sb.append(str.substring(length2));
                length2 = str.length();
            } else {
                int i9 = iIndexOf + 1;
                bDigit = (byte) Character.digit(str.charAt(i9), 10);
                if (bDigit >= 0) {
                }
                sb.append(str.substring(length2, i9));
                length2 = i9;
            }
        }
        if (length2 < str.length()) {
            sb.append(str.substring(length2));
        }
        return sb.toString();
    }

    public static String getString(String str) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return AbstractC0157z.n("Missing message: ", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$setLocale$0(String str, Locale locale, ClassLoader classLoader) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        return ResourceBundle.getBundle(str, locale, classLoader);
    }

    public static ResourceBundle setLocale(Locale locale, String str) {
        try {
            return (ResourceBundle) AccessController.doPrivileged(new a(str, locale, 0));
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public static String getString(String str, Object obj) {
        return getString(str, new Object[]{obj});
    }

    public static String getString(String str, int i5) {
        return getString(str, new Object[]{Integer.toString(i5)});
    }

    public static String getString(String str, char c) {
        return getString(str, new Object[]{String.valueOf(c)});
    }

    public static String getString(String str, Object obj, Object obj2) {
        return getString(str, new Object[]{obj, obj2});
    }

    public static String getString(String str, Object[] objArr) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return format(str, objArr);
    }
}
