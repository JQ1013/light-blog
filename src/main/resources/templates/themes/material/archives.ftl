<#include "module/macro.ftl">
<@layout title="归档 | ${options.blog_title?default('Material')}" keywords="${options.seo_keywords?default('Material')}" description="${options.seo_desc?default('Material')}">
    <!-- Index Module -->
    <div class="material-index mdl-grid">
        <#if options.theme_material_scheme?if_exists == "Paradox" && posts.number==0 && !isArchives??>
        <!-- Paradox Header -->
        <#include "_partial/daily_pic.ftl">
        <#include "_partial/blog_info.ftl">
        </#if>
        <div class="locate-thumbnail-symbol"></div>
        <!-- Pin on top -->

        <!-- Normal Post -->
        <#if options.theme_material_scheme?if_exists == "Paradox">
        <!-- Paradox Thumbnail -->
        <#include "_partial/Paradox-post_entry.ftl">
        <#else>
        <!-- Isolation Thumbnail -->
        <#include "_partial/Isolation-post_entry.ftl">
        </#if>
        <#include "_partial/index-nav.ftl">
        <@nav url="/archives/"></@nav>
        <#if options.theme_material_scheme?if_exists == "Paradox">
            <#include "_partial/Paradox-post_entry-thumbnail.ftl">
        </#if>
    </div>
</@layout>