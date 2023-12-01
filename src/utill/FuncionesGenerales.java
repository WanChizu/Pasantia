/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utill;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author A19B59953
 */
public class FuncionesGenerales {

    public static BigDecimal getValueOf(Object value) {
        BigDecimal respuesta = null;

        if (value != null && value instanceof Number) {
            Number valueNumber = (Number) value;

            respuesta = new BigDecimal(valueNumber.doubleValue()).setScale(2,RoundingMode.HALF_UP);
        }

        return respuesta;
    }

    
    
}
