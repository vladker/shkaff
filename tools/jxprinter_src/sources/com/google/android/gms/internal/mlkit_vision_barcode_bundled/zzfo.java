package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import A3.AbstractC0157z;
import androidx.collection.a;
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
final class zzfo {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, Chars.SPACE);
    }

    public static String zza(zzfm zzfmVar, String str) {
        StringBuilder sbX = AbstractC0157z.x("# ", str);
        zzd(zzfmVar, sbX, 0);
        return sbX.toString();
    }

    public static void zzb(StringBuilder sb, int i5, String str, Object obj) {
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
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzgq.zza(new zzde(((String) obj).getBytes(zzep.zza))));
            sb.append(Chars.DQUOTE);
            return;
        }
        if (obj instanceof zzdf) {
            sb.append(": \"");
            sb.append(zzgq.zza((zzdf) obj));
            sb.append(Chars.DQUOTE);
            return;
        }
        if (obj instanceof zzeh) {
            sb.append(" {");
            zzd((zzeh) obj, sb, i5 + 2);
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

    /* JADX WARN: Code duplicated, block: B:102:0x01fa  */
    private static void zzd(zzfm zzfmVar, StringBuilder sb, int i5) {
        int i6;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzfmVar.getClass().getDeclaredMethods();
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
                zzb(sb, i5, strSubstring.substring(0, strSubstring.length() - 4), zzeh.zzR(method2, zzfmVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i5, strSubstring.substring(0, strSubstring.length() - 3), zzeh.zzR(method, zzfmVar, new Object[0]));
            } else if (hashSet.contains("set".concat(strSubstring)) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(strSubstring));
                if (method4 != null) {
                    Object objZzR = zzeh.zzR(method4, zzfmVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzR instanceof Boolean) {
                            if (((Boolean) objZzR).booleanValue()) {
                                zzb(sb, i5, strSubstring, objZzR);
                            }
                        } else if (objZzR instanceof Integer) {
                            if (((Integer) objZzR).intValue() != 0) {
                                zzb(sb, i5, strSubstring, objZzR);
                            }
                        } else if (objZzR instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzR).floatValue()) != 0) {
                                zzb(sb, i5, strSubstring, objZzR);
                            }
                        } else if (!(objZzR instanceof Double)) {
                            if (objZzR instanceof String) {
                                zEquals = objZzR.equals("");
                            } else if (objZzR instanceof zzdf) {
                                zEquals = objZzR.equals(zzdf.zzb);
                            } else if (objZzR instanceof zzfm) {
                                if (objZzR != ((zzfm) objZzR).zzac()) {
                                    zzb(sb, i5, strSubstring, objZzR);
                                }
                            } else if (!(objZzR instanceof Enum) || ((Enum) objZzR).ordinal() != 0) {
                                zzb(sb, i5, strSubstring, objZzR);
                            }
                            if (!zEquals) {
                                zzb(sb, i5, strSubstring, objZzR);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzR).doubleValue()) != 0) {
                            zzb(sb, i5, strSubstring, objZzR);
                        }
                    } else if (((Boolean) zzeh.zzR(method5, zzfmVar, new Object[0])).booleanValue()) {
                        zzb(sb, i5, strSubstring, objZzR);
                    }
                }
            }
            i6 = 3;
        }
        if (zzfmVar instanceof zzed) {
            Iterator itZzf = ((zzed) zzfmVar).zzb.zzf();
            while (itZzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itZzf.next();
                zzb(sb, i5, a.i(((zzee) entry2.getKey()).zza, "[", "]"), entry2.getValue());
            }
        }
        zzgt zzgtVar = ((zzeh) zzfmVar).zzc;
        if (zzgtVar != null) {
            zzgtVar.zzi(sb, i5);
        }
    }
}
