package p079o;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import p050j.a;
import p050j.e;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public final class M extends a0 implements Q {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final M f6339i = new M();

    /* JADX WARN: Code duplicated, block: B:166:0x022b A[Catch: all -> 0x0068, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0231 A[Catch: all -> 0x0068, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x0236 A[Catch: all -> 0x0068, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:173:0x0241 A[Catch: all -> 0x0068, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:175:0x0248 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:176:0x024a A[Catch: all -> 0x0068, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:185:0x026a A[Catch: all -> 0x0068, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:188:0x0278 A[Catch: all -> 0x0068, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x027d A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #2 {all -> 0x0068, blocks: (B:22:0x0044, B:24:0x0055, B:36:0x0072, B:38:0x0083, B:39:0x008e, B:41:0x0094, B:43:0x00a6, B:46:0x00ae, B:49:0x00b3, B:51:0x00bd, B:53:0x00c1, B:54:0x00c8, B:55:0x00ce, B:57:0x00d2, B:60:0x00da, B:63:0x00df, B:65:0x00e9, B:67:0x00ed, B:68:0x00f4, B:69:0x00fa, B:71:0x00fe, B:74:0x0106, B:77:0x010b, B:79:0x0115, B:81:0x0119, B:82:0x0120, B:83:0x0126, B:85:0x012a, B:88:0x0132, B:91:0x0137, B:93:0x0141, B:95:0x0145, B:96:0x014c, B:97:0x0152, B:99:0x0156, B:102:0x015e, B:105:0x0163, B:107:0x016d, B:109:0x0171, B:110:0x0179, B:111:0x017e, B:113:0x0182, B:116:0x018a, B:119:0x018f, B:121:0x0199, B:123:0x019d, B:124:0x01a5, B:125:0x01aa, B:127:0x01b0, B:133:0x01c0, B:136:0x01c5, B:138:0x01cf, B:142:0x01e2, B:144:0x01e8, B:150:0x01f8, B:153:0x01fd, B:155:0x0207, B:160:0x021c, B:166:0x022b, B:168:0x0231, B:170:0x0236, B:171:0x0239, B:173:0x0241, B:174:0x0244, B:188:0x0278, B:190:0x027d, B:199:0x029e, B:176:0x024a, B:177:0x024d, B:179:0x0255, B:181:0x025d, B:184:0x0266, B:186:0x0271, B:185:0x026a, B:157:0x020b, B:158:0x0213, B:147:0x01f0, B:140:0x01d3, B:141:0x01db, B:130:0x01b8, B:33:0x006b), top: B:215:0x0044 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0283  */
    /* JADX WARN: Code duplicated, block: B:197:0x0295 A[Catch: all -> 0x0291, TRY_LEAVE, TryCatch #1 {all -> 0x0291, blocks: (B:193:0x0289, B:197:0x0295), top: B:213:0x0289 }] */
    @Override // p079o.Q, p079o.InterfaceC1290t
    public void write(G g6, Object obj, Object obj2, Type type, int i5) throws Throwable {
        Map treeMap;
        G g7;
        boolean z6;
        Class<?> cls;
        G g8;
        Q q6;
        G g9 = g6;
        b0 b0Var = g9.f6325j;
        Y y6 = g9.f6324i;
        if (obj == null) {
            b0Var.n();
            return;
        }
        Map map = (Map) obj;
        int i6 = c0.MapSortField.f6406a;
        if (((b0Var.c & i6) == 0 && (i5 & i6) == 0) || (map instanceof SortedMap) || (map instanceof LinkedHashMap)) {
            treeMap = map;
        } else {
            try {
                treeMap = new TreeMap(map);
            } catch (Exception unused) {
                treeMap = map;
            }
        }
        if (g6.e(obj)) {
            g6.j(obj);
            return;
        }
        W w6 = g9.f6331p;
        g9.g(w6, obj, obj2, 0);
        try {
            b0Var.write(123);
            g9.f6326k++;
            if (b0Var.d(c0.WriteClassName)) {
                String str = y6.c;
                Class<?> cls2 = treeMap.getClass();
                if (cls2 == e.class || cls2 == HashMap.class || cls2 == LinkedHashMap.class) {
                    z6 = treeMap.containsKey(str);
                }
                b0Var.g(str);
                b0Var.q(obj.getClass().getName());
            }
            Class<?> cls3 = null;
            Q q7 = null;
            g9 = g9;
            for (Map.Entry entry : treeMap.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                ArrayList arrayList = g9.f6356f;
                if (arrayList != null && arrayList.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        b(g6);
                    } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                        a.g(key);
                        b(g6);
                    }
                }
                ArrayList arrayList2 = this.f6356f;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        b(g6);
                    } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                        a.g(key);
                        b(g6);
                    }
                }
                ArrayList arrayList3 = g9.c;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        a(g6);
                    } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                        a.g(key);
                        a(g6);
                    }
                }
                ArrayList arrayList4 = this.c;
                if (arrayList4 != null && arrayList4.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        a(g6);
                    } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                        a.g(key);
                        a(g6);
                    }
                }
                ArrayList arrayList5 = g9.e;
                Object obj3 = key;
                if (arrayList5 != null && arrayList5.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        String str2 = (String) key;
                        c(g9, str2);
                        obj3 = str2;
                    } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                        obj3 = key;
                        String strG = a.g(key);
                        c(g9, strG);
                        obj3 = strG;
                    }
                }
                obj3 = key;
                obj3 = key;
                ArrayList arrayList6 = this.e;
                Object obj4 = obj3;
                if (arrayList6 != null && arrayList6.size() > 0) {
                    if (obj3 == null || (obj3 instanceof String)) {
                        String str3 = (String) obj3;
                        c(g9, str3);
                        obj4 = str3;
                    } else if (obj3.getClass().isPrimitive() || (obj3 instanceof Number)) {
                        obj4 = obj3;
                        String strG2 = a.g(obj3);
                        c(g9, strG2);
                        obj4 = strG2;
                    }
                }
                obj4 = obj3;
                obj4 = obj3;
                ArrayList arrayList7 = g9.d;
                ArrayList arrayList8 = this.f6358h;
                if ((arrayList7 != null && arrayList7.size() > 0) || (arrayList8 != null && arrayList8.size() > 0)) {
                    if (obj4 == null || (obj4 instanceof String)) {
                        value = d(g9, value, null);
                    } else if (obj4.getClass().isPrimitive() || (obj4 instanceof Number)) {
                        a.g(obj4);
                        value = d(g9, value, null);
                    }
                }
                ArrayList arrayList9 = this.d;
                ArrayList arrayList10 = this.f6358h;
                if ((arrayList9 != null && arrayList9.size() > 0) || (arrayList10 != null && arrayList10.size() > 0)) {
                    if (obj4 == null || (obj4 instanceof String)) {
                        value = d(g9, value, null);
                    } else if (obj4.getClass().isPrimitive() || (obj4 instanceof Number)) {
                        a.g(obj4);
                        value = d(g9, value, null);
                    }
                }
                if (value != null) {
                    if (obj4 instanceof String) {
                        String str4 = (String) obj4;
                        if (!z6) {
                            b0Var.write(44);
                        }
                        if (b0Var.d(c0.PrettyFormat)) {
                            g9.f();
                        }
                        b0Var.g(str4);
                    } else {
                        if (!z6) {
                            b0Var.write(44);
                        }
                        if (!b0Var.d(c0.BrowserCompatible) || b0Var.d(c0.WriteNonStringKeyAsString) || b0Var.d(c0.BrowserSecure)) {
                            g9.i(a.g(obj4));
                        } else {
                            g9.h(obj4);
                        }
                        b0Var.write(58);
                    }
                    if (value == null) {
                        b0Var.n();
                        g9 = g9;
                        q7 = q7;
                    } else {
                        cls = value.getClass();
                        if (cls == cls3) {
                            Class<?> cls4 = cls3;
                            Q q8 = q7;
                            cls = cls4;
                            try {
                                q8.write(g9, value, obj4, null, 0);
                                g8 = g6;
                                q6 = q8;
                            } catch (Throwable th) {
                                th = th;
                                g7 = g6;
                                g7.f6331p = w6;
                                throw th;
                            }
                        } else {
                            Object obj5 = value;
                            Q qB = y6.b(cls);
                            G g10 = g6;
                            qB.write(g10, obj5, obj4, null, 0);
                            q6 = qB;
                            g8 = g10;
                        }
                        q7 = q6;
                        cls3 = cls;
                        g9 = g8;
                    }
                    z6 = false;
                } else if ((c0.f6383G & b0Var.c) != 0) {
                    if (obj4 instanceof String) {
                        String str5 = (String) obj4;
                        if (!z6) {
                            b0Var.write(44);
                        }
                        if (b0Var.d(c0.PrettyFormat)) {
                            g9.f();
                        }
                        b0Var.g(str5);
                    } else {
                        if (!z6) {
                            b0Var.write(44);
                        }
                        if (b0Var.d(c0.BrowserCompatible)) {
                            g9.i(a.g(obj4));
                        } else {
                            g9.i(a.g(obj4));
                        }
                        b0Var.write(58);
                    }
                    if (value == null) {
                        b0Var.n();
                        g9 = g9;
                        q7 = q7;
                    } else {
                        cls = value.getClass();
                        if (cls == cls3) {
                            Class<?> cls5 = cls3;
                            Q q9 = q7;
                            cls = cls5;
                            q9.write(g9, value, obj4, null, 0);
                            g8 = g6;
                            q6 = q9;
                        } else {
                            Object obj6 = value;
                            Q qB2 = y6.b(cls);
                            G g11 = g6;
                            qB2.write(g11, obj6, obj4, null, 0);
                            q6 = qB2;
                            g8 = g11;
                        }
                        q7 = q6;
                        cls3 = cls;
                        g9 = g8;
                    }
                    z6 = false;
                } else {
                    continue;
                }
                g9 = g9;
                q7 = q7;
            }
            g9.f6331p = w6;
            g9.f6326k--;
            if (b0Var.d(c0.PrettyFormat) && treeMap.size() > 0) {
                g9.f();
            }
            b0Var.write(125);
        } catch (Throwable th2) {
            th = th2;
            g7 = g9;
        }
    }
}
