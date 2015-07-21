package com.xinyinhe.demo;

import com.android.port.SynMsgCore;
import com.android.sys.SysCallbackListener;
import com.android.sys.SysPlatform;
import com.android.sys.SysStatusCode;
import com.android.sys.item.SysAccount;
import com.android.sys.item.SysAppInfo;
import com.android.sys.item.SysInfo;
import com.android.syss.BackAppInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import com.xinyinhe.demo34.R;



public class Demo extends Activity
{
    private Button                                    mLoginButton;
    private Button                                    mOtherLoginButton;
    private Button                                    mBindGuestButton;
    private Button                                    mBindPhoneNumButton;
    private Button                                    mGuestLoginButton;
    private Button                                    mLogoutButton;
    private Button                                    mVolpayButton;
    
    private MainOnClickListener                       mListen;
    private SysCallbackListener<SysAccount>   mLoginListener;
    private SysCallbackListener<SysAccount>   mLoginGuestListener;
    private SysCallbackListener<SysAccount>   mLogoutListener;
    private SysCallbackListener<SysAccount>   mBindGuestListener;
    private SysCallbackListener<SysAccount>   mBindPhoneNumListener;

    // 支付
    private SysCallbackListener<SysInfo> mPayListener;
    private SysInfo                          orderInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.setContentView(R.layout.demo);
        //addShortcut();
        Context ctx = this.getApplicationContext();
        SysAppInfo appInfo = new SysAppInfo();
        appInfo.setAppId(10400);
        appInfo.setCtx(getApplicationContext());
        //初始化的时候 进行修改
        
        SysPlatform.getInstance().sysInit(appInfo);
        
        mListen = new MainOnClickListener();
        mVolpayButton = (Button) findViewById(R.id.volpay);
        mVolpayButton.setOnClickListener(mListen);
        mLoginButton = (Button) findViewById(R.id.login);
        mLoginButton.setOnClickListener(mListen);
        mOtherLoginButton = (Button) findViewById(R.id.modify_user);
        mOtherLoginButton.setOnClickListener(mListen);
        mBindGuestButton = (Button) findViewById(R.id.bindGuest);
        mBindGuestButton.setOnClickListener(mListen);
        mBindPhoneNumButton = (Button) findViewById(R.id.bindPhone);
        mBindPhoneNumButton.setOnClickListener(mListen);
        mGuestLoginButton = (Button) findViewById(R.id.guestlogin);
        mGuestLoginButton.setOnClickListener(mListen);
        mLogoutButton = (Button) findViewById(R.id.logout);
        mLogoutButton.setOnClickListener(mListen);

        initListener();
        
        //SysPlatform.getInstance(ctx).sysSetDebugMode();

