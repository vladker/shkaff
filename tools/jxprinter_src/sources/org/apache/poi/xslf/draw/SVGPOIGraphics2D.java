package org.apache.poi.xslf.draw;

import java.awt.RenderingHints;
import java.util.Map;
import org.apache.batik.svggen.SVGGeneratorContext;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.poi.util.Internal;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class SVGPOIGraphics2D extends SVGGraphics2D {
    private final RenderingHints hints;

    public SVGPOIGraphics2D(Document document, boolean z6) {
        super(getCtx(document), z6);
        this.hints = getGeneratorContext().getGraphicContextDefaults().getRenderingHints();
        getGeneratorContext().getExtensionHandler().setSvgGraphics2D(this);
    }

    private static SVGGeneratorContext getCtx(Document document) {
        SVGGeneratorContext sVGGeneratorContextCreateDefault = SVGGeneratorContext.createDefault(document);
        sVGGeneratorContextCreateDefault.setExtensionHandler(new SVGRenderExtension());
        SVGGeneratorContext.GraphicContextDefaults graphicContextDefaults = new SVGGeneratorContext.GraphicContextDefaults();
        graphicContextDefaults.setRenderingHints(new RenderingHints((Map) null));
        sVGGeneratorContextCreateDefault.setGraphicContextDefaults(graphicContextDefaults);
        return sVGGeneratorContextCreateDefault;
    }

    public void addRenderingHints(Map map) {
        this.hints.putAll(map);
        super.addRenderingHints(map);
    }

    public void setRenderingHint(RenderingHints.Key key, Object obj) {
        this.hints.put(key, obj);
        super.setRenderingHint(key, obj);
    }

    public void setRenderingHints(Map map) {
        this.hints.clear();
        this.hints.putAll(map);
        super.setRenderingHints(map);
    }
}
