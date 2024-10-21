<script lang="ts" setup>
import { Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'
const activeName = ref('all')
const dialogFormVisible = ref(false)
//const value = ref('')
const router = useRouter()
const tableData = [
  {
    testplanID: '01',
    testplanName: '敏捷研发项目-测试计划1',
    testplanManager: 'zihang001',
    testplanState: '进行中',
    passRate: '0%',
    testedcaseNumber: '2/2',
    testPhase: '单元测试',
    testplanRelatedProject: '敏捷研发项目'
  }
]
const goToOneTestPlanModule = () => {
  router.push(`/test/testoneplan`)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}
const testPlanPermissionData = [
  {
    VEPermission: '团队负责人'
  },
  {
    VEPermission: '测试计划负责人'
  },
  {
    VEPermission: '测试管理-管理员'
  },
  {
    VEPermission: 'zihang001'
  }
]
</script>
<template>
  <el-card class="projectPage">
    <div class="header">
      <span><strong>测试计划全览</strong></span>
      <div class="extra">
        <el-button type="primary" @click="dialogFormVisible = true">新建测试计划</el-button>
      </div>
    </div>
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="全部测试计划" name="all">
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column prop="testplanID" label="测试计划ID" width="100" />
          <el-table-column prop="testplanName" label="测试计划名称" />
          <el-table-column prop="testplanManager" label="负责人" width="150" />
          <el-table-column prop="testplanState" label="状态" width="100" />
          <el-table-column prop="passRate" label="通过率" width="100" />
          <el-table-column prop="testedcaseNumber" label="已测用例" width="100" />
          <el-table-column prop="testPhase" label="测试阶段" width="150" />
          <el-table-column prop="testplanRelatedProject" label="关联项目" width="150" />
          <el-table-column label="操作/查看" width="100">
            <el-button type="primary" :icon="Edit" circle @click="goToOneTestPlanModule" />
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
    <el-dialog v-model="dialogFormVisible" title="新建测试计划" width="560">
      <el-scrollbar height="400px">
        <el-form>
          <el-form-item label="测试计划名称" style="display: block">
            <el-input
              style="width: 100%"
              placeholder="请填入测试计划名称，此处不能为空"
              show-word-limit
              type="text"
            />
          </el-form-item>
          <el-form-item label="测试计划负责人" style="display: block">
            <el-input
              style="width: 100%"
              placeholder="zihang001"
              show-word-limit
              type="text"
              disabled
            />
          </el-form-item>
          <el-form-item label="测试阶段" style="display: block">
            <el-select> </el-select>
          </el-form-item>
          <el-form-item label="关联项目" style="display: block">
            <el-select> </el-select>
          </el-form-item>
          <el-form-item label="权限" style="display: block">
            <el-table :data="testPlanPermissionData" stripe style="width: 100%">
              <el-table-column prop="VEPermission" label="查看和编辑权限" />
            </el-table>
          </el-form-item>
        </el-form> </el-scrollbar
      ><template #footer>
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
