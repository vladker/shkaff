package p108t;

import A3.AbstractC0157z;
import A3.G;
import S2.d;
import com.alibaba.android.arouter.utils.Consts;
import com.bumptech.glide.g;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.E;
import p102s.o;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: renamed from: t.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1791x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C1791x f8539a = new C1791x();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(17));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, InterfaceC1792y interfaceC1792y) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, interfaceC1792y, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final InterfaceC1792y interfaceC1792y, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterImportFile.pickFile", strConcat), getCodec());
        if (interfaceC1792y != null) {
            final int i5 = 0;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.w
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    switch (i5) {
                        case 0:
                            InterfaceC1792y interfaceC1792y2 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            try {
                                ((o) interfaceC1792y2).pickFile(str, (List) obj3);
                                listA = G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1792y interfaceC1792y3 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((o) interfaceC1792y3).openFromWechat(str2, (String) obj5);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        default:
                            InterfaceC1792y interfaceC1792y4 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((o) interfaceC1792y4).openFromQQ(str3, (String) obj7);
                                listA3 = G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterImportFile.openFromWechat", strConcat), getCodec());
        if (interfaceC1792y != null) {
            final int i6 = 1;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.w
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    switch (i6) {
                        case 0:
                            InterfaceC1792y interfaceC1792y2 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            try {
                                ((o) interfaceC1792y2).pickFile(str, (List) obj3);
                                listA = G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1792y interfaceC1792y3 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((o) interfaceC1792y3).openFromWechat(str2, (String) obj5);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        default:
                            InterfaceC1792y interfaceC1792y4 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((o) interfaceC1792y4).openFromQQ(str3, (String) obj7);
                                listA3 = G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterImportFile.openFromQQ", strConcat), getCodec());
        if (interfaceC1792y != null) {
            final int i7 = 2;
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.w
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    switch (i7) {
                        case 0:
                            InterfaceC1792y interfaceC1792y2 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            try {
                                ((o) interfaceC1792y2).pickFile(str, (List) obj3);
                                listA = G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1792y interfaceC1792y3 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj4;
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((o) interfaceC1792y3).openFromWechat(str2, (String) obj5);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        default:
                            InterfaceC1792y interfaceC1792y4 = interfaceC1792y;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj6;
                            Object obj7 = list3.get(1);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((o) interfaceC1792y4).openFromQQ(str3, (String) obj7);
                                listA3 = G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
    }
}
