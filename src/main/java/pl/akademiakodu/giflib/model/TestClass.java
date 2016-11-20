package pl.akademiakodu.giflib.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Jaremina on 2016-11-19.
 */
@Entity
@Table(name = "OMG_CRAZY_TABLE")
public class TestClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Go", nullable = false)
    private String columnA;
    @Column(name = "AND", columnDefinition = "CLOB NOT NULL")
    private String columnB;
    @Column(name = "DEBUG", unique = true)
    private String columnC;
    @Column(name = "THIS", precision = 12)
    private BigDecimal columnD;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumnA() {
        return columnA;
    }

    public void setColumnA(String columnA) {
        this.columnA = columnA;
    }

    public String getColumnB() {
        return columnB;
    }

    public void setColumnB(String columnB) {
        this.columnB = columnB;
    }

    public String getColumnC() {
        return columnC;
    }

    public void setColumnC(String columnC) {
        this.columnC = columnC;
    }

    public BigDecimal getColumnD() {
        return columnD;
    }

    public void setColumnD(BigDecimal columnD) {
        this.columnD = columnD;
    }
}
