package cn.fly.commons.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class b extends h {
    public b(Context context) {
        super(context);
    }

    @Override // cn.fly.commons.c.h
    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(cn.fly.commons.n.a("027a?bibdbjEa<bibi5ehbZbabjba6d<bbbg-ad2bgbadgbeQhh_bibh^g"), cn.fly.commons.n.a("043a]bibdbj>aAbibi8ehb^babjbaSd1bbbgDadJbgbadgbe$hhPbibhKgMbjdj>dSbbbgBad_ccbacjOdAbhbbbgIad")));
        return intent;
    }

    @Override // cn.fly.commons.c.h
    public h.b a(IBinder iBinder) {
        h.b bVar = new h.b();
        bVar.f1362a = a(cn.fly.commons.n.a("0044biHb:bgba"), iBinder, cn.fly.commons.n.a("044a2bibdbjVa;bibi<ehbJbabjba)d<bbbg.ad]bgbadgbe9hh;bibh8g3bjccdj3d=bbbgRadEccbafaTbcbLchXdKbh"), 2, this.b);
        return bVar;
    }
}
