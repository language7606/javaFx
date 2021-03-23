package common;
	
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
	
public class BoardVO {
	SimpleIntegerProperty boardNo;
	SimpleStringProperty title;
	SimpleStringProperty passwd;
	SimpleStringProperty publicity;
	SimpleStringProperty exitDate;
	SimpleStringProperty contents;
	public BoardVO() {
		boardNo = new SimpleIntegerProperty();
		title = new SimpleStringProperty();
		passwd = new SimpleStringProperty();
		publicity = new SimpleStringProperty();
		exitDate = new SimpleStringProperty();
		contents = new SimpleStringProperty();
	}
	
	
	
	public SimpleIntegerProperty getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(SimpleIntegerProperty boardNo) {
		this.boardNo = boardNo;
	}
	
	public SimpleIntegerProperty boardNoProperty() {
		return this.boardNo;
	}
	
	public SimpleStringProperty getTitle() {
		return title;
	}
	public void setTitle(SimpleStringProperty title) {
		this.title = title;
	}
	public SimpleStringProperty titleProperty() {
		return this.title;
	}
	public SimpleStringProperty getPasswd() {
		return passwd;
	}
	public void setPasswd(SimpleStringProperty passwd) {
		this.passwd = passwd;
	}
	public SimpleStringProperty passwdProperty() {
		return this.passwd;
	}
	public SimpleStringProperty getPublicity() {
		return publicity;
	}
	public void setPublicity(SimpleStringProperty publicity) {
		this.publicity = publicity;
	}
	public SimpleStringProperty publicityProperty() {
		return this.publicity;
	}
	
	public SimpleStringProperty getExitDate() {
		return exitDate;
	}
	public void setExitDate(SimpleStringProperty exitDate) {
		this.exitDate = exitDate;
	}
	public SimpleStringProperty exitDateProperty() {
		return this.exitDate;
	}
	public SimpleStringProperty getContents() {
		return contents;
	}
	public void setContents(SimpleStringProperty contents) {
		this.contents = contents;
	}
	public SimpleStringProperty contentsProperty() {
		return this.contents;
	}
}
