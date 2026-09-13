package org.apache.poi.xslf.draw;

import java.awt.geom.Dimension2D;
import java.awt.geom.Rectangle2D;
import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.bridge.UserAgentAdapter;
import org.apache.batik.bridge.ViewBox;
import org.apache.batik.parser.DefaultLengthHandler;
import org.apache.batik.parser.LengthParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.util.Dimension2DDouble;
import org.apache.poi.util.Internal;
import org.w3c.dom.svg.SVGDocument;
import org.w3c.dom.svg.SVGSVGElement;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class SVGUserAgent extends UserAgentAdapter {
    private static final Logger LOG = LogManager.getLogger((Class<?>) SVGUserAgent.class);
    private Rectangle2D viewbox;

    public SVGUserAgent() {
        addStdFeatures();
    }

    private static float parseLength(SVGSVGElement sVGSVGElement, String str) {
        String attributeNS = sVGSVGElement.getAttributeNS((String) null, str);
        if (attributeNS == null || attributeNS.isEmpty()) {
            return 0.0f;
        }
        final float[] fArr = {0.0f};
        LengthParser lengthParser = new LengthParser();
        lengthParser.setLengthHandler(new DefaultLengthHandler() { // from class: org.apache.poi.xslf.draw.SVGUserAgent.1
            public void lengthValue(float f6) {
                fArr[0] = f6;
            }
        });
        lengthParser.parse(attributeNS);
        return fArr[0];
    }

    public void displayError(String str) {
        LOG.atError().log(str);
    }

    public void displayMessage(String str) {
        LOG.atInfo().log(str);
    }

    public Rectangle2D getViewbox() {
        throw null;
    }

    public Dimension2D getViewportSize() {
        return this.viewbox != null ? new Dimension2DDouble(this.viewbox.getWidth(), this.viewbox.getHeight()) : super.getViewportSize();
    }

    public void initViewbox(SVGDocument sVGDocument) {
        this.viewbox = null;
        SVGSVGElement rootElement = sVGDocument.getRootElement();
        if (rootElement == null) {
            return;
        }
        String attributeNS = rootElement.getAttributeNS((String) null, "viewBox");
        if (attributeNS != null && !attributeNS.isEmpty()) {
            float[] viewBoxAttribute = ViewBox.parseViewBoxAttribute(rootElement, attributeNS, (BridgeContext) null);
            this.viewbox = new Rectangle2D.Float(viewBoxAttribute[0], viewBoxAttribute[1], viewBoxAttribute[2], viewBoxAttribute[3]);
            return;
        }
        float length = parseLength(rootElement, "width");
        float length2 = parseLength(rootElement, "height");
        if (length == 0.0f || length2 == 0.0f) {
            return;
        }
        this.viewbox = new Rectangle2D.Double(0.0d, 0.0d, length, length2);
    }

    public void showAlert(String str) {
        LOG.atWarn().log(str);
    }

    public void displayError(Exception exc) {
        LOG.atError().withThrowable(exc).log(exc.getMessage());
    }
}
