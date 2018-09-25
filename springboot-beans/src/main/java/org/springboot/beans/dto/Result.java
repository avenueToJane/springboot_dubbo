package org.springboot.beans.dto;

import java.io.Serializable;
import lombok.Data;
@Data
public class Result implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4281283315866522164L;
	
	private String returnCode;//返回码
	
	private String returnMessage;//返回信息
	
	

}
