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
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class W {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ W f8523a = new W();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(26));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, X x6) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, x6, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final X x6, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterWifiManager.getDevices", strConcat), getCodec());
        if (x6 != null) {
            final int i5 = 0;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.V
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    switch (i5) {
                        case 0:
                            X x7 = x6;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((p102s.E) x7).getDevices());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            X x8 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x8).addDevice((d0) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            X x9 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            E.d(obj3, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x9).removeDevice((d0) obj3);
                                listA3 = G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        default:
                            X x10 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            E.d(obj4, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            d0 d0Var = (d0) obj4;
                            Object obj5 = list.get(1);
                            E.d(obj5, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x10).updateDevice(d0Var, (d0) obj5);
                                listA4 = G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterWifiManager.addDevice", strConcat), getCodec());
        if (x6 != null) {
            final int i6 = 1;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.V
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    switch (i6) {
                        case 0:
                            X x7 = x6;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((p102s.E) x7).getDevices());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            X x8 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x8).addDevice((d0) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            X x9 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            E.d(obj3, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x9).removeDevice((d0) obj3);
                                listA3 = G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        default:
                            X x10 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            E.d(obj4, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            d0 d0Var = (d0) obj4;
                            Object obj5 = list.get(1);
                            E.d(obj5, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x10).updateDevice(d0Var, (d0) obj5);
                                listA4 = G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterWifiManager.removeDevice", strConcat), getCodec());
        if (x6 != null) {
            final int i7 = 2;
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.V
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    switch (i7) {
                        case 0:
                            X x7 = x6;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((p102s.E) x7).getDevices());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            X x8 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x8).addDevice((d0) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            X x9 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            E.d(obj3, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x9).removeDevice((d0) obj3);
                                listA3 = G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        default:
                            X x10 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            E.d(obj4, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            d0 d0Var = (d0) obj4;
                            Object obj5 = list.get(1);
                            E.d(obj5, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x10).updateDevice(d0Var, (d0) obj5);
                                listA4 = G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterWifiManager.updateDevice", strConcat), getCodec());
        if (x6 != null) {
            final int i8 = 3;
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.V
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    switch (i8) {
                        case 0:
                            X x7 = x6;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((p102s.E) x7).getDevices());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            X x8 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x8).addDevice((d0) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            X x9 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            E.d(obj3, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x9).removeDevice((d0) obj3);
                                listA3 = G.listOf(null);
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        default:
                            X x10 = x6;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj4 = list.get(0);
                            E.d(obj4, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            d0 d0Var = (d0) obj4;
                            Object obj5 = list.get(1);
                            E.d(obj5, "null cannot be cast to non-null type com.appdev.flutter.pigeon.WifiDevice");
                            try {
                                ((p102s.E) x10).updateDevice(d0Var, (d0) obj5);
                                listA4 = G.listOf(null);
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
    }
}
