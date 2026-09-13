package cn.fly.commons.cc;

import com.google.common.net.HttpHeaders;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;

/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final HashMap<String, Class<?>> f1384a = new HashMap<>();
    private final ArrayList<y> b;
    private final ArrayList<Object> c;

    public w(ArrayList<y> arrayList, ArrayList<Object> arrayList2) {
        this.b = arrayList;
        this.c = arrayList2;
    }

    public void a(HashMap<String, Object> map, u uVar) {
        s sVar = new s(map, uVar);
        a(sVar);
        a(0, this.b.size(), sVar, null);
    }

    public void a(int i5, int i6, s sVar, List<Object> list) {
        String string;
        y.a aVar = new y.a();
        aVar.f1404a = i5;
        aVar.b = sVar;
        aVar.c = list;
        aVar.f1405f = this.b;
        aVar.f1406g = this.c;
        while (aVar.f1404a < i6) {
            try {
                if (sVar.f()) {
                    aVar.d = true;
                    break;
                }
                this.b.get(aVar.f1404a).a(aVar);
                if (aVar.e) {
                    break;
                } else {
                    aVar.f1404a++;
                }
            } catch (Throwable th) {
                th = th;
                if (th instanceof v) {
                    string = th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage();
                    th = th.getCause();
                } else {
                    StringBuilder sb = new StringBuilder("Suba Runtime Error: ");
                    sb.append(th.getMessage() == null ? th.getClass().getSimpleName() : th.getMessage());
                    string = sb.toString();
                }
                throw new v(string + "\r\n\tat " + this.b.get(aVar.f1404a).b + " (" + this.b.get(aVar.f1404a).c + ")", th);
            }
        }
        if (aVar.d || sVar.d() <= 0 || list == null) {
            return;
        }
        try {
            list.add(sVar.a());
        } catch (Throwable unused) {
        }
    }

    private void a(s sVar) {
        sVar.a("Object", Object.class);
        sVar.a("Class", Class.class);
        sVar.a("Method", Method.class);
        sVar.a("String", String.class);
        sVar.a("Thread", Thread.class);
        sVar.a(cn.fly.commons.x.b("008)ficf.ddc,eePfe"), Runnable.class);
        sVar.a(cn.fly.commons.x.b("006Pdkdbeh5heEce"), System.class);
        sVar.a("File", File.class);
        sVar.a("URL", URL.class);
        sVar.a("Double", Double.class);
        sVar.a("Float", Float.class);
        sVar.a("Long", Long.class);
        sVar.a("Integer", Integer.class);
        sVar.a(cn.fly.commons.x.b("005'dkBgTcjci1h"), Short.class);
        sVar.a("Byte", Byte.class);
        sVar.a("Number", Number.class);
        sVar.a(cn.fly.commons.x.b("009?dc2gcQciHcbheVci"), Character.class);
        sVar.a("Boolean", Boolean.class);
        sVar.a(cn.fly.commons.x.b("006OcbcjcfeeIfe"), Double.TYPE);
        sVar.a(cn.fly.commons.x.b("005>deAf4cj-ch"), Float.TYPE);
        sVar.a(XmlErrorCodes.LONG, Long.TYPE);
        sVar.a(cn.fly.commons.x.b("003)ch=dh"), Integer.TYPE);
        sVar.a("short", Short.TYPE);
        sVar.a("byte", Byte.TYPE);
        sVar.a(cn.fly.commons.x.b("004bgc7ci"), Character.TYPE);
        sVar.a("boolean", Boolean.TYPE);
        sVar.a("bigInt", BigInteger.class);
        sVar.a("BigInteger", BigInteger.class);
        sVar.a("bigDec", BigDecimal.class);
        sVar.a("BigDecimal", BigDecimal.class);
        sVar.a("List", List.class);
        sVar.a("Map", Map.class);
        sVar.a("Function", z.class);
        sVar.a("fun", z.class);
        sVar.a(HttpHeaders.RANGE, aa.class);
        sVar.a(SoapEncSchemaTypeSystem.SOAP_ARRAY, Array.class);
        sVar.a("Suba", x.class);
        sVar.a("VM", x.class);
        for (Map.Entry<String, Class<?>> entry : f1384a.entrySet()) {
            sVar.a(entry.getKey(), entry.getValue());
        }
    }

    public ArrayList<y> a() {
        return this.b;
    }
}
