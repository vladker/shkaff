package cn.fly.commons.a;

import cn.fly.FlySDK;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    public b() {
        super(cn.fly.commons.n.a("002Cdddg"), 0L, cn.fly.commons.n.a("005?dddgch!bh"), 86400L, c.a(cn.fly.commons.n.a("002Cdddg"), (Long) 0L));
    }

    private void n() {
        DH.RequestBuilder cLoc = DH.requester(FlySDK.getContext()).getCarrierStrict(false).getCarrierNameStrict(false).getMnbclfo().getCLoc();
        final int oSVersionIntForFly = DH.SyncMtd.getOSVersionIntForFly();
        if (oSVersionIntForFly >= 17) {
            cLoc = cLoc.getACIfo();
        }
        cLoc.request(new DH.DHResponder() { // from class: cn.fly.commons.a.b.1
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                int i5;
                long j6;
                HashMap<String, Object> map;
                HashMap map2;
                int iIntValue;
                int i6;
                int i7;
                int iIntValue2;
                long jLongValue;
                long jLongValue2;
                int iIntValue3;
                int iIntValue4;
                HashMap<String, Object> map3;
                try {
                    i5 = Integer.parseInt(dHResponse.getCarrierStrict(new int[0]));
                } catch (Throwable unused) {
                    i5 = -1;
                }
                if (oSVersionIntForFly < 17 || dHResponse.getACIfo() == null || dHResponse.getACIfo().isEmpty()) {
                    j6 = -1;
                    map = null;
                    if (dHResponse.getCLoc() != null) {
                        map2 = (HashMap) dHResponse.getCLoc();
                        map2.put("dbm", -1);
                    } else {
                        map2 = null;
                    }
                } else {
                    ArrayList<HashMap<String, Object>> aCIfo = dHResponse.getACIfo();
                    map = new HashMap<>();
                    j6 = -1;
                    map.put("bsd", aCIfo);
                    HashMap<String, Object> map4 = aCIfo.get(0);
                    map2 = new HashMap();
                    if (((Integer) map4.get(cn.fly.commons.n.a("004gVca6hd"))).intValue() == 2) {
                        map2.put(cn.fly.commons.n.a("0163cbbabd(bYcbXdeeTdcbi)abg^bgbiHc"), 1);
                        map2.put(cn.fly.commons.n.a("003Sddbgba"), map4.get(cn.fly.commons.n.a("004adee")));
                        map2.put(cn.fly.commons.n.a("003Bdgbgba"), map4.get(cn.fly.commons.n.a("003Bdgbgba")));
                        map2.put(cn.fly.commons.n.a("003c bgba"), map4.get(cn.fly.commons.n.a("003c bgba")));
                        map2.put(cn.fly.commons.n.a("003ebg"), map4.get(cn.fly.commons.n.a("003ebg")));
                        map2.put(cn.fly.commons.n.a("003e=bi$c"), map4.get(cn.fly.commons.n.a("003e=bi$c")));
                    } else {
                        map2.put(cn.fly.commons.n.a("0167cbbabd2b>cb$dee@dcbi=abg.bgbiRc"), -1);
                        map2.put(cn.fly.commons.n.a("003h4dg-a"), map4.get(cn.fly.commons.n.a("003h4dg-a")));
                        map2.put(cn.fly.commons.n.a("003eba"), map4.get(cn.fly.commons.n.a("003eba")));
                        map2.put(cn.fly.commons.n.a("004adee"), map4.get(cn.fly.commons.n.a("004adee")));
                    }
                    map2.put("dbm", map4.get("dbm"));
                }
                if (map2 != null) {
                    if (((Integer) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("0168cbbabdCbHcb)dee]dcbiLabgMbgbi9c")), -1)).intValue() == 1) {
                        int iIntValue5 = ((Integer) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("003ebg")), -1)).intValue();
                        int iIntValue6 = ((Integer) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("003e;bi@c")), -1)).intValue();
                        i7 = iIntValue6;
                        jLongValue2 = j6;
                        jLongValue = ((Long) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("003Nddbgba")), -1L)).longValue();
                        iIntValue3 = ((Integer) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("003Qdgbgba")), -1)).intValue();
                        i6 = iIntValue5;
                        iIntValue = -1;
                        iIntValue4 = ((Integer) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("003c3bgba")), -1)).intValue();
                        iIntValue2 = -1;
                    } else {
                        iIntValue = ((Integer) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("003h]dgYa")), -1)).intValue();
                        i6 = -1;
                        i7 = -1;
                        iIntValue2 = ((Integer) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("003eba")), -1)).intValue();
                        jLongValue = j6;
                        jLongValue2 = ((Long) ResHelper.forceCast(map2.get(cn.fly.commons.n.a("004adee")), -1L)).longValue();
                        iIntValue3 = -1;
                        iIntValue4 = -1;
                    }
                    if (i5 != -1 && iIntValue2 != -1 && jLongValue2 != j6) {
                        if (map == 0) {
                            map = new HashMap<>();
                        }
                        HashMap<String, Object> map5 = map;
                        map5.put(cn.fly.commons.n.a("003eba"), Integer.valueOf(iIntValue2));
                        map5.put(cn.fly.commons.n.a("004adee"), Long.valueOf(jLongValue2));
                        if (iIntValue != -1) {
                            map5.put(cn.fly.commons.n.a("003h_dg)a"), Integer.valueOf(iIntValue));
                        }
                        map = map5;
                    }
                    if (i5 == -1 || jLongValue == j6 || iIntValue3 == -1 || iIntValue4 == -1) {
                        map3 = map;
                    } else {
                        if (map == null) {
                            map = new HashMap<>();
                        }
                        map3 = map;
                        map3.put(cn.fly.commons.n.a("0037ddbgba"), Long.valueOf(jLongValue));
                        map3.put(cn.fly.commons.n.a("0030dgbgba"), Integer.valueOf(iIntValue3));
                        map3.put(cn.fly.commons.n.a("003c!bgba"), Integer.valueOf(iIntValue4));
                        if (i6 != -1) {
                            map3.put(cn.fly.commons.n.a("003ebg"), Integer.valueOf(i6));
                        }
                        if (i7 != -1) {
                            map3.put(cn.fly.commons.n.a("003e@biTc"), Integer.valueOf(i7));
                        }
                    }
                    Integer num = (Integer) ResHelper.forceCast(map2.get("dbm"), -1);
                    num.intValue();
                    map3.put("dbm", num);
                    map3.put(cn.fly.commons.n.a("007abJbhbhbgGdGbh"), Integer.valueOf(i5));
                    map3.put(cn.fly.commons.n.a("009-dgbgbdbi?hcb)bdHd"), dHResponse.getCarrierNameStrict(new int[0]));
                    ArrayList<HashMap<String, Object>> mnbclfo = dHResponse.getMnbclfo();
                    if (mnbclfo != null && mnbclfo.size() > 0) {
                        map3.put(cn.fly.commons.n.a("006cdb4bhddca"), mnbclfo);
                    }
                    b.this.a("BSIOMT", map3, true);
                }
            }
        });
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        n();
    }
}
