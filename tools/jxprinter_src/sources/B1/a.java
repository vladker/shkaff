package B1;

import A1.c;
import A3.J;
import A3.T;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.flutter.plugin.common.MethodCall;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.E;
import p145z1.b;
import p145z1.d;
import p145z1.e;
import p145z1.f;
import p145z1.j;
import p145z1.k;
import p145z1.l;
import p145z1.m;
import p145z1.n;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a INSTANCE = new a();

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T asValue(Object obj) {
        E.f(obj, "<this>");
        return obj;
    }

    public final List<k> convertMapOption(List<? extends Object> optionList, p133x1.a bitmapWrapper) {
        p145z1.a aVar;
        Paint.Align align;
        E.f(optionList, "optionList");
        E.f(bitmapWrapper, "bitmapWrapper");
        ArrayList arrayList = new ArrayList();
        int i5 = bitmapWrapper.f8841a;
        if (i5 != 0) {
            arrayList.add(new l(i5));
        }
        e flipOption = bitmapWrapper.getFlipOption();
        if (flipOption.f9105a && flipOption.b) {
            arrayList.add(bitmapWrapper.getFlipOption());
        }
        for (Object obj : optionList) {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                Object obj2 = map.get("value");
                if (obj2 instanceof Map) {
                    Object obj3 = map.get("type");
                    if (E.a(obj3, "flip")) {
                        Map map2 = (Map) obj2;
                        Object obj4 = map2.get("h");
                        E.d(obj4, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue = ((Boolean) obj4).booleanValue();
                        Object obj5 = map2.get("v");
                        E.d(obj5, "null cannot be cast to non-null type kotlin.Boolean");
                        arrayList.add(new e(zBooleanValue, ((Boolean) obj5).booleanValue()));
                    } else if (E.a(obj3, "clip")) {
                        Map map3 = (Map) obj2;
                        Object obj6 = map3.get("width");
                        E.d(obj6, "null cannot be cast to non-null type kotlin.Number");
                        int iIntValue = ((Number) obj6).intValue();
                        Object obj7 = map3.get("height");
                        E.d(obj7, "null cannot be cast to non-null type kotlin.Number");
                        int iIntValue2 = ((Number) obj7).intValue();
                        Object obj8 = map3.get("x");
                        E.d(obj8, "null cannot be cast to non-null type kotlin.Number");
                        int iIntValue3 = ((Number) obj8).intValue();
                        Object obj9 = map3.get("y");
                        E.d(obj9, "null cannot be cast to non-null type kotlin.Number");
                        arrayList.add(new b(iIntValue3, ((Number) obj9).intValue(), iIntValue, iIntValue2));
                    } else if (E.a(obj3, "rotate")) {
                        Object obj10 = ((Map) obj2).get("degree");
                        E.d(obj10, "null cannot be cast to non-null type kotlin.Int");
                        arrayList.add(new l(((Integer) obj10).intValue()));
                    } else if (E.a(obj3, TypedValues.Custom.S_COLOR)) {
                        Object obj11 = ((Map) obj2).get("matrix");
                        E.d(obj11, "null cannot be cast to non-null type kotlin.collections.List<*>");
                        List list = (List) obj11;
                        ArrayList arrayList2 = new ArrayList(J.collectionSizeOrDefault(list, 10));
                        for (Object obj12 : list) {
                            arrayList2.add(Float.valueOf(obj12 instanceof Double ? (float) ((Number) obj12).doubleValue() : 0.0f));
                        }
                        arrayList.add(new d(T.toFloatArray(arrayList2)));
                    } else if (E.a(obj3, "scale")) {
                        Map map4 = (Map) obj2;
                        Object obj13 = map4.get("width");
                        E.d(obj13, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue4 = ((Integer) obj13).intValue();
                        Object obj14 = map4.get("height");
                        E.d(obj14, "null cannot be cast to non-null type kotlin.Int");
                        int iIntValue5 = ((Integer) obj14).intValue();
                        Object obj15 = map4.get("keepRatio");
                        E.d(obj15, "null cannot be cast to non-null type kotlin.Boolean");
                        boolean zBooleanValue2 = ((Boolean) obj15).booleanValue();
                        Object obj16 = map4.get("keepWidthFirst");
                        E.d(obj16, "null cannot be cast to non-null type kotlin.Boolean");
                        arrayList.add(new m(iIntValue4, iIntValue5, zBooleanValue2, ((Boolean) obj16).booleanValue()));
                    } else if (E.a(obj3, "add_text")) {
                        Object obj17 = ((Map) obj2).get("texts");
                        E.c(obj17);
                        List list2 = (List) asValue(obj17);
                        if (list2.isEmpty()) {
                            aVar = null;
                        } else {
                            p145z1.a aVar2 = new p145z1.a();
                            for (Object obj18 : list2) {
                                if (obj18 instanceof Map) {
                                    Map map5 = (Map) obj18;
                                    Object obj19 = map5.get("text");
                                    E.c(obj19);
                                    String str = (String) asValue(obj19);
                                    Object obj20 = map5.get("x");
                                    E.c(obj20);
                                    int iIntValue6 = ((Number) asValue(obj20)).intValue();
                                    Object obj21 = map5.get("y");
                                    E.c(obj21);
                                    int iIntValue7 = ((Number) asValue(obj21)).intValue();
                                    Object obj22 = map5.get("size");
                                    E.c(obj22);
                                    int iIntValue8 = ((Number) asValue(obj22)).intValue();
                                    Object obj23 = map5.get("r");
                                    E.c(obj23);
                                    int iIntValue9 = ((Number) asValue(obj23)).intValue();
                                    Object obj24 = map5.get("g");
                                    E.c(obj24);
                                    int iIntValue10 = ((Number) asValue(obj24)).intValue();
                                    Object obj25 = map5.get("b");
                                    E.c(obj25);
                                    int iIntValue11 = ((Number) asValue(obj25)).intValue();
                                    Object obj26 = map5.get("a");
                                    E.c(obj26);
                                    int iIntValue12 = ((Number) asValue(obj26)).intValue();
                                    Object obj27 = map5.get("fontName");
                                    E.c(obj27);
                                    String str2 = (String) asValue(obj27);
                                    Object obj28 = map5.get("textAlign");
                                    E.c(obj28);
                                    if (E.a(obj28, "left")) {
                                        align = Paint.Align.LEFT;
                                    } else if (E.a(obj28, "center")) {
                                        align = Paint.Align.CENTER;
                                    } else {
                                        align = E.a(obj28, "right") ? Paint.Align.RIGHT : Paint.Align.LEFT;
                                    }
                                    aVar2.addText(new n(str, iIntValue6, iIntValue7, iIntValue8, iIntValue9, iIntValue10, iIntValue11, iIntValue12, str2, align));
                                }
                            }
                            aVar = aVar2;
                        }
                        if (aVar != null) {
                            arrayList.add(aVar);
                        }
                    } else if (E.a(obj3, "mix_image")) {
                        arrayList.add(new j((Map) obj2));
                    } else if (E.a(obj3, "draw")) {
                        arrayList.add(new c((Map) obj2));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final PorterDuff.Mode convertToPorterDuffMode(String type) {
        E.f(type, "type");
        switch (type.hashCode()) {
            case -1954086600:
                if (type.equals("srcATop")) {
                    return PorterDuff.Mode.SRC_ATOP;
                }
                break;
            case -1953637160:
                if (type.equals("srcOver")) {
                    return PorterDuff.Mode.SRC_OVER;
                }
                break;
            case -1338968417:
                if (type.equals("darken")) {
                    return PorterDuff.Mode.DARKEN;
                }
                break;
            case -1322311863:
                if (type.equals("dstOut")) {
                    return PorterDuff.Mode.DST_OUT;
                }
                break;
            case -1091287984:
                if (type.equals("overlay")) {
                    return PorterDuff.Mode.OVERLAY;
                }
                break;
            case -907689876:
                if (type.equals("screen")) {
                    return PorterDuff.Mode.SCREEN;
                }
                break;
            case -894304566:
                if (type.equals("srcOut")) {
                    return PorterDuff.Mode.SRC_OUT;
                }
                break;
            case 99781:
                if (type.equals("dst")) {
                    return PorterDuff.Mode.DST;
                }
                break;
            case 114148:
                if (type.equals("src")) {
                    return PorterDuff.Mode.SRC;
                }
                break;
            case 118875:
                if (type.equals("xor")) {
                    return PorterDuff.Mode.XOR;
                }
                break;
            case 94746189:
                if (type.equals("clear")) {
                    return PorterDuff.Mode.CLEAR;
                }
                break;
            case 95891914:
                if (type.equals("dstIn")) {
                    return PorterDuff.Mode.DST_IN;
                }
                break;
            case 109698601:
                if (type.equals("srcIn")) {
                    return PorterDuff.Mode.SRC_IN;
                }
                break;
            case 170546239:
                if (type.equals("lighten")) {
                    return PorterDuff.Mode.LIGHTEN;
                }
                break;
            case 653829668:
                if (type.equals("multiply")) {
                    return PorterDuff.Mode.MULTIPLY;
                }
                break;
            case 1957556377:
                if (type.equals("dstATop")) {
                    return PorterDuff.Mode.DST_ATOP;
                }
                break;
            case 1958005817:
                if (type.equals("dstOver")) {
                    return PorterDuff.Mode.DST_OVER;
                }
                break;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public final f getFormatOption(MethodCall call) {
        E.f(call, "call");
        Object objArgument = call.argument("fmt");
        E.c(objArgument);
        return new f((Map) objArgument);
    }
}
