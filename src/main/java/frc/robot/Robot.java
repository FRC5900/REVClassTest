/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  REVDigitBoard myDigiDisplay;
  double counter = 0.0;
  boolean runmode = false;

  @Override
  public void robotInit() {
    myDigiDisplay = new REVDigitBoard();
 
    myDigiDisplay.display("init");
  }

  @Override
  public void robotPeriodic() {

    if ( counter > 99.99 )
      counter = 0.0;
    else
      counter = counter + 0.01;

    if ( runmode == false )  {
      myDigiDisplay.display(counter);
      SmartDashboard.putBoolean("ButtonA", myDigiDisplay.getButtonA());
      SmartDashboard.putBoolean("ButtonB", myDigiDisplay.getButtonB());
      SmartDashboard.putNumber("PotVoltage", myDigiDisplay.getPot());  
    }
  }

  @Override
  public void disabledInit() {
    super.disabledInit();
    runmode = false;
  }

  @Override
  public void autonomousInit() {
    myDigiDisplay.display("auto");
    runmode = true;
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    myDigiDisplay.display("tele");
    runmode = true;
  }

  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    runmode = true;
    myDigiDisplay.display("test");
    counter = 0;
  }

  @Override
  public void testPeriodic() {
   
  }



}
