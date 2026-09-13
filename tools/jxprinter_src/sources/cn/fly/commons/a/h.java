package cn.fly.commons.a;

import cn.fly.FlySDK;
import cn.fly.commons.C0396r;
import cn.fly.commons.ae;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class h extends c {
    public h() {
        super(cn.fly.commons.n.a("003bee"), null, c.a(cn.fly.commons.n.a("003bee"), (Long) 0L));
    }

    private boolean n() {
        return cn.fly.commons.c.a(cn.fly.commons.n.a("003bee"));
    }

    private boolean o() {
        return cn.fly.commons.c.a(cn.fly.commons.n.a("002MbgTc"));
    }

    private boolean p() {
        return cn.fly.commons.c.a(cn.fly.commons.n.a("002BbeQc"));
    }

    @Override // cn.fly.commons.a.c
    public long b() {
        try {
            Calendar calendar = Calendar.getInstance();
            long timeInMillis = calendar.getTimeInMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            calendar.setTime(simpleDateFormat.parse(simpleDateFormat.format(new Date())));
            calendar.add(5, 1);
            long timeInMillis2 = (calendar.getTimeInMillis() - timeInMillis) + ((long) new SecureRandom().nextInt(240000));
            return (timeInMillis2 / 1000) + ((long) (timeInMillis2 % 1000 == 0 ? 0 : 1));
        } catch (Throwable th) {
            FlyLog.getInstance().d(th);
            return 0L;
        }
    }

    @Override // cn.fly.commons.a.c
    public boolean g() {
        return n() && h();
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        if (n()) {
            if (!o()) {
                p();
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = ((Long) a(cn.fly.commons.n.a("004bEdg3hb"), 2592000L)).longValue() * 1000;
            long jB = ae.b().b(ae.c, 0L);
            boolean zA = C0396r.a(jCurrentTimeMillis, jB);
            Object obj = this.f1211a;
            final boolean z6 = true;
            boolean z7 = obj != null && (obj instanceof Boolean) && ((Boolean) obj).booleanValue();
            if (jCurrentTimeMillis - jLongValue < jB && zA) {
                z6 = false;
            }
            if (z6 || z7) {
                DH.requester(FlySDK.getContext()).getIAForce(false, z7).request(new DH.DHResponder() { // from class: cn.fly.commons.a.h.1
                    @Override // cn.fly.tools.utils.DH.DHResponder
                    public void onResponse(DH.DHResponse dHResponse) {
                        ArrayList<HashMap<String, String>> iAForce = dHResponse.getIAForce(new int[0]);
                        if (iAForce == null || iAForce.isEmpty() || !z6) {
                            return;
                        }
                        h.this.a(iAForce);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<HashMap<String, String>> arrayList) {
        a(((Long) a(cn.fly.commons.n.a("004b+ba6ed"), 0L)).longValue(), "ALSAMT", arrayList);
        ae.b().a(ae.c, System.currentTimeMillis());
    }
}
