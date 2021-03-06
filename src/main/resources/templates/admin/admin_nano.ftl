<#include "module/_macro.ftl">
<@head title="关于Nano"></@head>
<div class="wrapper">
    <!-- 顶部栏模块 -->
    <#include "module/_header.ftl">
    <!-- 菜单栏模块 -->
    <#include "module/_sidebar.ftl">
    <div class="content-wrapper">
        <style type='text/css'>
            blockquote {
                border-left: 4px solid #dddddd;
                padding: 0 15px;
                color: #777777;
                font-size: 16px;
            }
        </style>
        <section class="content-header">
            <h1 style="display: inline-block;">关于Nano</h1>
            <ol class="breadcrumb">
                <li>
                    <a data-pjax="true" href="/admin"><i class="fa fa-dashboard"></i> 首页</a>
                </li>
                <li class="active">关于Nano</li>
            </ol>
        </section>
        <section class="content container-fluid">
            <div id='write' class='is-mac'>
                <blockquote>
                    <p>一款使用Java开发的简约，&quot;轻&quot;，快的博客系统。</p>
                    <p>非常感谢你使用Nano进行创作。</p>
                </blockquote>
                <p>目前该博客系统为beta测试版，有可能会出现一些莫名奇妙的bug，所以希望各位在使用过程中及时向我反馈：</p>
                <p>Github issues ：<a href='https://github.com/jqlmh/nano'
                                     target="_blank">https://github.com/jqlmh/nano</a>
                </p>
                <p>Blog : <a href="https://jqlmh.com" target="_blank">https://jqlmh.com</a></p>
                <p>Email : <a href='mailto:459296228@qq.com'>459296228@qq.com</a></p>
                <p>QQ : 459296228</p>
            </div>
        </section>
    </div>
    <#include "module/_footer.ftl">
</div>
<@footer></@footer>