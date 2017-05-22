/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package t1sd;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author patrick
 */
public class T1SD{
    public void salvar(Object objeto, String caminho) {
           try {
             FileOutputStream saveFile = new FileOutputStream(caminho);
             ObjectOutputStream stream = new ObjectOutputStream(saveFile);
 
              // salva o objeto
             stream.writeObject(objeto);
 
             stream.close();
           } catch (Exception exc) {
             exc.printStackTrace();
           }
    }
    
    public Object restaurar(String caminho) {
        Object objeto = null;          
            try {
                FileInputStream restFile = new FileInputStream(caminho);
                ObjectInputStream stream = new ObjectInputStream(restFile);
                // recupera o objeto
                objeto = stream.readObject();
                stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return objeto;
    }
}

