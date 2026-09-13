package org.apache.commons.math3.geometry.enclosing;

import androidx.exifinterface.media.a;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class WelzlEncloser<S extends Space, P extends Point<S>> implements Encloser<S, P> {
    private final SupportBallGenerator<S, P> generator;
    private final double tolerance;

    public WelzlEncloser(double d, SupportBallGenerator<S, P> supportBallGenerator) {
        this.tolerance = d;
        this.generator = supportBallGenerator;
    }

    private EnclosingBall<S, P> moveToFrontBall(List<P> list, int i5, List<P> list2) {
        EnclosingBall<S, P> enclosingBallBallOnSupport = this.generator.ballOnSupport(list2);
        if (enclosingBallBallOnSupport.getSupportSize() <= enclosingBallBallOnSupport.getCenter().getSpace().getDimension()) {
            for (int i6 = 0; i6 < i5; i6++) {
                P p6 = list.get(i6);
                if (!enclosingBallBallOnSupport.contains(p6, this.tolerance)) {
                    list2.add(p6);
                    enclosingBallBallOnSupport = moveToFrontBall(list, i6, list2);
                    a.w(1, list2);
                    for (int i7 = i6; i7 > 0; i7--) {
                        list.set(i7, list.get(i7 - 1));
                    }
                    list.set(0, p6);
                }
            }
        }
        return enclosingBallBallOnSupport;
    }

    private EnclosingBall<S, P> pivotingBall(Iterable<P> iterable) {
        P next = iterable.iterator().next();
        ArrayList arrayList = new ArrayList(next.getSpace().getDimension() + 1);
        ArrayList arrayList2 = new ArrayList(next.getSpace().getDimension() + 1);
        arrayList.add(next);
        EnclosingBall<S, P> enclosingBallMoveToFrontBall = moveToFrontBall(arrayList, arrayList.size(), arrayList2);
        while (true) {
            Point pointSelectFarthest = selectFarthest(iterable, enclosingBallMoveToFrontBall);
            if (enclosingBallMoveToFrontBall.contains(pointSelectFarthest, this.tolerance)) {
                return enclosingBallMoveToFrontBall;
            }
            arrayList2.clear();
            arrayList2.add(pointSelectFarthest);
            EnclosingBall<S, P> enclosingBallMoveToFrontBall2 = moveToFrontBall(arrayList, arrayList.size(), arrayList2);
            if (enclosingBallMoveToFrontBall2.getRadius() < enclosingBallMoveToFrontBall.getRadius()) {
                throw new MathInternalError();
            }
            arrayList.add(0, pointSelectFarthest);
            arrayList.subList(enclosingBallMoveToFrontBall2.getSupportSize(), arrayList.size()).clear();
            enclosingBallMoveToFrontBall = enclosingBallMoveToFrontBall2;
        }
    }

    @Override // org.apache.commons.math3.geometry.enclosing.Encloser
    public EnclosingBall<S, P> enclose(Iterable<P> iterable) {
        return (iterable == null || !iterable.iterator().hasNext()) ? this.generator.ballOnSupport(new ArrayList()) : pivotingBall(iterable);
    }

    public P selectFarthest(Iterable<P> iterable, EnclosingBall<S, P> enclosingBall) {
        Point<S> center = enclosingBall.getCenter();
        P p6 = null;
        double d = -1.0d;
        for (P p7 : iterable) {
            double dDistance = p7.distance(center);
            if (dDistance > d) {
                p6 = p7;
                d = dDistance;
            }
        }
        return p6;
    }
}
