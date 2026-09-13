package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private void writeBoolListInternal(int i5, BooleanArrayList booleanArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < booleanArrayList.size()) {
                this.output.writeBool(i5, booleanArrayList.getBoolean(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeBoolSizeNoTag = 0;
        for (int i7 = 0; i7 < booleanArrayList.size(); i7++) {
            iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(booleanArrayList.getBoolean(i7));
        }
        this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
        while (i6 < booleanArrayList.size()) {
            this.output.writeBoolNoTag(booleanArrayList.getBoolean(i6));
            i6++;
        }
    }

    private <V> void writeDeterministicBooleanMapEntry(int i5, boolean z6, V v6, MapEntryLite.Metadata<Boolean, V> metadata) {
        this.output.writeTag(i5, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z6), v6));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z6), v6);
    }

    private <V> void writeDeterministicIntegerMap(int i5, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr[i6] = it.next().intValue();
            i6++;
        }
        Arrays.sort(iArr);
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = iArr[i7];
            V v6 = map.get(Integer.valueOf(i8));
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i8), v6));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i8), v6);
        }
    }

    private <V> void writeDeterministicLongMap(int i5, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            jArr[i6] = it.next().longValue();
            i6++;
        }
        Arrays.sort(jArr);
        for (int i7 = 0; i7 < size; i7++) {
            long j6 = jArr[i7];
            V v6 = map.get(Long.valueOf(j6));
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j6), v6));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j6), v6);
        }
    }

    private <K, V> void writeDeterministicMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v6 = map.get(Boolean.FALSE);
                if (v6 != null) {
                    writeDeterministicBooleanMapEntry(i5, false, v6, metadata);
                }
                V v7 = map.get(Boolean.TRUE);
                if (v7 != null) {
                    writeDeterministicBooleanMapEntry(i5, true, v7, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i5, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i5, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i5, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i5, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            strArr[i6] = it.next();
            i6++;
        }
        Arrays.sort(strArr);
        for (int i7 = 0; i7 < size; i7++) {
            String str = strArr[i7];
            V v6 = map.get(str);
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v6));
            MapEntryLite.writeTo(this.output, metadata, str, v6);
        }
    }

    private void writeDoubleListInternal(int i5, DoubleArrayList doubleArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < doubleArrayList.size()) {
                this.output.writeDouble(i5, doubleArrayList.getDouble(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeDoubleSizeNoTag = 0;
        for (int i7 = 0; i7 < doubleArrayList.size(); i7++) {
            iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(doubleArrayList.getDouble(i7));
        }
        this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
        while (i6 < doubleArrayList.size()) {
            this.output.writeDoubleNoTag(doubleArrayList.getDouble(i6));
            i6++;
        }
    }

    private void writeEnumListInternal(int i5, IntArrayList intArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < intArrayList.size()) {
                this.output.writeEnum(i5, intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeEnumSizeNoTag = 0;
        for (int i7 = 0; i7 < intArrayList.size(); i7++) {
            iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i7));
        }
        this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
        while (i6 < intArrayList.size()) {
            this.output.writeEnumNoTag(intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeFixed32ListInternal(int i5, IntArrayList intArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < intArrayList.size()) {
                this.output.writeFixed32(i5, intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeFixed32SizeNoTag = 0;
        for (int i7 = 0; i7 < intArrayList.size(); i7++) {
            iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(intArrayList.getInt(i7));
        }
        this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
        while (i6 < intArrayList.size()) {
            this.output.writeFixed32NoTag(intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeFixed64ListInternal(int i5, LongArrayList longArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < longArrayList.size()) {
                this.output.writeFixed64(i5, longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeFixed64SizeNoTag = 0;
        for (int i7 = 0; i7 < longArrayList.size(); i7++) {
            iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(longArrayList.getLong(i7));
        }
        this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
        while (i6 < longArrayList.size()) {
            this.output.writeFixed64NoTag(longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeFloatListInternal(int i5, FloatArrayList floatArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < floatArrayList.size()) {
                this.output.writeFloat(i5, floatArrayList.getFloat(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeFloatSizeNoTag = 0;
        for (int i7 = 0; i7 < floatArrayList.size(); i7++) {
            iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(floatArrayList.getFloat(i7));
        }
        this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
        while (i6 < floatArrayList.size()) {
            this.output.writeFloatNoTag(floatArrayList.getFloat(i6));
            i6++;
        }
    }

    private void writeInt32ListInternal(int i5, IntArrayList intArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < intArrayList.size()) {
                this.output.writeInt32(i5, intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeInt32SizeNoTag = 0;
        for (int i7 = 0; i7 < intArrayList.size(); i7++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i7));
        }
        this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
        while (i6 < intArrayList.size()) {
            this.output.writeInt32NoTag(intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeInt64ListInternal(int i5, LongArrayList longArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < longArrayList.size()) {
                this.output.writeInt64(i5, longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeInt64SizeNoTag = 0;
        for (int i7 = 0; i7 < longArrayList.size(); i7++) {
            iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i7));
        }
        this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
        while (i6 < longArrayList.size()) {
            this.output.writeInt64NoTag(longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeLazyString(int i5, Object obj) {
        if (obj instanceof String) {
            this.output.writeString(i5, (String) obj);
        } else {
            this.output.writeBytes(i5, (ByteString) obj);
        }
    }

    private void writeSFixed32ListInternal(int i5, IntArrayList intArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < intArrayList.size()) {
                this.output.writeSFixed32(i5, intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeSFixed32SizeNoTag = 0;
        for (int i7 = 0; i7 < intArrayList.size(); i7++) {
            iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(intArrayList.getInt(i7));
        }
        this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
        while (i6 < intArrayList.size()) {
            this.output.writeSFixed32NoTag(intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeSFixed64ListInternal(int i5, LongArrayList longArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < longArrayList.size()) {
                this.output.writeSFixed64(i5, longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeSFixed64SizeNoTag = 0;
        for (int i7 = 0; i7 < longArrayList.size(); i7++) {
            iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(longArrayList.getLong(i7));
        }
        this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
        while (i6 < longArrayList.size()) {
            this.output.writeSFixed64NoTag(longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeSInt32ListInternal(int i5, IntArrayList intArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < intArrayList.size()) {
                this.output.writeSInt32(i5, intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeSInt32SizeNoTag = 0;
        for (int i7 = 0; i7 < intArrayList.size(); i7++) {
            iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i7));
        }
        this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
        while (i6 < intArrayList.size()) {
            this.output.writeSInt32NoTag(intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeSInt64ListInternal(int i5, LongArrayList longArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < longArrayList.size()) {
                this.output.writeSInt64(i5, longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeSInt64SizeNoTag = 0;
        for (int i7 = 0; i7 < longArrayList.size(); i7++) {
            iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i7));
        }
        this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
        while (i6 < longArrayList.size()) {
            this.output.writeSInt64NoTag(longArrayList.getLong(i6));
            i6++;
        }
    }

    private void writeUInt32ListInternal(int i5, IntArrayList intArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < intArrayList.size()) {
                this.output.writeUInt32(i5, intArrayList.getInt(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i7 = 0; i7 < intArrayList.size(); i7++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i7));
        }
        this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i6 < intArrayList.size()) {
            this.output.writeUInt32NoTag(intArrayList.getInt(i6));
            i6++;
        }
    }

    private void writeUInt64ListInternal(int i5, LongArrayList longArrayList, boolean z6) {
        int i6 = 0;
        if (!z6) {
            while (i6 < longArrayList.size()) {
                this.output.writeUInt64(i5, longArrayList.getLong(i6));
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i7 = 0; i7 < longArrayList.size(); i7++) {
            iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i7));
        }
        this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i6 < longArrayList.size()) {
            this.output.writeUInt64NoTag(longArrayList.getLong(i6));
            i6++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.output.getTotalBytesWritten();
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBool(int i5, boolean z6) {
        this.output.writeBool(i5, z6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBoolList(int i5, List<Boolean> list, boolean z6) {
        if (list instanceof BooleanArrayList) {
            writeBoolListInternal(i5, (BooleanArrayList) list, z6);
        } else {
            writeBoolListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytes(int i5, ByteString byteString) {
        this.output.writeBytes(i5, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytesList(int i5, List<ByteString> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.output.writeBytes(i5, list.get(i6));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDouble(int i5, double d) {
        this.output.writeDouble(i5, d);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDoubleList(int i5, List<Double> list, boolean z6) {
        if (list instanceof DoubleArrayList) {
            writeDoubleListInternal(i5, (DoubleArrayList) list, z6);
        } else {
            writeDoubleListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i5) {
        this.output.writeTag(i5, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnum(int i5, int i6) {
        this.output.writeEnum(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnumList(int i5, List<Integer> list, boolean z6) {
        if (list instanceof IntArrayList) {
            writeEnumListInternal(i5, (IntArrayList) list, z6);
        } else {
            writeEnumListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32(int i5, int i6) {
        this.output.writeFixed32(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32List(int i5, List<Integer> list, boolean z6) {
        if (list instanceof IntArrayList) {
            writeFixed32ListInternal(i5, (IntArrayList) list, z6);
        } else {
            writeFixed32ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64(int i5, long j6) {
        this.output.writeFixed64(i5, j6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64List(int i5, List<Long> list, boolean z6) {
        if (list instanceof LongArrayList) {
            writeFixed64ListInternal(i5, (LongArrayList) list, z6);
        } else {
            writeFixed64ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloat(int i5, float f6) {
        this.output.writeFloat(i5, f6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloatList(int i5, List<Float> list, boolean z6) {
        if (list instanceof FloatArrayList) {
            writeFloatListInternal(i5, (FloatArrayList) list, z6);
        } else {
            writeFloatListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeGroup(int i5, Object obj) {
        this.output.writeGroup(i5, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeGroupList(int i5, List<?> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeGroup(i5, list.get(i6));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32(int i5, int i6) {
        this.output.writeInt32(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32List(int i5, List<Integer> list, boolean z6) {
        if (list instanceof IntArrayList) {
            writeInt32ListInternal(i5, (IntArrayList) list, z6);
        } else {
            writeInt32ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64(int i5, long j6) {
        this.output.writeInt64(i5, j6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64List(int i5, List<Long> list, boolean z6) {
        if (list instanceof LongArrayList) {
            writeInt64ListInternal(i5, (LongArrayList) list, z6);
        } else {
            writeInt64ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public <K, V> void writeMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i5, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessage(int i5, Object obj) {
        this.output.writeMessage(i5, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessageList(int i5, List<?> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeMessage(i5, list.get(i6));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageSetItem(int i5, Object obj) {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i5, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i5, (MessageLite) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32(int i5, int i6) {
        this.output.writeSFixed32(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32List(int i5, List<Integer> list, boolean z6) {
        if (list instanceof IntArrayList) {
            writeSFixed32ListInternal(i5, (IntArrayList) list, z6);
        } else {
            writeSFixed32ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64(int i5, long j6) {
        this.output.writeSFixed64(i5, j6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64List(int i5, List<Long> list, boolean z6) {
        if (list instanceof LongArrayList) {
            writeSFixed64ListInternal(i5, (LongArrayList) list, z6);
        } else {
            writeSFixed64ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32(int i5, int i6) {
        this.output.writeSInt32(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32List(int i5, List<Integer> list, boolean z6) {
        if (list instanceof IntArrayList) {
            writeSInt32ListInternal(i5, (IntArrayList) list, z6);
        } else {
            writeSInt32ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64(int i5, long j6) {
        this.output.writeSInt64(i5, j6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64List(int i5, List<Long> list, boolean z6) {
        if (list instanceof LongArrayList) {
            writeSInt64ListInternal(i5, (LongArrayList) list, z6);
        } else {
            writeSInt64ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i5) {
        this.output.writeTag(i5, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeString(int i5, String str) {
        this.output.writeString(i5, str);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeStringList(int i5, List<String> list) {
        int i6 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i6 < list.size()) {
                this.output.writeString(i5, list.get(i6));
                i6++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i6 < list.size()) {
                writeLazyString(i5, lazyStringList.getRaw(i6));
                i6++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32(int i5, int i6) {
        this.output.writeUInt32(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32List(int i5, List<Integer> list, boolean z6) {
        if (list instanceof IntArrayList) {
            writeUInt32ListInternal(i5, (IntArrayList) list, z6);
        } else {
            writeUInt32ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64(int i5, long j6) {
        this.output.writeUInt64(i5, j6);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64List(int i5, List<Long> list, boolean z6) {
        if (list instanceof LongArrayList) {
            writeUInt64ListInternal(i5, (LongArrayList) list, z6);
        } else {
            writeUInt64ListInternal(i5, list, z6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeGroup(int i5, Object obj, Schema schema) {
        this.output.writeGroup(i5, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessage(int i5, Object obj, Schema schema) {
        this.output.writeMessage(i5, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeGroupList(int i5, List<?> list, Schema schema) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeGroup(i5, list.get(i6), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeMessageList(int i5, List<?> list, Schema schema) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeMessage(i5, list.get(i6), schema);
        }
    }

    private void writeBoolListInternal(int i5, List<Boolean> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeBoolSizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i7).booleanValue());
            }
            this.output.writeUInt32NoTag(iComputeBoolSizeNoTag);
            while (i6 < list.size()) {
                this.output.writeBoolNoTag(list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeBool(i5, list.get(i6).booleanValue());
            i6++;
        }
    }

    private void writeDoubleListInternal(int i5, List<Double> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeDoubleSizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i7).doubleValue());
            }
            this.output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
            while (i6 < list.size()) {
                this.output.writeDoubleNoTag(list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeDouble(i5, list.get(i6).doubleValue());
            i6++;
        }
    }

    private void writeEnumListInternal(int i5, List<Integer> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeEnumSizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i7).intValue());
            }
            this.output.writeUInt32NoTag(iComputeEnumSizeNoTag);
            while (i6 < list.size()) {
                this.output.writeEnumNoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeEnum(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeFixed32ListInternal(int i5, List<Integer> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeFixed32SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i7).intValue());
            }
            this.output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeFixed32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeFixed32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeFixed64ListInternal(int i5, List<Long> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeFixed64SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i7).longValue());
            }
            this.output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeFixed64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeFixed64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeFloatListInternal(int i5, List<Float> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeFloatSizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i7).floatValue());
            }
            this.output.writeUInt32NoTag(iComputeFloatSizeNoTag);
            while (i6 < list.size()) {
                this.output.writeFloatNoTag(list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeFloat(i5, list.get(i6).floatValue());
            i6++;
        }
    }

    private void writeInt32ListInternal(int i5, List<Integer> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeInt32SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i7).intValue());
            }
            this.output.writeUInt32NoTag(iComputeInt32SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeInt32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeInt32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeInt64ListInternal(int i5, List<Long> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeInt64SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i7).longValue());
            }
            this.output.writeUInt32NoTag(iComputeInt64SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeInt64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeInt64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeSFixed32ListInternal(int i5, List<Integer> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeSFixed32SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i7).intValue());
            }
            this.output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeSFixed32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSFixed32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    private void writeSFixed64ListInternal(int i5, List<Long> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeSFixed64SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i7).longValue());
            }
            this.output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeSFixed64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSFixed64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeSInt64ListInternal(int i5, List<Long> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeSInt64SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i7).longValue());
            }
            this.output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeSInt64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSInt64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    private void writeUInt64ListInternal(int i5, List<Long> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeUInt64SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i7).longValue());
            }
            this.output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeUInt64NoTag(list.get(i6).longValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeUInt64(i5, list.get(i6).longValue());
            i6++;
        }
    }

    public void writeSInt32ListInternal(int i5, List<Integer> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeSInt32SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i7).intValue());
            }
            this.output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeSInt32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeSInt32(i5, list.get(i6).intValue());
            i6++;
        }
    }

    public void writeUInt32ListInternal(int i5, List<Integer> list, boolean z6) {
        int i6 = 0;
        if (z6) {
            this.output.writeTag(i5, 2);
            int iComputeUInt32SizeNoTag = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i7).intValue());
            }
            this.output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
            while (i6 < list.size()) {
                this.output.writeUInt32NoTag(list.get(i6).intValue());
                i6++;
            }
            return;
        }
        while (i6 < list.size()) {
            this.output.writeUInt32(i5, list.get(i6).intValue());
            i6++;
        }
    }
}
