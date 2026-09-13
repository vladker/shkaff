package org.apache.commons.math3.random;

import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public interface RandomData {
    double nextExponential(double d);

    double nextGaussian(double d, double d6);

    String nextHexString(int i5);

    int nextInt(int i5, int i6);

    long nextLong(long j6, long j7);

    int[] nextPermutation(int i5, int i6);

    long nextPoisson(double d);

    Object[] nextSample(Collection<?> collection, int i5);

    String nextSecureHexString(int i5);

    int nextSecureInt(int i5, int i6);

    long nextSecureLong(long j6, long j7);

    double nextUniform(double d, double d6);

    double nextUniform(double d, double d6, boolean z6);
}
