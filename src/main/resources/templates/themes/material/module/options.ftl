<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/plugins/toast/css/jquery.toast.min.css">
    <link rel="stylesheet" href="/static/plugins/colorpicker/css/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="/static/css/AdminLTE.min.css">
    <style>
        .themeSetting,.themeImg{
            padding-top: 15px;
            padding-bottom: 15px;
        }
        .form-horizontal .control-label{
            text-align: left;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-6 themeImg">
            <img src="/${themeDir}/screenshot.png" style="width: 100%;">
        </div>
        <div class="col-lg-6 themeSetting">
            <div class="nav-tabs-custom">
                <ul class="nav nav-tabs">
                    <li class="active">
                        <a href="#general" data-toggle="tab">基础设置</a>
                    </li>
                    <li>
                        <a href="#style" data-toggle="tab">样式设置</a>
                    </li>
                    <li>
                        <a href="#sns" data-toggle="tab">社交资料</a>
                    </li>
                    <li>
                        <a href="#sns-share" data-toggle="tab">分享设置</a>
                    </li>
                    <li>
                        <a href="#other" data-toggle="tab">其他设置</a>
                    </li>
                    <li>
                        <a href="#about" data-toggle="tab">关于</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <!-- 基础设置 -->
                    <div class="tab-pane active" id="general">
                        <form method="post" class="form-horizontal" id="materialGeneralOptions">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="materialScheme" class="col-sm-4 control-label">Scheme：</label>
                                    <div class="col-sm-8">
                                        <select class="form-control" id="materialScheme" name="theme_material_scheme">
                                            <option value="Paradox" ${((options.theme_material_scheme?default('Paradox'))=='Paradox')?string('selected','')}>Paradox</option>
                                            <option value="Isolation" ${((options.theme_material_scheme?default('Paradox'))=='Isolation')?string('selected','')}>Isolation</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialFavicon" class="col-sm-4 control-label">Favicon：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="materialFavicon" name="theme_material_favicon" value="${options.theme_material_favicon?if_exists}" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-flat" type="button" onclick="openAttach('materialFavicon')">选择</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialHighFavicon" class="col-sm-4 control-label">高清Favicon：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="materialHighFavicon" name="theme_material_high_res_favicon" value="${options.theme_material_high_res_favicon?if_exists}" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-flat" type="button" onclick="openAttach('materialHighFavicon')">选择</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialAppleFavicon" class="col-sm-4 control-label">IOS主屏按钮图标：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="materialAppleFavicon" name="theme_material_apple_touch_icon" value="${options.theme_material_apple_touch_icon?if_exists}" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-flat" type="button" onclick="openAttach('materialAppleFavicon')">选择</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialDialyPic" class="col-sm-4 control-label">daily_pic：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="materialDialyPic" name="theme_material_daily_pic" value="${options.theme_material_daily_pic?if_exists}" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-flat" type="button" onclick="openAttach('materialDialyPic')">选择</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSidebarHeader" class="col-sm-4 control-label">Sidebar顶部图片：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="materialSidebarHeader" name="theme_material_sidebar_header" value="${options.theme_material_sidebar_header?if_exists}" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-flat" type="button" onclick="openAttach('materialSidebarHeader')">选择</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialFooterImage" class="col-sm-4 control-label">Sidebar底部图片：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="materialFooterImage" name="theme_material_footer_image" value="${options.theme_material_footer_image?if_exists}" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-flat" type="button" onclick="openAttach('materialFooterImage')">选择</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialCopyrightSince" class="col-sm-4 control-label">站点成立时间：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialCopyrightSince" name="theme_material_copyright_since" value="${options.theme_material_copyright_since?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialGoogleSiteVerification" class="col-sm-4 control-label">谷歌Search Console验证：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialGoogleSiteVerification" name="theme_material_google_site_verification" value="${options.theme_material_google_site_verification?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialBaiduSiteVerification" class="col-sm-4 control-label">百度站长平台验证：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialBaiduSiteVerification" name="theme_material_baidu_site_verification" value="${options.theme_material_baidu_site_verification?if_exists}" >
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-primary btn-sm pull-right" onclick="saveThemeOptions('materialGeneralOptions')">保存设置</button>
                            </div>
                        </form>
                    </div>

                    <!-- 样式设置 -->
                    <div class="tab-pane" id="style">
                        <form method="post" class="form-horizontal" id="materialStyleOptions">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="materialUiuxSlogan" class="col-sm-4 control-label">Slogan：</label>
                                    <div class="col-sm-8">
                                        <textarea class="form-control" rows="3" id="materialUiuxSlogan" name="theme_material_uiux_slogan" style="resize: none">${options.theme_material_uiux_slogan?default("Hi, nice to meet you")}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialUiuxCardElevation" class="col-sm-4 control-label">卡片深度：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialUiuxCardElevation" name="theme_material_uiux_card_elevation" value="${options.theme_material_uiux_card_elevation?default("2")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialUiuxThemeColor" class="col-sm-4 control-label">主题颜色：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialUiuxThemeColor" name="theme_material_uiux_theme_color" value="${options.theme_material_uiux_theme_color?default("#0097A7")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialUiuxThemeSubColor" class="col-sm-4 control-label">辅助颜色：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialUiuxThemeSubColor" name="theme_material_uiux_theme_sub_color" value="${options.theme_material_uiux_theme_sub_color?default("#00838F")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialHyperLinkColor" class="col-sm-4 control-label">超链接颜色：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialHyperLinkColor" name="theme_material_uiux_hyperlink_color" value="${options.theme_material_uiux_hyperlink_color?default("#00838F")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialButtonColor" class="col-sm-4 control-label">按钮颜色：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialButtonColor" name="theme_material_uiux_button_color" value="${options.theme_material_uiux_button_color?default("#757575")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialGoogleColor" class="col-sm-4 control-label">安卓Chrome颜色：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialGoogleColor" name="theme_material_footer_uiux_android_chrome_color" value="${options.theme_material_footer_uiux_android_chrome_color?default("#0097A7")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialNprogressColor" class="col-sm-4 control-label">NProgress颜色：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialNprogressColor" name="theme_material_uiux_nprogress_color" value="${options.theme_material_uiux_nprogress_color?default("#29d")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialNProgressBuffer" class="col-sm-4 control-label">NProgressBuffer：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialNProgressBuffer" name="theme_material_uiux_nprogress_buffer" value="${options.theme_material_uiux_nprogress_buffer?default("800")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialBackgroundColor" class="col-sm-4 control-label">背景颜色：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialBackgroundColor" name="theme_material_background_purecolor" value="${options.theme_material_background_purecolor?default("#F5F5F5")}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialBackgroundImage" class="col-sm-4 control-label">背景图片：</label>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input type="text" class="form-control" id="materialBackgroundImage" name="theme_material_background_bgimg" value="${options.theme_material_background_bgimg?if_exists}" >
                                            <span class="input-group-btn">
                                                <button class="btn btn-default btn-flat" type="button" onclick="openAttach('materialBackgroundImage')">选择</button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialBackgroundBing" class="col-sm-4 control-label">Bing背景：</label>
                                    <div class="col-sm-8">
                                        <select class="form-control" id="materialBackgroundBing" name="theme_material_background_bing">
                                            <option value="false" ${((options.theme_material_background_bing?if_exists)=='false')?string('selected','')}>关闭</option>
                                            <option value="true" ${((options.theme_material_background_bing?if_exists)=='true')?string('selected','')}>开启</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-primary btn-sm pull-right" onclick="saveThemeOptions('materialStyleOptions')">保存设置</button>
                            </div>
                        </form>
                    </div>

                    <!-- 社交资料 -->
                    <div class="tab-pane" id="sns">
                        <form method="post" class="form-horizontal" id="materialSnsOptions">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="materialSnsEmail" class="col-sm-4 control-label">Email：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsEmail" name="theme_material_sns_email" value="${options.theme_material_sns_email?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsFaceBook" class="col-sm-4 control-label">Facebook：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsFaceBook" name="theme_material_sns_facebook" value="${options.theme_material_sns_facebook?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsTwitter" class="col-sm-4 control-label">Twitter：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsTwitter" name="theme_material_sns_twitter" value="${options.theme_material_sns_twitter?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsGoogleplus" class="col-sm-4 control-label">GooglePlus：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsGoogleplus" name="theme_material_sns_googleplus" value="${options.theme_material_sns_googleplus?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsWeibo" class="col-sm-4 control-label">Weibo：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsWeibo" name="theme_material_sns_weibo" value="${options.theme_material_sns_weibo?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsInstagram" class="col-sm-4 control-label">Instagram：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsInstagram" name="theme_material_sns_instagram" value="${options.theme_material_sns_instagram?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsTumblr" class="col-sm-4 control-label">Tumblr：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsTumblr" name="theme_material_sns_tumblr" value="${options.theme_material_sns_tumblr?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsGithub" class="col-sm-4 control-label">Github：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsGithub" name="theme_material_sns_github" value="${options.theme_material_sns_github?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsLinkedin" class="col-sm-4 control-label">Linkedin：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsLinkedin" name="theme_material_sns_linkedin" value="${options.theme_material_sns_linkedin?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsZhihu" class="col-sm-4 control-label">Zhihu：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsZhihu" name="theme_material_sns_zhihu" value="${options.theme_material_sns_zhihu?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsBiliBili" class="col-sm-4 control-label">BiliBili：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsBiliBili" name="theme_material_sns_bilibili" value="${options.theme_material_sns_bilibili?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsTelegram" class="col-sm-4 control-label">Telegram：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsTelegram" name="theme_material_sns_telegram" value="${options.theme_material_sns_telegram?if_exists}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsV2ex" class="col-sm-4 control-label">V2ex：</label>
                                    <div class="col-sm-8">
                                        <input type="text" class="form-control" id="materialSnsV2ex" name="theme_material_sns_v2ex" value="${options.theme_material_sns_v2ex?if_exists}" >
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-primary btn-sm pull-right" onclick="saveThemeOptions('materialSnsOptions')">保存设置</button>
                            </div>
                        </form>
                    </div>

                    <!-- 分享设置 -->
                    <div class="tab-pane" id="sns-share">
                        <form method="post" class="form-horizontal" id="materialSnsShareOptions">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="materialSnsShareTwitter" class="col-sm-4 control-label">分享到Twitter：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_twitter" id="materialSnsShareTwitter" value="true" ${((options.theme_material_sns_share_twitter?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_twitter" id="materialSnsShareTwitter" value="false" ${((options.theme_material_sns_share_twitter?if_exists)=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialSnsShareFaceBook" class="col-sm-4 control-label">分享到Facebook：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_facebook" id="materialSnsShareFaceBook" value="true" ${((options.theme_material_sns_share_facebook?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_facebook" id="materialSnsShareFaceBook" value="false" ${((options.theme_material_sns_share_facebook?if_exists)=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="materialSnsShareGoogleplus" class="col-sm-4 control-label">分享到GooglePlus：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_googleplus" id="materialSnsShareGoogleplus" value="true" ${((options.theme_material_sns_share_googleplus?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_googleplus" id="materialSnsShareGoogleplus" value="false" ${((options.theme_material_sns_share_googleplus?if_exists)=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="materialSnsShareWeibo" class="col-sm-4 control-label">分享到Weibo：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_weibo" id="materialSnsShareWeibo" value="true" ${((options.theme_material_sns_share_weibo?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_weibo" id="materialSnsShareWeibo" value="false" ${((options.theme_material_sns_share_weibo?if_exists)=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="materialSnsShareLinkedin" class="col-sm-4 control-label">分享到Linkedin：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_linkedin" id="materialSnsShareLinkedin" value="true" ${((options.theme_material_sns_share_linkedin?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_linkedin" id="materialSnsShareLinkedin" value="false" ${((options.theme_material_sns_share_linkedin?if_exists)=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="materialSnsShareqq" class="col-sm-4 control-label">分享到QQ：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_qq" id="materialSnsShareqq" value="true" ${((options.theme_material_sns_share_qq?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_qq" id="materialSnsShareqq" value="false" ${((options.theme_material_sns_share_qq?if_exists)=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="materialSnsShareelegram" class="col-sm-4 control-label">分享到Telegram：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_telegram" id="materialSnsShareTelegram" value="true" ${((options.theme_material_sns_share_telegram?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_sns_share_telegram" id="materialSnsShareTelegram" value="false" ${((options.theme_material_sns_share_telegram?if_exists)=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-primary btn-sm pull-right" onclick="saveThemeOptions('materialSnsShareOptions')">保存设置</button>
                            </div>
                        </form>
                    </div>

                    <!-- 其他设置 -->
                    <div class="tab-pane" id="other">
                        <form method="post" class="form-horizontal" id="materialOtherOptions">
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="materialOtherJsFade" class="col-sm-4 control-label">渐显效果：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_js_fade" id="materialOtherJsFade" value="true" ${((options.theme_material_other_js_fade?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_js_fade" id="materialOtherJsFade" value="false" ${((options.theme_material_other_js_fade?default('true'))=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialOtherJsSmoothScroll" class="col-sm-4 control-label">平滑滚动效果：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_js_smoothscroll" id="materialOtherJsSmoothScroll" value="true" ${((options.theme_material_other_js_smoothscroll?default('true'))=='true')?string('checked','')}> 开启
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_js_smoothscroll" id="materialOtherJsSmoothScroll" value="false" ${((options.theme_material_other_js_smoothscroll?default('true'))=='false')?string('checked','')}> 关闭
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialOtherSidebarArchives" class="col-sm-4 control-label">侧边栏归档：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_sidebar_archives" id="materialOtherSidebarArchives" value="true" ${((options.theme_material_other_sidebar_archives?default('true'))=='true')?string('checked','')}> 显示
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_sidebar_archives" id="materialOtherSidebarArchives" value="false" ${((options.theme_material_other_sidebar_archives?default('true'))=='false')?string('checked','')}> 隐藏
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialOtherSidebarCates" class="col-sm-4 control-label">侧边栏分类：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_sidebar_cates" id="materialOtherSidebarCates" value="true" ${((options.theme_material_other_sidebar_cates?default('true'))=='true')?string('checked','')}> 显示
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_sidebar_cates" id="materialOtherSidebarCates" value="false" ${((options.theme_material_other_sidebar_cates?default('true'))=='false')?string('checked','')}> 隐藏
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialOtherSidebarPostCount" class="col-sm-4 control-label">侧边栏文章总数：</label>
                                    <div class="col-sm-8">
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_sidebar_postcount" id="materialOtherSidebarPostCount" value="true" ${((options.theme_material_other_sidebar_postcount?default('true'))=='true')?string('checked','')}> 显示
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="theme_material_other_sidebar_postcount" id="materialOtherSidebarPostCount" value="false" ${((options.theme_material_other_sidebar_postcount?default('true'))=='false')?string('checked','')}> 隐藏
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="materialOtherPostLicense" class="col-sm-4 control-label">文章License：</label>
                                    <div class="col-sm-8">
                                        <textarea class="form-control" rows="3" id="materialOtherPostLicense" name="theme_material_other_post_license" style="resize: none">${options.theme_material_other_post_license?if_exists}</textarea>
                                    </div>
                                </div>
                            </div>
                            <div class="box-footer">
                                <button type="button" class="btn btn-primary btn-sm pull-right" onclick="saveThemeOptions('materialOtherOptions')">保存设置</button>
                            </div>
                        </form>
                    </div>

                    <!-- 关于该主题 -->
                    <div class="tab-pane" id="about">
                        <div class="box box-widget widget-user-2">
                            <div class="widget-user-header bg-blue">
                                <div class="widget-user-image">
                                    <img class="img-circle" src="https://cdn.viosey.com/img/avatar/blog_avatar.png" alt="User Avatar">
                                </div>
                                <h3 class="widget-user-username">Viosey</h3>
                                <h5 class="widget-user-desc">深自缄默，如云漂泊</h5>
                            </div>
                            <div class="box-footer no-padding">
                                <ul class="nav nav-stacked">
                                    <li><a target="_blank" href="https://viosey.com">作者主页</a></li>
                                    <li><a target="_blank" href="https://github.com/viosey/hexo-theme-material">原主题地址</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="/static/plugins/jquery/jquery.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/plugins/toast/js/jquery.toast.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/plugins/colorpicker/js/bootstrap-colorpicker.min.js"></script>
<script src="/static/js/app.js"></script>
<script>
    $(document).ready(function () {
        $('#materialUiuxThemeColor').colorpicker();
        $('#materialUiuxThemeSubColor').colorpicker();
        $('#materialHyperLinkColor').colorpicker();
        $('#materialButtonColor').colorpicker();
        $('#materialGoogleColor').colorpicker();
        $('#materialNprogressColor').colorpicker();
        $('#materialBackgroundColor').colorpicker();
    });
    function saveThemeOptions(option) {
        var param = $('#'+option).serialize();
        $.ajax({
            type: 'post',
            url: '/admin/option/save',
            data: param,
            success: function (data) {
                showMsg("保存成功！","success",1000);
            }
        });
    }
    function openAttach(id) {
        layer.open({
            type: 2,
            title: '所有附件',
            shadeClose: true,
            shade: 0.5,
            area: ['90%', '90%'],
            content: '/admin/attachments/select?id='+id,
            scrollbar: false
        });
    }
</script>
</html>