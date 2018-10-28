package mega.coffee.account.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    private String id;

    private String loginName;

    private String firstName;

    private String lastName;

    private DOB dob;

    private String genda;

    private String cellNum;

    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date lastLoginDate;

    private GeoJsonPoint lastLoginLocation;




}

