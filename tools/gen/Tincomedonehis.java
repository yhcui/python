@Entity
@Table(name = "tincomedonehis", catalog = "zra")
public class Tincomedonehis extends BaseEntity implements Serializable{

	private String id;//操作记录Id
	private String incomePlanId;//收入计划id
	private String operatorId;//操作人
	private Date createTime;//操作日期
	private Date affirmTime;//确认日期
	private Date affirmAmount;//确认金额
	private String afaNo;//AFA关联号
	private Integer state;//状态
	private String remark;//说明
	private Integer valid;//有效 1是0否
	private Integer isDel;//是否删除 1是0否
	private String city;//全国化预留字段

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

	@Column(name = "fincome_plan_id")
	public String getIncomePlanId(){
		return this.incomePlanId;
	}
	public void setIncomePlanId(String incomePlanId){
		 this.incomePlanId= incomePlanId;
	}

	@Column(name = "foperator_id")
	public String getOperatorId(){
		return this.operatorId;
	}
	public void setOperatorId(String operatorId){
		 this.operatorId= operatorId;
	}

	@Column(name = "fcreate_time")
	public Date getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(Date createTime){
		 this.createTime= createTime;
	}

	@Column(name = "faffirm_time")
	public Date getAffirmTime(){
		return this.affirmTime;
	}
	public void setAffirmTime(Date affirmTime){
		 this.affirmTime= affirmTime;
	}

	@Column(name = "faffirm_amount")
	public Date getAffirmAmount(){
		return this.affirmAmount;
	}
	public void setAffirmAmount(Date affirmAmount){
		 this.affirmAmount= affirmAmount;
	}

	@Column(name = "fafa_no")
	public String getAfaNo(){
		return this.afaNo;
	}
	public void setAfaNo(String afaNo){
		 this.afaNo= afaNo;
	}

	@Column(name = "fstate")
	public Integer getState(){
		return this.state;
	}
	public void setState(Integer state){
		 this.state= state;
	}

	@Column(name = "fremark")
	public String getRemark(){
		return this.remark;
	}
	public void setRemark(String remark){
		 this.remark= remark;
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


}