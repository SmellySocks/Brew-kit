package domain.model;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import dao.BeerRepository;

@XmlRootElement
@Entity
@Table(name="beers")
@NamedQueries({
	@NamedQuery(name="beers.id", query="Select w FROM Beer w WHERE w.id=:id"),
        @NamedQuery(name="beers.all", query = "select w from Beer w")
})
public class Beer implements IHaveId{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String style;

    public Integer getIbu() {
        return ibu;
    }

    public void setIbu(Integer ibu) {
        this.ibu = ibu;
    }

    private Integer ibu;

    @OneToMany
    private List<OrderHistory> orderHistory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    private String brewery;
    
    
    
    public List<OrderHistory> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(List<OrderHistory> orderHistory) {
		this.orderHistory = orderHistory;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    }


