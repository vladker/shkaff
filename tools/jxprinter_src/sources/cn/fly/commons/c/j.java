package cn.fly.commons.c;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class j extends h {
    public j(Context context) {
        super(context);
    }

    @Override // cn.fly.commons.c.h
    public Intent a() {
        Intent intent = new Intent();
        intent.setClassName(cn.fly.commons.o.a("023c7dkdfdlgddgdidldcSf,dddi?cf$didcfi=fGdjdddiRcf"), cn.fly.commons.o.a("039cQdkdfdlgddgdidldcEf[dddiAcf*didcfi<f.djdddi>cfEdlfl<fOdddi7cf+didcel6fTdjdddiYcf"));
        return intent;
    }

    @Override // cn.fly.commons.c.h
    public long c() {
        return 3000L;
    }

    @Override // cn.fly.commons.c.h
    public h.b a(IBinder iBinder) {
        String strA = cn.fly.commons.o.a("042cFdkdfdlgddgdidldcJf-dddiOcfCdidcfiWf8djdddiZcf9dleefl!f!dddi)cf didcee3eif'djefAdcf");
        h.b bVar = new h.b();
        bVar.f1362a = a(cn.fly.commons.o.a("004_dkAdUdidc"), iBinder, strA, 1, new String[0]);
        return bVar;
    }
}
