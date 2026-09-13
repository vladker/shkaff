package p108t;

import A3.AbstractC0157z;
import A3.G;
import S2.d;
import S2.f;
import com.alibaba.android.arouter.utils.Consts;
import com.bumptech.glide.g;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.E;
import p102s.k;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ r f8535a = new r();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(15));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, InterfaceC1786s interfaceC1786s) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, interfaceC1786s, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final InterfaceC1786s interfaceC1786s, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterExcelUtils.setCurrentElementExcelInfo", strConcat), getCodec());
        if (interfaceC1786s != null) {
            final int i5 = 0;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.q
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    long jLongValue;
                    List listA;
                    switch (i5) {
                        case 0:
                            InterfaceC1786s interfaceC1786s2 = interfaceC1786s;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj3;
                            Object obj4 = list.get(2);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj4;
                            Object obj5 = list.get(3);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj5).booleanValue();
                            Object obj6 = list.get(4);
                            if (obj6 instanceof Integer) {
                                jLongValue = ((Number) obj6).intValue();
                            } else {
                                E.d(obj6, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj6).longValue();
                            }
                            try {
                                ((k) interfaceC1786s2).setCurrentElementExcelInfo(str, str2, str3, zBooleanValue, jLongValue);
                                listA = G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj7 = ((List) obj).get(0);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            ((k) interfaceC1786s).readExcelInfo((String) obj7, new f(reply, 28));
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterExcelUtils.readExcelInfo", strConcat), getCodec());
        if (interfaceC1786s != null) {
            final int i6 = 1;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.q
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    long jLongValue;
                    List listA;
                    switch (i6) {
                        case 0:
                            InterfaceC1786s interfaceC1786s2 = interfaceC1786s;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) obj3;
                            Object obj4 = list.get(2);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj4;
                            Object obj5 = list.get(3);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                            boolean zBooleanValue = ((Boolean) obj5).booleanValue();
                            Object obj6 = list.get(4);
                            if (obj6 instanceof Integer) {
                                jLongValue = ((Number) obj6).intValue();
                            } else {
                                E.d(obj6, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj6).longValue();
                            }
                            try {
                                ((k) interfaceC1786s2).setCurrentElementExcelInfo(str, str2, str3, zBooleanValue, jLongValue);
                                listA = G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj7 = ((List) obj).get(0);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            ((k) interfaceC1786s).readExcelInfo((String) obj7, new f(reply, 28));
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
