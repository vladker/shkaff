package p060k4;

import A3.C0130a;
import A3.T;
import A3.k0;
import O3.a;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.E;
import kotlinx.serialization.json.internal.I;
import p072m4.C1245e;
import p072m4.D;
import p072m4.r;
import p072m4.w;
import p072m4.y;
import p084o4.C1345y0;
import p084o4.J;
import p089p4.AbstractC1519d;
import p089p4.u;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5592a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ g(Object obj, Object obj2, int i5) {
        this.f5592a = i5;
        this.b = obj;
        this.c = obj2;
    }

    @Override // O3.a
    public final Object invoke() {
        String strSerialNameForJson;
        String[] strArrNames;
        switch (this.f5592a) {
            case 0:
                return w.buildSerialDescriptor((String) this.b, C1245e.INSTANCE, new r[0], new h((i) this.c, 0));
            case 1:
                r rVar = (r) this.b;
                AbstractC1519d abstractC1519d = (AbstractC1519d) this.c;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                boolean z6 = abstractC1519d.getConfiguration().f7764k && E.a(rVar.getKind(), y.INSTANCE);
                p089p4.w wVarNamingStrategy = I.namingStrategy(rVar, abstractC1519d);
                int iB = rVar.b();
                for (int i5 = 0; i5 < iB; i5++) {
                    List<Annotation> elementAnnotations = rVar.getElementAnnotations(i5);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : elementAnnotations) {
                        if (obj instanceof u) {
                            arrayList.add(obj);
                        }
                    }
                    u uVar = (u) T.singleOrNull((List) arrayList);
                    if (uVar != null && (strArrNames = uVar.names()) != null) {
                        for (String lowerCase : strArrNames) {
                            if (z6) {
                                lowerCase = lowerCase.toLowerCase(Locale.ROOT);
                                E.e(lowerCase, "toLowerCase(...)");
                            }
                            I.a(linkedHashMap, rVar, lowerCase, i5);
                        }
                    }
                    if (z6) {
                        strSerialNameForJson = rVar.getElementName(i5).toLowerCase(Locale.ROOT);
                        E.e(strSerialNameForJson, "toLowerCase(...)");
                    } else {
                        strSerialNameForJson = wVarNamingStrategy != null ? wVarNamingStrategy.serialNameForJson(rVar, i5, rVar.getElementName(i5)) : null;
                    }
                    if (strSerialNameForJson != null) {
                        I.a(linkedHashMap, rVar, strSerialNameForJson, i5);
                    }
                }
                return linkedHashMap.isEmpty() ? k0.emptyMap() : linkedHashMap;
            case 2:
                r rVar2 = (r) this.b;
                p089p4.w wVar = (p089p4.w) this.c;
                int iB2 = rVar2.b();
                String[] strArr = new String[iB2];
                for (int i6 = 0; i6 < iB2; i6++) {
                    strArr[i6] = wVar.serialNameForJson(rVar2, i6, rVar2.getElementName(i6));
                }
                return strArr;
            case 3:
                return J.a((J) this.c, (String) this.b);
            default:
                return w.buildSerialDescriptor((String) this.b, D.INSTANCE, new r[0], new C0130a((C1345y0) this.c, 18));
        }
    }

    public /* synthetic */ g(J j6, String str) {
        this.f5592a = 3;
        this.c = j6;
        this.b = str;
    }
}
