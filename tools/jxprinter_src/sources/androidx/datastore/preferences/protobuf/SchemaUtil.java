package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    public static int computeSizeBoolList(int i5, List<?> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z6) {
            return CodedOutputStream.computeBoolSize(i5, true) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i5, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        for (int i6 = 0; i6 < list.size(); i6++) {
            iComputeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i6));
        }
        return iComputeTagSize;
    }

    public static int computeSizeEnumList(int i5, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i5) * size) + iComputeSizeEnumListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeEnumListNoTag) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeEnumSizeNoTag = 0;
            while (i5 < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i5).intValue());
                i5++;
            }
            return iComputeEnumSizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeEnumSizeNoTag2 = 0;
        while (i5 < size) {
            iComputeEnumSizeNoTag2 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i5));
            i5++;
        }
        return iComputeEnumSizeNoTag2;
    }

    public static int computeSizeFixed32List(int i5, List<?> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z6) {
            return CodedOutputStream.computeFixed32Size(i5, 0) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 4) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i5, List<?> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z6) {
            return CodedOutputStream.computeFixed64Size(i5, 0L) * size;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(size * 8) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i5, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i6 = 0; i6 < size; i6++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i5, list.get(i6));
        }
        return iComputeGroupSize;
    }

    public static int computeSizeInt32List(int i5, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i5) * size) + iComputeSizeInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt32ListNoTag) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeInt32SizeNoTag = 0;
            while (i5 < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
            return iComputeInt32SizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeInt32SizeNoTag2 = 0;
        while (i5 < size) {
            iComputeInt32SizeNoTag2 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i5));
            i5++;
        }
        return iComputeInt32SizeNoTag2;
    }

    public static int computeSizeInt64List(int i5, List<Long> list, boolean z6) {
        if (list.size() == 0) {
            return 0;
        }
        int iComputeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        if (z6) {
            return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt64ListNoTag) + CodedOutputStream.computeTagSize(i5);
        }
        return (CodedOutputStream.computeTagSize(i5) * list.size()) + iComputeSizeInt64ListNoTag;
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iComputeInt64SizeNoTag = 0;
            while (i5 < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
            return iComputeInt64SizeNoTag;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iComputeInt64SizeNoTag2 = 0;
        while (i5 < size) {
            iComputeInt64SizeNoTag2 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i5));
            i5++;
        }
        return iComputeInt64SizeNoTag2;
    }

    public static int computeSizeMessage(int i5, Object obj, Schema schema) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSize(i5, (LazyFieldLite) obj) : CodedOutputStream.computeMessageSize(i5, (MessageLite) obj, schema);
    }

    public static int computeSizeMessageList(int i5, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            iComputeTagSize = (obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj)) + iComputeTagSize;
        }
        return iComputeTagSize;
    }

    public static int computeSizeSInt32List(int i5, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i5) * size) + iComputeSizeSInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt32ListNoTag) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeSInt32SizeNoTag = 0;
            while (i5 < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
            return iComputeSInt32SizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeSInt32SizeNoTag2 = 0;
        while (i5 < size) {
            iComputeSInt32SizeNoTag2 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i5));
            i5++;
        }
        return iComputeSInt32SizeNoTag2;
    }

    public static int computeSizeSInt64List(int i5, List<Long> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i5) * size) + iComputeSizeSInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt64ListNoTag) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iComputeSInt64SizeNoTag = 0;
            while (i5 < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
            return iComputeSInt64SizeNoTag;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iComputeSInt64SizeNoTag2 = 0;
        while (i5 < size) {
            iComputeSInt64SizeNoTag2 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i5));
            i5++;
        }
        return iComputeSInt64SizeNoTag2;
    }

    public static int computeSizeStringList(int i5, List<?> list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        if (!(list instanceof LazyStringList)) {
            while (i6 < size) {
                Object obj = list.get(i6);
                iComputeTagSize = (obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj)) + iComputeTagSize;
                i6++;
            }
            return iComputeTagSize;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i6 < size) {
            Object raw = lazyStringList.getRaw(i6);
            iComputeTagSize = (raw instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) raw) : CodedOutputStream.computeStringSizeNoTag((String) raw)) + iComputeTagSize;
            i6++;
        }
        return iComputeTagSize;
    }

    public static int computeSizeUInt32List(int i5, List<Integer> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i5) * size) + iComputeSizeUInt32ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt32ListNoTag) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof IntArrayList)) {
            int iComputeUInt32SizeNoTag = 0;
            while (i5 < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i5).intValue());
                i5++;
            }
            return iComputeUInt32SizeNoTag;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int iComputeUInt32SizeNoTag2 = 0;
        while (i5 < size) {
            iComputeUInt32SizeNoTag2 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i5));
            i5++;
        }
        return iComputeUInt32SizeNoTag2;
    }

    public static int computeSizeUInt64List(int i5, List<Long> list, boolean z6) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        if (!z6) {
            return (CodedOutputStream.computeTagSize(i5) * size) + iComputeSizeUInt64ListNoTag;
        }
        return CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt64ListNoTag) + CodedOutputStream.computeTagSize(i5);
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int size = list.size();
        int i5 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof LongArrayList)) {
            int iComputeUInt64SizeNoTag = 0;
            while (i5 < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i5).longValue());
                i5++;
            }
            return iComputeUInt64SizeNoTag;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int iComputeUInt64SizeNoTag2 = 0;
        while (i5 < size) {
            iComputeUInt64SizeNoTag2 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i5));
            i5++;
        }
        return iComputeUInt64SizeNoTag2;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i5, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (enumLiteMap.findValueByNumber(iIntValue) == null) {
                    ub = (UB) storeUnknownEnum(obj, i5, iIntValue, ub, unknownFieldSchema);
                    it.remove();
                }
            }
            return ub;
        }
        int size = list.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Integer num = list.get(i7);
            int iIntValue2 = num.intValue();
            if (enumLiteMap.findValueByNumber(iIntValue2) != null) {
                if (i7 != i6) {
                    list.set(i6, num);
                }
                i6++;
            } else {
                ub = (UB) storeUnknownEnum(obj, i5, iIntValue2, ub, unknownFieldSchema);
            }
        }
        if (i6 != size) {
            list.subList(i6, size).clear();
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            java.lang.reflect.Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t6, T t7) {
        FieldSet<T> extensions = extensionSchema.getExtensions(t7);
        if (extensions.isEmpty()) {
            return;
        }
        extensionSchema.getMutableExtensions(t6).mergeFrom(extensions);
    }

    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t6, T t7, long j6) {
        UnsafeUtil.putObject(t6, j6, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t6, j6), UnsafeUtil.getObject(t7, j6)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t6, T t7) {
        unknownFieldSchema.setToMessage(t6, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t6), unknownFieldSchema.getFromMessage(t7)));
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && !Protobuf.assumeLiteRuntime && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean shouldUseTableSwitch(int i5, int i6, int i7) {
        if (i6 < 40) {
            return true;
        }
        long j6 = ((long) i6) - ((long) i5);
        long j7 = i7;
        return j6 + 10 <= ((j7 + 3) * 3) + ((2 * j7) + 3);
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB storeUnknownEnum(Object obj, int i5, int i6, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i5, i6);
        return ub;
    }

    public static String toCamelCase(String str, boolean z6) {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if ('a' > cCharAt || cCharAt > 'z') {
                if ('A' > cCharAt || cCharAt > 'Z') {
                    if ('0' <= cCharAt && cCharAt <= '9') {
                        sb.append(cCharAt);
                    }
                    z6 = true;
                } else if (i5 != 0 || z6) {
                    sb.append(cCharAt);
                } else {
                    sb.append((char) (cCharAt + Chars.SPACE));
                }
            } else if (z6) {
                sb.append((char) (cCharAt - ' '));
            } else {
                sb.append(cCharAt);
            }
            z6 = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i5, boolean z6, Writer writer) {
        if (z6) {
            writer.writeBool(i5, true);
        }
    }

    public static void writeBoolList(int i5, List<Boolean> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(i5, list, z6);
    }

    public static void writeBytes(int i5, ByteString byteString, Writer writer) {
        if (byteString == null || byteString.isEmpty()) {
            return;
        }
        writer.writeBytes(i5, byteString);
    }

    public static void writeBytesList(int i5, List<ByteString> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBytesList(i5, list);
    }

    public static void writeDouble(int i5, double d, Writer writer) {
        if (Double.doubleToRawLongBits(d) != 0) {
            writer.writeDouble(i5, d);
        }
    }

    public static void writeDoubleList(int i5, List<Double> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(i5, list, z6);
    }

    public static void writeEnum(int i5, int i6, Writer writer) {
        if (i6 != 0) {
            writer.writeEnum(i5, i6);
        }
    }

    public static void writeEnumList(int i5, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(i5, list, z6);
    }

    public static void writeFixed32(int i5, int i6, Writer writer) {
        if (i6 != 0) {
            writer.writeFixed32(i5, i6);
        }
    }

    public static void writeFixed32List(int i5, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(i5, list, z6);
    }

    public static void writeFixed64(int i5, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeFixed64(i5, j6);
        }
    }

    public static void writeFixed64List(int i5, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(i5, list, z6);
    }

    public static void writeFloat(int i5, float f6, Writer writer) {
        if (Float.floatToRawIntBits(f6) != 0) {
            writer.writeFloat(i5, f6);
        }
    }

    public static void writeFloatList(int i5, List<Float> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(i5, list, z6);
    }

    public static void writeGroupList(int i5, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i5, list);
    }

    public static void writeInt32(int i5, int i6, Writer writer) {
        if (i6 != 0) {
            writer.writeInt32(i5, i6);
        }
    }

    public static void writeInt32List(int i5, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(i5, list, z6);
    }

    public static void writeInt64(int i5, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeInt64(i5, j6);
        }
    }

    public static void writeInt64List(int i5, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(i5, list, z6);
    }

    public static void writeLazyFieldList(int i5, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            ((LazyFieldLite) it.next()).writeTo(writer, i5);
        }
    }

    public static void writeMessage(int i5, Object obj, Writer writer) {
        if (obj != null) {
            writer.writeMessage(i5, obj);
        }
    }

    public static void writeMessageList(int i5, List<?> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i5, list);
    }

    public static void writeSFixed32(int i5, int i6, Writer writer) {
        if (i6 != 0) {
            writer.writeSFixed32(i5, i6);
        }
    }

    public static void writeSFixed32List(int i5, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(i5, list, z6);
    }

    public static void writeSFixed64(int i5, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeSFixed64(i5, j6);
        }
    }

    public static void writeSFixed64List(int i5, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(i5, list, z6);
    }

    public static void writeSInt32(int i5, int i6, Writer writer) {
        if (i6 != 0) {
            writer.writeSInt32(i5, i6);
        }
    }

    public static void writeSInt32List(int i5, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(i5, list, z6);
    }

    public static void writeSInt64(int i5, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeSInt64(i5, j6);
        }
    }

    public static void writeSInt64List(int i5, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(i5, list, z6);
    }

    public static void writeString(int i5, Object obj, Writer writer) {
        if (obj instanceof String) {
            writeStringInternal(i5, (String) obj, writer);
        } else {
            writeBytes(i5, (ByteString) obj, writer);
        }
    }

    private static void writeStringInternal(int i5, String str, Writer writer) {
        if (str == null || str.isEmpty()) {
            return;
        }
        writer.writeString(i5, str);
    }

    public static void writeStringList(int i5, List<String> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeStringList(i5, list);
    }

    public static void writeUInt32(int i5, int i6, Writer writer) {
        if (i6 != 0) {
            writer.writeUInt32(i5, i6);
        }
    }

    public static void writeUInt32List(int i5, List<Integer> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(i5, list, z6);
    }

    public static void writeUInt64(int i5, long j6, Writer writer) {
        if (j6 != 0) {
            writer.writeUInt64(i5, j6);
        }
    }

    public static void writeUInt64List(int i5, List<Long> list, Writer writer, boolean z6) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(i5, list, z6);
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static int computeSizeGroupList(int i5, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i6 = 0; i6 < size; i6++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i5, list.get(i6), schema);
        }
        return iComputeGroupSize;
    }

    public static void writeGroupList(int i5, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i5, list, schema);
    }

    public static void writeMessageList(int i5, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i5, list, schema);
    }

    public static int computeSizeMessageList(int i5, List<?> list, Schema schema) {
        int iComputeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            if (obj instanceof LazyFieldLite) {
                iComputeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                iComputeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, schema);
            }
            iComputeTagSize = iComputeMessageSizeNoTag + iComputeTagSize;
        }
        return iComputeTagSize;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i5, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Integer num = list.get(i7);
                int iIntValue = num.intValue();
                if (enumVerifier.isInRange(iIntValue)) {
                    if (i7 != i6) {
                        list.set(i6, num);
                    }
                    i6++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i5, iIntValue, ub, unknownFieldSchema);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
            return ub;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue2 = it.next().intValue();
            if (!enumVerifier.isInRange(iIntValue2)) {
                ub = (UB) storeUnknownEnum(obj, i5, iIntValue2, ub, unknownFieldSchema);
                it.remove();
            }
        }
        return ub;
    }
}
