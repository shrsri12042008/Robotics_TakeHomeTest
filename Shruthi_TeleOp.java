
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Shruthi_TeleOp", group = "Linear OpMode")
public class Shruthi_TeleOp extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftfrontDrive = null;
    private DcMotor leftbackDrive = null;
    private DcMotor rightfrontDrive = null;
    private DcMotor rightbackDrive = null;
    @Override
    public void runOpMode() {
        leftfrontDrive = hardwareMap.get(DcMotor.class, "left Front");
        rightfrontDrive = hardwareMap.get(DcMotor.class, "right Front");
        leftbackDrive = hardwareMap.get(DcMotor.class, "left Back");
        rightbackDrive = hardwareMap.get(DcMotor.class, "right Back");

        leftfrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftbackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightfrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightbackDrive.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            double max;
            double axial = -gamepad1.left_stick_y;
            double lateral = gamepad1.left_stick_x;
            double yaw = gamepad1.right_stick_x;
            double leftfrontPower = axial + lateral + yaw;
            double leftbackPower = axial - lateral + yaw;
            double rightfrontPower = axial - lateral - yaw;
            double rightbackPower = axial + lateral - yaw;
            max=Math.abs(Math.abs(leftfrontPower));
            max=Math.abs(Math.abs(rightfrontPower));
            max=Math.abs(Math.abs(leftbackPower));
            max=Math.abs(Math.abs(rightbackPower));
            if (max>1.0){
                leftfrontPower/=max;
                rightfrontPower/=max;
                leftbackPower/=max;
                rightbackPower/=max;
            }
            double movement_speed = 0.75;
            leftfrontDrive.setPower(leftfrontPower*movement_speed);
            leftbackDrive.setPower(leftbackPower*movement_speed);
            rightfrontDrive.setPower(rightfrontPower*movement_speed);
            rightbackDrive.setPower(rightbackPower*movement_speed);

        }


    }
}

