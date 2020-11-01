package archy.wiz.smaholdings.exception;

import java.io.Serializable;

public class ProjectNotFoundException extends Exception implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String exceptionMessage;
   
   public ProjectNotFoundException() {
	   this.exceptionMessage = System.currentTimeMillis() + ": " +exceptionMessage;
   }

public String getExceptionMessage() {
	return exceptionMessage;
}
   
}
