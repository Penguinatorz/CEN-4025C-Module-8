package Module_7;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * @Author: Jancarlo Sevilla
 * This is the table chart
 */
@Entity
public class databasePassing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	protected int id;
	
	@Column(name="list")
	protected String list;

	public databasePassing() {
	}

	public databasePassing(String listP) {
		this.list = listP;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

}
