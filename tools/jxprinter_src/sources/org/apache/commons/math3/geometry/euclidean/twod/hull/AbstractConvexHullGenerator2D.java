package org.apache.commons.math3.geometry.euclidean.twod.hull;

import java.util.Collection;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.hull.ConvexHull;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
abstract class AbstractConvexHullGenerator2D implements ConvexHullGenerator2D {
    private static final double DEFAULT_TOLERANCE = 1.0E-10d;
    private final boolean includeCollinearPoints;
    private final double tolerance;

    public AbstractConvexHullGenerator2D(boolean z6) {
        this(z6, 1.0E-10d);
    }

    public abstract Collection<Vector2D> findHullVertices(Collection<Vector2D> collection);

    @Override // org.apache.commons.math3.geometry.hull.ConvexHullGenerator
    public /* bridge */ /* synthetic */ ConvexHull generate(Collection collection) {
        return generate((Collection<Vector2D>) collection);
    }

    public double getTolerance() {
        return this.tolerance;
    }

    public boolean isIncludeCollinearPoints() {
        return this.includeCollinearPoints;
    }

    public AbstractConvexHullGenerator2D(boolean z6, double d) {
        this.includeCollinearPoints = z6;
        this.tolerance = d;
    }

    @Override // org.apache.commons.math3.geometry.euclidean.twod.hull.ConvexHullGenerator2D, org.apache.commons.math3.geometry.hull.ConvexHullGenerator
    public ConvexHull2D generate(Collection<Vector2D> collection) {
        MathUtils.checkNotNull(collection);
        if (collection.size() >= 2) {
            collection = findHullVertices(collection);
        }
        try {
            return new ConvexHull2D((Vector2D[]) collection.toArray(new Vector2D[collection.size()]), this.tolerance);
        } catch (MathIllegalArgumentException unused) {
            throw new ConvergenceException();
        }
    }
}
