<script setup>
import { addProjectService, deleteProjectService, getAllProjectService } from '@/api/project'
import { useUserStore } from '@/stores'
import { Edit, Delete } from '@element-plus/icons-vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { ref } from 'vue'
//import { TabsPaneContext } from 'element-plus'
import { useRouter } from 'vue-router'

const router = useRouter() //路由
const userStore = useUserStore() //用户信息
userStore.getUser()
const user = userStore.user
console.log(user)
const activetab = ref('all') //激活标签页
let tableData = ref([]) //表格数据
const goToOneProject = () => {
  router.push(`/project/oneproject`)
}

const handleClick = (tab, event) => {
  console.log(tab, event)
}
//已有项目
const getProjectList = async (managerId) => {
  const res = await getAllProjectService(managerId)
  tableData.value = res.data.data
}
getProjectList(userStore.user.userId)

const statusValue = ref('0')
//删除项目
const deleteProject = async (projectId) => {
  await ElMessageBox.confirm('你确定要删除该项目吗', '提示', {
    type: 'warning',
    confirmButtonText: '确认',
    cancelButtonText: '取消'
  })
  await deleteProjectService(projectId)
  ElMessage.success('删除成功')
}

//新建项目
const addProjectFormVisible = ref(false)
const addProjectFormRef = ref()
const addProjectFormModel = ref({
  projectName: '',
  managerId: userStore.user.userId,
  managerName: userStore.user.username,
  priority: 1
})
const addProject = async () => {
  await addProjectFormRef.value.validate()
  await addProjectService(addProjectFormModel.value)
  ElMessage.success('创建成功')
  addProjectFormVisible.value = false
}
</script>
<template>
  <el-card class="projectPage">
    <div class="header">
      <span><strong>项目全览</strong></span>
      <div class="extra">
        <el-button type="primary" @click="addProjectFormVisible = true">新建项目</el-button>
      </div>
    </div>
    <!-- 项目全览 -->
    <el-tabs v-model="activetab" class="demo-tabs" @tab-click="handleClick">
      <el-tab-pane label="全部项目" name="all">
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column type="index" label="序号" width="70" />
          <el-table-column v-if="false" prop="projectId" label="项目ID" width="100" />
          <el-table-column prop="projectName" label="项目名称" width="180" />
          <el-table-column prop="managerName" label="项目负责人" width="150" />
          <el-table-column prop="priority" label="项目优先级" width="100" />
          <el-table-column prop="projectStatus" label="项目状态" width="250">
            <el-select v-model="statusValue" style="width: 200px" disabled>
              <el-option label="未开始" value="0" />
              <el-option label="进行中" value="1" />
              <el-option label="已完成" value="2" />
            </el-select>
          </el-table-column>
          <el-table-column prop="updateTime" label="最近更新时间" />
          <el-table-column label="编辑/删除" width="150">
            <template #default="scope">
              <el-button type="primary" :icon="Edit" circle @click="goToOneProject" />
              <el-button
                type="primary"
                :icon="Delete"
                circle
                @click="deleteProject(scope.row.projectId)"
              ></el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="未开始" name="notstart">
        <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column prop="projectID" label="项目ID" width="100" />
          <el-table-column prop="projectName" label="项目名称" width="180" />
          <el-table-column prop="projectStatus" label="项目状态" width="250">
            <el-select v-model="projectStatus" width="150">
              <el-option label="未开始" value="option1" />
              <el-option label="进行中" value="option2" />
              <el-option label="已完成" value="option3" />
            </el-select>
          </el-table-column>
          <el-table-column prop="projectManager" label="项目负责人" />
          <el-table-column label="操作/查看" width="100">
            <el-button type="primary" :icon="Edit" circle @click="goToOneProject" />
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="进行中" name="goingon">No Data</el-tab-pane>
      <el-tab-pane label="已完成" name="finish">No Data</el-tab-pane>
    </el-tabs>
    <!-- 新建项目 -->
    <el-dialog v-model="addProjectFormVisible" title="新建项目" width="800">
      <el-form :model="addProjectFormModel" ref="addProjectFormRef">
        <el-form-item label="项目名称" prop="projectName">
          <el-input
            v-model="addProjectFormModel.projectName"
            style="width: 240px"
            placeholder="请填入项目名称，此处不能为空"
            show-word-limit
            type="text"
          />
        </el-form-item>
        <el-form-item label="项目负责人" prop="">
          <el-input
            v-model="userStore.user.username"
            style="width: 240px"
            show-word-limit
            type="text"
            disabled
          />
        </el-form-item>
        <el-form-item label="优先级">
          <el-select v-model="addProjectFormModel.priority">
            <el-option value="1"></el-option>
            <el-option value="2"></el-option>
            <el-option value="3"></el-option>
          </el-select>
        </el-form-item>
      </el-form>

      <template #footer>
        <div class="dialog-footer" style="display: flex; justify-content: space-between">
          <div>
            <el-link type="primary">邀请用户加入项目</el-link>
          </div>
          <div>
            <el-button @click="addProjectFormVisible = false"> 取消 </el-button>
            <el-button type="primary" @click="addProject"> 创建 </el-button>
          </div>
        </div>
      </template>
    </el-dialog>
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
.selectMember {
  margin-top: 2%;
}
</style>
