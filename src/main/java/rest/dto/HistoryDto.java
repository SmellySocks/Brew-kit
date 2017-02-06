package rest.dto;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HistoryDto {

    private Integer id;
    private Date date;
    private Double amount;
    private Double rate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public void setAmount(Double amount) {
        this.amount = amount;
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


    public Double getRate() {
        return rate;
    }
}
