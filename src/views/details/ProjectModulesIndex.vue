<script setup>
import { ref } from 'vue'
import { ArrowRight } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
const activeName = ref('all')
const tableData = [
  {
    moduleID: '01',
    moduleName: '敏捷研发项目-主模块',
    moduleBugNumber: '0',
    moduleManager: 'zihang001'
  }
]
const router = useRouter()
const goToOneProjectModule = () => {
  router.push(`/project/oneproject/modules/onemodule`)
}
</script>
<template>
  <el-card class="projectModulesIndexPage">
    <div class="header">
      <el-breadcrumb :separator-icon="ArrowRight">
        <el-breadcrumb-item :to="{ path: '/project/overview' }">项目全览</el-breadcrumb-item>
        <el-breadcrumb-item :to="{ path: '/project/oneproject' }"
          ><strong>敏捷研发项目</strong></el-breadcrumb-item
        >
        <el-breadcrumb-item><strong>模块全览</strong></el-breadcrumb-item>
      </el-breadcrumb>
      <div class="extra">
        <el-button type="primary">新建模块</el-button>
      </div>
    </div>
    <div class="projectModulesIndexContent">
      <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
        <el-tab-pane label="全部模块" name="all">
          <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="moduleID" label="模块ID" width="100" />
            <el-table-column prop="moduleName" label="模块名称" />
            <el-table-column prop="moduleBugNumber" label="模块下Bug数" width="200" />
            <el-table-column prop="moduleManager" label="模块负责人" width="200" />
            <el-table-column label="操作/查看" width="100">
              <el-button type="primary" :icon="Edit" circle @click="goToOneProjectModule" />
            </el-table-column>
          </el-table>
          <template #empty>
            <el-empty description="没有数据"></el-empty>
          </template>
        </el-tab-pane>
        <el-tab-pane label="我负责的" name="my">
          没有数据
          <template #empty>
            <el-empty description="没有数据"></el-empty>
          </template>
        </el-tab-pane>
      </el-tabs>
    </div>
  </el-card>
</template>
<style>
.projectModulesIndexPage {
  min-height: 100%;
  box-sizing: border-box;
  .header {
    display: flex;
    padding: 5px;
    justify-content: space-between;
    align-items: center;
  }
  .projectModulesIndexContent {
    padding-left: 10px;
    padding-top: 10px;
  }
}
</style>
