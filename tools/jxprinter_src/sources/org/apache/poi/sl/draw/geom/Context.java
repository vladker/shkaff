package org.apache.poi.sl.draw.geom;

import A3.AbstractC0157z;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Context {
    private static final Pattern DOUBLE_PATTERN = Pattern.compile("[\\x00-\\x20]*[+-]?(NaN|Infinity|((((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)([eE][+-]?(\\p{Digit}+))?)|(\\.(\\p{Digit}+)([eE][+-]?(\\p{Digit}+))?)|(((0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+)))[pP][+-]?(\\p{Digit}+)))[fFdD]?))[\\x00-\\x20]*");
    private final Rectangle2D _anchor;
    private final Map<String, Double> _ctx = new HashMap();
    private final IAdjustableShape _props;

    public Context(CustomGeometry customGeometry, Rectangle2D rectangle2D, IAdjustableShape iAdjustableShape) {
        this._props = iAdjustableShape;
        this._anchor = rectangle2D;
        Iterator<AdjustValueIf> it = customGeometry.adjusts.iterator();
        while (it.hasNext()) {
            evaluate(it.next());
        }
        Iterator<GuideIf> it2 = customGeometry.guides.iterator();
        while (it2.hasNext()) {
            evaluate(it2.next());
        }
    }

    public double evaluate(Formula formula) {
        String name;
        double dEvaluate = formula.evaluate(this);
        if ((formula instanceof GuideIf) && (name = ((GuideIf) formula).getName()) != null) {
            this._ctx.put(name, Double.valueOf(dEvaluate));
        }
        return dEvaluate;
    }

    public GuideIf getAdjustValue(String str) {
        return this._props.getAdjustValue(str);
    }

    public Rectangle2D getShapeAnchor() {
        return this._anchor;
    }

    public double getValue(String str) {
        if (DOUBLE_PATTERN.matcher(str).matches()) {
            return Double.parseDouble(str);
        }
        return this._ctx.containsKey(str) ? this._ctx.get(str).doubleValue() : evaluate(BuiltInGuide.valueOf(AbstractC0157z.n("_", str)));
    }
}
