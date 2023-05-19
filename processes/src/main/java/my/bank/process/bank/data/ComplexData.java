package my.bank.process.bank.data;

import java.io.Serializable;

import lombok.Data;


@Data
public class ComplexData implements Serializable{

	String id;
	String name;
	String email;
	Long age;
}
