package cn.fly;

import cn.fly.commons.ae;
import cn.fly.tools.proguard.PublicMemberKeeper;
import cn.fly.tools.utils.i;

/* JADX INFO: loaded from: classes.dex */
public class FlyStrategy implements PublicMemberKeeper {
    public static void setStrategy(final int i5) {
        new Thread(new i() { // from class: cn.fly.FlyStrategy.1
            @Override // cn.fly.tools.utils.i
            public void a() {
                ae.b().a(i5);
            }
        }).start();
    }
}
