package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;
import com.yanghui.antelope.domain.common.BaseMode;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-27
 */
@TableName("td_programme")
@Data
@EqualsAndHashCode(callSuper=false)
public class Programme extends BaseMode<Programme> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
	@TableField("customer_id")
	private Long customerId;
    /**
     * 客户经理建议
     */
	@TableField("customer_manager_proposal")
	private String customerManagerProposal;
    /**
     * 主管方案
     */
	@TableField("director_programme")
	private String directorProgramme;
    /**
     * 批款结果
     */
	@TableField("appropriation_result")
	private String appropriationResult;
    /**
     * 跟进建议
     */
	@TableField("follow_up_proposal")
	private String followUpProposal;
	@TableField(exist=false)
	private Integer mark;

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
