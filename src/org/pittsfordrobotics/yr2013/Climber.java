/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pittsfordrobotics.yr2013;

import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 * @author robbiemarkwick
 */
public class Climber implements Loggable{
    public Jaguar climber;
    public Jaguar angler;
    Climber (Jaguar climb,Jaguar angle){
        climber=climb;
        angler=angle;
    }
    public void climb(){ 
        if(ControlScheme.getClimbStart()) {
            Utils.ramp(1, angler, Utils.kDefaultTicksPerSecond, Utils.kDefaultRampStepSize);
        }//climb if needed
       else {
            Utils.ramp(0, angler, Utils.kDefaultTicksPerSecond, Utils.kDefaultRampStepSize);
        }//climb if needed
        if(ControlScheme.shouldClimb()) {
           Utils.ramp(1, climber, Utils.kDefaultTicksPerSecond, Utils.kDefaultRampStepSize);
        }//climb if needed
       else {
            Utils.ramp(0, climber, Utils.kDefaultTicksPerSecond, Utils.kDefaultRampStepSize);
        }//climb if needed
    }
    public String logString() {
	String xmlString="<climber>\n";
        xmlString=xmlString.concat("<beginMotor>\n"+
                "<target>"+(ControlScheme.getClimbStart()?1:0)+"</target>\n"+
                "<current>"+angler.get()+"</current>\n"+
                "</beginMotor>\n");
	xmlString=xmlString.concat("<climbMotor>\n"+
                "<target>"+(ControlScheme.shouldClimb()?1:0)+"</target>\n"+
                "<current>"+climber.get()+"</current>\n"+
                "</climbMotor>\n");
        xmlString=xmlString.concat("</climber>");
        return xmlString;
    }
}
