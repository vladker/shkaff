package cn.fly.commons.c;

import android.content.Context;
import cn.fly.tools.FlyLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class q extends h {
    public q(Context context) {
        super(context);
    }

    private String a(Context context, Object obj, Method method) {
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return null;
        }
    }

    @Override // cn.fly.commons.c.h
    public h.b b() {
        Class<?> cls;
        Object objNewInstance;
        Method method = null;
        try {
            cls = Class.forName(cn.fly.commons.a.l.a("034d?elegemXef7edekelejedemejedemejeg(khPemffedhmekeleeejed;gVekffeg3kh"));
            try {
                objNewInstance = cls.newInstance();
            } catch (Throwable th) {
                th = th;
                FlyLog.getInstance().d(th);
                objNewInstance = null;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = null;
        }
        if (cls != null && objNewInstance != null) {
            try {
                method = cls.getMethod(cn.fly.commons.a.l.a("007Wfk@gj+higeffgm"), Context.class);
            } catch (Throwable th3) {
                FlyLog.getInstance().d(th3);
            }
        }
        h.b bVar = new h.b();
        bVar.f1362a = a(this.f1360a, objNewInstance, method);
        return bVar;
    }
}
