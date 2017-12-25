package online.shixun.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nominal on 2017/12/25 0025.
 * 微博：@李明易DY
 */
@Entity
@Table(name = "commodity")
public class Commodity {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
    *商品名称
    */
    @Column(name = "name")
    private String name;


    /**
     * 商品描述
     */
    @Column(name = "description")
    private String description;

    /**
    *创建时间
    */
    @Column(name = "tb_craete")
    private Date craeteDate;

    /**
    *修改时间
    */
    @Column(name = "tb_modify")
    private Date modifyDate;

    public Commodity(int id,String name,String description, Date craeteDate, Date modifyDate) {
        this.id=id;
        this.name=name;
        this.description = description;
        this.craeteDate = craeteDate;
        this.modifyDate = modifyDate;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", craeteDate=" + craeteDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Commodity( String name,String description, Date craeteDate, Date modifyDate) {
        this.name=name;
        this.description = description;
        this.craeteDate = craeteDate;
        this.modifyDate = modifyDate;
    }

    public Commodity(int id) {
        this.id=id;
    }

    public Commodity() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCraeteDate() {
        return craeteDate;
    }

    public void setCraeteDate(Date craeteDate) {
        this.craeteDate = craeteDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
