package pl.umcs.diseasesimulation.aplication.modelingmethods.sir;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SirData {
    public double s, i , r;

    public void addToAll(double value) {
        s += value;
        i += value;
        r += value;
    }
}
