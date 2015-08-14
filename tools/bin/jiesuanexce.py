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
	settMap = {u'POS��':'0',u'�տ':'1',u'�ֽ�':'2',u'֧Ʊ':'4',u'����֧��':'6',u'ת��':'7',u'����':'3',u'���л��':'5',u'�Żݻ':'8',u'��������֧��':'9',u'�����ƶ�֧��':'10',u'΢��ƽ̨֧��':'11'};
	sql ="INSERT INTO `tfinsettle` (`fid`, `fsettle_code`, `fsettle_name`, `fsettle_type`, `fbank_name`, `fbank_no`, `fafa_subject`, `fafa_sub_subject`, `fafa_code`, `fallow_hand`, `fis_recon`, `fis_settlet`, `fis_afa`, `fvalid`, `fcreate_time`, `fcreater_id`, `fupdate_time`, `fupdater_id`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s, %s, %s, %s, %s, NULL, NULL, '2015-8-12 09:39:12', '1');";
	sqlsource = "INSERT INTO `tsettlesource` (`fid`, `ffinsettle_id`, `fsettle_source_code`, `fsettle_source_name`, `fisdel`, `fcreate_time`, `fcreater_id`, `fupdate_time`, `fupdater_id`, `cityid`) VALUES ('%s', '%s', '%s', '%s', 0, '2015-7-23 14:19:10', '1', '2015-7-23 14:49:46', '1', '10001');";
	id='';#����ID
	settleCode='';#���㷽ʽ���
	settleName='';#���㷽ʽ����
	settleType='';#�������� @see SettleTypeEnum
	bankName='';#��������
	bankNo='';#���п���
	afaSubject='';#afa��Ŀ��
	afaSubSubject='';#afa�ӿ�Ŀ��
	afaCode='';#afa����
	allowHand='0';#�����ֹ�¼��0��;1��
	isRecon='0';#�Ƿ����0��;1��
	isSettlet='0';#�Ƿ����0��;1��
	isAfa='0';#�Ƿ�afa;0��;1��
	valid='1';#�Ƿ�����;0��;1��
	settle_source_code='';
	settle_source_name='';
	ncols = table.ncols;
	for j in range(ncols):
		value =table.cell(rowIndex,j).value;

		trueV = "0";
		if ""== value:
			trueV="1"

		#if j== 0:#����
		#	print 'dd'
		if j== 1:#���㷽ʽ����
		#	print value;
			id=settMap[value];
			settleCode=settMap[value];
		if j== 2:#���㷽ʽ����
			settleName=value
		if j== 3:#��������
			bankName=value
		if j== 4:#�����˺�
			bankNo=value
		if j== 5:#�����ֹ�¼��
			allowHand = trueV
		if j== 6:#�Ƿ����
			isRecon = trueV
		if j== 7:#�Ƿ����
			isSettlet = trueV
		if j== 8:#�Ƿ�AFA
			isAfa = trueV
		if j== 9:#������Դ����
			settle_source_code=value;
		if j== 10:#������Դ����
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




