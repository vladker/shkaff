package org.apache.poi.sl.draw.geom;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface AdjustValueIf extends GuideIf {
    @Override // org.apache.poi.sl.draw.geom.GuideIf, org.apache.poi.sl.draw.geom.Formula
    default double evaluate(Context context) {
        return evaluateAdjustValue(context);
    }

    default double evaluateAdjustValue(Context context) {
        GuideIf adjustValue = context.getAdjustValue(getName());
        return adjustValue != null ? adjustValue.evaluate(context) : evaluateGuide(context);
    }
}
