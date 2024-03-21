// ShooterCommand.java
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class AmpShooterTwo extends Command {
    private final ShooterSubsystem shooter;

    public AmpShooterTwo(ShooterSubsystem shooterSubsystem) {
        shooter = shooterSubsystem;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
       
        shooter.shoot(0.3); 
    }

    @Override
    public void end(boolean interrupted) {
        shooter.stop();
    }
}
