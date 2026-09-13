package org.apache.poi.sl.draw.geom;

import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.poi.sl.usermodel.PaintStyle;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class Path implements PathIf {
    private final List<PathCommand> commands = new ArrayList();
    private PaintStyle.PaintModifier fill = PaintStyle.PaintModifier.NORM;
    private boolean stroke = true;
    private boolean extrusionOk = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f7177w = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f7176h = -1;

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void addCommand(PathCommand pathCommand) {
        this.commands.add(pathCommand);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Path)) {
            return false;
        }
        Path path = (Path) obj;
        return Objects.equals(this.commands, path.commands) && Long.valueOf(this.f7177w).equals(Long.valueOf(path.f7177w)) && Long.valueOf(this.f7176h).equals(Long.valueOf(path.f7176h)) && this.fill == path.fill && Boolean.valueOf(this.stroke).equals(Boolean.valueOf(path.stroke)) && Boolean.valueOf(this.extrusionOk).equals(Boolean.valueOf(path.extrusionOk));
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public PaintStyle.PaintModifier getFill() {
        return this.fill;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public long getH() {
        return this.f7176h;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public Path2D.Double getPath(Context context) {
        Path2D.Double r6 = new Path2D.Double();
        Iterator<PathCommand> it = this.commands.iterator();
        while (it.hasNext()) {
            it.next().execute(r6, context);
        }
        return r6;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public long getW() {
        return this.f7177w;
    }

    public int hashCode() {
        return Objects.hash(this.commands, Long.valueOf(this.f7177w), Long.valueOf(this.f7176h), Integer.valueOf(this.fill.ordinal()), Boolean.valueOf(this.stroke), Boolean.valueOf(this.extrusionOk));
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public boolean isExtrusionOk() {
        return this.extrusionOk;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public boolean isFilled() {
        return this.fill != PaintStyle.PaintModifier.NONE;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public boolean isStroked() {
        return this.stroke;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setExtrusionOk(boolean z6) {
        this.extrusionOk = z6;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setFill(PaintStyle.PaintModifier paintModifier) {
        this.fill = paintModifier;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setH(long j6) {
        this.f7176h = j6;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setStroke(boolean z6) {
        this.stroke = z6;
    }

    @Override // org.apache.poi.sl.draw.geom.PathIf
    public void setW(long j6) {
        this.f7177w = j6;
    }
}
