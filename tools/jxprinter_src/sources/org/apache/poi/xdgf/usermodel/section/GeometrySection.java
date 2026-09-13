package org.apache.poi.xdgf.usermodel.section;

import com.microsoft.schemas.office.visio.x2012.main.RowType;
import com.microsoft.schemas.office.visio.x2012.main.SectionType;
import java.awt.geom.Path2D;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.util.Internal;
import org.apache.poi.xdgf.geom.SplineCollector;
import org.apache.poi.xdgf.usermodel.XDGFCell;
import org.apache.poi.xdgf.usermodel.XDGFShape;
import org.apache.poi.xdgf.usermodel.XDGFSheet;
import org.apache.poi.xdgf.usermodel.section.geometry.Ellipse;
import org.apache.poi.xdgf.usermodel.section.geometry.GeometryRow;
import org.apache.poi.xdgf.usermodel.section.geometry.InfiniteLine;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineKnot;
import org.apache.poi.xdgf.usermodel.section.geometry.SplineStart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class GeometrySection extends XDGFSection {
    GeometrySection _master;
    SortedMap<Long, GeometryRow> _rows;

    public GeometrySection(SectionType sectionType, XDGFSheet xDGFSheet) {
        super(sectionType, xDGFSheet);
        this._rows = new TreeMap();
        for (RowType rowType : sectionType.getRowArray()) {
            if (this._rows.containsKey(Long.valueOf(rowType.getIX()))) {
                throw new POIXMLException("Index element '" + rowType.getIX() + "' already exists");
            }
            this._rows.put(Long.valueOf(rowType.getIX()), GeometryRowTypes.load(rowType));
        }
    }

    @Internal
    public static <T, S extends SortedMap<Long, T>> Collection<T> combineGeometries(S s6, S s7) {
        if (s7 != null) {
            TreeMap treeMap = new TreeMap((SortedMap) s7);
            treeMap.putAll(s6);
            s6 = treeMap;
        }
        return s6.values();
    }

    public Iterable<GeometryRow> getCombinedRows() {
        SortedMap<Long, GeometryRow> sortedMap = this._rows;
        GeometrySection geometrySection = this._master;
        return combineGeometries(sortedMap, geometrySection == null ? null : geometrySection._rows);
    }

    public Boolean getNoShow() {
        Boolean boolMaybeGetBoolean = XDGFCell.maybeGetBoolean(this._cells, "NoShow");
        if (boolMaybeGetBoolean != null) {
            return boolMaybeGetBoolean;
        }
        GeometrySection geometrySection = this._master;
        return geometrySection != null ? geometrySection.getNoShow() : Boolean.FALSE;
    }

    public Path2D.Double getPath(XDGFShape xDGFShape) {
        GeometryRow geometryRow;
        Iterator<GeometryRow> it = getCombinedRows().iterator();
        GeometryRow next = it.hasNext() ? it.next() : null;
        if (next instanceof Ellipse) {
            return ((Ellipse) next).getPath();
        }
        if (next instanceof InfiniteLine) {
            return ((InfiniteLine) next).getPath();
        }
        if (next instanceof SplineStart) {
            throw new POIXMLException("SplineStart must be preceded by another type");
        }
        Path2D.Double r6 = new Path2D.Double();
        SplineCollector splineCollector = null;
        while (true) {
            if (next != null) {
                geometryRow = null;
            } else {
                if (!it.hasNext()) {
                    if (splineCollector != null) {
                        splineCollector.addToPath(r6, xDGFShape);
                    }
                    return r6;
                }
                geometryRow = next;
                next = it.next();
            }
            if (next instanceof SplineStart) {
                if (splineCollector != null) {
                    throw new POIXMLException("SplineStart found multiple times!");
                }
                splineCollector = new SplineCollector((SplineStart) next);
            } else if (!(next instanceof SplineKnot)) {
                if (splineCollector != null) {
                    splineCollector.addToPath(r6, xDGFShape);
                    splineCollector = null;
                }
                next.addToPath(r6, xDGFShape);
            } else {
                if (splineCollector == null) {
                    throw new POIXMLException("SplineKnot found without SplineStart!");
                }
                splineCollector.addKnot((SplineKnot) next);
            }
            next = geometryRow;
        }
    }

    @Override // org.apache.poi.xdgf.usermodel.section.XDGFSection
    public void setupMaster(XDGFSection xDGFSection) {
        this._master = (GeometrySection) xDGFSection;
        for (Map.Entry<Long, GeometryRow> entry : this._rows.entrySet()) {
            GeometryRow geometryRow = this._master._rows.get(entry.getKey());
            if (geometryRow != null) {
                try {
                    entry.getValue().setupMaster(geometryRow);
                } catch (ClassCastException unused) {
                }
            }
        }
    }
}
