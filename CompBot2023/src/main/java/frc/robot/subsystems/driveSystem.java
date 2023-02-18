// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveSystem extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public CANSparkMax leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless);
    public CANSparkMax leftRearMotor = new CANSparkMax(2, MotorType.kBrushless);
    public CANSparkMax rightFrontMotor = new CANSparkMax(3, MotorType.kBrushless);
    public CANSparkMax rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);
  
    MotorControllerGroup leftSide = new MotorControllerGroup(leftFrontMotor, leftRearMotor); 
    MotorControllerGroup rightSide = new MotorControllerGroup(rightFrontMotor, rightRearMotor);
  
    DifferentialDrive differentialDrive = new DifferentialDrive(leftSide, rightSide);

    XboxController xboxController = RobotContainer.getInstance().getXboxController();

    double forwardSpeed;
    double rotationSpeed;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveSystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftFrontMotor.restoreFactoryDefaults();
        leftRearMotor.restoreFactoryDefaults();
        rightFrontMotor.restoreFactoryDefaults();
        rightFrontMotor.restoreFactoryDefaults();

        leftSide.setInverted(true);
        rightSide.setInverted(false);

        leftRearMotor.follow(leftFrontMotor);
        rightRearMotor.follow(rightFrontMotor);

        differentialDrive.setMaxOutput(0.2);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    public void drive(double forwardSpeed, double rotationSpeed) {
        differentialDrive.arcadeDrive(forwardSpeed, rotationSpeed);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

