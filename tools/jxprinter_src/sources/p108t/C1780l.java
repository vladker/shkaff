package p108t;

import A3.AbstractC0157z;
import S2.d;
import S2.f;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.E;
import p102s.C1633f;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: renamed from: t.l, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1780l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C1780l f8531a = new C1780l();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(13));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, InterfaceC1781m interfaceC1781m) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, interfaceC1781m, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final InterfaceC1781m interfaceC1781m, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterBluetoothScanner.startScan", strConcat), getCodec());
        if (interfaceC1781m != null) {
            final int i5 = 0;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.k
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    long jLongValue;
                    long jLongValue2;
                    switch (i5) {
                        case 0:
                            E.f(reply, "reply");
                            ((C1633f) interfaceC1781m).startScan(new f(reply, 17));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            if (obj2 instanceof Integer) {
                                jLongValue = ((Number) obj2).intValue();
                            } else {
                                E.d(obj2, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj2).longValue();
                            }
                            ((C1633f) interfaceC1781m).stopScan(jLongValue, new f(reply, 16));
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            if (obj3 instanceof Integer) {
                                jLongValue2 = ((Number) obj3).intValue();
                            } else {
                                E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue2 = ((Long) obj3).longValue();
                            }
                            ((C1633f) interfaceC1781m).getDevice(jLongValue2, new f(reply, 18));
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterBluetoothScanner.stopScan", strConcat), getCodec());
        if (interfaceC1781m != null) {
            final int i6 = 1;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.k
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    long jLongValue;
                    long jLongValue2;
                    switch (i6) {
                        case 0:
                            E.f(reply, "reply");
                            ((C1633f) interfaceC1781m).startScan(new f(reply, 17));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            if (obj2 instanceof Integer) {
                                jLongValue = ((Number) obj2).intValue();
                            } else {
                                E.d(obj2, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj2).longValue();
                            }
                            ((C1633f) interfaceC1781m).stopScan(jLongValue, new f(reply, 16));
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            if (obj3 instanceof Integer) {
                                jLongValue2 = ((Number) obj3).intValue();
                            } else {
                                E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue2 = ((Long) obj3).longValue();
                            }
                            ((C1633f) interfaceC1781m).getDevice(jLongValue2, new f(reply, 18));
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterBluetoothScanner.getDevice", strConcat), getCodec());
        if (interfaceC1781m != null) {
            final int i7 = 2;
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.k
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    long jLongValue;
                    long jLongValue2;
                    switch (i7) {
                        case 0:
                            E.f(reply, "reply");
                            ((C1633f) interfaceC1781m).startScan(new f(reply, 17));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            if (obj2 instanceof Integer) {
                                jLongValue = ((Number) obj2).intValue();
                            } else {
                                E.d(obj2, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj2).longValue();
                            }
                            ((C1633f) interfaceC1781m).stopScan(jLongValue, new f(reply, 16));
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj3 = ((List) obj).get(0);
                            if (obj3 instanceof Integer) {
                                jLongValue2 = ((Number) obj3).intValue();
                            } else {
                                E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue2 = ((Long) obj3).longValue();
                            }
                            ((C1633f) interfaceC1781m).getDevice(jLongValue2, new f(reply, 18));
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
    }
}
