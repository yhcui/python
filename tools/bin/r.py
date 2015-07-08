#!D:\\Python27
#coding=gbk
import zipfile
import sys;
import os;
import shutil;
import datetime
import MySQLdb
import sys

reload(sys)
sys.setdefaultencoding( "utf-8" )

print sys.getdefaultencoding();

#定义对象包括 java字段名，java类型，注释，mysql字段名,
#连接数据库 -获取数据库信息
#创建类文件
#写开头文件
#生成变量数据
#生成构造函数
#生成get 和set
#写结尾文件

#定义全局变量
global OUTDIR;

def prepare():
    global OUTDIR;
    
    binpath = os.getcwd();
    pardir =  os.path.pardir;
    OUTDIR = pardir+"\\gen";
    print binpath;
    print pardir;

def getTableInfo(dbName,tableName):
    #连接数据库
    conn=MySQLdb.connect(host="172.16.13.201",user="zra",passwd="ziroom",db=dbName,charset="utf8")
     
    cursor = conn.cursor ( cursorclass = MySQLdb . cursors . DictCursor )
    
    query = 'show full columns from  ' +tableName;
    try:
        cursor.execute(query);
        
        #for value in cursor:
        #    print value['Field'];
        #    print value['Key'];
        #    print value['Type'];
        #    print '-----';
        #print 'Hello'
        return cursor;
    except:
        print 'except'
    finally:
        conn.close();


    

    
        

def getClassNameByTableName(tableName):
    if tableName.startswith('f'):
        tableName = tableName[1:];
        
    return tableName.capitalize();

def getClassHeader(className,dbName,tableName):
    str = '@Entity\n'
    str += '@Table(name = "'+tableName+'", catalog = "'+dbName+'")\n'
    str += "public class "+ className +" extends BaseEntity implements Serializable{\n";
    return str;

def conMysqlToJava(tableInfo):
    fieldList =[];
    for value in tableInfo:
        mysqlTypeInfoDic = getMysqlTypeInfo(value['Type']);
        javaFieldType = getJavaFieldTypeFromMysqlType(mysqlTypeInfoDic);
        javaFieldName = getJavaFieldNameFromMysqlName(value['Field']);
        javaMethodName =getJavaMethodName(javaFieldName);
        print value['Comment'];
        javaFileld={'javaMethodName':javaMethodName,'javaField':javaFieldName,'javaFieldType':javaFieldType,'comment':value['Comment'],'mysqlField':value['Field'],'key':value['Key']};
        fieldList.append(javaFileld);

    return fieldList;
    

def getMysqlTypeInfo(mysqlType):
    
    mysqlTypeList = mysqlType.split();
    mysqlTypeLen = '0';
    mysqlTypeStr = '';
    if mysqlTypeList[0].find("(") >0:
        mysqlTypeLen = mysqlTypeList[0].split("(")[1].split(")")[0];
        mysqlTypeStr = mysqlTypeList[0].split("(")[0];
    else:
        mysqlTypeStr = mysqlTypeList[0];
    
    mysqlTypeDic ={'mysqlTypeStr':mysqlTypeStr,'mysqlTypeLen':mysqlTypeLen};
    return  mysqlTypeDic;

def getJavaFieldTypeFromMysqlType(mysqlTypeInfoDic):
    mysqlTypeStr = mysqlTypeInfoDic['mysqlTypeStr'];
    mysqlTypeStr = mysqlTypeStr.lower();
    if 'varchar'== mysqlTypeStr or 'char'== mysqlTypeStr or 'text'== mysqlTypeStr:
        return 'String';
    elif 'blob'== mysqlTypeStr:
        return 'byte[]';
    elif 'double'== mysqlTypeStr:
        return 'Double';
    elif 'float'== mysqlTypeStr:
        return 'Float';
    elif 'int'== mysqlTypeStr or 'integer'== mysqlTypeStr:
        return 'Long';
    elif 'date'== mysqlTypeStr:
        return 'Date';
    elif 'time'== mysqlTypeStr:
        return 'Time';
    elif 'datetime'== mysqlTypeStr or 'timestamp'== mysqlTypeStr:
        return 'Timestamp'
    elif 'year'== mysqlTypeStr:
        return 'Date';
    elif 'tinyint'== mysqlTypeStr or 'smallint'== mysqlTypeStr or 'mediumint'== mysqlTypeStr or 'boolean'== mysqlTypeStr:
        return 'Integer';
    elif 'bigint'== mysqlTypeStr:
        return 'BigInteger';
    elif 'decimal'== mysqlTypeStr:
        return 'BigDecimal'
    else:
        return 'ERROR';
def getJavaMethodName(javaFieldName):
    temp = javaFieldName[0:1]
    return temp.capitalize()+javaFieldName[1:];

def getJavaFieldNameFromMysqlName(mysqlFieldName):

    javaFieldName='';
    if mysqlFieldName.startswith('f'):
        mysqlFieldName = mysqlFieldName[1:];
        
    
    str_list = mysqlFieldName.split('_');
    if len(str_list) > 1:
        for index in range(1, len(str_list)):
             if str_list[index] != '':
                 str_list[index] = str_list[index].capitalize();
             else:
                 continue
             javaFieldName =''.join(str_list);
    else:
         javaFieldName = mysqlFieldName;
    return javaFieldName;     
         
    
def getDefFieldStr(fieldList):
    str='';
    for field in fieldList:
        str +='\tprivate '+field['javaFieldType'] +' '+field['javaField'] +';//'+field['comment']+'\n';
    return str;

def getDefMethodStr(fieldList,tableName):
    str='';
    for field in fieldList:
        if field['key']=='PRI':
            str +='\t@GenericGenerator(name = "generator", strategy = "uuid")\n'
            str +='\t@Id\n';
            str +='\t@GeneratedValue(generator = "generator")\n';
            str +='\t@Column(name = "'+field['mysqlField']+'", unique = true, nullable = false)\n';
        else:
            str +='\t@Column(name = "'+field['mysqlField']+'")\n';
        
        str +='\tpublic '+field['javaFieldType']+' get'+field['javaMethodName']+'(){\n';
        str +='\t\treturn this.'+field['javaField']+';\n';
        str +='\t}\n';
        str +='\tpublic void set'+field['javaMethodName'] +"("+ field['javaFieldType']+' '+field['javaField']+"){\n";
        str +='\t\t this.'+field['javaField'] +'= '+field['javaField']+';\n';
        str +="\t}\n\n"
        
    return str;

#dbName = "test";
#tableName = "user"
dbName = "zra";
tableName = "treconitemsoperatehis"
testvar = 'testVar'
print getJavaMethodName(testvar)

prepare();
print OUTDIR;
className = getClassNameByTableName(tableName)
classFilePath = OUTDIR+"\\"+className+".java";

if os.path.exists(classFilePath) :
    print 'exist';

f=open(classFilePath,'a');
tableInfo = getTableInfo(dbName,tableName);

str = getClassHeader(className,dbName,tableName)
f.write(str);
str ='\n';
f.write(str);

fieldList = conMysqlToJava(tableInfo);
str = getDefFieldStr(fieldList);
f.write(str);
str ='\n'
f.write(str);


str = getDefMethodStr(fieldList,tableName);
f.write(str);
str ='\n'
f.write(str);

str = "}";
f.write(str);


f.close();
print 'SUCCESS'



