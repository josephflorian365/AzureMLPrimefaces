/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.Getter;
import lombok.Setter;

public class Iris {

    @Getter
    @Setter
    Double sepal_lenght;
    @Getter
    @Setter
    Double sepal_width;
    @Getter
    @Setter
    Double petal_lenght;
    @Getter
    @Setter
    Double petal_widht;
    @Getter
    @Setter
    String category;
    @Getter
    @Setter
    Double probability;
    @Getter
    @Setter
    String result;
}
