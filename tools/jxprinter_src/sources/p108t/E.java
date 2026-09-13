package p108t;

import A3.AbstractC0157z;
import S2.d;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import org.apache.poi.openxml4j.opc.g;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ E f8512a = new E();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(20));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, F f6) {
        kotlin.jvm.internal.E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, f6, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, F f6, String messageChannelSuffix) {
        kotlin.jvm.internal.E.f(binaryMessenger, "binaryMessenger");
        kotlin.jvm.internal.E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLoadingUtil.showTipText", strConcat), getCodec());
        if (f6 != null) {
            basicMessageChannel.setMessageHandler(new g(f6, 12));
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLoadingUtil.hidden", strConcat), getCodec());
        if (f6 != null) {
            basicMessageChannel2.setMessageHandler(new C1793z(f6, 7));
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
    }
}
