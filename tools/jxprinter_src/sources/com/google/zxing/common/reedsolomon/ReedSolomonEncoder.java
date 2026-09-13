package com.google.zxing.common.reedsolomon;

import A3.AbstractC0157z;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class ReedSolomonEncoder {
    private final List<GenericGFPoly> cachedGenerators;
    private final GenericGF field;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.field = genericGF;
        ArrayList arrayList = new ArrayList();
        this.cachedGenerators = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    private GenericGFPoly buildGenerator(int i5) {
        if (i5 >= this.cachedGenerators.size()) {
            GenericGFPoly genericGFPolyMultiply = (GenericGFPoly) AbstractC0157z.f(1, this.cachedGenerators);
            for (int size = this.cachedGenerators.size(); size <= i5; size++) {
                GenericGF genericGF = this.field;
                genericGFPolyMultiply = genericGFPolyMultiply.multiply(new GenericGFPoly(genericGF, new int[]{1, genericGF.exp(genericGF.getGeneratorBase() + (size - 1))}));
                this.cachedGenerators.add(genericGFPolyMultiply);
            }
        }
        return this.cachedGenerators.get(i5);
    }

    public void encode(int[] iArr, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i5;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly genericGFPolyBuildGenerator = buildGenerator(i5);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] coefficients = new GenericGFPoly(this.field, iArr2).multiplyByMonomial(i5, 1).divide(genericGFPolyBuildGenerator)[1].getCoefficients();
        int length2 = i5 - coefficients.length;
        for (int i6 = 0; i6 < length2; i6++) {
            iArr[length + i6] = 0;
        }
        System.arraycopy(coefficients, 0, iArr, length + length2, coefficients.length);
    }
}
