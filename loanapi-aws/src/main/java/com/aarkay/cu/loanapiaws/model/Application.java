package com.aarkay.cu.loanapiaws.model;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@QueryEntity
@Document(collection = "newloanrequest")
public class Application {

    @Id
    private String _id;
    private String applicationId;
    private String customerId;
    private String genderCode;
    private String flagOwnCar;
    private String flagOwnRealty;
    private int cntChildren;
    private double amtIncomeTotal;
    private String nameIncomeType;
    private String nameEducationType;
    private String nameFamilyStatus;
    private String nameHousingType;
    private long daysBirth;
    private long daysEmployed;
    private int flagMobil;
    private int flagWorkPhone;
    private int flagPhone;
    private int flagEmail;
    private String occupationType;
    private int cntFamMembers;
    private double riskScore;
}
