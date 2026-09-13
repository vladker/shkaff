package org.apache.commons.math3.ml.neuralnet.twod.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.ml.neuralnet.Neuron;
import org.apache.commons.math3.ml.neuralnet.twod.NeuronSquareMesh2D;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class LocationFinder {
    private final Map<Long, Location> locations = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class Location {
        private final int column;
        private final int row;

        public Location(int i5, int i6) {
            this.row = i5;
            this.column = i6;
        }

        public int getColumn() {
            return this.column;
        }

        public int getRow() {
            return this.row;
        }
    }

    public LocationFinder(NeuronSquareMesh2D neuronSquareMesh2D) {
        int numberOfRows = neuronSquareMesh2D.getNumberOfRows();
        int numberOfColumns = neuronSquareMesh2D.getNumberOfColumns();
        for (int i5 = 0; i5 < numberOfRows; i5++) {
            for (int i6 = 0; i6 < numberOfColumns; i6++) {
                Long lValueOf = Long.valueOf(neuronSquareMesh2D.getNeuron(i5, i6).getIdentifier());
                if (this.locations.get(lValueOf) != null) {
                    throw new MathIllegalStateException();
                }
                this.locations.put(lValueOf, new Location(i5, i6));
            }
        }
    }

    public Location getLocation(Neuron neuron) {
        return this.locations.get(Long.valueOf(neuron.getIdentifier()));
    }
}
