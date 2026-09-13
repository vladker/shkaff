package p108t;

import A3.AbstractC0157z;
import S2.d;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import kotlin.jvm.internal.E;
import org.apache.poi.openxml4j.opc.g;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C f8511a = new C();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(19));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, D d) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, d, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, D d, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelUtil.createLabelFromImage", messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : ""), getCodec());
        if (d != null) {
            basicMessageChannel.setMessageHandler(new g(d, 11));
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
    }
}
