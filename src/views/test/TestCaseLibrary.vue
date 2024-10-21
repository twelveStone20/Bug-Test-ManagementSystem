<script lang="ts" setup>
import { Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'
const activeName = ref('all')
const router = useRouter()
const dialogFormVisible = ref(false)
const tableData = [
  {
    testcaseLibraryID: '01',
    testcaseLibraryName: '用例库1',
    testcaseNumber: '2'
  },
  {
    testcaseLibraryID: '02',
    testcaseLibraryName: '用例库2',
    testcaseNumber: '0'
  }
]
const goToOneTestCaseLibrary = () => {
  router.push(`/test/testonecaselibrary`)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}
</script>
<template>
  <el-card class="projectPage">
    <div class="header">
      <span><strong>用例库</strong></span>
      <div class="extra">
        <el-button type="primary" @click="dialogFormVisible = true">新增用例库</el-button>
      </div>
    </div>
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="全部用例库" name="all">
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column prop="testcaseLibraryID" label="用例库ID" width="100" />
          <el-table-column prop="testcaseLibraryName" label="用例库名称" width="120" />
          <el-table-column prop="testcaseNumber" label="测试用例数量" />
          <el-table-column label="操作/查看" width="100">
            <el-button type="primary" :icon="Edit" circle @click="goToOneTestCaseLibrary" />
          </el-table-column>
        </el-table>
        <template #empty>
          <el-empty description="没有数据"></el-empty>
        </template>
      </el-tab-pane>
    </el-tabs>
    <el-dialog v-model="dialogFormVisible" title="新建用例库" width="560">
      <el-form>
        <el-form-item label="用例库名称" style="display: block">
          <el-input
            style="width: 100%"
            placeholder="请填入用例库名称，此处不能为空"
            show-word-limit
            type="text"
          />
        </el-form-item>
        <el-form-item label="用例库描述" style="display: block">
          <el-input style="width: 100%" placeholder="请填入用例库描述" type="textarea" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <div>
            <el-button @click="dialogFormVisible = false"> 取消 </el-button>
            <el-button type="primary" @click="dialogFormVisible = false"> 创建 </el-button>
          </div>
        </div>
      </template>
    </el-dialog>
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
