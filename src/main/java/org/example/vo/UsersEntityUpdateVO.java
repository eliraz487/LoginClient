package org.example.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class UsersEntityUpdateVO  implements Serializable {

    private TryLoginEntityVO tryLogin;

    private String userName="";


    private String password="";


}
