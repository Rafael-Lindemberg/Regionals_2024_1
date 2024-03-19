// ShooterCommand.java
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class IntakeCommand extends Command {
    private final IntakeSubsystem intake;

    public IntakeCommand(IntakeSubsystem intakeSubsystem) {
        intake = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
       
        intake.intake(1); 
    }

    @Override
    public void end(boolean interrupted) {
        // Stop shooter motors when command ends
        intake.stop();
    }
}
