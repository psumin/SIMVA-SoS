package mci;

import kr.ac.kaist.se.simulator.BaseAction;
import kr.ac.kaist.se.simulator.BaseConstituent;
import kr.ac.kaist.se.simulator.ManagerInterface;

import java.util.ArrayList;

/**
 * Hospital.java
 * Hospital class, this is an SoS manager class

 * Author: Junho Kim <jhkim@se.kaist.ac.kr>

 * The MIT License (MIT)

 * Copyright (c) 2016 Junho Kim

 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions: TBD
 */
public class Hospital extends BaseConstituent implements ManagerInterface {

    public static ArrayList<MapPoint> GeoMap = new ArrayList<>();

    @Override
    public int getSoSLevelBenefit() {
        return 0;
    }

    @Override
    public void addSoSLevelBenefit(int SoSLevelBenefit) {

    }

    /**
     * Normal action of Hospital
     * Heal the patient.
     * This action takes 10 ticks
     * @param elapsedTime
     */
    @Override
    public void normalAction(int elapsedTime) {

    }

    /**
     * Immediate action of Hospital
     * Hospital find the patients who has limited death time. (< 50)
     * @return
     */
    @Override
    public BaseAction immediateAction() {
        for(MapPoint eachMap : Hospital.GeoMap){
            RescueAction rA = eachMap.getCurAction();
            if(rA == null)
                continue;

            if(rA.getRemainTime() < 50){
                rA.addBenefit(10); // Acknowledge
            }

        }
        RescueAction healAction = new RescueAction(50, 10);
        healAction.addPerformer(this);
        healAction.setStatus(BaseAction.Status.HANDLED);
        return healAction;
    }

    @Override
    public BaseConstituent clone() {
        return null;
    }

    @Override
    public BaseAction getCurrentAction() {
        return null;
    }
}
