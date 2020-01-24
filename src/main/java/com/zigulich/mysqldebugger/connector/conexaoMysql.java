/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zigulich.mysqldebugger.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luan Zigulich
 */
public class conexaoMysql {
    public static Connection conn;
    
    public static void estabelecerConexao(String Parametros){
        Thread t = new Thread(){
            @Override
            public void run(){
                Connection conn = null;
                String[] Par = Parametros.split(";");

                switch (Par.length) {
                    case 2:
                        Par[2] = "";
                        break;
                    case 1:
                        Par[1] = "";
                        Par[2] = "";
                        break;
                    case 0:
                        Par[1] = "";
                        Par[2] = "";
                        Par[3] = "";
                        break;
                    default:
                        break;
                }

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(conexaoMysql.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    conn = DriverManager.getConnection("jdbc:mysql://"+Par[0]+"/mysql?user="+Par[1]+"&password="+Par[2]+"&useTimezone=true&serverTimezone=UTC");
                } catch(SQLException ex){
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o banco de dados! HOST:"+Par[0]+" USER:"+Par[1]+" PASS:"+Par[2], "Erro na conexão", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                }
                conexaoMysql.conn = conn;
            }
        };
        t.start();
    }
    
    public static Connection getConexao(){;
        return conexaoMysql.conn;
    }
}
