package cn.fly.commons.c;

import android.content.Context;
import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.ae;
import cn.fly.tools.utils.ResHelper;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1323a = cn.fly.commons.a.l.a("005Oemeggj2eCgj");

    public static synchronized HashMap<String, Object> a(Context context) {
        try {
            HashMap<String, Object> map = new HashMap<>();
            HashMap<String, Object> mapA = a();
            boolean z6 = mapA != null && mapA.size() > 0;
            if (z6) {
                HashMap map2 = new HashMap();
                if (mapA.containsKey(cn.fly.commons.a.l.a("004^ehedejed"))) {
                    mapA.put(cn.fly.commons.a.l.a("005e>ehedejed"), mapA.remove(cn.fly.commons.a.l.a("004Yehedejed")));
                }
                map2.putAll(mapA);
                map.put(cn.fly.commons.a.l.a("0095fgejedgjfe5edig"), map2);
            }
            String strAo = cn.fly.tools.b.c.a(context).d().ao();
            if (!z6 && TextUtils.isEmpty(strAo)) {
                return null;
            }
            map.put(cn.fly.commons.a.l.a("004FelEeUejed"), strAo);
            a(strAo);
            return map;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static String b(Context context) {
        return e.b(context);
    }

    private static HashMap<String, Object> a() {
        HashMap<String, Object> map;
        File file = new File(FlySDK.getContext().getFilesDir().getAbsolutePath() + cn.fly.commons.a.l.a("005m9idelggGm"), f1323a);
        if (file.exists()) {
            map = (HashMap) ResHelper.readObjectFromFile(file.getAbsolutePath());
            ae.b().b("all_ds", map);
            file.delete();
        } else {
            map = null;
        }
        return (map == null || map.isEmpty()) ? (HashMap) ae.b().c("all_ds", null) : map;
    }

    private static void a(String str) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put(cn.fly.commons.a.l.a("004Jel2e7ejed"), str);
        }
        ae.b().b("all_ds", map);
    }
}
