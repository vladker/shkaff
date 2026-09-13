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
import org.apache.poi.xssf.usermodel.b;
import p102s.C1631d;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: renamed from: t.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1777i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C1777i f8529a = new C1777i();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(12));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, InterfaceC1778j interfaceC1778j) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, interfaceC1778j, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final InterfaceC1778j interfaceC1778j, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterAsr.initialize", strConcat), getCodec());
        if (interfaceC1778j != null) {
            final int i5 = 0;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.h
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    switch (i5) {
                        case 0:
                            InterfaceC1778j interfaceC1778j2 = interfaceC1778j;
                            E.f(reply, "reply");
                            try {
                                interfaceC1778j2.getClass();
                                listA = G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        default:
                            E.f(reply, "reply");
                            ((C1631d) interfaceC1778j).listen(new f(reply, 15));
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterAsr.listen", strConcat), getCodec());
        if (interfaceC1778j != null) {
            final int i6 = 1;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.h
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    switch (i6) {
                        case 0:
                            InterfaceC1778j interfaceC1778j2 = interfaceC1778j;
                            E.f(reply, "reply");
                            try {
                                interfaceC1778j2.getClass();
                                listA = G.listOf(null);
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        default:
                            E.f(reply, "reply");
                            ((C1631d) interfaceC1778j).listen(new f(reply, 15));
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterAsr.stop", strConcat), getCodec());
        if (interfaceC1778j != null) {
            basicMessageChannel3.setMessageHandler(new b(interfaceC1778j, 25));
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
    }
}
