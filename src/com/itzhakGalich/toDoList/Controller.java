package com.itzhakGalich.toDoList;

import com.itzhakGalich.toDoList.datamodel.ToDoItem;
import com.itzhakGalich.toDoList.datamodel.TodoData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;


import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller
{
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView<ToDoItem> todoListView;
    @FXML
    private TextArea itemDetails;

    @FXML
    Label deadLineLabel;

    public void  initialize()
    {
//        ToDoItem item1 = new ToDoItem("Mail birthday card",
//                "Buy a 30th birthday card for John", LocalDate.of(2016, Month.APRIL, 25));
//
//        ToDoItem item2 = new ToDoItem("Doctor's Appointment",
//                "See Dr. Smith at 123 Main Street. Bring paperwork.", LocalDate.of(2016, Month.MAY, 23));
//
//        ToDoItem item3 = new ToDoItem("Pickup Doug at the train station",
//                "Doug's arrived on March 23 on the 5:00 train", LocalDate.of(2016, Month.MARCH, 23));
//
//        ToDoItem item4 = new ToDoItem("Finish design proposal for client",
//                "I promised Mike I'd email website mockups by Friday 22nd April", LocalDate.of(2016, Month.APRIL, 22));
//        ToDoItem item5 = new ToDoItem("Pick up dry cleaning",
//                    "The clothes shuld be ready by Wednesday", LocalDate.of(2016, Month.APRIL, 20));
//
//        toDoItems = new ArrayList<ToDoItem>();
//        toDoItems.add(item1);
//        toDoItems.add(item2);
//        toDoItems.add(item3);
//        toDoItems.add(item4);
//        toDoItems.add(item5);
//
//        TodoData.getInstance().setTodoItems(toDoItems);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ToDoItem>() {
            @Override
            public void changed(ObservableValue<? extends ToDoItem> observable, ToDoItem oldValue, ToDoItem newValue)
            {
               if(newValue!=null)
               {
                   ToDoItem item = todoListView.getSelectionModel().getSelectedItem();
                   itemDetails.setText(item.getDetails());
                   DateTimeFormatter dFormatter = DateTimeFormatter.ofPattern("d MMMM, yyyy");
                   deadLineLabel.setText(dFormatter.format(item.getDeadLine()));
               }
            }
        });

        todoListView.getItems().addAll(TodoData.getInstance().getTodoItems());
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

    }

    @FXML
    public void handleClickListView()
    {
        ToDoItem item = todoListView.getSelectionModel().getSelectedItem();

        deadLineLabel.setText(item.getDeadLine().toString());
        itemDetails.setText(item.getDetails());

    }

}
