package com.yanghui.antelope.domain.creditBusiness;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨辉
 * @since 2018-08-20
 */
@TableName("td_estate")
public class Estate extends Model<Estate> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 地址
     */
	private String address;
    /**
     * 面积
     */
	private BigDecimal area;
    /**
     * 购买时间
     */
	@TableField("purchase_time")
	private Date purchaseTime;
    /**
     * 质押银行
     */
	@TableField("pledge_bank")
	private String pledgeBank;
    /**
     * 质押时间
     */
	@TableField("pledge_time")
	private Date pledgeTime;
    /**
     * 贷款年限
     */
	@TableField("loan_term")
	private Integer loanTerm;
    /**
     * 贷款额度
     */
	@TableField("loan_limit")
	private BigDecimal loanLimit;
    /**
     * 月供
     */
	@TableField("monthly_supply")
	private BigDecimal monthlySupply;
    /**
     * 证明资料原件
     */
	@TableField("proof_data_file")
	private String proofDataFile;
	private String remark;
    /**
     * 创建人
     */
	@TableField("create_by")
	private Long createBy;
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新人
     */
	@TableField("update_by")
	private Long updateBy;
	@TableField("update_time")
	private Date updateTime;
	private Integer yn;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public String getPledgeBank() {
		return pledgeBank;
	}

	public void setPledgeBank(String pledgeBank) {
		this.pledgeBank = pledgeBank;
	}

	public Date getPledgeTime() {
		return pledgeTime;
	}

	public void setPledgeTime(Date pledgeTime) {
		this.pledgeTime = pledgeTime;
	}

	public Integer getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(Integer loanTerm) {
		this.loanTerm = loanTerm;
	}

	public BigDecimal getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(BigDecimal loanLimit) {
		this.loanLimit = loanLimit;
	}

	public BigDecimal getMonthlySupply() {
		return monthlySupply;
	}

	public void setMonthlySupply(BigDecimal monthlySupply) {
		this.monthlySupply = monthlySupply;
	}

	public String getProofDataFile() {
		return proofDataFile;
	}

	public void setProofDataFile(String proofDataFile) {
		this.proofDataFile = proofDataFile;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getYn() {
		return yn;
	}

	public void setYn(Integer yn) {
		this.yn = yn;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
