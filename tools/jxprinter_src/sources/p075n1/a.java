package p075n1;

import A3.InterfaceC0131a0;
import O3.l;
import U1.f;
import U1.g;
import X3.b0;
import com.android.billingclient.api.H;
import com.android.billingclient.api.InterfaceC0423n;
import com.bumptech.glide.load.engine.cache.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import p050j.h;
import p050j.p;
import p050j.r;
import p062l0.e;
import p069m1.b;
import p115u1.d;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements InterfaceC0131a0, V1.a, j, p, h, InterfaceC0423n, b, W0.a, X0.a {
    public static a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6213a;
    public Object b;

    public /* synthetic */ a(int i5, boolean z6) {
        this.f6213a = i5;
    }

    @Override // p050j.h
    public boolean a(r rVar, Object obj) {
        return rVar.d(obj, (String) this.b) == null;
    }

    @Override // p069m1.b
    public void b(int i5, String str, String str2) {
        for (b bVar : (b[]) this.b) {
            bVar.b(i5, str, str2);
        }
    }

    @Override // p050j.p
    public Object c(r rVar, Object obj, Object obj2) {
        switch (this.f6213a) {
            case 9:
                h hVar = (h) this.b;
                if (obj2 != null) {
                    p050j.b bVar = new p050j.b();
                    if (obj2 instanceof Iterable) {
                        for (Object obj3 : (Iterable) obj2) {
                            if (hVar.a(rVar, obj3)) {
                                bVar.add(obj3);
                            }
                        }
                        return bVar;
                    }
                    if (hVar.a(rVar, obj2)) {
                        return obj2;
                    }
                }
                return null;
            default:
                String[] strArr = (String[]) this.b;
                ArrayList arrayList = new ArrayList(strArr.length);
                for (String str : strArr) {
                    arrayList.add(rVar.d(obj2, str));
                }
                return arrayList;
        }
    }

    @Override // com.android.billingclient.api.InterfaceC0423n
    public void d() {
        p051j0.a.d("GoogleBillingManager", "连接断开");
        e.a((e) this.b);
    }

    @Override // V1.a
    public boolean e(int i5) {
        return i5 == 2;
    }

    @Override // X0.a
    public void f(int i5) {
        ((p114u0.e) this.b).getClass();
    }

    @Override // V1.a
    public double g(double[] dArr, int i5) {
        double[][] dArr2;
        int i6 = (int) dArr[0];
        int i7 = (int) dArr[1];
        f fVar = ((g) this.b).f711a;
        if (i6 < 0 || i7 < 0 || i7 > i6) {
            return 0.0d;
        }
        double[][] dArr3 = fVar.f710a;
        if (i6 >= dArr3.length) {
            int length = dArr3.length * 2;
            double[][] dArr4 = i6 > length ? new double[i6 + 1][] : new double[length + 1][];
            int i8 = 0;
            while (true) {
                dArr2 = fVar.f710a;
                if (i8 >= dArr2.length) {
                    break;
                }
                dArr4[i8] = dArr2[i8];
                i8++;
            }
            for (int length2 = dArr2.length; length2 < dArr4.length; length2++) {
                double[] dArr5 = new double[(length2 / 2) + 1];
                dArr4[length2] = dArr5;
                dArr5[0] = 1.0d;
                int i9 = 1;
                while (true) {
                    double[] dArr6 = dArr4[length2];
                    if (i9 < dArr6.length) {
                        double[] dArr7 = dArr4[length2 - 1];
                        double d = dArr7[i9 - 1];
                        dArr6[i9] = i9 < dArr7.length ? d + dArr7[i9] : d * 2.0d;
                        i9++;
                    }
                }
            }
            fVar.f710a = dArr4;
        }
        if (i7 * 2 > i6) {
            i7 = i6 - i7;
        }
        return fVar.f710a[i6][i7];
    }

    @Override // W0.a
    public Object getItem(int i5) {
        List list = (List) this.b;
        return (i5 < 0 || i5 >= list.size()) ? "" : list.get(i5);
    }

    @Override // W0.a
    public int h() {
        return ((List) this.b).size();
    }

    public void i(float f6, float f7, float f8) {
        L1.p pVar = (L1.p) this.b;
        if (pVar.d() < pVar.e || f6 < 1.0f) {
            pVar.getClass();
            pVar.f434m.postScale(f6, f6, f7, f8);
            pVar.a();
        }
    }

    @Override // com.android.billingclient.api.InterfaceC0423n
    public void onBillingSetupFinished(H h6) {
        e eVar = (e) this.b;
        if (h6.f2433a != 0) {
            p051j0.a.d("GoogleBillingManager", "连接失败: " + h6.getDebugMessage() + ", 响应码: " + h6.f2433a);
            e.a(eVar);
            return;
        }
        p051j0.a.d("GoogleBillingManager", "连接成功");
        eVar.d = 0;
        W2.b bVar = eVar.c;
        if (bVar != null) {
            bVar.run();
            eVar.c = null;
        }
    }

    @Override // A3.InterfaceC0131a0
    public Iterator sourceIterator() {
        switch (this.f6213a) {
            case 1:
                return ((Iterable) this.b).iterator();
            default:
                return b0.iterator((CharSequence) this.b);
        }
    }

    public String toString() {
        switch (this.f6213a) {
            case 4:
                return "combin(n, r)";
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(Object obj, int i5) {
        this.f6213a = i5;
        this.b = obj;
    }

    public /* synthetic */ a(Object obj, l lVar, int i5) {
        this.f6213a = i5;
        this.b = obj;
    }

    public a(int i5) {
        this.f6213a = i5;
        switch (i5) {
            case 4:
                this.b = new g();
                break;
            case 6:
                this.b = new HashMap();
                break;
            case 15:
                this.b = new LinkedHashSet();
                break;
            default:
                d dVar = new d();
                dVar.f8733a = true;
                dVar.b = false;
                dVar.c = null;
                new b();
                this.b = dVar;
                break;
        }
    }
}
