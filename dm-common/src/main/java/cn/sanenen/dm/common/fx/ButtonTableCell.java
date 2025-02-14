package cn.sanenen.dm.common.fx;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

import java.util.function.Consumer;

public class ButtonTableCell<S, T> extends TableCell<S, T> {

    private final Button button;

    public ButtonTableCell(String buttonText, Consumer<S> onAction) {
        button = new Button(buttonText);
        button.setOnAction(event -> {
            if (onAction != null) {
                onAction.accept(getCurrentItem());
            }
        });
    }

    @Override
    protected void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setGraphic(null);
        } else {
            setGraphic(button);
        }
    }

    private S getCurrentItem() {
        return getTableView().getItems().get(getIndex());
    }

    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(String buttonText, Consumer<S> onAction) {
        return column -> new ButtonTableCell<>(buttonText, onAction);
    }
}