public class Tproject extends BaseEntity implements Serializable{

	private String Id;//主键
	private String Code;//项目编号
	private String CompanyId;//公司ID
	private String Name;//项目名称
	private String Title;//副标题
	private String Describe;//项目介绍
	private String Address;//项目地址
	private Double Lon;//经度
	private Double Lat;//纬度
	private Long BusinessDistrict;//项目所属商圈
	private String Region;//项目所属区域
	private Double Area;//项目面积
	private Long BuildingNum;//楼栋数
	private Long CarPortNum;//车位数量
	private String BuildingStructure;//楼体结构
	private Long RoomNum;//房间总数
	private Long HouseTypeNum;//户型数
	private Long PublicArea;//公区面积
	private String ElectricityType;//用电类别
	private String WaterType;//用水类别
	private String CooperationModel;//项目合作模式
	private String OwnerType;//业主类型
	private String OwnerName;//业主
	private String PropertyType;//产权类型
	private Long FinishYear;//建成年代
	private Date ContractBegin;//项目收楼日期
	private Long ContractCycle;//项目租赁年限
	private Date ContractEnd;//项目到期日期
	private Date OpeningTime;//项目开业日期
	private Long VacancyDay;//项目空置总天数
	private String ProjectManager;//项目运营负责人/项目经理
	private String MarketTel;//销售电话
	private String LockType;//门锁类型
	private Integer IsDel;//是否删除

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "fId", unique = true, nullable = false)
	public String getId(){
		this.Id
	}
	public void setId(String Id){
		 this.Id= Id
	}

	@Column(name = "fCode")
	public String getCode(){
		this.Code
	}
	public void setCode(String Code){
		 this.Code= Code
	}

	@Column(name = "fCompanyId")
	public String getCompanyid(){
		this.CompanyId
	}
	public void setCompanyid(String CompanyId){
		 this.CompanyId= CompanyId
	}

	@Column(name = "fName")
	public String getName(){
		this.Name
	}
	public void setName(String Name){
		 this.Name= Name
	}

	@Column(name = "fTitle")
	public String getTitle(){
		this.Title
	}
	public void setTitle(String Title){
		 this.Title= Title
	}

	@Column(name = "fDescribe")
	public String getDescribe(){
		this.Describe
	}
	public void setDescribe(String Describe){
		 this.Describe= Describe
	}

	@Column(name = "fAddress")
	public String getAddress(){
		this.Address
	}
	public void setAddress(String Address){
		 this.Address= Address
	}

	@Column(name = "fLon")
	public Double getLon(){
		this.Lon
	}
	public void setLon(Double Lon){
		 this.Lon= Lon
	}

	@Column(name = "fLat")
	public Double getLat(){
		this.Lat
	}
	public void setLat(Double Lat){
		 this.Lat= Lat
	}

	@Column(name = "fBusinessDistrict")
	public Long getBusinessdistrict(){
		this.BusinessDistrict
	}
	public void setBusinessdistrict(Long BusinessDistrict){
		 this.BusinessDistrict= BusinessDistrict
	}

	@Column(name = "fRegion")
	public String getRegion(){
		this.Region
	}
	public void setRegion(String Region){
		 this.Region= Region
	}

	@Column(name = "fArea")
	public Double getArea(){
		this.Area
	}
	public void setArea(Double Area){
		 this.Area= Area
	}

	@Column(name = "fBuildingNum")
	public Long getBuildingnum(){
		this.BuildingNum
	}
	public void setBuildingnum(Long BuildingNum){
		 this.BuildingNum= BuildingNum
	}

	@Column(name = "fCarPortNum")
	public Long getCarportnum(){
		this.CarPortNum
	}
	public void setCarportnum(Long CarPortNum){
		 this.CarPortNum= CarPortNum
	}

	@Column(name = "fBuildingStructure")
	public String getBuildingstructure(){
		this.BuildingStructure
	}
	public void setBuildingstructure(String BuildingStructure){
		 this.BuildingStructure= BuildingStructure
	}

	@Column(name = "fRoomNum")
	public Long getRoomnum(){
		this.RoomNum
	}
	public void setRoomnum(Long RoomNum){
		 this.RoomNum= RoomNum
	}

	@Column(name = "fHouseTypeNum")
	public Long getHousetypenum(){
		this.HouseTypeNum
	}
	public void setHousetypenum(Long HouseTypeNum){
		 this.HouseTypeNum= HouseTypeNum
	}

	@Column(name = "fPublicArea")
	public Long getPublicarea(){
		this.PublicArea
	}
	public void setPublicarea(Long PublicArea){
		 this.PublicArea= PublicArea
	}

	@Column(name = "fElectricityType")
	public String getElectricitytype(){
		this.ElectricityType
	}
	public void setElectricitytype(String ElectricityType){
		 this.ElectricityType= ElectricityType
	}

	@Column(name = "fWaterType")
	public String getWatertype(){
		this.WaterType
	}
	public void setWatertype(String WaterType){
		 this.WaterType= WaterType
	}

	@Column(name = "fCooperationModel")
	public String getCooperationmodel(){
		this.CooperationModel
	}
	public void setCooperationmodel(String CooperationModel){
		 this.CooperationModel= CooperationModel
	}

	@Column(name = "fOwnerType")
	public String getOwnertype(){
		this.OwnerType
	}
	public void setOwnertype(String OwnerType){
		 this.OwnerType= OwnerType
	}

	@Column(name = "fOwnerName")
	public String getOwnername(){
		this.OwnerName
	}
	public void setOwnername(String OwnerName){
		 this.OwnerName= OwnerName
	}

	@Column(name = "fPropertyType")
	public String getPropertytype(){
		this.PropertyType
	}
	public void setPropertytype(String PropertyType){
		 this.PropertyType= PropertyType
	}

	@Column(name = "fFinishYear")
	public Long getFinishyear(){
		this.FinishYear
	}
	public void setFinishyear(Long FinishYear){
		 this.FinishYear= FinishYear
	}

	@Column(name = "fContractBegin")
	public Date getContractbegin(){
		this.ContractBegin
	}
	public void setContractbegin(Date ContractBegin){
		 this.ContractBegin= ContractBegin
	}

	@Column(name = "fContractCycle")
	public Long getContractcycle(){
		this.ContractCycle
	}
	public void setContractcycle(Long ContractCycle){
		 this.ContractCycle= ContractCycle
	}

	@Column(name = "fContractEnd")
	public Date getContractend(){
		this.ContractEnd
	}
	public void setContractend(Date ContractEnd){
		 this.ContractEnd= ContractEnd
	}

	@Column(name = "fOpeningTime")
	public Date getOpeningtime(){
		this.OpeningTime
	}
	public void setOpeningtime(Date OpeningTime){
		 this.OpeningTime= OpeningTime
	}

	@Column(name = "fVacancyDay")
	public Long getVacancyday(){
		this.VacancyDay
	}
	public void setVacancyday(Long VacancyDay){
		 this.VacancyDay= VacancyDay
	}

	@Column(name = "fProjectManager")
	public String getProjectmanager(){
		this.ProjectManager
	}
	public void setProjectmanager(String ProjectManager){
		 this.ProjectManager= ProjectManager
	}

	@Column(name = "fMarketTel")
	public String getMarkettel(){
		this.MarketTel
	}
	public void setMarkettel(String MarketTel){
		 this.MarketTel= MarketTel
	}

	@Column(name = "fLockType")
	public String getLocktype(){
		this.LockType
	}
	public void setLocktype(String LockType){
		 this.LockType= LockType
	}

	@Column(name = "fIsDel")
	public Integer getIsdel(){
		this.IsDel
	}
	public void setIsdel(Integer IsDel){
		 this.IsDel= IsDel
	}


}public class Tproject extends BaseEntity implements Serializable{

	private String Id;//主键
	private String Code;//项目编号
	private String CompanyId;//公司ID
	private String Name;//项目名称
	private String Title;//副标题
	private String Describe;//项目介绍
	private String Address;//项目地址
	private Double Lon;//经度
	private Double Lat;//纬度
	private Long BusinessDistrict;//项目所属商圈
	private String Region;//项目所属区域
	private Double Area;//项目面积
	private Long BuildingNum;//楼栋数
	private Long CarPortNum;//车位数量
	private String BuildingStructure;//楼体结构
	private Long RoomNum;//房间总数
	private Long HouseTypeNum;//户型数
	private Long PublicArea;//公区面积
	private String ElectricityType;//用电类别
	private String WaterType;//用水类别
	private String CooperationModel;//项目合作模式
	private String OwnerType;//业主类型
	private String OwnerName;//业主
	private String PropertyType;//产权类型
	private Long FinishYear;//建成年代
	private Date ContractBegin;//项目收楼日期
	private Long ContractCycle;//项目租赁年限
	private Date ContractEnd;//项目到期日期
	private Date OpeningTime;//项目开业日期
	private Long VacancyDay;//项目空置总天数
	private String ProjectManager;//项目运营负责人/项目经理
	private String MarketTel;//销售电话
	private String LockType;//门锁类型
	private Integer IsDel;//是否删除

	@GenericGenerator(name = "generator", strategy = "uuid")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "fId", unique = true, nullable = false)
	public String getId(){
		this.Id
	}
	public void setId(String Id){
		 this.Id= Id
	}

	@Column(name = "fCode")
	public String getCode(){
		this.Code
	}
	public void setCode(String Code){
		 this.Code= Code
	}

	@Column(name = "fCompanyId")
	public String getCompanyid(){
		this.CompanyId
	}
	public void setCompanyid(String CompanyId){
		 this.CompanyId= CompanyId
	}

	@Column(name = "fName")
	public String getName(){
		this.Name
	}
	public void setName(String Name){
		 this.Name= Name
	}

	@Column(name = "fTitle")
	public String getTitle(){
		this.Title
	}
	public void setTitle(String Title){
		 this.Title= Title
	}

	@Column(name = "fDescribe")
	public String getDescribe(){
		this.Describe
	}
	public void setDescribe(String Describe){
		 this.Describe= Describe
	}

	@Column(name = "fAddress")
	public String getAddress(){
		this.Address
	}
	public void setAddress(String Address){
		 this.Address= Address
	}

	@Column(name = "fLon")
	public Double getLon(){
		this.Lon
	}
	public void setLon(Double Lon){
		 this.Lon= Lon
	}

	@Column(name = "fLat")
	public Double getLat(){
		this.Lat
	}
	public void setLat(Double Lat){
		 this.Lat= Lat
	}

	@Column(name = "fBusinessDistrict")
	public Long getBusinessdistrict(){
		this.BusinessDistrict
	}
	public void setBusinessdistrict(Long BusinessDistrict){
		 this.BusinessDistrict= BusinessDistrict
	}

	@Column(name = "fRegion")
	public String getRegion(){
		this.Region
	}
	public void setRegion(String Region){
		 this.Region= Region
	}

	@Column(name = "fArea")
	public Double getArea(){
		this.Area
	}
	public void setArea(Double Area){
		 this.Area= Area
	}

	@Column(name = "fBuildingNum")
	public Long getBuildingnum(){
		this.BuildingNum
	}
	public void setBuildingnum(Long BuildingNum){
		 this.BuildingNum= BuildingNum
	}

	@Column(name = "fCarPortNum")
	public Long getCarportnum(){
		this.CarPortNum
	}
	public void setCarportnum(Long CarPortNum){
		 this.CarPortNum= CarPortNum
	}

	@Column(name = "fBuildingStructure")
	public String getBuildingstructure(){
		this.BuildingStructure
	}
	public void setBuildingstructure(String BuildingStructure){
		 this.BuildingStructure= BuildingStructure
	}

	@Column(name = "fRoomNum")
	public Long getRoomnum(){
		this.RoomNum
	}
	public void setRoomnum(Long RoomNum){
		 this.RoomNum= RoomNum
	}

	@Column(name = "fHouseTypeNum")
	public Long getHousetypenum(){
		this.HouseTypeNum
	}
	public void setHousetypenum(Long HouseTypeNum){
		 this.HouseTypeNum= HouseTypeNum
	}

	@Column(name = "fPublicArea")
	public Long getPublicarea(){
		this.PublicArea
	}
	public void setPublicarea(Long PublicArea){
		 this.PublicArea= PublicArea
	}

	@Column(name = "fElectricityType")
	public String getElectricitytype(){
		this.ElectricityType
	}
	public void setElectricitytype(String ElectricityType){
		 this.ElectricityType= ElectricityType
	}

	@Column(name = "fWaterType")
	public String getWatertype(){
		this.WaterType
	}
	public void setWatertype(String WaterType){
		 this.WaterType= WaterType
	}

	@Column(name = "fCooperationModel")
	public String getCooperationmodel(){
		this.CooperationModel
	}
	public void setCooperationmodel(String CooperationModel){
		 this.CooperationModel= CooperationModel
	}

	@Column(name = "fOwnerType")
	public String getOwnertype(){
		this.OwnerType
	}
	public void setOwnertype(String OwnerType){
		 this.OwnerType= OwnerType
	}

	@Column(name = "fOwnerName")
	public String getOwnername(){
		this.OwnerName
	}
	public void setOwnername(String OwnerName){
		 this.OwnerName= OwnerName
	}

	@Column(name = "fPropertyType")
	public String getPropertytype(){
		this.PropertyType
	}
	public void setPropertytype(String PropertyType){
		 this.PropertyType= PropertyType
	}

	@Column(name = "fFinishYear")
	public Long getFinishyear(){
		this.FinishYear
	}
	public void setFinishyear(Long FinishYear){
		 this.FinishYear= FinishYear
	}

	@Column(name = "fContractBegin")
	public Date getContractbegin(){
		this.ContractBegin
	}
	public void setContractbegin(Date ContractBegin){
		 this.ContractBegin= ContractBegin
	}

	@Column(name = "fContractCycle")
	public Long getContractcycle(){
		this.ContractCycle
	}
	public void setContractcycle(Long ContractCycle){
		 this.ContractCycle= ContractCycle
	}

	@Column(name = "fContractEnd")
	public Date getContractend(){
		this.ContractEnd
	}
	public void setContractend(Date ContractEnd){
		 this.ContractEnd= ContractEnd
	}

	@Column(name = "fOpeningTime")
	public Date getOpeningtime(){
		this.OpeningTime
	}
	public void setOpeningtime(Date OpeningTime){
		 this.OpeningTime= OpeningTime
	}

	@Column(name = "fVacancyDay")
	public Long getVacancyday(){
		this.VacancyDay
	}
	public void setVacancyday(Long VacancyDay){
		 this.VacancyDay= VacancyDay
	}

	@Column(name = "fProjectManager")
	public String getProjectmanager(){
		this.ProjectManager
	}
	public void setProjectmanager(String ProjectManager){
		 this.ProjectManager= ProjectManager
	}

	@Column(name = "fMarketTel")
	public String getMarkettel(){
		this.MarketTel
	}
	public void setMarkettel(String MarketTel){
		 this.MarketTel= MarketTel
	}

	@Column(name = "fLockType")
	public String getLocktype(){
		this.LockType
	}
	public void setLocktype(String LockType){
		 this.LockType= LockType
	}

	@Column(name = "fIsDel")
	public Integer getIsdel(){
		this.IsDel
	}
	public void setIsdel(Integer IsDel){
		 this.IsDel= IsDel
	}


}