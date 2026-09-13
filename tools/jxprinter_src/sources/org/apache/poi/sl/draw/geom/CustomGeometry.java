package org.apache.poi.sl.draw.geom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Spliterator;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class CustomGeometry implements Iterable<PathIf> {
    Path textBounds;
    final List<AdjustValueIf> adjusts = new ArrayList();
    final List<GuideIf> guides = new ArrayList();
    final List<PathIf> paths = new ArrayList();
    final List<AdjustHandle> handles = new ArrayList();
    final List<ConnectionSiteIf> connections = new ArrayList();

    private static LineToCommand lineTo(String str, String str2) {
        AdjustPoint adjustPoint = new AdjustPoint();
        adjustPoint.setX(str);
        adjustPoint.setY(str2);
        LineToCommand lineToCommand = new LineToCommand();
        lineToCommand.setPt(adjustPoint);
        return lineToCommand;
    }

    private static MoveToCommand moveTo(String str, String str2) {
        AdjustPoint adjustPoint = new AdjustPoint();
        adjustPoint.setX(str);
        adjustPoint.setY(str2);
        MoveToCommand moveToCommand = new MoveToCommand();
        moveToCommand.setPt(adjustPoint);
        return moveToCommand;
    }

    public void addAdjustGuide(AdjustValueIf adjustValueIf) {
        this.adjusts.add(adjustValueIf);
    }

    public void addAdjustHandle(AdjustHandle adjustHandle) {
        this.handles.add(adjustHandle);
    }

    public void addConnectionSite(ConnectionSiteIf connectionSiteIf) {
        this.connections.add(connectionSiteIf);
    }

    public void addGeomGuide(GuideIf guideIf) {
        this.guides.add(guideIf);
    }

    public void addPath(PathIf pathIf) {
        this.paths.add(pathIf);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomGeometry)) {
            return false;
        }
        CustomGeometry customGeometry = (CustomGeometry) obj;
        return Objects.equals(this.adjusts, customGeometry.adjusts) && Objects.equals(this.guides, customGeometry.guides) && Objects.equals(this.handles, customGeometry.handles) && Objects.equals(this.connections, customGeometry.connections) && Objects.equals(this.textBounds, customGeometry.textBounds) && Objects.equals(this.paths, customGeometry.paths);
    }

    public Path getTextBounds() {
        return this.textBounds;
    }

    public int hashCode() {
        return Objects.hash(this.adjusts, this.guides, this.handles, this.connections, this.textBounds, this.paths);
    }

    @Override // java.lang.Iterable
    public Iterator<PathIf> iterator() {
        return this.paths.iterator();
    }

    public void setTextBounds(String str, String str2, String str3, String str4) {
        Path path = new Path();
        this.textBounds = path;
        path.addCommand(moveTo(str, str2));
        this.textBounds.addCommand(lineTo(str3, str2));
        this.textBounds.addCommand(lineTo(str3, str4));
        this.textBounds.addCommand(lineTo(str, str4));
        this.textBounds.addCommand(new ClosePathCommand());
    }

    @Override // java.lang.Iterable
    public Spliterator<PathIf> spliterator() {
        return this.paths.spliterator();
    }
}
