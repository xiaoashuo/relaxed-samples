package com.relaxed.common.risk.model.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Yakir
 * @since 2021-08-29T18:48:19.341
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("engine_data_list_meta")
@Schema(title = "")
public class DataListMeta extends Model<DataListMeta> {

	/**
	 * 主键
	 */
	@TableId(value = "ID")
	@Schema(title = "主键", description = "主键")
	private Long id;

	/**
	 * 数据列表ID
	 */
	@Schema(title = "数据列表ID", description = "数据列表ID")
	private Long dataListId;

	/**
	 * 字段名
	 */
	@Schema(title = "字段名", description = "字段名")
	private String fieldName;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private String label;

	/**
	 * 字段序号
	 */
	@Schema(title = "字段序号", description = "字段序号")
	private Integer seqNum;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime createTime;

	/**
	 *
	 */
	@Schema(title = "", description = "")
	private LocalDateTime updateTime;

}
