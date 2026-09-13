package cn.fly.commons.c;

import android.content.Context;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ReflectHelper;

/* JADX INFO: loaded from: classes.dex */
public class c extends h {
    public c(Context context) {
        super(context);
    }

    @Override // cn.fly.commons.c.h
    public h.b b() {
        Object objInvokeInstanceMethodNoThrow;
        h.b bVar = new h.b();
        Object systemServiceSafe = DH.SyncMtd.getSystemServiceSafe(cn.fly.commons.o.a("008<eh.f?ecejdgSdDdjdc"));
        if (systemServiceSafe != null && (objInvokeInstanceMethodNoThrow = ReflectHelper.invokeInstanceMethodNoThrow(systemServiceSafe, cn.fly.commons.o.a("010$dkffWid!di+eFgh4d;didc"), null, new Object[0])) != null) {
            bVar.f1362a = objInvokeInstanceMethodNoThrow.toString();
        }
        return bVar;
    }
}
