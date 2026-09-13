package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(@NonNull Parcel parcel) {
        return zzb(parcel, 20293);
    }

    public static void finishObjectHeader(@NonNull Parcel parcel, int i5) {
        zzc(parcel, i5);
    }

    public static void writeBigDecimal(@NonNull Parcel parcel, int i5, @NonNull BigDecimal bigDecimal, boolean z6) {
        if (bigDecimal == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzc(parcel, iZzb);
        }
    }

    public static void writeBigDecimalArray(@NonNull Parcel parcel, int i5, @NonNull BigDecimal[] bigDecimalArr, boolean z6) {
        if (bigDecimalArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int length = bigDecimalArr.length;
        parcel.writeInt(length);
        for (int i6 = 0; i6 < length; i6++) {
            parcel.writeByteArray(bigDecimalArr[i6].unscaledValue().toByteArray());
            parcel.writeInt(bigDecimalArr[i6].scale());
        }
        zzc(parcel, iZzb);
    }

    public static void writeBigInteger(@NonNull Parcel parcel, int i5, @NonNull BigInteger bigInteger, boolean z6) {
        if (bigInteger == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzc(parcel, iZzb);
        }
    }

    public static void writeBigIntegerArray(@NonNull Parcel parcel, int i5, @NonNull BigInteger[] bigIntegerArr, boolean z6) {
        if (bigIntegerArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        parcel.writeInt(bigIntegerArr.length);
        for (BigInteger bigInteger : bigIntegerArr) {
            parcel.writeByteArray(bigInteger.toByteArray());
        }
        zzc(parcel, iZzb);
    }

    public static void writeBoolean(@NonNull Parcel parcel, int i5, boolean z6) {
        zza(parcel, i5, 4);
        parcel.writeInt(z6 ? 1 : 0);
    }

    public static void writeBooleanArray(@NonNull Parcel parcel, int i5, @NonNull boolean[] zArr, boolean z6) {
        if (zArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeBooleanArray(zArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeBooleanList(@NonNull Parcel parcel, int i5, @NonNull List<Boolean> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(list.get(i6).booleanValue() ? 1 : 0);
        }
        zzc(parcel, iZzb);
    }

    public static void writeBooleanObject(@NonNull Parcel parcel, int i5, @NonNull Boolean bool, boolean z6) {
        if (bool != null) {
            zza(parcel, i5, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z6) {
            zza(parcel, i5, 0);
        }
    }

    public static void writeBundle(@NonNull Parcel parcel, int i5, @NonNull Bundle bundle, boolean z6) {
        if (bundle == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeBundle(bundle);
            zzc(parcel, iZzb);
        }
    }

    public static void writeByte(@NonNull Parcel parcel, int i5, byte b) {
        zza(parcel, i5, 4);
        parcel.writeInt(b);
    }

    public static void writeByteArray(@NonNull Parcel parcel, int i5, @NonNull byte[] bArr, boolean z6) {
        if (bArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeByteArray(bArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeByteArrayArray(@NonNull Parcel parcel, int i5, @NonNull byte[][] bArr, boolean z6) {
        if (bArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        parcel.writeInt(bArr.length);
        for (byte[] bArr2 : bArr) {
            parcel.writeByteArray(bArr2);
        }
        zzc(parcel, iZzb);
    }

    public static void writeByteArraySparseArray(@NonNull Parcel parcel, int i5, @NonNull SparseArray<byte[]> sparseArray, boolean z6) {
        if (sparseArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseArray.keyAt(i6));
            parcel.writeByteArray(sparseArray.valueAt(i6));
        }
        zzc(parcel, iZzb);
    }

    public static void writeChar(@NonNull Parcel parcel, int i5, char c) {
        zza(parcel, i5, 4);
        parcel.writeInt(c);
    }

    public static void writeCharArray(@NonNull Parcel parcel, int i5, @NonNull char[] cArr, boolean z6) {
        if (cArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeCharArray(cArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeDouble(@NonNull Parcel parcel, int i5, double d) {
        zza(parcel, i5, 8);
        parcel.writeDouble(d);
    }

    public static void writeDoubleArray(@NonNull Parcel parcel, int i5, @NonNull double[] dArr, boolean z6) {
        if (dArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeDoubleArray(dArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeDoubleList(@NonNull Parcel parcel, int i5, @NonNull List<Double> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeDouble(list.get(i6).doubleValue());
        }
        zzc(parcel, iZzb);
    }

    public static void writeDoubleObject(@NonNull Parcel parcel, int i5, @NonNull Double d, boolean z6) {
        if (d != null) {
            zza(parcel, i5, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z6) {
            zza(parcel, i5, 0);
        }
    }

    public static void writeDoubleSparseArray(@NonNull Parcel parcel, int i5, @NonNull SparseArray<Double> sparseArray, boolean z6) {
        if (sparseArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseArray.keyAt(i6));
            parcel.writeDouble(sparseArray.valueAt(i6).doubleValue());
        }
        zzc(parcel, iZzb);
    }

    public static void writeFloat(@NonNull Parcel parcel, int i5, float f6) {
        zza(parcel, i5, 4);
        parcel.writeFloat(f6);
    }

    public static void writeFloatArray(@NonNull Parcel parcel, int i5, @NonNull float[] fArr, boolean z6) {
        if (fArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeFloatArray(fArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeFloatList(@NonNull Parcel parcel, int i5, @NonNull List<Float> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeFloat(list.get(i6).floatValue());
        }
        zzc(parcel, iZzb);
    }

    public static void writeFloatObject(@NonNull Parcel parcel, int i5, @NonNull Float f6, boolean z6) {
        if (f6 != null) {
            zza(parcel, i5, 4);
            parcel.writeFloat(f6.floatValue());
        } else if (z6) {
            zza(parcel, i5, 0);
        }
    }

    public static void writeFloatSparseArray(@NonNull Parcel parcel, int i5, @NonNull SparseArray<Float> sparseArray, boolean z6) {
        if (sparseArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseArray.keyAt(i6));
            parcel.writeFloat(sparseArray.valueAt(i6).floatValue());
        }
        zzc(parcel, iZzb);
    }

    public static void writeIBinder(@NonNull Parcel parcel, int i5, @NonNull IBinder iBinder, boolean z6) {
        if (iBinder == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeStrongBinder(iBinder);
            zzc(parcel, iZzb);
        }
    }

    public static void writeIBinderArray(@NonNull Parcel parcel, int i5, @NonNull IBinder[] iBinderArr, boolean z6) {
        if (iBinderArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeBinderArray(iBinderArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeIBinderList(@NonNull Parcel parcel, int i5, @NonNull List<IBinder> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeBinderList(list);
            zzc(parcel, iZzb);
        }
    }

    public static void writeIBinderSparseArray(@NonNull Parcel parcel, int i5, @NonNull SparseArray<IBinder> sparseArray, boolean z6) {
        if (sparseArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseArray.keyAt(i6));
            parcel.writeStrongBinder(sparseArray.valueAt(i6));
        }
        zzc(parcel, iZzb);
    }

    public static void writeInt(@NonNull Parcel parcel, int i5, int i6) {
        zza(parcel, i5, 4);
        parcel.writeInt(i6);
    }

    public static void writeIntArray(@NonNull Parcel parcel, int i5, @NonNull int[] iArr, boolean z6) {
        if (iArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeIntArray(iArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeIntegerList(@NonNull Parcel parcel, int i5, @NonNull List<Integer> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(list.get(i6).intValue());
        }
        zzc(parcel, iZzb);
    }

    public static void writeIntegerObject(@NonNull Parcel parcel, int i5, @NonNull Integer num, boolean z6) {
        if (num != null) {
            zza(parcel, i5, 4);
            parcel.writeInt(num.intValue());
        } else if (z6) {
            zza(parcel, i5, 0);
        }
    }

    public static void writeList(@NonNull Parcel parcel, int i5, @NonNull List list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeList(list);
            zzc(parcel, iZzb);
        }
    }

    public static void writeLong(@NonNull Parcel parcel, int i5, long j6) {
        zza(parcel, i5, 8);
        parcel.writeLong(j6);
    }

    public static void writeLongArray(@NonNull Parcel parcel, int i5, @NonNull long[] jArr, boolean z6) {
        if (jArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeLongArray(jArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeLongList(@NonNull Parcel parcel, int i5, @NonNull List<Long> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeLong(list.get(i6).longValue());
        }
        zzc(parcel, iZzb);
    }

    public static void writeLongObject(@NonNull Parcel parcel, int i5, @NonNull Long l6, boolean z6) {
        if (l6 != null) {
            zza(parcel, i5, 8);
            parcel.writeLong(l6.longValue());
        } else if (z6) {
            zza(parcel, i5, 0);
        }
    }

    public static void writeParcel(@NonNull Parcel parcel, int i5, @NonNull Parcel parcel2, boolean z6) {
        if (parcel2 == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzc(parcel, iZzb);
        }
    }

    public static void writeParcelArray(@NonNull Parcel parcel, int i5, @NonNull Parcel[] parcelArr, boolean z6) {
        if (parcelArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        parcel.writeInt(parcelArr.length);
        for (Parcel parcel2 : parcelArr) {
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzc(parcel, iZzb);
    }

    public static void writeParcelList(@NonNull Parcel parcel, int i5, @NonNull List<Parcel> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            Parcel parcel2 = list.get(i6);
            if (parcel2 != null) {
                parcel.writeInt(parcel2.dataSize());
                parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzc(parcel, iZzb);
    }

    public static void writeParcelSparseArray(@NonNull Parcel parcel, int i5, @NonNull SparseArray<Parcel> sparseArray, boolean z6) {
        if (sparseArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseArray.keyAt(i6));
            Parcel parcelValueAt = sparseArray.valueAt(i6);
            if (parcelValueAt != null) {
                parcel.writeInt(parcelValueAt.dataSize());
                parcel.appendFrom(parcelValueAt, 0, parcelValueAt.dataSize());
            } else {
                parcel.writeInt(0);
            }
        }
        zzc(parcel, iZzb);
    }

    public static void writeParcelable(@NonNull Parcel parcel, int i5, @NonNull Parcelable parcelable, int i6, boolean z6) {
        if (parcelable == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcelable.writeToParcel(parcel, i6);
            zzc(parcel, iZzb);
        }
    }

    public static void writePendingIntent(@NonNull Parcel parcel, int i5, @NonNull PendingIntent pendingIntent, boolean z6) {
        if (pendingIntent == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzc(parcel, iZzb);
        }
    }

    public static void writeShort(@NonNull Parcel parcel, int i5, short s6) {
        zza(parcel, i5, 4);
        parcel.writeInt(s6);
    }

    public static void writeSparseBooleanArray(@NonNull Parcel parcel, int i5, @NonNull SparseBooleanArray sparseBooleanArray, boolean z6) {
        if (sparseBooleanArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzc(parcel, iZzb);
        }
    }

    public static void writeSparseIntArray(@NonNull Parcel parcel, int i5, @NonNull SparseIntArray sparseIntArray, boolean z6) {
        if (sparseIntArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseIntArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseIntArray.keyAt(i6));
            parcel.writeInt(sparseIntArray.valueAt(i6));
        }
        zzc(parcel, iZzb);
    }

    public static void writeSparseLongArray(@NonNull Parcel parcel, int i5, @NonNull SparseLongArray sparseLongArray, boolean z6) {
        if (sparseLongArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseLongArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseLongArray.keyAt(i6));
            parcel.writeLong(sparseLongArray.valueAt(i6));
        }
        zzc(parcel, iZzb);
    }

    public static void writeString(@NonNull Parcel parcel, int i5, @NonNull String str, boolean z6) {
        if (str == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeString(str);
            zzc(parcel, iZzb);
        }
    }

    public static void writeStringArray(@NonNull Parcel parcel, int i5, @NonNull String[] strArr, boolean z6) {
        if (strArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeStringArray(strArr);
            zzc(parcel, iZzb);
        }
    }

    public static void writeStringList(@NonNull Parcel parcel, int i5, @NonNull List<String> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
            }
        } else {
            int iZzb = zzb(parcel, i5);
            parcel.writeStringList(list);
            zzc(parcel, iZzb);
        }
    }

    public static void writeStringSparseArray(@NonNull Parcel parcel, int i5, @NonNull SparseArray<String> sparseArray, boolean z6) {
        if (sparseArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseArray.keyAt(i6));
            parcel.writeString(sparseArray.valueAt(i6));
        }
        zzc(parcel, iZzb);
    }

    public static <T extends Parcelable> void writeTypedArray(@NonNull Parcel parcel, int i5, @NonNull T[] tArr, int i6, boolean z6) {
        if (tArr == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        parcel.writeInt(tArr.length);
        for (T t6 : tArr) {
            if (t6 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t6, i6);
            }
        }
        zzc(parcel, iZzb);
    }

    public static <T extends Parcelable> void writeTypedList(@NonNull Parcel parcel, int i5, @NonNull List<T> list, boolean z6) {
        if (list == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            T t6 = list.get(i6);
            if (t6 == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, t6, 0);
            }
        }
        zzc(parcel, iZzb);
    }

    public static <T extends Parcelable> void writeTypedSparseArray(@NonNull Parcel parcel, int i5, @NonNull SparseArray<T> sparseArray, boolean z6) {
        if (sparseArray == null) {
            if (z6) {
                zza(parcel, i5, 0);
                return;
            }
            return;
        }
        int iZzb = zzb(parcel, i5);
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            parcel.writeInt(sparseArray.keyAt(i6));
            T tValueAt = sparseArray.valueAt(i6);
            if (tValueAt == null) {
                parcel.writeInt(0);
            } else {
                zzd(parcel, tValueAt, 0);
            }
        }
        zzc(parcel, iZzb);
    }

    private static void zza(Parcel parcel, int i5, int i6) {
        parcel.writeInt(i5 | (i6 << 16));
    }

    private static int zzb(Parcel parcel, int i5) {
        parcel.writeInt(i5 | SupportMenu.CATEGORY_MASK);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzc(Parcel parcel, int i5) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(iDataPosition - i5);
        parcel.setDataPosition(iDataPosition);
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i5) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i5);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
