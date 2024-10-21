<script lang="ts" setup>
import { Edit } from '@element-plus/icons-vue'
import { ArrowRight } from '@element-plus/icons-vue'
import { ref } from 'vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'
const activeName = ref('all')
const router = useRouter()
const tableData = [
  {
    testModuleID: '01',
    testModuleName: '敏捷研发项目-主模块-测试计划1-测试模块1',
    testModuleExecutor: 'zihang001',
    testModuleState: '进行中',
    testModulepassRate: '0%',
    testModuleTestedCaseNumber: '2/2',
    testModuleRelatedProjectModule: '敏捷研发项目-主模块'
  }
]
const goToOneTestPlan = () => {
  router.push(`/test/testplanonemodule`)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}
</script>

<template>
  <el-card class="testOnePlanPage">
    <div class="header">
      <el-breadcrumb :separator-icon="ArrowRight">
        <el-breadcrumb-item :to="{ path: '/test/testplan' }">测试计划全览</el-breadcrumb-item>
        <el-breadcrumb-item><strong>敏捷研发项目-测试计划1</strong></el-breadcrumb-item>
      </el-breadcrumb>
      <div class="extra">
        <el-button type="primary">查看测试需求</el-button>
        <el-button type="primary">新建测试模块</el-button>
      </div>
    </div>
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="全部测试模块" name="all">
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column prop="testModuleID" label="测试模块ID" width="100" />
          <el-table-column prop="testModuleName" label="测试模块名称" />
          <el-table-column prop="testModuleExecutor" label="执行人" width="150" />
          <el-table-column prop="testModuleState" label="状态" width="100" />
          <el-table-column prop="testModulepassRate" label="通过率" width="100" />
          <el-table-column prop="testModuleTestedCaseNumber" label="已测用例" width="100" />
          <el-table-column prop="testModuleRelatedProjectModule" label="关联项目模块" width="200" />
          <el-table-column label="操作/查看" width="100">
            <el-button type="primary" :icon="Edit" circle @click="goToOneTestPlan" />
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
.testOnePlanPage {
  min-height: 100%;
  box-sizing: border-box;
  .header {
    display: flex;
    padding: 5px;
    justify-content: space-between;
    align-items: center;
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
