package team.view;

import java.util.Scanner;

public class Input {

    static Scanner sc = new Scanner(System.in);

    public static int getOperation() throws OutOfBoundException {

        int opNum = sc.nextInt();

        if((opNum < 1 || opNum > 4) && opNum != -1) {
            throw new OutOfBoundException("输入不合法，请重新输入");
        }

        return opNum;

    }

    public static int getId() {

        int id = sc.nextInt();

        return id;

    }

}
