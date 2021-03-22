package myapp.input;

import java.net.URL;
import java.util.ResourceBundle;

import common.InputBoardVO;
import common.InputDAO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RootController implements Initializable {
	
	
	@FXML private TextField txtTitle;
	@FXML private PasswordField txtPassword;
	@FXML private ComboBox<String> comboPublic;
	@FXML private DatePicker dateExit;
	@FXML private TextArea txtContent;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void handleBtnRegAction(ActionEvent e) {
		String title = txtTitle.getText();
		String password = txtPassword.getText();
		String strPublic = comboPublic.getValue();
		String exitDate = dateExit.getValue().toString();
		String contents = txtContent.getText();
		
		InputBoardVO bo = new InputBoardVO();
		bo.setTitle(title);
		bo.setPasswd(password);
		bo.setPublicity(strPublic);
		bo.setExitDate(exitDate);
		bo.setContents(contents);
		
		InputDAO.insertBoard(bo);
		
		//초기화
		txtTitle.setText("");
		
		
	}
	public void handleBtnCancelAction(ActionEvent e) {
		Platform.exit();
	}
}