        orderInfo = new SysInfo();
        orderInfo.setName("超级宝刀");
        orderInfo.setOrderno("011016371310124");
        orderInfo.setSmid("10002");
        orderInfo.setPrice("200");
        orderInfo.setExtraInfo("用户自定义数据！！！");
//        SysUtil.openAPN(this);
//        SysUtil.setWifiEnable(this, true);
        
    }

    private void initListener()
    {
        // 支付
        mPayListener = new SysCallbackListener<SysInfo>()
        {
            @Override
            public void callback(int statusCode, SysInfo data)
            {
                // TODO Auto-generated method stub
                if (SysStatusCode.Sys_PAY_STATUS_CODE_SUCCEED == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_succeed, Toast.LENGTH_SHORT)
                            .show();

                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_USER_CANCELED == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_user_canceled,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_NETWOKR_EXCEPTION == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_netwokr_exception,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_PAY_POINT_INVALID == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_point_invalid,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_PAY_POINT_PAUSED == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_point_paused,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_CHANNEL_INVALID == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_channel_invalid,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_CHANNEL_PAUSED == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_channel_paused,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_GOODS_INVALID == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_goods_invalid,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_GOODS_PAUSED == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_goods_paused,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_MERCHANT_ID_ERROR == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_merchant_id_error,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_NO_VALID_PAY_CHANNEL == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_no_valid_pay_channel,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_EMPTY_ORDER_NO == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_empty_order_no,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_EMPTY_ORDER_TIME == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_empty_order_time,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_WRONG_SIGN == statusCode)
                {

                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_wrong_sign, Toast.LENGTH_SHORT)
                            .show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_PRICE_ERROR == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_price_error,
                            Toast.LENGTH_SHORT).show();
                }
                else if (SysStatusCode.Sys_PAY_STATUS_CODE_OTHER_EXCEPTION == statusCode)
                {
                    Toast.makeText(getApplicationContext(),
                            R.string.sys_pay_other_exception,
                            Toast.LENGTH_SHORT).show();
                }

            }
        };
        
        mLoginListener = new SysCallbackListener<SysAccount>()
                {
                    @Override
                    public void callback(int statusCode, SysAccount accoutn)
                    {
                        switch (statusCode)
                        {
                        case SysStatusCode.Sys_SUCCESS:
                            // Toast.makeText(getApplicationContext(),
                            // R.string.sys_user_login_success,
                            // Toast.LENGTH_LONG).show();
                            break;

                        case SysStatusCode.Sys_ERROR_CANCEL:
                            // Toast.makeText(getApplicationContext(),
                            // R.string.sys_user_cancel, Toast.LENGTH_LONG)
                            // .show();
                            break;
                        }
                    }
                };

                mLoginGuestListener = new SysCallbackListener<SysAccount>()
                {
                    @Override
                    public void callback(int statusCode, SysAccount accoutn)
                    {
                        switch (statusCode)
                        {
                        case SysStatusCode.Sys_SUCCESS:
                            // Toast.makeText(getApplicationContext(),
                            // R.string.sys_user_login_success,
                            // Toast.LENGTH_LONG).show();
                            break;

                        case SysStatusCode.Sys_ERROR_CANCEL:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_cancel, Toast.LENGTH_LONG)
                                    .show();
                            break;
                        }
                    }
                };

                mLogoutListener = new SysCallbackListener<SysAccount>()
                {
                    @Override
                    public void callback(int statusCode, SysAccount accoutn)
                    {
                        switch (statusCode)
                        {
                        case SysStatusCode.Sys_SUCCESS:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_logout_success,
                                    Toast.LENGTH_LONG).show();
                            break;

                        case SysStatusCode.Sys_ERROR_CANCEL:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_cancel, Toast.LENGTH_LONG)
                                    .show();
                            break;
                        }
                    }
                };

                mBindGuestListener = new SysCallbackListener<SysAccount>()
                {
                    @Override
                    public void callback(int statusCode, SysAccount accoutn)
                    {
                        switch (statusCode)
                        {
                        case SysStatusCode.Sys_SUCCESS:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_bind_guest_success,
                                    Toast.LENGTH_LONG).show();
                            break;

                        case SysStatusCode.Sys_ERROR_CANCEL:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_cancel, Toast.LENGTH_LONG)
                                    .show();
                            break;

                        case SysStatusCode.Sys_ERROR_USER_IS_NOT_GUEST:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_is_not_guest,
                                    Toast.LENGTH_LONG).show();

                        case SysStatusCode.Sys_ERROR_USER_HAS_NO_GUEST:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_has_not_guest,
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                };
                mBindPhoneNumListener = new SysCallbackListener<SysAccount>()
                {
                    @Override
                    public void callback(int statusCode, SysAccount data)
                    {
                        switch (statusCode)
                        {
                        case SysStatusCode.Sys_SUCCESS:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_bind_phone_success,
                                    Toast.LENGTH_LONG).show();
                            break;

                        case SysStatusCode.Sys_ERROR_CANCEL:
                            Toast.makeText(getApplicationContext(),
                                    R.string.sys_user_cancel, Toast.LENGTH_LONG)
                                    .show();
                            break;
                        }
                    }
                };
    }

    class MainOnClickListener implements OnClickListener
    {

        @Override
        public void onClick(View v)
        {
        	
            switch (v.getId())
            {
                case R.id.login:
                    SysPlatform.getInstance().sysLogin(
                            getApplicationContext(), mLoginListener);
                    break;

                case R.id.modify_user:
                    // VgoPlatform.getInstance().vgoOtherLogin(getApplicationContext(),
                    // mListener);
                    // this feature will be put in user Center;
//                    SysUserCore.getInstance().sysModifyUser(
//                            getApplicationContext());
                    break;

                case R.id.bindGuest:
                    SysPlatform.getInstance().sysBindGuest(
                            getApplicationContext(), mBindGuestListener);
                    break;

                case R.id.bindPhone:
                    SysPlatform.getInstance().sysBindPhoneNumber(
                            getApplicationContext(), mBindPhoneNumListener);
                    break;

                case R.id.guestlogin:
                    SysPlatform.getInstance().sysLoginGuest(
                            getApplicationContext(), mLoginGuestListener);
                    break;

                case R.id.logout:
                    SysPlatform.getInstance().sysLogout(
                            getApplicationContext(), mLogoutListener);
                    break;
            // 支付测试
            case R.id.volpay:
                SysPlatform.getInstance().sysUniPay(
                        getApplicationContext(), orderInfo, mPayListener);
                break;
            }
            
            
        }
    }
    
}
