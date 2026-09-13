package org.apache.poi.ddf;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class EscherPropertyFactory {

    /* JADX INFO: renamed from: org.apache.poi.ddf.EscherPropertyFactory$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder;

        static {
            int[] iArr = new int[EscherPropertyTypesHolder.values().length];
            $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder = iArr;
            try {
                iArr[EscherPropertyTypesHolder.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder[EscherPropertyTypesHolder.RGB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder[EscherPropertyTypesHolder.SHAPE_PATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public List<EscherProperty> createProperties(byte[] bArr, int i5, short s6) {
        int arrayData;
        BiFunction biFunction;
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (int i7 = 0; i7 < s6; i7++) {
            short s7 = LittleEndian.getShort(bArr, i5);
            int i8 = LittleEndian.getInt(bArr, i5 + 2);
            boolean z6 = (Short.MIN_VALUE & s7) != 0;
            EscherPropertyTypes escherPropertyTypesForPropertyID = EscherPropertyTypes.forPropertyID(s7);
            int i9 = AnonymousClass1.$SwitchMap$org$apache$poi$ddf$EscherPropertyTypesHolder[escherPropertyTypesForPropertyID.holder.ordinal()];
            if (i9 == 1) {
                final int i10 = 0;
                biFunction = new BiFunction() { // from class: org.apache.poi.ddf.s
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        switch (i10) {
                            case 0:
                                return new EscherBoolProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 1:
                                return new EscherRGBProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 2:
                                return new EscherShapePathProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 3:
                                return new EscherArrayProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 4:
                                return new EscherComplexProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            default:
                                return new EscherSimpleProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                        }
                    }
                };
            } else if (i9 == 2) {
                final int i11 = 1;
                biFunction = new BiFunction() { // from class: org.apache.poi.ddf.s
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        switch (i11) {
                            case 0:
                                return new EscherBoolProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 1:
                                return new EscherRGBProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 2:
                                return new EscherShapePathProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 3:
                                return new EscherArrayProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 4:
                                return new EscherComplexProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            default:
                                return new EscherSimpleProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                        }
                    }
                };
            } else if (i9 == 3) {
                final int i12 = 2;
                biFunction = new BiFunction() { // from class: org.apache.poi.ddf.s
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        switch (i12) {
                            case 0:
                                return new EscherBoolProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 1:
                                return new EscherRGBProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 2:
                                return new EscherShapePathProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 3:
                                return new EscherArrayProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 4:
                                return new EscherComplexProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            default:
                                return new EscherSimpleProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                        }
                    }
                };
            } else if (!z6) {
                final int i13 = 5;
                biFunction = new BiFunction() { // from class: org.apache.poi.ddf.s
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        switch (i13) {
                            case 0:
                                return new EscherBoolProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 1:
                                return new EscherRGBProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 2:
                                return new EscherShapePathProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 3:
                                return new EscherArrayProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 4:
                                return new EscherComplexProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            default:
                                return new EscherSimpleProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                        }
                    }
                };
            } else if (escherPropertyTypesForPropertyID.holder == EscherPropertyTypesHolder.ARRAY) {
                final int i14 = 3;
                biFunction = new BiFunction() { // from class: org.apache.poi.ddf.s
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        switch (i14) {
                            case 0:
                                return new EscherBoolProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 1:
                                return new EscherRGBProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 2:
                                return new EscherShapePathProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 3:
                                return new EscherArrayProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 4:
                                return new EscherComplexProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            default:
                                return new EscherSimpleProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                        }
                    }
                };
            } else {
                final int i15 = 4;
                biFunction = new BiFunction() { // from class: org.apache.poi.ddf.s
                    @Override // java.util.function.BiFunction
                    public final Object apply(Object obj, Object obj2) {
                        switch (i15) {
                            case 0:
                                return new EscherBoolProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 1:
                                return new EscherRGBProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 2:
                                return new EscherShapePathProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 3:
                                return new EscherArrayProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            case 4:
                                return new EscherComplexProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                            default:
                                return new EscherSimpleProperty(((Short) obj).shortValue(), ((Integer) obj2).intValue());
                        }
                    }
                };
            }
            arrayList.add(biFunction.apply(Short.valueOf(s7), Integer.valueOf(i8)));
            i5 += 6;
        }
        int size = arrayList.size();
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            EscherProperty escherProperty = (EscherProperty) obj;
            if (escherProperty instanceof EscherArrayProperty) {
                arrayData = ((EscherArrayProperty) escherProperty).setArrayData(bArr, i5);
            } else if (escherProperty instanceof EscherComplexProperty) {
                EscherComplexProperty escherComplexProperty = (EscherComplexProperty) escherProperty;
                int length = escherComplexProperty.getComplexData().length;
                int length2 = bArr.length - i5;
                if (length2 < length) {
                    throw new IllegalStateException(androidx.collection.a.m("Could not read complex escher property, length was ", length, length2, ", but had only ", " bytes left"));
                }
                arrayData = escherComplexProperty.setComplexData(bArr, i5);
            } else {
                continue;
            }
            i5 = arrayData + i5;
        }
        return arrayList;
    }
}
