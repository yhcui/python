@Entity
@Table(name = "tincomeperiod", catalog = "zra")
public class Tincomeperiod extends BaseEntity implements Serializable{

	private String id;//期间Id
	private String periodName;//期间名称
	private Integer periodYear;//年度
	private Date startDate;//开始日期
	private Date endDate;//结束日期
	private Integer isAdjust;//调整 1是0否
	private Integer valid;//启用 1是0否
	private Integer isDel;//是否删除 1是0否
	private String city;//全国化预留字段
	private Date createTime;//创建时间
	private String createrId;//创建ID
	private Date updateTime;//更新时间
	private String updaterId;//修改ID

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

	@Column(name = "fperiod_name")
	public String getPeriodName(){
		return this.periodName;
	}
	public void setPeriodName(String periodName){
		 this.periodName= periodName;
	}

	@Column(name = "fperiod_year")
	public Integer getPeriodYear(){
		return this.periodYear;
	}
	public void setPeriodYear(Integer periodYear){
		 this.periodYear= periodYear;
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

	@Column(name = "fis_adjust")
	public Integer getIsAdjust(){
		return this.isAdjust;
	}
	public void setIsAdjust(Integer isAdjust){
		 this.isAdjust= isAdjust;
	}

	@Column(name = "fvalid")
	public Integer getValid(){
		return this.valid;
	}
	public void setValid(Integer valid){
		 this.valid= valid;
	}

	@Column(name = "fis_del")
	public Integer getIsDel(){
		return this.isDel;
	}
	public void setIsDel(Integer isDel){
		 this.isDel= isDel;
	}

	@Column(name = "fcity")
	public String getCity(){
		return this.city;
	}
	public void setCity(String city){
		 this.city= city;
	}

	@Column(name = "fcreate_time")
	public Date getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(Date createTime){
		 this.createTime= createTime;
	}

	@Column(name = "creater_id")
	public String getCreaterId(){
		return this.createrId;
	}
	public void setCreaterId(String createrId){
		 this.createrId= createrId;
	}

	@Column(name = "fupdate_time")
	public Date getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(Date updateTime){
		 this.updateTime= updateTime;
	}

	@Column(name = "updater_id")
	public String getUpdaterId(){
		return this.updaterId;
	}
	public void setUpdaterId(String updaterId){
		 this.updaterId= updaterId;
	}


}