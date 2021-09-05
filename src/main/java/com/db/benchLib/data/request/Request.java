package com.db.benchLib.data.request;

import com.db.benchLib.data.PointGeo;
import com.db.benchLib.data.request.RequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Request implements Serializable {
    @Id
    private String id;
    private PointGeo location;
    private Map<String, String> properties;
    private Binary photo;
    private RequestStatus requestStatus;
}
