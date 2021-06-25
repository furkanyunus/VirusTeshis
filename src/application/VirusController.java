package application;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;


public class VirusController extends checkBox {	
	
    @FXML
    private TableView<Hastalar> HastaTable;

    @FXML
    private TableColumn<Hastalar, String> colAd;

    @FXML
    private TableColumn<Hastalar, String> colMeslek;

    @FXML
    private TableColumn<Hastalar, String> colCinsiyet;

    @FXML
    private TableColumn<Hastalar, String> colMemleket;

    @FXML
    private TableColumn<Hastalar, String> colAtes;

    @FXML
    private TableColumn<Hastalar, String> colSayi; 
    @FXML
    private TableColumn<Hastalar, String> colTeshis;
    @FXML
    private TableColumn<Hastalar, String> colTarih;

    @FXML
    private TextField hastaAdi;

    @FXML
    private Button sorgula;

    @FXML
    private ToggleGroup cinsiyet,meslek;

    @FXML
    private ComboBox<String> Sehir;
    
    @FXML
    private Slider slider;
    
    @FXML
    private Label lblhastaAtes;
    
    @FXML
    private Button btnGrafik,ekle;
    
    @FXML
    private DatePicker date,finish;

    @FXML
    private PieChart pieChart;
    
    ObservableList<Hastalar> hasta=FXCollections.observableArrayList();
    ObservableList<Piechart> chart=FXCollections.observableArrayList();
    int sayi=0;
    @FXML
     void btnEkle(ActionEvent event) {
    	
    	Alert alert=new Alert(AlertType.INFORMATION);
    	alert.setTitle("Bilgileri Ekleme");
    	alert.setHeaderText(null);
    	alert.setContentText("Ekleme Basarili...");
    	alert.showAndWait();
    
    	String hastaIsim=hastaAdi.getText();
    	String Ates=lblhastaAtes.getText();
    	String hastaTeshis=teshis.getText();
    	RadioButton gender=(RadioButton)cinsiyet.getSelectedToggle();
    	RadioButton mes=(RadioButton)meslek.getSelectedToggle();
    	String cinsiyet=gender.getText();
    	String meslek=mes.getText();
    	String memleket=Sehir.getSelectionModel().getSelectedItem().toString();
    	LocalDate localdate=date.getValue();
    	++sayi;
    	hasta.add(new Hastalar(hastaIsim,memleket,cinsiyet,meslek,Ates,hastaTeshis,localdate,sayi));
    	HastaTable.refresh();
    }
    
    @FXML
    void btnGuncelle(ActionEvent event) {
    	Hastalar h=HastaTable.getSelectionModel().getSelectedItem();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("UYARI!!!");
    	alert.setHeaderText("Kiþi Bilgileri Güncellenecek...");
    	alert.setContentText("Ýþlemi gerçekleþtirmek istediðinize emin misiniz?");
    	
    	Optional<ButtonType>result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    		String hastaIsim=hastaAdi.getText();
        	String Ates=lblhastaAtes.getText();
        	String hastaTeshis=teshis.getText();
        	RadioButton gender=(RadioButton)cinsiyet.getSelectedToggle();
        	RadioButton mes=(RadioButton)meslek.getSelectedToggle();
        	String cinsiyet=gender.getText();
        	String meslek=mes.getText();
        	LocalDate localdate=date.getValue();
        	String memleket=Sehir.getSelectionModel().getSelectedItem().toString();
    		
    		h.setHastaAdi(hastaIsim);
        	h.setHastaCinsiyeti(cinsiyet);
        	h.setHastaMeslek(meslek);
        	h.setIl(memleket);
        	h.setHastaAtesi(Ates);
        	h.setHastaTeshis(hastaTeshis);
        	h.setTarih(localdate);
    	}
    	else {
    		alert.close();
    	}
    	
    	HastaTable.refresh();
    }
    @FXML
    void btnSil(ActionEvent event) {
    	Hastalar h=HastaTable.getSelectionModel().getSelectedItem();
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("UYARI!!!");
    	alert.setHeaderText("Kiþi Bilgileri Silinecek...");
    	alert.setContentText("Ýþlemi gerçekleþtirmek istediðinize emin misiniz?");
    	
    	Optional<ButtonType>result=alert.showAndWait();
    	if(result.get()==ButtonType.OK) {
    		hasta.remove(h);
    	}
    	else {
    		alert.close();
    	}
    	
    	
    	HastaTable.refresh();
    	
    }
    
    
    @FXML
    void btnSorgu(ActionEvent event) {
    	
    }

    public void insert() {
    	HastaTable.setItems(hasta);
    	colAd.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("HastaAdi"));
    	colMeslek.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("HastaMeslek"));
    	colCinsiyet.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("HastaCinsiyeti"));
    	colMemleket.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("Il"));
    	colAtes.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("HastaAtesi"));
    	colTeshis.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("HastaTeshis"));
    	colTarih.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("Tarih"));
    	colSayi.setCellValueFactory(new PropertyValueFactory<Hastalar,String>("colSayi"));
    }
    
    @FXML
    void initialize() {
    	insert();
    	ObservableList<String>sehirler=FXCollections.observableArrayList("Ankara","Ýstanbul","Hatay","Niðde","Ýzmir");
    	Sehir.setItems(sehirler);
    	
    	  slider.setMin(21.0);
    	  slider.setMax(43.7);
    	  slider.setShowTickLabels(true);
         
          slider.valueProperty().addListener(new ChangeListener<Number>() {
              @Override
              public void changed(ObservableValue<? extends Number> observed, Number oldValue, Number newValue) {

            	  lblhastaAtes.setText(newValue+"derece");

              }
          });
    	
    }
    @FXML
    void btnGoster(ActionEvent event) throws IOException {
    	
    	LocalDate bitis=finish.getValue();
    	chart.add(new Piechart(bitis));
    	
    	
    	/*LocalDate finish=date.getValue();
    	LocalDate start=date.getValue();
    	int TarihSonuc=(finish.getMonthValue())-(start.getMonthValue());
    	pieChart.setUserData(TarihSonuc);*/
    }
}
