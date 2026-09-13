package cn.fly.commons;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static o f1469a;
    private HashMap<String, Object> b;

    private o() {
        HashMap<String, Object> mapC = c();
        this.b = mapC;
        if (mapC == null) {
            this.b = new HashMap<>();
        }
        ArrayList<FlyProduct> arrayListB = ad.b();
        if (arrayListB == null || arrayListB.isEmpty()) {
            return;
        }
        int size = arrayListB.size();
        int i5 = 0;
        while (i5 < size) {
            FlyProduct flyProduct = arrayListB.get(i5);
            i5++;
            FlyProduct flyProduct2 = flyProduct;
            if (!this.b.containsKey(flyProduct2.getProductTag())) {
                this.b.put(flyProduct2.getProductTag(), 0);
            }
        }
    }

    public static o a() {
        if (f1469a == null) {
            synchronized (o.class) {
                try {
                    if (f1469a == null) {
                        f1469a = new o();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1469a;
    }

    private HashMap<String, Object> c() {
        try {
            return ae.b().g();
        } catch (Throwable unused) {
            return null;
        }
    }

    public HashMap<String, Object> b() {
        return this.b;
    }

    public void a(FlyProduct flyProduct, int i5) {
        if (flyProduct != null) {
            this.b.put(flyProduct.getProductTag(), Integer.valueOf(i5));
            a(this.b);
        }
    }

    private void a(HashMap<String, Object> map) {
        try {
            ae.b().a(map);
        } catch (Throwable unused) {
        }
    }

    public static String a(String str) {
        return C0396r.a(str, 99);
    }
}
