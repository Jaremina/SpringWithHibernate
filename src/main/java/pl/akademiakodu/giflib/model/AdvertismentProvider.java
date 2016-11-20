package pl.akademiakodu.giflib.model;

import sun.util.resources.cldr.mg.LocaleNames_mg;

import javax.persistence.*;

/**
 * Created by Jaremina on 2016-11-19.
 */
@Entity
@Table(name = "ADS_PROV")
public class AdvertismentProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME", unique = true)
    private String companyName;
    @Column(name = "DESC", nullable = false)
    private String description;
    @Column(name = "CREATED")
    private int yearCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    @Override
    public String toString() {
        return "AdvertismentProvider{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", description='" + description + '\'' +
                ", yearCreated=" + yearCreated +
                '}';
    }
}
