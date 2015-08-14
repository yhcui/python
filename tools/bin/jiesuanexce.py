#!D:\\Python27
#coding=gbk
import zipfile
import sys;
import os;
import shutil;
import datetime
import MySQLdb
import sys
import xlrd

reload(sys)
sys.setdefaultencoding( "utf-8" )

print sys.getdefaultencoding();

def getFsettleSql(rowIndex,table):
	settMap = {u'POS机':'0',u'收款卡':'1',u'现金':'2',u'支票':'4',u'在线支付':'6',u'转款':'7',u'网银':'3',u'银行汇款':'5',u'优惠活动':'8',u'银联在线支付':'9',u'银联移动支付':'10',u'微信平台支付':'11'};
	sql ="INSERT INTO `tfinsettle` (`fid`, `fsettle_code`, `fsettle_name`, `fsettle_type`, `fbank_name`, `fbank_no`, `fafa_subject`, `fafa_sub_subject`, `fafa_code`, `fallow_hand`, `fis_recon`, `fis_settlet`, `fis_afa`, `fvalid`, `fcreate_time`, `fcreater_id`, `fupdate_time`, `fupdater_id`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, NULL, NULL, '2015-8-12 09:39:12', '1');";
	sqlsource = "INSERT INTO `tsettlesource` (`fid`, `ffinsettle_id`, `fsettle_source_code`, `fsettle_source_name`, `fisdel`, `fcreate_time`, `fcreater_id`, `fupdate_time`, `fupdater_id`, `cityid`) VALUES ('%s', '%s', '%s', '%s', 0, '2015-7-23 14:19:10', '1', '2015-7-23 14:49:46', '1', '10001');";
	id='';#主键ID
	settleCode='';#结算方式类别
	settleName='';#结算方式名称
	settleType='';#结算类型 @see SettleTypeEnum
	bankName='';#银行名称
	bankNo='';#银行卡号
	afaSubject='';#afa科目段
	afaSubSubject='';#afa子科目段
	afaCode='';#afa代码
	allowHand='0';#允许手工录入0否;1是
	isRecon='0';#是否对账0否;1是
	isSettlet='0';#是否结算0否;1是
	isAfa='0';#是否传afa;0否;1是
	valid='1';#是否启用;0否;1是
	settle_source_code='';
	settle_source_name='';
	ncols = table.ncols;
	for j in range(ncols):
		value =table.cell(rowIndex,j).value;

		trueV = "0";
		if ""== value:
			trueV="1"

		#if j== 0:#类型
		#	print 'dd'
		if j== 1:#结算方式代码
		#	print value;
			id=settMap[value];
			settleCode=settMap[value];
		if j== 2:#结算方式名称
			settleName=value
		if j== 3:#银行名称
			bankName=value
		if j== 4:#银行账号
			bankNo=value
		if j== 5:#允许手工录入
			allowHand = trueV
		if j== 6:#是否对账
			isRecon = trueV
		if j== 7:#是否结算
			isSettlet = trueV
		if j== 8:#是否传AFA
			isAfa = trueV
		if j== 9:#结算来源代码
			settle_source_code=value;
		if j== 10:#结算来源名称
			settle_source_name=value;
	tt=sql%(id,settleCode,settleName,settleType,bankName,bankNo,afaSubject,afaSubSubject,afaCode,allowHand,isRecon,isSettlet,isAfa,valid);
	tt = tt +sqlsource%(id,id,settle_source_code,settle_source_name)
	return tt;
excelName = 'jiesuan.xlsx';
data =  xlrd.open_workbook(excelName);
table = data.sheets()[0];
nrows = table.nrows;
for i in range(nrows):
	tt = getFsettleSql(i,table)
	print tt;

print 'END'




