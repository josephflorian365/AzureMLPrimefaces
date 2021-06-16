/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.Iris;
import org.primefaces.json.JSONObject;
//import org.primefaces.shaded.json.JSONObject;
import services.PredecirIris;

@Named(value = "irisC")
@SessionScoped
@Data
public class PredecirIrisC implements Serializable{

    Iris iris;

    public PredecirIrisC() {
        iris = new Iris();
        iris.setSepal_lenght(4.1);
        iris.setSepal_width(2.3);
        iris.setPetal_lenght(5.4);
        iris.setPetal_widht(2.3);
    }
    
        public void obtenerDatos() throws IOException, InterruptedException {
        try {
            JSONObject cadenaJson = PredecirIris.obtenerJSon(iris);
//            System.out.println("cadenaJson " + cadenaJson);
            iris.setCategory(cadenaJson.getString("Scored Labels"));
            iris.setProbability(cadenaJson.getDouble("Scored Probabilities"));
//            System.out.println("Scored " + cadenaJson.getString("Scored Labels"));
//            System.out.println("Probabilities " + cadenaJson.getDouble("Scored Probabilities"));
//            if (iris.getCategory().equals("Iris-versicolor")) {
//                iris.setResult("Es una Iris-versicolor");
//            }
//            if (iris.getCategory().equals("Iris-setosa")) {
//                iris.setResult("Es una Iris-setosa");
//            }
//            if (iris.getCategory().equals("Iris-virginica")) {
//                iris.setResult("Es una Iris-virginica");
//            }else {
//                iris.setResult("Lo sentimos, No es ninguna especie predecible");
//            }
        } catch (Exception e) {
            System.out.println("Error en obtenerDatosC: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
