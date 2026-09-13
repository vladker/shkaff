package org.apache.commons.math3.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class SobolSequenceGenerator implements RandomVectorGenerator {
    private static final int BITS = 52;
    private static final String FILE_CHARSET = "US-ASCII";
    private static final int MAX_DIMENSION = 1000;
    private static final String RESOURCE_NAME = "/assets/org/apache/commons/math3/random/new-joe-kuo-6.1000";
    private static final double SCALE = FastMath.pow(2.0d, 52);
    private int count = 0;
    private final int dimension;
    private final long[][] direction;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final long[] f6886x;

    public SobolSequenceGenerator(int i5) {
        if (i5 < 1 || i5 > 1000) {
            throw new OutOfRangeException(Integer.valueOf(i5), 1, 1000);
        }
        InputStream resourceAsStream = getClass().getResourceAsStream(RESOURCE_NAME);
        if (resourceAsStream == null) {
            throw new MathInternalError();
        }
        this.dimension = i5;
        this.direction = (long[][]) Array.newInstance((Class<?>) Long.TYPE, i5, 53);
        this.f6886x = new long[i5];
        try {
            try {
                initFromStream(resourceAsStream);
                try {
                    resourceAsStream.close();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                throw new MathInternalError();
            } catch (MathParseException unused3) {
                throw new MathInternalError();
            }
        } catch (Throwable th) {
            try {
                resourceAsStream.close();
            } catch (IOException unused4) {
            }
            throw th;
        }
    }

    private void initDirectionVector(int i5, int i6, int[] iArr) {
        int length = iArr.length;
        int i7 = length - 1;
        for (int i8 = 1; i8 <= i7; i8++) {
            this.direction[i5][i8] = ((long) iArr[i8]) << (52 - i8);
        }
        for (int i9 = length; i9 <= 52; i9++) {
            long[] jArr = this.direction[i5];
            long j6 = jArr[i9 - i7];
            jArr[i9] = j6 ^ (j6 >> i7);
            int i10 = 1;
            while (true) {
                int i11 = length - 2;
                if (i10 <= i11) {
                    long[] jArr2 = this.direction[i5];
                    jArr2[i9] = jArr2[i9] ^ (((long) ((i6 >> (i11 - i10)) & 1)) * jArr2[i9 - i10]);
                    i10++;
                }
            }
        }
    }

    private int initFromStream(InputStream inputStream) throws IOException {
        for (int i5 = 1; i5 <= 52; i5++) {
            this.direction[0][i5] = 1 << (52 - i5);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("US-ASCII")));
        try {
            bufferedReader.readLine();
            int i6 = -1;
            int i7 = 2;
            int i8 = 1;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return i6;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                try {
                    int i9 = Integer.parseInt(stringTokenizer.nextToken());
                    if (i9 >= 2 && i9 <= this.dimension) {
                        int i10 = Integer.parseInt(stringTokenizer.nextToken());
                        int i11 = Integer.parseInt(stringTokenizer.nextToken());
                        int[] iArr = new int[i10 + 1];
                        for (int i12 = 1; i12 <= i10; i12++) {
                            iArr[i12] = Integer.parseInt(stringTokenizer.nextToken());
                        }
                        initDirectionVector(i8, i11, iArr);
                        i8++;
                    }
                    if (i9 > this.dimension) {
                        bufferedReader.close();
                        return i9;
                    }
                    i7++;
                    i6 = i9;
                } catch (NumberFormatException unused) {
                    throw new MathParseException(line, i7);
                } catch (NoSuchElementException unused2) {
                    throw new MathParseException(line, i7);
                }
            }
        } catch (Throwable th) {
            bufferedReader.close();
            throw th;
        }
    }

    public int getNextIndex() {
        return this.count;
    }

    @Override // org.apache.commons.math3.random.RandomVectorGenerator
    public double[] nextVector() {
        double[] dArr = new double[this.dimension];
        int i5 = this.count;
        if (i5 == 0) {
            this.count = i5 + 1;
            return dArr;
        }
        int i6 = i5 - 1;
        int i7 = 1;
        while ((i6 & 1) == 1) {
            i6 >>= 1;
            i7++;
        }
        for (int i8 = 0; i8 < this.dimension; i8++) {
            long[] jArr = this.f6886x;
            long j6 = jArr[i8] ^ this.direction[i8][i7];
            jArr[i8] = j6;
            dArr[i8] = j6 / SCALE;
        }
        this.count++;
        return dArr;
    }

    public double[] skipTo(int i5) {
        if (i5 == 0) {
            Arrays.fill(this.f6886x, 0L);
        } else {
            int i6 = i5 - 1;
            long j6 = i6 ^ (i6 >> 1);
            for (int i7 = 0; i7 < this.dimension; i7++) {
                long j7 = 0;
                for (int i8 = 1; i8 <= 52; i8++) {
                    long j8 = j6 >> (i8 - 1);
                    if (j8 == 0) {
                        break;
                    }
                    j7 ^= (j8 & 1) * this.direction[i7][i8];
                }
                this.f6886x[i7] = j7;
            }
        }
        this.count = i5;
        return nextVector();
    }

    public SobolSequenceGenerator(int i5, InputStream inputStream) throws IOException {
        if (i5 >= 1) {
            this.dimension = i5;
            this.direction = (long[][]) Array.newInstance((Class<?>) Long.TYPE, i5, 53);
            this.f6886x = new long[i5];
            int iInitFromStream = initFromStream(inputStream);
            if (iInitFromStream < i5) {
                throw new OutOfRangeException(Integer.valueOf(i5), 1, Integer.valueOf(iInitFromStream));
            }
            return;
        }
        throw new NotStrictlyPositiveException(Integer.valueOf(i5));
    }
}
