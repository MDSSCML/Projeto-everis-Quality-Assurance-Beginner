package Controle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

@Entity
@Table(name="Controle") 
@DynamicInsert(value = true)
public class Controle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	@Column
	public String nome;
	@Column
	public String sobreNome;
	@Column
	public String usuario;
	@Column
	public String cidade;
	@Column
	public String estado;
	@Column
	public String cep;
	
}
