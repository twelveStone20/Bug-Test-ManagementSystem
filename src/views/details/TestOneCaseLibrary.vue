<script setup>
import { Edit } from '@element-plus/icons-vue'
import { ref } from 'vue'
import { ArrowRight } from '@element-plus/icons-vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'
import { useTeamStore } from '@/stores/modules/team'
import { useUserStore } from '@/stores'
import { useUsecaseLibStore } from '@/stores/modules/usercaselib'
const activeName = ref('all')
const router = useRouter()

const userStore = useUserStore()
userStore.getUser()

const teamStore = useTeamStore()
teamStore.getTeam(userStore.user.userId)
//获取用例库数据

const usecaseLibStore = useUsecaseLibStore()
usecaseLibStore.getUsecaseLib()

const tableData = ref([
  {
    testcaseID: 1,
    testcaseName: '用例1'
  }
])
const goToOneTestCase = () => {
  router.push(`/test/testcase`)
}
const handleClick = (tab, event) => {
  console.log(tab, event)
}

//新建用例
const addUsecaseFormVisible = ref(false)
</script>
<template>
  <div class="card-container">
    <el-card class="projectPage">
      <div class="header">
        <el-breadcrumb :separator-icon="ArrowRight">
          <el-breadcrumb-item :to="{ path: '/test/testcaselibrary' }">用例库</el-breadcrumb-item>
          <el-breadcrumb-item
            ><strong>{{
              usecaseLibStore.usecaseLib.usecaseLibraryName
            }}</strong></el-breadcrumb-item
          >
        </el-breadcrumb>
        <div class="extra">
          <el-button type="primary" @click="addUsecaseFormVisible = true">新建用例</el-button>
        </div>
      </div>
      <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
        <el-tab-pane label="全部用例" name="all">
          <el-table :data="tableData" stripe style="width: 100%">
            <el-table-column prop="testcaseID" label="用例ID" width="100" />
            <el-table-column prop="testcaseName" label="用例名称" />
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
      <div class="footer">
        <span
          ><strong>所属团队：{{ teamStore.team.teamName }}</strong></span
        >
      </div>
      <!-- 新建用例 -->
      <el-dialog v-model="addUsecaseFormVisible" title="新建用例" width="800">
        <el-form inline="true" label-width="auto">
          <el-form-item label="用例名称：">
            <el-input
              style="width: 350px"
              placeholder="请填入用例名称，此处不能为空"
              show-word-limit
              type="text"
            ></el-input>
          </el-form-item>
          <br />
          <el-form-item label="维护人：">
            <el-input style="width: 120px" type="text"></el-input>
          </el-form-item>
          <el-form-item label="优先级：">
            <el-input style="width: 120px" type="text"></el-input>
          </el-form-item>
          <br />
          <el-form-item label="所属用例库：">
            <el-input style="width: 120px" type="text"></el-input>
          </el-form-item>
          <el-form-item label="用例类型：">
            <el-input style="width: 120px" type="text"></el-input>
          </el-form-item>
          <el-form-item label="前置条件：">
            <el-input
              style="width: 350px"
              placeholder="请填入前置条件"
              show-word-limit
              type="textarea"
            ></el-input>
          </el-form-item>
          <el-form-item label="操作步骤：">
            <el-input
              style="width: 350px"
              placeholder="请填入操作步骤"
              show-word-limit
              type="textarea"
            ></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
          <div class="dialog-footer" style="display: flex; justify-content: right">
            <div>
              <el-button @click="addProjectFormVisible = false"> 取消 </el-button>
              <el-button type="primary" @click="addProject"> 创建 </el-button>
            </div>
          </div>
        </template>
      </el-dialog>
    </el-card>
  </div>
</template>

<style scoped>
.projectPage {
  min-height: 100%;
  box-sizing: border-box;
}
.card-container {
  height: 100%;
  position: relative;
  .header {
    display: flex;
    padding: 5px;
    justify-content: space-between;
    align-items: center;
  }
  .footer {
    position: absolute;
    bottom: 10px;
    text-align: left;
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
