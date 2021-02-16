package pl.umcs.DiseaseSimulation.aplication.recordCreator;

import pl.umcs.DiseaseSimulation.domain.agregate.Simulation;

public class DaysDataHolder
{
    private long[] duringIncubation;
    private long[] infecting;
    private long[] quarantined;
    private long[] infectingWithSymptoms;
    // If people will die during infection
    private long[] quarantinedThatWillDie;
    private long[] infectingThatWillDie;
    //if people will not die
    private long[] waitingForDeath;
    private long[] immune;

    public DaysDataHolder(Simulation simulation, boolean willPeopleDieDuringInfecting)
    {
        duringIncubation = new long[simulation.getIncubationTime()];
        duringIncubation[0] = simulation.getInitialInfectedNumber();
        infecting = new long[simulation.getTimeOfOnsetOfSymptomsFromIncubation()];
        quarantined = new long[simulation.getTimeOfInfect() - simulation.getTimeOfOnsetOfSymptomsFromIncubation()];
        infectingWithSymptoms = new long[simulation.getTimeOfInfect() - simulation.getTimeOfOnsetOfSymptomsFromIncubation()];

        if (willPeopleDieDuringInfecting)
        {
            quarantinedThatWillDie = new long[simulation.getTimeOfDying()];
            infectingThatWillDie = new long[simulation.getTimeOfDying()];
        }
        else
            waitingForDeath = new long[simulation.getDurationOfSymptoms() - simulation.getTimeOfInfect() + simulation.getTimeOfOnsetOfSymptomsFromIncubation() ];

        immune = new long[simulation.getImmunityTime()];
    }

    public long getDuringIncubation(int day) {
        return getDay(day, duringIncubation);
    }

    public void setDuringIncubation(int day, long value)
    {
        setDay(day, duringIncubation, value);
    }

    public long getInfecting(int day) {
        return getDay(day, infecting);
    }

    public void setInfecting(int day, long value) {
        setDay(day, infecting, value);
    }

    public long getQuarantined(int day) {
        return getDay(day, quarantined);
    }

    public void setQuarantined(int day, long value) {
        setDay(day, quarantined, value);
    }

    public long getInfectingWithSymptoms(int day) {
        return getDay(day, infectingWithSymptoms);
    }

    public void setInfectingWithSymptoms(int day, long value) {
        setDay(day, infectingWithSymptoms, value);
    }

    public long getQuarantinedThatWillDie(int day) {
        return getDay(day, quarantinedThatWillDie);
    }

    public void setQuarantinedThatWillDie(int day, long value) {
        setDay(day, quarantinedThatWillDie, value);
    }

    public long getInfectingThatWillDie(int day) {
        return getDay(day, infectingThatWillDie);
    }

    public void setInfectingThatWillDie(int day, long value) {
        setDay(day, infectingThatWillDie, value);
    }

    public long getWaitingForDeath(int day) {
        return getDay(day, waitingForDeath);
    }

    public void setWaitingForDeath(int day, long value) {
        setDay(day, waitingForDeath, value);
    }

    public long getImmune(int day) {
        return getDay(day, immune);
    }

    public void setImmune(int day, long value) {
        setDay(day, immune, value);
    }

    private long getDay(int day, long[] array)
    {
        return array[day % array.length];
    }

    private void setDay(int day, long[] array, long value)
    {
        array[day % array.length] = value;
    }
}
