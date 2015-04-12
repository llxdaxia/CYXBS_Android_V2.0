# CYXBS_V2.0
	掌上重邮(重邮小帮手Android客户端)2.0

##Set-up

###Requirements
- buildToolsVersion:22.0.1
- compileSdkVersion:22

###Dependencies
- [appcompat-v7](https://developer.android.com/tools/support-library/features.html#v7-appcompat) / [recyclerview-v7](https://developer.android.com/tools/support-library/features.html#v7-recyclerview) / [cardview-v7](https://developer.android.com/tools/support-library/features.html#v7-cardview)／[palette-v7](https://developer.android.com/reference/android/support/v7/graphics/Palette.html)
- [Retrofit](https://github.com/square/retrofit) / [OkHttp](https://github.com/square/okhttp)
- [fresco](http://frescolib.org/)
- [ActiveAndroid](http://www.activeandroid.com/)
- [fastJson](https://github.com/alibaba/fastjson/wiki)
- [EventBus](https://github.com/greenrobot/EventBus)
- [Dagger](https://github.com/google/dagger)
- [ButterKnife](http://jakewharton.github.io/butterknife/)
- [Robolectric](https://github.com/robolectric/robolectric)
- [Square AssertJ](https://github.com/square/assertj-android)

##Project Tree
    app/
        config/         全局配置文件
        di/             依赖注入包
        model/          model层
            bean/       java bean类
            impl/       model接口的实现
            ...         model接口
        presenter/      presenter层
            activity/
            adapter/
            fragment/
        util/           工具包
        view/           view层
            impl/       view接口的实现
            widget/     自定义view
            ...         view接口


##Naming Conventions
    包名小写

    JAVA部分
        采用驼峰法
        Activity类：Activity为后缀、Fragment类：Fragment为后缀、Adapter类：Adapter为后缀...
        抽象类Abs开头
        接口I开头

    资源文件
        小写加下划线分割
        contentview命名：activity_功能模块.xml，fragment_功能模块.xml

        例如：activity_main.xml、activity_more.xml、fragment_main.xml
        组件命名：组件简写\_模块\_描述.xml

            Button：btn\_模块\_描述.xml
            例如：btn\_main\_login.xml

            Dialog：dialog\_模块\_描述.xml
            例如：dialog\_main\_hint.xml

            PopupWindow命名：pw\_模块\_描述.xml
            例如：pw\_main\_info.xml

        adapter的子布局：item\_功能模块\_描述.xml
        例如：item_main_goods_list.xml

        包含项：include_描述.xml（include文件可能多模块复用，所以不加模块）
        例如：include_head.xml、include_bottom.xml

        延迟加载部分：viewstub_描述.xml
        例如：viewstub_empty.xml

        合并：merge_描述.xml


