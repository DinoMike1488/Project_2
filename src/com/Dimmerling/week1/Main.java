package com.Dimmerling.week1;

import java.util.ArrayList;
import java.util.Scanner;

/*
3/3/19
Michael Dimmerling
programming fundamentals
Program give you a list of options to use to manipulate a task from the user.
 */
public class Main {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<UserTask> taskUserList = new ArrayList<>();
    static UserTaskList list = new UserTaskList();

    static boolean whatUserTask(){
        String whichUserTask;
        boolean exit = false;

        System.out.println("Please pick one of these 5 options\n" +
                "(1) Add a task.\n" +
                "(2) Remove a task.\n" +
                "(3) Update a task.\n" +
                "(4) List all tasks.\n" +
                "(0) Exit.");
        whichUserTask = scan.nextLine();

        switch (whichUserTask){
            case "1": addUserTask();
                break;

            case "2":
                list.listUserTask(taskUserList);
                removeUserTask();
                break;

            case "3":
                list.listUserTask(taskUserList);
                if(list.updateUserTask(taskUserList)){addUserTask();}
                break;

            case "4":
                list.listUserTask(taskUserList);
                break;

            case "0":
                exit = true;
                break;

            default:
                System.out.println("Not a valid input!");
                break;
        }
        return exit;
    }
    static void addUserTask() {
        int taskPri = 0;
        boolean validInput = false;
        System.out.println("What is the name of your new task?");
        String askTask = scan.nextLine();
        System.out.println("What is the description of the task " + askTask + ":");
        String taskDes = scan.nextLine();
        while(!validInput){
            try{
                System.out.println("What is the priority of this task?(1-5)");
                taskPri = scan.nextInt();
                scan.nextLine();
                if(0<taskPri & taskPri<6){
                    validInput = true;
                }
                else{
                    System.out.println("input a valid priority number(1-5)");
                }
            }catch (Exception e){
                scan.nextLine();
                System.out.println("invalid input try again!");
            }
        }
        UserTask newTask = new UserTask(askTask, taskDes, taskPri);
        taskUserList.add(newTask);
    }
    static void removeUserTask() {
        int checkUserTask = 0;
        int UserTaskId = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("What task would you like to remove?(By ID number)");
                UserTaskId = scan.nextInt();
                scan.nextLine();
                validInput = true;

            } catch (Exception e) {
                scan.nextLine();
                System.out.println("invalid input try again!");
            }
        }
        for (UserTask getUserTask : taskUserList) {
            if (UserTaskId == getUserTask.getId()) {
                taskUserList.remove(getUserTask);
            }
            else if (checkUserTask > taskUserList.size()) {
                System.out.println("Input a valid task!");
                removeUserTask();
            }
            checkUserTask++;
        }
    }
    public static void main(String[] args) {
        //main
        boolean exit;
        do{
            exit = whatUserTask();
        }while(!exit);
    }
}
