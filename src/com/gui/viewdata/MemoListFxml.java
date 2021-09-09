package com.gui.viewdata;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemoListFxml {

    @FXML
    TableView dataTable;

    @FXML
    TableColumn<Book, Integer> columnBookId;

    @FXML
    TableColumn<Book, String> columnBookName;

    @FXML
    TableColumn<Book, String> columnAuthor;

    @FXML
    TableColumn<Book, String> columnPublisher;

    @FXML
    TextField tfBookId;

    @FXML
    TextField tfBookName;

    @FXML
    TextField tfBookAuthor;

    @FXML
    TextField tfBookPublisher;

    public MemoListFxml() {
        System.out.println("constructor");
    }

    @FXML
    private void initialize() {

        columnBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnBookName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        columnPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
    }

    @FXML
    public void addRow() {
        int id = Integer.parseInt(tfBookId.getText());
        String name = tfBookName.getText();
        String author = tfBookAuthor.getText();
        String publisher = tfBookPublisher.getText();

        Book book = new Book(id, name, author, publisher);

        dataTable.getItems().add(book);
    }
}
