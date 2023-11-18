package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name = "Elevator_Shruthi", group = "Linear OpMode")
public class Elevator_Shruthi extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor Elevator_left = null;
    private DcMotor Elevator_right = null;
    @Override
    public void runOpMode() {
        Elevator_left = hardwareMap.get(DcMotor.class, "left Front");
        Elevator_right = hardwareMap.get(DcMotor.class, "right Front");

        Elevator_left.setDirection(DcMotor.Direction.REVERSE);
        Elevator_right.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();
        while (opModeIsActive()) {
            boolean counter = false;
            if (gamepad1.a) {
                counter=true;
                Elevator_left.setPower(0.8);
                Elevator_right.setPower(0.8);
            }
            if (counter=true && gamepad1.a) {
                Elevator_left.setPower(-0.8);
                Elevator_right.setPower(-0.8);
                counter=false;
            }
        }
    }
}

