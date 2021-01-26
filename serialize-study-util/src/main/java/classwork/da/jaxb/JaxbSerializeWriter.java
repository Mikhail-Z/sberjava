package classwork.da.jaxb;

import homework.v3.entity.jaxb.Bundle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class JaxbSerializeWriter {
	
	public void customSerializeWriter(Bundle parameters, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName)){
			try (ObjectOutputStream oos = new ObjectOutputStream(fos);){
				oos.writeObject(parameters);
			}
		}
	}
	
}
