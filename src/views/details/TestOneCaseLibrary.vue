<script lang="ts" setup>
import { Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'
import { ArrowRight } from '@element-plus/icons-vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'
const activeName = ref('all')
const router = useRouter()
const tableData = [
  {
    testcaseID: '01',
    testcaseName: '测试用例1',
    testcaseMaintainer: 'zihang001',
    testcaseType: '功能测试',
    testcasePriority: 'P0',
    testcaseExecutor: 'zihang001',
    testcaseState: '进行中',
    testcaseExecutionResult: '失败',
    testcaseLastExecuteTime: '2024-09-29'
  }
]
const goToOneTestCase = () => {
  router.push(`/test/testcase`)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}
</script>
<template>
  <el-card class="projectPage">
    <div class="header">
      <el-breadcrumb :separator-icon="ArrowRight">
        <el-breadcrumb-item :to="{ path: '/test/testcaselibrary' }">用例库</el-breadcrumb-item>
        <el-breadcrumb-item><strong>用例库1</strong></el-breadcrumb-item>
      </el-breadcrumb>
      <div class="extra">
        <el-button type="primary">新建测试用例</el-button>
      </div>
    </div>
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="全部测试用例" name="all">
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column prop="testcaseID" label="测试用例ID" width="100" />
          <el-table-column prop="testcaseName" label="测试用例名称" />
          <el-table-column prop="testcaseMaintainer" label="维护人" width="100" />
          <el-table-column prop="testcasePriority" label="优先级" width="100" />
          <el-table-column prop="testcaseType" label="测试类型" width="100" />
          <el-table-column prop="testcaseExecutor" label="执行人" width="100" />
          <el-table-column prop="testcaseState" label="状态" width="100" />
          <el-table-column prop="testcaseExecutionResult" label="执行结果" width="100" />
          <el-table-column prop="testcaseLastExecuteTime" label="最后执行时间" width="150" />
          <el-table-column label="操作/查看" width="100">
            <el-button type="primary" :icon="Edit" circle @click="goToOneTestCase" />
          </el-table-column>
        </el-table>
        <template #empty>
          <el-empty description="没有数据"></el-empty>
        </template>
      </el-tab-pane>
      <el-tab-pane label="未开始" name="notstart">
        没有数据
        <template #empty>
          <el-empty description="没有数据"></el-empty>
        </template>
      </el-tab-pane>
      <el-tab-pane label="进行中" name="goingon">没有数据</el-tab-pane>
      <el-tab-pane label="已完成" name="finished">没有数据</el-tab-pane>
    </el-tabs>
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
