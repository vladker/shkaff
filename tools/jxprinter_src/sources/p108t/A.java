package p108t;

import A3.AbstractC0157z;
import S2.d;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import kotlin.jvm.internal.E;
import org.apache.poi.openxml4j.opc.g;
import org.apache.poi.xssf.usermodel.b;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ A f8510a = new A();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(18));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, B b) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, b, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, B b, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.setSingleSelectMode", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel.setMessageHandler(new g(b, 10));
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.merge", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel2.setMessageHandler(new C1793z(b, 1));
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.split", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel3.setMessageHandler(new C1793z(b, 2));
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.addRowOnTop", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel4.setMessageHandler(new C1793z(b, 3));
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.removeRowOnTop", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel5.setMessageHandler(new C1793z(b, 4));
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.addRowOnButtom", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel6.setMessageHandler(new C1793z(b, 5));
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.removeRowOnButtom", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel7.setMessageHandler(new C1793z(b, 6));
        } else {
            basicMessageChannel7.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.addColumnOnLeft", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel8.setMessageHandler(new b(b, 26));
        } else {
            basicMessageChannel8.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.removeColumnOnLeft", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel9.setMessageHandler(new b(b, 27));
        } else {
            basicMessageChannel9.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.addColumnOnRight", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel10.setMessageHandler(new b(b, 28));
        } else {
            basicMessageChannel10.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.removeColumnOnRight", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel11.setMessageHandler(new b(b, 29));
        } else {
            basicMessageChannel11.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterLabelTableUtil.showLine", strConcat), getCodec());
        if (b != null) {
            basicMessageChannel12.setMessageHandler(new C1793z(b, 0));
        } else {
            basicMessageChannel12.setMessageHandler(null);
        }
    }
}
