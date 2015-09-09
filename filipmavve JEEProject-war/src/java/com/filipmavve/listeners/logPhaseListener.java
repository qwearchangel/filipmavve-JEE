/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.filipmavve.listeners;

import java.util.Date;
import javax.faces.FactoryFinder;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;

/**
 *
 * @author Filip
 */
public class logPhaseListener {

    public static void registerListener() {
        LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        Lifecycle lifecycle
                = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
        lifecycle.addPhaseListener(new PhaseListener() {

            @Override
            public void afterPhase(PhaseEvent event) {
                System.out.println("AfterPhase id:" + event.getPhaseId() + " at: " + (new Date()).getTime());
            }

            @Override
            public void beforePhase(PhaseEvent event) {
                System.out.println("BeforePhase id:" + event.getPhaseId() + " at: " + (new Date()).getTime());
            }

            @Override
            public PhaseId getPhaseId() {
                return PhaseId.ANY_PHASE;
            }
        });
    }
}
