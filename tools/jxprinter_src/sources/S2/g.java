package S2;

import A3.AbstractC0157z;
import A3.G;
import com.alibaba.android.arouter.utils.Consts;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.jvm.internal.E;
import p007a4.AbstractC0272e;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ g f639a = new g();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(0));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, h hVar) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, hVar, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final h hVar, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.uri_content.UriContentPlatformApi.registerRequest", strConcat), getCodec());
        if (hVar != null) {
            final int i5 = 0;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: S2.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List<Object> listWrapError;
                    switch (i5) {
                        case 0:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).registerRequest(str, jLongValue, ((Long) obj4).longValue(), new f(reply, 3));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).requestNextChunk(((Long) obj5).longValue(), new f(reply, 0));
                            break;
                        case 2:
                            h hVar2 = hVar;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                A a6 = (A) hVar2;
                                AbstractC0272e.b(a6, null, 3, new m(a6, ((Long) obj6).longValue(), null));
                                listWrapError = G.listOf(null);
                            } catch (Throwable th) {
                                listWrapError = j.INSTANCE.wrapError(th);
                            }
                            reply.reply(listWrapError);
                            break;
                        case 3:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj7 = ((List) obj).get(0);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            f fVar = new f(reply, 1);
                            ((A) hVar).getContentLength((String) obj7, fVar);
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            f fVar2 = new f(reply, 2);
                            ((A) hVar).exists((String) obj8, fVar2);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.uri_content.UriContentPlatformApi.requestNextChunk", strConcat), getCodec());
        if (hVar != null) {
            final int i6 = 1;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: S2.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List<Object> listWrapError;
                    switch (i6) {
                        case 0:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).registerRequest(str, jLongValue, ((Long) obj4).longValue(), new f(reply, 3));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).requestNextChunk(((Long) obj5).longValue(), new f(reply, 0));
                            break;
                        case 2:
                            h hVar2 = hVar;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                A a6 = (A) hVar2;
                                AbstractC0272e.b(a6, null, 3, new m(a6, ((Long) obj6).longValue(), null));
                                listWrapError = G.listOf(null);
                            } catch (Throwable th) {
                                listWrapError = j.INSTANCE.wrapError(th);
                            }
                            reply.reply(listWrapError);
                            break;
                        case 3:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj7 = ((List) obj).get(0);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            f fVar = new f(reply, 1);
                            ((A) hVar).getContentLength((String) obj7, fVar);
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            f fVar2 = new f(reply, 2);
                            ((A) hVar).exists((String) obj8, fVar2);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.uri_content.UriContentPlatformApi.cancelRequest", strConcat), getCodec());
        if (hVar != null) {
            final int i7 = 2;
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: S2.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List<Object> listWrapError;
                    switch (i7) {
                        case 0:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).registerRequest(str, jLongValue, ((Long) obj4).longValue(), new f(reply, 3));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).requestNextChunk(((Long) obj5).longValue(), new f(reply, 0));
                            break;
                        case 2:
                            h hVar2 = hVar;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                A a6 = (A) hVar2;
                                AbstractC0272e.b(a6, null, 3, new m(a6, ((Long) obj6).longValue(), null));
                                listWrapError = G.listOf(null);
                            } catch (Throwable th) {
                                listWrapError = j.INSTANCE.wrapError(th);
                            }
                            reply.reply(listWrapError);
                            break;
                        case 3:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj7 = ((List) obj).get(0);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            f fVar = new f(reply, 1);
                            ((A) hVar).getContentLength((String) obj7, fVar);
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            f fVar2 = new f(reply, 2);
                            ((A) hVar).exists((String) obj8, fVar2);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.uri_content.UriContentPlatformApi.getContentLength", strConcat), getCodec());
        if (hVar != null) {
            final int i8 = 3;
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: S2.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List<Object> listWrapError;
                    switch (i8) {
                        case 0:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).registerRequest(str, jLongValue, ((Long) obj4).longValue(), new f(reply, 3));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).requestNextChunk(((Long) obj5).longValue(), new f(reply, 0));
                            break;
                        case 2:
                            h hVar2 = hVar;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                A a6 = (A) hVar2;
                                AbstractC0272e.b(a6, null, 3, new m(a6, ((Long) obj6).longValue(), null));
                                listWrapError = G.listOf(null);
                            } catch (Throwable th) {
                                listWrapError = j.INSTANCE.wrapError(th);
                            }
                            reply.reply(listWrapError);
                            break;
                        case 3:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj7 = ((List) obj).get(0);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            f fVar = new f(reply, 1);
                            ((A) hVar).getContentLength((String) obj7, fVar);
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            f fVar2 = new f(reply, 2);
                            ((A) hVar).exists((String) obj8, fVar2);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.uri_content.UriContentPlatformApi.exists", strConcat), getCodec());
        if (hVar != null) {
            final int i9 = 4;
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: S2.e
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List<Object> listWrapError;
                    switch (i9) {
                        case 0:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj2 = list.get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj2;
                            Object obj3 = list.get(1);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.Long");
                            long jLongValue = ((Long) obj3).longValue();
                            Object obj4 = list.get(2);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).registerRequest(str, jLongValue, ((Long) obj4).longValue(), new f(reply, 3));
                            break;
                        case 1:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj5 = ((List) obj).get(0);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.Long");
                            ((A) hVar).requestNextChunk(((Long) obj5).longValue(), new f(reply, 0));
                            break;
                        case 2:
                            h hVar2 = hVar;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj6 = ((List) obj).get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.Long");
                            try {
                                A a6 = (A) hVar2;
                                AbstractC0272e.b(a6, null, 3, new m(a6, ((Long) obj6).longValue(), null));
                                listWrapError = G.listOf(null);
                            } catch (Throwable th) {
                                listWrapError = j.INSTANCE.wrapError(th);
                            }
                            reply.reply(listWrapError);
                            break;
                        case 3:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj7 = ((List) obj).get(0);
                            E.d(obj7, "null cannot be cast to non-null type kotlin.String");
                            f fVar = new f(reply, 1);
                            ((A) hVar).getContentLength((String) obj7, fVar);
                            break;
                        default:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            f fVar2 = new f(reply, 2);
                            ((A) hVar).exists((String) obj8, fVar2);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
    }
}
