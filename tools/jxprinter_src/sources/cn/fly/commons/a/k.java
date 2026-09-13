package cn.fly.commons.a;

import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Base64;
import cn.fly.FlySDK;
import cn.fly.commons.ae;
import cn.fly.tools.FlyLog;
import cn.fly.tools.utils.DH;
import cn.fly.tools.utils.Data;
import cn.fly.tools.utils.HashonHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class k extends c {
    private long b;
    private ArrayList<HashMap<String, String>> c;

    public k() {
        super(cn.fly.commons.n.a("002hb"), 0L, cn.fly.commons.n.a("004hb<dgbh"), 300L, c.a(cn.fly.commons.n.a("002hb"), (Long) 0L));
        this.b = 0L;
        this.c = null;
        this.b = ae.b().b(ae.b, -1L);
    }

    private boolean b(final String str) {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        DH.requester(FlySDK.getContext()).getMpfof(true, str, 0).request(new DH.DHResponder() { // from class: cn.fly.commons.a.k.2
            @Override // cn.fly.tools.utils.DH.DHResponder
            public void onResponse(DH.DHResponse dHResponse) {
                boolean z6 = false;
                Object mpfof = dHResponse.getMpfof(new int[0]);
                if (mpfof == null) {
                    atomicBoolean.set(false);
                    return;
                }
                ApplicationInfo applicationInfoA = cn.fly.tools.c.a(mpfof, str);
                if (applicationInfoA != null) {
                    int i5 = applicationInfoA.flags;
                    boolean z7 = (i5 & 1) == 0 && (i5 & 128) == 0;
                    boolean z8 = (i5 & 2097152) == 0;
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (z7 && z8) {
                        z6 = true;
                    }
                    atomicBoolean2.set(z6);
                }
            }
        });
        return atomicBoolean.get();
    }

    private byte[] c(ArrayList<HashMap<String, String>> arrayList) {
        new HashonHelper();
        String strFromObject = HashonHelper.fromObject(arrayList);
        try {
            return Data.AES128Encode(o(), strFromObject);
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return strFromObject.getBytes();
        }
    }

    private ArrayList<HashMap<String, String>> n() {
        ArrayList<HashMap<String, String>> arrayListP = p();
        if (arrayListP == null) {
            arrayListP = new ArrayList<>();
        }
        if (arrayListP.isEmpty()) {
            ae.b().a("key_rcdat", System.currentTimeMillis());
        }
        ArrayList<HashMap<String, String>> arrayList = this.c;
        if (arrayList == null || arrayList.isEmpty() || cn.fly.commons.c.f1293a) {
            cn.fly.commons.c.f1293a = false;
            DH.requester(FlySDK.getContext()).getIAForce(false, false).request(new DH.DHResponder() { // from class: cn.fly.commons.a.k.1
                @Override // cn.fly.tools.utils.DH.DHResponder
                public void onResponse(DH.DHResponse dHResponse) {
                    k.this.c = dHResponse.getIAForce(new int[0]);
                }
            });
        }
        ArrayList<HashMap<String, String>> arrayList2 = this.c;
        if (arrayList2 != null) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                HashMap<String, String> map = arrayList2.get(i5);
                String str = map != null ? map.get(cn.fly.commons.n.a("003hGcfch")) : null;
                if (!TextUtils.isEmpty(str) && b(str)) {
                    HashMap<String, String> mapB = b(arrayListP, str);
                    mapB.put(cn.fly.commons.n.a("003hTcfch"), str);
                    mapB.put(cn.fly.commons.n.a("004cb;bd^d"), map.get(cn.fly.commons.n.a("004cb;bd^d")));
                    mapB.put(cn.fly.commons.n.a("007SbbVdObhdgbgbi3c"), map.get(cn.fly.commons.n.a("007SbbVdObhdgbgbi3c")));
                    int i6 = mapB.get(cn.fly.commons.n.a("008@bhbe9cgVbgbd7dSdg")) == null ? 0 : Integer.parseInt(String.valueOf(mapB.get(cn.fly.commons.n.a("008@bhbe9cgVbgbd7dSdg"))));
                    mapB.put(cn.fly.commons.n.a("008Qbhbe=cgVbgbdHdWdg"), (b() + ((long) i6)) + "");
                    if (!a(arrayListP, str)) {
                        arrayListP.add(mapB);
                    }
                }
            }
        }
        return arrayListP;
    }

    private String o() {
        String model = DH.SyncMtd.getModel();
        return TextUtils.isEmpty(model) ? "sdfntdbdxjdsgsxv" : model;
    }

    private ArrayList<HashMap<String, String>> p() {
        String strB = ae.b().b("key_pamtb", (String) null);
        return a(TextUtils.isEmpty(strB) ? null : Base64.decode(strB, 2));
    }

    @Override // cn.fly.commons.a.c
    public void a() {
        ArrayList<HashMap<String, String>> arrayListN = n();
        b(arrayListN);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.b >= ((Long) a(cn.fly.commons.n.a("005hbRch)bh"), 3600L)).longValue() * 1000) {
            a(arrayListN);
        }
    }

    private HashMap<String, String> b(ArrayList<HashMap<String, String>> arrayList, String str) {
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            HashMap<String, String> map = arrayList.get(i5);
            i5++;
            HashMap<String, String> map2 = map;
            if (str.equals(map2.get(cn.fly.commons.n.a("003h@cfch")))) {
                return map2;
            }
        }
        return new HashMap<>();
    }

    private ArrayList<HashMap<String, String>> c(String str) {
        try {
            ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    arrayList.add(HashonHelper.fromJson(jSONArray.getJSONObject(i5).toString()));
                }
            }
            return arrayList;
        } catch (Throwable th) {
            FlyLog.getInstance().w(th);
            return new ArrayList<>();
        }
    }

    private void b(ArrayList<HashMap<String, String>> arrayList) {
        byte[] bArrC = c(arrayList);
        if (bArrC != null) {
            ae.b().a("key_pamtb", Base64.encodeToString(bArrC, 2));
        }
    }

    private boolean a(ArrayList<HashMap<String, String>> arrayList, String str) {
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            HashMap<String, String> map = arrayList.get(i5);
            i5++;
            if (str.equals(map.get(cn.fly.commons.n.a("003hDcfch")))) {
                return true;
            }
        }
        return false;
    }

    private void a(ArrayList<HashMap<String, String>> arrayList) {
        k kVar;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put(cn.fly.commons.n.a("008KbhFdaIbibhba4bg"), Long.valueOf(ae.b().b("key_rcdat", -1L)));
            kVar = this;
            try {
                kVar.a(0L, "PRTMT", arrayList, map, false);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            kVar = this;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ae.b().a(ae.b, jCurrentTimeMillis);
        ae.b().b("key_pamtb");
        kVar.b = jCurrentTimeMillis;
    }

    private ArrayList<HashMap<String, String>> a(byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    return c(Data.AES128PaddingDecode(o().getBytes("UTF-8"), bArr));
                }
            } catch (Throwable th) {
                FlyLog.getInstance().w(th);
                return new ArrayList<>();
            }
        }
        return new ArrayList<>();
    }
}
