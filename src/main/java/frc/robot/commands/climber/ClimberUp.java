package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.ClimberSubsystem;

public class ClimberUp extends Command {
    private final ClimberSubsystem climber;

    public ClimberUp(ClimberSubsystem climberSubsystem){
        climber = climberSubsystem;
        addRequirements(climberSubsystem);
    }

    @Override
    public void execute(){
        climber.moveUp(0.8);
    }
}
