package org.apache.poi.ss.usermodel;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CellCopyPolicy {
    public static final boolean DEFAULT_CONDENSE_ROWS_POLICY = false;
    public static final boolean DEFAULT_COPY_CELL_FORMULA_POLICY = true;
    public static final boolean DEFAULT_COPY_CELL_STYLE_POLICY = true;
    public static final boolean DEFAULT_COPY_CELL_VALUE_POLICY = true;
    public static final boolean DEFAULT_COPY_HYPERLINK_POLICY = true;
    public static final boolean DEFAULT_COPY_MERGED_REGIONS_POLICY = true;
    public static final boolean DEFAULT_COPY_ROW_HEIGHT_POLICY = true;
    public static final boolean DEFAULT_MERGE_HYPERLINK_POLICY = false;
    private boolean condenseRows;
    private boolean copyCellFormula;
    private boolean copyCellStyle;
    private boolean copyCellValue;
    private boolean copyHyperlink;
    private boolean copyMergedRegions;
    private boolean copyRowHeight;
    private boolean mergeHyperlink;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Builder {
        private boolean copyCellValue = true;
        private boolean copyCellStyle = true;
        private boolean copyCellFormula = true;
        private boolean copyHyperlink = true;
        private boolean mergeHyperlink = false;
        private boolean copyRowHeight = true;
        private boolean condenseRows = false;
        private boolean copyMergedRegions = true;

        public CellCopyPolicy build() {
            return new CellCopyPolicy(this);
        }

        public Builder cellFormula(boolean z6) {
            this.copyCellFormula = z6;
            return this;
        }

        public Builder cellStyle(boolean z6) {
            this.copyCellStyle = z6;
            return this;
        }

        public Builder cellValue(boolean z6) {
            this.copyCellValue = z6;
            return this;
        }

        public Builder condenseRows(boolean z6) {
            this.condenseRows = z6;
            return this;
        }

        public Builder copyHyperlink(boolean z6) {
            this.copyHyperlink = z6;
            return this;
        }

        public Builder mergeHyperlink(boolean z6) {
            this.mergeHyperlink = z6;
            return this;
        }

        public Builder mergedRegions(boolean z6) {
            this.copyMergedRegions = z6;
            return this;
        }

        public Builder rowHeight(boolean z6) {
            this.copyRowHeight = z6;
            return this;
        }
    }

    public Builder createBuilder() {
        return new Builder().cellValue(this.copyCellValue).cellStyle(this.copyCellStyle).cellFormula(this.copyCellFormula).copyHyperlink(this.copyHyperlink).mergeHyperlink(this.mergeHyperlink).rowHeight(this.copyRowHeight).condenseRows(this.condenseRows).mergedRegions(this.copyMergedRegions);
    }

    public boolean isCondenseRows() {
        return this.condenseRows;
    }

    public boolean isCopyCellFormula() {
        return this.copyCellFormula;
    }

    public boolean isCopyCellStyle() {
        return this.copyCellStyle;
    }

    public boolean isCopyCellValue() {
        return this.copyCellValue;
    }

    public boolean isCopyHyperlink() {
        return this.copyHyperlink;
    }

    public boolean isCopyMergedRegions() {
        return this.copyMergedRegions;
    }

    public boolean isCopyRowHeight() {
        return this.copyRowHeight;
    }

    public boolean isMergeHyperlink() {
        return this.mergeHyperlink;
    }

    public void setCondenseRows(boolean z6) {
        this.condenseRows = z6;
    }

    public void setCopyCellFormula(boolean z6) {
        this.copyCellFormula = z6;
    }

    public void setCopyCellStyle(boolean z6) {
        this.copyCellStyle = z6;
    }

    public void setCopyCellValue(boolean z6) {
        this.copyCellValue = z6;
    }

    public void setCopyHyperlink(boolean z6) {
        this.copyHyperlink = z6;
    }

    public void setCopyMergedRegions(boolean z6) {
        this.copyMergedRegions = z6;
    }

    public void setCopyRowHeight(boolean z6) {
        this.copyRowHeight = z6;
    }

    public void setMergeHyperlink(boolean z6) {
        this.mergeHyperlink = z6;
    }

    public CellCopyPolicy() {
        this.copyCellValue = true;
        this.copyCellStyle = true;
        this.copyCellFormula = true;
        this.copyHyperlink = true;
        this.mergeHyperlink = false;
        this.copyRowHeight = true;
        this.condenseRows = false;
        this.copyMergedRegions = true;
    }

    public CellCopyPolicy(CellCopyPolicy cellCopyPolicy) {
        this.copyCellValue = true;
        this.copyCellStyle = true;
        this.copyCellFormula = true;
        this.copyHyperlink = true;
        this.mergeHyperlink = false;
        this.copyRowHeight = true;
        this.condenseRows = false;
        this.copyMergedRegions = true;
        this.copyCellValue = cellCopyPolicy.isCopyCellValue();
        this.copyCellStyle = cellCopyPolicy.isCopyCellStyle();
        this.copyCellFormula = cellCopyPolicy.isCopyCellFormula();
        this.copyHyperlink = cellCopyPolicy.isCopyHyperlink();
        this.mergeHyperlink = cellCopyPolicy.isMergeHyperlink();
        this.copyRowHeight = cellCopyPolicy.isCopyRowHeight();
        this.condenseRows = cellCopyPolicy.isCondenseRows();
        this.copyMergedRegions = cellCopyPolicy.isCopyMergedRegions();
    }

    private CellCopyPolicy(Builder builder) {
        this.copyCellValue = true;
        this.copyCellStyle = true;
        this.copyCellFormula = true;
        this.copyHyperlink = true;
        this.mergeHyperlink = false;
        this.copyRowHeight = true;
        this.condenseRows = false;
        this.copyMergedRegions = true;
        this.copyCellValue = builder.copyCellValue;
        this.copyCellStyle = builder.copyCellStyle;
        this.copyCellFormula = builder.copyCellFormula;
        this.copyHyperlink = builder.copyHyperlink;
        this.mergeHyperlink = builder.mergeHyperlink;
        this.copyRowHeight = builder.copyRowHeight;
        this.condenseRows = builder.condenseRows;
        this.copyMergedRegions = builder.copyMergedRegions;
    }
}
