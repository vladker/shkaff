package com.google.android.gms.internal.play_billing;

import A3.AbstractC0157z;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
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
final class zzht {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, Chars.SPACE);
    }

    public static String zza(zzhr zzhrVar, String str) {
        StringBuilder sbX = AbstractC0157z.x("# ", str);
        zzd(zzhrVar, sbX, 0);
        return sbX.toString();
    }

    public static void zzb(StringBuilder sb, int i5, String str, Object obj) {
        String strReplace;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i5, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i5, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i5, sb);
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
        if (!(obj instanceof String)) {
            if (obj instanceof zzfp) {
                sb.append(": \"");
                sb.append(zzio.zza(((zzfp) obj).zzm()));
                sb.append(Chars.DQUOTE);
                return;
            }
            if (obj instanceof zzgp) {
                sb.append(" {");
                zzd((zzgp) obj, sb, i5 + 2);
                sb.append("\n");
                zzc(i5, sb);
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
            zzb(sb, i7, Constants.KEY, entry.getKey());
            zzb(sb, i7, "value", entry.getValue());
            sb.append("\n");
            zzc(i5, sb);
            sb.append(VectorFormat.DEFAULT_SUFFIX);
            return;
        }
        sb.append(": \"");
        String strReplace2 = (String) obj;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        for (int i8 = 0; i8 < strReplace2.length(); i8++) {
            char cCharAt2 = strReplace2.charAt(i8);
            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                strReplace = zzio.zza(strReplace2.getBytes(StandardCharsets.UTF_8));
                sb.append(strReplace);
                sb.append(Chars.DQUOTE);
            } else {
                if (cCharAt2 == '\"') {
                    z8 = true;
                } else if (cCharAt2 == '\'') {
                    z7 = true;
                } else if (cCharAt2 == '\\') {
                    z6 = true;
                }
            }
        }
        if (z6) {
            strReplace2 = strReplace2.replace("\\", "\\\\");
        }
        strReplace = z7 ? strReplace2.replace("'", "\\'") : strReplace2;
        if (z8) {
            strReplace = strReplace.replace("\"", "\\\"");
        }
        sb.append(strReplace);
        sb.append(Chars.DQUOTE);
    }

    private static void zzc(int i5, StringBuilder sb) {
        while (i5 > 0) {
            int i6 = 80;
            if (i5 <= 80) {
                i6 = i5;
            }
            sb.append(zza, 0, i6);
            i5 -= i6;
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:66:0x017f  */
    private static void zzd(zzhr zzhrVar, StringBuilder sb, int i5) {
        int i6;
        boolean zBooleanValue;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzhrVar.getClass().getDeclaredMethods();
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
                zzb(sb, i5, strSubstring.substring(0, strSubstring.length() - 4), zzgp.zzx(method2, zzhrVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i5, strSubstring.substring(0, strSubstring.length() - 3), zzgp.zzx(method, zzhrVar, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objZzx = zzgp.zzx(method4, zzhrVar, new Object[0]);
                    if (method5 != null) {
                        zBooleanValue = ((Boolean) zzgp.zzx(method5, zzhrVar, new Object[0])).booleanValue();
                    } else if (objZzx instanceof Boolean) {
                        if (((Boolean) objZzx).booleanValue()) {
                            zBooleanValue = true;
                        } else {
                            zBooleanValue = false;
                        }
                    } else if (objZzx instanceof Integer) {
                        if (((Integer) objZzx).intValue() == 0) {
                            zBooleanValue = false;
                        } else {
                            zBooleanValue = true;
                        }
                    } else if (objZzx instanceof Float) {
                        if (Float.floatToRawIntBits(((Float) objZzx).floatValue()) == 0) {
                            zBooleanValue = false;
                        } else {
                            zBooleanValue = true;
                        }
                    } else if (!(objZzx instanceof Double)) {
                        if (objZzx instanceof String) {
                            zEquals = objZzx.equals("");
                        } else if (objZzx instanceof zzfp) {
                            zEquals = objZzx.equals(zzfp.zza);
                        } else if (!(objZzx instanceof zzhr) ? !((objZzx instanceof Enum) && ((Enum) objZzx).ordinal() == 0) : objZzx != ((zzhr) objZzx).zzl()) {
                            zBooleanValue = true;
                        } else {
                            zBooleanValue = false;
                        }
                        if (zEquals) {
                            zBooleanValue = false;
                        } else {
                            zBooleanValue = true;
                        }
                    } else if (Double.doubleToRawLongBits(((Double) objZzx).doubleValue()) == 0) {
                        zBooleanValue = false;
                    } else {
                        zBooleanValue = true;
                    }
                    if (zBooleanValue) {
                        zzb(sb, i5, strSubstring, objZzx);
                    }
                }
            }
            i6 = 3;
        }
        if (zzhrVar instanceof zzgm) {
            Iterator itZzf = ((zzgm) zzhrVar).zzb.zzf();
            if (itZzf.hasNext()) {
                throw null;
            }
        }
        zzir zzirVar = ((zzgp) zzhrVar).zzc;
        if (zzirVar != null) {
            zzirVar.zzi(sb, i5);
        }
    }
}
