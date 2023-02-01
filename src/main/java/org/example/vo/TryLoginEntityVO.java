package org.example.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class TryLoginEntityVO implements Serializable {

    private String ip="";

    private String mac="";

    private String headers="";

    private String userName="";

    private String password="";

}
