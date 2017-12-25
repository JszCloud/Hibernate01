package online.shixun.model;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by Nominal on 2017/12/20 0020.
 * 微博：@李明易DY
 */
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    private String code;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

    @ManyToOne(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
    @JoinColumn(name = "us_id")
    private User user;

    public Order(Long id,String code, Date createDate) {
        this.code = code;
        this.createDate = createDate;
        this.id=id;
    }

    public Order(String code, Date createDate, User user) {
        this.code = code;
        this.createDate = createDate;
        this.user = user;
    }

    public Order(Long id) {
        this.id=id;
    }

    public Order() {
    }

    public Order(String code, Date createDate) {

        this.code = code;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", createDate=" + createDate +

                '}';
    }
}