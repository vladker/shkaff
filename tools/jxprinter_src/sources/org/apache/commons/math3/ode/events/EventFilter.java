package org.apache.commons.math3.ode.events;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class EventFilter implements EventHandler {
    private static final int HISTORY_SIZE = 100;
    private double extremeT;
    private final FilterType filter;
    private boolean forward;
    private final EventHandler rawHandler;
    private final Transformer[] transformers = new Transformer[100];
    private final double[] updates = new double[100];

    public EventFilter(EventHandler eventHandler, FilterType filterType) {
        this.rawHandler = eventHandler;
        this.filter = filterType;
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public EventHandler.Action eventOccurred(double d, double[] dArr, boolean z6) {
        return this.rawHandler.eventOccurred(d, dArr, this.filter.getTriggeredIncreasing());
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public double g(double d, double[] dArr) {
        double dG = this.rawHandler.g(d, dArr);
        boolean z6 = this.forward;
        int i5 = 0;
        if (z6) {
            Transformer[] transformerArr = this.transformers;
            int length = transformerArr.length - 1;
            if (this.extremeT >= d) {
                while (length > 0) {
                    if (this.updates[length] <= d) {
                        return this.transformers[length].transformed(dG);
                    }
                    length--;
                }
                return this.transformers[0].transformed(dG);
            }
            Transformer transformer = transformerArr[length];
            Transformer transformerSelectTransformer = this.filter.selectTransformer(transformer, dG, z6);
            if (transformerSelectTransformer != transformer) {
                double[] dArr2 = this.updates;
                System.arraycopy(dArr2, 1, dArr2, 0, length);
                Transformer[] transformerArr2 = this.transformers;
                System.arraycopy(transformerArr2, 1, transformerArr2, 0, length);
                this.updates[length] = this.extremeT;
                this.transformers[length] = transformerSelectTransformer;
            }
            this.extremeT = d;
            return transformerSelectTransformer.transformed(dG);
        }
        if (d < this.extremeT) {
            Transformer transformer2 = this.transformers[0];
            Transformer transformerSelectTransformer2 = this.filter.selectTransformer(transformer2, dG, z6);
            if (transformerSelectTransformer2 != transformer2) {
                double[] dArr3 = this.updates;
                System.arraycopy(dArr3, 0, dArr3, 1, dArr3.length - 1);
                Transformer[] transformerArr3 = this.transformers;
                System.arraycopy(transformerArr3, 0, transformerArr3, 1, transformerArr3.length - 1);
                this.updates[0] = this.extremeT;
                this.transformers[0] = transformerSelectTransformer2;
            }
            this.extremeT = d;
            return transformerSelectTransformer2.transformed(dG);
        }
        while (true) {
            double[] dArr4 = this.updates;
            if (i5 >= dArr4.length - 1) {
                return this.transformers[dArr4.length - 1].transformed(dG);
            }
            if (d <= dArr4[i5]) {
                return this.transformers[i5].transformed(dG);
            }
            i5++;
        }
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public void init(double d, double[] dArr, double d6) {
        this.rawHandler.init(d, dArr, d6);
        boolean z6 = d6 >= d;
        this.forward = z6;
        this.extremeT = z6 ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        Arrays.fill(this.transformers, Transformer.UNINITIALIZED);
        Arrays.fill(this.updates, this.extremeT);
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public void resetState(double d, double[] dArr) {
        this.rawHandler.resetState(d, dArr);
    }
}
