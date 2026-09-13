package p051j0;

import A3.AbstractC0157z;
import U1.b;
import U1.c;
import U1.d;
import U1.e;
import U1.i;
import androidx.webkit.ProxyConfig;
import com.orhanobut.hawk.Hawk;
import java.util.ArrayList;
import kotlin.jvm.internal.Y;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import p067m.k;
import p113u.g;
import p134x2.P0;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5394a = -1;

    public static b a(int i5, String str) {
        boolean z6;
        char cCharAt;
        if (str.trim().length() == 0) {
            return null;
        }
        d dVar = new d(1);
        d dVar2 = new d(1);
        int i6 = 0;
        boolean z7 = true;
        boolean z8 = false;
        boolean z9 = false;
        while (i6 < str.length()) {
            char cCharAt2 = str.charAt(i6);
            if (cCharAt2 != ' ' && cCharAt2 != '\t' && cCharAt2 != '\n') {
                if (z7) {
                    if (cCharAt2 == '(') {
                        if (z9) {
                            throw new c("Open bracket found after negate.", i6);
                        }
                        dVar2.c("(");
                    } else if (!z8 && (cCharAt2 == '+' || cCharAt2 == '-')) {
                        z8 = true;
                        if (cCharAt2 == '-') {
                            z9 = true;
                        }
                    } else if ((cCharAt2 >= '0' && cCharAt2 <= '9') || cCharAt2 == '.') {
                        int i7 = i6 + 1;
                        while (i7 < str.length()) {
                            char cCharAt3 = str.charAt(i7);
                            if ((cCharAt3 < '0' || cCharAt3 > '9') && cCharAt3 != '.') {
                                if (cCharAt3 != 'e' && cCharAt3 != 'E') {
                                    break;
                                }
                                int i8 = i7 + 1;
                                if (i8 < str.length()) {
                                    char cCharAt4 = str.charAt(i8);
                                    if (cCharAt4 != '+' && cCharAt4 != '-' && (cCharAt4 < '0' || cCharAt4 > '9')) {
                                        throw new c("Expected digit, plus sign or minus sign but found: " + String.valueOf(cCharAt4), i8 + i5);
                                    }
                                    i7 += 2;
                                } else {
                                    i7 = i8;
                                }
                                while (i7 < str.length() && (cCharAt = str.charAt(i7)) >= '0' && cCharAt <= '9') {
                                    i7++;
                                }
                                break;
                            }
                            i7++;
                        }
                        String strSubstring = str.substring(i6, i7);
                        try {
                            double d = Double.parseDouble(strSubstring);
                            if (z9) {
                                d = -d;
                            }
                            i iVar = new i();
                            iVar.b = d;
                            dVar.c(iVar);
                            i6 = i7 - 1;
                            z7 = false;
                            z8 = false;
                            z9 = false;
                        } catch (Throwable unused) {
                            throw new c(AbstractC0157z.n("Improperly formatted value: ", strSubstring), i6 + i5);
                        }
                    } else {
                        if (cCharAt2 == ',' || cCharAt2 == ')' || cCharAt2 == '^' || cCharAt2 == '*' || cCharAt2 == '/' || cCharAt2 == '+' || cCharAt2 == '-') {
                            throw new c("Unexpected character: " + String.valueOf(cCharAt2), i6 + i5);
                        }
                        int i9 = i6 + 1;
                        while (i9 < str.length() && (cCharAt2 = str.charAt(i9)) != ',' && cCharAt2 != ' ' && cCharAt2 != '\t' && cCharAt2 != '\n' && cCharAt2 != '(' && cCharAt2 != ')' && cCharAt2 != '^' && cCharAt2 != '*' && cCharAt2 != '/' && cCharAt2 != '+' && cCharAt2 != '-') {
                            i9++;
                        }
                        if (i9 < str.length()) {
                            int i10 = i9;
                            while (true) {
                                if ((cCharAt2 != ' ' && cCharAt2 != '\t' && cCharAt2 != '\n') || (i10 = i10 + 1) == str.length()) {
                                    break;
                                }
                                cCharAt2 = str.charAt(i10);
                            }
                            if (cCharAt2 == '(') {
                                e eVar = new e(str.substring(i6, i9), z9);
                                k kVar = new k();
                                z6 = false;
                                kVar.f6115a = 0;
                                kVar.b = new Object[1];
                                eVar.d = kVar;
                                eVar.e = new double[1];
                                int i11 = i10 + 1;
                                int i12 = 1;
                                while (i12 != 0) {
                                    int i13 = i10 + 1;
                                    if (i13 >= str.length()) {
                                        throw new c("Missing function close bracket.", i6 + i5);
                                    }
                                    char cCharAt5 = str.charAt(i13);
                                    if (cCharAt5 == ')') {
                                        i12--;
                                    } else if (cCharAt5 == '(') {
                                        i12++;
                                    } else if (cCharAt5 == ',' && i12 == 1) {
                                        b bVarA = a(i11, str.substring(i11, i13));
                                        if (bVarA == null) {
                                            throw new c("Incomplete function.", i11 + i5);
                                        }
                                        k kVar2 = eVar.d;
                                        int i14 = kVar2.f6115a;
                                        eVar.a(bVarA);
                                        int length = ((Object[]) kVar2.b).length;
                                        kVar2.d(i14, bVarA);
                                        int length2 = ((Object[]) kVar2.b).length;
                                        if (length != length2) {
                                            eVar.e = new double[length2];
                                        }
                                        bVarA.f707a = eVar;
                                        i11 = i10 + 2;
                                    }
                                    i10 = i13;
                                }
                                b bVarA2 = a(i11, str.substring(i11, i10));
                                if (bVarA2 != null) {
                                    k kVar3 = eVar.d;
                                    int i15 = kVar3.f6115a;
                                    eVar.a(bVarA2);
                                    int length3 = ((Object[]) kVar3.b).length;
                                    kVar3.d(i15, bVarA2);
                                    int length4 = ((Object[]) kVar3.b).length;
                                    if (length3 != length4) {
                                        eVar.e = new double[length4];
                                    }
                                    bVarA2.f707a = eVar;
                                } else if (eVar.d.f6115a > 0) {
                                    throw new c("Incomplete function.", i11 + i5);
                                }
                                dVar.c(eVar);
                            } else {
                                z6 = false;
                                dVar.c(new U1.k(str.substring(i6, i9), z9));
                                i10--;
                            }
                            i6 = i10;
                        } else {
                            z6 = false;
                            dVar.c(new U1.k(str.substring(i6, i9), z9));
                            i6 = i9 - 1;
                        }
                        z7 = z6;
                        z8 = z7;
                        z9 = z8;
                    }
                } else if (cCharAt2 == ')') {
                    d dVar3 = new d(1);
                    d dVar4 = new d(1);
                    while (true) {
                        if (dVar2.b == 0) {
                            throw new c("Missing open bracket.", i6 + i5);
                        }
                        Object objD = dVar2.d((W1.a) dVar2.c);
                        if (objD.equals("(")) {
                            dVar3.b(dVar.d((W1.a) dVar.c));
                            dVar.c(b(dVar3, dVar4));
                            break;
                        }
                        dVar3.b(dVar.d((W1.a) dVar.c));
                        dVar4.b(objD);
                    }
                } else {
                    if (cCharAt2 != '^' && cCharAt2 != '*' && cCharAt2 != '/' && cCharAt2 != '+' && cCharAt2 != '-') {
                        throw new c("Expected operator or close bracket but found: " + String.valueOf(cCharAt2), i6 + i5);
                    }
                    dVar2.c(String.valueOf(cCharAt2));
                    z7 = true;
                }
            }
            i6++;
        }
        if (dVar.b == dVar2.b + 1) {
            return b(dVar, dVar2);
        }
        throw new c("Incomplete expression.", str.length() + i5);
    }

    public static b b(d dVar, d dVar2) {
        Object obj;
        d dVar3 = new d(1);
        int i5 = 0;
        W1.a aVar = null;
        W1.a aVar2 = null;
        while (dVar2.b != 0) {
            Object objD = dVar2.d((W1.a) dVar2.d);
            Object objD2 = dVar.d((W1.a) dVar.d);
            Object objD3 = dVar.d((W1.a) dVar.d);
            if (objD.equals("^")) {
                dVar.b(new U1.a((b) objD2, (b) objD3, 3));
            } else {
                dVar.b(objD3);
                W1.a aVar3 = new W1.a();
                aVar3.f784a = null;
                aVar3.b = null;
                aVar3.c = objD;
                if (i5 == 0) {
                    aVar = aVar3;
                } else {
                    aVar3.f784a = aVar2;
                    aVar2.b = aVar3;
                }
                i5++;
                dVar3.c(objD2);
                aVar2 = aVar3;
            }
        }
        dVar3.c(dVar.d((W1.a) dVar.c));
        while (i5 != 0) {
            if (i5 == 0) {
                obj = null;
            } else {
                obj = aVar.c;
                if (aVar == aVar2) {
                    aVar2 = (W1.a) aVar2.f784a;
                    if (aVar2 == null) {
                        aVar = null;
                    } else {
                        aVar2.b = null;
                    }
                } else {
                    aVar = (W1.a) aVar.b;
                    aVar.f784a = null;
                }
                i5--;
            }
            Object objD4 = dVar3.d((W1.a) dVar3.d);
            Object objD5 = dVar3.d((W1.a) dVar3.d);
            if (obj.equals(ProxyConfig.MATCH_ALL_SCHEMES)) {
                dVar3.b(new U1.a((b) objD4, (b) objD5, 2));
            } else if (obj.equals(PackagingURIHelper.FORWARD_SLASH_STRING)) {
                dVar3.b(new U1.a((b) objD4, (b) objD5, 1));
            } else {
                dVar3.b(objD5);
                dVar2.c(obj);
                dVar.c(objD4);
            }
        }
        dVar.c(dVar3.d((W1.a) dVar3.c));
        while (dVar2.b != 0) {
            Object objD6 = dVar2.d((W1.a) dVar2.d);
            Object objD7 = dVar.d((W1.a) dVar.d);
            Object objD8 = dVar.d((W1.a) dVar.d);
            if (objD6.equals("+")) {
                dVar.b(new U1.a((b) objD7, (b) objD8, 0));
            } else {
                if (!objD6.equals(ProcessIdUtil.DEFAULT_PROCESSID)) {
                    throw new c(androidx.collection.a.l(objD6, "Unknown operator: "), -1);
                }
                dVar.b(new U1.a((b) objD7, (b) objD8, 4));
            }
        }
        return (b) dVar.d((W1.a) dVar.c);
    }

    public static void c(String str, String str2) {
        if (1 > f5394a) {
            p004a1.d.c(str).a().g(3, str2);
        }
    }

    public static void d(String str, String str2) {
        if (4 > f5394a) {
            p004a1.d.c(str).a().g(6, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String string;
        if (4 > f5394a) {
            xyz.doikki.videoplayer.player.k kVarA = p004a1.d.c(str).a();
            p004a1.b bVar = (p004a1.b) kVarA.b;
            if (6 < bVar.f918a) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str2 == null || str2.length() == 0) {
                string = "";
            } else {
                StringBuilder sbR = androidx.collection.a.r(str2);
                sbR.append(p057k1.c.f5473a);
                string = sbR.toString();
            }
            sb.append(string);
            sb.append(bVar.f923j.c(th));
            kVarA.i(6, sb.toString());
        }
    }

    public static ArrayList f() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("CODE_128");
        arrayList.add("CODE_39");
        arrayList.add("CODE_93");
        arrayList.add("EAN_8");
        arrayList.add("EAN_13");
        arrayList.add("UPC_A");
        arrayList.add("UPC_E");
        arrayList.add("ITF");
        arrayList.add("CODABAR");
        return arrayList;
    }

    public static String g(P0 p1) {
        String uid = p1.getUid();
        System.out.println(uid);
        if (!Y.f(uid)) {
            return uid;
        }
        o("print_info", "Empty UID detected, return empty string");
        return "";
    }

    public static synchronized P0 h() {
        try {
            try {
                Object obj = Hawk.get("print_info", null);
                if (obj == null || (obj instanceof P0)) {
                    return obj instanceof P0 ? (P0) obj : null;
                }
                String name = obj.getClass().getName();
                d("print_info", "Invalid cached print info type: ".concat(name));
                String strConcat = "invalid type: ".concat(name);
                try {
                    Hawk.delete("print_info");
                } catch (RuntimeException e) {
                    e("print_info", "Failed to delete invalid print info after " + strConcat, e);
                }
                return null;
            } catch (Exception e6) {
                e("print_info", "Failed to read cached print info", e6);
                try {
                    Hawk.delete("print_info");
                } catch (RuntimeException e7) {
                    e("print_info", "Failed to delete invalid print info after read failure", e7);
                }
                return null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static ArrayList i() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("QR_CODE");
        arrayList.add("DATA_MATRIX");
        arrayList.add("PDF_417");
        return arrayList;
    }

    public static ArrayList j() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("CODE_128");
        arrayList.add("CODE_39");
        arrayList.add("CODE_93");
        arrayList.add("EAN_8");
        arrayList.add("EAN_13");
        arrayList.add("UPC_A");
        return arrayList;
    }

    public static void k(String str, String str2) {
        if (2 > f5394a) {
            p004a1.d.c(str).a().g(4, str2);
        }
    }

    public static void l() {
        p042h2.d.show(g.toast_3);
    }

    public static void m() {
        Hawk.put("requestBluetoothPermissionsFailCount", 0);
    }

    public static synchronized void n(P0 p1) {
        k("print_info", "PrintInfoUtils:   " + p1.toString());
        Hawk.put("print_info", p1);
    }

    public static void o(String str, String str2) {
        if (3 > f5394a) {
            p004a1.d.c(str).a().g(5, str2);
        }
    }
}
