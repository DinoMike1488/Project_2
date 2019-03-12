package com.Dimmerling.week1;

import java.util.ArrayList;
import java.util.Scanner;

public class UserTaskList {
    private Scanner scan = new Scanner(System.in);
    public boolean updateUserTask(ArrayList<UserTask> getList) {
        boolean check = true;
        int checkUserTask = 0;

        System.out.println("What task would you like to update?(By ID number)");
        int taskId = scan.nextInt();
        scan.nextLine();
        for (UserTask getTask : getList) {
            if (taskId == getTask.getId()) {
                getList.remove(getTask);
                check = true;
            }
            if (checkUserTask > getList.size()) {
                System.out.println("Input a valid task!");
                check = false;
            }
            checkUserTask++;
        }
        return check;
    }
    public void listUserTask(ArrayList<UserTask> getList){
        int idNum = 1;
        for (int i = 5; i>0;i--) {
            for (UserTask getTask : getList) {
                if (getTask.getTaskPri() == i) {
                    System.out.println(idNum+") " + getTask.getTaskName()+ "\nDescription: " + getTask.getTaskDes()
                            + "\nPriority: " + i);
                    getTask.setId(idNum);
                    idNum++;
                }
            }
        }
    }
}
