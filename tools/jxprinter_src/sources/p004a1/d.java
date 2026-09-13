package p004a1;

import p069m1.b;
import p075n1.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f934a;
    public static a b;
    public static boolean c;

    public static void a(b bVar, b... bVarArr) {
        if (c) {
            p057k1.b.f5472a.c();
        }
        c = true;
        f934a = bVar;
        a aVar = new a(13, false);
        aVar.b = bVarArr;
        b = aVar;
    }

    @Deprecated
    public static c b() {
        c cVar = new c();
        cVar.f932h = true;
        cVar.f933i = true;
        return cVar;
    }

    public static c c(String str) {
        c cVar = new c();
        cVar.f929a = str;
        return cVar;
    }

    @Deprecated
    public static void init(int i5, b bVar) {
        a aVar = new a(bVar);
        aVar.f907a = i5;
        a(aVar.a(), p057k1.b.f5472a.b());
    }

    @Deprecated
    public static c nb() {
        c cVar = new c();
        cVar.f932h = false;
        cVar.f933i = true;
        return cVar;
    }

    @Deprecated
    public static c nst() {
        c cVar = new c();
        cVar.d = false;
        cVar.e = null;
        cVar.f930f = 0;
        cVar.f931g = true;
        return cVar;
    }

    @Deprecated
    public static c nt() {
        c cVar = new c();
        cVar.b = false;
        cVar.c = true;
        return cVar;
    }

    @Deprecated
    public static c st(int i5) {
        c cVar = new c();
        cVar.d = true;
        cVar.f930f = i5;
        cVar.f931g = true;
        return cVar;
    }

    @Deprecated
    public static c t() {
        c cVar = new c();
        cVar.b = true;
        cVar.c = true;
        return cVar;
    }

    @Deprecated
    public static c st(String str, int i5) {
        c cVar = new c();
        cVar.d = true;
        cVar.e = str;
        cVar.f930f = i5;
        cVar.f931g = true;
        return cVar;
    }

    @Deprecated
    public static void init(int i5, b bVar, b... bVarArr) {
        a aVar = new a(bVar);
        aVar.f907a = i5;
        a(aVar.a(), bVarArr);
    }
}
