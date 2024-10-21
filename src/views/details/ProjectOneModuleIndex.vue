<script setup>
import { ArrowRight } from '@element-plus/icons-vue'
</script>
<template>
  <el-card class="projectOneModuleIndexPage">
    <div class="header">
      <el-breadcrumb :separator-icon="ArrowRight">
        <el-breadcrumb-item :to="{ path: '/project/overview' }">项目全览</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/project/oneproject' }"
          ><strong>敏捷研发项目</strong></el-breadcrumb-item
        >
        <el-breadcrumb-item :to="{ path: '/project/oneproject/modules' }"
          ><strong>模块全览</strong></el-breadcrumb-item
        >
        <el-breadcrumb-item><strong>敏捷研发项目-主模块</strong></el-breadcrumb-item>
      </el-breadcrumb>
      <div class="extra">
        <el-button type="primary">查看测试需求</el-button>
        <el-button type="primary">编辑模块信息</el-button>
      </div>
    </div>
    <div class="projectOneModuleIndexContent">
      <el-form label-width="auto">
        <el-form-item label="模块ID：">
          <el-input style="width: 200px" placeholder="Bug每日新增图" show-word-limit type="text" />
        </el-form-item>
        <el-form-item label="模块负责人：">
          <el-input
            style="width: 200px"
            placeholder="请填入模块负责人"
            show-word-limit
            type="text"
          />
        </el-form-item>
        <el-form-item label="待处理的Bug数：">
          <el-input style="width: 50px" />
        </el-form-item>
      </el-form>
      <el-table class="projectBugTable">
        <el-table-column prop="projectID" label="BugID" width="200" />
        <el-table-column prop="projectName" label="Bug名称" width="300" />
        <el-table-column prop="projectName" label="Bug描述" width="500" />
      </el-table>
    </div>
  </el-card>
</template>
<style>
.projectOneModuleIndexPage {
  min-height: 100%;
  box-sizing: border-box;
  .header {
    display: flex;
    padding: 5px;
    justify-content: space-between;
    align-items: center;
  }
  .projectOneModuleIndexContent {
    padding-top: 10px;
  }
}
.demo-tabs {
  padding: 0 10px;
  margin-top: 10px;
}
.demo-tabs > .el-tabs__content {
  padding: 0px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>
