package p108t;

import A3.AbstractC0157z;
import S2.d;
import com.alibaba.android.arouter.utils.Consts;
import com.bumptech.glide.g;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.E;
import p102s.v;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ H f8514a = new H();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(21));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, I i5) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, i5, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final I i5, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLog.isLogEnable", strConcat), getCodec());
        if (i5 != null) {
            basicMessageChannel.setMessageHandler(new C1793z(i5, 8));
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLog.v", strConcat), getCodec());
        if (i5 != null) {
            final int i6 = 0;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.G
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    switch (i6) {
                        case 0:
                            I i7 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i7).v(str, (String) obj3);
                                listA = A3.G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            I i8 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i8).d(str2, (String) obj5);
                                listA2 = A3.G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            I i9 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i9).i(str3, (String) obj7);
                                listA3 = A3.G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            I i10 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj8;
                            Object obj9 = list4.get(1);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i10).e(str4, (String) obj9);
                                listA4 = A3.G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        default:
                            I i11 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj10;
                            Object obj11 = list5.get(1);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i11).w(str5, (String) obj11);
                                listA5 = A3.G.listOf(null);
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLog.d", strConcat), getCodec());
        if (i5 != null) {
            final int i7 = 1;
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.G
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    switch (i7) {
                        case 0:
                            I i8 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i8).v(str, (String) obj3);
                                listA = A3.G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            I i9 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i9).d(str2, (String) obj5);
                                listA2 = A3.G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            I i10 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i10).i(str3, (String) obj7);
                                listA3 = A3.G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            I i11 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj8;
                            Object obj9 = list4.get(1);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i11).e(str4, (String) obj9);
                                listA4 = A3.G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        default:
                            I i12 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj10;
                            Object obj11 = list5.get(1);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i12).w(str5, (String) obj11);
                                listA5 = A3.G.listOf(null);
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLog.i", strConcat), getCodec());
        if (i5 != null) {
            final int i8 = 2;
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.G
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    switch (i8) {
                        case 0:
                            I i9 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i9).v(str, (String) obj3);
                                listA = A3.G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            I i10 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i10).d(str2, (String) obj5);
                                listA2 = A3.G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            I i11 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i11).i(str3, (String) obj7);
                                listA3 = A3.G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            I i12 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj8;
                            Object obj9 = list4.get(1);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i12).e(str4, (String) obj9);
                                listA4 = A3.G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        default:
                            I i13 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj10;
                            Object obj11 = list5.get(1);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i13).w(str5, (String) obj11);
                                listA5 = A3.G.listOf(null);
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLog.e", strConcat), getCodec());
        if (i5 != null) {
            final int i9 = 3;
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.G
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    switch (i9) {
                        case 0:
                            I i10 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i10).v(str, (String) obj3);
                                listA = A3.G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            I i11 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i11).d(str2, (String) obj5);
                                listA2 = A3.G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            I i12 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i12).i(str3, (String) obj7);
                                listA3 = A3.G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            I i13 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj8;
                            Object obj9 = list4.get(1);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i13).e(str4, (String) obj9);
                                listA4 = A3.G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        default:
                            I i14 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj10;
                            Object obj11 = list5.get(1);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i14).w(str5, (String) obj11);
                                listA5 = A3.G.listOf(null);
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLog.w", strConcat), getCodec());
        if (i5 != null) {
            final int i10 = 4;
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.G
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    List listA5;
                    switch (i10) {
                        case 0:
                            I i11 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i11).v(str, (String) obj3);
                                listA = A3.G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            I i12 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i12).d(str2, (String) obj5);
                                listA2 = A3.G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            I i13 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i13).i(str3, (String) obj7);
                                listA3 = A3.G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            I i14 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj8 = list4.get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj8;
                            Object obj9 = list4.get(1);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i14).e(str4, (String) obj9);
                                listA4 = A3.G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        default:
                            I i15 = i5;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj10 = list5.get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            String str5 = (String) obj10;
                            Object obj11 = list5.get(1);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((v) i15).w(str5, (String) obj11);
                                listA5 = A3.G.listOf(null);
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
    }
}
