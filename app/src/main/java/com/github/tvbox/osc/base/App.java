包裹包 com.github.tvbox.osc.base；

import android.app.Activity;
import androidx.multidex.MultiDexApplication;

import com.github.tvbox.osc.bean.VodInfo;
import com.github.tvbox.osc.callback.EmptyCallback;
import com.github.tvbox.osc.callback.LoadingCallback;
import com.github.tvbox.osc.data.AppDataManager;
import com.github.tvbox.osc.server.ControlManager;
import com.github.tvbox.osc.util.AppManager;
import com.github.tvbox.osc.util.EpgUtil;
import com.github.tvbox.osc.util.FileUtils;
import com.github.tvbox.osc.util.HawkConfig;
import com.github.tvbox.osc.util.OkGoHelper;
导入com.github.tvbox.osc.util.PlayerHelper;
导入com.github.tvbox.osc.util.js.JSEngine;
导入com.kingja.loadsir.core.LoadSir;
导入com.orhanobut.hawk.Hawk;

导入me.jessyan.autosize.AutoSizeConfig;
导入me.jessyan.autosize.unit.Subunits;

/**
*@作者pj567
* @日期：2020/12/17
* @描述：
*/
公共类 App 扩展 MultiDexApplication {class App extends MultiDexApplication {
    私有静态App实例；private static App instance;

    @覆盖
    公共无效 onCreate() {public void onCreate() {
        极好的。onCreate ( ) ; 极好的。onCreate ( ) ;
        实例=这个；这个；
        初始化参数( ) ; 初始化参数( ) ;
        // 好，出发// OKGo
        好的帮手。在里面（） ; //台标获取init(); //台标获取
        EpgUtil。在里面（） ; 在里面（） ;
        // 初始化Web服务器 // 初始化Web服务器
        控制管理器。初始化（这个）；初始化（这个）；
        //初始化数据库//初始化数据库
        应用程序数据管理器。在里面（） ; 在里面（） ;
        加载先生。开始构建器( )开始构建器( )
                。addCallback （新的EmptyCallback （））addCallback （新的EmptyCallback （））
                .addCallback （新的LoadingCallbackLoadingCallback())addCallback(new())
                。犯罪（）;commit();
        AutoSizeConfig.getInstance().setCustomFragment(true).getUnitsManager()getInstance().setCustomFragment(true).getUnitsManager()
                .setSupportDP(假)setSupportDP(false)
                .setSupportSP(假)setSupportSP(false)
                .setSupportSubunits(Subunits.MM);setSupportSubunits(Subunits.MM);
        PlayerHelper.init();init();
        JSEngine.getInstance().create();getInstance().create();
        FileUtils.cleanPlayerCache();cleanPlayerCache();
    }}

    private void initParams() {
        // Hawk
        Hawk.init(this).build();
        Hawk.put(HawkConfig.DEBUG_OPEN, false);
        if (!Hawk.contains(HawkConfig.PLAY_TYPE)) {
            Hawk.put(HawkConfig.PLAY_TYPE, 1);
        }
        
    }

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        JSEngine.getInstance().destroy();
    }
//自定义默认配置，硬解，安全dns，缩略图

       if (!Hawk.contains(HawkConfig.IJK_CODEC)) {            Hawk.put(HawkConfig.IJK_CODEC, "硬解码");        } 

       if (!Hawk.contains(HawkConfig.DOH_URL)) {            Hawk.put(HawkConfig.DOH_URL, 2);        }

       if (!Hawk.contains(HawkConfig.SEARCH_VIEW)) {            Hawk.put(HawkConfig.SEARCH_VIEW, 2);        }

    private VodInfo vodInfo;
    public void setVodInfo(VodInfo vodinfo){
        this.vodInfo = vodinfo;
    }
    public VodInfo getVodInfo(){
        return this.vodInfo;
    }

    public Activity getCurrentActivity() {
        return AppManager.getInstance().currentActivity();
    }
}
