package org.apache.poi.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public final class GenericRecordUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AnnotatedFlag {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean exactMatch;
        private final Map<Integer, String> masks = new LinkedHashMap();
        private final Supplier<Number> value;

        public AnnotatedFlag(Supplier<Number> supplier, int[] iArr, String[] strArr, boolean z6) {
            this.value = supplier;
            this.exactMatch = z6;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                this.masks.put(Integer.valueOf(iArr[i5]), strArr[i5]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$getDescription$0(int i5, Map.Entry entry) {
            return match(i5, ((Integer) entry.getKey()).intValue());
        }

        private boolean match(int i5, int i6) {
            if (this.exactMatch) {
                return i5 == i6;
            }
            return (i5 & i6) == i6;
        }

        public String getDescription() {
            final int iIntValue = this.value.get().intValue();
            return (String) this.masks.entrySet().stream().filter(new Predicate() { // from class: org.apache.poi.util.f
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return this.f7249a.lambda$getDescription$0(iIntValue, (Map.Entry) obj);
                }
            }).map(new com.google.android.material.color.utilities.g(29)).collect(Collectors.joining(" | "));
        }

        public Supplier<Number> getValue() {
            return this.value;
        }
    }

    private GenericRecordUtil() {
    }

    public static Supplier<AnnotatedFlag> getBitsAsString(Supplier<Number> supplier, BitField[] bitFieldArr, String[] strArr) {
        return new d(supplier, Arrays.stream(bitFieldArr).mapToInt(new O4.a(2)).toArray(), strArr, 1);
    }

    public static Supplier<AnnotatedFlag> getEnumBitsAsString(Supplier<Number> supplier, int[] iArr, String[] strArr) {
        return new d(supplier, iArr, strArr, 2);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier) {
        return Collections.singletonMap(str, supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotatedFlag lambda$getBitsAsString$1(Supplier supplier, int[] iArr, String[] strArr) {
        return new AnnotatedFlag(supplier, iArr, strArr, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotatedFlag lambda$getBitsAsString$2(Supplier supplier, int[] iArr, String[] strArr) {
        return new AnnotatedFlag(supplier, iArr, strArr, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnnotatedFlag lambda$getEnumBitsAsString$3(Supplier supplier, int[] iArr, String[] strArr) {
        return new AnnotatedFlag(supplier, iArr, strArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Enum lambda$safeEnum$0(int i5, Enum[] enumArr, Enum r6) {
        return (i5 < 0 || i5 >= enumArr.length) ? r6 : enumArr[i5];
    }

    public static <T extends Enum<?>> Supplier<T> safeEnum(T[] tArr, Supplier<Number> supplier) {
        return safeEnum(tArr, supplier, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2) {
        return getGenericProperties(str, supplier, str2, supplier2, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static <T extends Enum<?>> Supplier<T> safeEnum(T[] tArr, Supplier<Number> supplier, T t6) {
        return new e(supplier.get().intValue(), tArr, t6);
    }

    public static Supplier<AnnotatedFlag> getBitsAsString(Supplier<Number> supplier, int[] iArr, String[] strArr) {
        return new d(supplier, iArr, strArr, 0);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3) {
        return getGenericProperties(str, supplier, str2, supplier2, str3, supplier3, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4) {
        return getGenericProperties(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, null, null, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5) {
        return getGenericProperties(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, str5, supplier5, null, null, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5, String str6, Supplier<?> supplier6) {
        return getGenericProperties(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, str5, supplier5, str6, supplier6, null, null, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5, String str6, Supplier<?> supplier6, String str7, Supplier<?> supplier7) {
        return getGenericProperties(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, str5, supplier5, str6, supplier6, str7, supplier7, null, null, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5, String str6, Supplier<?> supplier6, String str7, Supplier<?> supplier7, String str8, Supplier<?> supplier8) {
        return getGenericProperties(str, supplier, str2, supplier2, str3, supplier3, str4, supplier4, str5, supplier5, str6, supplier6, str7, supplier7, str8, supplier8, null, null);
    }

    public static Map<String, Supplier<?>> getGenericProperties(String str, Supplier<?> supplier, String str2, Supplier<?> supplier2, String str3, Supplier<?> supplier3, String str4, Supplier<?> supplier4, String str5, Supplier<?> supplier5, String str6, Supplier<?> supplier6, String str7, Supplier<?> supplier7, String str8, Supplier<?> supplier8, String str9, Supplier<?> supplier9) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String[] strArr = {str, str2, str3, str4, str5, str6, str7, str8, str9};
        Supplier[] supplierArr = {supplier, supplier2, supplier3, supplier4, supplier5, supplier6, supplier7, supplier8, supplier9};
        for (int i5 = 0; i5 < 9; i5++) {
            String str10 = strArr[i5];
            if (str10 == null) {
                break;
            }
            if ("base".equals(str10)) {
                linkedHashMap.putAll((Map) supplierArr[i5].get());
            } else {
                linkedHashMap.put(strArr[i5], supplierArr[i5]);
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
