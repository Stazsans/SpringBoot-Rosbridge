package com.ros.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@Schema(name = "PageInfo", title = "通用分页返回对象")
public class PageInfo<T> {
    @Schema(name = "list",description = "List of page")
    List<T> list ;
    @Schema(name = "total",description = "Total number of pages")
    long total ;
}

