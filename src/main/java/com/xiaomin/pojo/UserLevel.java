package com.xiaomin.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLevel {

  private long id;
  private String levelName;
  private Date dateModified;

}
