package com.itzhakGalich.toDoList;

import com.itzhakGalich.toDoList.datamodel.ToDoItem;
import com.itzhakGalich.toDoList.datamodel.TodoData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;


import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Controller
{
    private List<ToDoItem> toDoItems;
    @FXML
    private ListView<ToDoItem> todoListView;
    @FXML
    private TextArea itemDetails;

    @FXML
    Label deadLineLabel;

    @FXML
    private BorderPane mainBorderPane;

    public void  initialize()
    {


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
    public void showNewItemDialog()
    {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("todoItem.fxml"));
            dialog.getDialogPane().setContent(root);

        }
        catch (IOException ex)
        {
            System.out.println("Could't load the dialog");
            ex.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK)
        {
            System.out.println("Ok pressed");
        }
        else
        {
            System.out.println("Cancel pressed");
        }

    }

    @FXML
    public void handleClickListView()
    {
        ToDoItem item = todoListView.getSelectionModel().getSelectedItem();

        deadLineLabel.setText(item.getDeadLine().toString());
        itemDetails.setText(item.getDetails());

    }

}
