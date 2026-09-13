package cn.fly.commons.a;

import android.text.TextUtils;
import cn.fly.FlySDK;
import cn.fly.commons.ae;
import cn.fly.commons.x;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class i extends c {
    public i() {
        super(x.b("003<ehdbeh"), 0L, x.b("006;ehdbehdiZci"), 2592000L, c.a(x.b("003<ehdbeh"), (Long) 0L));
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        DH.requester(FlySDK.getContext()).getSA().request(new DH.DHResponder() { // from class: cn.fly.commons.a.i.1
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                HashMap<String, String> map;
                ArrayList<HashMap<String, String>> sa = dHResponse.getSA();
                if (sa == null || sa.isEmpty()) {
                    return;
                }
                long jB = ae.b().b(ae.d, 0L);
                long jB2 = i.this.b() * 1000;
                long jCurrentTimeMillis = System.currentTimeMillis();
                boolean z6 = jCurrentTimeMillis - jB2 >= jB;
                if (!z6) {
                    ArrayList<HashMap<String, String>> arrayListFromFile = ResHelper.readArrayListFromFile(cn.fly.commons.n.e, true);
                    int size = sa.size();
                    int i5 = 0;
                    loop0: while (i5 < size) {
                        HashMap<String, String> map2 = sa.get(i5);
                        i5++;
                        String str = map2.get(x.b("003i)dgdi"));
                        if (!TextUtils.isEmpty(str)) {
                            int size2 = arrayListFromFile.size();
                            int i6 = 0;
                            do {
                                if (i6 >= size2) {
                                    z6 = true;
                                    break loop0;
                                } else {
                                    map = arrayListFromFile.get(i6);
                                    i6++;
                                }
                            } while (!str.equals(map.get(x.b("003iFdgdi"))));
                        }
                    }
                }
                if (z6) {
                    i.this.a(0L, "SALMT", sa);
                    ResHelper.saveArrayListToFile(sa, cn.fly.commons.n.e, true);
                    ae.b().a(ae.d, jCurrentTimeMillis);
                }
            }
        });
    }
}
