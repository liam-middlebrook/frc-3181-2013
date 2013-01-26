/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pittsfordrobotics.yr2013;
import com.sun.squawk.microedition.io.FileConnection;
import edu.wpi.first.wpilibj.Preferences;
import java.io.DataOutputStream;
import java.util.Date;
import javax.microedition.io.Connector;
/**
 *
 * @author robbiemarkwick
 */
public class Logging {
    static String logString="<?xml version=\"1.0\"?>\n<log>\n";
    public static void init(){
	logString="<?xml version=\"1.0\"?>\n<log>\n";
    }
    /**
     * Adds stuff to log files
     * @param items
     * @param ControlScheme 
     */
    public static void logItems(Loggable items[],boolean controlScheme,boolean autonomous){
	logString.concat("<mainThread>\n");
	if(controlScheme)logString.concat(ControlScheme.logString(autonomous));
	for(int i=0;i<items.length;i++){
	    logString.concat(items[i].logString());
	}
	logString.concat("</mainThread>\n");
    }
    public static void export(){
	logString.concat("</log>");
	try{
	    String logFilePath="./RobotLogs/";
	    logFilePath=logFilePath.concat(Preferences.getInstance().getString("DriverName","ANONYMOUSDRIVER")+"/");
	    logFilePath=logFilePath.concat((new Date()).toString()+".xml");
	   /* FileConnection fc = (FileConnection)Connector.open(logFilePath, Connector.WRITE);
	    fc.create(); 
	    DataOutputStream theFile = fc.openDataOutputStream();
	    theFile*/
	    Connector.openDataOutputStream(logFilePath).writeChars(logString);
	}
	catch(Exception e){
	    //Do something
	}
    }
}
