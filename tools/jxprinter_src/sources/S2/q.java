package S2;

import A3.AbstractC0157z;
import A3.J;
import X3.b0;
import android.app.Activity;
import android.content.Intent;
import com.idlefish.flutterboost.FlutterBoost;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.T;
import p007a4.M;
import p018c4.B0;
import p102s.F;
import p102s.G;
import p108t.C1775g;
import p147z3.Q;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends G3.m implements O3.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f647a;
    public /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(B0 b1, E3.g gVar) {
        super(2, gVar);
        this.f647a = 3;
        this.c = b1;
    }

    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Serializable, java.lang.String[]] */
    @Override // G3.a
    public final E3.g create(Object obj, E3.g gVar) {
        switch (this.f647a) {
            case 0:
                return new q((O3.l) this.b, (Long) this.c, gVar, 0);
            case 1:
                return new q((O3.l) this.b, (Exception) this.c, gVar, 1);
            case 2:
                return new q((T) this.b, (T) this.c, gVar, 2);
            case 3:
                q qVar = new q((B0) this.c, gVar);
                qVar.b = obj;
                return qVar;
            case 4:
                return new q((String) this.c, (O3.l) this.b, gVar);
            case 5:
                return new q((String) this.b, (String[]) this.c, gVar, 5);
            default:
                return new q((String) this.b, (T) this.c, gVar, 6);
        }
    }

    @Override // O3.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f647a) {
            case 0:
                return ((q) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 1:
                return ((q) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 2:
                return ((q) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 3:
                return ((q) create(obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 4:
                return ((q) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            case 5:
                return ((q) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
            default:
                return ((q) create((M) obj, (E3.g) obj2)).invokeSuspend(Q.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0280  */
    @Override // G3.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        boolean z6;
        boolean z7;
        String message;
        String message2;
        String message3;
        String message4;
        String message5;
        String message6;
        String message7;
        switch (this.f647a) {
            case 0:
                F3.i.getCOROUTINE_SUSPENDED();
                p147z3.v.throwOnFailure(obj);
                ((O3.l) this.b).invoke(p147z3.u.a(p147z3.u.m1361constructorimpl((Long) this.c)));
                return Q.INSTANCE;
            case 1:
                F3.i.getCOROUTINE_SUSPENDED();
                p147z3.v.throwOnFailure(obj);
                ((O3.l) this.b).invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure((Exception) this.c))));
                return Q.INSTANCE;
            case 2:
                F3.i.getCOROUTINE_SUSPENDED();
                p147z3.v.throwOnFailure(obj);
                InputStream inputStream = (InputStream) ((T) this.b).f5689a;
                if (inputStream != null) {
                    inputStream.close();
                }
                BufferedInputStream bufferedInputStream = (BufferedInputStream) ((T) this.c).f5689a;
                if (bufferedInputStream == null) {
                    return null;
                }
                bufferedInputStream.close();
                return Q.INSTANCE;
            case 3:
                F3.i.getCOROUTINE_SUSPENDED();
                p147z3.v.throwOnFailure(obj);
                Object obj2 = this.b;
                if (obj2 != null) {
                    return obj2;
                }
                throw new IllegalArgumentException("null element found in " + ((B0) this.c) + '.');
            case 4:
                String strN = "文件已损坏或不是有效的 Excel 文件";
                String str = (String) this.c;
                O3.l lVar = (O3.l) this.b;
                F3.i.getCOROUTINE_SUSPENDED();
                p147z3.v.throwOnFailure(obj);
                try {
                    if (str.length() == 0) {
                        lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("文件路径为空")))));
                        return Q.INSTANCE;
                    }
                    File file = new File(str);
                    if (file.exists() && !file.isFile()) {
                        lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("路径不是有效的文件")))));
                        return Q.INSTANCE;
                    }
                    String lowerCase = b0.substringAfterLast(str, '.', "").toLowerCase(Locale.ROOT);
                    E.e(lowerCase, "toLowerCase(...)");
                    if (!lowerCase.equals("xlsx") && !lowerCase.equals("xls")) {
                        lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("不支持的文件格式，请选择 Excel 文件（.xlsx 或 .xls）")))));
                        return Q.INSTANCE;
                    }
                    if (file.exists()) {
                        long length = file.length();
                        if (length == 0) {
                            lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("文件为空")))));
                            return Q.INSTANCE;
                        }
                        if (length > 52428800) {
                            lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("文件过大，请选择小于 50MB 的文件")))));
                            return Q.INSTANCE;
                        }
                    }
                    Object objM1039readExcelInfoIoAF18A = p056k0.g.m1039readExcelInfoIoAF18A(str);
                    if (objM1039readExcelInfoIoAF18A instanceof z3.u.a) {
                        Throwable thM1362exceptionOrNullimpl = p147z3.u.m1362exceptionOrNullimpl(objM1039readExcelInfoIoAF18A);
                        if (thM1362exceptionOrNullimpl != null && (message7 = thM1362exceptionOrNullimpl.getMessage()) != null && b0.contains((CharSequence) message7, (CharSequence) "HTML", false)) {
                            message = thM1362exceptionOrNullimpl.getMessage();
                            if (message == null) {
                                message = "文件格式错误";
                            }
                        } else if (thM1362exceptionOrNullimpl != null && (message6 = thM1362exceptionOrNullimpl.getMessage()) != null && b0.contains((CharSequence) message6, (CharSequence) "XML", false)) {
                            message = thM1362exceptionOrNullimpl.getMessage();
                            if (message == null) {
                                message = "文件格式错误";
                            }
                        } else if (thM1362exceptionOrNullimpl != null && (message5 = thM1362exceptionOrNullimpl.getMessage()) != null && b0.contains((CharSequence) message5, (CharSequence) "既不是有效的二进制", false)) {
                            message = thM1362exceptionOrNullimpl.getMessage();
                            if (message == null) {
                                message = "文件格式错误";
                            }
                        } else if (thM1362exceptionOrNullimpl != null && (message4 = thM1362exceptionOrNullimpl.getMessage()) != null && b0.contains((CharSequence) message4, (CharSequence) "另存为标准", false)) {
                            message = thM1362exceptionOrNullimpl.getMessage();
                            if (message == null) {
                                message = "文件格式错误";
                            }
                        } else if (thM1362exceptionOrNullimpl != null && (message3 = thM1362exceptionOrNullimpl.getMessage()) != null && b0.contains((CharSequence) message3, (CharSequence) "NotOfficeXmlFileException", false)) {
                            message = "文件格式错误，请确保选择的是有效的 Excel 文件";
                        } else if (thM1362exceptionOrNullimpl != null && (message2 = thM1362exceptionOrNullimpl.getMessage()) != null && b0.contains((CharSequence) message2, (CharSequence) "ZipException", false)) {
                            message = "文件已损坏或不是有效的 Excel 文件";
                        } else if (thM1362exceptionOrNullimpl == null || (message = thM1362exceptionOrNullimpl.getMessage()) == null) {
                            message = "读取 Excel 文件失败";
                        }
                        lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception(message)))));
                    } else {
                        if (objM1039readExcelInfoIoAF18A instanceof z3.u.a) {
                            objM1039readExcelInfoIoAF18A = null;
                        }
                        p056k0.e eVar = (p056k0.e) objM1039readExcelInfoIoAF18A;
                        if (eVar != null) {
                            List<p056k0.d> columnInfos = eVar.getColumnInfos();
                            ArrayList arrayList = new ArrayList(J.collectionSizeOrDefault(columnInfos, 10));
                            for (p056k0.d dVar : columnInfos) {
                                arrayList.add(new C1775g(dVar.getName(), dVar.getFirstValue()));
                            }
                            lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(arrayList)));
                        } else {
                            lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception("读取 Excel 信息失败")))));
                        }
                    }
                    return Q.INSTANCE;
                } catch (Exception e) {
                    String message8 = e.getMessage();
                    if (message8 != null) {
                        z7 = false;
                        boolean zContains = b0.contains((CharSequence) message8, (CharSequence) "HTML", false);
                        z6 = true;
                        if (zContains) {
                            strN = e.getMessage();
                            if (strN == null) {
                                strN = "文件格式错误";
                            }
                        }
                        lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception(strN)))));
                    } else {
                        z6 = true;
                        z7 = false;
                    }
                    String message9 = e.getMessage();
                    if (message9 == null || b0.contains(message9, "XML", z7) != z6) {
                        String message10 = e.getMessage();
                        if (message10 == null || b0.contains(message10, "既不是有效的二进制", z7) != z6) {
                            String message11 = e.getMessage();
                            if (message11 == null || b0.contains(message11, "另存为标准", z7) != z6) {
                                String message12 = e.getMessage();
                                if (message12 == null || b0.contains(message12, "NotOfficeXmlFileException", z7) != z6) {
                                    String message13 = e.getMessage();
                                    if (message13 == null || b0.contains(message13, "ZipException", z7) != z6) {
                                        strN = AbstractC0157z.n("读取文件时发生错误：", e.getMessage());
                                    }
                                } else {
                                    strN = "文件格式错误，请确保选择的是有效的 Excel 文件";
                                }
                            } else {
                                strN = e.getMessage();
                                if (strN == null) {
                                    strN = "文件格式错误";
                                }
                            }
                        } else {
                            strN = e.getMessage();
                            if (strN == null) {
                                strN = "文件格式错误";
                            }
                        }
                    } else {
                        strN = e.getMessage();
                        if (strN == null) {
                            strN = "文件格式错误";
                        }
                    }
                    lVar.invoke(p147z3.u.a(p147z3.u.m1361constructorimpl(p147z3.v.createFailure(new Exception(strN)))));
                }
                break;
            case 5:
                F3.i.getCOROUTINE_SUSPENDED();
                p147z3.v.throwOnFailure(obj);
                F f6 = G.Companion;
                Map<Integer, String> requestCache = f6.getRequestCache();
                f6.getClass();
                requestCache.put(G3.b.boxInt(2345), (String) this.b);
                Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setType("*/*");
                intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) this.c);
                Activity activityCurrentActivity = FlutterBoost.instance().currentActivity();
                f6.getClass();
                activityCurrentActivity.startActivityForResult(intent, 2345);
                return Q.INSTANCE;
            default:
                F3.i.getCOROUTINE_SUSPENDED();
                p147z3.v.throwOnFailure(obj);
                FlutterBoost.instance().sendEventToFlutter((String) this.b, (Map) ((T) this.c).f5689a);
                return Q.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, Serializable serializable, E3.g gVar, int i5) {
        super(2, gVar);
        this.f647a = i5;
        this.b = obj;
        this.c = serializable;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(String str, O3.l lVar, E3.g gVar) {
        super(2, gVar);
        this.f647a = 4;
        this.c = str;
        this.b = lVar;
    }
}
