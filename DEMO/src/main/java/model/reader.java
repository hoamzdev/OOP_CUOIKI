
package model;

import java.io.Serializable;

public class reader implements Serializable{
    private static int ID = 9999;
    private int id;
    private String name;
    private String address;
    private String phone;

    public reader() {
    }

    public reader(int id, String nme, String address, String phone) {
        this.id = id;
        this.name = nme;
        this.address = address;
        this.phone = phone;
    }
    
    public Object[] toObject(){
        return new Object[]{id,name,address,phone};
    }
           
}
