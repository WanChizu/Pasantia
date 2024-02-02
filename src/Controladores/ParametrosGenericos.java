/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Lizor
 */
public class ParametrosGenericos {

    /**
     * @param args the command line arguments
     */
    
    public static void setParametros(PreparedStatement ps, List<Object> parameters) throws SQLException {
    for (int i = 0; i < parameters.size(); i++) {
        Object param = parameters.get(i);
        int parameterIndex = i + 1;

        if (param instanceof String) {
            ps.setString(parameterIndex, (String) param);
        } else if (param instanceof Integer) {
            ps.setInt(parameterIndex, (int) param);
        } else if (param instanceof Boolean) {
            ps.setBoolean(parameterIndex, (boolean) param);
        } else if (param instanceof BigDecimal) {
            ps.setBigDecimal(parameterIndex, (BigDecimal) param);
        }
    }
}

    
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    
    
}
