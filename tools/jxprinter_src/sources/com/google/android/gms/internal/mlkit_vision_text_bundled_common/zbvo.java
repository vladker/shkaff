package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import A3.AbstractC0157z;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
final class zbvo {
    private static final char[] zba;

    static {
        char[] cArr = new char[80];
        zba = cArr;
        Arrays.fill(cArr, Chars.SPACE);
    }

    public static String zba(zbvm zbvmVar, String str) {
        StringBuilder sbX = AbstractC0157z.x("# ", str);
        zbd(zbvmVar, sbX, 0);
        return sbX.toString();
    }

    public static void zbb(StringBuilder sb, int i5, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zbb(sb, i5, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zbb(sb, i5, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zbc(i5, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i6 = 1; i6 < str.length(); i6++) {
                char cCharAt = str.charAt(i6);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zbwj.zba(new zbtb(((String) obj).getBytes(zbuo.zba))));
            sb.append(Chars.DQUOTE);
            return;
        }
        if (obj instanceof zbtc) {
            sb.append(": \"");
            sb.append(zbwj.zba((zbtc) obj));
            sb.append(Chars.DQUOTE);
            return;
        }
        if (obj instanceof zbuf) {
            sb.append(" {");
            zbd((zbuf) obj, sb, i5 + 2);
            sb.append("\n");
            zbc(i5, sb);
            sb.append(VectorFormat.DEFAULT_SUFFIX);
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i7 = i5 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zbb(sb, i7, Constants.KEY, entry.getKey());
        zbb(sb, i7, "value", entry.getValue());
        sb.append("\n");
        zbc(i5, sb);
        sb.append(VectorFormat.DEFAULT_SUFFIX);
    }

    private static void zbc(int i5, StringBuilder sb) {
        while (i5 > 0) {
            int i6 = 80;
            if (i5 <= 80) {
                i6 = i5;
            }
            sb.append(zba, 0, i6);
            i5 -= i6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01fa  */
    private static void zbd(zbvm zbvmVar, StringBuilder sb, int i5) {
        int i6;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zbvmVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i7 = 0;
        while (true) {
            i6 = 3;
            if (i7 >= length) {
                break;
            }
            Method method3 = declaredMethods[i7];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i7++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i6);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zbb(sb, i5, strSubstring.substring(0, strSubstring.length() - 4), zbuf.zbz(method2, zbvmVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zbb(sb, i5, strSubstring.substring(0, strSubstring.length() - 3), zbuf.zbz(method, zbvmVar, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objZbz = zbuf.zbz(method4, zbvmVar, new Object[0]);
                    if (method5 == null) {
                        if (objZbz instanceof Boolean) {
                            if (((Boolean) objZbz).booleanValue()) {
                                zbb(sb, i5, strSubstring, objZbz);
                            }
                        } else if (objZbz instanceof Integer) {
                            if (((Integer) objZbz).intValue() != 0) {
                                zbb(sb, i5, strSubstring, objZbz);
                            }
                        } else if (objZbz instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZbz).floatValue()) != 0) {
                                zbb(sb, i5, strSubstring, objZbz);
                            }
                        } else if (!(objZbz instanceof Double)) {
                            if (objZbz instanceof String) {
                                zEquals = objZbz.equals("");
                            } else if (objZbz instanceof zbtc) {
                                zEquals = objZbz.equals(zbtc.zbb);
                            } else if (objZbz instanceof zbvm) {
                                if (objZbz != ((zbvm) objZbz).zbm()) {
                                    zbb(sb, i5, strSubstring, objZbz);
                                }
                            } else if (!(objZbz instanceof Enum) || ((Enum) objZbz).ordinal() != 0) {
                                zbb(sb, i5, strSubstring, objZbz);
                            }
                            if (!zEquals) {
                                zbb(sb, i5, strSubstring, objZbz);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZbz).doubleValue()) != 0) {
                            zbb(sb, i5, strSubstring, objZbz);
                        }
                    } else if (((Boolean) zbuf.zbz(method5, zbvmVar, new Object[0])).booleanValue()) {
                        zbb(sb, i5, strSubstring, objZbz);
                    }
                }
            }
            i6 = 3;
        }
        if (zbvmVar instanceof zbub) {
            Iterator itZbg = ((zbub) zbvmVar).zbb.zbg();
            while (itZbg.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itZbg.next();
                zbb(sb, i5, "[32149011]", entry2.getValue());
            }
        }
        zbwm zbwmVar = ((zbuf) zbvmVar).zbc;
        if (zbwmVar != null) {
            zbwmVar.zbi(sb, i5);
        }
    }
}
