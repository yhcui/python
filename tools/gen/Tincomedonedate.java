@Entity
@Table(name = "tincomedonedate", catalog = "zra")
public class Tincomedonedate extends BaseEntity implements Serializable{

	private String id;//自增id
	private String incomePlanId;//收入计划id
	private String incomeOperatorId;//确认人
	private Date incomeDoneDate;//确认收入日期
	private Date incomeCreateDate;//创建日期
	private Integer isdel;//是否删除0:未删除;1删除

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

	@Column(name = "fincome_operator_id")
	public String getIncomeOperatorId(){
		return this.incomeOperatorId;
	}
	public void setIncomeOperatorId(String incomeOperatorId){
		 this.incomeOperatorId= incomeOperatorId;
	}

	@Column(name = "fincome_done_date")
	public Date getIncomeDoneDate(){
		return this.incomeDoneDate;
	}
	public void setIncomeDoneDate(Date incomeDoneDate){
		 this.incomeDoneDate= incomeDoneDate;
	}

	@Column(name = "fincome_create_date")
	public Date getIncomeCreateDate(){
		return this.incomeCreateDate;
	}
	public void setIncomeCreateDate(Date incomeCreateDate){
		 this.incomeCreateDate= incomeCreateDate;
	}

	@Column(name = "fisdel")
	public Integer getIsdel(){
		return this.isdel;
	}
	public void setIsdel(Integer isdel){
		 this.isdel= isdel;
	}


}