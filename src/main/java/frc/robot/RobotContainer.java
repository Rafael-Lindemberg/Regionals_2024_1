// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.*;
import frc.robot.commands.climber.ClimberDown;
import frc.robot.commands.climber.ClimberUp;
import frc.robot.commands.drivetrain.NorthUntilInterupt;
import frc.robot.subsystems.*;
import frc.team1891.common.control.AxisTrigger;
import frc.team1891.common.control.POVTrigger;
import frc.team1891.common.control.POVTrigger.POV;
import frc.team1891.common.logger.BullLogger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Subsystems
  private final DriveTrain m_DriveTrain = DriveTrain.getInstance();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem();
  private final ClimberSubsystem m_ClimberSubsystem = new ClimberSubsystem();
  // public final Intake m_intake = Intake.getInstance();
  // public final GrabbyArm m_arm = GrabbyArm.getInstance();
  // public final Conveyer m_conveyer = Conveyer.getInstance();
  // public final Grabber m_Grabber = Grabber.getInstance();
  // public final PneumaticHub m_Hub = new PneumaticHub();

  // public final MatrixLEDs m_LEDSystem = MatrixLEDs.getInstance();

  // private static final Compressor m_compressor = new Compressor(PneumaticsModuleType.REVPH);

  // This is big bad, but I'm lazy -stephen
  // public static Compressor getCompressor() {
  //   return m_compressor;
  // }
    
  public static boolean scoringForCubes = false;
  public static double setAngle = 0;
  //private final AbsoluteAngleJoystickDrive m_absoluteDrive = new AbsoluteAngleJoystickDrive(m_DriveTrain, null, null, null);

  BullLogger logger = new BullLogger("Main log", false, false);
  // Replace with CommandPS4Controller or CommandJoystick if needed

  // public static final XboxController m_driverController =
  //   new XboxController(OperatorConstants.kDriverControllerPort) {
  //     public double getRawAxis(int axis) {
  //       return MathUtil.applyDeadband(super.getRawAxis(axis), .15);
  //     };
  // };
  private final Joystick m_Joystick = new Joystick(1);
  public static final XboxController m_driverController = new XboxController(0);
  private final Joystick m_coBox = new Joystick(2);

  // This is big bad, but I'm lazy -stephen
  public static XboxController getController() {
    return m_driverController;
  }
  private JoystickButton m_FaceForward = new JoystickButton(m_Joystick, XboxController.Button.kLeftStick.value);
  private JoystickButton m_xwheels = new JoystickButton(m_Joystick, XboxController.Button.kStart.value);
  private AxisTrigger m_rightStickTrig = new AxisTrigger(m_Joystick, XboxController.Axis.kRightX.value,.13);
  private POVTrigger m_POVNorth = new POVTrigger(m_Joystick, POV.NORTH);
  private JoystickButton m_CoGrab = new JoystickButton(m_coBox, 3);
  // belt back and forth
  // grab and drop

    // DEMO BUTTON
    String number_image = "";
  //private JoystickButton m_autopilotToCommunity = new JoystickButton(m_coBox, 1);
  public void periodic() {
    // SmartDashboard.putNumber("Tank Pressure", m_Hub.getPressure(0));
    // int seconds = (int)DriverStation.getMatchTime();
    // if(seconds <= 30 && seconds > 0 && DriverStation.isTeleop()){
    //   if(number_image != String.format("number_%d.png", seconds)){
    // //    new RunMatrixImageCommand(m_LEDSystem, YamlLoader.getImage(String.format("number_%d.png", seconds))).schedule();
    //     number_image = String.format("number_%d.png", seconds);
    //   }
      
    // }else if(seconds <= 0 && !firstLogo.isScheduled() && DriverStation.isEnabled() && DriverStation.isDSAttached() && !CommandScheduler.getInstance().isScheduled(lowBattery)) {
    //   firstLogo.schedule();
    // }
    //System.out.println("matchTime: " + seconds);

    // if(!DriverStation.isDSAttached()){
    //   if(!CommandScheduler.getInstance().isScheduled(offlineCommand)){
    //     offlineCommand.schedule();
    //   }
    // } else if (RobotController.getBatteryVoltage() < 8) {
    //   if (!CommandScheduler.getInstance().isScheduled(lowBattery)) {
    //     lowBattery.schedule();
    //   }
    // } else{
    //   if(CommandScheduler.getInstance().isScheduled(offlineCommand)){
    //     firstLogo.schedule();
    //   }
    // }
  }
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Autos.load();

    // offlineCommand = new RunMatrixVideoCommand(m_LEDSystem, YamlLoader.getVideo("offline"), 10, RunType.CONTINUOUS);
    // firstLogo = new RunMatrixVideoCommand(m_LEDSystem, YamlLoader.getVideo("first_pixels"),5,RunType.CONTINUOUS);
    // lowBattery = new RunMatrixVideoCommand(m_LEDSystem, YamlLoader.getVideo(("batterylow")), 20, RunType.CONTINUOUS);
    //offlineBack = new RunMatrixVideoCommand(m_LEDSystemBack, YamlLoader.getVideo("offline"), 10, RunType.CONTINUOUS);
    //m_absoluteAngleDrive = new AbsoluteAngleJoystickDrive(m_DriveTrain, m_driverController.getLeftY(), null, null);
    // Configure the trigger bindings
    configureBindings();
    
    m_DriveTrain.setDefaultCommand(
        new RunCommand(
            () -> {
                m_Joystick.setRumble(RumbleType.kBothRumble, 0.0);
                final double DEADBAND = .4;
                double x = m_Joystick.getRawAxis(0);
                double y = m_Joystick.getRawAxis(1);
                double z = m_Joystick.getRawAxis(5);
                if (Math.abs(x) > DEADBAND) {
                  y = MathUtil.applyDeadband(y, DEADBAND*.6);
                } else {
                  y = MathUtil.applyDeadband(y, DEADBAND);
                }
                 if (Math.abs(y) > DEADBAND) {
                  x = MathUtil.applyDeadband(x, DEADBAND*.6);
                } else {
                  x = MathUtil.applyDeadband(x, DEADBAND);
                }
                z = MathUtil.applyDeadband(z, DEADBAND);

                

                if (m_Joystick.getRawButton(15)){
                  m_DriveTrain.holonomicDrive(-y,-x,z/2,true);         
              } else if (!m_Joystick.getRawButton(15)){
                  m_DriveTrain.holonomicDrive(-y,-x,z,true);         
              }
              
            }, m_DriveTrain));
    // if(DriverStation.isDSAttached()) {
    //   firstLogo.schedule();
    // }
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    double r2Threshold = 0.5;
    double l2Threshold = 0.5;

    AxisTrigger r2AxisTrigger = new AxisTrigger(m_driverController, XboxController.Axis.kRightTrigger.value, r2Threshold);
    r2AxisTrigger.whileTrue(new ShooterCommand(m_ShooterSubsystem));
    
    AxisTrigger l2AxisTrigger = new AxisTrigger(m_driverController, XboxController.Axis.kLeftTrigger.value, l2Threshold );
    l2AxisTrigger.whileTrue(new IntakeCommand(m_IntakeSubsystem));

    m_FaceForward.onTrue(new NorthUntilInterupt(m_DriveTrain,()-> m_Joystick.getRawAxis(0),() -> m_Joystick.getRawAxis(1),() -> m_rightStickTrig.getAsBoolean()));

   
    JoystickButton r1Button = new JoystickButton(m_driverController, 6);
    r1Button.whileTrue(new ClimberDown(m_ClimberSubsystem));

    JoystickButton l1Button = new JoystickButton(m_driverController, 5);
    l1Button.whileTrue(new ClimberUp(m_ClimberSubsystem));

    JoystickButton triangle = new JoystickButton(m_driverController, 4);
    triangle.whileTrue(new AmpShooter(m_ShooterSubsystem));
    
    JoystickButton circle = new JoystickButton(m_driverController, 2);
    circle.whileTrue(new AmpShooterTwo(m_ShooterSubsystem));

    JoystickButton x = new JoystickButton(m_driverController, 1);
    x.whileTrue(new AmpShooterThree(m_ShooterSubsystem));

    JoystickButton square = new JoystickButton(m_driverController, 3);
    square.whileTrue(new AmpShooterFour(m_ShooterSubsystem));

    m_FaceForward.onTrue(new NorthUntilInterupt(m_DriveTrain,()-> m_driverController.getLeftX(),() -> m_driverController.getLeftY(),() -> m_rightStickTrig.getAsBoolean()));

   

    
    //m_alignToPlaceButton.onTrue(new DriveToPose(m_DriveTrain, ()-> m_DriveTrain.pickConeScoringArea().getPose2d(), () -> m_leftrightTrigger.or(m_forwardBack.or(m_rightStickTrig)).getAsBoolean()));
      //m_alignToPlaceButton.onTrue(new ConditionalCommand(
      //new DriveToPose(m_DriveTrain, ()-> m_DriveTrain.pickCubeScoringArea().getPose2d(), () -> m_leftrightTrigger.or(m_forwardBack.or(m_rightStickTrig)).getAsBoolean()),
      //new DriveToPose(m_DriveTrain, ()-> m_DriveTrain.pickConeScoringArea().getPose2d(), () -> m_leftrightTrigger.or(m_forwardBack.or(m_rightStickTrig)).getAsBoolean()),
      //()-> scoringForCubes));

    m_POVNorth.onTrue(
      new InstantCommand(
            () ->
            {
              if(Robot.isRedAlliance()){
                m_DriveTrain.resetAngle(180);
              }else{
                m_DriveTrain.resetAngle(0);
              }
            },
                m_DriveTrain));


    m_xwheels.onTrue(
      new RunCommand(
        ()->{
          m_DriveTrain.moduleXConfiguration();
        }, m_DriveTrain)
        .withTimeout(2)
    );
    m_CoGrab.onTrue(new ButtonPress("pressed"));
    m_CoGrab.onFalse(new ButtonPress("not pressed"));
    
    SmartDashboard.putData("set to 90", new InstantCommand(){
      @Override
      public void initialize() {
        setAngle = 90;
      }
    });
    SmartDashboard.putData("set to 0", new InstantCommand(){
      @Override
      public void initialize() {
        setAngle = 30;
      }
    });
  
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    return Autos.getSelected();
  }
}
