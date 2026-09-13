package S2;

import A3.G;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.firebase.analytics.FirebaseAnalyticsHostApi;
import java.util.List;
import p108t.C1770b;
import p108t.C1772d;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements O3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f638a;
    public final /* synthetic */ BasicMessageChannel.Reply b;

    public /* synthetic */ f(BasicMessageChannel.Reply reply, int i5) {
        this.f638a = i5;
        this.b = reply;
    }

    @Override // O3.l
    public final Object invoke(Object obj) {
        switch (this.f638a) {
            case 0:
                p147z3.u uVar = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl = p147z3.u.m1362exceptionOrNullimpl(uVar.b());
                BasicMessageChannel.Reply reply = this.b;
                if (thM1362exceptionOrNullimpl != null) {
                    reply.reply(j.INSTANCE.wrapError(thM1362exceptionOrNullimpl));
                } else {
                    Object objB = uVar.b();
                    if (objB instanceof z3.u.a) {
                        objB = null;
                    }
                    reply.reply(j.INSTANCE.wrapResult((c) objB));
                }
                return Q.INSTANCE;
            case 1:
                p147z3.u uVar2 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl2 = p147z3.u.m1362exceptionOrNullimpl(uVar2.b());
                BasicMessageChannel.Reply reply2 = this.b;
                if (thM1362exceptionOrNullimpl2 != null) {
                    reply2.reply(j.INSTANCE.wrapError(thM1362exceptionOrNullimpl2));
                } else {
                    Object objB2 = uVar2.b();
                    if (objB2 instanceof z3.u.a) {
                        objB2 = null;
                    }
                    reply2.reply(j.INSTANCE.wrapResult((Long) objB2));
                }
                return Q.INSTANCE;
            case 2:
                p147z3.u uVar3 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl3 = p147z3.u.m1362exceptionOrNullimpl(uVar3.b());
                BasicMessageChannel.Reply reply3 = this.b;
                if (thM1362exceptionOrNullimpl3 != null) {
                    reply3.reply(j.INSTANCE.wrapError(thM1362exceptionOrNullimpl3));
                } else {
                    Object objB3 = uVar3.b();
                    if (objB3 instanceof z3.u.a) {
                        objB3 = null;
                    }
                    reply3.reply(j.INSTANCE.wrapResult((Boolean) objB3));
                }
                return Q.INSTANCE;
            case 3:
                Throwable thM1362exceptionOrNullimpl4 = p147z3.u.m1362exceptionOrNullimpl(((p147z3.u) obj).b());
                BasicMessageChannel.Reply reply4 = this.b;
                if (thM1362exceptionOrNullimpl4 != null) {
                    reply4.reply(j.INSTANCE.wrapError(thM1362exceptionOrNullimpl4));
                } else {
                    reply4.reply(j.INSTANCE.wrapResult(null));
                }
                return Q.INSTANCE;
            case 4:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$30$lambda$29$lambda$28(this.b, (p147z3.u) obj);
            case 5:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$33$lambda$32$lambda$31(this.b, (p147z3.u) obj);
            case 6:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$15$lambda$14$lambda$13(this.b, (p147z3.u) obj);
            case 7:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$24$lambda$23$lambda$22(this.b, (p147z3.u) obj);
            case 8:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$12$lambda$11$lambda$10(this.b, (p147z3.u) obj);
            case 9:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$3$lambda$2$lambda$1(this.b, (p147z3.u) obj);
            case 10:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$9$lambda$8$lambda$7(this.b, (p147z3.u) obj);
            case 11:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$21$lambda$20$lambda$19(this.b, (p147z3.u) obj);
            case 12:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$6$lambda$5$lambda$4(this.b, (p147z3.u) obj);
            case 13:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$27$lambda$26$lambda$25(this.b, (p147z3.u) obj);
            case 14:
                return FirebaseAnalyticsHostApi.Companion.setUp$lambda$18$lambda$17$lambda$16(this.b, (p147z3.u) obj);
            case 15:
                p147z3.u uVar4 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl5 = p147z3.u.m1362exceptionOrNullimpl(uVar4.b());
                BasicMessageChannel.Reply reply5 = this.b;
                if (thM1362exceptionOrNullimpl5 != null) {
                    reply5.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl5));
                } else {
                    Object objB4 = uVar4.b();
                    if (objB4 instanceof z3.u.a) {
                        objB4 = null;
                    }
                    reply5.reply(G.listOf((String) objB4));
                }
                return Q.INSTANCE;
            case 16:
                Throwable thM1362exceptionOrNullimpl6 = p147z3.u.m1362exceptionOrNullimpl(((p147z3.u) obj).b());
                BasicMessageChannel.Reply reply6 = this.b;
                if (thM1362exceptionOrNullimpl6 != null) {
                    reply6.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl6));
                } else {
                    reply6.reply(G.listOf(null));
                }
                return Q.INSTANCE;
            case 17:
                p147z3.u uVar5 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl7 = p147z3.u.m1362exceptionOrNullimpl(uVar5.b());
                BasicMessageChannel.Reply reply7 = this.b;
                if (thM1362exceptionOrNullimpl7 != null) {
                    reply7.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl7));
                } else {
                    Object objB5 = uVar5.b();
                    if (objB5 instanceof z3.u.a) {
                        objB5 = null;
                    }
                    reply7.reply(G.listOf((Long) objB5));
                }
                return Q.INSTANCE;
            case 18:
                p147z3.u uVar6 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl8 = p147z3.u.m1362exceptionOrNullimpl(uVar6.b());
                BasicMessageChannel.Reply reply8 = this.b;
                if (thM1362exceptionOrNullimpl8 != null) {
                    reply8.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl8));
                } else {
                    Object objB6 = uVar6.b();
                    if (objB6 instanceof z3.u.a) {
                        objB6 = null;
                    }
                    reply8.reply(G.listOf((C1770b) objB6));
                }
                return Q.INSTANCE;
            case 19:
                p147z3.u uVar7 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl9 = p147z3.u.m1362exceptionOrNullimpl(uVar7.b());
                BasicMessageChannel.Reply reply9 = this.b;
                if (thM1362exceptionOrNullimpl9 != null) {
                    reply9.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl9));
                } else {
                    Object objB7 = uVar7.b();
                    if (objB7 instanceof z3.u.a) {
                        objB7 = null;
                    }
                    reply9.reply(G.listOf((String) objB7));
                }
                return Q.INSTANCE;
            case 20:
                p147z3.u uVar8 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl10 = p147z3.u.m1362exceptionOrNullimpl(uVar8.b());
                BasicMessageChannel.Reply reply10 = this.b;
                if (thM1362exceptionOrNullimpl10 != null) {
                    reply10.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl10));
                } else {
                    Object objB8 = uVar8.b();
                    if (objB8 instanceof z3.u.a) {
                        objB8 = null;
                    }
                    reply10.reply(G.listOf((C1772d) objB8));
                }
                return Q.INSTANCE;
            case 21:
                p147z3.u uVar9 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl11 = p147z3.u.m1362exceptionOrNullimpl(uVar9.b());
                BasicMessageChannel.Reply reply11 = this.b;
                if (thM1362exceptionOrNullimpl11 != null) {
                    reply11.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl11));
                } else {
                    Object objB9 = uVar9.b();
                    if (objB9 instanceof z3.u.a) {
                        objB9 = null;
                    }
                    reply11.reply(G.listOf((Boolean) objB9));
                }
                return Q.INSTANCE;
            case 22:
                p147z3.u uVar10 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl12 = p147z3.u.m1362exceptionOrNullimpl(uVar10.b());
                BasicMessageChannel.Reply reply12 = this.b;
                if (thM1362exceptionOrNullimpl12 != null) {
                    reply12.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl12));
                } else {
                    Object objB10 = uVar10.b();
                    if (objB10 instanceof z3.u.a) {
                        objB10 = null;
                    }
                    reply12.reply(G.listOf((Boolean) objB10));
                }
                return Q.INSTANCE;
            case 23:
                p147z3.u uVar11 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl13 = p147z3.u.m1362exceptionOrNullimpl(uVar11.b());
                BasicMessageChannel.Reply reply13 = this.b;
                if (thM1362exceptionOrNullimpl13 != null) {
                    reply13.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl13));
                } else {
                    Object objB11 = uVar11.b();
                    if (objB11 instanceof z3.u.a) {
                        objB11 = null;
                    }
                    reply13.reply(G.listOf((Boolean) objB11));
                }
                return Q.INSTANCE;
            case 24:
                p147z3.u uVar12 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl14 = p147z3.u.m1362exceptionOrNullimpl(uVar12.b());
                BasicMessageChannel.Reply reply14 = this.b;
                if (thM1362exceptionOrNullimpl14 != null) {
                    reply14.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl14));
                } else {
                    Object objB12 = uVar12.b();
                    if (objB12 instanceof z3.u.a) {
                        objB12 = null;
                    }
                    reply14.reply(G.listOf((C1772d) objB12));
                }
                return Q.INSTANCE;
            case 25:
                p147z3.u uVar13 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl15 = p147z3.u.m1362exceptionOrNullimpl(uVar13.b());
                BasicMessageChannel.Reply reply15 = this.b;
                if (thM1362exceptionOrNullimpl15 != null) {
                    reply15.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl15));
                } else {
                    Object objB13 = uVar13.b();
                    if (objB13 instanceof z3.u.a) {
                        objB13 = null;
                    }
                    reply15.reply(G.listOf((String) objB13));
                }
                return Q.INSTANCE;
            case 26:
                p147z3.u uVar14 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl16 = p147z3.u.m1362exceptionOrNullimpl(uVar14.b());
                BasicMessageChannel.Reply reply16 = this.b;
                if (thM1362exceptionOrNullimpl16 != null) {
                    reply16.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl16));
                } else {
                    Object objB14 = uVar14.b();
                    if (objB14 instanceof z3.u.a) {
                        objB14 = null;
                    }
                    reply16.reply(G.listOf((C1772d) objB14));
                }
                return Q.INSTANCE;
            case 27:
                p147z3.u uVar15 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl17 = p147z3.u.m1362exceptionOrNullimpl(uVar15.b());
                BasicMessageChannel.Reply reply17 = this.b;
                if (thM1362exceptionOrNullimpl17 != null) {
                    reply17.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl17));
                } else {
                    Object objB15 = uVar15.b();
                    if (objB15 instanceof z3.u.a) {
                        objB15 = null;
                    }
                    reply17.reply(G.listOf((Boolean) objB15));
                }
                return Q.INSTANCE;
            case 28:
                p147z3.u uVar16 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl18 = p147z3.u.m1362exceptionOrNullimpl(uVar16.b());
                BasicMessageChannel.Reply reply18 = this.b;
                if (thM1362exceptionOrNullimpl18 != null) {
                    reply18.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl18));
                } else {
                    Object objB16 = uVar16.b();
                    if (objB16 instanceof z3.u.a) {
                        objB16 = null;
                    }
                    reply18.reply(G.listOf((List) objB16));
                }
                return Q.INSTANCE;
            default:
                p147z3.u uVar17 = (p147z3.u) obj;
                Throwable thM1362exceptionOrNullimpl19 = p147z3.u.m1362exceptionOrNullimpl(uVar17.b());
                BasicMessageChannel.Reply reply19 = this.b;
                if (thM1362exceptionOrNullimpl19 != null) {
                    reply19.reply(com.bumptech.glide.g.a(thM1362exceptionOrNullimpl19));
                } else {
                    Object objB17 = uVar17.b();
                    if (objB17 instanceof z3.u.a) {
                        objB17 = null;
                    }
                    reply19.reply(G.listOf((List) objB17));
                }
                return Q.INSTANCE;
        }
    }
}
