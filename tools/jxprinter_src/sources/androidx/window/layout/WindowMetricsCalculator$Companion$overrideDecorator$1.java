package androidx.window.layout;

import O3.l;
import kotlin.jvm.internal.B;
import kotlin.jvm.internal.E;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class WindowMetricsCalculator$Companion$overrideDecorator$1 extends B implements l {
    public WindowMetricsCalculator$Companion$overrideDecorator$1(Object obj) {
        super(1, obj, WindowMetricsCalculatorDecorator.class, "decorate", "decorate(Landroidx/window/layout/WindowMetricsCalculator;)Landroidx/window/layout/WindowMetricsCalculator;", 0);
    }

    @Override // O3.l
    public final WindowMetricsCalculator invoke(WindowMetricsCalculator p1) {
        E.f(p1, "p0");
        return ((WindowMetricsCalculatorDecorator) this.receiver).decorate(p1);
    }
}
