package personal.web.model;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEST")
public class Comments 
{
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer ID;
	String NAME;
	String COMMENTS;
	Timestamp TIME;
	
	public Integer getID()
	{
		return ID;
	}
	public void setID(Integer iD)
	{
		ID=iD;
	}
	
	public String getNAME()
	{
		return NAME;
	}
	public void setNAME(String nAME)
	{
		NAME=nAME;
	}
	
	public String getCOMMENTS()
	{
		return COMMENTS;
	}
	public void setCOMMENTS(String cOMMENTS)
	{
		COMMENTS=cOMMENTS;
	}
	

	public Timestamp getTIME() {
		return TIME;
	}
	public void setTIME(Timestamp tIME) {
		TIME = tIME;
	}
}
