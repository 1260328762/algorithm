package com.cl.operationlog;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author chenliang
 * @since 2023/12/4 17:25
 */
@Accessors(chain = true)
@Data
public class OperationLogContent {

    private String fieldName;

    private Object preValue;

    private Object curValue;

}
