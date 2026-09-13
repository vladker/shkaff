package org.opencv.core;

import A3.AbstractC0157z;
import androidx.collection.a;
import androidx.webkit.ProxyConfig;
import java.nio.ByteBuffer;
import kotlinx.serialization.json.internal.AbstractC1125a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class Mat {
    public final long nativeObj;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Atable<T> {
        T getV();

        Tuple2<T> getV2c();

        Tuple3<T> getV3c();

        Tuple4<T> getV4c();

        void setV(T t6);

        void setV2c(Tuple2<T> tuple2);

        void setV3c(Tuple3<T> tuple3);

        void setV4c(Tuple4<T> tuple4);
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AtableByte extends AtableBase implements Atable<Byte> {
        public AtableByte(Mat mat, int i5, int i6) {
            super(mat, i5, i6);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Byte> getV2c() {
            byte[] bArr = new byte[2];
            this.mat.get(this.indices, bArr);
            return new Tuple2<>(Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Byte> getV3c() {
            byte[] bArr = new byte[3];
            this.mat.get(this.indices, bArr);
            return new Tuple3<>(Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Byte> getV4c() {
            byte[] bArr = new byte[4];
            this.mat.get(this.indices, bArr);
            return new Tuple4<>(Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Byte> tuple2) {
            this.mat.put(this.indices, new byte[]{((Byte) ((Tuple2) tuple2)._0).byteValue(), ((Byte) ((Tuple2) tuple2)._1).byteValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Byte> tuple3) {
            this.mat.put(this.indices, new byte[]{((Byte) ((Tuple3) tuple3)._0).byteValue(), ((Byte) ((Tuple3) tuple3)._1).byteValue(), ((Byte) ((Tuple3) tuple3)._2).byteValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Byte> tuple4) {
            this.mat.put(this.indices, new byte[]{((Byte) ((Tuple4) tuple4)._0).byteValue(), ((Byte) ((Tuple4) tuple4)._1).byteValue(), ((Byte) ((Tuple4) tuple4)._2).byteValue(), ((Byte) ((Tuple4) tuple4)._3).byteValue()});
        }

        public AtableByte(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Byte getV() {
            byte[] bArr = new byte[1];
            this.mat.get(this.indices, bArr);
            return Byte.valueOf(bArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Byte b) {
            this.mat.put(this.indices, new byte[]{b.byteValue()});
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AtableDouble extends AtableBase implements Atable<Double> {
        public AtableDouble(Mat mat, int i5, int i6) {
            super(mat, i5, i6);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Double> getV2c() {
            double[] dArr = new double[2];
            this.mat.get(this.indices, dArr);
            return new Tuple2<>(Double.valueOf(dArr[0]), Double.valueOf(dArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Double> getV3c() {
            double[] dArr = new double[3];
            this.mat.get(this.indices, dArr);
            return new Tuple3<>(Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Double> getV4c() {
            double[] dArr = new double[4];
            this.mat.get(this.indices, dArr);
            return new Tuple4<>(Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr[2]), Double.valueOf(dArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Double> tuple2) {
            this.mat.put(this.indices, ((Double) ((Tuple2) tuple2)._0).doubleValue(), ((Double) ((Tuple2) tuple2)._1).doubleValue());
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Double> tuple3) {
            this.mat.put(this.indices, ((Double) ((Tuple3) tuple3)._0).doubleValue(), ((Double) ((Tuple3) tuple3)._1).doubleValue(), ((Double) ((Tuple3) tuple3)._2).doubleValue());
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Double> tuple4) {
            this.mat.put(this.indices, ((Double) ((Tuple4) tuple4)._0).doubleValue(), ((Double) ((Tuple4) tuple4)._1).doubleValue(), ((Double) ((Tuple4) tuple4)._2).doubleValue(), ((Double) ((Tuple4) tuple4)._3).doubleValue());
        }

        public AtableDouble(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Double getV() {
            double[] dArr = new double[1];
            this.mat.get(this.indices, dArr);
            return Double.valueOf(dArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Double d) {
            this.mat.put(this.indices, d.doubleValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AtableFloat extends AtableBase implements Atable<Float> {
        public AtableFloat(Mat mat, int i5, int i6) {
            super(mat, i5, i6);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Float> getV2c() {
            float[] fArr = new float[2];
            this.mat.get(this.indices, fArr);
            return new Tuple2<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Float> getV3c() {
            float[] fArr = new float[3];
            this.mat.get(this.indices, fArr);
            return new Tuple3<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Float> getV4c() {
            float[] fArr = new float[4];
            this.mat.get(this.indices, fArr);
            return new Tuple4<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]), Float.valueOf(fArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Float> tuple2) {
            this.mat.put(this.indices, new float[]{((Float) ((Tuple2) tuple2)._0).floatValue(), ((Float) ((Tuple2) tuple2)._1).floatValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Float> tuple3) {
            this.mat.put(this.indices, new float[]{((Float) ((Tuple3) tuple3)._0).floatValue(), ((Float) ((Tuple3) tuple3)._1).floatValue(), ((Float) ((Tuple3) tuple3)._2).floatValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Float> tuple4) {
            this.mat.put(this.indices, ((Float) ((Tuple4) tuple4)._0).floatValue(), ((Float) ((Tuple4) tuple4)._1).floatValue(), ((Float) ((Tuple4) tuple4)._2).floatValue(), ((Float) ((Tuple4) tuple4)._3).floatValue());
        }

        public AtableFloat(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Float getV() {
            float[] fArr = new float[1];
            this.mat.get(this.indices, fArr);
            return Float.valueOf(fArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Float f6) {
            this.mat.put(this.indices, new float[]{f6.floatValue()});
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AtableInteger extends AtableBase implements Atable<Integer> {
        public AtableInteger(Mat mat, int i5, int i6) {
            super(mat, i5, i6);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Integer> getV2c() {
            int[] iArr = new int[2];
            this.mat.get(this.indices, iArr);
            return new Tuple2<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Integer> getV3c() {
            int[] iArr = new int[3];
            this.mat.get(this.indices, iArr);
            return new Tuple3<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Integer> getV4c() {
            int[] iArr = new int[4];
            this.mat.get(this.indices, iArr);
            return new Tuple4<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Integer> tuple2) {
            this.mat.put(this.indices, new int[]{((Integer) ((Tuple2) tuple2)._0).intValue(), ((Integer) ((Tuple2) tuple2)._1).intValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Integer> tuple3) {
            this.mat.put(this.indices, new int[]{((Integer) ((Tuple3) tuple3)._0).intValue(), ((Integer) ((Tuple3) tuple3)._1).intValue(), ((Integer) ((Tuple3) tuple3)._2).intValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Integer> tuple4) {
            this.mat.put(this.indices, new int[]{((Integer) ((Tuple4) tuple4)._0).intValue(), ((Integer) ((Tuple4) tuple4)._1).intValue(), ((Integer) ((Tuple4) tuple4)._2).intValue(), ((Integer) ((Tuple4) tuple4)._3).intValue()});
        }

        public AtableInteger(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Integer getV() {
            int[] iArr = new int[1];
            this.mat.get(this.indices, iArr);
            return Integer.valueOf(iArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Integer num) {
            this.mat.put(this.indices, new int[]{num.intValue()});
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AtableShort extends AtableBase implements Atable<Short> {
        public AtableShort(Mat mat, int i5, int i6) {
            super(mat, i5, i6);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Short> getV2c() {
            short[] sArr = new short[2];
            this.mat.get(this.indices, sArr);
            return new Tuple2<>(Short.valueOf(sArr[0]), Short.valueOf(sArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Short> getV3c() {
            short[] sArr = new short[3];
            this.mat.get(this.indices, sArr);
            return new Tuple3<>(Short.valueOf(sArr[0]), Short.valueOf(sArr[1]), Short.valueOf(sArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Short> getV4c() {
            short[] sArr = new short[4];
            this.mat.get(this.indices, sArr);
            return new Tuple4<>(Short.valueOf(sArr[0]), Short.valueOf(sArr[1]), Short.valueOf(sArr[2]), Short.valueOf(sArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Short> tuple2) {
            this.mat.put(this.indices, new short[]{((Short) ((Tuple2) tuple2)._0).shortValue(), ((Short) ((Tuple2) tuple2)._1).shortValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Short> tuple3) {
            this.mat.put(this.indices, new short[]{((Short) ((Tuple3) tuple3)._0).shortValue(), ((Short) ((Tuple3) tuple3)._1).shortValue(), ((Short) ((Tuple3) tuple3)._2).shortValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Short> tuple4) {
            this.mat.put(this.indices, new short[]{((Short) ((Tuple4) tuple4)._0).shortValue(), ((Short) ((Tuple4) tuple4)._1).shortValue(), ((Short) ((Tuple4) tuple4)._2).shortValue(), ((Short) ((Tuple4) tuple4)._3).shortValue()});
        }

        public AtableShort(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        @Override // org.opencv.core.Mat.Atable
        public Short getV() {
            short[] sArr = new short[1];
            this.mat.get(this.indices, sArr);
            return Short.valueOf(sArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Short sh) {
            this.mat.put(this.indices, new short[]{sh.shortValue()});
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Tuple2<T> {
        private final T _0;
        private final T _1;

        public Tuple2(T t6, T t7) {
            this._0 = t6;
            this._1 = t7;
        }

        public T get_0() {
            return this._0;
        }

        public T get_1() {
            return this._1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Tuple3<T> {
        private final T _0;
        private final T _1;
        private final T _2;

        public Tuple3(T t6, T t7, T t8) {
            this._0 = t6;
            this._1 = t7;
            this._2 = t8;
        }

        public T get_0() {
            return this._0;
        }

        public T get_1() {
            return this._1;
        }

        public T get_2() {
            return this._2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Tuple4<T> {
        private final T _0;
        private final T _1;
        private final T _2;
        private final T _3;

        public Tuple4(T t6, T t7, T t8, T t9) {
            this._0 = t6;
            this._1 = t7;
            this._2 = t8;
            this._3 = t9;
        }

        public T get_0() {
            return this._0;
        }

        public T get_1() {
            return this._1;
        }

        public T get_2() {
            return this._2;
        }

        public T get_3() {
            return this._3;
        }
    }

    public Mat(long j6) {
        if (j6 == 0) {
            throw new UnsupportedOperationException("Native object address is NULL");
        }
        this.nativeObj = j6;
    }

    public static Mat eye(int i5, int i6, int i7) {
        return new Mat(n_eye(i5, i6, i7));
    }

    private static native void locateROI_0(long j6, double[] dArr, double[] dArr2);

    private static native String nDump(long j6);

    private static native double[] nGet(long j6, int i5, int i6);

    private static native int nGetB(long j6, int i5, int i6, int i7, byte[] bArr);

    private static native int nGetBIdx(long j6, int[] iArr, int i5, byte[] bArr);

    private static native int nGetD(long j6, int i5, int i6, int i7, double[] dArr);

    private static native int nGetDIdx(long j6, int[] iArr, int i5, double[] dArr);

    private static native int nGetF(long j6, int i5, int i6, int i7, float[] fArr);

    private static native int nGetFIdx(long j6, int[] iArr, int i5, float[] fArr);

    private static native int nGetI(long j6, int i5, int i6, int i7, int[] iArr);

    private static native int nGetIIdx(long j6, int[] iArr, int i5, int[] iArr2);

    private static native double[] nGetIdx(long j6, int[] iArr);

    private static native int nGetS(long j6, int i5, int i6, int i7, short[] sArr);

    private static native int nGetSIdx(long j6, int[] iArr, int i5, short[] sArr);

    private static native int nPutB(long j6, int i5, int i6, int i7, byte[] bArr);

    private static native int nPutBIdx(long j6, int[] iArr, int i5, byte[] bArr);

    private static native int nPutBwIdxOffset(long j6, int[] iArr, int i5, int i6, byte[] bArr);

    private static native int nPutBwOffset(long j6, int i5, int i6, int i7, int i8, byte[] bArr);

    private static native int nPutD(long j6, int i5, int i6, int i7, double[] dArr);

    private static native int nPutDIdx(long j6, int[] iArr, int i5, double[] dArr);

    private static native int nPutF(long j6, int i5, int i6, int i7, float[] fArr);

    private static native int nPutFIdx(long j6, int[] iArr, int i5, float[] fArr);

    private static native int nPutI(long j6, int i5, int i6, int i7, int[] iArr);

    private static native int nPutIIdx(long j6, int[] iArr, int i5, int[] iArr2);

    private static native int nPutS(long j6, int i5, int i6, int i7, short[] sArr);

    private static native int nPutSIdx(long j6, int[] iArr, int i5, short[] sArr);

    private static native long n_Mat();

    private static native long n_Mat(double d, double d6, int i5);

    private static native long n_Mat(double d, double d6, int i5, double d7, double d8, double d9, double d10);

    private static native long n_Mat(int i5, int i6, int i7);

    private static native long n_Mat(int i5, int i6, int i7, double d, double d6, double d7, double d8);

    private static native long n_Mat(int i5, int i6, int i7, ByteBuffer byteBuffer);

    private static native long n_Mat(int i5, int i6, int i7, ByteBuffer byteBuffer, long j6);

    private static native long n_Mat(int i5, int[] iArr, int i6);

    private static native long n_Mat(int i5, int[] iArr, int i6, double d, double d6, double d7, double d8);

    private static native long n_Mat(long j6, int i5, int i6);

    private static native long n_Mat(long j6, int i5, int i6, int i7, int i8);

    private static native long n_Mat(long j6, Range[] rangeArr);

    private static native long n_adjustROI(long j6, int i5, int i6, int i7, int i8);

    private static native void n_assignTo(long j6, long j7);

    private static native void n_assignTo(long j6, long j7, int i5);

    private static native int n_channels(long j6);

    private static native int n_checkVector(long j6, int i5);

    private static native int n_checkVector(long j6, int i5, int i6);

    private static native int n_checkVector(long j6, int i5, int i6, boolean z6);

    private static native long n_clone(long j6);

    private static native long n_col(long j6, int i5);

    private static native long n_colRange(long j6, int i5, int i6);

    private static native int n_cols(long j6);

    private static native void n_convertTo(long j6, long j7, int i5);

    private static native void n_convertTo(long j6, long j7, int i5, double d);

    private static native void n_convertTo(long j6, long j7, int i5, double d, double d6);

    private static native void n_copySize(long j6, long j7);

    private static native void n_copyTo(long j6, long j7);

    private static native void n_copyTo(long j6, long j7, long j8);

    private static native void n_create(long j6, double d, double d6, int i5);

    private static native void n_create(long j6, int i5, int i6, int i7);

    private static native void n_create(long j6, int i5, int[] iArr, int i6);

    private static native long n_cross(long j6, long j7);

    private static native long n_dataAddr(long j6);

    private static native void n_delete(long j6);

    private static native int n_depth(long j6);

    private static native long n_diag(long j6);

    private static native long n_diag(long j6, int i5);

    private static native int n_dims(long j6);

    private static native double n_dot(long j6, long j7);

    private static native long n_elemSize(long j6);

    private static native long n_elemSize1(long j6);

    private static native boolean n_empty(long j6);

    private static native long n_eye(double d, double d6, int i5);

    private static native long n_eye(int i5, int i6, int i7);

    private static native long n_inv(long j6);

    private static native long n_inv(long j6, int i5);

    private static native boolean n_isContinuous(long j6);

    private static native boolean n_isSubmatrix(long j6);

    private static native long n_matMul(long j6, long j7);

    private static native long n_mul(long j6, long j7);

    private static native long n_mul(long j6, long j7, double d);

    private static native long n_ones(double d, double d6, int i5);

    private static native long n_ones(int i5, int i6, int i7);

    private static native long n_ones(int i5, int[] iArr, int i6);

    private static native void n_push_back(long j6, long j7);

    private static native void n_release(long j6);

    private static native long n_reshape(long j6, int i5);

    private static native long n_reshape(long j6, int i5, int i6);

    private static native long n_reshape_1(long j6, int i5, int i6, int[] iArr);

    private static native long n_row(long j6, int i5);

    private static native long n_rowRange(long j6, int i5, int i6);

    private static native int n_rows(long j6);

    private static native long n_setTo(long j6, double d, double d6, double d7, double d8);

    private static native long n_setTo(long j6, double d, double d6, double d7, double d8, long j7);

    private static native long n_setTo(long j6, long j7);

    private static native long n_setTo(long j6, long j7, long j8);

    private static native double[] n_size(long j6);

    private static native int n_size_i(long j6, int i5);

    private static native long n_step1(long j6);

    private static native long n_step1(long j6, int i5);

    private static native long n_submat(long j6, int i5, int i6, int i7, int i8);

    private static native long n_submat_ranges(long j6, Range[] rangeArr);

    private static native long n_submat_rr(long j6, int i5, int i6, int i7, int i8);

    private static native long n_t(long j6);

    private static native long n_total(long j6);

    private static native int n_type(long j6);

    private static native long n_zeros(double d, double d6, int i5);

    private static native long n_zeros(int i5, int i6, int i7);

    private static native long n_zeros(int i5, int[] iArr, int i6);

    public static Mat ones(int i5, int i6, int i7) {
        return new Mat(n_ones(i5, i6, i7));
    }

    public static Mat zeros(int i5, int i6, int i7) {
        return new Mat(n_zeros(i5, i6, i7));
    }

    public Mat adjustROI(int i5, int i6, int i7, int i8) {
        return new Mat(n_adjustROI(this.nativeObj, i5, i6, i7, i8));
    }

    public void assignTo(Mat mat, int i5) {
        n_assignTo(this.nativeObj, mat.nativeObj, i5);
    }

    public <T> Atable<T> at(Class<T> cls, int i5, int i6) {
        if (cls == Byte.class || cls == Byte.TYPE) {
            return new AtableByte(this, i5, i6);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return new AtableDouble(this, i5, i6);
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return new AtableFloat(this, i5, i6);
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return new AtableInteger(this, i5, i6);
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return new AtableShort(this, i5, i6);
        }
        throw new RuntimeException("Unsupported class type");
    }

    public int channels() {
        return n_channels(this.nativeObj);
    }

    public int checkVector(int i5, int i6, boolean z6) {
        return n_checkVector(this.nativeObj, i5, i6, z6);
    }

    public Mat col(int i5) {
        return new Mat(n_col(this.nativeObj, i5));
    }

    public Mat colRange(int i5, int i6) {
        return new Mat(n_colRange(this.nativeObj, i5, i6));
    }

    public int cols() {
        return n_cols(this.nativeObj);
    }

    public void convertTo(Mat mat, int i5, double d, double d6) {
        n_convertTo(this.nativeObj, mat.nativeObj, i5, d, d6);
    }

    public void copySize(Mat mat) {
        n_copySize(this.nativeObj, mat.nativeObj);
    }

    public void copyTo(Mat mat) {
        n_copyTo(this.nativeObj, mat.nativeObj);
    }

    public void create(int i5, int i6, int i7) {
        n_create(this.nativeObj, i5, i6, i7);
    }

    public Mat cross(Mat mat) {
        return new Mat(n_cross(this.nativeObj, mat.nativeObj));
    }

    public long dataAddr() {
        return n_dataAddr(this.nativeObj);
    }

    public int depth() {
        return n_depth(this.nativeObj);
    }

    public Mat diag(int i5) {
        return new Mat(n_diag(this.nativeObj, i5));
    }

    public int dims() {
        return n_dims(this.nativeObj);
    }

    public double dot(Mat mat) {
        return n_dot(this.nativeObj, mat.nativeObj);
    }

    public String dump() {
        return nDump(this.nativeObj);
    }

    public long elemSize() {
        return n_elemSize(this.nativeObj);
    }

    public long elemSize1() {
        return n_elemSize1(this.nativeObj);
    }

    public boolean empty() {
        return n_empty(this.nativeObj);
    }

    public void finalize() throws Throwable {
        n_delete(this.nativeObj);
        super.finalize();
    }

    public int get(int i5, int i6, byte[] bArr) {
        int iType = type();
        if (bArr == null || bArr.length % CvType.channels(iType) != 0) {
            throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), bArr == null ? 0 : bArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
        }
        if (CvType.depth(iType) == 0 || CvType.depth(iType) == 1) {
            return nGetB(this.nativeObj, i5, i6, bArr.length, bArr);
        }
        throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int height() {
        return rows();
    }

    public Mat inv(int i5) {
        return new Mat(n_inv(this.nativeObj, i5));
    }

    public boolean isContinuous() {
        return n_isContinuous(this.nativeObj);
    }

    public boolean isSubmatrix() {
        return n_isSubmatrix(this.nativeObj);
    }

    public void locateROI(Size size, Point point) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        locateROI_0(this.nativeObj, dArr, dArr2);
        if (size != null) {
            size.width = dArr[0];
            size.height = dArr[1];
        }
        if (point != null) {
            point.f7681x = dArr2[0];
            point.f7682y = dArr2[1];
        }
    }

    public Mat matMul(Mat mat) {
        return new Mat(n_matMul(this.nativeObj, mat.nativeObj));
    }

    public Mat mul(Mat mat, double d) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj, d));
    }

    public void push_back(Mat mat) {
        n_push_back(this.nativeObj, mat.nativeObj);
    }

    public int put(int i5, int i6, double... dArr) {
        int iType = type();
        if (dArr == null || dArr.length % CvType.channels(iType) != 0) {
            throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), dArr == null ? 0 : dArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
        }
        return nPutD(this.nativeObj, i5, i6, dArr.length, dArr);
    }

    public void release() {
        n_release(this.nativeObj);
    }

    public Mat reshape(int i5, int i6) {
        return new Mat(n_reshape(this.nativeObj, i5, i6));
    }

    public Mat row(int i5) {
        return new Mat(n_row(this.nativeObj, i5));
    }

    public Mat rowRange(int i5, int i6) {
        return new Mat(n_rowRange(this.nativeObj, i5, i6));
    }

    public int rows() {
        return n_rows(this.nativeObj);
    }

    public Mat setTo(Scalar scalar) {
        long j6 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j6, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public Size size() {
        return new Size(n_size(this.nativeObj));
    }

    public long step1(int i5) {
        return n_step1(this.nativeObj, i5);
    }

    public Mat submat(int i5, int i6, int i7, int i8) {
        return new Mat(n_submat_rr(this.nativeObj, i5, i6, i7, i8));
    }

    public Mat t() {
        return new Mat(n_t(this.nativeObj));
    }

    public String toString() {
        String string = dims() > 0 ? "" : "-1*-1*";
        for (int i5 = 0; i5 < dims(); i5++) {
            StringBuilder sbR = a.r(string);
            sbR.append(size(i5));
            sbR.append(ProxyConfig.MATCH_ALL_SCHEMES);
            string = sbR.toString();
        }
        return "Mat [ " + string + CvType.typeToString(type()) + ", isCont=" + isContinuous() + ", isSubmat=" + isSubmatrix() + ", nativeObj=0x" + Long.toHexString(this.nativeObj) + ", dataAddr=0x" + Long.toHexString(dataAddr()) + " ]";
    }

    public long total() {
        return n_total(this.nativeObj);
    }

    public int type() {
        return n_type(this.nativeObj);
    }

    public int width() {
        return cols();
    }

    public static Mat eye(Size size, int i5) {
        return new Mat(n_eye(size.width, size.height, i5));
    }

    public static Mat ones(Size size, int i5) {
        return new Mat(n_ones(size.width, size.height, i5));
    }

    public static Mat zeros(Size size, int i5) {
        return new Mat(n_zeros(size.width, size.height, i5));
    }

    public void assignTo(Mat mat) {
        n_assignTo(this.nativeObj, mat.nativeObj);
    }

    public int checkVector(int i5, int i6) {
        return n_checkVector(this.nativeObj, i5, i6);
    }

    public Mat clone() {
        return new Mat(n_clone(this.nativeObj));
    }

    public Mat colRange(Range range) {
        return new Mat(n_colRange(this.nativeObj, range.start, range.end));
    }

    public void convertTo(Mat mat, int i5, double d) {
        n_convertTo(this.nativeObj, mat.nativeObj, i5, d);
    }

    public void copyTo(Mat mat, Mat mat2) {
        n_copyTo(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void create(Size size, int i5) {
        n_create(this.nativeObj, size.width, size.height, i5);
    }

    public Mat diag() {
        return new Mat(n_diag(this.nativeObj, 0));
    }

    public Mat inv() {
        return new Mat(n_inv(this.nativeObj));
    }

    public Mat mul(Mat mat) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj));
    }

    public Mat reshape(int i5) {
        return new Mat(n_reshape(this.nativeObj, i5));
    }

    public Mat rowRange(Range range) {
        return new Mat(n_rowRange(this.nativeObj, range.start, range.end));
    }

    public Mat setTo(Scalar scalar, Mat mat) {
        long j6 = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j6, dArr[0], dArr[1], dArr[2], dArr[3], mat.nativeObj));
    }

    public int size(int i5) {
        return n_size_i(this.nativeObj, i5);
    }

    public long step1() {
        return n_step1(this.nativeObj);
    }

    public Mat submat(Range range, Range range2) {
        return new Mat(n_submat_rr(this.nativeObj, range.start, range.end, range2.start, range2.end));
    }

    public static Mat diag(Mat mat) {
        return new Mat(n_diag(mat.nativeObj));
    }

    public static Mat ones(int[] iArr, int i5) {
        return new Mat(n_ones(iArr.length, iArr, i5));
    }

    public static Mat zeros(int[] iArr, int i5) {
        return new Mat(n_zeros(iArr.length, iArr, i5));
    }

    public int checkVector(int i5) {
        return n_checkVector(this.nativeObj, i5);
    }

    public void convertTo(Mat mat, int i5) {
        n_convertTo(this.nativeObj, mat.nativeObj, i5);
    }

    public void create(int[] iArr, int i5) {
        n_create(this.nativeObj, iArr.length, iArr, i5);
    }

    public Mat reshape(int i5, int[] iArr) {
        return new Mat(n_reshape_1(this.nativeObj, i5, iArr.length, iArr));
    }

    public Mat setTo(Mat mat, Mat mat2) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }

    public Mat submat(Range[] rangeArr) {
        return new Mat(n_submat_ranges(this.nativeObj, rangeArr));
    }

    public Mat() {
        this.nativeObj = n_Mat();
    }

    public Mat setTo(Mat mat) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj));
    }

    public Mat submat(Rect rect) {
        return new Mat(n_submat(this.nativeObj, rect.f7686x, rect.f7687y, rect.width, rect.height));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class AtableBase {
        protected final int[] indices;
        protected final Mat mat;

        public AtableBase(Mat mat, int i5, int i6) {
            this.mat = mat;
            this.indices = new int[]{i5, i6};
        }

        public AtableBase(Mat mat, int[] iArr) {
            this.mat = mat;
            this.indices = iArr;
        }
    }

    public Mat(int i5, int i6, int i7) {
        this.nativeObj = n_Mat(i5, i6, i7);
    }

    public Mat(int i5, int i6, int i7, ByteBuffer byteBuffer) {
        this.nativeObj = n_Mat(i5, i6, i7, byteBuffer);
    }

    public Mat(int i5, int i6, int i7, ByteBuffer byteBuffer, long j6) {
        this.nativeObj = n_Mat(i5, i6, i7, byteBuffer, j6);
    }

    public Mat(Size size, int i5) {
        this.nativeObj = n_Mat(size.width, size.height, i5);
    }

    public <T> Atable<T> at(Class<T> cls, int[] iArr) {
        if (cls != Byte.class && cls != Byte.TYPE) {
            if (cls != Double.class && cls != Double.TYPE) {
                if (cls != Float.class && cls != Float.TYPE) {
                    if (cls != Integer.class && cls != Integer.TYPE) {
                        if (cls != Short.class && cls != Short.TYPE) {
                            throw new RuntimeException("Unsupported class parameter");
                        }
                        return new AtableShort(this, iArr);
                    }
                    return new AtableInteger(this, iArr);
                }
                return new AtableFloat(this, iArr);
            }
            return new AtableDouble(this, iArr);
        }
        return new AtableByte(this, iArr);
    }

    public Mat(int[] iArr, int i5) {
        this.nativeObj = n_Mat(iArr.length, iArr, i5);
    }

    public int put(int[] iArr, double... dArr) {
        int iType = type();
        if (dArr != null && dArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                return nPutDIdx(this.nativeObj, iArr, dArr.length, dArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), dArr == null ? 0 : dArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public Mat(int i5, int i6, int i7, Scalar scalar) {
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(i5, i6, i7, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Mat(Size size, int i5, Scalar scalar) {
        double d = size.width;
        double d6 = size.height;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(d, d6, i5, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Mat(int[] iArr, int i5, Scalar scalar) {
        int length = iArr.length;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(length, iArr, i5, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Mat(Mat mat, Range range, Range range2) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end, range2.start, range2.end);
    }

    public int get(int[] iArr, byte[] bArr) {
        int iType = type();
        if (bArr != null && bArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                    throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
                }
                return nGetBIdx(this.nativeObj, iArr, bArr.length, bArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), bArr == null ? 0 : bArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public Mat(Mat mat, Range range) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end);
    }

    public Mat(Mat mat, Range[] rangeArr) {
        this.nativeObj = n_Mat(mat.nativeObj, rangeArr);
    }

    public Mat(Mat mat, Rect rect) {
        long j6 = mat.nativeObj;
        int i5 = rect.f7687y;
        int i6 = i5 + rect.height;
        int i7 = rect.f7686x;
        this.nativeObj = n_Mat(j6, i5, i6, i7, i7 + rect.width);
    }

    public int put(int i5, int i6, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 5) {
                return nPutF(this.nativeObj, i5, i6, fArr.length, fArr);
            }
            throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), fArr == null ? 0 : fArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int i5, int i6, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            return nGetS(this.nativeObj, i5, i6, sArr.length, sArr);
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), sArr == null ? 0 : sArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int[] iArr, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 5) {
                    return nPutFIdx(this.nativeObj, iArr, fArr.length, fArr);
                }
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), fArr == null ? 0 : fArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int[] iArr, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                    throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
                }
                return nGetSIdx(this.nativeObj, iArr, sArr.length, sArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), sArr == null ? 0 : sArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int i5, int i6, int[] iArr) {
        int iType = type();
        if (iArr != null && iArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 4) {
                return nPutI(this.nativeObj, i5, i6, iArr.length, iArr);
            }
            throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), iArr == null ? 0 : iArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int i5, int i6, int[] iArr) {
        int iType = type();
        if (iArr != null && iArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 4) {
                return nGetI(this.nativeObj, i5, i6, iArr.length, iArr);
            }
            throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), iArr == null ? 0 : iArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int[] iArr, int[] iArr2) {
        int iType = type();
        if (iArr2 != null && iArr2.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 4) {
                    return nPutIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
                }
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), iArr2 == null ? 0 : iArr2.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int[] iArr, int[] iArr2) {
        int iType = type();
        if (iArr2 != null && iArr2.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 4) {
                    return nGetIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
                }
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), iArr2 == null ? 0 : iArr2.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int i5, int i6, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            return nPutS(this.nativeObj, i5, i6, sArr.length, sArr);
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), sArr == null ? 0 : sArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int i5, int i6, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 5) {
                return nGetF(this.nativeObj, i5, i6, fArr.length, fArr);
            }
            throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), fArr == null ? 0 : fArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int[] iArr, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                    throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
                }
                return nPutSIdx(this.nativeObj, iArr, sArr.length, sArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), sArr == null ? 0 : sArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int[] iArr, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 5) {
                    return nGetFIdx(this.nativeObj, iArr, fArr.length, fArr);
                }
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), fArr == null ? 0 : fArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int i5, int i6, byte[] bArr) {
        int iType = type();
        if (bArr != null && bArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            return nPutB(this.nativeObj, i5, i6, bArr.length, bArr);
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), bArr == null ? 0 : bArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int i5, int i6, double[] dArr) {
        int iType = type();
        if (dArr != null && dArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 6) {
                return nGetD(this.nativeObj, i5, i6, dArr.length, dArr);
            }
            throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), dArr == null ? 0 : dArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int[] iArr, byte[] bArr) {
        int iType = type();
        if (bArr != null && bArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                    throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
                }
                return nPutBIdx(this.nativeObj, iArr, bArr.length, bArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), bArr == null ? 0 : bArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int get(int[] iArr, double[] dArr) {
        int iType = type();
        if (dArr != null && dArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 6) {
                    return nGetDIdx(this.nativeObj, iArr, dArr.length, dArr);
                }
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), dArr == null ? 0 : dArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public int put(int i5, int i6, byte[] bArr, int i7, int i8) {
        int iType = type();
        if (bArr != null && i8 % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
            }
            return nPutBwOffset(this.nativeObj, i5, i6, i8, i7, bArr);
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), bArr == null ? 0 : bArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }

    public double[] get(int i5, int i6) {
        return nGet(this.nativeObj, i5, i6);
    }

    public double[] get(int[] iArr) {
        if (iArr.length == dims()) {
            return nGetIdx(this.nativeObj, iArr);
        }
        throw new IllegalArgumentException("Incorrect number of indices");
    }

    public int put(int[] iArr, byte[] bArr, int i5, int i6) {
        int iType = type();
        if (bArr != null && i6 % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                    throw new UnsupportedOperationException(AbstractC0157z.k(iType, "Mat data type is not compatible: "));
                }
                return nPutBwIdxOffset(this.nativeObj, iArr, i6, i5, bArr);
            }
            throw new IllegalArgumentException("Incorrect number of indices");
        }
        throw new UnsupportedOperationException(AbstractC1125a.h(new StringBuilder("Provided data element number ("), bArr == null ? 0 : bArr.length, ") should be multiple of the Mat channels count (", iType, ")"));
    }
}
