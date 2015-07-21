#!D:\\Python27
#coding=gbk
import zipfile
import sys;
import os;
import shutil;
import datetime


def decode(apk,outdir):
    if os.path.exists("../out/"+outdir):
         print "WARNING !!! ../out/"+outdir +" exist ";
    else:
        os.system("java -jar apktool.jar d -f  ../apk/"+apk+"  -o ../out/"+outdir);
    
def writechannel(ch,outdir):
    chanenelf = file("../out/"+outdir+"/assets/sys_channel.ng","wt");
    try:
        chanenelf.write(ch);
    finally :
        chanenelf.close();
        
    
def encode(channel,apk,outdir):
    os.system("java -jar apktool.jar b -f ../out/"+outdir+" -o ../gen/"+channel+"/"+apk);
    
def pack(op,channel,apk):
    outdir =  channel+"/"+apk.split(".")[0];
    if op == 'd' or op == 'e':
        decode(apk,outdir);
        if op == 'e':
            writechannel(channel,outdir);
            encode(channel,apk,outdir);
            sign(channel,apk);
        comp('JOB DONE!');
    else:
        comp('PARAMTER ERROR');
    
def sign(channel,apk):
    os.system("jarsigner -sigalg SHA1withRSA -digestalg SHA1 -keystore ../sign/keystore.key -keypass xyh5a1407 -storepass xyh5a1407 ../gen/"+channel+"/"+apk+"  keystore.key");
    print 'ok';
    
def comp(ti):
    print '\033[1;31;40m'
    print ti;
    print '\033[0m'
    
    


channels="";
apks="";
op = "";
if len(sys.argv)>1:
    op = sys.argv[1];
    if len(sys.argv)>2:
        apks = sys.argv[2].split(",");
    else:
        apks = os.listdir("../apk/");
    if len(sys.argv)>2:
        channels = sys.argv[3].split(",");
    else:
        channels=['ngsteamtest1'];
    for channel in channels:
        for apk in apks:
            pack(op,channel,apk);
        
    
else:
    print 'options:';
    print '\td';
    print '\t  decompile apk';
    print '\te';
    print '\t  recompile apk';

#print os.path.exists("../out/ngsteam/ngsteam001_yinghuafeipaopaolong_1014_V2") 




