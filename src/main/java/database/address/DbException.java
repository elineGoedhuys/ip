/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.address;

/**
 *
 * @author Eline
 */
public class DbException extends RuntimeException {
    
     public DbException(){
	super();
}

public DbException(String message,Throwable exception){
	super(message,exception);
}

public DbException(String message){
	super(message);
}

public DbException(Throwable exception){
	super(exception);
}
    
}
