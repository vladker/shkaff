package org.apache.poi.sl.usermodel;

import java.util.Objects;
import org.apache.poi.sl.draw.DrawPaint;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public abstract class AbstractColorStyle implements ColorStyle {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ColorStyle) {
            return Objects.equals(DrawPaint.applyColorTransform(this), DrawPaint.applyColorTransform((ColorStyle) obj));
        }
        return false;
    }

    public int hashCode() {
        return DrawPaint.applyColorTransform(this).hashCode();
    }
}
