package com.kkb.common.homer.core;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author zhaodahai
 * 2021/7/13
 */
@Setter
@Getter
public class HomerContext extends HashMap<String,String> implements Serializable {

    private static final long serialVersionUID = 3590063803926654241L;
}
