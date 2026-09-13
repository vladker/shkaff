package androidx.datastore.preferences.protobuf;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1, reason: invalid class name */
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i5, int i6, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z6, int[] iArr2, int i7, int i8, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i5;
        this.maxFieldNumber = i6;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z6;
        this.intArray = iArr2;
        this.checkInitializedCount = i7;
        this.repeatedFieldOffsetStart = i8;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t6, T t7, int i5) {
        return isFieldPresent(t6, i5) == isFieldPresent(t7, i5);
    }

    private static <T> boolean booleanAt(T t6, long j6) {
        return UnsafeUtil.getBoolean(t6, j6);
    }

    private static void checkMutable(Object obj) {
        if (!isMutable(obj)) {
            throw new IllegalArgumentException(a.l(obj, "Mutating immutable message: "));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> int decodeMapEntry(byte[] bArr, int i5, int i6, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
        int i7 = registers.int1;
        if (i7 < 0 || i7 > i6 - iDecodeVarint32) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i8 = iDecodeVarint32 + i7;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint32 < i8) {
            int iDecodeVarint33 = iDecodeVarint32 + 1;
            int i9 = bArr[iDecodeVarint32];
            if (i9 < 0) {
                iDecodeVarint33 = ArrayDecoders.decodeVarint32(i9, bArr, iDecodeVarint33, registers);
                i9 = registers.int1;
            }
            int i10 = iDecodeVarint33;
            int i11 = i9 >>> 3;
            int i12 = i9 & 7;
            if (i11 != 1) {
                if (i11 == 2 && i12 == metadata.valueType.getWireType()) {
                    iDecodeVarint32 = decodeMapEntryValue(bArr, i10, i6, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.object1;
                } else {
                    iDecodeVarint32 = ArrayDecoders.skipField(i9, bArr, i10, i6, registers);
                }
            } else if (i12 == metadata.keyType.getWireType()) {
                iDecodeVarint32 = decodeMapEntryValue(bArr, i10, i6, metadata.keyType, null, registers);
                obj = registers.object1;
            } else {
                iDecodeVarint32 = ArrayDecoders.skipField(i9, bArr, i10, i6, registers);
            }
        }
        if (iDecodeVarint32 != i8) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i8;
    }

    private int decodeMapEntryValue(byte[] bArr, int i5, int i6, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                registers.object1 = Boolean.valueOf(registers.long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i5, registers);
            case 3:
                registers.object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i5));
                return i5 + 8;
            case 4:
            case 5:
                registers.object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i5));
                return i5 + 4;
            case 6:
            case 7:
                registers.object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i5));
                return i5 + 8;
            case 8:
                registers.object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i5));
                return i5 + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                registers.object1 = Integer.valueOf(registers.int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                registers.object1 = Long.valueOf(registers.long1);
                return iDecodeVarint65;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i5, i6, registers);
            case 15:
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                registers.object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1));
                return iDecodeVarint33;
            case 16:
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                registers.object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1));
                return iDecodeVarint66;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i5, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t6, long j6) {
        return UnsafeUtil.getDouble(t6, j6);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i5, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i5);
        Object object = UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i5)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i5)) == null) ? ub : (UB) filterUnknownEnumMap(i5, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i5, int i6, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i5));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i6, codedBuilderNewCodedBuilder.build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static <T> float floatAt(T t6, long j6) {
        return UnsafeUtil.getFloat(t6, j6);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i5) {
        return (Internal.EnumVerifier) this.objects[((i5 / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i5) {
        return this.objects[(i5 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i5) {
        int i6 = (i5 / 3) * 2;
        Schema schema = (Schema) this.objects[i6];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i6 + 1]);
        this.objects[i6] = schemaSchemaFor;
        return schemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t6) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t6));
    }

    private static <T> int intAt(T t6, long j6) {
        return UnsafeUtil.getInt(t6, j6);
    }

    private static boolean isEnforceUtf8(int i5) {
        return (i5 & 536870912) != 0;
    }

    private boolean isFieldPresent(T t6, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return isFieldPresent(t6, i5);
        }
        return (i7 & i8) != 0;
    }

    private static boolean isLegacyEnumIsClosed(int i5) {
        return (i5 & Integer.MIN_VALUE) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i5, int i6) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i5));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!messageFieldSchema.isInitialized(list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.datastore.preferences.protobuf.Schema] */
    private boolean isMapInitialized(T t6, int i5, int i6) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t6, offset(i5)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            if (SchemaFor == 0) {
                SchemaFor = SchemaFor;
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            SchemaFor = SchemaFor;
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t6, T t7, int i5) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5) & 1048575;
        return UnsafeUtil.getInt(t6, jPresenceMaskAndOffsetAt) == UnsafeUtil.getInt(t7, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t6, int i5, int i6) {
        return UnsafeUtil.getInt(t6, (long) (presenceMaskAndOffsetAt(i6) & 1048575)) == i5;
    }

    private static boolean isRequired(int i5) {
        return (i5 & 268435456) != 0;
    }

    private static <T> long longAt(T t6, long j6) {
        return UnsafeUtil.getLong(t6, j6);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 20401. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <UT, UB, ET extends androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema<UT, UB> r18, androidx.datastore.preferences.protobuf.ExtensionSchema<ET> r19, T r20, androidx.datastore.preferences.protobuf.Reader r21, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r22) {
        /*
            Method dump skipped, instruction units count: 2040
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.mergeFromHelper(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    private final <K, V> void mergeMap(Object obj, int i5, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jOffset = offset(typeAndOffsetAt(i5));
        Object object = UnsafeUtil.getObject(obj, jOffset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jOffset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jOffset, objNewMapField);
            object = objNewMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t6, T t7, int i5) {
        if (isFieldPresent(t7, i5)) {
            long jOffset = offset(typeAndOffsetAt(i5));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t7, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i5) + " is present but null: " + t7);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i5);
            if (!isFieldPresent(t6, i5)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t6, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t6, jOffset, object);
                }
                setFieldPresent(t6, i5);
                return;
            }
            Object object2 = unsafe.getObject(t6, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t6, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t6, T t7, int i5) {
        int iNumberAt = numberAt(i5);
        if (isOneofPresent(t7, iNumberAt, i5)) {
            long jOffset = offset(typeAndOffsetAt(i5));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t7, jOffset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i5) + " is present but null: " + t7);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i5);
            if (!isOneofPresent(t6, iNumberAt, i5)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t6, jOffset, objNewInstance);
                } else {
                    unsafe.putObject(t6, jOffset, object);
                }
                setOneofPresent(t6, iNumberAt, i5);
                return;
            }
            Object object2 = unsafe.getObject(t6, jOffset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t6, jOffset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t6, T t7, int i5) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i5);
        long jOffset = offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i5);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putDouble(t6, jOffset, UnsafeUtil.getDouble(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 1:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putFloat(t6, jOffset, UnsafeUtil.getFloat(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 2:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 3:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 4:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 5:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 6:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 7:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putBoolean(t6, jOffset, UnsafeUtil.getBoolean(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 8:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 9:
                mergeMessage(t6, t7, i5);
                break;
            case 10:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 11:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 12:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 13:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 14:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 15:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putInt(t6, jOffset, UnsafeUtil.getInt(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 16:
                if (isFieldPresent(t7, i5)) {
                    UnsafeUtil.putLong(t6, jOffset, UnsafeUtil.getLong(t7, jOffset));
                    setFieldPresent(t6, i5);
                }
                break;
            case 17:
                mergeMessage(t6, t7, i5);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t6, t7, jOffset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t6, t7, jOffset);
                break;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t7, iNumberAt, i5)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setOneofPresent(t6, iNumberAt, i5);
                }
                break;
            case 60:
                mergeOneofMessage(t6, t7, i5);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t7, iNumberAt, i5)) {
                    UnsafeUtil.putObject(t6, jOffset, UnsafeUtil.getObject(t7, jOffset));
                    setOneofPresent(t6, iNumberAt, i5);
                }
                break;
            case 68:
                mergeOneofMessage(t6, t7, i5);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t6, int i5) {
        Schema messageFieldSchema = getMessageFieldSchema(i5);
        long jOffset = offset(typeAndOffsetAt(i5));
        if (!isFieldPresent(t6, i5)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t6, jOffset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t6, int i5, int i6) {
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        if (!isOneofPresent(t6, i5, i6)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t6, offset(typeAndOffsetAt(i6)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i5 = 0;
        int i6 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.getType() == FieldType.MAP) {
                i5++;
            } else if (fieldInfo.getType().id() >= 18 && fieldInfo.getType().id() <= 49) {
                i6++;
            }
        }
        int[] iArr2 = i5 > 0 ? new int[i5] : null;
        int[] iArr3 = i6 > 0 ? new int[i6] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i7 < fields.length) {
            FieldInfo fieldInfo2 = fields[i7];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i8, objArr);
            if (i9 < checkInitialized.length && checkInitialized[i9] == fieldNumber3) {
                checkInitialized[i9] = i8;
                i9++;
            }
            if (fieldInfo2.getType() == FieldType.MAP) {
                iArr2[i10] = i8;
                i10++;
            } else {
                if (fieldInfo2.getType().id() >= 18 && fieldInfo2.getType().id() <= 49) {
                    iArr3[i11] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i11++;
                }
                i7++;
                i8 += 3;
            }
            i7++;
            i8 += 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), structuralMessageInfo.getSyntax(), true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x0251  */
    /* JADX WARN: Code duplicated, block: B:122:0x0254  */
    /* JADX WARN: Code duplicated, block: B:125:0x026b  */
    /* JADX WARN: Code duplicated, block: B:126:0x026e  */
    /* JADX WARN: Code duplicated, block: B:163:0x0327  */
    /* JADX WARN: Code duplicated, block: B:180:0x0376  */
    /* JADX WARN: Code duplicated, block: B:183:0x0384  */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i5;
        int iCharAt;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr;
        int i10;
        int i11;
        int i12;
        char cCharAt;
        int i13;
        char cCharAt2;
        int i14;
        char cCharAt3;
        int i15;
        char cCharAt4;
        int i16;
        char cCharAt5;
        int i17;
        char cCharAt6;
        int i18;
        char cCharAt7;
        int i19;
        char cCharAt8;
        int i20;
        int i21;
        int i22;
        int i23;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i24;
        int i25;
        int iObjectFieldOffset3;
        int i26;
        java.lang.reflect.Field fieldReflectField;
        char cCharAt9;
        int i27;
        int i28;
        int i29;
        Object obj;
        java.lang.reflect.Field fieldReflectField2;
        int i30;
        Object obj2;
        java.lang.reflect.Field fieldReflectField3;
        int i31;
        char cCharAt10;
        int i32;
        char cCharAt11;
        int i33;
        char cCharAt12;
        int i34;
        char cCharAt13;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char c = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i35 = 1;
            while (true) {
                i5 = i35 + 1;
                if (stringInfo.charAt(i35) < 55296) {
                    break;
                }
                i35 = i5;
            }
        } else {
            i5 = 1;
        }
        int i36 = i5 + 1;
        int iCharAt2 = stringInfo.charAt(i5);
        if (iCharAt2 >= 55296) {
            int i37 = iCharAt2 & 8191;
            int i38 = 13;
            while (true) {
                i34 = i36 + 1;
                cCharAt13 = stringInfo.charAt(i36);
                if (cCharAt13 < 55296) {
                    break;
                }
                i37 |= (cCharAt13 & 8191) << i38;
                i38 += 13;
                i36 = i34;
            }
            iCharAt2 = i37 | (cCharAt13 << i38);
            i36 = i34;
        }
        if (iCharAt2 == 0) {
            i8 = 0;
            iCharAt = 0;
            i7 = 0;
            i11 = 0;
            i6 = 0;
            i10 = 0;
            iArr = EMPTY_INT_ARRAY;
            i9 = 0;
        } else {
            int i39 = i36 + 1;
            int iCharAt3 = stringInfo.charAt(i36);
            if (iCharAt3 >= 55296) {
                int i40 = iCharAt3 & 8191;
                int i41 = 13;
                while (true) {
                    i19 = i39 + 1;
                    cCharAt8 = stringInfo.charAt(i39);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt8 & 8191) << i41;
                    i41 += 13;
                    i39 = i19;
                }
                iCharAt3 = i40 | (cCharAt8 << i41);
                i39 = i19;
            }
            int i42 = i39 + 1;
            int iCharAt4 = stringInfo.charAt(i39);
            if (iCharAt4 >= 55296) {
                int i43 = iCharAt4 & 8191;
                int i44 = 13;
                while (true) {
                    i18 = i42 + 1;
                    cCharAt7 = stringInfo.charAt(i42);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt7 & 8191) << i44;
                    i44 += 13;
                    i42 = i18;
                }
                iCharAt4 = i43 | (cCharAt7 << i44);
                i42 = i18;
            }
            int i45 = i42 + 1;
            int iCharAt5 = stringInfo.charAt(i42);
            if (iCharAt5 >= 55296) {
                int i46 = iCharAt5 & 8191;
                int i47 = 13;
                while (true) {
                    i17 = i45 + 1;
                    cCharAt6 = stringInfo.charAt(i45);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt6 & 8191) << i47;
                    i47 += 13;
                    i45 = i17;
                }
                iCharAt5 = i46 | (cCharAt6 << i47);
                i45 = i17;
            }
            int i48 = i45 + 1;
            int iCharAt6 = stringInfo.charAt(i45);
            if (iCharAt6 >= 55296) {
                int i49 = iCharAt6 & 8191;
                int i50 = 13;
                while (true) {
                    i16 = i48 + 1;
                    cCharAt5 = stringInfo.charAt(i48);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt5 & 8191) << i50;
                    i50 += 13;
                    i48 = i16;
                }
                iCharAt6 = i49 | (cCharAt5 << i50);
                i48 = i16;
            }
            int i51 = i48 + 1;
            iCharAt = stringInfo.charAt(i48);
            if (iCharAt >= 55296) {
                int i52 = iCharAt & 8191;
                int i53 = 13;
                while (true) {
                    i15 = i51 + 1;
                    cCharAt4 = stringInfo.charAt(i51);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt4 & 8191) << i53;
                    i53 += 13;
                    i51 = i15;
                }
                iCharAt = i52 | (cCharAt4 << i53);
                i51 = i15;
            }
            int i54 = i51 + 1;
            int iCharAt7 = stringInfo.charAt(i51);
            if (iCharAt7 >= 55296) {
                int i55 = iCharAt7 & 8191;
                int i56 = 13;
                while (true) {
                    i14 = i54 + 1;
                    cCharAt3 = stringInfo.charAt(i54);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt3 & 8191) << i56;
                    i56 += 13;
                    i54 = i14;
                }
                iCharAt7 = i55 | (cCharAt3 << i56);
                i54 = i14;
            }
            int i57 = i54 + 1;
            int iCharAt8 = stringInfo.charAt(i54);
            if (iCharAt8 >= 55296) {
                int i58 = iCharAt8 & 8191;
                int i59 = 13;
                while (true) {
                    i13 = i57 + 1;
                    cCharAt2 = stringInfo.charAt(i57);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i58 |= (cCharAt2 & 8191) << i59;
                    i59 += 13;
                    i57 = i13;
                }
                iCharAt8 = i58 | (cCharAt2 << i59);
                i57 = i13;
            }
            int i60 = i57 + 1;
            int iCharAt9 = stringInfo.charAt(i57);
            if (iCharAt9 >= 55296) {
                int i61 = iCharAt9 & 8191;
                int i62 = 13;
                while (true) {
                    i12 = i60 + 1;
                    cCharAt = stringInfo.charAt(i60);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i61 |= (cCharAt & 8191) << i62;
                    i62 += 13;
                    i60 = i12;
                }
                iCharAt9 = i61 | (cCharAt << i62);
                i60 = i12;
            }
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            i6 = (iCharAt3 * 2) + iCharAt4;
            int i63 = iCharAt7;
            i7 = iCharAt5;
            i8 = i63;
            i9 = iCharAt3;
            iArr = iArr2;
            i10 = iCharAt9;
            i36 = i60;
            i11 = iCharAt6;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[iCharAt * 2];
        int i64 = i10 + i8;
        int i65 = i64;
        int i66 = i10;
        int i67 = 0;
        int i68 = 0;
        while (i36 < length) {
            int i69 = i36 + 1;
            int iCharAt10 = stringInfo.charAt(i36);
            if (iCharAt10 >= c) {
                int i70 = iCharAt10 & 8191;
                int i71 = i69;
                int i72 = 13;
                while (true) {
                    i33 = i71 + 1;
                    cCharAt12 = stringInfo.charAt(i71);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i70 |= (cCharAt12 & 8191) << i72;
                    i72 += 13;
                    i71 = i33;
                }
                iCharAt10 = i70 | (cCharAt12 << i72);
                i20 = i33;
            } else {
                i20 = i69;
            }
            int i73 = i20 + 1;
            int iCharAt11 = stringInfo.charAt(i20);
            if (iCharAt11 >= c) {
                int i74 = iCharAt11 & 8191;
                int i75 = i73;
                int i76 = 13;
                while (true) {
                    i32 = i75 + 1;
                    cCharAt11 = stringInfo.charAt(i75);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i74 |= (cCharAt11 & 8191) << i76;
                    i76 += 13;
                    i75 = i32;
                }
                iCharAt11 = i74 | (cCharAt11 << i76);
                i21 = i32;
            } else {
                i21 = i73;
            }
            int i77 = iCharAt11 & 255;
            int i78 = length;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i67] = i68;
                i67++;
            }
            int[] iArr4 = iArr3;
            if (i77 >= 51) {
                int i79 = i21 + 1;
                int iCharAt12 = stringInfo.charAt(i21);
                char c6 = 55296;
                if (iCharAt12 >= 55296) {
                    int i80 = iCharAt12 & 8191;
                    int i81 = 13;
                    while (true) {
                        i31 = i79 + 1;
                        cCharAt10 = stringInfo.charAt(i79);
                        if (cCharAt10 < c6) {
                            break;
                        }
                        i80 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i79 = i31;
                        c6 = 55296;
                    }
                    iCharAt12 = i80 | (cCharAt10 << i81);
                    i79 = i31;
                }
                int i82 = i77 - 51;
                int i83 = i79;
                if (i82 == 9 || i82 == 17) {
                    i28 = i6 + 1;
                    objArr[((i68 / 3) * 2) + 1] = objects[i6];
                } else {
                    if (i82 == 12 && (rawMessageInfo.getSyntax().equals(ProtoSyntax.PROTO2) || (iCharAt11 & 2048) != 0)) {
                        i28 = i6 + 1;
                        objArr[((i68 / 3) * 2) + 1] = objects[i6];
                    }
                    i29 = iCharAt12 * 2;
                    obj = objects[i29];
                    if (obj instanceof java.lang.reflect.Field) {
                        fieldReflectField2 = (java.lang.reflect.Field) obj;
                    } else {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i29] = fieldReflectField2;
                    }
                    int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    i30 = i29 + 1;
                    obj2 = objects[i30];
                    if (obj2 instanceof java.lang.reflect.Field) {
                        fieldReflectField3 = (java.lang.reflect.Field) obj2;
                    } else {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i30] = fieldReflectField3;
                    }
                    i23 = i6;
                    i25 = 0;
                    stringInfo = stringInfo;
                    iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    i26 = iObjectFieldOffset4;
                    i22 = iCharAt10;
                    i36 = i83;
                }
                i6 = i28;
                i29 = iCharAt12 * 2;
                obj = objects[i29];
                if (obj instanceof java.lang.reflect.Field) {
                    fieldReflectField2 = (java.lang.reflect.Field) obj;
                } else {
                    fieldReflectField2 = reflectField(cls, (String) obj);
                    objects[i29] = fieldReflectField2;
                }
                int iObjectFieldOffset5 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                i30 = i29 + 1;
                obj2 = objects[i30];
                if (obj2 instanceof java.lang.reflect.Field) {
                    fieldReflectField3 = (java.lang.reflect.Field) obj2;
                } else {
                    fieldReflectField3 = reflectField(cls, (String) obj2);
                    objects[i30] = fieldReflectField3;
                }
                i23 = i6;
                i25 = 0;
                stringInfo = stringInfo;
                iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                i26 = iObjectFieldOffset5;
                i22 = iCharAt10;
                i36 = i83;
            } else {
                int i84 = i6 + 1;
                java.lang.reflect.Field fieldReflectField4 = reflectField(cls, (String) objects[i6]);
                if (i77 == 9 || i77 == 17) {
                    i22 = iCharAt10;
                    objArr[((i68 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i77 == 27 || i77 == 49) {
                        i22 = iCharAt10;
                        i27 = i6 + 2;
                        objArr[((i68 / 3) * 2) + 1] = objects[i84];
                    } else if (i77 == 12 || i77 == 30 || i77 == 44) {
                        i22 = iCharAt10;
                        if (rawMessageInfo.getSyntax() == ProtoSyntax.PROTO2 || (iCharAt11 & 2048) != 0) {
                            i27 = i6 + 2;
                            objArr[((i68 / 3) * 2) + 1] = objects[i84];
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        if ((iCharAt11 & 4096) != 0 || i77 > 17) {
                            iObjectFieldOffset2 = 1048575;
                            i24 = i21;
                            i25 = 0;
                        } else {
                            int i85 = i21 + 1;
                            int iCharAt13 = stringInfo.charAt(i21);
                            if (iCharAt13 >= 55296) {
                                int i86 = iCharAt13 & 8191;
                                int i87 = 13;
                                while (true) {
                                    i24 = i85 + 1;
                                    cCharAt9 = stringInfo.charAt(i85);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i86 |= (cCharAt9 & 8191) << i87;
                                    i87 += 13;
                                    i85 = i24;
                                }
                                iCharAt13 = i86 | (cCharAt9 << i87);
                            } else {
                                i24 = i85;
                            }
                            int i88 = (iCharAt13 / 32) + (i9 * 2);
                            Object obj3 = objects[i88];
                            if (obj3 instanceof java.lang.reflect.Field) {
                                fieldReflectField = (java.lang.reflect.Field) obj3;
                            } else {
                                fieldReflectField = reflectField(cls, (String) obj3);
                                objects[i88] = fieldReflectField;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                            i25 = iCharAt13 % 32;
                        }
                        int i89 = iObjectFieldOffset2;
                        if (i77 >= 18 && i77 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        iObjectFieldOffset3 = i89;
                        i26 = iObjectFieldOffset;
                        i36 = i24;
                    } else {
                        if (i77 == 50) {
                            int i90 = i66 + 1;
                            iArr[i66] = i68;
                            int i91 = (i68 / 3) * 2;
                            int i92 = i6 + 2;
                            objArr[i91] = objects[i84];
                            if ((iCharAt11 & 2048) != 0) {
                                i23 = i6 + 3;
                                objArr[i91 + 1] = objects[i92];
                                i22 = iCharAt10;
                                i66 = i90;
                            } else {
                                i23 = i92;
                                i66 = i90;
                                i22 = iCharAt10;
                            }
                        } else {
                            i22 = iCharAt10;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                        if ((iCharAt11 & 4096) != 0) {
                            iObjectFieldOffset2 = 1048575;
                            i24 = i21;
                            i25 = 0;
                        } else {
                            iObjectFieldOffset2 = 1048575;
                            i24 = i21;
                            i25 = 0;
                        }
                        int i810 = iObjectFieldOffset2;
                        if (i77 >= 18) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        iObjectFieldOffset3 = i810;
                        i26 = iObjectFieldOffset;
                        i36 = i24;
                    }
                    i23 = i27;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    if ((iCharAt11 & 4096) != 0) {
                        iObjectFieldOffset2 = 1048575;
                        i24 = i21;
                        i25 = 0;
                    } else {
                        iObjectFieldOffset2 = 1048575;
                        i24 = i21;
                        i25 = 0;
                    }
                    int i811 = iObjectFieldOffset2;
                    if (i77 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    iObjectFieldOffset3 = i811;
                    i26 = iObjectFieldOffset;
                    i36 = i24;
                }
                i23 = i84;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                if ((iCharAt11 & 4096) != 0) {
                    iObjectFieldOffset2 = 1048575;
                    i24 = i21;
                    i25 = 0;
                } else {
                    iObjectFieldOffset2 = 1048575;
                    i24 = i21;
                    i25 = 0;
                }
                int i812 = iObjectFieldOffset2;
                if (i77 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                iObjectFieldOffset3 = i812;
                i26 = iObjectFieldOffset;
                i36 = i24;
            }
            int i93 = i68 + 1;
            iArr4[i68] = i22;
            int i94 = i68 + 2;
            int i95 = iObjectFieldOffset3;
            iArr4[i93] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | ((iCharAt11 & 2048) != 0 ? Integer.MIN_VALUE : 0) | (i77 << 20) | i26;
            i68 += 3;
            iArr4[i94] = (i25 << 20) | i95;
            stringInfo = stringInfo;
            i6 = i23;
            length = i78;
            iArr3 = iArr4;
            c = 55296;
        }
        return new MessageSchema<>(iArr3, objArr, i7, i11, rawMessageInfo.getDefaultInstance(), rawMessageInfo.getSyntax(), false, iArr, i10, i64, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i5) {
        return this.buffer[i5];
    }

    private static long offset(int i5) {
        return i5 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t6, long j6) {
        return ((Boolean) UnsafeUtil.getObject(t6, j6)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t6, long j6) {
        return ((Double) UnsafeUtil.getObject(t6, j6)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t6, long j6) {
        return ((Float) UnsafeUtil.getObject(t6, j6)).floatValue();
    }

    private static <T> int oneofIntAt(T t6, long j6) {
        return ((Integer) UnsafeUtil.getObject(t6, j6)).intValue();
    }

    private static <T> long oneofLongAt(T t6, long j6) {
        return ((Long) UnsafeUtil.getObject(t6, j6)).longValue();
    }

    private <K, V> int parseMapField(T t6, byte[] bArr, int i5, int i6, int i7, long j6, ArrayDecoders.Registers registers) {
        Unsafe unsafe = UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i7);
        Object object = unsafe.getObject(t6, j6);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t6, j6, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i5, i6, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    private int parseOneofField(T t6, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j6, int i12, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        Unsafe unsafe = UNSAFE;
        long j7 = this.buffer[i12 + 2] & 1048575;
        switch (i11) {
            case 51:
                if (i9 != 1) {
                    return i5;
                }
                unsafe.putObject(t6, j6, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i5)));
                int i13 = i5 + 8;
                unsafe.putInt(t6, j7, i8);
                return i13;
            case 52:
                if (i9 != 5) {
                    return i5;
                }
                unsafe.putObject(t6, j6, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i5)));
                int i14 = i5 + 4;
                unsafe.putInt(t6, j7, i8);
                return i14;
            case 53:
            case 54:
                if (i9 != 0) {
                    return i5;
                }
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                unsafe.putObject(t6, j6, Long.valueOf(registers.long1));
                unsafe.putInt(t6, j7, i8);
                return iDecodeVarint64;
            case 55:
            case 62:
                if (i9 != 0) {
                    return i5;
                }
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                unsafe.putObject(t6, j6, Integer.valueOf(registers.int1));
                unsafe.putInt(t6, j7, i8);
                return iDecodeVarint32;
            case 56:
            case 65:
                if (i9 != 1) {
                    return i5;
                }
                unsafe.putObject(t6, j6, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i5)));
                int i15 = i5 + 8;
                unsafe.putInt(t6, j7, i8);
                return i15;
            case 57:
            case 64:
                if (i9 != 5) {
                    return i5;
                }
                unsafe.putObject(t6, j6, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i5)));
                int i16 = i5 + 4;
                unsafe.putInt(t6, j7, i8);
                return i16;
            case 58:
                if (i9 != 0) {
                    return i5;
                }
                int iDecodeVarint65 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                unsafe.putObject(t6, j6, Boolean.valueOf(registers.long1 != 0));
                unsafe.putInt(t6, j7, i8);
                return iDecodeVarint65;
            case 59:
                if (i9 != 2) {
                    return i5;
                }
                int iDecodeVarint33 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                int i17 = registers.int1;
                if (i17 == 0) {
                    unsafe.putObject(t6, j6, "");
                } else {
                    if ((i10 & 536870912) != 0 && !Utf8.isValidUtf8(bArr, iDecodeVarint33, iDecodeVarint33 + i17)) {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                    unsafe.putObject(t6, j6, new String(bArr, iDecodeVarint33, i17, Internal.UTF_8));
                    iDecodeVarint33 += i17;
                }
                unsafe.putInt(t6, j7, i8);
                return iDecodeVarint33;
            case 60:
                if (i9 != 2) {
                    return i5;
                }
                Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t6, i8, i12);
                int iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i12), bArr, i5, i6, registers);
                storeOneofMessageField(t6, i8, i12, objMutableOneofMessageFieldForMerge);
                return iMergeMessageField;
            case 61:
                if (i9 != 2) {
                    return i5;
                }
                int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i5, registers);
                unsafe.putObject(t6, j6, registers.object1);
                unsafe.putInt(t6, j7, i8);
                return iDecodeBytes;
            case 63:
                if (i9 != 0) {
                    return i5;
                }
                int iDecodeVarint34 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                int i18 = registers.int1;
                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i12);
                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i18)) {
                    getMutableUnknownFields(t6).storeField(i7, Long.valueOf(i18));
                    return iDecodeVarint34;
                }
                unsafe.putObject(t6, j6, Integer.valueOf(i18));
                unsafe.putInt(t6, j7, i8);
                return iDecodeVarint34;
            case 66:
                if (i9 != 0) {
                    return i5;
                }
                int iDecodeVarint35 = ArrayDecoders.decodeVarint32(bArr, i5, registers);
                unsafe.putObject(t6, j6, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.int1)));
                unsafe.putInt(t6, j7, i8);
                return iDecodeVarint35;
            case 67:
                if (i9 != 0) {
                    return i5;
                }
                int iDecodeVarint66 = ArrayDecoders.decodeVarint64(bArr, i5, registers);
                unsafe.putObject(t6, j6, Long.valueOf(CodedInputStream.decodeZigZag64(registers.long1)));
                unsafe.putInt(t6, j7, i8);
                return iDecodeVarint66;
            case 68:
                if (i9 == 3) {
                    Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t6, i8, i12);
                    int iMergeGroupField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i12), bArr, i5, i6, (i7 & (-8)) | 4, registers);
                    storeOneofMessageField(t6, i8, i12, objMutableOneofMessageFieldForMerge2);
                    return iMergeGroupField;
                }
                break;
        }
        return i5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int parseRepeatedField(T t6, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, long j6, int i11, long j7, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32List;
        Unsafe unsafe = UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t6, j7);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t6, j7, protobufListMutableCopyWithCapacity2);
        }
        Internal.ProtobufList protobufList = protobufListMutableCopyWithCapacity2;
        switch (i11) {
            case 18:
            case 35:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i5, protobufList, registers);
                }
                if (i9 == 1) {
                    return ArrayDecoders.decodeDoubleList(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 19:
            case 36:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i5, protobufList, registers);
                }
                if (i9 == 5) {
                    return ArrayDecoders.decodeFloatList(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i5, protobufList, registers);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeVarint64List(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i5, protobufList, registers);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeVarint32List(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i5, protobufList, registers);
                }
                if (i9 == 1) {
                    return ArrayDecoders.decodeFixed64List(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i5, protobufList, registers);
                }
                if (i9 == 5) {
                    return ArrayDecoders.decodeFixed32List(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 25:
            case 42:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i5, protobufList, registers);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeBoolList(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 26:
                if (i9 == 2) {
                    return (j6 & 536870912) == 0 ? ArrayDecoders.decodeStringList(i7, bArr, i5, i6, protobufList, registers) : ArrayDecoders.decodeStringListRequireUtf8(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 27:
                if (i9 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i10), i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 28:
                if (i9 == 2) {
                    return ArrayDecoders.decodeBytesList(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 30:
            case 44:
                if (i9 != 2) {
                    if (i9 == 0) {
                        iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i7, bArr, i5, i6, protobufList, registers);
                    }
                    return i5;
                }
                iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i5, protobufList, registers);
                SchemaUtil.filterUnknownEnumList((Object) t6, i8, (List<Integer>) protobufList, getEnumFieldVerifier(i10), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case 47:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i5, protobufList, registers);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeSInt32List(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 34:
            case 48:
                if (i9 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i5, protobufList, registers);
                }
                if (i9 == 0) {
                    return ArrayDecoders.decodeSInt64List(i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            case 49:
                if (i9 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i10), i7, bArr, i5, i6, protobufList, registers);
                }
                return i5;
            default:
                return i5;
        }
    }

    private int positionForFieldNumber(int i5) {
        if (i5 < this.minFieldNumber || i5 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i5, 0);
    }

    private int presenceMaskAndOffsetAt(int i5) {
        return this.buffer[i5 + 2];
    }

    private <E> void readGroupList(Object obj, long j6, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j6), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i5, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i5)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i5, Reader reader) {
        if (isEnforceUtf8(i5)) {
            UnsafeUtil.putObject(obj, offset(i5), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i5), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i5), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i5, Reader reader) {
        if (isEnforceUtf8(i5)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i5)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i5)));
        }
    }

    private static java.lang.reflect.Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbY = AbstractC0157z.y("Field ", str, " for ");
            a.w(cls, sbY, " not found. Known fields are ");
            sbY.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbY.toString());
        }
    }

    private void setFieldPresent(T t6, int i5) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5);
        long j6 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j6 == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t6, j6, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t6, j6));
    }

    private void setOneofPresent(T t6, int i5, int i6) {
        UnsafeUtil.putInt(t6, presenceMaskAndOffsetAt(i6) & 1048575, i5);
    }

    private int slowPositionForFieldNumber(int i5, int i6) {
        int length = (this.buffer.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int iNumberAt = numberAt(i8);
            if (i5 == iNumberAt) {
                return i8;
            }
            if (i5 < iNumberAt) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007a  */
    /* JADX WARN: Code duplicated, block: B:22:0x007d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0084  */
    /* JADX WARN: Code duplicated, block: B:28:0x009e  */
    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:32:0x00af  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00be A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:37:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:41:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:? A[RETURN, SYNTHETIC] */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i5, Object[] objArr) {
        int iObjectFieldOffset;
        int iId;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        int i6;
        Class<?> messageFieldClass;
        int i7;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof == null) {
            FieldType type = fieldInfo.getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            iId = type.id();
            if (!type.isList() && !type.isMap()) {
                java.lang.reflect.Field presenceField = fieldInfo.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
            } else if (fieldInfo.getCachedSizeField() == null) {
                iObjectFieldOffset2 = 0;
                iNumberOfTrailingZeros = 0;
            } else {
                jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
            iArr[i5] = fieldInfo.getFieldNumber();
            int i8 = i5 + 1;
            if (fieldInfo.isEnforceUtf8()) {
                i6 = 536870912;
            } else {
                i6 = 0;
            }
            iArr[i8] = (fieldInfo.isRequired() ? 268435456 : 0) | i6 | (iId << 20) | iObjectFieldOffset;
            iArr[i5 + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i5 / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i5 / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            i7 = (i5 / 3) * 2;
            objArr[i7] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i7 + 1] = messageFieldClass;
            } else if (fieldInfo.getEnumVerifier() != null) {
                objArr[i7 + 1] = fieldInfo.getEnumVerifier();
            }
        }
        iId = fieldInfo.getType().id() + 51;
        iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        iArr[i5] = fieldInfo.getFieldNumber();
        int i9 = i5 + 1;
        if (fieldInfo.isEnforceUtf8()) {
            i6 = 536870912;
        } else {
            i6 = 0;
        }
        iArr[i9] = (fieldInfo.isRequired() ? 268435456 : 0) | i6 | (iId << 20) | iObjectFieldOffset;
        iArr[i5 + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        messageFieldClass = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
            if (messageFieldClass != null) {
                objArr[((i5 / 3) * 2) + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[((i5 / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        i7 = (i5 / 3) * 2;
        objArr[i7] = fieldInfo.getMapDefaultEntry();
        if (messageFieldClass != null) {
            objArr[i7 + 1] = messageFieldClass;
        } else if (fieldInfo.getEnumVerifier() != null) {
            objArr[i7 + 1] = fieldInfo.getEnumVerifier();
        }
    }

    private void storeMessageField(T t6, int i5, Object obj) {
        UNSAFE.putObject(t6, offset(typeAndOffsetAt(i5)), obj);
        setFieldPresent(t6, i5);
    }

    private void storeOneofMessageField(T t6, int i5, int i6, Object obj) {
        UNSAFE.putObject(t6, offset(typeAndOffsetAt(i6)), obj);
        setOneofPresent(t6, i5, i6);
    }

    private static int type(int i5) {
        return (i5 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i5) {
        return this.buffer[i5 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    private void writeFieldsInAscendingOrder(T t6, Writer writer) {
        Map.Entry<?, ?> entry;
        Iterator it;
        boolean z6;
        int i5;
        int i6;
        int i7;
        boolean z7;
        MessageSchema<T> messageSchema = this;
        if (messageSchema.hasExtensions) {
            FieldSet<T> extensions = messageSchema.extensionSchema.getExtensions(t6);
            if (extensions.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator it2 = extensions.iterator();
                entry = (Map.Entry) it2.next();
                it = it2;
            }
        } else {
            entry = null;
            it = null;
        }
        int length = messageSchema.buffer.length;
        Unsafe unsafe = UNSAFE;
        int i8 = 1048575;
        int i9 = 0;
        int i10 = 0;
        while (i9 < length) {
            int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(i9);
            int iNumberAt = messageSchema.numberAt(i9);
            int iType = type(iTypeAndOffsetAt);
            if (iType <= 17) {
                int i11 = messageSchema.buffer[i9 + 2];
                z6 = true;
                int i12 = i11 & 1048575;
                if (i12 != i8) {
                    i10 = i12 == 1048575 ? 0 : unsafe.getInt(t6, i12);
                    i8 = i12;
                }
                i5 = i8;
                i6 = i10;
                i7 = 1 << (i11 >>> 20);
            } else {
                z6 = true;
                i5 = i8;
                i6 = i10;
                i7 = 0;
            }
            while (entry != null && messageSchema.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                messageSchema.extensionSchema.serializeExtension(writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jOffset = offset(iTypeAndOffsetAt);
            switch (iType) {
                case 0:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeDouble(iNumberAt, doubleAt(t6, jOffset));
                    }
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeFloat(iNumberAt, floatAt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeInt64(iNumberAt, unsafe.getLong(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeUInt64(iNumberAt, unsafe.getLong(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeInt32(iNumberAt, unsafe.getInt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeFixed64(iNumberAt, unsafe.getLong(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeFixed32(iNumberAt, unsafe.getInt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeBool(iNumberAt, booleanAt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        messageSchema.writeString(iNumberAt, unsafe.getObject(t6, jOffset), writer);
                    }
                    break;
                case 9:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t6, jOffset), messageSchema.getMessageFieldSchema(i9));
                    }
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeUInt32(iNumberAt, unsafe.getInt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 12:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeEnum(iNumberAt, unsafe.getInt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeSFixed32(iNumberAt, unsafe.getInt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeSFixed64(iNumberAt, unsafe.getLong(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeSInt32(iNumberAt, unsafe.getInt(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeSInt64(iNumberAt, unsafe.getLong(t6, jOffset));
                    }
                    messageSchema = this;
                    break;
                case 17:
                    if (messageSchema.isFieldPresent(t6, i9, i5, i6, i7)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t6, jOffset), messageSchema.getMessageFieldSchema(i9));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, messageSchema.getMessageFieldSchema(i9));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer);
                    break;
                case 29:
                    z7 = false;
                    SchemaUtil.writeUInt32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 30:
                    z7 = false;
                    SchemaUtil.writeEnumList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 31:
                    z7 = false;
                    SchemaUtil.writeSFixed32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 32:
                    z7 = false;
                    SchemaUtil.writeSFixed64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 33:
                    z7 = false;
                    SchemaUtil.writeSInt32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 34:
                    z7 = false;
                    SchemaUtil.writeSInt64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, z6);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(messageSchema.numberAt(i9), (List) unsafe.getObject(t6, jOffset), writer, messageSchema.getMessageFieldSchema(i9));
                    break;
                case 50:
                    messageSchema.writeMapHelper(writer, iNumberAt, unsafe.getObject(t6, jOffset), i9);
                    break;
                case 51:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t6, jOffset));
                    }
                    break;
                case 52:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t6, jOffset));
                    }
                    break;
                case 53:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t6, jOffset));
                    }
                    break;
                case 54:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t6, jOffset));
                    }
                    break;
                case 55:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t6, jOffset));
                    }
                    break;
                case 56:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t6, jOffset));
                    }
                    break;
                case 57:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t6, jOffset));
                    }
                    break;
                case 58:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t6, jOffset));
                    }
                    break;
                case 59:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        messageSchema.writeString(iNumberAt, unsafe.getObject(t6, jOffset), writer);
                    }
                    break;
                case 60:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeMessage(iNumberAt, unsafe.getObject(t6, jOffset), messageSchema.getMessageFieldSchema(i9));
                    }
                    break;
                case 61:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t6, jOffset));
                    }
                    break;
                case 62:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t6, jOffset));
                    }
                    break;
                case 63:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t6, jOffset));
                    }
                    break;
                case 64:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t6, jOffset));
                    }
                    break;
                case 65:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t6, jOffset));
                    }
                    break;
                case 66:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t6, jOffset));
                    }
                    break;
                case 67:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t6, jOffset));
                    }
                    break;
                case 68:
                    if (messageSchema.isOneofPresent(t6, iNumberAt, i9)) {
                        writer.writeGroup(iNumberAt, unsafe.getObject(t6, jOffset), messageSchema.getMessageFieldSchema(i9));
                    }
                    break;
                default:
                    break;
            }
            i9 += 3;
            i10 = i6;
            i8 = i5;
            entry = entry;
        }
        while (entry != null) {
            messageSchema.extensionSchema.serializeExtension(writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        messageSchema.writeUnknownInMessageTo(messageSchema.unknownFieldSchema, t6, writer);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    private void writeFieldsInDescendingOrder(T t6, Writer writer) {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t6, writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t6);
            if (extensions.isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        } else {
            itDescendingIterator = null;
            entry = null;
        }
        for (int length = this.buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t6, length)) {
                        writer.writeDouble(iNumberAt, doubleAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 1:
                    if (isFieldPresent(t6, length)) {
                        writer.writeFloat(iNumberAt, floatAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 2:
                    if (isFieldPresent(t6, length)) {
                        writer.writeInt64(iNumberAt, longAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 3:
                    if (isFieldPresent(t6, length)) {
                        writer.writeUInt64(iNumberAt, longAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 4:
                    if (isFieldPresent(t6, length)) {
                        writer.writeInt32(iNumberAt, intAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 5:
                    if (isFieldPresent(t6, length)) {
                        writer.writeFixed64(iNumberAt, longAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 6:
                    if (isFieldPresent(t6, length)) {
                        writer.writeFixed32(iNumberAt, intAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 7:
                    if (isFieldPresent(t6, length)) {
                        writer.writeBool(iNumberAt, booleanAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 8:
                    if (isFieldPresent(t6, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 9:
                    if (isFieldPresent(t6, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 10:
                    if (isFieldPresent(t6, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 11:
                    if (isFieldPresent(t6, length)) {
                        writer.writeUInt32(iNumberAt, intAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 12:
                    if (isFieldPresent(t6, length)) {
                        writer.writeEnum(iNumberAt, intAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 13:
                    if (isFieldPresent(t6, length)) {
                        writer.writeSFixed32(iNumberAt, intAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 14:
                    if (isFieldPresent(t6, length)) {
                        writer.writeSFixed64(iNumberAt, longAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 15:
                    if (isFieldPresent(t6, length)) {
                        writer.writeSInt32(iNumberAt, intAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 16:
                    if (isFieldPresent(t6, length)) {
                        writer.writeSInt64(iNumberAt, longAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 17:
                    if (isFieldPresent(t6, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 31:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 37:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 38:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 39:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 41:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 42:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 43:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 44:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 45:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 47:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(writer, iNumberAt, UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeDouble(iNumberAt, oneofDoubleAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 52:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeFloat(iNumberAt, oneofFloatAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 53:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeInt64(iNumberAt, oneofLongAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 54:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeUInt64(iNumberAt, oneofLongAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 55:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeInt32(iNumberAt, oneofIntAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 56:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeFixed64(iNumberAt, oneofLongAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 57:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeFixed32(iNumberAt, oneofIntAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 58:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeBool(iNumberAt, oneofBooleanAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 59:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), writer);
                    }
                    break;
                case 60:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
                case 61:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 62:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeUInt32(iNumberAt, oneofIntAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 63:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeEnum(iNumberAt, oneofIntAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 64:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeSFixed32(iNumberAt, oneofIntAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 65:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeSFixed64(iNumberAt, oneofLongAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 66:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeSInt32(iNumberAt, oneofIntAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 67:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeSInt64(iNumberAt, oneofLongAt(t6, offset(iTypeAndOffsetAt)));
                    }
                    break;
                case 68:
                    if (isOneofPresent(t6, iNumberAt, length)) {
                        writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t6, offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                    }
                    break;
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i5, Object obj, int i6) {
        if (obj != null) {
            writer.writeMap(i5, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i5, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i5, (String) obj);
        } else {
            writer.writeBytes(i5, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t6, Writer writer) {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t6), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public boolean equals(T t6, T t7) {
        int length = this.buffer.length;
        for (int i5 = 0; i5 < length; i5 += 3) {
            if (!equals(t6, t7, i5)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t6).equals(this.unknownFieldSchema.getFromMessage(t7))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t6).equals(this.extensionSchema.getExtensions(t7));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.buffer.length * 3;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:251:0x0559 A[PHI: r0 r1
  0x0559: PHI (r0v2 androidx.datastore.preferences.protobuf.MessageSchema<T>) = 
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v26 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v32 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
  (r0v1 androidx.datastore.preferences.protobuf.MessageSchema<T>)
 binds: [B:22:0x005b, B:249:0x054f, B:218:0x04b0, B:204:0x0467, B:196:0x0440, B:189:0x0419, B:166:0x0330, B:160:0x0312, B:154:0x02f4, B:148:0x02d6, B:142:0x02b8, B:136:0x029a, B:130:0x027c, B:124:0x025e, B:118:0x0240, B:112:0x0223, B:106:0x0206, B:100:0x01e9, B:94:0x01cc, B:87:0x01aa, B:82:0x0176, B:79:0x016a, B:76:0x015a, B:73:0x014a, B:70:0x013a, B:67:0x012e, B:64:0x0122, B:61:0x0115, B:54:0x00f5, B:50:0x00df, B:47:0x00ce, B:44:0x00bf, B:41:0x00b0, B:38:0x00a5, B:35:0x009a, B:32:0x008b, B:29:0x007c, B:25:0x0064] A[DONT_GENERATE, DONT_INLINE]
  0x0559: PHI (r1v4 T) = 
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v5 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
  (r1v1 T)
 binds: [B:22:0x005b, B:249:0x054f, B:218:0x04b0, B:204:0x0467, B:196:0x0440, B:189:0x0419, B:166:0x0330, B:160:0x0312, B:154:0x02f4, B:148:0x02d6, B:142:0x02b8, B:136:0x029a, B:130:0x027c, B:124:0x025e, B:118:0x0240, B:112:0x0223, B:106:0x0206, B:100:0x01e9, B:94:0x01cc, B:87:0x01aa, B:82:0x0176, B:79:0x016a, B:76:0x015a, B:73:0x014a, B:70:0x013a, B:67:0x012e, B:64:0x0122, B:61:0x0115, B:54:0x00f5, B:50:0x00df, B:47:0x00ce, B:44:0x00bf, B:41:0x00b0, B:38:0x00a5, B:35:0x009a, B:32:0x008b, B:29:0x007c, B:25:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public int getSerializedSize(T t6) {
        int i5;
        int iComputeDoubleSize;
        int iComputeFloatSize;
        int iComputeInt64Size;
        int iComputeSizeMessage;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        MessageSchema<T> messageSchema = this;
        T t7 = t6;
        Unsafe unsafe = UNSAFE;
        int i6 = 1048575;
        int i7 = 0;
        int i8 = 0;
        int iComputeBytesSize = 0;
        int i9 = 1048575;
        while (i7 < messageSchema.buffer.length) {
            int iTypeAndOffsetAt = messageSchema.typeAndOffsetAt(i7);
            int iType = type(iTypeAndOffsetAt);
            int iNumberAt = messageSchema.numberAt(i7);
            int i10 = messageSchema.buffer[i7 + 2];
            int i11 = i10 & i6;
            if (iType <= 17) {
                if (i11 != i9) {
                    i8 = i11 == i6 ? 0 : unsafe.getInt(t7, i11);
                    i9 = i11;
                }
                i5 = 1 << (i10 >>> 20);
            } else {
                i5 = 0;
            }
            int i12 = iComputeBytesSize;
            long jOffset = offset(iTypeAndOffsetAt);
            if (iType < FieldType.DOUBLE_LIST_PACKED.id() || iType > FieldType.SINT64_LIST_PACKED.id()) {
                i11 = 0;
            }
            switch (iType) {
                case 0:
                    if (!messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 1:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeFloatSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iComputeBytesSize = iComputeFloatSize + i12;
                        messageSchema = this;
                        t7 = t6;
                    }
                    messageSchema = this;
                    t7 = t6;
                    iComputeBytesSize = i12;
                    break;
                case 2:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 3:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 4:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 5:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeFloatSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iComputeBytesSize = iComputeFloatSize + i12;
                        messageSchema = this;
                        t7 = t6;
                    }
                    messageSchema = this;
                    t7 = t6;
                    iComputeBytesSize = i12;
                    break;
                case 6:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeFloatSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iComputeBytesSize = iComputeFloatSize + i12;
                        messageSchema = this;
                        t7 = t6;
                    }
                    messageSchema = this;
                    t7 = t6;
                    iComputeBytesSize = i12;
                    break;
                case 7:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeFloatSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iComputeBytesSize = iComputeFloatSize + i12;
                        messageSchema = this;
                        t7 = t6;
                    }
                    messageSchema = this;
                    t7 = t6;
                    iComputeBytesSize = i12;
                    break;
                case 8:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        Object object = unsafe.getObject(t7, jOffset);
                        iComputeBytesSize = (object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object)) + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 9:
                    if (!messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t7, jOffset), messageSchema.getMessageFieldSchema(i7));
                        iComputeBytesSize = i12 + iComputeSizeMessage;
                    }
                    break;
                case 10:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 11:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 12:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 13:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeFloatSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iComputeBytesSize = iComputeFloatSize + i12;
                        messageSchema = this;
                        t7 = t6;
                    }
                    messageSchema = this;
                    t7 = t6;
                    iComputeBytesSize = i12;
                    break;
                case 14:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeFloatSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iComputeBytesSize = iComputeFloatSize + i12;
                        messageSchema = this;
                        t7 = t6;
                    }
                    messageSchema = this;
                    t7 = t6;
                    iComputeBytesSize = i12;
                    break;
                case 15:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 16:
                    if (messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeInt64Size = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t7, jOffset));
                        iComputeBytesSize = iComputeInt64Size + i12;
                        messageSchema = this;
                    }
                    messageSchema = this;
                    iComputeBytesSize = i12;
                    break;
                case 17:
                    if (!messageSchema.isFieldPresent(t7, i7, i9, i8, i5)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t7, jOffset), messageSchema.getMessageFieldSchema(i7));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 18:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 19:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 20:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 21:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 22:
                    iComputeSizeMessage = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 23:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 24:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 25:
                    iComputeSizeMessage = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 26:
                    iComputeSizeMessage = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t7, jOffset));
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 27:
                    iComputeSizeMessage = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t7, jOffset), messageSchema.getMessageFieldSchema(i7));
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 28:
                    iComputeSizeMessage = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t7, jOffset));
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 29:
                    iComputeSizeMessage = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 30:
                    iComputeSizeMessage = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 31:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 32:
                    iComputeSizeMessage = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 33:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 34:
                    iComputeSizeMessage = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t7, jOffset), false);
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 37:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 38:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 39:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 41:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 42:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 43:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 44:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 45:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 47:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t7, jOffset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        iComputeBytesSize = i12;
                    } else {
                        if (messageSchema.useCachedSizeField) {
                            unsafe.putInt(t7, i11, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeBytesSize = iComputeUInt32SizeNoTag + iComputeTagSize + iComputeSizeFixed64ListNoTag + i12;
                    }
                    break;
                case 49:
                    iComputeSizeMessage = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t7, jOffset), messageSchema.getMessageFieldSchema(i7));
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 50:
                    iComputeSizeMessage = messageSchema.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t7, jOffset), messageSchema.getMapFieldDefaultEntry(i7));
                    iComputeBytesSize = i12 + iComputeSizeMessage;
                    break;
                case 51:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 52:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 53:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 54:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 55:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 56:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 57:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 58:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 59:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        Object object2 = unsafe.getObject(t7, jOffset);
                        iComputeBytesSize = (object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2)) + i12;
                    }
                    break;
                case 60:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeSizeMessage = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t7, jOffset), messageSchema.getMessageFieldSchema(i7));
                        iComputeBytesSize = i12 + iComputeSizeMessage;
                    }
                    break;
                case 61:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 62:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 63:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 64:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 65:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 66:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 67:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t7, jOffset));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                case 68:
                    if (!messageSchema.isOneofPresent(t7, iNumberAt, i7)) {
                        iComputeBytesSize = i12;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t7, jOffset), messageSchema.getMessageFieldSchema(i7));
                        iComputeBytesSize = iComputeDoubleSize + i12;
                    }
                    break;
                default:
                    iComputeBytesSize = i12;
                    break;
            }
            i7 += 3;
            i6 = 1048575;
        }
        int unknownFieldsSerializedSize = iComputeBytesSize + messageSchema.getUnknownFieldsSerializedSize(messageSchema.unknownFieldSchema, t7);
        return messageSchema.hasExtensions ? unknownFieldsSerializedSize + messageSchema.extensionSchema.getExtensions(t7).getSerializedSize() : unknownFieldsSerializedSize;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public int hashCode(T t6) {
        int i5;
        int iHashLong;
        int i6;
        int iOneofIntAt;
        int length = this.buffer.length;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i8);
            int iNumberAt = numberAt(i8);
            long jOffset = offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (type(iTypeAndOffsetAt)) {
                case 0:
                    i5 = i7 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t6, jOffset)));
                    i7 = iHashLong + i5;
                    break;
                case 1:
                    i5 = i7 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t6, jOffset));
                    i7 = iHashLong + i5;
                    break;
                case 2:
                    i5 = i7 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i7 = iHashLong + i5;
                    break;
                case 3:
                    i5 = i7 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i7 = iHashLong + i5;
                    break;
                case 4:
                    i6 = i7 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i7 = i6 + iOneofIntAt;
                    break;
                case 5:
                    i5 = i7 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i7 = iHashLong + i5;
                    break;
                case 6:
                    i6 = i7 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i7 = i6 + iOneofIntAt;
                    break;
                case 7:
                    i5 = i7 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t6, jOffset));
                    i7 = iHashLong + i5;
                    break;
                case 8:
                    i5 = i7 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t6, jOffset)).hashCode();
                    i7 = iHashLong + i5;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t6, jOffset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i7 = (i7 * 53) + iHashCode;
                    break;
                case 10:
                    i5 = i7 * 53;
                    iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                    i7 = iHashLong + i5;
                    break;
                case 11:
                    i6 = i7 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i7 = i6 + iOneofIntAt;
                    break;
                case 12:
                    i6 = i7 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i7 = i6 + iOneofIntAt;
                    break;
                case 13:
                    i6 = i7 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i7 = i6 + iOneofIntAt;
                    break;
                case 14:
                    i5 = i7 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i7 = iHashLong + i5;
                    break;
                case 15:
                    i6 = i7 * 53;
                    iOneofIntAt = UnsafeUtil.getInt(t6, jOffset);
                    i7 = i6 + iOneofIntAt;
                    break;
                case 16:
                    i5 = i7 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.getLong(t6, jOffset));
                    i7 = iHashLong + i5;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t6, jOffset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i7 = (i7 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i5 = i7 * 53;
                    iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                    i7 = iHashLong + i5;
                    break;
                case 50:
                    i5 = i7 * 53;
                    iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                    i7 = iHashLong + i5;
                    break;
                case 51:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t6, jOffset)));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t6, jOffset));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i6 = i7 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i7 = i6 + iOneofIntAt;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i6 = i7 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i7 = i6 + iOneofIntAt;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t6, jOffset));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t6, jOffset)).hashCode();
                        i7 = iHashLong + i5;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                        i7 = iHashLong + i5;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                        i7 = iHashLong + i5;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i6 = i7 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i7 = i6 + iOneofIntAt;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i6 = i7 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i7 = i6 + iOneofIntAt;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i6 = i7 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i7 = i6 + iOneofIntAt;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i6 = i7 * 53;
                        iOneofIntAt = oneofIntAt(t6, jOffset);
                        i7 = i6 + iOneofIntAt;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t6, jOffset));
                        i7 = iHashLong + i5;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t6, iNumberAt, i8)) {
                        i5 = i7 * 53;
                        iHashLong = UnsafeUtil.getObject(t6, jOffset).hashCode();
                        i7 = iHashLong + i5;
                    }
                    break;
            }
        }
        int iHashCode2 = this.unknownFieldSchema.getFromMessage(t6).hashCode() + (i7 * 53);
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t6).hashCode() : iHashCode2;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    /* JADX WARN: Code duplicated, block: B:58:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0094 A[SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean isInitialized(T t6) {
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i8 < this.checkInitializedCount) {
            int i10 = this.intArray[i8];
            int iNumberAt = numberAt(i10);
            int iTypeAndOffsetAt = typeAndOffsetAt(i10);
            int i11 = this.buffer[i10 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i7) {
                if (i12 != 1048575) {
                    i9 = UNSAFE.getInt(t6, i12);
                }
                i6 = i9;
                i5 = i12;
            } else {
                i5 = i7;
                i6 = i9;
            }
            T t7 = t6;
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t7, i10, i5, i6, i13)) {
                return false;
            }
            int iType = type(iTypeAndOffsetAt);
            if (iType == 9 || iType == 17) {
                if (isFieldPresent(t7, i10, i5, i6, i13) && !isInitialized(t7, iTypeAndOffsetAt, getMessageFieldSchema(i10))) {
                    return false;
                }
            } else if (iType == 27) {
                if (!isListInitialized(t7, iTypeAndOffsetAt, i10)) {
                    return false;
                }
            } else if (iType == 60 || iType == 68) {
                if (isOneofPresent(t7, iNumberAt, i10) && !isInitialized(t7, iTypeAndOffsetAt, getMessageFieldSchema(i10))) {
                    return false;
                }
            } else if (iType != 49) {
                if (iType == 50 && !isMapInitialized(t7, iTypeAndOffsetAt, i10)) {
                    return false;
                }
            } else if (!isListInitialized(t7, iTypeAndOffsetAt, i10)) {
                return false;
            }
            i8++;
            t6 = t7;
            i7 = i5;
            i9 = i6;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t6).isInitialized();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x006a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x007d A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public void makeImmutable(T t6) {
        if (isMutable(t6)) {
            if (t6 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t6;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i5 = 0; i5 < length; i5 += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i5);
                long jOffset = offset(iTypeAndOffsetAt);
                int iType = type(iTypeAndOffsetAt);
                if (iType != 9) {
                    if (iType != 60 && iType != 68) {
                        switch (iType) {
                            case 17:
                                if (isFieldPresent(t6, i5)) {
                                    getMessageFieldSchema(i5).makeImmutable(UNSAFE.getObject(t6, jOffset));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.listFieldSchema.makeImmutableListAt(t6, jOffset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t6, jOffset);
                                if (object != null) {
                                    unsafe.putObject(t6, jOffset, this.mapFieldSchema.toImmutable(object));
                                }
                                break;
                        }
                    } else if (isOneofPresent(t6, numberAt(i5), i5)) {
                        getMessageFieldSchema(i5).makeImmutable(UNSAFE.getObject(t6, jOffset));
                    }
                } else if (isFieldPresent(t6, i5)) {
                    getMessageFieldSchema(i5).makeImmutable(UNSAFE.getObject(t6, jOffset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t6);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t6);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t6, T t7) {
        checkMutable(t6);
        t7.getClass();
        for (int i5 = 0; i5 < this.buffer.length; i5 += 3) {
            mergeSingleField(t6, t7, i5);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t6, t7);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t6, t7);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 12321. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    @androidx.datastore.preferences.protobuf.CanIgnoreReturnValue
    public int parseMessage(T r27, byte[] r28, int r29, int r30, int r31, androidx.datastore.preferences.protobuf.ArrayDecoders.Registers r32) {
        /*
            Method dump skipped, instruction units count: 1232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.parseMessage(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.ArrayDecoders$Registers):int");
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void writeTo(T t6, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t6, writer);
        } else {
            writeFieldsInAscendingOrder(t6, writer);
        }
    }

    private boolean isFieldPresent(T t6, int i5) {
        boolean zEquals;
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5);
        long j6 = 1048575 & iPresenceMaskAndOffsetAt;
        if (j6 != 1048575) {
            return (UnsafeUtil.getInt(t6, j6) & (1 << (iPresenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i5);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t6, jOffset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t6, jOffset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t6, jOffset) != 0;
            case 3:
                return UnsafeUtil.getLong(t6, jOffset) != 0;
            case 4:
                return UnsafeUtil.getInt(t6, jOffset) != 0;
            case 5:
                return UnsafeUtil.getLong(t6, jOffset) != 0;
            case 6:
                return UnsafeUtil.getInt(t6, jOffset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t6, jOffset);
            case 8:
                Object object = UnsafeUtil.getObject(t6, jOffset);
                if (object instanceof String) {
                    zEquals = ((String) object).isEmpty();
                } else {
                    if (!(object instanceof ByteString)) {
                        throw new IllegalArgumentException();
                    }
                    zEquals = ByteString.EMPTY.equals(object);
                }
                break;
            case 9:
                return UnsafeUtil.getObject(t6, jOffset) != null;
            case 10:
                zEquals = ByteString.EMPTY.equals(UnsafeUtil.getObject(t6, jOffset));
                break;
            case 11:
                return UnsafeUtil.getInt(t6, jOffset) != 0;
            case 12:
                return UnsafeUtil.getInt(t6, jOffset) != 0;
            case 13:
                return UnsafeUtil.getInt(t6, jOffset) != 0;
            case 14:
                return UnsafeUtil.getLong(t6, jOffset) != 0;
            case 15:
                return UnsafeUtil.getInt(t6, jOffset) != 0;
            case 16:
                return UnsafeUtil.getLong(t6, jOffset) != 0;
            case 17:
                return UnsafeUtil.getObject(t6, jOffset) != null;
            default:
                throw new IllegalArgumentException();
        }
        return !zEquals;
    }

    private int positionForFieldNumber(int i5, int i6) {
        if (i5 < this.minFieldNumber || i5 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i5, i6);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t6, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
        checkMutable(t6);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t6, reader, extensionRegistryLite);
    }

    private boolean equals(T t6, T t7, int i5) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i5);
        long jOffset = offset(iTypeAndOffsetAt);
        switch (type(iTypeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t6, t7, i5) && Double.doubleToLongBits(UnsafeUtil.getDouble(t6, jOffset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t7, jOffset));
            case 1:
                return arePresentForEquals(t6, t7, i5) && Float.floatToIntBits(UnsafeUtil.getFloat(t6, jOffset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t7, jOffset));
            case 2:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getLong(t6, jOffset) == UnsafeUtil.getLong(t7, jOffset);
            case 3:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getLong(t6, jOffset) == UnsafeUtil.getLong(t7, jOffset);
            case 4:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getInt(t6, jOffset) == UnsafeUtil.getInt(t7, jOffset);
            case 5:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getLong(t6, jOffset) == UnsafeUtil.getLong(t7, jOffset);
            case 6:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getInt(t6, jOffset) == UnsafeUtil.getInt(t7, jOffset);
            case 7:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getBoolean(t6, jOffset) == UnsafeUtil.getBoolean(t7, jOffset);
            case 8:
                return arePresentForEquals(t6, t7, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset));
            case 9:
                return arePresentForEquals(t6, t7, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset));
            case 10:
                return arePresentForEquals(t6, t7, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset));
            case 11:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getInt(t6, jOffset) == UnsafeUtil.getInt(t7, jOffset);
            case 12:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getInt(t6, jOffset) == UnsafeUtil.getInt(t7, jOffset);
            case 13:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getInt(t6, jOffset) == UnsafeUtil.getInt(t7, jOffset);
            case 14:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getLong(t6, jOffset) == UnsafeUtil.getLong(t7, jOffset);
            case 15:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getInt(t6, jOffset) == UnsafeUtil.getInt(t7, jOffset);
            case 16:
                return arePresentForEquals(t6, t7, i5) && UnsafeUtil.getLong(t6, jOffset) == UnsafeUtil.getLong(t7, jOffset);
            case 17:
                return arePresentForEquals(t6, t7, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(t6, t7, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t6, jOffset), UnsafeUtil.getObject(t7, jOffset));
            default:
                return true;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t6, byte[] bArr, int i5, int i6, ArrayDecoders.Registers registers) {
        parseMessage(t6, bArr, i5, i6, 0, registers);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i5, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i5)));
    }
}
