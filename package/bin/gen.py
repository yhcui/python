#!D:\\Python27
#coding=gbk
import zipfile
import sys;
import os;
import shutil;
import datetime



def prepare():
    
    print 'start package'

    binpath = os.getcwd();

    pardir =  os.path.pardir;

    sourcepath=pardir+"\\apk";

    listfiles = os.listdir(sourcepath);

    for ff in listfiles :
        extname = os.path.splitext(ff)[1]
        if  extname == '.apk':
            os.rename(sourcepath+"\\"+ff,sourcepath+"\\"+"class.zip");
        elif extname == '.jar':
            os.rename(sourcepath+"\\"+ff,sourcepath+"\\"+"Syslib.jar");
        else:
            print "SB!"
            



    #deal zip
    os.chdir(pardir +"\\apk");

    os.system("7z d class.zip -x!classes.dex -r");
    os.rename(sourcepath+"\\"+"class.zip",sourcepath+"\\"+"class.apk");

    os.chdir(pardir);

    temapkpath = os.getcwd()+"\\template\\sys_lib\\assets";
    temjarpath = os.getcwd()+"\\template\\sys_lib\\libs";

    print temapkpath;
    print temjarpath;

    # remove
    if os.path.exists(temapkpath+"\\class.apk") :
        os.remove(temapkpath+"\\class.apk");
    if os.path.exists(temjarpath+"\\Syslib.jar") :
        os.remove(temjarpath+"\\Syslib.jar");

    #copy

    shutil.copyfile(os.getcwd()+"\\apk\\class.apk", temapkpath+"\\class.apk");
    shutil.copyfile(os.getcwd()+"\\apk\\Syslib.jar", temjarpath+"\\Syslib.jar");

    #
    

def zipsdk(version):
    
    pardir =   os.getcwd();
    tempfold = pardir+"\\template";
    print tempfold;
    os.chdir(tempfold);
    today =datetime.date.today()
    ISOFORMAT='%Y.%m.%d'
    

    zipfile = "新银河支付-net_v"+version+"-正式版本-"+today.strftime(ISOFORMAT)+".zip";
    os.system("7z a "+zipfile+" * -r");
    if os.path.exists(pardir+"\\gen\\"+zipfile) :
        os.remove(pardir+"\\gen\\"+zipfile);
    shutil.copyfile(zipfile, pardir+"\\gen\\"+zipfile);
    os.remove(zipfile);

version = "X";
if len(sys.argv)>1:
    version = sys.argv[1];
print version;
prepare();
#pardir =  os.path.pardir;
#os.chdir(pardir);
zipsdk(version);

print 'end package'





