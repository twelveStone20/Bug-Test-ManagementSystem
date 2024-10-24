<script lang="ts" setup>
import { Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'
const activeName = ref('all')
const router = useRouter()
const tableData = [
  {
    testRequireID: '01',
    testRequireName: '测试需求1',
    testRequireRelatedTestPlan: '敏捷开发项目-测试计划1',
    testRequireMaintainer: 'zihang001',
    testRequireManager: 'zihang001',
    testRequirePriority: '普通',
    testRequireDescription: '这是一条普通的测试需求',
    testRequireState: '未完成'
  }
]
const goToOneTestRequirement = () => {
  router.push(`/test/testonerequirement`)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}
</script>
<template>
  <el-card class="projectPage">
    <div class="header">
      <span><strong>测试需求</strong></span>
      <div class="extra">
        <el-button type="primary">新增测试需求</el-button>
      </div>
    </div>
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="全部测试需求" name="all">
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column prop="testRequireID" label="测试需求ID" width="100" />
          <el-table-column prop="testRequireName" label="测试需求名称" width="150" />
          <el-table-column prop="testRequireRelatedTestPlan" label="关联测试计划" width="150" />
          <el-table-column prop="testRequireMaintainer" label="维护人" width="100" />
          <el-table-column prop="testRequireManager" label="负责人" width="100" />
          <el-table-column prop="testRequirePriority" label="优先级" width="100" />
          <el-table-column prop="testRequireDescription" label="简要描述" />
          <el-table-column prop="testRequireState" label="状态" width="100" />
          <el-table-column label="操作/查看" width="100">
            <el-button type="primary" :icon="Edit" circle @click="goToOneTestRequirement" />
          </el-table-column>
        </el-table>
        <template #empty>
          <el-empty description="没有数据"></el-empty>
        </template>
      </el-tab-pane>
      <el-tab-pane label="未完成" name="notstart">
        没有数据
        <template #empty>
          <el-empty description="没有数据"></el-empty>
        </template>
      </el-tab-pane>
      <el-tab-pane label="已完成" name="finished">没有数据</el-tab-pane>
    </el-tabs>
  </el-card>
</template>

<style scoped>
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
