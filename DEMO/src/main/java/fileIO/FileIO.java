
package fileIO;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import java.util.ArrayList;


public class FileIO {
    public static void writeFile(ArrayList listOBj,String filename){
    
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
            }
        } catch (Exception e) {
        }
    }
}
