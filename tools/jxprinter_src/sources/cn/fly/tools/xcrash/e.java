package cn.fly.tools.xcrash;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class e {
    public static boolean a(String str) {
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
}
