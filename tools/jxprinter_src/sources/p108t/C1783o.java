package p108t;

import A3.AbstractC0157z;
import A3.G;
import S2.d;
import S2.f;
import com.alibaba.android.arouter.utils.Consts;
import com.bumptech.glide.g;
import com.orhanobut.hawk.Hawk;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import p102s.h;
import p147z3.AbstractC1935o;
import p147z3.InterfaceC1934n;

/* JADX INFO: renamed from: t.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class C1783o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ C1783o f8533a = new C1783o();
    private static final InterfaceC1934n codec$delegate = AbstractC1935o.lazy(new d(14));

    public final MessageCodec<Object> getCodec() {
        return (MessageCodec) codec$delegate.getValue();
    }

    public final void setUp(BinaryMessenger binaryMessenger, InterfaceC1784p interfaceC1784p) {
        E.f(binaryMessenger, "binaryMessenger");
        setUp(binaryMessenger, interfaceC1784p, "");
    }

    public final void setUp(BinaryMessenger binaryMessenger, final InterfaceC1784p interfaceC1784p, String messageChannelSuffix) {
        E.f(binaryMessenger, "binaryMessenger");
        E.f(messageChannelSuffix, "messageChannelSuffix");
        String strConcat = messageChannelSuffix.length() > 0 ? Consts.DOT.concat(messageChannelSuffix) : "";
        BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.getPlatformType", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i5 = 8;
            basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i5) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.getCachePath", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i6 = 16;
            basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i6) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel2.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.getLanguage", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i7 = 0;
            basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i7) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel3.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.setLanguage", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i8 = 1;
            basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i8) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel4.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.getSystemLanguage", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i9 = 2;
            basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i9) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel5.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.getLanguageMode", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i10 = 3;
            basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i10) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel6.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.getWifiSsid", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i11 = 4;
            basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i11) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel7.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.showDialog", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i12 = 5;
            basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i12) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel8.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.showPromptDialog", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i13 = 6;
            basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i13) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel9.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.showBottomDialog", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i14 = 7;
            basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i14) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel10.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.needCameraPermission", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i15 = 9;
            basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i15) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel11.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.needBlueToothPermission", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i16 = 10;
            basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i16) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel12.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.needStoragePermission", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i17 = 11;
            basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i17) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel13.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.needPermission", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i18 = 12;
            basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i18) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel14.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.selectImage", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i19 = 13;
            basicMessageChannel15.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i19) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel15.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.get", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i20 = 14;
            basicMessageChannel16.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i20) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel16.setMessageHandler(null);
        }
        BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, AbstractC0157z.n("dev.flutter.pigeon.flutterui.FlutterEnv.set", strConcat), getCodec());
        if (interfaceC1784p != null) {
            final int i21 = 15;
            basicMessageChannel17.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: t.n
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    List listA;
                    List listA2;
                    List listA3;
                    List listA4;
                    long jLongValue;
                    List listA5;
                    List listA6;
                    List listA7;
                    List listA8;
                    switch (i21) {
                        case 0:
                            InterfaceC1784p interfaceC1784p2 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA = G.listOf(((h) interfaceC1784p2).getLanguage());
                            } catch (Throwable th) {
                                listA = g.a(th);
                            }
                            reply.reply(listA);
                            break;
                        case 1:
                            InterfaceC1784p interfaceC1784p3 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj2 = ((List) obj).get(0);
                            E.d(obj2, "null cannot be cast to non-null type kotlin.String");
                            try {
                                ((h) interfaceC1784p3).setLanguage((String) obj2);
                                listA2 = G.listOf(null);
                            } catch (Throwable th2) {
                                listA2 = g.a(th2);
                            }
                            reply.reply(listA2);
                            break;
                        case 2:
                            InterfaceC1784p interfaceC1784p4 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA3 = G.listOf(((h) interfaceC1784p4).getSystemLanguage());
                            } catch (Throwable th3) {
                                listA3 = g.a(th3);
                            }
                            reply.reply(listA3);
                            break;
                        case 3:
                            InterfaceC1784p interfaceC1784p5 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA4 = G.listOf(((h) interfaceC1784p5).getLanguageMode());
                            } catch (Throwable th4) {
                                listA4 = g.a(th4);
                            }
                            reply.reply(listA4);
                            break;
                        case 4:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).getWifiSsid(new f(reply, 19));
                            break;
                        case 5:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list = (List) obj;
                            Object obj3 = list.get(0);
                            E.d(obj3, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showDialog((String) obj3, (Map) list.get(1), new f(reply, 26));
                            break;
                        case 6:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list2 = (List) obj;
                            Object obj4 = list2.get(0);
                            E.d(obj4, "null cannot be cast to non-null type kotlin.String");
                            Object obj5 = list2.get(1);
                            E.d(obj5, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).showPromptDialog((String) obj4, (String) obj5, new f(reply, 24));
                            break;
                        case 7:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list3 = (List) obj;
                            Object obj6 = list3.get(0);
                            E.d(obj6, "null cannot be cast to non-null type kotlin.String");
                            String str = (String) obj6;
                            Object obj7 = list3.get(1);
                            if (obj7 instanceof Integer) {
                                jLongValue = ((Number) obj7).intValue();
                            } else {
                                E.d(obj7, "null cannot be cast to non-null type kotlin.Long");
                                jLongValue = ((Long) obj7).longValue();
                            }
                            ((h) interfaceC1784p).showBottomDialog(str, jLongValue, (Map) list3.get(2), new f(reply, 20));
                            break;
                        case 8:
                            InterfaceC1784p interfaceC1784p6 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                ((h) interfaceC1784p6).getClass();
                                String str2 = (String) Hawk.get("appType");
                                if (str2 == null) {
                                    str2 = "sanduOverseas";
                                }
                                listA5 = G.listOf(Long.valueOf(str2.equals("sanduOverseas") ? ((Long) 3).longValue() : ((Long) 1).longValue()));
                            } catch (Throwable th5) {
                                listA5 = g.a(th5);
                            }
                            reply.reply(listA5);
                            break;
                        case 9:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj8 = ((List) obj).get(0);
                            E.d(obj8, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needCameraPermission((String) obj8, new f(reply, 21));
                            break;
                        case 10:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj9 = ((List) obj).get(0);
                            E.d(obj9, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needBlueToothPermission((String) obj9, new f(reply, 22));
                            break;
                        case 11:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            Object obj10 = ((List) obj).get(0);
                            E.d(obj10, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needStoragePermission((String) obj10, new f(reply, 27));
                            break;
                        case 12:
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list4 = (List) obj;
                            Object obj11 = list4.get(0);
                            E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                            Object obj12 = list4.get(1);
                            E.d(obj12, "null cannot be cast to non-null type kotlin.String");
                            ((h) interfaceC1784p).needPermission((List) obj11, (String) obj12, new f(reply, 23));
                            break;
                        case 13:
                            E.f(reply, "reply");
                            ((h) interfaceC1784p).selectImage(new f(reply, 25));
                            break;
                        case 14:
                            InterfaceC1784p interfaceC1784p7 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list5 = (List) obj;
                            Object obj13 = list5.get(0);
                            E.d(obj13, "null cannot be cast to non-null type kotlin.String");
                            String str3 = (String) obj13;
                            Object obj14 = list5.get(1);
                            E.d(obj14, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                listA6 = G.listOf(((h) interfaceC1784p7).get(str3, obj14));
                            } catch (Throwable th6) {
                                listA6 = g.a(th6);
                            }
                            reply.reply(listA6);
                            break;
                        case 15:
                            InterfaceC1784p interfaceC1784p8 = interfaceC1784p;
                            E.f(reply, "reply");
                            E.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                            List list6 = (List) obj;
                            Object obj15 = list6.get(0);
                            E.d(obj15, "null cannot be cast to non-null type kotlin.String");
                            String str4 = (String) obj15;
                            Object obj16 = list6.get(1);
                            E.d(obj16, "null cannot be cast to non-null type kotlin.Any");
                            try {
                                ((h) interfaceC1784p8).set(str4, obj16);
                                listA7 = G.listOf(null);
                            } catch (Throwable th7) {
                                listA7 = g.a(th7);
                            }
                            reply.reply(listA7);
                            break;
                        default:
                            InterfaceC1784p interfaceC1784p9 = interfaceC1784p;
                            E.f(reply, "reply");
                            try {
                                listA8 = G.listOf(((h) interfaceC1784p9).getCachePath());
                            } catch (Throwable th8) {
                                listA8 = g.a(th8);
                            }
                            reply.reply(listA8);
                            break;
                    }
                }
            });
        } else {
            basicMessageChannel17.setMessageHandler(null);
        }
    }
}
