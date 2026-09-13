package androidx.versionedparcelable;

import A3.AbstractC0157z;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.exifinterface.media.a;
import com.alibaba.android.arouter.utils.Consts;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th) {
            super(th);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        this.mReadCache = arrayMap;
        this.mWriteCache = arrayMap2;
        this.mParcelizerCache = arrayMap3;
    }

    private Exception createException(int i5, String str) {
        switch (i5) {
            case -9:
                return (Exception) readParcelable();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i5 + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> cls) throws ClassNotFoundException {
        Class cls2 = this.mParcelizerCache.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(a.A(cls.getPackage().getName(), Consts.DOT, cls.getSimpleName(), "Parcelizer"), false, cls.getClassLoader());
        this.mParcelizerCache.put(cls.getName(), cls3);
        return cls3;
    }

    private Method getReadMethod(String str) throws NoSuchMethodException {
        Method method = this.mReadCache.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.mReadCache.put(str, declaredMethod);
        return declaredMethod;
    }

    @NonNull
    public static Throwable getRootCause(@NonNull Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int getType(T t6) {
        if (t6 instanceof String) {
            return 4;
        }
        if (t6 instanceof Parcelable) {
            return 2;
        }
        if (t6 instanceof VersionedParcelable) {
            return 1;
        }
        if (t6 instanceof Serializable) {
            return 3;
        }
        if (t6 instanceof IBinder) {
            return 5;
        }
        if (t6 instanceof Integer) {
            return 7;
        }
        if (t6 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t6.getClass().getName().concat(" cannot be VersionedParcelled"));
    }

    private Method getWriteMethod(Class cls) throws NoSuchMethodException, ClassNotFoundException {
        Method method = this.mWriteCache.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsFindParcelClass = findParcelClass(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsFindParcelClass.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.mWriteCache.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    private <T, S extends Collection<T>> S readCollection(S s6) {
        int i5 = readInt();
        if (i5 < 0) {
            return null;
        }
        if (i5 != 0) {
            int i6 = readInt();
            if (i5 < 0) {
                return null;
            }
            if (i6 == 1) {
                while (i5 > 0) {
                    s6.add(readVersionedParcelable());
                    i5--;
                }
            } else if (i6 == 2) {
                while (i5 > 0) {
                    s6.add(readParcelable());
                    i5--;
                }
            } else if (i6 == 3) {
                while (i5 > 0) {
                    s6.add(readSerializable());
                    i5--;
                }
            } else if (i6 == 4) {
                while (i5 > 0) {
                    s6.add(readString());
                    i5--;
                }
            } else if (i6 == 5) {
                while (i5 > 0) {
                    s6.add(readStrongBinder());
                    i5--;
                }
            }
        }
        return s6;
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> collection, int i5) {
        setOutputField(i5);
        writeCollection(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable versionedParcelable) {
        try {
            writeString(findParcelClass(versionedParcelable.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(versionedParcelable.getClass().getSimpleName().concat(" does not have a Parcelizer"), e);
        }
    }

    public abstract void closeField();

    public abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    public <T> T[] readArray(T[] tArr, int i5) {
        return !readField(i5) ? tArr : (T[]) readArray(tArr);
    }

    public abstract boolean readBoolean();

    public boolean readBoolean(boolean z6, int i5) {
        return !readField(i5) ? z6 : readBoolean();
    }

    public boolean[] readBooleanArray(boolean[] zArr, int i5) {
        return !readField(i5) ? zArr : readBooleanArray();
    }

    public abstract Bundle readBundle();

    public Bundle readBundle(Bundle bundle, int i5) {
        return !readField(i5) ? bundle : readBundle();
    }

    public byte readByte(byte b, int i5) {
        return !readField(i5) ? b : (byte) (readInt() & 255);
    }

    public abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] bArr, int i5) {
        return !readField(i5) ? bArr : readByteArray();
    }

    public char[] readCharArray(char[] cArr, int i5) {
        if (!readField(i5)) {
            return cArr;
        }
        int i6 = readInt();
        if (i6 < 0) {
            return null;
        }
        char[] cArr2 = new char[i6];
        for (int i7 = 0; i7 < i6; i7++) {
            cArr2[i7] = (char) readInt();
        }
        return cArr2;
    }

    public abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence charSequence, int i5) {
        return !readField(i5) ? charSequence : readCharSequence();
    }

    public abstract double readDouble();

    public double readDouble(double d, int i5) {
        return !readField(i5) ? d : readDouble();
    }

    public double[] readDoubleArray(double[] dArr, int i5) {
        return !readField(i5) ? dArr : readDoubleArray();
    }

    public Exception readException(Exception exc, int i5) {
        int exceptionCode;
        return (readField(i5) && (exceptionCode = readExceptionCode()) != 0) ? readException(exceptionCode, readString()) : exc;
    }

    public abstract boolean readField(int i5);

    public abstract float readFloat();

    public float readFloat(float f6, int i5) {
        return !readField(i5) ? f6 : readFloat();
    }

    public float[] readFloatArray(float[] fArr, int i5) {
        return !readField(i5) ? fArr : readFloatArray();
    }

    public <T extends VersionedParcelable> T readFromParcel(String str, VersionedParcel versionedParcel) {
        try {
            return (T) getReadMethod(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
        }
    }

    public abstract int readInt();

    public int readInt(int i5, int i6) {
        return !readField(i6) ? i5 : readInt();
    }

    public int[] readIntArray(int[] iArr, int i5) {
        return !readField(i5) ? iArr : readIntArray();
    }

    public <T> List<T> readList(List<T> list, int i5) {
        return !readField(i5) ? list : (List) readCollection(new ArrayList());
    }

    public abstract long readLong();

    public long readLong(long j6, int i5) {
        return !readField(i5) ? j6 : readLong();
    }

    public long[] readLongArray(long[] jArr, int i5) {
        return !readField(i5) ? jArr : readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> map, int i5) {
        if (!readField(i5)) {
            return map;
        }
        int i6 = readInt();
        if (i6 < 0) {
            return null;
        }
        ArrayMap arrayMap = new ArrayMap();
        if (i6 != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            readCollection(arrayList);
            readCollection(arrayList2);
            for (int i7 = 0; i7 < i6; i7++) {
                arrayMap.put(arrayList.get(i7), arrayList2.get(i7));
            }
        }
        return arrayMap;
    }

    public abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T t6, int i5) {
        return !readField(i5) ? t6 : (T) readParcelable();
    }

    public Serializable readSerializable() {
        String string = readString();
        if (string == null) {
            return null;
        }
        try {
            return (Serializable) new ObjectInputStream(new ByteArrayInputStream(readByteArray())) { // from class: androidx.versionedparcelable.VersionedParcel.1
                @Override // java.io.ObjectInputStream
                public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
                    Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
                    return cls != null ? cls : super.resolveClass(objectStreamClass);
                }
            }.readObject();
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("VersionedParcelable encountered IOException reading a Serializable object (name = ", string, ")"), e);
        } catch (ClassNotFoundException e6) {
            throw new RuntimeException(AbstractC0157z.o("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ", string, ")"), e6);
        }
    }

    public <T> Set<T> readSet(Set<T> set, int i5) {
        return !readField(i5) ? set : (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size size, int i5) {
        if (!readField(i5)) {
            return size;
        }
        if (readBoolean()) {
            return new Size(readInt(), readInt());
        }
        return null;
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF sizeF, int i5) {
        if (!readField(i5)) {
            return sizeF;
        }
        if (readBoolean()) {
            return new SizeF(readFloat(), readFloat());
        }
        return null;
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i5) {
        if (!readField(i5)) {
            return sparseBooleanArray;
        }
        int i6 = readInt();
        if (i6 < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(i6);
        for (int i7 = 0; i7 < i6; i7++) {
            sparseBooleanArray2.put(readInt(), readBoolean());
        }
        return sparseBooleanArray2;
    }

    public abstract String readString();

    public String readString(String str, int i5) {
        return !readField(i5) ? str : readString();
    }

    public abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder iBinder, int i5) {
        return !readField(i5) ? iBinder : readStrongBinder();
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T t6, int i5) {
        return !readField(i5) ? t6 : (T) readVersionedParcelable();
    }

    public abstract void setOutputField(int i5);

    public <T> void writeArray(T[] tArr, int i5) {
        setOutputField(i5);
        writeArray(tArr);
    }

    public abstract void writeBoolean(boolean z6);

    public void writeBoolean(boolean z6, int i5) {
        setOutputField(i5);
        writeBoolean(z6);
    }

    public void writeBooleanArray(boolean[] zArr, int i5) {
        setOutputField(i5);
        writeBooleanArray(zArr);
    }

    public abstract void writeBundle(Bundle bundle);

    public void writeBundle(Bundle bundle, int i5) {
        setOutputField(i5);
        writeBundle(bundle);
    }

    public void writeByte(byte b, int i5) {
        setOutputField(i5);
        writeInt(b);
    }

    public abstract void writeByteArray(byte[] bArr);

    public void writeByteArray(byte[] bArr, int i5) {
        setOutputField(i5);
        writeByteArray(bArr);
    }

    public abstract void writeByteArray(byte[] bArr, int i5, int i6);

    public void writeCharArray(char[] cArr, int i5) {
        setOutputField(i5);
        if (cArr == null) {
            writeInt(-1);
            return;
        }
        writeInt(cArr.length);
        for (char c : cArr) {
            writeInt(c);
        }
    }

    public abstract void writeCharSequence(CharSequence charSequence);

    public void writeCharSequence(CharSequence charSequence, int i5) {
        setOutputField(i5);
        writeCharSequence(charSequence);
    }

    public abstract void writeDouble(double d);

    public void writeDouble(double d, int i5) {
        setOutputField(i5);
        writeDouble(d);
    }

    public void writeDoubleArray(double[] dArr, int i5) {
        setOutputField(i5);
        writeDoubleArray(dArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception exc, int i5) {
        int i6;
        setOutputField(i5);
        if (exc == 0) {
            writeNoException();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i6 = -9;
        } else if (exc instanceof SecurityException) {
            i6 = -1;
        } else if (exc instanceof BadParcelableException) {
            i6 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i6 = -3;
        } else if (exc instanceof NullPointerException) {
            i6 = -4;
        } else if (exc instanceof IllegalStateException) {
            i6 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i6 = -6;
        } else {
            i6 = exc instanceof UnsupportedOperationException ? -7 : 0;
        }
        writeInt(i6);
        if (i6 == 0) {
            if (!(exc instanceof RuntimeException)) {
                throw new RuntimeException(exc);
            }
            throw ((RuntimeException) exc);
        }
        writeString(exc.getMessage());
        if (i6 != -9) {
            return;
        }
        writeParcelable((Parcelable) exc);
    }

    public abstract void writeFloat(float f6);

    public void writeFloat(float f6, int i5) {
        setOutputField(i5);
        writeFloat(f6);
    }

    public void writeFloatArray(float[] fArr, int i5) {
        setOutputField(i5);
        writeFloatArray(fArr);
    }

    public abstract void writeInt(int i5);

    public void writeInt(int i5, int i6) {
        setOutputField(i6);
        writeInt(i5);
    }

    public void writeIntArray(int[] iArr, int i5) {
        setOutputField(i5);
        writeIntArray(iArr);
    }

    public <T> void writeList(List<T> list, int i5) {
        writeCollection(list, i5);
    }

    public abstract void writeLong(long j6);

    public void writeLong(long j6, int i5) {
        setOutputField(i5);
        writeLong(j6);
    }

    public void writeLongArray(long[] jArr, int i5) {
        setOutputField(i5);
        writeLongArray(jArr);
    }

    public <K, V> void writeMap(Map<K, V> map, int i5) {
        setOutputField(i5);
        if (map == null) {
            writeInt(-1);
            return;
        }
        int size = map.size();
        writeInt(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        writeCollection(arrayList);
        writeCollection(arrayList2);
    }

    public void writeNoException() {
        writeInt(0);
    }

    public abstract void writeParcelable(Parcelable parcelable);

    public void writeParcelable(Parcelable parcelable, int i5) {
        setOutputField(i5);
        writeParcelable(parcelable);
    }

    public void writeSerializable(Serializable serializable, int i5) {
        setOutputField(i5);
        writeSerializable(serializable);
    }

    public <T> void writeSet(Set<T> set, int i5) {
        writeCollection(set, i5);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size size, int i5) {
        setOutputField(i5);
        writeBoolean(size != null);
        if (size != null) {
            writeInt(size.getWidth());
            writeInt(size.getHeight());
        }
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF sizeF, int i5) {
        setOutputField(i5);
        writeBoolean(sizeF != null);
        if (sizeF != null) {
            writeFloat(sizeF.getWidth());
            writeFloat(sizeF.getHeight());
        }
    }

    public void writeSparseBooleanArray(SparseBooleanArray sparseBooleanArray, int i5) {
        setOutputField(i5);
        if (sparseBooleanArray == null) {
            writeInt(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            writeInt(sparseBooleanArray.keyAt(i6));
            writeBoolean(sparseBooleanArray.valueAt(i6));
        }
    }

    public abstract void writeString(String str);

    public void writeString(String str, int i5) {
        setOutputField(i5);
        writeString(str);
    }

    public abstract void writeStrongBinder(IBinder iBinder);

    public void writeStrongBinder(IBinder iBinder, int i5) {
        setOutputField(i5);
        writeStrongBinder(iBinder);
    }

    public abstract void writeStrongInterface(IInterface iInterface);

    public void writeStrongInterface(IInterface iInterface, int i5) {
        setOutputField(i5);
        writeStrongInterface(iInterface);
    }

    public <T extends VersionedParcelable> void writeToParcel(T t6, VersionedParcel versionedParcel) {
        try {
            getWriteMethod(t6.getClass()).invoke(null, t6, versionedParcel);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (!(e8.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
            }
            throw ((RuntimeException) e8.getCause());
        }
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable, int i5) {
        setOutputField(i5);
        writeVersionedParcelable(versionedParcelable);
    }

    private <T> void writeCollection(Collection<T> collection) {
        if (collection == null) {
            writeInt(-1);
        }
        int size = collection.size();
        writeInt(size);
        if (size > 0) {
            int type = getType(collection.iterator().next());
            writeInt(type);
            switch (type) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        writeVersionedParcelable((VersionedParcelable) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        writeParcelable((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        writeSerializable((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        writeString((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        writeStrongBinder((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        writeInt(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        writeFloat(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private void writeSerializable(Serializable serializable) {
        if (serializable == null) {
            writeString(null);
            return;
        }
        String name = serializable.getClass().getName();
        writeString(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            writeByteArray(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(AbstractC0157z.o("VersionedParcelable encountered IOException writing serializable object (name = ", name, ")"), e);
        }
    }

    public <T> T[] readArray(T[] tArr) {
        int i5 = readInt();
        if (i5 < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(i5);
        if (i5 != 0) {
            int i6 = readInt();
            if (i5 < 0) {
                return null;
            }
            if (i6 == 1) {
                while (i5 > 0) {
                    arrayList.add(readVersionedParcelable());
                    i5--;
                }
            } else if (i6 == 2) {
                while (i5 > 0) {
                    arrayList.add(readParcelable());
                    i5--;
                }
            } else if (i6 == 3) {
                while (i5 > 0) {
                    arrayList.add(readSerializable());
                    i5--;
                }
            } else if (i6 == 4) {
                while (i5 > 0) {
                    arrayList.add(readString());
                    i5--;
                }
            } else if (i6 == 5) {
                while (i5 > 0) {
                    arrayList.add(readStrongBinder());
                    i5--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public boolean[] readBooleanArray() {
        int i5 = readInt();
        if (i5 < 0) {
            return null;
        }
        boolean[] zArr = new boolean[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            zArr[i6] = readInt() != 0;
        }
        return zArr;
    }

    public double[] readDoubleArray() {
        int i5 = readInt();
        if (i5 < 0) {
            return null;
        }
        double[] dArr = new double[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            dArr[i6] = readDouble();
        }
        return dArr;
    }

    public float[] readFloatArray() {
        int i5 = readInt();
        if (i5 < 0) {
            return null;
        }
        float[] fArr = new float[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            fArr[i6] = readFloat();
        }
        return fArr;
    }

    public int[] readIntArray() {
        int i5 = readInt();
        if (i5 < 0) {
            return null;
        }
        int[] iArr = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr[i6] = readInt();
        }
        return iArr;
    }

    public long[] readLongArray() {
        int i5 = readInt();
        if (i5 < 0) {
            return null;
        }
        long[] jArr = new long[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            jArr[i6] = readLong();
        }
        return jArr;
    }

    public <T extends VersionedParcelable> T readVersionedParcelable() {
        String string = readString();
        if (string == null) {
            return null;
        }
        return (T) readFromParcel(string, createSubParcel());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void writeArray(T[] tArr) {
        if (tArr == 0) {
            writeInt(-1);
            return;
        }
        int length = tArr.length;
        writeInt(length);
        if (length > 0) {
            int i5 = 0;
            int type = getType(tArr[0]);
            writeInt(type);
            if (type == 1) {
                while (i5 < length) {
                    writeVersionedParcelable((VersionedParcelable) tArr[i5]);
                    i5++;
                }
                return;
            }
            if (type == 2) {
                while (i5 < length) {
                    writeParcelable((Parcelable) tArr[i5]);
                    i5++;
                }
                return;
            }
            if (type == 3) {
                while (i5 < length) {
                    writeSerializable((Serializable) tArr[i5]);
                    i5++;
                }
            } else if (type == 4) {
                while (i5 < length) {
                    writeString((String) tArr[i5]);
                    i5++;
                }
            } else {
                if (type != 5) {
                    return;
                }
                while (i5 < length) {
                    writeStrongBinder((IBinder) tArr[i5]);
                    i5++;
                }
            }
        }
    }

    public void writeBooleanArray(boolean[] zArr) {
        if (zArr != null) {
            writeInt(zArr.length);
            for (boolean z6 : zArr) {
                writeInt(z6 ? 1 : 0);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeByteArray(byte[] bArr, int i5, int i6, int i7) {
        setOutputField(i7);
        writeByteArray(bArr, i5, i6);
    }

    public void writeDoubleArray(double[] dArr) {
        if (dArr != null) {
            writeInt(dArr.length);
            for (double d : dArr) {
                writeDouble(d);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeFloatArray(float[] fArr) {
        if (fArr != null) {
            writeInt(fArr.length);
            for (float f6 : fArr) {
                writeFloat(f6);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeIntArray(int[] iArr) {
        if (iArr != null) {
            writeInt(iArr.length);
            for (int i5 : iArr) {
                writeInt(i5);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeLongArray(long[] jArr) {
        if (jArr != null) {
            writeInt(jArr.length);
            for (long j6 : jArr) {
                writeLong(j6);
            }
            return;
        }
        writeInt(-1);
    }

    public void writeVersionedParcelable(VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            writeString(null);
            return;
        }
        writeVersionedParcelableCreator(versionedParcelable);
        VersionedParcel versionedParcelCreateSubParcel = createSubParcel();
        writeToParcel(versionedParcelable, versionedParcelCreateSubParcel);
        versionedParcelCreateSubParcel.closeField();
    }

    private Exception readException(int i5, String str) {
        return createException(i5, str);
    }

    public void setSerializationFlags(boolean z6, boolean z7) {
    }
}
