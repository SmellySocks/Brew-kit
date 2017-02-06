/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import javax.persistence.*;

import java.sql.Date;


@Entity
@Table(name="history")
@NamedQueries({
       @NamedQuery(name = "history.all", query = "SELECT h FROM OrderHistory h")
})
public class OrderHistory implements IHaveId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date date;
    private Double amount;



    @ManyToOne
    private Beer beerId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


    public OrderHistory(Integer id, Date date, Integer operationId, Double amount, Integer BeerId) {

        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public OrderHistory() {

    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Double getAmount() {

        return amount;
    }
    public Beer getBeerId() {
        return beerId;
    }

    public void setBeerId(Beer beerId) {
        this.beerId = beerId;
    }

}
