package com.theirrationalengineers.robot.commands;

import com.theirrationalengineers.robot.Constants.ArmConstants;
import com.theirrationalengineers.robot.Constants.DrivetrainConstants;
import com.theirrationalengineers.robot.subsystems.ArmSubsystem;
import com.theirrationalengineers.robot.subsystems.DrivetrainSubsystem;
import com.theirrationalengineers.robot.subsystems.IntakeSubsystem;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoScoreCommand extends SequentialCommandGroup {
    public AutoScoreCommand(ArmSubsystem arm, DrivetrainSubsystem drivetrain, IntakeSubsystem intake) {
        addCommands(
            new MoveArmCommand(ArmConstants.LOW_GOAL, arm),
            new InstantCommand(intake::open, intake),
            Commands.waitSeconds(3.0),
            new MoveArmCommand(ArmConstants.OFFSET, arm),
            new DriveDistanceCommand(-DrivetrainConstants.LEAVE_COMMUNITY_INCHES, drivetrain)
        );
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
}
