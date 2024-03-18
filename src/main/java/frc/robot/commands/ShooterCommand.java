// ShooterCommand.java
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends Command {
    private final ShooterSubsystem shooter;

    public ShooterCommand(ShooterSubsystem shooterSubsystem) {
        shooter = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        // Set shooter motor speed (adjust as needed)
        shooter.shoot(0.8); // Example: 80% speed
    }

    @Override
    public void end(boolean interrupted) {
        // Stop shooter motors when command ends
        shooter.stop();
    }
}
