@Entity
@Table(name = "tincomeplan", catalog = "zra")
public class Tincomeplan extends BaseEntity implements Serializable{

	private String id;//收入计划Id
	private String batchNo;//批号
	private String projectName;//项目名称
	private String contractId;//合同Id
	private Integer planType;//性质
	private Integer fundType;//款项类型
	private Integer affirmType;//确认类型
	private BigDecimal conMonthRent;//月租金 数据库修改合同月租金留痕
	private String periodId;//关联期间Id tincomeperiod
	private Date startDate;//开始日期
	private Date endDate;//结束日期
	private Integer totalDays;//合计天数
	private BigDecimal dayRent;//均天单价
	private BigDecimal balance;//余额
	private BigDecimal totalAmount;//合计金额
	private Integer affirmDays;//已确认天数
	private BigDecimal affirmAmount;//已确认金额
	private String afaNo;//AFA关联号
	private String source;//来源
	private Integer valid;//有效 1是0否
	private Integer isdel;//是否删除 1是0否
	private String city;//全国化预留字段
	private Date createtime;//创建时间
	private String createrid;//创建ID
	private Date updatetime;//更新时间
	private String updaterid;//修改ID

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "fid", unique = true, nullable = false)
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		 this.id= id;
	}

	@Column(name = "fbatch_no")
	public String getBatchNo(){
		return this.batchNo;
	}
	public void setBatchNo(String batchNo){
		 this.batchNo= batchNo;
	}

	@Column(name = "fproject_name")
	public String getProjectName(){
		return this.projectName;
	}
	public void setProjectName(String projectName){
		 this.projectName= projectName;
	}

	@Column(name = "fcontract_id")
	public String getContractId(){
		return this.contractId;
	}
	public void setContractId(String contractId){
		 this.contractId= contractId;
	}

	@Column(name = "fplan_type")
	public Integer getPlanType(){
		return this.planType;
	}
	public void setPlanType(Integer planType){
		 this.planType= planType;
	}

	@Column(name = "ffund_type")
	public Integer getFundType(){
		return this.fundType;
	}
	public void setFundType(Integer fundType){
		 this.fundType= fundType;
	}

	@Column(name = "faffirm_type")
	public Integer getAffirmType(){
		return this.affirmType;
	}
	public void setAffirmType(Integer affirmType){
		 this.affirmType= affirmType;
	}

	@Column(name = "fcon_month_rent")
	public BigDecimal getConMonthRent(){
		return this.conMonthRent;
	}
	public void setConMonthRent(BigDecimal conMonthRent){
		 this.conMonthRent= conMonthRent;
	}

	@Column(name = "fperiod_id")
	public String getPeriodId(){
		return this.periodId;
	}
	public void setPeriodId(String periodId){
		 this.periodId= periodId;
	}

	@Column(name = "fstart_date")
	public Date getStartDate(){
		return this.startDate;
	}
	public void setStartDate(Date startDate){
		 this.startDate= startDate;
	}

	@Column(name = "fend_date")
	public Date getEndDate(){
		return this.endDate;
	}
	public void setEndDate(Date endDate){
		 this.endDate= endDate;
	}

	@Column(name = "ftotal_days")
	public Integer getTotalDays(){
		return this.totalDays;
	}
	public void setTotalDays(Integer totalDays){
		 this.totalDays= totalDays;
	}

	@Column(name = "fday_rent")
	public BigDecimal getDayRent(){
		return this.dayRent;
	}
	public void setDayRent(BigDecimal dayRent){
		 this.dayRent= dayRent;
	}

	@Column(name = "fbalance")
	public BigDecimal getBalance(){
		return this.balance;
	}
	public void setBalance(BigDecimal balance){
		 this.balance= balance;
	}

	@Column(name = "ftotal_amount")
	public BigDecimal getTotalAmount(){
		return this.totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount){
		 this.totalAmount= totalAmount;
	}

	@Column(name = "faffirm_days")
	public Integer getAffirmDays(){
		return this.affirmDays;
	}
	public void setAffirmDays(Integer affirmDays){
		 this.affirmDays= affirmDays;
	}

	@Column(name = "faffirm_amount")
	public BigDecimal getAffirmAmount(){
		return this.affirmAmount;
	}
	public void setAffirmAmount(BigDecimal affirmAmount){
		 this.affirmAmount= affirmAmount;
	}

	@Column(name = "fafa_no")
	public String getAfaNo(){
		return this.afaNo;
	}
	public void setAfaNo(String afaNo){
		 this.afaNo= afaNo;
	}

	@Column(name = "fsource")
	public String getSource(){
		return this.source;
	}
	public void setSource(String source){
		 this.source= source;
	}

	@Column(name = "fvalid")
	public Integer getValid(){
		return this.valid;
	}
	public void setValid(Integer valid){
		 this.valid= valid;
	}

	@Column(name = "fisdel")
	public Integer getIsdel(){
		return this.isdel;
	}
	public void setIsdel(Integer isdel){
		 this.isdel= isdel;
	}

	@Column(name = "fcity")
	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		 this.city= city;
	}

	@Column(name = "fcreatetime")
	public Date getCreatetime(){
		return this.createtime;
	}
	public void setCreatetime(Date createtime){
		 this.createtime= createtime;
	}

	@Column(name = "createrid")
	public String getCreaterid(){
		return this.createrid;
	}
	public void setCreaterid(String createrid){
		 this.createrid= createrid;
	}

	@Column(name = "fupdatetime")
	public Date getUpdatetime(){
		return this.updatetime;
	}
	public void setUpdatetime(Date updatetime){
		 this.updatetime= updatetime;
	}

	@Column(name = "updaterid")
	public String getUpdaterid(){
		return this.updaterid;
	}
	public void setUpdaterid(String updaterid){
		 this.updaterid= updaterid;
	}


}