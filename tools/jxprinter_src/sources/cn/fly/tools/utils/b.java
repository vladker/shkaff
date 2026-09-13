package cn.fly.tools.utils;

import cn.fly.FlySDK;
import cn.fly.commons.ae;
import cn.fly.commons.o;
import cn.fly.commons.z;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1954a = o.a("003Shcdkff");
    private static final String b = o.a("005+gcddddelGj");
    private static final String c = o.a("0093efdddddhMc=dffidhhf");
    private static final String d = o.a("013CdfdkffdhRc=dkdfdfdkHeZfidhhf");

    public static synchronized boolean a() {
        try {
            File file = new File(new File(FlySDK.getContext().getFilesDir(), f1954a), d);
            if (!file.exists() || file.length() <= 0) {
                return false;
            }
            File file2 = new File(FlySDK.getContext().getFilesDir(), b);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            FileUtils.copyFile(file, new File(file2, c));
            ae.b().a((ArrayList<String>) null);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized boolean b() {
        File file = new File(new File(FlySDK.getContext().getFilesDir(), o.a("007Bhcdkffgl7fFdjfi")), o.a("0082dfdkffdhdc'h8dhhf"));
        if (!file.exists() || file.length() <= 56320) {
            return false;
        }
        z.a().a(1);
        return true;
    }
}
