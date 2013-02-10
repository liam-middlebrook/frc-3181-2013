/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.pittsfordrobotics.yr2013;


import edu.wpi.first.wpilibj.*;

/**
 *  @author LiamMiddlebrook
 */
public class Data extends IterativeRobot {
	DriveSystem robotDrive = new DriveSystem(Hardware.driveJoystick,Hardware.auxJoystick,Hardware.frontRightJaguar,Hardware.frontLeftJaguar,Hardware.backRightJaguar,Hardware.backLeftJaguar);
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit() {
        robotDrive.start();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
