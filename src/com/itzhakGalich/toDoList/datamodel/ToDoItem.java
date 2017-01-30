package com.itzhakGalich.toDoList.datamodel;

import java.time.LocalDate;

/**
 * Created by יצחק ושרה on 29/01/2017.
 */
public class ToDoItem
{
    private String shortDiscription;
    private String details;
    private LocalDate deadLine;

    public ToDoItem(String shortDiscription, String details, LocalDate deadLine) {
        this.shortDiscription = shortDiscription;
        this.details = details;
        this.deadLine = deadLine;
    }

    public String getShortDiscription() {
        return shortDiscription;
    }

    public void setShortDiscription(String shortDiscription) {
        this.shortDiscription = shortDiscription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return shortDiscription;
    }
}
