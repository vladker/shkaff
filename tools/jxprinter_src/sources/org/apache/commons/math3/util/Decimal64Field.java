package org.apache.commons.math3.util;

import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Decimal64Field implements Field<Decimal64> {
    private static final Decimal64Field INSTANCE = new Decimal64Field();

    private Decimal64Field() {
    }

    public static final Decimal64Field getInstance() {
        return INSTANCE;
    }

    @Override // org.apache.commons.math3.Field
    public Class<? extends FieldElement<Decimal64>> getRuntimeClass() {
        return Decimal64.class;
    }

    @Override // org.apache.commons.math3.Field
    public Decimal64 getOne() {
        return Decimal64.ONE;
    }

    @Override // org.apache.commons.math3.Field
    public Decimal64 getZero() {
        return Decimal64.ZERO;
    }
}
