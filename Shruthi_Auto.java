package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
@Autonomous(name = "Shruthi_Auto", group = "Linear OpMode")
public class Shruthi_Auto extends LinearOpMode {
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
            leftfrontDrive.setPower(1);
            leftbackDrive.setPower(1);
            rightbackDrive.setPower(1);
            rightfrontDrive.setPower(1);
            sleep(10000);
            leftfrontDrive.setPower(-1);
            leftbackDrive.setPower(-1);
            rightfrontDrive.setPower(1);
            rightbackDrive.setPower(1);
        }
    }
}
