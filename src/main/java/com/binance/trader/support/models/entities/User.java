package com.binance.trader.support.models.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    private String userName ;

    private String userApiKey;

    private String userSecretKey;

    @OneToMany(mappedBy = "user")
    private List<TrackingModel> trackingModels;

    @OneToMany(mappedBy = "user")
    private List<SelectedToken> selectedTokens;

}
