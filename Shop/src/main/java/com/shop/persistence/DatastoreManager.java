package com.shop.persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.shop.domain.Shop;

public class DatastoreManager {


    private static DatastoreManager instance=new DatastoreManager();
    private Datastore datastore;
    
    private DatastoreManager() {
        try {
            MongoClient mongo = new MongoClient("localhost");    
            this.datastore=new Morphia().createDatastore(mongo, "shopPicture");            
            datastore.ensureIndexes();            
        } catch (Exception ex) {
            Logger.getLogger(DatastoreManager.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public static DatastoreManager getInstance(){        
        return instance;
    }
    
    public Datastore getDatastore(){        
        return datastore;
    }

    
    /**
     * Resets all BBDD. 
     */    
	public void clearBBDD() {
		datastore.delete(datastore.createQuery(Shop.class));
	}

}
