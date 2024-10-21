<script setup>
import { ArrowRight } from '@element-plus/icons-vue'
</script>
<template>
  <el-card class="projectPage">
    <div class="header">
      <el-breadcrumb :separator-icon="ArrowRight">
        <el-breadcrumb-item :to="{ path: '/test/testrequire' }">测试需求</el-breadcrumb-item>
        <el-breadcrumb-item><strong>测试需求1</strong></el-breadcrumb-item>
      </el-breadcrumb>
      <div class="extra">
        <el-button type="primary">查看测试需求</el-button>
        <el-button type="primary">新建测试模块</el-button>
      </div>
    </div>
  </el-card>
</template>

<style>
.projectPage {
  min-height: 100%;
  box-sizing: border-box;
}
.header {
  display: flex;
  padding: 5px;
  justify-content: space-between;
  align-items: center;
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
