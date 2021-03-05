package pl.umcs.diseasesimulation.aplication.modelingmethods.seirds;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SeirdsData {
    public double s, e, i, r, d;

    public void addToAll(double value) {
        s += value;
        e += value;
        i += value;
        r += value;
        d += value;
    }
}
