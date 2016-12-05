package distributedServer.foodstore.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Info", uniqueConstraints = {  
@UniqueConstraint(columnNames = "Username")})
public class Info implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Info() {
		super();
	}
	
	public Info(final String name) {
		super();
		this.name = name;
	}
	
	@Id
	@Column(name = "Username")
	private String username;
	
	@Column(name = "Menu")
	private String menu;
	
	@Column(name = "Pass")
	private String pass;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Phone")
	private String phone;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "Sex")
	private String sex;
	
	public String getUsername() {
		return name;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setUserName(String name) {
		this.username = name;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setaddress(String address) {
		this.address = address;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Info other = (Info) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Foo [name=").append(name).append("]");
        return builder.toString();
    }
}
	