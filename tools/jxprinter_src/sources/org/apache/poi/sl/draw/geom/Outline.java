package org.apache.poi.sl.draw.geom;

import java.awt.Shape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Outline {
    private final PathIf path;
    private final Shape shape;

    public Outline(Shape shape, PathIf pathIf) {
        this.shape = shape;
        this.path = pathIf;
    }

    public Shape getOutline() {
        return this.shape;
    }

    public PathIf getPath() {
        return this.path;
    }
}
