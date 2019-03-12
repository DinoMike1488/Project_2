package com.Dimmerling.week1;

public class UserTask {
    public String taskName;
    public String taskDes;
    public int taskPri;
    public int id;

    public UserTask(String taskName, String taskDes, int taskPri) {
        this.taskName = taskName;
        this.taskDes = taskDes;
        this.taskPri = taskPri;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDes() {
        return taskDes;
    }

    public int getTaskPri() {
        return taskPri;
    }



}