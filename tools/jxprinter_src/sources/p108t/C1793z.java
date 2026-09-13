package p108t;

import A3.G;
import com.bumptech.glide.g;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.List;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.T;
import p007a4.AbstractC0272e;
import p007a4.C0276f0;
import p007a4.C0315z0;
import p023d4.C0631u1;
import p051j0.a;
import p102s.C1630c;
import p102s.q;
import p102s.x;
import p134x2.P0;

/* JADX INFO: renamed from: t.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1793z implements BasicMessageChannel.MessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8540a;

    public /* synthetic */ C1793z(Object obj, int i5) {
        this.f8540a = i5;
    }

    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        List listA;
        List listA2;
        List listA3;
        List listA4;
        List listA5;
        List listA6;
        List listA7;
        List listA8;
        List listA9;
        List listA10;
        List listA11;
        List listA12;
        long jLongValue;
        List listA13;
        switch (this.f8540a) {
            case 0:
                E.f(reply, "reply");
                E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj2 = ((List) obj).get(0);
                E.d(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new q(((Boolean) obj2).booleanValue(), null));
                    listA = G.listOf(null);
                } catch (Throwable th) {
                    listA = g.a(th);
                }
                reply.reply(listA);
                break;
            case 1:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 5));
                    listA2 = G.listOf(null);
                } catch (Throwable th2) {
                    listA2 = g.a(th2);
                }
                reply.reply(listA2);
                break;
            case 2:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 10));
                    listA3 = G.listOf(null);
                } catch (Throwable th3) {
                    listA3 = g.a(th3);
                }
                reply.reply(listA3);
                break;
            case 3:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 4));
                    listA4 = G.listOf(null);
                } catch (Throwable th4) {
                    listA4 = g.a(th4);
                }
                reply.reply(listA4);
                break;
            case 4:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 9));
                    listA5 = G.listOf(null);
                } catch (Throwable th5) {
                    listA5 = g.a(th5);
                }
                reply.reply(listA5);
                break;
            case 5:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 3));
                    listA6 = G.listOf(null);
                } catch (Throwable th6) {
                    listA6 = g.a(th6);
                }
                reply.reply(listA6);
                break;
            case 6:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 8));
                    listA7 = G.listOf(null);
                } catch (Throwable th7) {
                    listA7 = g.a(th7);
                }
                reply.reply(listA7);
                break;
            case 7:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getMain(), 2, new C1630c(2, null, 11));
                    listA8 = G.listOf(null);
                } catch (Throwable th8) {
                    listA8 = g.a(th8);
                }
                reply.reply(listA8);
                break;
            case 8:
                E.f(reply, "reply");
                try {
                    listA9 = G.listOf(Boolean.valueOf(a.f5394a != 9));
                } catch (Throwable th9) {
                    listA9 = g.a(th9);
                }
                reply.reply(listA9);
                break;
            case 9:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C0631u1(2, null, 4));
                    listA10 = G.listOf(null);
                } catch (Throwable th10) {
                    listA10 = g.a(th10);
                }
                reply.reply(listA10);
                break;
            case 10:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C0631u1(2, null, 5));
                    listA11 = G.listOf(null);
                } catch (Throwable th11) {
                    listA11 = g.a(th11);
                }
                reply.reply(listA11);
                break;
            case 11:
                E.f(reply, "reply");
                try {
                    AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new C0631u1(2, null, 6));
                    listA12 = G.listOf(null);
                } catch (Throwable th12) {
                    listA12 = g.a(th12);
                }
                reply.reply(listA12);
                break;
            default:
                E.f(reply, "reply");
                E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                Object obj3 = ((List) obj).get(0);
                if (obj3 instanceof Integer) {
                    jLongValue = ((Number) obj3).intValue();
                } else {
                    E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                    jLongValue = ((Long) obj3).longValue();
                }
                try {
                    T t6 = new T();
                    P0 p0H = a.h();
                    E3.g gVar = null;
                    if (p0H != null) {
                        t6.f5689a = p0H;
                        p0H.f8867j = (int) jLongValue;
                        AbstractC0272e.b(C0315z0.INSTANCE, C0276f0.getIO(), 2, new x(t6, gVar, 1));
                    }
                    listA13 = G.listOf(null);
                } catch (Throwable th13) {
                    listA13 = g.a(th13);
                }
                reply.reply(listA13);
                break;
        }
    }
}
