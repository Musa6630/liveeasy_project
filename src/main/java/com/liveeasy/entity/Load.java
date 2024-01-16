package com.liveeasy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
//import javax.persistence.*;
import java.util.Date;
import jakarta.persistence.*;


@Data
@Entity
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private int weight;
    private String comment;
    private String shipperId;

    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;
}

