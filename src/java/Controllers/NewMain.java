/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.ProductOptions;
import Models.Products;
import java.util.Map;

/**
 *
 * @author wongun78
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.loadDB();
        for (Map.Entry<Integer, Products> en : dao.getProd().entrySet()) {
            Object key = en.getKey();
            Object val = en.getValue();
            System.out.println(key);
            System.out.println(val);
        }
        System.out.println(dao.getStatus());
//        for (ProductOptions productOptions : dao.getProdop()) {
//        }
    }
    
}
