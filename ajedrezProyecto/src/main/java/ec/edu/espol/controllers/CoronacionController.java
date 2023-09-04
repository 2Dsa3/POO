/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author japolo15
 */
public class CoronacionController implements Initializable {

    @FXML
    private ImageView estrellasB;
    @FXML
    private ImageView estrellasA;
    @FXML
    private Button Pcaballo;
    @FXML
    private ImageView ImgCaballo;
    @FXML
    private Button Ptorre;
    @FXML
    private ImageView ImgTorre;
    @FXML
    private Button Palfil;
    @FXML
    private ImageView ImgAlfil;
    @FXML
    private Button Preina;
    @FXML
    private ImageView ImgReina;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        this.cargarImagenes();
    }    
    
    public void cargarImagenes(){
        
        Image imgA = new Image("ec/edu/espol/chessPieces/blackpawn.png");
        Image imgB = new Image("ec/edu/espol/chessPieces/torre_real.jpg");
        Image imgC = new Image("ec/edu/espol/chessPieces/caballo_real.jpg");
        Image imgD = new Image("ec/edu/espol/chessPieces/reina_real.jpg");
        
        ImgAlfil= new ImageView(imgA);
        ImgTorre= new ImageView(imgB);
        ImgCaballo= new ImageView(imgC);
        ImgReina= new ImageView(imgD);
    }
            
    
}
