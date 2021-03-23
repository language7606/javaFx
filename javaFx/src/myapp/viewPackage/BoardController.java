package myapp.viewPackage;

import java.net.URL;
import java.util.ResourceBundle;

import common.BoardVO;
import common.InputDAO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class BoardController implements Initializable {
	@FXML
	TableView<BoardVO> tableView;

	@FXML
	Button updateBtn, deleteBtn, exitBtn;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		deleteBtn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				deleteBtnAction(e);
			}
		});
		ObservableList<BoardVO> list = InputDAO.boardList();

		tableView.setPrefWidth(450);
		tableView.setLayoutX(30);

		TableColumn<BoardVO, Integer> tcBoardNo = //
				(TableColumn<BoardVO, Integer>) tableView.getColumns().get(0);
		tcBoardNo.setCellValueFactory(//
				new PropertyValueFactory<BoardVO, Integer>("boardNo")//
		);
		tcBoardNo.setPrefWidth(70);
		TableColumn<BoardVO, String> tcTitle = //
				(TableColumn<BoardVO, String>) tableView.getColumns().get(1);
		tcTitle.setCellValueFactory(//
				new Callback<CellDataFeatures<BoardVO, String>, ObservableValue<String>>() {

					@Override
					public ObservableValue<String> call(CellDataFeatures<BoardVO, String> arg0) {
//						return param.getValue().titleProperty();
						return null;
					}
				});
		TableColumn<BoardVO, String> tcPub = //
				new TableColumn<BoardVO, String>("공개");
		tcPub.setCellValueFactory(new PropertyValueFactory<BoardVO, String>("publicity"));
		tableView.getColumns().add(tcPub);

		tableView.setItems(list);

		tableView.getSelectionModel().selectedItemProperty()//
				.addListener(new ChangeListener<BoardVO>() {

					@Override
					public void changed(ObservableValue<? extends BoardVO> arg0, BoardVO arg1, BoardVO arg2) {
						System.out.println(newVal.getBoardNo));
						boardNo.setText(String.valueOf(newVal.getBoardNo()));
						title.setText(newVal.getTitle());
						publicity.setValue(newVal.getPublicity());
						contents.setText(newVal.getContents());
						exitDate.setValue(LocalDate.parse(newVa.getExitDate()));
					}
				});
	}

	public void updateBtnAction(ActionEvent e) {

	}

	public void deleteBtnAction(ActionEvent e) {
		
	}
}
