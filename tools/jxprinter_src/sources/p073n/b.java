package p073n;

import A3.AbstractC0157z;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.serialization.json.internal.AbstractC1125a;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.ss.formula.functions.Complex;
import p061l.a;
import p061l.f;
import p067m.e;
import p067m.i;
import p067m.k;
import p096r.c;
import p096r.d;
import p096r.g;
import p096r.j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final String c = c.e(p067m.b.class);
    public static final String d = c.e(e.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p096r.b f6185a;
    public final AtomicLong b = new AtomicLong();

    public b(p096r.b bVar) {
        this.f6185a = bVar;
    }

    public static void a(a aVar, p061l.e eVar, boolean z6) {
        int length = aVar.f6184f.length;
        for (int i5 = 0; i5 < length; i5++) {
            p061l.c cVar = new p061l.c();
            if (z6) {
                eVar.i(21, aVar.b("_asm_flag_" + (i5 / 32)));
                eVar.f(Integer.valueOf(1 << i5));
                eVar.b(126);
                eVar.d(153, cVar);
            }
            d dVar = aVar.f6184f[i5];
            Class cls = dVar.e;
            Method method = dVar.b;
            String str = dVar.f7884a;
            Type type = dVar.f7885f;
            if (cls == Boolean.TYPE) {
                eVar.i(25, aVar.b("instance"));
                eVar.i(21, aVar.b(str + "_asm"));
                k(eVar, dVar);
            } else if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE || cls == Character.TYPE) {
                eVar.i(25, aVar.b("instance"));
                eVar.i(21, aVar.b(str + "_asm"));
                k(eVar, dVar);
            } else if (cls == Long.TYPE) {
                eVar.i(25, aVar.b("instance"));
                eVar.i(22, aVar.a(str + "_asm"));
                if (method != null) {
                    Class cls2 = aVar.d.b;
                    if (cls2 == null) {
                        cls2 = aVar.c;
                    }
                    eVar.g(182, c.e(cls2), method.getName(), c.c(method));
                    if (!method.getReturnType().equals(Void.TYPE)) {
                        eVar.b(87);
                    }
                } else {
                    eVar.a(181, c.e(dVar.f7886g), dVar.c.getName(), c.b(dVar.e));
                }
            } else if (cls == Float.TYPE) {
                eVar.i(25, aVar.b("instance"));
                eVar.i(23, aVar.b(str + "_asm"));
                k(eVar, dVar);
            } else if (cls == Double.TYPE) {
                eVar.i(25, aVar.b("instance"));
                eVar.i(24, aVar.a(str + "_asm"));
                k(eVar, dVar);
            } else if (cls == String.class) {
                eVar.i(25, aVar.b("instance"));
                eVar.i(25, aVar.b(str + "_asm"));
                k(eVar, dVar);
            } else if (cls.isEnum()) {
                eVar.i(25, aVar.b("instance"));
                eVar.i(25, aVar.b(str + "_asm"));
                k(eVar, dVar);
            } else if (Collection.class.isAssignableFrom(cls)) {
                eVar.i(25, aVar.b("instance"));
                if (j.r(type) == String.class) {
                    eVar.i(25, aVar.b(str + "_asm"));
                    eVar.h(192, c.e(cls));
                } else {
                    eVar.i(25, aVar.b(str + "_asm"));
                }
                k(eVar, dVar);
            } else {
                eVar.i(25, aVar.b("instance"));
                eVar.i(25, aVar.b(str + "_asm"));
                k(eVar, dVar);
            }
            if (z6) {
                eVar.e(cVar);
            }
        }
    }

    public static void b(a aVar, p061l.e eVar) {
        Class cls = aVar.c;
        g gVar = aVar.d;
        Constructor constructor = gVar.c;
        if (Modifier.isPublic(constructor.getModifiers())) {
            Class cls2 = gVar.b;
            if (cls2 != null) {
                cls = cls2;
            }
            eVar.h(187, c.e(cls));
            eVar.b(89);
            eVar.g(183, c.e(constructor.getDeclaringClass()), "<init>", "()V");
            eVar.i(58, aVar.b("instance"));
            return;
        }
        eVar.i(25, 0);
        eVar.i(25, 1);
        eVar.i(25, 0);
        eVar.a(180, c.e(m.class), "clazz", "Ljava/lang/Class;");
        eVar.g(183, c.e(m.class), "createInstance", AbstractC0157z.s(new StringBuilder("(L"), c, ";Ljava/lang/reflect/Type;)Ljava/lang/Object;"));
        Class cls3 = gVar.b;
        if (cls3 != null) {
            cls = cls3;
        }
        eVar.h(192, c.e(cls));
        eVar.i(58, aVar.b("instance"));
    }

    public static void c(a aVar, p061l.e eVar, d dVar, Class cls, int i5) {
        int i6;
        g(aVar, eVar, dVar);
        Class cls2 = dVar.e;
        Type type = dVar.f7885f;
        String str = dVar.f7884a;
        p061l.c cVar = new p061l.c();
        p061l.c cVar2 = new p061l.c();
        int i7 = dVar.f7889j;
        int i8 = p067m.c.SupportArrayToBean.f6089a & i7;
        String str2 = c;
        if (i8 != 0) {
            eVar.b(89);
            eVar.h(193, c.e(m.class));
            eVar.d(153, cVar);
            eVar.h(192, c.e(m.class));
            eVar.i(25, 1);
            if (type instanceof Class) {
                eVar.f(f.a(c.b(cls2)));
                i6 = 182;
            } else {
                eVar.i(25, 0);
                eVar.f(Integer.valueOf(i5));
                i6 = 182;
                eVar.g(182, c.e(m.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            }
            eVar.f(str);
            eVar.f(Integer.valueOf(i7));
            eVar.g(i6, c.e(m.class), "deserialze", AbstractC0157z.o("(L", str2, ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"));
            eVar.h(192, c.e(cls));
            eVar.i(58, aVar.b(str.concat("_asm")));
            eVar.d(167, cVar2);
            eVar.e(cVar);
        }
        eVar.i(25, 1);
        if (type instanceof Class) {
            eVar.f(f.a(c.b(cls2)));
        } else {
            eVar.i(25, 0);
            eVar.f(Integer.valueOf(i5));
            eVar.g(182, c.e(m.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
        }
        eVar.f(str);
        eVar.g(185, c.e(p.class), "deserialze", AbstractC0157z.o("(L", str2, ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;"));
        eVar.h(192, c.e(cls));
        eVar.i(58, aVar.b(str.concat("_asm")));
        eVar.e(cVar2);
    }

    public static void d(a aVar, p061l.e eVar, p061l.c cVar) {
        eVar.c(21, aVar.b("matchedCount"));
        eVar.d(158, cVar);
        eVar.i(25, aVar.b("lexer"));
        eVar.g(182, d, "token", "()I");
        eVar.f(13);
        eVar.d(160, cVar);
        j(aVar, eVar);
    }

    public static void e(a aVar, a aVar2) {
        String str;
        String str2;
        int i5;
        char c6;
        Integer num;
        int i6;
        Integer num2 = 14;
        Integer num3 = 16;
        String str3 = "(L";
        StringBuilder sb = new StringBuilder("(L");
        String str4 = c;
        p061l.e eVar = new p061l.e(aVar, "deserialzeArrayMapping", AbstractC0157z.s(sb, str4, ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"), null);
        m(aVar2, eVar);
        b(aVar2, eVar);
        d[] dVarArr = aVar2.d.f7916i;
        int length = dVarArr.length;
        int i7 = 0;
        while (true) {
            d[] dVarArr2 = dVarArr;
            String str5 = d;
            Integer num4 = num3;
            if (i7 >= length) {
                a(aVar2, eVar, false);
                p061l.c cVar = new p061l.c();
                p061l.c cVar2 = new p061l.c();
                p061l.c cVar3 = new p061l.c();
                p061l.c cVar4 = new p061l.c();
                eVar.i(25, aVar2.b("lexer"));
                eVar.g(182, str5, "getCurrent", "()C");
                eVar.b(89);
                eVar.i(54, aVar2.b("ch"));
                eVar.i(16, 44);
                eVar.d(160, cVar2);
                eVar.i(25, aVar2.b("lexer"));
                eVar.g(182, str5, "next", "()C");
                eVar.b(87);
                eVar.i(25, aVar2.b("lexer"));
                eVar.f(num4);
                eVar.g(182, str5, "setToken", "(I)V");
                eVar.d(167, cVar4);
                eVar.e(cVar2);
                eVar.i(21, aVar2.b("ch"));
                eVar.i(16, 93);
                eVar.d(160, cVar3);
                eVar.i(25, aVar2.b("lexer"));
                eVar.g(182, str5, "next", "()C");
                eVar.b(87);
                eVar.i(25, aVar2.b("lexer"));
                eVar.f(15);
                eVar.g(182, str5, "setToken", "(I)V");
                eVar.d(167, cVar4);
                eVar.e(cVar3);
                eVar.i(21, aVar2.b("ch"));
                eVar.i(16, 26);
                eVar.d(160, cVar);
                eVar.i(25, aVar2.b("lexer"));
                eVar.g(182, str5, "next", "()C");
                eVar.b(87);
                eVar.i(25, aVar2.b("lexer"));
                eVar.f(20);
                eVar.g(182, str5, "setToken", "(I)V");
                eVar.d(167, cVar4);
                eVar.e(cVar);
                eVar.i(25, aVar2.b("lexer"));
                eVar.f(num4);
                eVar.g(182, str5, "nextToken", "(I)V");
                eVar.e(cVar4);
                eVar.i(25, aVar2.b("instance"));
                eVar.b(176);
                int i8 = aVar2.f6183a;
                eVar.f5767h = 5;
                eVar.f5768i = i8;
                return;
            }
            int i9 = length;
            boolean z6 = i7 == length + (-1);
            int i10 = z6 ? 93 : 44;
            boolean z7 = z6;
            d dVar = dVarArr2[i7];
            int i11 = i7;
            Class cls = dVar.e;
            String str6 = dVar.f7884a;
            Integer num5 = num2;
            Type type = dVar.f7885f;
            if (cls == Byte.TYPE || cls == Short.TYPE || cls == Integer.TYPE) {
                str = str3;
                str2 = str4;
                num4 = num4;
                i5 = i11;
                c6 = 14;
                eVar.i(25, aVar2.b("lexer"));
                eVar.i(16, i10);
                eVar.i(54, AbstractC1125a.f(AbstractC1125a.j(eVar, 182, str5, "scanInt", "(C)I"), str6, "_asm", aVar2));
            } else {
                str = str3;
                if (cls == Long.TYPE) {
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    StringBuilder sbJ = AbstractC1125a.j(eVar, 182, str5, "scanLong", "(C)J");
                    sbJ.append(str6);
                    sbJ.append("_asm");
                    eVar.i(55, aVar2.a(sbJ.toString()));
                } else if (cls == Boolean.TYPE) {
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    eVar.i(54, AbstractC1125a.f(AbstractC1125a.j(eVar, 182, str5, "scanBoolean", "(C)Z"), str6, "_asm", aVar2));
                } else if (cls == Float.TYPE) {
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    eVar.i(56, AbstractC1125a.f(AbstractC1125a.j(eVar, 182, str5, "scanFloat", "(C)F"), str6, "_asm", aVar2));
                } else if (cls == Double.TYPE) {
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    StringBuilder sbJ2 = AbstractC1125a.j(eVar, 182, str5, "scanDouble", "(C)D");
                    sbJ2.append(str6);
                    sbJ2.append("_asm");
                    eVar.i(57, aVar2.a(sbJ2.toString()));
                } else if (cls == Character.TYPE) {
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    eVar.g(182, str5, "scanString", "(C)Ljava/lang/String;");
                    eVar.b(3);
                    eVar.i(54, AbstractC1125a.f(AbstractC1125a.j(eVar, 182, "java/lang/String", "charAt", "(I)C"), str6, "_asm", aVar2));
                } else if (cls == String.class) {
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    eVar.i(58, AbstractC1125a.f(AbstractC1125a.j(eVar, 182, str5, "scanString", "(C)Ljava/lang/String;"), str6, "_asm", aVar2));
                } else if (cls.isEnum()) {
                    p061l.c cVar5 = new p061l.c();
                    p061l.c cVar6 = new p061l.c();
                    p061l.c cVar7 = new p061l.c();
                    p061l.c cVar8 = new p061l.c();
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.g(182, str5, "getCurrent", "()C");
                    eVar.b(89);
                    eVar.i(54, aVar2.b("ch"));
                    eVar.f(110);
                    eVar.d(159, cVar8);
                    eVar.i(21, aVar2.b("ch"));
                    eVar.f(34);
                    eVar.d(160, cVar5);
                    eVar.e(cVar8);
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.f(f.a(c.b(cls)));
                    eVar.i(25, 1);
                    eVar.g(182, str4, "getSymbolTable", "()" + c.b(k.class));
                    eVar.i(16, i10);
                    eVar.g(182, str5, "scanEnum", "(Ljava/lang/Class;" + c.b(k.class) + "C)Ljava/lang/Enum;");
                    eVar.d(167, cVar7);
                    eVar.e(cVar5);
                    eVar.i(21, aVar2.b("ch"));
                    eVar.f(48);
                    eVar.d(161, cVar6);
                    eVar.i(21, aVar2.b("ch"));
                    eVar.f(57);
                    eVar.d(163, cVar6);
                    g(aVar2, eVar, dVar);
                    eVar.h(192, c.e(h.class));
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    eVar.g(182, str5, "scanInt", "(C)I");
                    eVar.g(182, c.e(h.class), "valueOf", "(I)Ljava/lang/Enum;");
                    eVar.d(167, cVar7);
                    eVar.e(cVar6);
                    eVar.i(25, 0);
                    eVar.i(25, aVar2.b("lexer"));
                    eVar.i(16, i10);
                    eVar.g(182, c.e(m.class), "scanEnum", AbstractC0157z.o(str, str5, ";C)Ljava/lang/Enum;"));
                    eVar.e(cVar7);
                    eVar.h(192, c.e(cls));
                    eVar.i(58, aVar2.b(str6 + "_asm"));
                } else {
                    if (Collection.class.isAssignableFrom(cls)) {
                        Class clsR = j.r(type);
                        if (clsR == String.class) {
                            if (cls == List.class || cls == Collections.class || cls == ArrayList.class) {
                                eVar.h(187, c.e(ArrayList.class));
                                eVar.b(89);
                                eVar.g(183, c.e(ArrayList.class), "<init>", "()V");
                            } else {
                                eVar.f(f.a(c.b(cls)));
                                eVar.g(184, c.e(j.class), "createCollection", "(Ljava/lang/Class;)Ljava/util/Collection;");
                            }
                            eVar.i(58, aVar2.b(str6 + "_asm"));
                            eVar.i(25, aVar2.b("lexer"));
                            eVar.i(25, aVar2.b(str6 + "_asm"));
                            eVar.i(16, i10);
                            eVar.g(182, str5, "scanStringArray", "(Ljava/util/Collection;C)V");
                            p061l.c cVar9 = new p061l.c();
                            eVar.i(25, aVar2.b("lexer"));
                            eVar.a(180, str5, "matchStat", "I");
                            eVar.f(5);
                            eVar.d(160, cVar9);
                            eVar.b(1);
                            eVar.i(58, AbstractC1125a.f(new StringBuilder(), str6, "_asm", aVar2));
                            eVar.e(cVar9);
                            str = str;
                            str2 = str4;
                            i5 = i11;
                            num = num5;
                        } else {
                            p061l.c cVar10 = new p061l.c();
                            eVar.i(25, aVar2.b("lexer"));
                            eVar.g(182, str5, "token", "()I");
                            eVar.i(54, aVar2.b("token"));
                            eVar.i(21, aVar2.b("token"));
                            if (i11 == 0) {
                                str = str;
                                i6 = 14;
                            } else {
                                str = str;
                                i6 = 16;
                            }
                            eVar.f(Integer.valueOf(i6));
                            eVar.d(159, cVar10);
                            eVar.i(25, 1);
                            eVar.i(21, aVar2.b("token"));
                            eVar.g(182, str4, "throwException", "(I)V");
                            eVar.e(cVar10);
                            p061l.c cVar11 = new p061l.c();
                            p061l.c cVar12 = new p061l.c();
                            String str7 = str4;
                            eVar.i(25, aVar2.b("lexer"));
                            eVar.g(182, str5, "getCurrent", "()C");
                            eVar.i(16, 91);
                            eVar.d(160, cVar11);
                            eVar.i(25, aVar2.b("lexer"));
                            eVar.g(182, str5, "next", "()C");
                            eVar.b(87);
                            eVar.i(25, aVar2.b("lexer"));
                            num = num5;
                            eVar.f(num);
                            eVar.g(182, str5, "setToken", "(I)V");
                            eVar.d(167, cVar12);
                            eVar.e(cVar11);
                            eVar.i(25, aVar2.b("lexer"));
                            eVar.f(num);
                            eVar.g(182, str5, "nextToken", "(I)V");
                            eVar.e(cVar12);
                            i5 = i11;
                            h(eVar, cls, i5, false);
                            eVar.b(89);
                            eVar.i(58, AbstractC1125a.f(new StringBuilder(), str6, "_asm", aVar2));
                            f(aVar2, eVar, dVar, clsR);
                            eVar.i(25, 1);
                            eVar.f(f.a(c.b(clsR)));
                            eVar.i(25, 3);
                            String strE = c.e(m.class);
                            StringBuilder sb2 = new StringBuilder("(Ljava/util/Collection;");
                            sb2.append(c.b(p.class));
                            sb2.append("L");
                            str2 = str7;
                            sb2.append(str2);
                            sb2.append(";Ljava/lang/reflect/Type;Ljava/lang/Object;)V");
                            eVar.g(184, strE, "parseArray", sb2.toString());
                        }
                    } else {
                        i5 = i11;
                        str2 = str4;
                        num = num5;
                        if (cls.isArray()) {
                            str = str;
                            eVar.i(25, aVar2.b("lexer"));
                            eVar.f(num);
                            eVar.g(182, str5, "nextToken", "(I)V");
                            eVar.i(25, 1);
                            eVar.i(25, 0);
                            eVar.f(Integer.valueOf(i5));
                            eVar.g(182, c.e(m.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
                            eVar.g(182, str2, "parseObject", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;");
                            eVar.h(192, c.e(cls));
                            eVar.i(58, aVar2.b(str6 + "_asm"));
                        } else {
                            p061l.c cVar13 = new p061l.c();
                            p061l.c cVar14 = new p061l.c();
                            num5 = num;
                            if (cls == Date.class) {
                                str = str;
                                eVar.i(25, aVar2.b("lexer"));
                                eVar.g(182, str5, "getCurrent", "()C");
                                eVar.f(49);
                                eVar.d(160, cVar13);
                                eVar.h(187, c.e(Date.class));
                                eVar.b(89);
                                eVar.i(25, aVar2.b("lexer"));
                                eVar.i(16, i10);
                                eVar.g(182, str5, "scanLong", "(C)J");
                                eVar.g(183, c.e(Date.class), "<init>", "(J)V");
                                eVar.i(58, AbstractC1125a.f(new StringBuilder(), str6, "_asm", aVar2));
                                eVar.d(167, cVar14);
                            } else {
                                str = str;
                            }
                            eVar.e(cVar13);
                            c6 = 14;
                            i(14, eVar, aVar2);
                            c(aVar2, eVar, dVar, cls, i5);
                            eVar.i(25, 0);
                            eVar.i(25, aVar2.b("lexer"));
                            if (z7) {
                                num4 = num4;
                                eVar.f(15);
                            } else {
                                num4 = num4;
                                eVar.f(num4);
                            }
                            eVar.g(183, c.e(m.class), "check", "(" + c.b(p067m.d.class) + "I)V");
                            eVar.e(cVar14);
                        }
                    }
                    num5 = num;
                    str2 = str2;
                    c6 = 14;
                }
                str2 = str4;
                i5 = i11;
                c6 = 14;
            }
            i7 = i5 + 1;
            num3 = num4;
            dVarArr = dVarArr2;
            length = i9;
            num2 = num5;
            str4 = str2;
            str3 = str;
        }
    }

    public static void f(a aVar, p061l.e eVar, d dVar, Class cls) {
        p061l.c cVar = new p061l.c();
        eVar.i(25, 0);
        String str = aVar.e;
        StringBuilder sb = new StringBuilder();
        String str2 = dVar.f7884a;
        eVar.a(180, str, AbstractC0157z.s(sb, str2, "_asm_list_item_deser__"), c.b(p.class));
        eVar.d(199, cVar);
        eVar.i(25, 0);
        eVar.i(25, 1);
        eVar.g(182, c, "getConfig", "()" + c.b(p067m.j.class));
        eVar.f(f.a(c.b(cls)));
        eVar.a(181, str, AbstractC0157z.s(AbstractC1125a.j(eVar, 182, c.e(p067m.j.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + c.b(p.class)), str2, "_asm_list_item_deser__"), c.b(p.class));
        eVar.e(cVar);
        eVar.i(25, 0);
        eVar.a(180, str, str2 + "_asm_list_item_deser__", c.b(p.class));
    }

    public static void g(a aVar, p061l.e eVar, d dVar) {
        p061l.c cVar = new p061l.c();
        eVar.i(25, 0);
        String str = aVar.e;
        StringBuilder sb = new StringBuilder();
        String str2 = dVar.f7884a;
        eVar.a(180, str, AbstractC0157z.s(sb, str2, "_asm_deser__"), c.b(p.class));
        eVar.d(199, cVar);
        eVar.i(25, 0);
        eVar.i(25, 1);
        eVar.g(182, c, "getConfig", "()" + c.b(p067m.j.class));
        eVar.f(f.a(c.b(dVar.e)));
        eVar.a(181, str, AbstractC0157z.s(AbstractC1125a.j(eVar, 182, c.e(p067m.j.class), "getDeserializer", "(Ljava/lang/reflect/Type;)" + c.b(p.class)), str2, "_asm_deser__"), c.b(p.class));
        eVar.e(cVar);
        eVar.i(25, 0);
        eVar.a(180, str, str2 + "_asm_deser__", c.b(p.class));
    }

    public static void h(p061l.e eVar, Class cls, int i5, boolean z6) {
        if (cls.isAssignableFrom(ArrayList.class) && !z6) {
            eVar.h(187, "java/util/ArrayList");
            eVar.b(89);
            eVar.g(183, "java/util/ArrayList", "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedList.class) && !z6) {
            eVar.h(187, c.e(LinkedList.class));
            eVar.b(89);
            eVar.g(183, c.e(LinkedList.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(HashSet.class)) {
            eVar.h(187, c.e(HashSet.class));
            eVar.b(89);
            eVar.g(183, c.e(HashSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(TreeSet.class)) {
            eVar.h(187, c.e(TreeSet.class));
            eVar.b(89);
            eVar.g(183, c.e(TreeSet.class), "<init>", "()V");
        } else if (cls.isAssignableFrom(LinkedHashSet.class)) {
            eVar.h(187, c.e(LinkedHashSet.class));
            eVar.b(89);
            eVar.g(183, c.e(LinkedHashSet.class), "<init>", "()V");
        } else if (z6) {
            eVar.h(187, c.e(HashSet.class));
            eVar.b(89);
            eVar.g(183, c.e(HashSet.class), "<init>", "()V");
        } else {
            eVar.i(25, 0);
            eVar.f(Integer.valueOf(i5));
            eVar.g(182, c.e(m.class), "getFieldType", "(I)Ljava/lang/reflect/Type;");
            eVar.g(184, c.e(j.class), "createCollection", "(Ljava/lang/reflect/Type;)Ljava/util/Collection;");
        }
        eVar.h(192, c.e(cls));
    }

    public static void i(int i5, p061l.e eVar, a aVar) {
        p061l.c cVar = new p061l.c();
        p061l.c cVar2 = new p061l.c();
        eVar.i(25, aVar.b("lexer"));
        String str = d;
        eVar.g(182, str, "getCurrent", "()C");
        if (i5 == 12) {
            eVar.i(16, 123);
        } else {
            if (i5 != 14) {
                throw new IllegalStateException();
            }
            eVar.i(16, 91);
        }
        eVar.d(160, cVar);
        eVar.i(25, aVar.b("lexer"));
        eVar.g(182, str, "next", "()C");
        eVar.b(87);
        eVar.i(25, aVar.b("lexer"));
        eVar.f(Integer.valueOf(i5));
        eVar.g(182, str, "setToken", "(I)V");
        eVar.d(167, cVar2);
        eVar.e(cVar);
        eVar.i(25, aVar.b("lexer"));
        eVar.f(Integer.valueOf(i5));
        eVar.g(182, str, "nextToken", "(I)V");
        eVar.e(cVar2);
    }

    public static void j(a aVar, p061l.e eVar) {
        p061l.c cVar = new p061l.c();
        p061l.c cVar2 = new p061l.c();
        p061l.c cVar3 = new p061l.c();
        p061l.c cVar4 = new p061l.c();
        p061l.c cVar5 = new p061l.c();
        eVar.i(25, aVar.b("lexer"));
        String str = d;
        eVar.g(182, str, "getCurrent", "()C");
        eVar.b(89);
        eVar.i(54, aVar.b("ch"));
        eVar.i(16, 44);
        eVar.d(160, cVar2);
        eVar.i(25, aVar.b("lexer"));
        eVar.g(182, str, "next", "()C");
        eVar.b(87);
        eVar.i(25, aVar.b("lexer"));
        eVar.f(16);
        eVar.g(182, str, "setToken", "(I)V");
        eVar.d(167, cVar5);
        eVar.e(cVar2);
        eVar.i(21, aVar.b("ch"));
        eVar.i(16, 125);
        eVar.d(160, cVar3);
        eVar.i(25, aVar.b("lexer"));
        eVar.g(182, str, "next", "()C");
        eVar.b(87);
        eVar.i(25, aVar.b("lexer"));
        eVar.f(13);
        eVar.g(182, str, "setToken", "(I)V");
        eVar.d(167, cVar5);
        eVar.e(cVar3);
        eVar.i(21, aVar.b("ch"));
        eVar.i(16, 93);
        eVar.d(160, cVar4);
        eVar.i(25, aVar.b("lexer"));
        eVar.g(182, str, "next", "()C");
        eVar.b(87);
        eVar.i(25, aVar.b("lexer"));
        eVar.f(15);
        eVar.g(182, str, "setToken", "(I)V");
        eVar.d(167, cVar5);
        eVar.e(cVar4);
        eVar.i(21, aVar.b("ch"));
        eVar.i(16, 26);
        eVar.d(160, cVar);
        eVar.i(25, aVar.b("lexer"));
        eVar.f(20);
        eVar.g(182, str, "setToken", "(I)V");
        eVar.d(167, cVar5);
        eVar.e(cVar);
        eVar.i(25, aVar.b("lexer"));
        eVar.g(182, str, "nextToken", "()V");
        eVar.e(cVar5);
    }

    public static void k(p061l.e eVar, d dVar) {
        Method method = dVar.b;
        Class cls = dVar.f7886g;
        if (method == null) {
            eVar.a(181, c.e(cls), dVar.c.getName(), c.b(dVar.e));
            return;
        }
        eVar.g(method.getDeclaringClass().isInterface() ? 185 : 182, c.e(cls), method.getName(), c.c(method));
        if (method.getReturnType().equals(Void.TYPE)) {
            return;
        }
        eVar.b(87);
    }

    public static void l(int i5, p061l.e eVar, a aVar) {
        String str = "_asm_flag_" + (i5 / 32);
        eVar.i(21, aVar.b(str));
        eVar.f(Integer.valueOf(1 << i5));
        eVar.b(128);
        eVar.i(54, aVar.b(str));
    }

    public static void m(a aVar, p061l.e eVar) {
        eVar.i(25, 1);
        eVar.a(180, c, "lexer", c.b(p067m.d.class));
        eVar.h(192, d);
        eVar.i(58, aVar.b("lexer"));
    }

    /* JADX WARN: Code duplicated, block: B:132:0x097d  */
    public p createJavaBeanDeserializer(p067m.j jVar, g gVar) {
        int i5;
        Class<String> cls;
        String str;
        int i6;
        String str2;
        Class cls2;
        Class<String> cls3;
        p061l.c cVar;
        p061l.c cVar2;
        String str3;
        String str4;
        String str5;
        Integer num;
        String str6;
        String str7;
        int i7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        int i8;
        String str16;
        p061l.c cVar3;
        Integer num2;
        Integer num3 = 14;
        Integer num4 = -1;
        Class cls4 = gVar.f7912a;
        if (cls4.isPrimitive()) {
            throw new IllegalArgumentException("not support type :".concat(cls4.getName()));
        }
        String str17 = "FastjsonASMDeserializer_" + this.b.incrementAndGet() + "_" + cls4.getSimpleName();
        String name = b.class.getPackage().getName();
        String str18 = name.replace('.', '/') + PackagingURIHelper.FORWARD_SLASH_STRING + str17;
        String strO = androidx.collection.a.o(name, Consts.DOT, str17);
        a aVar = new a();
        aVar.g(str18, c.e(m.class), null);
        new HashMap();
        d[] dVarArr = gVar.f7915h;
        for (d dVar : dVarArr) {
            new S1.f(aVar, AbstractC0157z.s(new StringBuilder(), dVar.f7884a, "_asm_prefix__"), "[C");
        }
        int length = dVarArr.length;
        int i9 = 0;
        while (i9 < length) {
            d dVar2 = dVarArr[i9];
            int i10 = length;
            Class cls5 = dVar2.e;
            String str19 = dVar2.f7884a;
            if (!cls5.isPrimitive()) {
                if (Collection.class.isAssignableFrom(cls5)) {
                    new S1.f(aVar, androidx.collection.a.n(str19, "_asm_list_item_deser__"), c.b(p.class));
                } else {
                    new S1.f(aVar, androidx.collection.a.n(str19, "_asm_deser__"), c.b(p.class));
                }
            }
            i9++;
            length = i10;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(c.b(p067m.j.class));
        sb.append(c.b(g.class));
        String str20 = ")V";
        sb.append(")V");
        p061l.e eVar = new p061l.e(aVar, "<init>", sb.toString(), null);
        eVar.i(25, 0);
        eVar.i(25, 1);
        eVar.i(25, 2);
        eVar.g(183, c.e(m.class), "<init>", "(" + c.b(p067m.j.class) + c.b(g.class) + ")V");
        int length2 = dVarArr.length;
        int i11 = 0;
        while (i11 < length2) {
            d dVar3 = dVarArr[i11];
            eVar.i(25, 0);
            eVar.f("\"" + dVar3.f7884a + "\":");
            eVar.a(181, str18, AbstractC0157z.s(AbstractC1125a.j(eVar, 182, "java/lang/String", "toCharArray", "()[C"), dVar3.f7884a, "_asm_prefix__"), "[C");
            i11++;
            length2 = length2;
            dVarArr = dVarArr;
            str20 = str20;
        }
        String str21 = str20;
        eVar.b(177);
        eVar.f5767h = 4;
        eVar.f5768i = 4;
        new HashMap();
        Class cls6 = gVar.f7912a;
        boolean zIsPublic = Modifier.isPublic(gVar.c.getModifiers());
        String str22 = "(L";
        String str23 = c;
        if (zIsPublic) {
            p061l.e eVar2 = new p061l.e(aVar, "createInstance", AbstractC0157z.o("(L", str23, ";Ljava/lang/reflect/Type;)Ljava/lang/Object;"), null);
            Class cls7 = gVar.b;
            if (cls7 == null) {
                cls7 = cls6;
            }
            eVar2.h(187, c.e(cls7));
            eVar2.b(89);
            Class cls8 = gVar.b;
            if (cls8 != null) {
                cls6 = cls8;
            }
            eVar2.g(183, c.e(cls6), "<init>", "()V");
            eVar2.b(176);
            eVar2.f5767h = 3;
            eVar2.f5768i = 3;
        }
        a aVar2 = new a(str18, gVar, 5);
        Integer numValueOf = Integer.valueOf((int) r0);
        d[] dVarArr2 = aVar2.f6184f;
        if (dVarArr2.length == 0) {
            break;
        }
        int length3 = dVarArr2.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length3) {
                g gVar2 = aVar2.d;
                aVar2.f6184f = gVar2.f7916i;
                p061l.e eVar3 = new p061l.e(aVar, "deserialze", AbstractC0157z.o("(L", str23, ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"), null);
                p061l.c cVar4 = new p061l.c();
                p061l.c cVar5 = new p061l.c();
                p061l.c cVar6 = new p061l.c();
                p061l.c cVar7 = new p061l.c();
                m(aVar2, eVar3);
                p061l.c cVar8 = new p061l.c();
                String str24 = "deserialze";
                String str25 = "lexer";
                p061l.c cVar9 = cVar7;
                p061l.c cVar10 = cVar4;
                eVar3.i(25, aVar2.b("lexer"));
                String str26 = d;
                Class cls9 = Collection.class;
                String str27 = "()I";
                eVar3.g(182, str26, "token", "()I");
                eVar3.f(num3);
                eVar3.d(160, cVar8);
                int i13 = gVar2.f7917j;
                p067m.c cVar11 = p067m.c.SupportArrayToBean;
                if ((cVar11.f6089a & i13) == 0) {
                    i5 = 25;
                    eVar3.i(25, aVar2.b("lexer"));
                    eVar3.i(21, 4);
                    eVar3.f(Integer.valueOf(cVar11.f6089a));
                    eVar3.g(182, str26, "isEnabled", "(II)Z");
                    eVar3.d(153, cVar8);
                } else {
                    i5 = 25;
                }
                eVar3.i(i5, 0);
                eVar3.i(i5, 1);
                eVar3.i(i5, 2);
                eVar3.i(i5, 3);
                eVar3.b(1);
                String strS = AbstractC0157z.s(new StringBuilder("(L"), str23, ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
                String str28 = aVar2.e;
                eVar3.g(183, str28, "deserialzeArrayMapping", strS);
                eVar3.b(176);
                eVar3.e(cVar8);
                eVar3.i(25, aVar2.b("lexer"));
                eVar3.f(Integer.valueOf(p067m.c.SortFeidFastMatch.f6089a));
                eVar3.g(182, str26, "isEnabled", "(I)Z");
                eVar3.d(153, cVar5);
                eVar3.i(25, aVar2.b("lexer"));
                Class cls10 = aVar2.c;
                eVar3.f(cls10.getName());
                eVar3.g(182, str26, "scanType", "(Ljava/lang/String;)I");
                eVar3.f(num4);
                eVar3.d(159, cVar5);
                eVar3.i(25, 1);
                String str29 = "getContext";
                eVar3.g(182, str23, "getContext", "()" + c.b(i.class));
                eVar3.i(58, aVar2.b("mark_context"));
                eVar3.b(3);
                String str30 = "matchedCount";
                eVar3.i(54, aVar2.b("matchedCount"));
                b(aVar2, eVar3);
                eVar3.i(25, 1);
                eVar3.g(182, str23, "getContext", "()" + c.b(i.class));
                String str31 = "()";
                eVar3.i(58, aVar2.b("context"));
                eVar3.i(25, 1);
                eVar3.i(25, aVar2.b("context"));
                eVar3.i(25, aVar2.b("instance"));
                eVar3.i(25, 3);
                String str32 = "setContext";
                eVar3.g(182, str23, "setContext", "(" + c.b(i.class) + "Ljava/lang/Object;Ljava/lang/Object;)" + c.b(i.class));
                eVar3.i(58, aVar2.b("childContext"));
                eVar3.i(25, aVar2.b("lexer"));
                String str33 = "matchStat";
                String str34 = "I";
                eVar3.a(180, str26, "matchStat", "I");
                eVar3.f(numValueOf);
                String str35 = str23;
                eVar3.d(159, cVar6);
                eVar3.b(3);
                eVar3.c(54, aVar2.b("matchStat"));
                int length4 = aVar2.f6184f.length;
                int i14 = 0;
                while (i14 < length4) {
                    int i15 = i14;
                    eVar3.b(3);
                    eVar3.i(54, aVar2.b("_asm_flag_" + (i15 / 32)));
                    i14 = i15 + 32;
                    str32 = str32;
                }
                String str36 = str32;
                eVar3.i(25, aVar2.b("lexer"));
                eVar3.f(Integer.valueOf(p067m.c.InitStringFieldAsEmpty.f6089a));
                eVar3.g(182, str26, "isEnabled", "(I)Z");
                eVar3.c(54, aVar2.b("initStringFieldAsEmpty"));
                int i16 = 0;
                while (true) {
                    cls = String.class;
                    str = "_asm";
                    if (i16 >= length4) {
                        break;
                    }
                    String str37 = str29;
                    d dVar4 = aVar2.f6184f[i16];
                    Integer num5 = numValueOf;
                    Class<String> cls11 = dVar4.e;
                    String str38 = dVar4.f7884a;
                    String str39 = str30;
                    if (cls11 == Boolean.TYPE || cls11 == Byte.TYPE || cls11 == Short.TYPE || cls11 == Integer.TYPE) {
                        num4 = num4;
                        i16 = i16;
                        eVar3.b(3);
                        eVar3.i(54, aVar2.b(str38 + "_asm"));
                    } else {
                        if (cls11 == Long.TYPE) {
                            eVar3.b(9);
                            eVar3.i(55, aVar2.a(str38 + "_asm"));
                        } else if (cls11 == Float.TYPE) {
                            eVar3.b(11);
                            eVar3.i(56, aVar2.b(str38 + "_asm"));
                        } else if (cls11 == Double.TYPE) {
                            eVar3.b(14);
                            eVar3.i(57, aVar2.a(str38 + "_asm"));
                        } else {
                            if (cls11 == cls) {
                                p061l.c cVar12 = new p061l.c();
                                p061l.c cVar13 = new p061l.c();
                                eVar3.i(21, aVar2.b("initStringFieldAsEmpty"));
                                eVar3.d(153, cVar13);
                                l(i16, eVar3, aVar2);
                                eVar3.i(25, aVar2.b("lexer"));
                                eVar3.g(182, str26, "stringDefaultValue", "()Ljava/lang/String;");
                                eVar3.d(167, cVar12);
                                eVar3.e(cVar13);
                                eVar3.b(1);
                                eVar3.e(cVar12);
                            } else {
                                eVar3.b(1);
                            }
                            eVar3.h(192, c.e(cls11));
                            eVar3.i(58, aVar2.b(str38 + "_asm"));
                        }
                        num4 = num4;
                        i16 = i16;
                    }
                    i16++;
                    str29 = str37;
                    numValueOf = num5;
                    str30 = str39;
                    num4 = num4;
                }
                String str40 = str30;
                Integer num6 = numValueOf;
                Integer num7 = num4;
                String str41 = str29;
                int i17 = 0;
                while (i17 < length4) {
                    d dVar5 = aVar2.f6184f[i17];
                    Class<String> cls12 = dVar5.e;
                    String str42 = dVar5.f7884a;
                    Type type = dVar5.f7885f;
                    p061l.c cVar14 = new p061l.c();
                    int i18 = length4;
                    int i19 = i17;
                    String str43 = str33;
                    if (cls12 == Boolean.TYPE) {
                        eVar3.i(25, aVar2.b(str25));
                        eVar3.i(25, 0);
                        eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                        eVar3.i(54, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldBoolean", "([C)Z"), str42, str, aVar2));
                        str2 = str34;
                    } else {
                        str2 = str34;
                        if (cls12 == Byte.TYPE || cls12 == Short.TYPE || cls12 == Integer.TYPE) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            eVar3.i(54, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldInt", "([C)I"), str42, str, aVar2));
                        } else if (cls12 == Long.TYPE) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            StringBuilder sbJ = AbstractC1125a.j(eVar3, 182, str26, "scanFieldLong", "([C)J");
                            sbJ.append(str42);
                            sbJ.append(str);
                            eVar3.i(55, aVar2.a(sbJ.toString()));
                        } else if (cls12 == Float.TYPE) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            eVar3.i(56, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldFloat", "([C)F"), str42, str, aVar2));
                        } else if (cls12 == Double.TYPE) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            StringBuilder sbJ2 = AbstractC1125a.j(eVar3, 182, str26, "scanFieldDouble", "([C)D");
                            sbJ2.append(str42);
                            sbJ2.append(str);
                            eVar3.i(57, aVar2.a(sbJ2.toString()));
                        } else if (cls12 == cls) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            eVar3.i(58, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldString", "([C)Ljava/lang/String;"), str42, str, aVar2));
                        } else if (cls12 == int[].class) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            eVar3.i(58, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldIntArray", "([C)[I"), str42, str, aVar2));
                        } else if (cls12 == float[].class) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            eVar3.i(58, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldFloatArray", "([C)[F"), str42, str, aVar2));
                        } else if (cls12 == float[][].class) {
                            eVar3.i(25, aVar2.b(str25));
                            eVar3.i(25, 0);
                            eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                            eVar3.i(58, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldFloatArray2", "([C)[[F"), str42, str, aVar2));
                        } else {
                            if (cls12.isEnum()) {
                                eVar3.i(25, 0);
                                eVar3.i(25, aVar2.b(str25));
                                eVar3.i(25, 0);
                                eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                                g(aVar2, eVar3, dVar5);
                                String strE = c.e(m.class);
                                StringBuilder sbY = AbstractC0157z.y(str22, str26, ";[C");
                                sbY.append(c.b(p.class));
                                sbY.append(")Ljava/lang/Enum;");
                                eVar3.g(182, strE, "scanEnum", sbY.toString());
                                eVar3.h(192, c.e(cls12));
                                eVar3.i(58, aVar2.b(str42 + str));
                            } else {
                                cls2 = cls9;
                                if (cls2.isAssignableFrom(cls12)) {
                                    eVar3.i(25, aVar2.b(str25));
                                    eVar3.i(25, 0);
                                    eVar3.a(180, str28, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                                    Class<String> clsR = j.r(type);
                                    if (clsR == cls) {
                                        eVar3.f(f.a(c.b(cls12)));
                                        eVar3.i(58, AbstractC1125a.f(AbstractC1125a.j(eVar3, 182, str26, "scanFieldStringArray", "([CLjava/lang/Class;)" + c.b(cls2)), str42, str, aVar2));
                                        eVar3.i(25, aVar2.b(str25));
                                        str16 = str2;
                                        eVar3.a(180, str26, str43, str16);
                                        p061l.c cVar15 = new p061l.c();
                                        eVar3.d(158, cVar15);
                                        l(i19, eVar3, aVar2);
                                        eVar3.e(cVar15);
                                        eVar3.i(25, aVar2.b(str25));
                                        eVar3.a(180, str26, str43, str16);
                                        eVar3.b(89);
                                        eVar3.i(54, aVar2.b(str43));
                                        eVar3.f(num7);
                                        cVar3 = cVar10;
                                        eVar3.d(159, cVar3);
                                        eVar3.i(25, aVar2.b(str25));
                                        eVar3.a(180, str26, str43, str16);
                                        eVar3.d(158, cVar14);
                                        String str44 = str40;
                                        cls9 = cls2;
                                        eVar3.i(21, aVar2.b(str44));
                                        eVar3.b(4);
                                        eVar3.b(96);
                                        eVar3.i(54, aVar2.b(str44));
                                        eVar3.i(25, aVar2.b(str25));
                                        eVar3.a(180, str26, str43, str16);
                                        num2 = num6;
                                        eVar3.f(num2);
                                        p061l.c cVar16 = cVar9;
                                        cls3 = cls;
                                        eVar3.d(159, cVar16);
                                        eVar3.e(cVar14);
                                        if (i19 == i18 - 1) {
                                            eVar3.i(25, aVar2.b(str25));
                                            eVar3.a(180, str26, str43, str16);
                                            eVar3.f(num2);
                                            eVar3.d(160, cVar3);
                                        }
                                        num6 = num2;
                                        cVar2 = cVar16;
                                        str2 = str16;
                                        str40 = str44;
                                        cVar = cVar3;
                                        i7 = i19;
                                        str3 = str22;
                                        str4 = str26;
                                        str43 = str43;
                                        str5 = str;
                                        str7 = str21;
                                        str10 = str35;
                                        num = num3;
                                        str12 = str27;
                                        str11 = str31;
                                        str6 = str36;
                                        str9 = str28;
                                        str8 = str25;
                                    } else {
                                        cls9 = cls2;
                                        p061l.c cVar17 = cVar9;
                                        cls3 = cls;
                                        p061l.c cVar18 = cVar10;
                                        p061l.c cVar19 = new p061l.c();
                                        cVar2 = cVar17;
                                        String str45 = d;
                                        str4 = str26;
                                        str5 = str;
                                        eVar3.g(182, str45, "matchField", "([C)Z");
                                        eVar3.d(153, cVar19);
                                        l(i19, eVar3, aVar2);
                                        p061l.c cVar20 = new p061l.c();
                                        String str46 = str28;
                                        eVar3.i(25, aVar2.b("lexer"));
                                        String str47 = str27;
                                        str8 = str25;
                                        eVar3.g(182, str45, "token", str47);
                                        eVar3.f(8);
                                        eVar3.d(160, cVar20);
                                        eVar3.i(25, aVar2.b("lexer"));
                                        eVar3.f(16);
                                        str3 = str22;
                                        eVar3.g(182, str45, "nextToken", "(I)V");
                                        eVar3.d(167, cVar19);
                                        eVar3.e(cVar20);
                                        p061l.c cVar21 = new p061l.c();
                                        p061l.c cVar22 = new p061l.c();
                                        p061l.c cVar23 = new p061l.c();
                                        eVar3.i(25, aVar2.b("lexer"));
                                        eVar3.g(182, str45, "token", str47);
                                        eVar3.f(21);
                                        eVar3.d(160, cVar22);
                                        eVar3.i(25, aVar2.b("lexer"));
                                        Integer num8 = num3;
                                        eVar3.f(num8);
                                        eVar3.g(182, str45, "nextToken", "(I)V");
                                        h(eVar3, cls12, i19, true);
                                        eVar3.d(167, cVar21);
                                        eVar3.e(cVar22);
                                        eVar3.i(25, aVar2.b("lexer"));
                                        eVar3.g(182, str45, "token", str47);
                                        eVar3.f(num8);
                                        eVar3.d(159, cVar23);
                                        eVar3.i(25, aVar2.b("lexer"));
                                        eVar3.g(182, str45, "token", str47);
                                        eVar3.f(12);
                                        eVar3.d(160, cVar18);
                                        h(eVar3, cls12, i19, false);
                                        StringBuilder sb2 = new StringBuilder();
                                        num = num8;
                                        String str48 = dVar5.f7884a;
                                        eVar3.i(58, AbstractC1125a.f(sb2, str48, "_asm", aVar2));
                                        f(aVar2, eVar3, dVar5, clsR);
                                        eVar3.i(25, 1);
                                        eVar3.f(f.a(c.b(clsR)));
                                        eVar3.b(3);
                                        eVar3.g(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                        String strE2 = c.e(p.class);
                                        StringBuilder sb3 = new StringBuilder(str3);
                                        String str49 = c;
                                        String strS2 = AbstractC0157z.s(sb3, str49, ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;");
                                        String str50 = str24;
                                        eVar3.g(185, strE2, str50, strS2);
                                        eVar3.i(58, aVar2.b("list_item_value"));
                                        eVar3.i(25, aVar2.b(str48 + "_asm"));
                                        eVar3.i(25, aVar2.b("list_item_value"));
                                        if (cls12.isInterface()) {
                                            eVar3.g(185, c.e(cls12), "add", "(Ljava/lang/Object;)Z");
                                        } else {
                                            eVar3.g(182, c.e(cls12), "add", "(Ljava/lang/Object;)Z");
                                        }
                                        eVar3.b(87);
                                        eVar3.d(167, cVar19);
                                        eVar3.e(cVar23);
                                        h(eVar3, cls12, i19, false);
                                        eVar3.e(cVar21);
                                        eVar3.i(58, AbstractC1125a.f(new StringBuilder(), str48, "_asm", aVar2));
                                        boolean zE = p067m.j.e(dVar5.e);
                                        f(aVar2, eVar3, dVar5, clsR);
                                        if (zE) {
                                            eVar3.g(185, c.e(p.class), "getFastMatchToken", str47);
                                            eVar3.i(54, aVar2.b("fastMatchToken"));
                                            eVar3.i(25, aVar2.b("lexer"));
                                            eVar3.i(21, aVar2.b("fastMatchToken"));
                                            str13 = str45;
                                            str14 = "nextToken";
                                            str15 = "(I)V";
                                            eVar3.g(182, str13, str14, str15);
                                        } else {
                                            str13 = str45;
                                            str14 = "nextToken";
                                            str15 = "(I)V";
                                            eVar3.b(87);
                                            eVar3.f(12);
                                            eVar3.i(54, aVar2.b("fastMatchToken"));
                                            i(12, eVar3, aVar2);
                                        }
                                        eVar3.i(25, 1);
                                        String str51 = str41;
                                        eVar3.g(182, str49, str51, "()" + c.b(i.class));
                                        eVar3.i(58, aVar2.b("listContext"));
                                        eVar3.i(25, 1);
                                        eVar3.i(25, AbstractC1125a.f(new StringBuilder(), str48, "_asm", aVar2));
                                        eVar3.f(str48);
                                        String str52 = str36;
                                        eVar3.g(182, str49, str52, "(Ljava/lang/Object;Ljava/lang/Object;)" + c.b(i.class));
                                        eVar3.b(87);
                                        p061l.c cVar24 = new p061l.c();
                                        p061l.c cVar25 = new p061l.c();
                                        eVar3.b(3);
                                        String str53 = str15;
                                        String str54 = str14;
                                        eVar3.i(54, aVar2.b(Complex.DEFAULT_SUFFIX));
                                        eVar3.e(cVar24);
                                        eVar3.i(25, aVar2.b("lexer"));
                                        eVar3.g(182, str13, "token", str47);
                                        eVar3.f(15);
                                        eVar3.d(159, cVar25);
                                        eVar3.i(25, 0);
                                        eVar3.a(180, aVar2.e, str48.concat("_asm_list_item_deser__"), c.b(p.class));
                                        eVar3.i(25, 1);
                                        eVar3.f(f.a(c.b(clsR)));
                                        eVar3.i(21, aVar2.b(Complex.DEFAULT_SUFFIX));
                                        eVar3.g(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
                                        eVar3.g(185, c.e(p.class), str50, AbstractC0157z.o(str3, str49, ";Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;"));
                                        eVar3.i(58, aVar2.b("list_item_value"));
                                        int iB = aVar2.b(Complex.DEFAULT_SUFFIX);
                                        k kVar = eVar3.f5766g;
                                        kVar.g(132);
                                        kVar.e(iB, 1);
                                        eVar3.i(25, aVar2.b(str48.concat("_asm")));
                                        eVar3.i(25, aVar2.b("list_item_value"));
                                        if (cls12.isInterface()) {
                                            eVar3.g(185, c.e(cls12), "add", "(Ljava/lang/Object;)Z");
                                            i8 = 182;
                                        } else {
                                            i8 = 182;
                                            eVar3.g(182, c.e(cls12), "add", "(Ljava/lang/Object;)Z");
                                        }
                                        eVar3.b(87);
                                        eVar3.i(25, 1);
                                        eVar3.i(25, aVar2.b(str48.concat("_asm")));
                                        eVar3.g(i8, str49, "checkListResolve", "(Ljava/util/Collection;)V");
                                        eVar3.i(25, aVar2.b("lexer"));
                                        eVar3.g(i8, str13, "token", str47);
                                        eVar3.f(16);
                                        eVar3.d(160, cVar24);
                                        if (zE) {
                                            eVar3.i(25, aVar2.b("lexer"));
                                            eVar3.i(21, aVar2.b("fastMatchToken"));
                                            eVar3.g(i8, str13, str54, str53);
                                        } else {
                                            i(12, eVar3, aVar2);
                                        }
                                        eVar3.d(167, cVar24);
                                        eVar3.e(cVar25);
                                        eVar3.i(25, 1);
                                        eVar3.i(25, aVar2.b("listContext"));
                                        StringBuilder sb4 = new StringBuilder("(");
                                        sb4.append(c.b(i.class));
                                        str7 = str21;
                                        sb4.append(str7);
                                        str6 = str52;
                                        eVar3.g(182, str49, str6, sb4.toString());
                                        eVar3.i(25, aVar2.b("lexer"));
                                        eVar3.g(182, str13, "token", str47);
                                        eVar3.f(15);
                                        cVar = cVar18;
                                        eVar3.d(160, cVar);
                                        j(aVar2, eVar3);
                                        eVar3.e(cVar19);
                                        i7 = i19;
                                        if (i7 == i18 - 1) {
                                            d(aVar2, eVar3, cVar);
                                        }
                                        str12 = str47;
                                        str24 = str50;
                                        str10 = str35;
                                        str11 = str31;
                                        str9 = str46;
                                        str41 = str51;
                                    }
                                } else {
                                    p061l.c cVar26 = cVar9;
                                    cls3 = cls;
                                    cVar = cVar10;
                                    cVar2 = cVar26;
                                    cls9 = cls2;
                                    str3 = str22;
                                    str4 = str26;
                                    str5 = str;
                                    num = num3;
                                    str6 = str36;
                                    String str55 = str41;
                                    str7 = str21;
                                    i7 = i19;
                                    String str56 = str28;
                                    String str57 = str27;
                                    str8 = str25;
                                    p061l.c cVar27 = new p061l.c();
                                    p061l.c cVar28 = new p061l.c();
                                    eVar3.i(25, aVar2.b(str8));
                                    eVar3.i(25, 0);
                                    str9 = str56;
                                    eVar3.a(180, str9, AbstractC0157z.s(new StringBuilder(), str42, "_asm_prefix__"), "[C");
                                    eVar3.g(182, str4, "matchField", "([C)Z");
                                    eVar3.d(154, cVar27);
                                    eVar3.b(1);
                                    eVar3.i(58, aVar2.b(str42 + str5));
                                    eVar3.d(167, cVar28);
                                    eVar3.e(cVar27);
                                    l(i7, eVar3, aVar2);
                                    String str58 = str40;
                                    eVar3.i(21, aVar2.b(str58));
                                    eVar3.b(4);
                                    eVar3.b(96);
                                    eVar3.i(54, aVar2.b(str58));
                                    c(aVar2, eVar3, dVar5, cls12, i7);
                                    eVar3.i(25, 1);
                                    str10 = str35;
                                    eVar3.g(182, str10, "getResolveStatus", str57);
                                    eVar3.f(1);
                                    eVar3.d(160, cVar28);
                                    eVar3.i(25, 1);
                                    str11 = str31;
                                    str12 = str57;
                                    eVar3.g(182, str10, "getLastResolveTask", str11 + c.b(p067m.a.class));
                                    eVar3.i(58, aVar2.b("resolveTask"));
                                    eVar3.i(25, aVar2.b("resolveTask"));
                                    eVar3.i(25, 1);
                                    eVar3.g(182, str10, str55, str11 + c.b(i.class));
                                    str41 = str55;
                                    eVar3.a(181, c.e(p067m.a.class), "ownerContext", c.b(i.class));
                                    eVar3.i(25, aVar2.b("resolveTask"));
                                    eVar3.i(25, 0);
                                    eVar3.f(str42);
                                    eVar3.g(182, c.e(m.class), "getFieldDeserializer", "(Ljava/lang/String;)" + c.b(l.class));
                                    eVar3.a(181, c.e(p067m.a.class), "fieldDeserializer", c.b(l.class));
                                    eVar3.i(25, 1);
                                    eVar3.f(0);
                                    eVar3.g(182, str10, "setResolveStatus", "(I)V");
                                    eVar3.e(cVar28);
                                    if (i7 == i18 - 1) {
                                        d(aVar2, eVar3, cVar);
                                    }
                                }
                            }
                            i17 = i7 + 1;
                            p061l.c cVar29 = cVar2;
                            cVar10 = cVar;
                            cls = cls3;
                            cVar9 = cVar29;
                            str36 = str6;
                            str35 = str10;
                            str28 = str9;
                            str31 = str11;
                            str25 = str8;
                            str = str5;
                            length4 = i18;
                            str26 = str4;
                            str33 = str43;
                            str34 = str2;
                            str22 = str3;
                            num3 = num;
                            str27 = str12;
                            str21 = str7;
                        }
                    }
                    cls2 = cls9;
                    eVar3.i(25, aVar2.b(str25));
                    str16 = str2;
                    eVar3.a(180, str26, str43, str16);
                    p061l.c cVar110 = new p061l.c();
                    eVar3.d(158, cVar110);
                    l(i19, eVar3, aVar2);
                    eVar3.e(cVar110);
                    eVar3.i(25, aVar2.b(str25));
                    eVar3.a(180, str26, str43, str16);
                    eVar3.b(89);
                    eVar3.i(54, aVar2.b(str43));
                    eVar3.f(num7);
                    cVar3 = cVar10;
                    eVar3.d(159, cVar3);
                    eVar3.i(25, aVar2.b(str25));
                    eVar3.a(180, str26, str43, str16);
                    eVar3.d(158, cVar14);
                    String str410 = str40;
                    cls9 = cls2;
                    eVar3.i(21, aVar2.b(str410));
                    eVar3.b(4);
                    eVar3.b(96);
                    eVar3.i(54, aVar2.b(str410));
                    eVar3.i(25, aVar2.b(str25));
                    eVar3.a(180, str26, str43, str16);
                    num2 = num6;
                    eVar3.f(num2);
                    p061l.c cVar111 = cVar9;
                    cls3 = cls;
                    eVar3.d(159, cVar111);
                    eVar3.e(cVar14);
                    if (i19 == i18 - 1) {
                        eVar3.i(25, aVar2.b(str25));
                        eVar3.a(180, str26, str43, str16);
                        eVar3.f(num2);
                        eVar3.d(160, cVar3);
                    }
                    num6 = num2;
                    cVar2 = cVar111;
                    str2 = str16;
                    str40 = str410;
                    cVar = cVar3;
                    i7 = i19;
                    str3 = str22;
                    str4 = str26;
                    str43 = str43;
                    str5 = str;
                    str7 = str21;
                    str10 = str35;
                    num = num3;
                    str12 = str27;
                    str11 = str31;
                    str6 = str36;
                    str9 = str28;
                    str8 = str25;
                    i17 = i7 + 1;
                    p061l.c cVar210 = cVar2;
                    cVar10 = cVar;
                    cls = cls3;
                    cVar9 = cVar210;
                    str36 = str6;
                    str35 = str10;
                    str28 = str9;
                    str31 = str11;
                    str25 = str8;
                    str = str5;
                    length4 = i18;
                    str26 = str4;
                    str33 = str43;
                    str34 = str2;
                    str22 = str3;
                    num3 = num;
                    str27 = str12;
                    str21 = str7;
                }
                int i20 = length4;
                String str59 = str22;
                String str60 = str21;
                p061l.c cVar30 = cVar10;
                String str61 = str35;
                String str62 = str31;
                String str63 = str36;
                eVar3.e(cVar9);
                if (cls10.isInterface() || Modifier.isAbstract(cls10.getModifiers())) {
                    i6 = 1;
                } else {
                    i6 = 1;
                    a(aVar2, eVar3, true);
                }
                eVar3.e(cVar6);
                eVar3.i(25, i6);
                eVar3.i(25, aVar2.b("context"));
                eVar3.g(182, str61, str63, "(" + c.b(i.class) + str60);
                p061l.c cVar31 = new p061l.c();
                eVar3.i(25, aVar2.b("childContext"));
                eVar3.d(198, cVar31);
                eVar3.i(25, aVar2.b("childContext"));
                eVar3.i(25, aVar2.b("instance"));
                eVar3.a(181, c.e(i.class), "object", "Ljava/lang/Object;");
                eVar3.e(cVar31);
                eVar3.i(25, aVar2.b("instance"));
                g gVar3 = aVar2.d;
                Method method = gVar3.f7913f;
                if (method != null) {
                    Class cls13 = gVar3.b;
                    if (cls13 == null) {
                        cls13 = aVar2.c;
                    }
                    eVar3.g(182, c.e(cls13), method.getName(), str62 + c.b(method.getReturnType()));
                }
                eVar3.b(176);
                eVar3.e(cVar30);
                a(aVar2, eVar3, true);
                eVar3.i(25, 0);
                eVar3.i(25, 1);
                eVar3.i(25, 2);
                eVar3.i(25, 3);
                eVar3.i(25, aVar2.b("instance"));
                eVar3.i(21, 4);
                int i21 = i20 / 32;
                if (i20 != 0 && i20 % 32 != 0) {
                    i21++;
                }
                if (i21 == 1) {
                    eVar3.b(4);
                } else {
                    eVar3.c(16, i21);
                }
                eVar3.c(188, 10);
                for (int i22 = 0; i22 < i21; i22++) {
                    eVar3.b(89);
                    if (i22 == 0) {
                        eVar3.b(3);
                    } else {
                        if (i22 == 1) {
                            eVar3.b(4);
                        } else {
                            eVar3.c(16, i22);
                        }
                        eVar3.i(21, aVar2.b("_asm_flag_" + i22));
                        eVar3.b(79);
                    }
                    eVar3.i(21, aVar2.b("_asm_flag_" + i22));
                    eVar3.b(79);
                }
                eVar3.g(182, c.e(m.class), "parseRest", AbstractC0157z.o(str59, str61, ";Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;I[I)Ljava/lang/Object;"));
                eVar3.h(192, c.e(cls10));
                eVar3.b(176);
                eVar3.e(cVar5);
                eVar3.i(25, 0);
                eVar3.i(25, 1);
                eVar3.i(25, 2);
                eVar3.i(25, 3);
                eVar3.i(21, 4);
                eVar3.g(183, c.e(m.class), str24, AbstractC0157z.o(str59, str61, ";Ljava/lang/reflect/Type;Ljava/lang/Object;I)Ljava/lang/Object;"));
                eVar3.b(176);
                int i23 = aVar2.f6183a;
                eVar3.f5767h = 10;
                eVar3.f5768i = i23;
                break;
            }
            d dVar6 = dVarArr2[i12];
            Class cls14 = dVar6.e;
            Type type2 = dVar6.f7885f;
            d[] dVarArr3 = dVarArr2;
            if (cls14 == Character.TYPE || (Collection.class.isAssignableFrom(cls14) && (!(type2 instanceof ParameterizedType) || !(((ParameterizedType) type2).getActualTypeArguments()[0] instanceof Class)))) {
                break;
                break;
            }
            i12++;
            dVarArr2 = dVarArr3;
        }
        e(aVar, new a(str18, gVar, 4));
        byte[] bArrF = aVar.f();
        return (p) this.f6185a.defineClassPublic(strO, bArrF, 0, bArrF.length).getConstructor(p067m.j.class, g.class).newInstance(jVar, gVar);
    }
}
