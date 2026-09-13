package p029e5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.litepal.LitePalApplication;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static a f3948g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3949a;
    public int b;
    public String c;
    public String d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f3950f;

    public /* synthetic */ a(int i5) {
        this.f3949a = i5;
    }

    public static a b() {
        if (f3948g == null) {
            synchronized (a.class) {
                try {
                    if (f3948g == null) {
                        f3948g = new a(0);
                        c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f3948g;
    }

    public static void c() {
        try {
            String[] list = LitePalApplication.getContext().getAssets().list("");
            if (list == null || list.length <= 0) {
                return;
            }
            for (String str : list) {
                if ("litepal.xml".equalsIgnoreCase(str)) {
                    a aVarA = b.a();
                    a aVar = f3948g;
                    aVar.c = aVarA.c;
                    aVar.b = aVarA.b;
                    aVar.f3950f = aVarA.a();
                    a aVar2 = f3948g;
                    aVar2.d = aVarA.d;
                    aVar2.e = aVarA.e;
                    return;
                }
            }
        } catch (IOException unused) {
        }
    }

    public final List a() {
        switch (this.f3949a) {
            case 0:
                List list = this.f3950f;
                if (list == null) {
                    ArrayList arrayList = new ArrayList();
                    this.f3950f = arrayList;
                    arrayList.add("org.litepal.model.Table_Schema");
                } else if (list.isEmpty()) {
                    this.f3950f.add("org.litepal.model.Table_Schema");
                }
                return this.f3950f;
            default:
                ArrayList arrayList2 = (ArrayList) this.f3950f;
                if (arrayList2 == null) {
                    ArrayList arrayList3 = new ArrayList();
                    this.f3950f = arrayList3;
                    arrayList3.add("org.litepal.model.Table_Schema");
                } else if (arrayList2.isEmpty()) {
                    ((ArrayList) this.f3950f).add("org.litepal.model.Table_Schema");
                }
                return (ArrayList) this.f3950f;
        }
    }
}
