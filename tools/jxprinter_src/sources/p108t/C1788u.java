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
import p102s.l;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: renamed from: t.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1788u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C1788u f8537a = new C1788u();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(16));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, InterfaceC1789v interfaceC1789v) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, interfaceC1789v, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final InterfaceC1789v interfaceC1789v, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterHttp.getHeaders", strConcat), getCodec());
        if (interfaceC1789v != null) {
            final int i5 = 0;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.t
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    switch (i5) {
                        case 0:
                            InterfaceC1789v interfaceC1789v2 = interfaceC1789v;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((l) interfaceC1789v2).getHeaders());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        default:
                            InterfaceC1789v interfaceC1789v3 = interfaceC1789v;
                            E.f(reply, "reply");
                            try {
                                listA2 = G.listOf(((l) interfaceC1789v3).getBaseUrl());
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterHttp.getBaseUrl", strConcat), getCodec());
        if (interfaceC1789v != null) {
            final int i6 = 1;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.t
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    switch (i6) {
                        case 0:
                            InterfaceC1789v interfaceC1789v2 = interfaceC1789v;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((l) interfaceC1789v2).getHeaders());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        default:
                            InterfaceC1789v interfaceC1789v3 = interfaceC1789v;
                            E.f(reply, "reply");
                            try {
                                listA2 = G.listOf(((l) interfaceC1789v3).getBaseUrl());
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
