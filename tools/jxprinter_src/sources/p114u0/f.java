package p114u0;

import X0.a;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8720a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ g d;

    public /* synthetic */ f(g gVar, List list, List list2, int i5) {
        this.f8720a = i5;
        this.d = gVar;
        this.b = list;
        this.c = list2;
    }

    @Override // X0.a
    public final void f(int i5) {
        switch (this.f8720a) {
            case 0:
                g gVar = this.d;
                int i6 = i5 + gVar.f8726i;
                gVar.f8732o = i6;
                int currentItem = gVar.c.getCurrentItem();
                int i7 = gVar.f8726i;
                int i8 = gVar.f8727j;
                if (i7 == i8) {
                    gVar.c.setAdapter(new p091q0.a(gVar.f8728k, gVar.f8729l));
                    if (currentItem > gVar.c.getAdapter().h() - 1) {
                        currentItem = gVar.c.getAdapter().h() - 1;
                        gVar.c.setCurrentItem(currentItem);
                    }
                    g gVar2 = this.d;
                    int i9 = gVar2.f8728k;
                    int i10 = currentItem + i9;
                    int i11 = gVar2.f8729l;
                    if (i9 == i11) {
                        g.a(gVar2, i6, i10, gVar2.f8730m, gVar2.f8731n, this.b, this.c);
                    } else if (i10 == i9) {
                        g.a(gVar2, i6, i10, gVar2.f8730m, 31, this.b, this.c);
                    } else if (i10 == i11) {
                        g.a(gVar2, i6, i10, 1, gVar2.f8731n, this.b, this.c);
                    } else {
                        g.a(gVar2, i6, i10, 1, 31, this.b, this.c);
                    }
                } else if (i6 == i7) {
                    gVar.c.setAdapter(new p091q0.a(gVar.f8728k, 12));
                    if (currentItem > gVar.c.getAdapter().h() - 1) {
                        currentItem = gVar.c.getAdapter().h() - 1;
                        gVar.c.setCurrentItem(currentItem);
                    }
                    g gVar3 = this.d;
                    int i12 = gVar3.f8728k;
                    int i13 = currentItem + i12;
                    if (i13 == i12) {
                        g.a(gVar3, i6, i13, gVar3.f8730m, 31, this.b, this.c);
                    } else {
                        g.a(gVar3, i6, i13, 1, 31, this.b, this.c);
                    }
                } else if (i6 == i8) {
                    gVar.c.setAdapter(new p091q0.a(1, gVar.f8729l));
                    if (currentItem > gVar.c.getAdapter().h() - 1) {
                        currentItem = gVar.c.getAdapter().h() - 1;
                        gVar.c.setCurrentItem(currentItem);
                    }
                    int i14 = 1 + currentItem;
                    g gVar4 = this.d;
                    if (i14 == gVar4.f8729l) {
                        g.a(gVar4, i6, i14, 1, gVar4.f8731n, this.b, this.c);
                    } else {
                        g.a(gVar4, i6, i14, 1, 31, this.b, this.c);
                    }
                } else {
                    gVar.c.setAdapter(new p091q0.a(1, 12));
                    g gVar5 = this.d;
                    g.a(gVar5, i6, 1 + gVar5.c.getCurrentItem(), 1, 31, this.b, this.c);
                }
                gVar.getClass();
                break;
            default:
                int i15 = i5 + 1;
                g gVar6 = this.d;
                int i16 = gVar6.f8726i;
                int i17 = gVar6.f8727j;
                g gVar7 = this.d;
                if (i16 == i17) {
                    int i18 = gVar6.f8728k;
                    int i19 = (i15 + i18) - 1;
                    int i20 = gVar6.f8729l;
                    if (i18 == i20) {
                        g.a(gVar6, gVar6.f8732o, i19, gVar6.f8730m, gVar6.f8731n, this.b, this.c);
                    } else if (i18 == i19) {
                        g.a(gVar6, gVar6.f8732o, i19, gVar6.f8730m, 31, this.b, this.c);
                    } else if (i20 == i19) {
                        g.a(gVar6, gVar6.f8732o, i19, 1, gVar6.f8731n, this.b, this.c);
                    } else {
                        g.a(gVar6, gVar6.f8732o, i19, 1, 31, this.b, this.c);
                    }
                } else {
                    int i21 = gVar6.f8732o;
                    if (i21 == i16) {
                        int i22 = gVar6.f8728k;
                        int i23 = (i15 + i22) - 1;
                        if (i23 == i22) {
                            g.a(gVar6, i21, i23, gVar6.f8730m, 31, this.b, this.c);
                        } else {
                            g.a(gVar6, i21, i23, 1, 31, this.b, this.c);
                        }
                    } else if (i21 != i17) {
                        g.a(gVar6, i21, i15, 1, 31, this.b, this.c);
                    } else if (i15 == gVar6.f8729l) {
                        g.a(gVar6, i21, gVar6.c.getCurrentItem() + 1, 1, gVar7.f8731n, this.b, this.c);
                    } else {
                        g.a(gVar6, i21, gVar6.c.getCurrentItem() + 1, 1, 31, this.b, this.c);
                    }
                }
                gVar7.getClass();
                break;
        }
    }
}
